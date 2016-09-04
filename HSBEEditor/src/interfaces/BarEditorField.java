package interfaces;

import core.Bar;
import core.Field;
import enums.TokenField;
import ui_elements.JCheckBoxLabel;


/**
 * A field which can hold/store a field's data
 * @author MarcoForlini
 */
public interface BarEditorField {

	/**
	 * Check if the field is compiled
	 * @return	true if the field contains any not-default value, false if empty or contains a default value
	 */
	boolean isFieldCompiled();

	/**
	 * Get the content of the field
	 * @return	The content of the field
	 */
	String getFieldContent();

	/**
	 * Get the field type
	 * @return	The field type
	 */
	TokenField getTokenField();

	/**
	 * Get the associated Disable JCheckBox which enable/disable this field
	 * @return	The associrated Disable JCheckBox
	 */
	JCheckBoxLabel getCheckDisable();

	/**
	 * Check if the field is disabled (the line begins with ;)
	 * @return	true if the field is disabled, false otherwise
	 */
	default boolean isFieldDisabled(){
		return (getCheckDisable() != null ? !getCheckDisable().isSelected() : false);
	}
	
	/**
	 * Save the field value to the given bar
	 * @param bar	The bar
	 */
	default void saveToBar(Bar bar){
		if (isFieldCompiled()){
			bar.set(getTokenField(), new Field(getFieldContent(), isFieldDisabled()));
		}
	}

	/**
	 * Load the field value from the given bar
	 * @param bar	The bar
	 */
	void loadFromBar(Bar bar);

}
