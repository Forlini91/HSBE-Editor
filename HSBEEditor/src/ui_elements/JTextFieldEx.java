package ui_elements;

import java.awt.event.FocusEvent;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import javax.swing.JTextField;

import core.Bar;
import core.Field;
import core.QF;
import enums.TokenField;
import enums.TokenQF;
import enums.TokenRef;
import interfaces.BarEditorField;
import interfaces.JComponentEx;


/**
 * A JTextField which can hold a field's data
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class JTextFieldEx extends JTextField implements JComponentEx, BarEditorField {

	/**
	 * Type of field
	 * @author MarcoForlini
	 */
	public enum Type{
		/** Any field but the other ones */
		DEFAULT,
		/** A referene field */
		REF,
		/** A numeric value field */
		VALUE,
		/** The "Visible_On" field */
		VISIBLE_ON
	}
	
	private TokenField tokenField;
	/** Type of field */
	public Type type = Type.DEFAULT;
	/** The associated chkDisabled field */
	public JCheckBoxLabel chkDisabled = null;
	private Consumer<JTextFieldEx> focusGained = (c) -> {/*Do nothing*/};
	
	private boolean usingQF = false;
	private QF qf = null;
	boolean temporary = false;

	
	private JTextFieldEx(TokenField tokenField, JCheckBoxLabel chkDisabled){
		super();
		this.tokenField = tokenField;
		this.chkDisabled = chkDisabled;
		chkDisabled.setField(this);
		setColumns(10);
		addFocusListener(this);
	}

	/**
	 * Create a new {@link JTextFieldEx}
	 * @param tokenField	The field
	 * @param chkDisabled	The associated chkDisabled
	 * @param focusGained	The action to execute on FocusGained event
	 */
	public JTextFieldEx(TokenField tokenField, JCheckBoxLabel chkDisabled, Consumer<JTextFieldEx> focusGained){
		this(tokenField, chkDisabled);
		this.focusGained = focusGained;
	}

	/**
	 * Create a new {@link JTextFieldEx}
	 * @param tokenField	The field
	 * @param chkDisabled	The associated chkDisabled
	 * @param focusGained	The action to execute on FocusGained event
	 * @param type			Type of field
	 */
	public JTextFieldEx(TokenField tokenField, JCheckBoxLabel chkDisabled, Consumer<JTextFieldEx> focusGained, Type type){
		this(tokenField, chkDisabled);
		this.type = type;
		this.focusGained = focusGained;
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
		return !getText().isEmpty();
	}

	@Override
	public String getFieldContent(){
		return getText();
	}

	@Override
	public void loadFromBar(Bar bar){
		try {
			Field field = bar.get(tokenField);
			String text = field.value;
			setText(text);
			if (chkDisabled != null){
				chkDisabled.setSelected(!field.disabled);
			}
		} catch (Exception e){
			/*Nothing to do*/
		}
	}
	
	
	@Override
	public void focusGained (FocusEvent e) {
		if (temporary){
			temporary = false;
		} else {
			focusGained.accept(this);
		}
	}
	
	@Override
	public void focusLost (FocusEvent e) {
		if (e.isTemporary()){
			temporary = true;
		}
	}
	
	/**
	 * Return the current quick function, if any
	 * @return	The current quick function if any, null otherwise
	 */
	public QF getQF(){
		return qf;
	}

	@Override
	public void useQF (QF qf) {
		if (isEditable()){
			this.qf = qf;
			setText(qf.toString());
			setUsingQF(true);
		}
	}

	@Override
	public boolean isUsingQF(){
		return usingQF;
	}

	@Override
	public void setUsingQF(boolean usingQF){
		this.usingQF = usingQF;
		if (!usingQF){
			qf = null;
		}
	}

	/**
	 * Parse the QF or reset the usingQF flag;
	 */
	public void parseQF(){
		try {
			parseQFExc();
		} catch (Exception e){
			setUsingQF(false);
			return;
		}
	}


	private void parseQFExc() throws Exception {
		StringBuilder text = new StringBuilder(getText());
		if (text.length() < 4){
			throw new Exception();
		}

		int begin = 0;
		String prefix = "";
		boolean negate = false;
		TokenRef ref = null;
		if (text.charAt(0) == '!'){
			begin += 1;
			negate = true;
		}
		
		switch(type){
			case REF:
				if (text.charAt(begin) == '#') {
					begin += 1;
				}
			case VALUE:
				if (text.charAt(begin) == '#') {
					if (text.charAt(begin+1) == '#') {
						begin += 2;
					} else {
						begin += 1;
					}
				}
				break;
			case VISIBLE_ON:
				if (text.charAt(begin) == '#') {
					if (text.charAt(begin+1) == '#') {
						begin += 2;
					} else {
						begin += 1;
					}
				}
				if (text.substring(begin).toLowerCase().startsWith("hud_ref")){
					begin += 7;
					if (text.charAt(begin) == '#'){
						begin += 1;
					} else {
						begin += 2;
					}
				}
			default:
				break;
		}
		
		{
			int i = negate?1:0;
			if (begin > i){
				prefix = text.substring(i, begin);
			}
		}
		
		if (text.charAt(begin) == '$'){
			ref = TokenRef.R1;
			begin += 1;
		} else if (text.charAt(begin+1) == '$'){
			String s = "R" + text.charAt(begin);
			ref = TokenRef.valueOf(s);
			begin += 2;
		} else {
			throw new Exception();
		}
		if (begin > 0){
			text.delete(0, begin);
		}
		
		StringTokenizer tok = new StringTokenizer(text.toString(), " ");
		if (!tok.hasMoreTokens() || tok.countTokens() > 2){
			throw new Exception();
		}
		String tokenS = tok.nextToken().toUpperCase();
		TokenQF token = TokenQF.valueOf(tokenS);
		String[] params = new String[tok.countTokens()];
		int i = 0;
		while(tok.hasMoreTokens()){
			params[i] = tok.nextToken();
		}
		useQF(new QF(prefix, token, negate, ref, params));
	}

}
