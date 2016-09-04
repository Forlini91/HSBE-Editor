package ui_elements;

import java.awt.event.FocusEvent;
import java.lang.reflect.Method;
import java.util.function.Consumer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.Bar;
import core.Field;
import core.QF;
import enums.TokenField;
import interfaces.BarEditorField;
import interfaces.JComponentEx;
import interfaces.Token;


/**
 * A JComboBox which can hold a field's data
 * @author MarcoForlini
 * @param <E>	The type of the content
 */
@SuppressWarnings ("serial")
public class JComboBoxEx<E> extends JComboBox <E> implements JComponentEx, BarEditorField {

	private TokenField tokenField = null;
	private E defaultSelection = null;
	private String prefix = "";
	private JCheckBoxLabel chkDisabled;
	private Consumer<JComponentEx> focusGained = (c) -> {/*Do nothing*/};
	private Class<? extends E> tokenClass;
	
	/**
	 * Create a new {@link JComboBoxEx}
	 */
	public JComboBoxEx(){
		super ();
		addFocusListener(this);
		getEditor().getEditorComponent().addFocusListener(this);
	}

	/**
	 * Initialize the data
	 * @param tokenField		The field
	 * @param tokenClass		The type of element
	 * @param defaultSelection	The default selection
	 * @param chkDisabled		The associated disable CheckBox
	 * @param focusGained		Action to execute when gaining focus
	 */
	public JComboBoxEx(TokenField tokenField, Class<? extends E> tokenClass, E defaultSelection, JCheckBoxLabel chkDisabled, Consumer<JComponentEx> focusGained){
		this(tokenField, tokenClass, defaultSelection, "", chkDisabled, focusGained, false);
	}
	
	/**
	 * Initialize the data
	 * @param tokenField		The field
	 * @param tokenClass		The type of element
	 * @param defaultSelection	The default selection
	 * @param prefix			The prefix in the enums fields
	 * @param chkDisabled		The associated disable CheckBox
	 * @param focusGained		Action to execute when gaining focus
	 */
	public JComboBoxEx(TokenField tokenField, Class<? extends E> tokenClass, E defaultSelection, String prefix, JCheckBoxLabel chkDisabled, Consumer<JComponentEx> focusGained){
		this(tokenField, tokenClass, defaultSelection, prefix, chkDisabled, focusGained, false);
	}
	
	/**
	 * Initialize the data
	 * @param tokenField		The field
	 * @param tokenClass		The type of element
	 * @param defaultSelection	The default selection
	 * @param chkDisabled		The associated disable CheckBox
	 * @param focusGained		Action to execute when gaining focus
	 * @param editable			If true, the combobox is editable, else user can only choose an element in the list
	 */
	public JComboBoxEx(TokenField tokenField, Class<? extends E> tokenClass, E defaultSelection, JCheckBoxLabel chkDisabled, Consumer<JComponentEx> focusGained, boolean editable){
		this(tokenField, tokenClass, defaultSelection, "", chkDisabled, focusGained, editable);
	}
	
	/**
	 * Initialize the data
	 * @param tokenField		The field
	 * @param tokenClass		The type of element
	 * @param defaultSelection	The default selection
	 * @param prefix			The prefix in the enums fields
	 * @param chkDisabled		The associated disable CheckBox
	 * @param focusGained		Action to execute when gaining focus
	 * @param editable			If true, the combobox is editable, else user can only choose an element in the list
	 */
	public JComboBoxEx(TokenField tokenField, Class<? extends E> tokenClass, E defaultSelection, String prefix, JCheckBoxLabel chkDisabled, Consumer<JComponentEx> focusGained, boolean editable){
		this();
		this.tokenField = tokenField;
		this.tokenClass = tokenClass;
		setModel(new DefaultComboBoxModel <E>(tokenClass.getEnumConstants()));
		this.defaultSelection = defaultSelection;
		this.prefix = prefix;
		this.chkDisabled = chkDisabled;
		this.focusGained = focusGained;
		chkDisabled.setField(this);
		setEditable(editable);
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
		return (getSelectedItem() != defaultSelection);
	}

	@Override
	public String getFieldContent(){
		Object sel = getSelectedItem();
		if (sel instanceof Token){
			return ((Token) sel).toCode();
		}
		return sel.toString();
	}

	@Override
	public void loadFromBar(Bar bar){
		//Nothing to do
	}

	/**
	 * Read the field from the bar
	 * @param bar	The bar
	 */
	public void setElement(Bar bar){
		try{
			Field field = bar.get(tokenField);
			String param = prefix + field.value;
			try {
				Method m = tokenClass.getMethod("valueOf", String.class);
				Object sel = m.invoke(null, param.toUpperCase());
				setSelectedItem(sel);
			} catch (Exception e){
				if (isEditable()){
					setSelectedItem(param);
				} else {
					setSelectedItem(defaultSelection);
				}
			}
			if (chkDisabled != null){
				chkDisabled.setSelected(!field.disabled);
			}
		} catch (Exception e){
			setSelectedItem(defaultSelection);
		}
	}
	
	@Override
	public void focusGained (FocusEvent e) {
		focusGained.accept(this);
	}
	
	@Override
	public void focusLost (FocusEvent e) {/*Nothing to do*/}
	
	@Override
	public void useQF (QF qf) {/*Nothing to do*/}
	
	@Override
	public boolean isUsingQF(){
		return false;
	}
	
	@Override
	public void setUsingQF(boolean usingQF){/*Nothing to do*/}

}
