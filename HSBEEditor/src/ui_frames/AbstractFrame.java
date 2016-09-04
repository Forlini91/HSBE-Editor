package ui_frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Customized JFrame with many useful methods
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public abstract class AbstractFrame extends JFrame {
	
	private AbstractFrame previousMenu;
	/** If true, the frame has been loaded at least once */
	protected boolean loadedOnce = false;
	/** If true, the frame is currently loaded */
	protected boolean loaded = false;
	
	/**
	 * Create a new {@link AbstractFrame}
	 */
	public AbstractFrame(){
		addWindowListener(windowEvents);
	}
	
	/**
	 * WindowsAdapter events.
	 */
	protected WindowAdapter windowEvents = new WindowAdapter(){
		@Override
		public void windowOpened(WindowEvent e) {
			super.windowOpened(e);
			onOpenEvent(e);
			loadedOnce = true;
		}
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			onCloseEvent(e);
			loaded = false;
		}
		@Override
		public void windowActivated(WindowEvent e) {
			super.windowActivated(e);
			if (loadedOnce && !loaded){
				onReopenEvent(e);
			}
			loaded = true;
			onActivateEvent(e);
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			super.windowDeactivated(e);
			onDeactivateEvent(e);
			if (!isVisible()){
				loaded = false;
			}
		}
		@Override
		public void windowStateChanged(WindowEvent e) {
			super.windowStateChanged(e);
			onStateChangeEvent(e);
			if (!isVisible()){
				loaded = false;
			}
		}
		@Override
		public void windowGainedFocus(WindowEvent e) {
			super.windowGainedFocus(e);
			onGainFocusEvent(e);
		}
		@Override
		public void windowLostFocus(WindowEvent e) {
			super.windowLostFocus(e);
			onLostFocusEvent(e);
			if (!isVisible()){
				loaded = false;
			}
		}
	};
	
	/**
	 * Return the previous menu
	 * @return	The previous menu
	 */
	protected AbstractFrame getPreviousMenu(){
		return previousMenu;
	}
	
	/**
	 * Update the menu when opened.
	 * @param e		The WindoewEvent
	 */
	protected void onOpenEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when reopened.
	 * @param e		The WindoewEvent
	 */
	protected void onReopenEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when closed.
	 * @param e		The WindoewEvent
	 */
	protected void onCloseEvent(WindowEvent e){ previousMenu();}
	
	/**
	 * Update the menu when activated.
	 * @param e		The WindoewEvent
	 */
	protected void onActivateEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when deactivated.
	 * @param e		The WindoewEvent
	 */
	protected void onDeactivateEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when state change.
	 * @param e		The WindoewEvent
	 */
	protected void onStateChangeEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when closed.
	 * @param e		The WindoewEvent
	 */
	protected void onGainFocusEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Update the menu when closed.
	 * @param e		The WindoewEvent
	 */
	protected void onLostFocusEvent(WindowEvent e){/*Do nothing*/}
	
	/**
	 * Open the specified menu.
	 * @param menu				The menu to open
	 * @param freezeThis		Freeze this menu while the specified menu is open
	 * @param closeThis 		Close this menu when opening the given menu
	 * @pram closeThis			The current menu is closed
	 * @param savePrevious		The specified menu will register this as the previous menu
	 * @param deletePrevious 	The new menu will forget any previous menu
	 */
	protected void goToMenu(AbstractFrame menu, boolean freezeThis, boolean closeThis, boolean savePrevious, boolean deletePrevious){
		if (menu == null) {
			return;
		}
		if (savePrevious) {
			menu.previousMenu = this;
			System.out.println(menu + " set previous: " + this);
		} else if (deletePrevious) {
			menu.previousMenu = null;
			System.out.println(menu + " set previous: null");
		}
		if (closeThis) {
			setVisible(false);
		} else if (freezeThis){
			setEnabled(false);
		}
		menu.setVisible(true);
		menu.setEnabled(true);
	}
	
	/**
	 * Close this menu and goto the previous menu.
	 */
	protected void previousMenu(){
		if (previousMenu == null) {
			System.out.println(getClass().getSimpleName() + " > load previous > " + null);
			return;
		}
		System.out.println(getClass().getSimpleName() + " > load previous > " + previousMenu.getClass().getSimpleName());
		goToMenu(previousMenu, false, true, false, false);
	}
	
	/**
	 * Close this menu and goto the main menu.
	 */
	protected void mainMenu(){
		goToMenu(IniEditor.window, false, true, false, true);
	}
	
	/**
	 * Build the bounds for the given component
	 * @param component		The component
	 * @param widthPercent	Percent of the screen width
	 * @param heightPercent	Percent of the screen height
	 * @return				The bounds
	 */
	protected static Rectangle getBounds(Component component, double widthPercent, double heightPercent){
		GraphicsConfiguration gc = component.getGraphicsConfiguration();
		Rectangle rBounds = gc.getBounds();
		Dimension dimension = new Dimension((int) (rBounds.width*widthPercent), (int) (rBounds.height*heightPercent));
		Point point = new Point((rBounds.width / 2) - (dimension.width / 2), (rBounds.height / 2) - (dimension.height / 2));
		return new Rectangle(point, dimension);
	}

}
