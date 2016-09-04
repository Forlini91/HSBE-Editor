package enums;

import interfaces.Token;

/**
 * All possible colors
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenColor implements Token {

	HUDNONE(0, ""),
	HUDCOLORGREEN(1, "Green"),
	HUDCOLORHEALTH(2, "Health"),
	HUDCOLORBLUE(3, "Blue"),
	HUDCOLORCYAN(4, "Cyan"),
	HUDCOLORRED(5, "Red"),
	HUDCOLORBROWN(6, "Brown"),
	HUDCOLORYELLOW(7, "Yellow"),
	HUDCOLORPURPLE(8, "Purple"),
	HUDCOLORPINK(9, "Pink"),
	HUDCOLORORANGE(10, "Orange"),
	HUDCOLORLIME(11, "Lime"),
	HUDCOLORRHUBARB(12, "Rhubarb"),
	HUDCOLORWHITE(13, "White"),
	HUDCOLORGRAY(14, "Gray"),
	HUDCOLORBLACK(15, "Black")
	;

	public final int code;
	public final String name;

	TokenColor (int code, String name){
		this.code = code;
		this.name = name;
	}

	@Override
	public String toCode(){
		return "HUDcolor" + name;
	}
	
	@Override
	public String toString(){
		if (code > 0){
			return code + " - " + name;
		}
		return "";
	}
	
}
