package enums;

import java.util.Map;

import interfaces.Token;

/**
 * All supported fonts
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenFont implements Token {

	FHUDDEFAULT ("HUDdefault", "Default", "Use the global font"),
	FHUDFONTSIMPLE ("HUDfontSimple", "Sans Serif", "A simple, sans serif font"),
	FHUDFONTKINGTHINGS ("HUDfontKingthings", "Kingthings Petrock", "The Kingthings Petrock font"),
	F1 ("1", "Font 1", "Standard Oblivion font"),
	F2 ("2", "Font 2", "Standard Oblivion font"),
	F3 ("3", "Font 3", "Standard Oblivion font"),
	F4 ("4", "Font 4", "Standard Oblivion font"),
	F5 ("5", "Font 5", "Standard Oblivion font"),
	;

	public final String code;
	public final String name;
	public final String description;
	public static Map<String, TokenFont> map;

	TokenFont (String code, String name, String description){
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
