package enums;

import interfaces.Token;

/**
 * All possible visible modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenVisMode implements Token {

	VM0 ("", "Mode 1", "visible OR visible_on changed - invisible AND visible_on unchanghed for x time"),
	VM1 ("#", "Mode 2", "visible AND visible_on changed - invisible OR visible_on unchanghed for x time"),
	VM2 ("##", "Mode 3", "visible OR visible_on changed - invisible for x time AND visible_on unchanghed for x time"),
	;

	public final String code;
	public final String name;
	public final String description;
	
	TokenVisMode (String code, String name, String description){
		this.code = code;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toCode(){
		return code;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
