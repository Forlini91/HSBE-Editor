package enums;

import interfaces.Token;


/**
 * All possible font sizes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenTextSize implements Token {
	
	SHUDDEFAULT ("HUDdefault", "Default", "Use the global font size"),
	S8 ("8", "8", "Doesn't work with the vanilla font"),
	S10 ("10", "10", "Doesn't work with the vanilla font"),
	S12 ("12", "12", "Doesn't work with the vanilla font"),
	S14 ("14", "14", "Doesn't work with the vanilla font"),
	S16 ("16", "16", "Doesn't work with the vanilla font"),
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenTextSize (String code, String name, String description){
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
