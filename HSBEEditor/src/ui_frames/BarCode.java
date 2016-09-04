package ui_frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import core.Bar;
import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;


/**
 * A window to directly edit the bar's code
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class BarCode extends AbstractFrame {

	private static final GridBagLayout gridBagLayout = new GridBagLayoutExtended(new int[]{0}, new int[]{160, 20, 20}, new double[]{1.0}, new double[]{1.0, 0, 0, Double.MIN_VALUE});
	private static final GridBagConstraints gbc_scrollPane = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btSave = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, 1, 1, GridBagConstraints.BOTH);
	
	private JTextArea code;

	/**
	 * Create a new BarCode window
	 * @param bar	The bar
	 * @param i		The nth bar
	 * @param n		The number of bars
	 */
	public BarCode(Bar bar, int i, int n){
		setTitle(bar.getName());
		setBounds(getBounds(this, 0.75, 0.75));
		setMinimumSize(new Dimension(480, 450));
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		getContentPane().setLayout(gridBagLayout);
		
		code = new JTextArea(bar.toCode());
		JScrollPane scrollPane = new JScrollPane(code);
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JButton btClose = new JButton("Save");
		btClose.addActionListener(x -> {
			bar.readCode(code.getText());
			bar.updatePanel();
			dispose();
		});
		getContentPane().add(btClose, gbc_btSave);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(x -> {
			dispose();
		});
		getContentPane().add(btCancel, gbc_btCancel);
		setVisible(true);
	}
	
}