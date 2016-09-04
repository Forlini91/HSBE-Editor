package ui_frames;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import core.QF;
import enums.TokenOptMode;
import enums.TokenQF;
import enums.TokenQFCaller;
import enums.TokenRef;
import enums.TokenVisMode;
import enums.TokenVisRef;
import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;
import ui_elements.JTextFieldEx;


/**
 * A dialog which allow the user to define a Quick Function
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class DefineQF extends JDialog {

	private static final GridBagLayout gridBagLayout = new GridBagLayoutExtended(new int[]{50, 150}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0.25, 0.5}, new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0});
	private static final GridBagConstraints gbc_chkNegate = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL);
	private static final GridBagConstraints gbc_comboBox = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL);
	private static final GridBagConstraints gbc_lblCaller = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblReturn = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblSharp = new GridBagConstraintsExtended(0, 5, 5, 5, 3, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_comboSharpRef = new GridBagConstraintsExtended(0, 5, 5, 5, 3, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_comboSharpVal = new GridBagConstraintsExtended(0, 5, 5, 5, 3, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_comboSharpVis = new GridBagConstraintsExtended(0, 5, 5, 5, 3, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_comboVisRef = new GridBagConstraintsExtended(0, 5, 5, 5, 4, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_txtVisRef = new GridBagConstraintsExtended(0, 5, 5, 5, 4, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblRef = new GridBagConstraintsExtended(0, 5, 5, 5, 5, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_spnRef = new GridBagConstraintsExtended(0, 5, 5, 5, 5, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblParam1 = new GridBagConstraintsExtended(0, 5, 5, 5, 6, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_txtParam1 = new GridBagConstraintsExtended(0, 5, 5, 5, 6, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblParam2 = new GridBagConstraintsExtended(0, 5, 5, 5, 7, 0, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_txtParam2 = new GridBagConstraintsExtended(0, 5, 5, 5, 7, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_empty = new GridBagConstraintsExtended(0, 5, 5, 5, 8, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btConfirm = new GridBagConstraintsExtended(0, 5, 5, 5, 9, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btDelete = new GridBagConstraintsExtended(0, 5, 5, 5, 10, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 11, 0, 1, 2, GridBagConstraints.BOTH);

	private JCheckBox chkNegate, chkSharpRef;
	private JLabel lblCaller, lblReturn, lblSharp, lblVisRef, lblRef, lblParam1, lblParam2;
	private JTextField txtParam1, txtParam2;
	private JButton btConfirm, btDelete, btCancel;
	private JComboBox <TokenRef> spnRef;
	private JComboBox <TokenVisMode> comboSharpVis;
	private JComboBox <TokenOptMode> comboSharpOpt;
	private JComboBox <TokenVisRef> comboVisRef;

	private TokenQF token;
	private boolean save = false;
	private boolean delete = false;
	
	/**
	 * Create a new {@link DefineQF}
	 * @param frame		The parent frame
	 * @param token		The selected QF
	 * @param textField	The JTextField
	 */
	public DefineQF(JFrame frame, TokenQF token, JTextFieldEx textField){
		super(frame, ModalityType.APPLICATION_MODAL);
		setMinimumSize(new Dimension(480, 315));
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		setBounds(AbstractFrame.getBounds(this, 0.2, 0.45));
		Container cont = getContentPane();
		cont.setLayout(gridBagLayout);
		this.token = token;

		chkNegate = new JCheckBox("Negate");
		cont.add(chkNegate, gbc_chkNegate);
		
		JComboBox<TokenQF> listQF = new JComboBox<>();
		listQF.setModel(new DefaultComboBoxModel <>(TokenQF.values()));
		listQF.setSelectedItem(token);
		listQF.addItemListener(e -> {
			this.token = (TokenQF) listQF.getSelectedItem();
			setToken(this.token, textField);
		});
		cont.add(listQF, gbc_comboBox);

		lblCaller = new JLabel("Caller: " + token.caller);
		cont.add(lblCaller, gbc_lblCaller);
		
		lblReturn = new JLabel("Return: " + token.returnType);
		cont.add(lblReturn, gbc_lblReturn);
		
		lblSharp = new JLabel();
		cont.add(lblSharp, gbc_lblSharp);

		chkSharpRef = new JCheckBox ("Fixed");
		chkSharpRef.setToolTipText("The reference will be calculated only once");
		cont.add(chkSharpRef, gbc_comboSharpRef);
		
		comboSharpOpt = new JComboBox<>(new DefaultComboBoxModel <>(TokenOptMode.values()));
		cont.add(comboSharpOpt, gbc_comboSharpVal);

		comboSharpVis = new JComboBox<>(new DefaultComboBoxModel <>(TokenVisMode.values()));
		cont.add(comboSharpVis, gbc_comboSharpVis);
		
		lblVisRef = new JLabel("Monitor reference");
		cont.add(lblVisRef, gbc_comboVisRef);
		
		comboVisRef = new JComboBox<>();
		comboVisRef.setModel(new DefaultComboBoxModel <>(TokenVisRef.values()));
		cont.add(comboVisRef, gbc_txtVisRef);
		
		lblRef = new JLabel ("Use reference");
		cont.add(lblRef, gbc_lblRef);
		
		spnRef = new JComboBox<>();
		spnRef.setModel(new DefaultComboBoxModel<>(TokenRef.values()));
		cont.add(spnRef, gbc_spnRef);
		
		lblParam1 = new JLabel ();
		cont.add(lblParam1, gbc_lblParam1);

		txtParam1 = new JTextField ();
		cont.add(txtParam1, gbc_txtParam1);
		
		lblParam2 = new JLabel ();
		cont.add(lblParam2, gbc_lblParam2);

		txtParam2 = new JTextField ();
		cont.add(txtParam2, gbc_txtParam2);

		setToken(token, textField);
		
		JSeparator separator = new JSeparator();
		cont.add(separator, gbc_empty);

		btConfirm = new JButton("Create QF");
		btConfirm.addActionListener(x -> {
			if (checkFields()){
				save = true;
				close();
			}
		});
		cont.add(btConfirm, gbc_btConfirm);

		btDelete = new JButton("Delete QF");
		btDelete.setVisible(false);
		btDelete.addActionListener(x -> {
			delete = true;
			close();
		});
		cont.add(btDelete, gbc_btDelete);

		btCancel = new JButton("Cancel operation");
		btCancel.addActionListener(x -> {
			close();
		});
		cont.add(btCancel, gbc_btCancel);
	}
	
	private void close(){
		getContentPane().removeAll();
		dispose();
	}
	
	/**
	 * Build a new QF
	 * @return	The new QF
	 * @throws Exception	If the user choose to cancel the operation
	 */
	public QF get() throws Exception{
		setVisible(true);
		if (delete){
			return null;
		} else if (save){
			String prefix;
			if (chkSharpRef.isVisible() && chkSharpRef.isSelected()){
				prefix = "#";
			} else if (comboSharpOpt.isVisible()) {
				prefix = ((TokenOptMode) comboSharpOpt.getSelectedItem()).code;
			} else if (comboSharpVis.isVisible() && comboVisRef.isVisible()){
				prefix = ((TokenVisMode) comboSharpVis.getSelectedItem()).code + ((TokenVisRef) comboVisRef.getSelectedItem()).code;
				if (comboVisRef.getSelectedIndex() > 0){
					prefix += '#';
				}
			} else {
				prefix = "";
			}

			TokenRef ref = null;
			if (spnRef.isVisible()){
				ref = (TokenRef) spnRef.getSelectedItem();
			}

			if (token.params.length == 0){
				return new QF(prefix, token, chkNegate.isSelected(), ref);
			} else if (token.params.length == 1){
				return new QF(prefix, token, chkNegate.isSelected(), ref, txtParam1.getText());
			} else {
				return new QF(prefix, token, chkNegate.isSelected(), ref, txtParam1.getText(), txtParam2.getText());
			}
		}
		throw new Exception();
	}
	
	private boolean checkFields(){
		if (token.params.length >= 1){
			if (txtParam1.getText().length() == 0){
				JOptionPane.showMessageDialog(this, "You need to specify the parameter 1", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (token.params.length == 2){
				if (txtParam2.getText().length() == 0){
					JOptionPane.showMessageDialog(this, "You need to specify the parameter 2", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Model the dialog aspect for the given QF for the given JTextFieldEx
	 * @param token		The token
	 * @param textField	The text field
	 */
	public void setToken(TokenQF token, JTextFieldEx textField){
		setTitle(token.name);
		lblCaller.setText("Caller: " + token.caller);
		lblReturn.setText("Return: " + token.returnType);
		
		lblSharp.setVisible(false);
		chkSharpRef.setVisible(false);
		comboSharpOpt.setVisible(false);
		comboSharpVis.setVisible(false);
		lblVisRef.setVisible(false);
		comboVisRef.setVisible(false);
		switch(textField.type){
			case REF:
				lblSharp.setText("Fixed reference");
				lblSharp.setVisible(true);
				chkSharpRef.setVisible(true);
				break;
			case VALUE:
				lblSharp.setText("Optimization");
				lblSharp.setVisible(true);
				comboSharpOpt.setVisible(true);
				break;
			case VISIBLE_ON:
				lblSharp.setText("Visibility mode");
				lblSharp.setVisible(true);
				comboSharpVis.setVisible(true);
				lblVisRef.setVisible(true);
				comboVisRef.setVisible(true);
				break;
			default:
				break;
		}
		
		if (token.caller != TokenQFCaller.NOTHING &&
				token.caller != TokenQFCaller.ACTOR_AND_ACTOR &&
				token.caller != TokenQFCaller.ACTOR_AND_FACTION &&
				token.caller != TokenQFCaller.ACTOR_AND_ITEM) {
			lblRef.setVisible(true);
			spnRef.setVisible(true);
		} else {
			lblRef.setVisible(false);
			spnRef.setVisible(false);
		}
		
		if (token.params.length >= 1){
			lblParam1.setText(token.params[0].name);
			lblParam1.setToolTipText(token.params[0].description);
			lblParam1.setVisible(true);
			txtParam1.setVisible(true);
		} else {
			lblParam1.setVisible(false);
			txtParam1.setVisible(false);
		}

		if (token.params.length >= 2){
			lblParam2.setText(token.params[1].name);
			lblParam2.setToolTipText(token.params[1].description);
			lblParam2.setVisible(true);
			txtParam2.setVisible(true);
		} else {
			lblParam2.setVisible(false);
			txtParam2.setVisible(false);
		}
		lblCaller.invalidate();
	}
	
	/**
	 * Load the given QF data
	 * @param textField		The text field
	 * @param negate		Is the QF negated?
	 * @param prefix		Is there any prefix?
	 * @param caller		The QF calling reference
	 * @param params		The QF parameters (if any)
	 */
	public void setData (JTextFieldEx textField, boolean negate, String prefix, TokenRef caller, String...params){
		try{
			switch(textField.type){
				case REF:
					chkSharpRef.setSelected(prefix.startsWith("#"));
					comboSharpOpt.setSelectedItem(TokenOptMode.OM0);
					comboSharpVis.setSelectedItem(TokenVisMode.VM0);
					comboVisRef.setSelectedItem(TokenVisRef.VR);
					break;
				case VALUE:
					chkSharpRef.setSelected(false);
					TokenOptMode tom = TokenOptMode.valueOf(prefix);
					comboSharpOpt.setSelectedItem(tom);
					comboSharpVis.setSelectedItem(TokenVisMode.VM0);
					comboVisRef.setSelectedItem(TokenVisRef.VR);
					break;
				case VISIBLE_ON:
					chkSharpRef.setSelected(false);
					comboSharpOpt.setSelectedItem(TokenOptMode.OM0);
					String elaboratedPrefix;
					if (prefix.startsWith("##")){
						comboSharpVis.setSelectedItem(TokenVisMode.VM2);
						elaboratedPrefix = prefix.substring(2);
					} else if (prefix.startsWith("#")){
						comboSharpVis.setSelectedItem(TokenVisMode.VM1);
						elaboratedPrefix = prefix.substring(1);
					} else {
						comboSharpVis.setSelectedItem(TokenVisMode.VM0);
						elaboratedPrefix = prefix;
					}
					if (prefix.endsWith("#")){
						int length = elaboratedPrefix.length();
						elaboratedPrefix = elaboratedPrefix.substring(0, length-1);
					}
					switch(elaboratedPrefix){
						case "hud_ref":
						case "hud_ref1":
							comboVisRef.setSelectedItem(TokenVisRef.VR1);
							break;
						case "hud_ref2":
							comboVisRef.setSelectedItem(TokenVisRef.VR2);
							break;
						case "hud_refE":
							comboVisRef.setSelectedItem(TokenVisRef.VRE);
							break;
						case "hud_refB":
							comboVisRef.setSelectedItem(TokenVisRef.VRB);
							break;
						default:
							comboVisRef.setSelectedItem(TokenVisRef.VR);
							break;
					}
					break;
				default:
					break;
			}
		} catch (Exception e){
			System.out.println("ERROR QF: " + token);
			System.out.println(e.getMessage());
		}
		
		spnRef.setSelectedItem(caller);
		chkNegate.setSelected(negate);
		if (params.length >= 1){
			txtParam1.setText(params[0]);
			if (params.length >= 2){
				txtParam2.setText(params[1]);
			}
		}
		btConfirm.setText("Save QF");
		btDelete.setVisible(true);
	}

}