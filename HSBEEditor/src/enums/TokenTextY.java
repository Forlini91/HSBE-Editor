package enums;

import interfaces.Token;

/**
 * All possible text Y positions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenTextY implements Token {
	
	HUDDEFAULT ("HUDdefault", "Default", "Use global setting"),
	HUDTXTABOVE ("HUDtxtAbove", "Above", "Above the bar"),
	HUDTXTBELOW ("HUDtxtBelow", "Below", "Below the bar"),
	HUDTXTCENTER ("HUDtxtCenter", "Center", "Center of the bar"),
	HUDTXTNOBAR ("HUDtxtNoBar", "Only text. No bar", "Only text, no bar. Same as using HUDtxtNoBar for hud_type")
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenTextY (String code, String name, String description){
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
