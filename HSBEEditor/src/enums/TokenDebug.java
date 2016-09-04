package enums;

import interfaces.Token;

/**
 * All possible debug modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenDebug implements Token {
	
	D0 ("0", "No debug", "Debug is disabled"),
	D1 ("1", "Debug mode: 1", "It will display debug info about this bar, to the console"),
	D2 ("2", "Debug mode: 2", "It will display debug info and additional initialization info for this bar, to the console"),
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenDebug (String code, String name, String description){
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
