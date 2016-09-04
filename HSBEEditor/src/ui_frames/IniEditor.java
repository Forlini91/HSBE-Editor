package ui_frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import core.Bar;
import core.FileIni;
import core.FileSettings;
import ui_elements.GridBagConstraintsExtended;


/**
 * The IniEditor window. Display all bars and the tools to create, delete and manipulate them.
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class IniEditor extends AbstractFrame {
	
	/** String used for the About section */
	public static final String S_ABOUT = "HSBE - Ini editor\nCreated by Forli\nAll rights reserved\nCreative Common License: BY-NC-SA";
	/** The software icon */
	public static final ImageIcon IMAGE_ICON = new ImageIcon(IniEditor.class.getResource("Icon.png"));
	/** The program logo */
	public static final ImageIcon IMAGE_LOGO = new ImageIcon(IniEditor.class.getResource("Logo.png"));
	
	/** The window for global access */
	public static IniEditor window = null;
	/** Setting: Min group size */
	public static int minGroup = 3;
	/** Setting: Max group size */
	public static int maxGroup = 999;
	/** Settings: Number of spaces for a tab */
	public static int tabSize = 24;
	/** Default UI editor used: true for UI editor, false for code editor */
	public static boolean defaultUIEditor = true;
	/** Display the editor panel on the left side */
	public static boolean UIeditorLeft = true;

	private File file = null;
	/** The selected bars */
	public Set<Bar> selected = new HashSet<>();
	/** All bars */
	public Set<Bar> bars = new HashSet<>();
	/** The last clicked bar */
	public Bar lastClicked = null;
	/** If true, we're in the moving state */
	public boolean moving = false;
	
	private JPanel panel;
	private JLabel labelHeader;
	private GridBagLayout gbl_panel;

	/**
	 * Launch the application.
	 * @param args 	Unused
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				window = new IniEditor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void onCloseEvent(WindowEvent e){
		FileSettings.save();
		System.out.println("Exit");
	}
	

	/**
	 * Create and show the a new IniEditor window
	 */
	public IniEditor(){
		setTitle("HSBE - Ini Editor");
		setIconImage(IMAGE_ICON.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(getBounds(this, 0.8, 0.8));
		setMinimumSize(new Dimension(480, 270));
		FileSettings.load();
		
		JPanel panelExt = new JPanel();
		GridBagLayout gbl_panelExt = new GridBagLayout();
		gbl_panelExt.columnWidths = new int[]{0};
		gbl_panelExt.rowHeights = new int[]{0};
		gbl_panelExt.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelExt.rowWeights = new double[]{Double.MIN_VALUE};
		panelExt.setLayout(gbl_panelExt);
		setContentPane(panelExt);
		
		panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
		panel.setBounds(0, 0, getWidth(), getHeight());
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelExt.add(scrollPane, gbc_scrollPane);

		
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 120, 320};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{0, 0.25, 0.75};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		labelHeader = new JLabel("<no file selected>");
		labelHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		labelHeader.setHorizontalAlignment(SwingConstants.CENTER);

		setJMenuBar(buildMenuBar());
		setVisible(true);
	}
	
	
	
	/**
	 * Ask the user what to do with an already existing file
	 * @param file	The file which already exists
	 */
	public void handlefileExists(File file){
		String[] buttons = { "Overwrite", "Create backup", "Cancel" };
		int answ = JOptionPane.showOptionDialog(this, "The file already exists. Do you want to ovewrite it? I will keep a backup with extension \"*.ini.backup\".", "Overwrite", 0, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
		if (answ >= 2) {
			return;
		} else if (answ == 0) {
			try {
				Files.deleteIfExists(file.toPath());
			} catch (IOException e1) {
				JOptionPane.showConfirmDialog(this, "An error occurred while deleting the old ini", "Overwrite error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		} else {
			String filePath = file.getAbsolutePath();
			filePath = filePath.substring(0, filePath.length()-3) + "backup";
			
			File backup = new File(filePath + "0.ini");
			if (backup.exists()){
				Stack<File> toRename = new Stack<>();
				int i = 1;
				do {
					toRename.push(backup);
					backup = new File(filePath + i + ".ini");
					i++;
				} while(backup.exists());
				try {
					do {
						Files.move(toRename.peek().toPath(), backup.toPath());
						backup = toRename.pop();
					} while(!toRename.isEmpty());
				} catch (IOException e) {
					JOptionPane.showConfirmDialog(this, "An error occurred while creating the backup of the old ini(s).", "Backup error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			try {
				Files.move(file.toPath(), backup.toPath());
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(this, "An error occurred while creating the backup of the old ini(s).", "Backup error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	}
	
	

	
	
	/**
	 * Load a new ini or reload the current ini
	 * @param reload	if true reload the current ini, else load a new ini
	 */
	public void loadIni(boolean reload){
		try{
			FileIni lf = new FileIni(reload ? file : null, "Open/Create", false);
			bars = lf.load();
			file = lf.getFile();
		} catch (IllegalStateException e){
			bars = new TreeSet<>();
			file = null;
		} catch (IOException e){
			JOptionPane.showMessageDialog(this, "An error occurred while loading the ini", "Load error", JOptionPane.ERROR_MESSAGE, IMAGE_ICON);
			return;
		}
		labelHeader.setText((file != null ? "<html><center>" + file.getParentFile().getPath() + "<br>" + file.getName() + "</center>" : "<no file>"));
		updatePanels();
	}
	
	
	/**
	 * Save the current ini
	 * @param saveAs	if true, save with a new name
	 */
	public void saveIni(boolean saveAs){
		FileIni sv;
		try {
			sv = new FileIni(saveAs ? null : file, "Save", true);
		} catch (IllegalStateException e){
			return;
		}
		File file = sv.getFile();
		if (file != null && file.exists()){
			handlefileExists(file);
		}
		try {
			sv.save(new TreeSet<>(bars));
			labelHeader.setText((file != null ? "<html><center>" + file.getParentFile().getPath() + "<br>" + file.getName() + "</center>" : "<no file>"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "An error occurred while saving the ini", "Save error", JOptionPane.ERROR_MESSAGE, IMAGE_ICON);
		}
	}
	
	
	/**
	 * Import bars from another file
	 */
	public void importBars(){
		try{
			FileIni lf = new FileIni((File) null, "Import", false);
			Set<Bar> impBarSet = lf.load();
			ImportBars dialog = new ImportBars(this, impBarSet);
			List<Bar> impBarList = dialog.get();
			if (impBarList == null){
				throw new IllegalStateException();
			}
			int i = bars.size();
			for (Bar bar : impBarList){
				bar.setI(i++);
				bars.add(bar);
				System.out.println("IMPORT BAR: " + bar + " - " + bar.hashCode());
			}
			updatePanels();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "An error occurred while importing the bars", "Import error", JOptionPane.ERROR_MESSAGE, IMAGE_ICON);
		} catch (IllegalStateException e){
			if (e == FileIni.fne){
				JOptionPane.showMessageDialog(this, "The file doesn't exists!", "Import error", JOptionPane.ERROR_MESSAGE, IMAGE_ICON);
			}
		}
	}

	/**
	 * Export the selected bars to a new file
	 */
	public void exportBars(){
		try{
			FileIni sv = new FileIni((File) null, "Export", true);
			File file = sv.getFile();
			if (file.exists()){
				handlefileExists(file);
			}
			try {
				sv.save(new TreeSet<>(selected));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "An error occurred while exporting the bars", "Export error", JOptionPane.ERROR_MESSAGE, IMAGE_ICON);
			}
		} catch (IllegalStateException e){
			//Nothing to do
		}
	}

	/**
	 * Update all bar panels
	 */
	public void updatePanels(){
		panel.removeAll();
		
		SortedSet<Bar> barSet = new TreeSet<>(bars);
		int i = 0;
		for (Bar bar : barSet){
			BarPanel bp = new BarPanel(bar);
			panel.add(bp.label0, new GridBagConstraintsExtended(i));
			panel.add(bp.label1, new GridBagConstraintsExtended(i, 0));
			panel.add(bp.label2, new GridBagConstraintsExtended(i, 1));
			panel.add(bp.label3, new GridBagConstraintsExtended(i, 2));
			bar.setPanel(bp);
			i++;
		}
		gbl_panel.rowHeights = new int[i+1];
		gbl_panel.rowWeights = new double[i+1];
		Arrays.fill(gbl_panel.rowHeights, 0);
		Arrays.fill(gbl_panel.rowWeights, 0.0);
		gbl_panel.rowWeights[i] = Double.MIN_VALUE;
		//panel.setPreferredSize(new Dimension(maxWidth-30, 30*bars.size()+15));
		panel.updateUI();
	}

	/**
	 * Update all bars indexes
	 * @param bars	The bars to update
	 */
	public static void updateIndex(Set<Bar> bars){
		List<Bar> barList = new ArrayList<>(bars);
		Collections.sort(barList);
		int i = 0;
		for (Bar bar : barList){
			bar.setI(i++);
		}
	}



	
	/**
	 * Create a new empty Bar
	 * @return	The new Bar
	 */
	public Bar newBar(){
		int i = bars.size();
		Bar bar = new Bar("<empty bar>", "", i);
		bar.nameIsSet(true);
		bars.add(bar);
		System.out.println("NEW BAR: " + bar + " - " + bar.hashCode());
		return bar;
	}

	/**
	 * Clone the given bar
	 * @param copyFrom	The bar to clone
	 * @return			The new bar
	 */
	public Bar newBar(Bar copyFrom){
		int i = bars.size();
		Bar bar = new Bar(copyFrom, i);
		bars.add(bar);
		System.out.println("NEW BAR: " + bar + " - " + bar.hashCode());
		return bar;
	}

	/**
	 * Create a new bar from raw .ini code
	 * @param code	The .ini code
	 * @return		The new bar
	 */
	public Bar newBar(String code){
		int i = bars.size();
		Bar bar = new Bar(code, i);
		if (bar.numFields() > 0){
			bars.add(bar);
			System.out.println("NEW BAR: " + bar + " - " + bar.hashCode());
			return bar;
		}
		JOptionPane.showMessageDialog(this, "The bar code is empty or not valid!", "Error", JOptionPane.ERROR_MESSAGE);
		return null;
	}

	/**
	 * Open the bar editor for the given bar
	 * @param bar	The bar to edit
	 * @return		The opened window
	 */
	public static AbstractFrame editBarEditor(Bar bar){
		return editBarEditor(bar, 0, 0);
	}

	/**
	 * Open the bar editor
	 * @param bar	The bar to edit
	 * @param i		The nth bar
	 * @param n		The total number of bars
	 * @return		The opened window
	 */
	public static AbstractFrame editBarEditor(Bar bar, int i, int n){
		if (defaultUIEditor){
			return new BarEditor(bar, i, n);
		}
		return new BarCode(bar, i, n);
	}

	/**
	 * Open the bar editor for all selected bars
	 */
	public void editBarsEditor(){
		int i = 0, n = selected.size();
		for (Bar bar : selected){
			editBarEditor(bar, i, n);
		}
	}

	/**
	 * Open the bar editor for all selected bars
	 */
	@SuppressWarnings ("unused")
	public void editBarsCode(){
		int i = 0, n = selected.size();
		for (Bar bar : selected){
			new BarCode(bar, i, n);
		}
	}
	
	/**
	 * Add a new bar before the selected ones
	 */
	public void addBefore(){
		Bar newBar;
		for(Bar bar : selected){
			newBar = newBar();
			moveBars(false, bar, newBar);
		}
		if (selected.size() == 1){
			selected.iterator().next().setSelected(false);
		}
	}

	/**
	 * Add a new bar after the selected ones
	 */
	public void addAfter(){
		Bar newBar;
		for(Bar bar : selected){
			newBar = newBar();
			moveBars(true, bar, newBar);
		}
		if (selected.size() == 1){
			selected.iterator().next().setSelected(false);
		}
	}

	/**
	 * Duplicate the selected bars
	 */
	public void duplicateBars(){
		new TreeSet<>(selected).forEach(bar -> {
			Bar dupl = newBar(bar);
			moveBars(true, bar, dupl);
			System.out.println("ORIGINAL: " + bar + " - " + bar.hashCode() + "   >   DUPLICATE: " + dupl + " - " + dupl.hashCode());
		});
		if (selected.size() == 1){
			selected.iterator().next().setSelected(false);
		}
	}

	/**
	 * Delete the selected bars
	 */
	public void deleteBars(){
		if (selected.size() > 1){
			new DeleteBars(this, selected, () -> {
				if (JOptionPane.showConfirmDialog(this, "Do you want to delete these " + selected.size() + " bars?", "Confirm delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					new TreeSet<>(selected).forEach(bar -> {
						System.out.println("DELETE: " + bar + " - " + bar.hashCode());
						bars.remove(bar);
					});
				}
			}).setVisible(true);
		} else if (selected.size() == 1){
			Bar bar = selected.iterator().next();
			if (JOptionPane.showConfirmDialog(this, "Do you want to delete \"" + bar + "\"?", "Confirm delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
				bars.remove(bar);
			}
		}
		selected.clear();
		updateIndex(bars);
	}
	
	/**
	 * Move the selected bars
	 * @param stopBefore	StopBefore flag
	 * @param destBar		The destination bar
	 * @param toMove		The bars to move
	 */
	public void moveBars(boolean stopBefore, Bar destBar, Bar...toMove){
		moveBars(stopBefore, destBar, Arrays.asList(toMove));
	}
	
	/**
	 * Move the selected bars
	 * @param stopBefore	StopBefore flag
	 * @param destBar			The destination bar
	 * @param toMove		The bars to move
	 */
	public void moveBars(boolean stopBefore, Bar destBar, Collection<Bar> toMove){
		bars.removeAll(toMove);
		List<Bar> newList = new ArrayList<>();
		List<Bar> oldList = new ArrayList<>(bars);
		List<Bar> toMoveList = new ArrayList<>(toMove);
		oldList.sort(null);
		toMoveList.sort(null);

		final Bar from = toMoveList.get(0);
		final int n = toMoveList.size();
		final int to = destBar.getI();
		final boolean before = (from.getI() > to && !stopBefore);
		final int pos = oldList.indexOf(destBar) + (before ? 0 : 1);
		int max = oldList.size();

		System.out.println("MOVE BARS: n/m = " + n + '/' + max + "   | from bar = " + from + "   | to bar/pos = " + to + '/' + pos + "   | before = " + before);
		for (int i = 0; i < pos; i++){
			newList.add(oldList.get(i));
			//System.out.println("1 - Put: " + oldList.get(i));
		}
		//System.out.println("2 - Put moved ones");
		newList.addAll(toMoveList);
		for (int i = pos; i < max; i++){
			newList.add(oldList.get(i));
			//System.out.println("3 - Put: " + oldList.get(i));
		}
		
		max = newList.size();
		System.out.println("MOVE BARS - Final: Max = " + max);
		for (int i = 0; i < max; i++){
			newList.get(i).setI(i);
			//System.out.println("NEW POS: " + newList.get(i));
		}
		bars = new HashSet<>(newList);
	}

	
	
	/**
	 * Select all bars
	 */
	public void selectAll(){
		System.out.println("Select all");
		Set<Bar> setBar = new HashSet<>(bars);
		setBar.removeAll(selected);
		setBar.forEach(bar -> bar.getPanel().setSelected(true));
	}

	/**
	 * Deselect all bars
	 */
	public void deselectAll(){
		System.out.println("Deselect all");
		new HashSet<>(selected).forEach(bar -> bar.getPanel().setSelected(false));
	}

	/**
	 * Reverse the selection for all bars
	 */
	public void reverseAll(){
		System.out.println("Reverse all");
		new HashSet<>(bars).forEach(bar -> bar.getPanel().reverseSelection());
	}

	/**
	 * Select/Deselect a range of bars
	 * @param fromBar	Select from this bar
	 * @param toBar		Select to this bar
	 * @param select	If true, select the bars, else deselect them
	 */
	public void selectRange(Bar fromBar, Bar toBar, boolean select){
		selectRange(fromBar.getI(), toBar.getI(), select);
	}

	/**
	 * Select/Deselect a range of bars
	 * @param from		Select from this bar
	 * @param to		Select to this bar
	 * @param select	If true, select the bars, else deselect them
	 */
	public void selectRange(int from, int to, boolean select){
		if (from < to){
			new TreeSet<>(bars).forEach(bar -> {
				if (bar.getI() >= from && bar.getI() <= to) {
					bar.getPanel().setSelected(select);
				}
			});
		} else {
			new TreeSet<>(bars).forEach(bar -> {
				if (bar.getI() >= to && bar.getI() <= from) {
					bar.getPanel().setSelected(select);
				}
			});
		}
	}




	/**
	 * Build a new JMenuBar
	 * @return	The new JMenuBar
	 */
	public JMenuBar buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnIni = new JMenu("File");
		JMenu mnBar = new JMenu("Bars");
		JMenu mnSettings = new JMenu("Settings");
		JMenu mnInfo = new JMenu("?");
		menuBar.add(mnIni);
		menuBar.add(mnBar);
		menuBar.add(mnSettings);
		menuBar.add(mnInfo);
		
		JMenuItem mntmLoadIni = new JMenuItem("Load ini");
		JMenuItem mntmSaveIni = new JMenuItem("Save ini");
		JMenuItem mntmSaveIniAs = new JMenuItem("Save ini as...");
		JMenuItem mntmReloadIni = new JMenuItem("Reload ini");
		mntmLoadIni.addActionListener(e -> loadIni(false));
		mntmSaveIni.addActionListener(e -> saveIni(false));
		mntmSaveIniAs.addActionListener(e -> saveIni(true));
		mntmReloadIni.addActionListener(e -> loadIni(true));
		mnIni.add(mntmLoadIni);
		mnIni.add(mntmSaveIni);
		mnIni.add(mntmSaveIniAs);
		mnIni.add(mntmReloadIni);

		JMenuItem mntmNewBarEmpty = new JMenuItem("New bar (empty)");
		JMenuItem mntmNewBarCode = new JMenuItem("New bar from code");
		//JMenuItem mntmEnable = new JMenuItem("Enable bar(s)");
		//JMenuItem mntmDisable = new JMenuItem("Disable bar(s)");
		JMenuItem mntmImport = new JMenuItem("Import bar(s)");
		JMenuItem mntmSelectAll = new JMenuItem("Select all");
		JMenuItem mntmDeselectAll = new JMenuItem("Deselect all");
		JMenuItem mntmReverse = new JMenuItem("Reverse selection");
		mntmNewBarEmpty.addActionListener(e -> {
			newBar();
			updatePanels();
		});
		mntmNewBarCode.addActionListener(e -> {
			NewBarCode dialog;
			String s = null;
			do {
				dialog = new NewBarCode(this, s);
				s = dialog.get();
			} while (s != null && newBar(s) == null);
			updatePanels();
		});
		mntmImport.addActionListener(e -> {
			importBars();
			updatePanels();
		});
		mntmSelectAll.addActionListener(e -> selectAll());
		mntmDeselectAll.addActionListener(e -> deselectAll());
		mntmReverse.addActionListener(e -> reverseAll());
		mnBar.add(mntmNewBarEmpty);
		mnBar.add(mntmNewBarCode);
		mnBar.add(mntmImport);
		mnBar.add(mntmSelectAll);
		mnBar.add(mntmDeselectAll);
		mnBar.add(mntmReverse);
		
		//SETTINGS
		JMenu mnsDefaultEditor = new JMenu("Default editor");
		JRadioButtonMenuItem radEditorUI = new JRadioButtonMenuItem("UI editor");
		JRadioButtonMenuItem radEditorCode = new JRadioButtonMenuItem("Code editor");
		if (defaultUIEditor){
			radEditorUI.setSelected(true);
		} else {
			radEditorCode.setSelected(true);
		}
		radEditorUI.addChangeListener((e) -> {
			if (radEditorUI.isSelected()){
				radEditorCode.setSelected(false);
				defaultUIEditor = true;
			}
		});
		radEditorCode.addChangeListener((e) -> {
			if (radEditorCode.isSelected()){
				radEditorUI.setSelected(false);
				defaultUIEditor = false;
			}
		});
		mnsDefaultEditor.add(radEditorUI);
		mnsDefaultEditor.add(radEditorCode);
		mnSettings.add(mnsDefaultEditor);
		
		JMenu mnsUIEditorPos = new JMenu("UI editor panel position");
		JRadioButtonMenuItem radEditorL = new JRadioButtonMenuItem("Left");
		JRadioButtonMenuItem radEditorR = new JRadioButtonMenuItem("Right");
		if (UIeditorLeft){
			radEditorL.setSelected(true);
		} else {
			radEditorR.setSelected(true);
		}
		radEditorL.addChangeListener((e) -> {
			if (radEditorL.isSelected()){
				radEditorR.setSelected(false);
				UIeditorLeft = true;
			}
		});
		radEditorR.addChangeListener((e) -> {
			if (radEditorR.isSelected()){
				radEditorL.setSelected(false);
				UIeditorLeft = false;
			}
		});
		mnsUIEditorPos.add(radEditorL);
		mnsUIEditorPos.add(radEditorR);
		mnSettings.add(mnsUIEditorPos);

		JMenu mnsMinGroup = new JMenu("Min group size");
		JLabel minGroupLabel = new JLabel(" ");
		JSlider minGroupSlider = new JSlider();
		JLabel maxGroupLabel = new JLabel(" ");
		JSlider maxGroupSlider = new JSlider();
		mnsMinGroup.setToolTipText("When the editor create the file, it groups the fields by category for better readability. If a group is smaller than this value, it get merged with the following one.");
		minGroupLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minGroupLabel.setPreferredSize(new Dimension(100, minGroupLabel.getPreferredSize().height));
		minGroupSlider.setMinimum(1);
		minGroupSlider.setMaximum(16);
		minGroupSlider.setValue(1);
		minGroupSlider.setSnapToTicks(true);
		minGroupSlider.setMinorTickSpacing(1);
		minGroupSlider.setMajorTickSpacing(2);
		minGroupSlider.addChangeListener(e -> {
			if (minGroupSlider.getValue() < 16){
				minGroup = minGroupSlider.getValue();
				minGroupLabel.setText("" + minGroup);
				maxGroupSlider.setMinimum(minGroup);
			} else {
				minGroup = 999;
				minGroupLabel.setText("No");
				maxGroupSlider.setMinimum(31);
			}
		});
		minGroupSlider.setValue(minGroup < 999 ? minGroup : 16);
		mnsMinGroup.add(minGroupLabel);
		mnsMinGroup.add(minGroupSlider);
		mnSettings.add(mnsMinGroup);

		JMenu mnsMaxGroup = new JMenu("Max group size");
		mnsMaxGroup.setToolTipText("When the editor create the file, it groups the fields by category for better readability. If a group is larger than this value, it gets truncated.");
		maxGroupLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxGroupLabel.setPreferredSize(new Dimension(100, maxGroupLabel.getPreferredSize().height));
		maxGroupSlider.setMinimum(minGroupSlider.getValue());
		maxGroupSlider.setMaximum(31);
		maxGroupSlider.setValue(maxGroupSlider.getMinimum());
		maxGroupSlider.setSnapToTicks(true);
		maxGroupSlider.setMinorTickSpacing(1);
		maxGroupSlider.setMajorTickSpacing(2);
		maxGroupSlider.addChangeListener(e -> {
			if (maxGroupSlider.getValue() < 31){
				maxGroup = maxGroupSlider.getValue();
				maxGroupLabel.setText("" + maxGroup);
			} else {
				maxGroup = 999;
				maxGroupLabel.setText("No");
			}
		});
		maxGroupSlider.setValue(maxGroup < 999 ? maxGroup : 31);
		mnsMaxGroup.add(maxGroupLabel);
		mnsMaxGroup.add(maxGroupSlider);
		mnSettings.add(mnsMaxGroup);

		JMenu mnsTabSize = new JMenu("Tabs size");
		JLabel tabSizeLabel = new JLabel(" ");
		JSlider tabSizeSlider = new JSlider();
		mnsTabSize.setToolTipText("When the editor create the file, it put tabulations for better readability. With this setting you can specify how many spaces fits in a tab in your editor (Notepad, Notepad++, etc)");
		tabSizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tabSizeLabel.setPreferredSize(new Dimension(100, tabSizeLabel.getPreferredSize().height));
		tabSizeSlider.setMinimum(1);
		tabSizeSlider.setMaximum(50);
		tabSizeSlider.setValue(1);
		tabSizeSlider.setSnapToTicks(true);
		tabSizeSlider.setMinorTickSpacing(1);
		tabSizeSlider.setMajorTickSpacing(2);
		tabSizeSlider.addChangeListener(e -> {
			tabSize = tabSizeSlider.getValue();
			tabSizeLabel.setText("" + tabSize);
		});
		tabSizeSlider.setValue(tabSize);
		mnsTabSize.add(tabSizeLabel);
		mnsTabSize.add(tabSizeSlider);
		mnSettings.add(mnsTabSize);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmManual.addActionListener(e -> JOptionPane.showMessageDialog(this, "Oh, did you expect some kind of... manual?\nHSB/HSBE already have manuals!\n\n...don't look at me! You're the one who should read them!", "About", JOptionPane.QUESTION_MESSAGE));
		mntmAbout.addActionListener(e -> JOptionPane.showMessageDialog(this, S_ABOUT, "About", JOptionPane.INFORMATION_MESSAGE, IMAGE_LOGO));
		mnInfo.add(mntmManual);
		mnInfo.add(mntmAbout);
		
		return menuBar;
	}


	




	/**
	 * A bar panel associated to each bar
	 * @author MarcoForlini
	 */
	public class BarPanel extends AbstractBarPanel {
		
		/**
		 * Create a new {@link BarPanel}
		 * @param bar	The associated bar
		 */
		public BarPanel(Bar bar){
			super(bar);
		}
		
		@Override
		public void setSelected(boolean isSelected){
			if (isSelected){
				selected.add(bar);
				setBorder(bevelSelectedBorder);
			} else {
				selected.remove(bar);
				setBorder(null);
			}
			bar.setSelected(isSelected);
		}



		@Override
		public void setReadyForMove(){
			moving = true;
			selected.forEach(bar -> bar.getPanel().setBorder(bevelMoveBorder));
		}

		@Override
		public void mouseReleasedEvent (MouseEvent e){
			if (e.getButton() == MouseEvent.BUTTON1){
				if (moving) {
					if (!bar.isSelected()){
						//System.out.println("Move destination: " + bar);
						moveBars(false, bar, selected);
						updatePanels();
					} else {
						//System.out.println("Move cancelled");
						if (selected.size() > 1){
							new TreeSet<>(selected).forEach(bar -> {
								bar.getPanel().setBorder(bevelSelectedBorder);
							});
						} else {
							bar.setSelected(false);
						}
					}
				} else if (e.isShiftDown()) {
					System.out.println("SHIFT down: " + bar);
					if (selected.size() == 0){
						reverseSelection();
					} else {
						boolean select = lastClicked.isSelected();
						if (!e.isControlDown()){
							deselectAll();
						}
						selectRange(lastClicked, bar, select);
						moving = false;
						return;
					}
				} else if (e.isControlDown()){
					System.out.println("CTRL down: " + bar);
					reverseSelection();
				} else if (selected.size() > 0){
					System.out.println("Click and deselect: " + bar);
					new TreeSet<>(selected).forEach(bar -> {
						bar.getPanel().setSelected(false);
					});
				} else if (e.getClickCount() == 2) {
					System.out.println("Double click: " + bar);
					editBarEditor(bar);
				}
			} else if (!moving){
				System.out.println("Right click: " + bar);
				if (selected.size() > 0 && !selected.contains(bar)){
					new TreeSet<>(selected).forEach(bar -> {
						bar.getPanel().setSelected(false);
					});
				}
				setSelected(true);
				popupMenu.setLocation(e.getLocationOnScreen());
				popupMenu.setVisible(true);
			}
			moving = false;
			lastClicked = bar;
			
			if (selected.size() <= 0){
				//System.out.println("Mouse up (border off): " + bar);
				setBorder(null);
				//} else {
				//System.out.println("Mouse up (border on): " + bar);
			}
		}


		
		@Override
		protected JPopupMenu buildPopupMenu(){
			JPopupMenu popupMenu = new JPopupMenu();
			popupMenu.setInvoker(IniEditor.this);
			popupMenu.setBounds(0, 0, 200, 50);
			popupMenu.addPopupMenuListener(new PopupMenuListener() {

				@Override
				public void popupMenuWillBecomeVisible (PopupMenuEvent e) {/*Do nothing*/}

				@Override
				public void popupMenuWillBecomeInvisible (PopupMenuEvent e) {
					if (!moving && (selected.size() <= 1 || !selected.contains(bar))) {
						setBorder(null);
					}
				}

				@Override
				public void popupMenuCanceled (PopupMenuEvent e) {
					if (!moving && (selected.size() <= 1 || !selected.contains(bar))) {
						setBorder(null);
					}
				}
			});

			JMenuItem mntmEdit = new JMenuItem("Edit: UI editor");
			JMenuItem mntmCode = new JMenuItem("Edit: Code editor");
			JMenuItem mntmAddBefore = new JMenuItem("Add bar before this");
			JMenuItem mntmAddAfter = new JMenuItem("Add bar after this");
			JMenuItem mntmMove = new JMenuItem("Move");
			JMenuItem mntmDuplicate = new JMenuItem("Duplicate");
			JMenuItem mntmDelete = new JMenuItem("Delete");
			JMenuItem mntmEnable = new JMenuItem("Enable");
			JMenuItem mntmDisable = new JMenuItem("Disable");
			JMenuItem mntmExport = new JMenuItem("Export to file");
			//Separator

			mntmEdit.addActionListener((x) -> editBarsEditor());
			mntmCode.addActionListener((x) -> editBarsCode());
			mntmMove.addActionListener((x) -> setReadyForMove());
			mntmDuplicate.addActionListener((x) -> {
				duplicateBars();
				updatePanels();
			});
			mntmDelete.addActionListener((x) -> {
				deleteBars();
				updatePanels();
			});
			mntmEnable.addActionListener((x) -> {
				selected.forEach(bar -> bar.getPanel().setEnabled(true));
			});
			mntmDisable.addActionListener((x) -> {
				selected.forEach(bar -> bar.getPanel().setEnabled(false));
			});
			mntmExport.addActionListener((x) -> exportBars());
			//SEPARATOR
			mntmAddBefore.addActionListener((x) -> {
				addBefore();
				updatePanels();
			});
			mntmAddAfter.addActionListener((x) -> {
				addAfter();
				updatePanels();
			});

			popupMenu.add(mntmEdit);
			popupMenu.add(mntmCode);
			popupMenu.add(new JSeparator());
			popupMenu.add(mntmAddBefore);
			popupMenu.add(mntmAddAfter);
			popupMenu.add(mntmMove);
			popupMenu.add(mntmDuplicate);
			popupMenu.add(mntmDelete);
			popupMenu.add(new JSeparator());
			//popupMenu.add(mntmEnable);
			//popupMenu.add(mntmDisable);
			popupMenu.add(mntmExport);

			return popupMenu;
		}
	}
}
