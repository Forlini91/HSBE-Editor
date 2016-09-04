package ui_elements;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * A checkbox which can enable/disable a field
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class JCheckBoxLabel extends JCheckBox {
	
	private static final ImageIcon IMAGE_SELECTED = new ImageIcon(JCheckBoxLabel.class.getResource("CheckBoxSelected.png"));
	private static final ImageIcon IMAGE_DESELECTED = new ImageIcon(JCheckBoxLabel.class.getResource("CheckBoxDeselected.png"));

	private JComponent component = null;
	private Color selB = null, selB2 = null;
	private Color selF = null, selF2 = null;

	/**
	 * Create a new {@link JCheckBoxLabel}
	 * @param text			The checkBox text
	 * @param toolTipText	The tooltip text
	 */
	public JCheckBoxLabel (String text, String toolTipText){
		super(text);
		setToolTipText(toolTipText);
		addItemListener((e) -> {
			updateColor();
			if (isSelected()){
				setIcon(IMAGE_SELECTED);
			} else {
				setIcon(IMAGE_DESELECTED);
			}
		});
		setSelected(true);
		//setIcon(IMAGE_ICON);
		//setSelectedIcon(IMAGE_ICON);
		//setDisabledIcon(IMAGE_ICON);
		//setDisabledSelectedIcon(IMAGE_ICON);
	}

	/**
	 * Associate the field
	 * @param component	The field to associate
	 */
	public void setField(JComponent component){
		this.component = component;
		selB = component.getBackground();
		selF = component.getForeground();
		if (component instanceof JComboBox){
			Component editor = ((JComboBox<?>) component).getEditor().getEditorComponent();
			selB2 = editor.getBackground();
			selF2 = editor.getForeground();
		}
		updateColor();
	}

	/**
	 * Update the associated field color
	 */
	public void updateColor(){
		if (component != null && selB != null && selF != null){
			if (isSelected()){
				component.setBackground(selB);
				component.setForeground(selF);
				if (component instanceof JComboBox){
					Component editor = ((JComboBox<?>) component).getEditor().getEditorComponent();
					editor.setBackground(selB2);
					editor.setForeground(selF2);
				}
			} else {
				if (component instanceof JComboBox){
					JComboBox<?> combo = (JComboBox<?>) component;
					if (combo.isEditable()){
						Component editor = combo.getEditor().getEditorComponent();
						editor.setBackground(Color.ORANGE);
						editor.setForeground(Color.BLUE);
						return;
					}
				}
				component.setBackground(Color.ORANGE);
				component.setForeground(Color.BLUE);
			}
		}
	}

}
