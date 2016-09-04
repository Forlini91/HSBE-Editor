package ui_frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import core.Bar;
import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;


/**
 * Dialog to allow the player to select the bars to import from the given ones
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class ImportBars extends JDialog {

	private static final GridBagLayout gridBagLayout = new GridBagLayoutExtended(new int[]{0}, new int[]{160, 20, 20}, new double[]{1.0}, new double[]{0.9, 0.05, 0.05, Double.MIN_VALUE});
	private static final GridBagConstraints gbc_scrollPane = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btConfirm = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, 1, 1, GridBagConstraints.BOTH);
	
	private List<Bar> bars = null;
	
	/**
	 * Create a new {@link ImportBars}
	 * @param frame	The parent frame
	 * @param bars	All bars in the file
	 */
	public ImportBars(JFrame frame, Collection<Bar> bars){
		super(frame, ModalityType.APPLICATION_MODAL);
		setTitle("Import bars");
		setMinimumSize(new Dimension(320, 180));
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		setBounds(AbstractFrame.getBounds(this, 0.2, 0.4));
		getContentPane().setLayout(gridBagLayout);

		Vector<Bar> v = new Vector<>(bars);
		v.sort(null);
		JList<Bar> barList = new JList<>(v);
		JScrollPane scrollPane = new JScrollPane(barList);
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JButton btConfirm = new JButton("Import selected bars");
		btConfirm.addActionListener(x -> {
			this.bars = barList.getSelectedValuesList();
			close();
		});
		getContentPane().add(btConfirm, gbc_btConfirm);

		JButton btCancel = new JButton("Cancel operation");
		btCancel.addActionListener(x -> {
			close();
		});
		getContentPane().add(btCancel, gbc_btCancel);
	}
	
	/**
	 * Get the selected bars
	 * @return	The selected bars
	 */
	public List<Bar> get(){
		setVisible(true);
		return bars;
	}

	private void close(){
		getContentPane().removeAll();
		dispose();
	}
	
}