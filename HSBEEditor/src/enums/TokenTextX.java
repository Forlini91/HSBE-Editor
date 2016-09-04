package enums;

import interfaces.Token;

/**
 * All possible text X positions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenTextX implements Token {

	HUDDEFAULT ("HUDdefault", "Default", "Use global setting"),
	HUDTXTLEFT ("HUDtxtLeft", "Left", "Left side of the bar"),
	HUDTXTRIGHT ("HUDtxtRight", "Right", "Right side of the bar"),
	HUDTXTCENTER ("HUDtxtCenter", "Center", "Center of the bar"),
	;

	public final String code;
	public final String name;
	public final String description;

	TokenTextX (String code, String name, String description){
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
