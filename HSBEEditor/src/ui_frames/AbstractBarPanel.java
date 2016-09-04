package ui_frames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import core.Bar;

/**
 * Contains the data for a bar panel
 * @author MarcoForlini
 */
public abstract class AbstractBarPanel {
	
	/** Border used when the element is clicked */
	public static Border bevelClickedBorder = new BevelBorder(BevelBorder.LOWERED, null, null, null, null);
	/** Border used when the element is selected */
	public static Border bevelSelectedBorder = new BevelBorder(BevelBorder.LOWERED, null, null, null, null);
	/** border used when the element is begin moved */
	public static Border bevelMoveBorder = new BevelBorder(BevelBorder.RAISED, null, null, null, null);

	/** The associated bar */
	public final Bar bar;
	/** The first label */
	public final JLabel label0 = new JLabel();
	/** The second label */
	public final JLabel label1 = new JLabel();
	/** The third label */
	public final JLabel label2 = new JLabel();
	/** The fourth label */
	public final JLabel label3 = new JLabel();
	/** The popup menu for this panel */
	protected final JPopupMenu popupMenu = buildPopupMenu();


	/**
	 * Create a new {@link AbstractBarPanel}
	 * @param bar	The associated bar
	 */
	public AbstractBarPanel (Bar bar){
		this.bar = bar;
		label0.setOpaque(false);
		label1.setText("" + (bar.getI() + 1));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setText(bar.getName());
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setText(bar.getDescription());
		
		MouseListener ml = getClickMouseListener();
		label0.addMouseListener(ml);
		label1.addMouseListener(ml);
		label2.addMouseListener(ml);
		label3.addMouseListener(ml);
		setSelected(bar.isSelected());
	}
	
	/**
	 * Reverse the selection of the panel and the associated bar
	 */
	public void reverseSelection(){
		setSelected(!bar.isSelected());
	}
	
	/**
	 * Enable/Disable the panel and the associated bar
	 * @param enabled	The new state
	 */
	public void setEnabled(boolean enabled){
		bar.setEnabled(enabled);
		if (enabled){
			label1.setForeground(Color.BLACK);
			label2.setForeground(Color.BLACK);
			label3.setForeground(Color.BLACK);
		} else {
			label1.setForeground(Color.LIGHT_GRAY);
			label2.setForeground(Color.LIGHT_GRAY);
			label3.setForeground(Color.LIGHT_GRAY);
		}
	}

	/**
	 * Change the panel border
	 * @param b		The new border
	 */
	public void setBorder(Border b){
		label0.setBorder(b);
		//		label1.setBorder(b);
		//		label2.setBorder(b);
		//		label3.setBorder(b);
	}
	
	/**
	 * Build a new MouseListener
	 * @return	The new MouseListener
	 */
	protected MouseListener getClickMouseListener() {
		return new MouseListener(){
			@Override
			public void mouseClicked (MouseEvent e) {/*Nothing do to*/}
			
			@Override
			public void mousePressed (MouseEvent e) {
				if (!bar.isSelected()){
					setBorder(bevelClickedBorder);
				}
			}
			
			@Override
			public void mouseReleased (MouseEvent e) {
				mouseReleasedEvent(e);
			}
			
			@Override
			public void mouseEntered (MouseEvent e) {/*Nothing do to*/}
			@Override
			public void mouseExited (MouseEvent e) {/*Nothing do to*/}
		};
	}
	
	/**
	 * Set/Unset the selected state
	 * @param isSelected	The new selected state
	 */
	public abstract void setSelected(boolean isSelected);
	
	/**
	 * Event fired when the mouse is released
	 * @param e	The MouseEvent
	 */
	protected abstract void mouseReleasedEvent(MouseEvent e);

	/**
	 * Build a new JPopupMenu for this panel
	 * @return	The new JPopupMenu
	 */
	protected abstract JPopupMenu buildPopupMenu ();

	/**
	 * Set the flag ReadyForMove
	 */
	public abstract void setReadyForMove();

	@Override
	public String toString(){
		return bar.toString();
	}
}
