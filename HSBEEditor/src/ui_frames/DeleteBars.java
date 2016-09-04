package ui_frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import core.Bar;
import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;


/**
 * Dialog which allow the player to delete the given bars
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class DeleteBars extends JDialog {

	private static final GridBagLayout gridBagLayout = new GridBagLayoutExtended(new int[]{0}, new int[]{160, 20, 20}, new double[]{1.0}, new double[]{0.9, 0.05, 0.05, Double.MIN_VALUE});
	private static final GridBagConstraints gbc_scrollPane = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btConfirm = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, 1, 1, GridBagConstraints.BOTH);

	private JList<Bar> barList;

	/**
	 * Create a new DeleteBars
	 * @param frame			The parent frame
	 * @param bars			The bars to delete
	 * @param eliminator	The function which elminitate the bars
	 */
	public DeleteBars(JFrame frame, Collection<Bar> bars, Runnable eliminator){
		super(frame, ModalityType.APPLICATION_MODAL);
		setTitle("Delete bars");
		setMinimumSize(new Dimension(320, 180));
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		setBounds(AbstractFrame.getBounds(this, 0.2, 0.4));
		Vector<Bar> v = new Vector<>(bars);
		v.sort(null);
		getContentPane().setLayout(gridBagLayout);
		
		barList = new JList<>(v);
		barList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(barList);
		getContentPane().add(scrollPane, gbc_scrollPane);

		JButton btConfirm = new JButton("Delete all bars");
		btConfirm.addActionListener(x -> {
			eliminator.run();
			close();
		});
		getContentPane().add(btConfirm, gbc_btConfirm);
		
		JButton btCancel = new JButton("Cancel operation");
		btCancel.addActionListener(x -> {
			close();
		});
		getContentPane().add(btCancel, gbc_btCancel);
	}
	
	private void close(){
		getContentPane().removeAll();
		dispose();
	}

}