package ui_frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;


/**
 * Dialog which allow the player to edit a bar code
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class NewBarCode extends JDialog {
	
	private static final GridBagLayout gridBagLayout = new GridBagLayoutExtended(new int[]{0}, new int[]{160, 20, 20}, new double[]{1.0}, new double[]{0.9, 0.05, 0.05, Double.MIN_VALUE});
	private static final GridBagConstraints gbc_scrollPane = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btClose = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, 1, 1, GridBagConstraints.BOTH);

	private JTextArea code;
	boolean save = false;
	
	/**
	 * Create a new NewBarCode
	 * @param frame	The parent frame
	 * @param s		The current bar code
	 */
	public NewBarCode(JFrame frame, String s){
		super(frame, ModalityType.APPLICATION_MODAL);
		setTitle("New bar from code");
		setBounds(AbstractFrame.getBounds(this, 0.4, 0.6));
		setMinimumSize(new Dimension(480, 270));
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		getContentPane().setLayout(gridBagLayout);

		code = new JTextArea(s!=null?s:"");
		JScrollPane scrollPane = new JScrollPane(code);
		getContentPane().add(scrollPane, gbc_scrollPane);

		JButton btClose = new JButton("Create");
		btClose.addActionListener(x -> {
			save = true;
			close();
		});
		getContentPane().add(btClose, gbc_btClose);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(x -> {
			close();
		});
		getContentPane().add(btCancel, gbc_btCancel);
	}

	private void close(){
		getContentPane().removeAll();
		dispose();
	}

	/**
	 * Return the current bar code
	 * @return	The bar code, null if operation is cancelled
	 */
	public String get(){
		setVisible(true);
		if (save){
			return (code.getText());
		}
		return null;
	}

}