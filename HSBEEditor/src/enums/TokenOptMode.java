package enums;

import interfaces.Token;

/**
 * All possible optimization modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenOptMode implements Token {

	OM0 ("", "No optimization", "The bar is always updated"),
	OM1 ("#", "Full optimization", "Only update the bar if references or ((val-min)/(max-min)) fraction change"),
	OM2 ("##", "Half optimization", "Only update the bar if references or ((val-min)/(max-min)) fraction change (But bar's visibility is always updated)"),
	;

	public final String code;
	public final String name;
	public final String description;
	
	TokenOptMode (String code, String name, String description){
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
