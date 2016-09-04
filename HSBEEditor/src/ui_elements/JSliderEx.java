package ui_elements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;

import core.Bar;
import core.Field;
import enums.TokenField;
import interfaces.BarEditorField;


/**
 * A JSlider which can hold a field's data
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class JSliderEx extends JSlider implements BarEditorField, MouseMotionListener, MouseListener {

	private TokenField tokenField;
	private JCheckBoxLabel chkDisabled;
	
	private final JPopupMenu pop = new JPopupMenu();
	private JMenuItem item = new JMenuItem();
	
	/**
	 * Create a new {@link JSliderEx}
	 * @param tokenField	The field
	 * @param chkDisabled	The associated Disable JCheckBox
	 * @param min			The min value
	 * @param max			The max value
	 * @param value			The initial value
	 */
	public JSliderEx (TokenField tokenField, JCheckBoxLabel chkDisabled, int min, int max, int value){
		super(min, max, value);
		this.tokenField = tokenField;
		this.chkDisabled = chkDisabled;
		chkDisabled.setField(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		setMajorTickSpacing(25);
		setMinorTickSpacing(1);
		setSnapToTicks(true);
		pop.add(item);
		pop.setDoubleBuffered(true);
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
		return getValue() >= 0;
	}

	@Override
	public String getFieldContent(){
		return String.valueOf(getValue());
	}

	@Override
	public void loadFromBar(Bar bar){
		try {
			Field field = bar.get(tokenField);
			String text = field.value;
			Integer val = Integer.valueOf(text);
			setValue(val);
			if (chkDisabled != null){
				chkDisabled.setSelected(!field.disabled);
			}
		} catch (Exception e){/*Nothing to do*/}
	}


	/**
	 * Show the tooltip on mouse over
	 * @param me	The mouse event
	 */
	public void showToolTip (MouseEvent me){
		int val = getValue();
		item.setText(val>=0?String.valueOf(val):"Default");
		pop.show(me.getComponent(), me.getX() - 5, -30);
		item.setArmed(false);
	}
	
	@Override
	public void mouseDragged (MouseEvent me){
		showToolTip(me);
	}
	
	@Override
	public void mousePressed (MouseEvent me){
		showToolTip(me);
	}
	
	@Override
	public void mouseReleased (MouseEvent me){
		pop.setVisible(false);
	}
	
	@Override
	public void mouseMoved (MouseEvent me){/*Nothing to do*/}
	@Override
	public void mouseClicked (MouseEvent me){/*Nothing to do*/}
	@Override
	public void mouseEntered (MouseEvent me){/*Nothing to do*/}
	@Override
	public void mouseExited (MouseEvent me){/*Nothing to do*/}
	
}
