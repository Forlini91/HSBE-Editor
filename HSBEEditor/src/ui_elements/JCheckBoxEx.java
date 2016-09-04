package ui_elements;

import javax.swing.JCheckBox;

import core.Bar;
import enums.TokenField;
import interfaces.BarEditorField;

/**
 * A checkbox which can hold a boolean field's data
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class JCheckBoxEx extends JCheckBox implements BarEditorField{
	
	private TokenField tokenField;
	private JCheckBoxLabel chkDisabled;
	
	/**
	 * Create a new CheckBoxEx
	 * @param tokenField	The associated field
	 * @param chkDisabled	The associated Disable check
	 * @param text			The text of the checkbox
	 */
	public JCheckBoxEx(TokenField tokenField, JCheckBoxLabel chkDisabled, String text){
		this.tokenField = tokenField;
		this.chkDisabled = chkDisabled;
		setText(text);
	}
	
	@Override
	public TokenField getTokenField(){
		return tokenField;
	}

	@Override
	public JCheckBoxLabel getCheckDisable(){
		return chkDisabled;
	}
	
	@Override
	public boolean isFieldCompiled(){
		return isSelected();
	}

	@Override
	public String getFieldContent(){
		return "1";
	}
	
	@Override
	public void loadFromBar(Bar bar){
		try {
			setSelected(!bar.get(tokenField).value.equals("0"));
		} catch (Exception e){
			//Nothing to do
		}
	}

}
