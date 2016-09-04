package enums;

import interfaces.Token;

/**
 * All possible bar types
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenType implements Token {
	
	HUDDEFAULT ("HUDdefault", "Default", "If hud_custom is empty: HUDbarHorizontal, otherwise: 1 (a single, custom icon"),
	HUDBARHORIZONTAL ("HUDbarHorizontal", "Horizontal", "A standard horizontal bar"),
	HUDBARVERTICAL ("HUDbarVertical", "Vertical", "A standard bar, but vertical"),
	HUDBARCENTERED ("HUDbarCentered", "Centered", "A horizontal bar where the fill shrinks symmetrically on both sides"),
	HUDBARSMALL ("HUDbarSmall", "Small", "A smaller horizontal bar, made to look better when small"),
	HUDBARCIRCLE ("HUDbarCircle", "Circle", "A filled circle that shrink/grow"),
	HUDBARREFICON ("HUDbarRefIcon", "Ref icon", "The standard icon for the bar's reference. Works for inventory items, spells and summons. Get the icon from hud_ref."),
	HUDBARREFICON2 ("HUDbarRefIcon2", "Ref icon 2", "As HUDbarRefIcon, but get the icon from hud_ref2"),
	HUDBAREFFECTICON ("HUDbarEffectIcon", "Effect icon", "The icon for a spell effect. The effect is given in hud_spell_effect"),
	HUDTXTNOBAR ("HUDtxtNoBar", "Only text. No bar", "Only text, no bar. Same as using HUDtxtNoBar for hud_textPos_y"),
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenType (String code, String name, String description){
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
