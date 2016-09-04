package interfaces;

import java.awt.event.FocusListener;

import core.QF;


/**
 * A component which can hold a Quick Function
 * @author MarcoForlini
 */
public interface JComponentEx extends FocusListener {
	
	/**
	 * Assign the given QF to the component
	 * @param qf	The QF
	 */
	void useQF(QF qf);

	/**
	 * Check if the component is using a QF
	 * @return	true if the component is using a QF, false otherwise
	 */
	boolean isUsingQF();
	
	/**
	 * Set/Unset the usingQF flag
	 * @param usingQF	The new flag state
	 */
	void setUsingQF(boolean usingQF);
	
}
