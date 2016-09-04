package interfaces;



/**
 * A piece of information which can be translated into .ini code.
 * @author MarcoForlini
 */
public interface Token {

	/**
	 * Convert this object to .ini code
	 * @return	The .ini code
	 */
	String toCode();

}
