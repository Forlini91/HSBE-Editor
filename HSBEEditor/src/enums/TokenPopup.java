package enums;

import interfaces.Token;

/**
 * All possible popup mode
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenPopup implements Token {
	
	HUDDEFAULT ("", "", "Do nothing"),
	HUDBARSABOVE ("HUDbarsAbove", "Top edge", "Bar will enter/exit from the top edge of the screen"),
	HUDBARSBELOW ("HUDbarsBelow", "Bottom edge", "Bar will enter/exit from the bottom edge of the screen"),
	HUDBARSLEFT ("HUDbarsLeft", "Left edge", "Bar will enter/exit from the left edge of the screen"),
	HUDBARSRIGHT ("HUDbarsRight", "Right edge", "Bar will enter/exit from the right edge of the screen")
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenPopup (String code, String name, String description){
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
