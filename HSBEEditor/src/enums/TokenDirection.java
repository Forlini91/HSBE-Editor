package enums;

import interfaces.Token;

/**
 * All possible directions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenDirection implements Token {
	
	HUDDEFAULT ("HUDdefault", "Default", "Horizontal bars shrinks/fills on the right, vertical bars and on the top"),
	HUDDIRRIGHT ("HUDdirRight", "Right", "Horizontal bars shrinks/fills on the right side"),
	HUDDIRLEFT ("HUDdirLeft", "Left", "Horizontal bars shrinks/fills on the left side"),
	HUDDIRTOP ("HUDdirTop", "Top", "Vertical bars shrinks/fills on the top"),
	HUDDIRBOTTOM ("HUDdirBottom", "Bottom", "Vertical bars shrinks/fills on the bottom"),
	HUDDIRBOTH ("HUDdirBoth", "Both", "Horizontal bars shrinks/fills on the left and right sides, vertical bars and on the top and bottom sides"),
	HUDDIRSWITCHED ("HUDdirSwitched", "Switched", "Used for bars of type HUDbarCentered, to have it flipped vertically"),
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenDirection (String code, String name, String description){
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
