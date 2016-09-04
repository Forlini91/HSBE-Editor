package enums;

import interfaces.Token;


/**
 * All possible visible_on reference monitor modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenVisRef implements Token {

	VR ("", "No ref", "Don't monitor references"),
	VR1("hud_ref1", "Monitor hud_ref", "Update visibility if hud_ref change"),
	VR2("hud_ref2", "Monitor hud_ref_2", "Update visibility if hud_ref_2 change"),
	VRE("hud_refE", "Monitor either hud_ref or hud_ref_2", "Update visibility if either hud_ref or hud_ref_2 change"),
	VRB("hud_refB", "Monitor both hud_ref and hud_ref_2", "Update visibility if both hud_ref and hud_ref_2 change"),
	;

	public final String code;
	public final String name;
	public final String description;
	
	TokenVisRef (String code, String name, String description){
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
