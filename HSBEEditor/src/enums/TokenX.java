package enums;

import interfaces.Token;

/**
 * All possible X positions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenX implements Token {
	
	HUDPREVBAR ("HUDprevBar", "Previous bar", "Same x pos as previous bar (or standard bars for first bar)"),
	HUDPREVBARLEFT ("HUDprevBarLeft", "Previous bar - left", "To the left of the previously defined bar"),
	HUDPREVBARRIGHT ("HUDprevBarRight", "Previous bar - right", "To the right of the previously defined bar"),
	HUDBARS ("HUDbars", "Standard/stored bars", "Same x pos as standard bars/the last bar with hud_store_pos set"),
	HUDBARSLEFT ("HUDbarsLeft", "Standard/stored bars - left", "To the left of standard bars/the last bar with hud_store_pos set"),
	HUDBARSRIGHT ("HUDbarsRight", "Standard/stored bars - right", "To the righ of standard bars/the last bar with hud_store_pos set"),
	HUDBARS2 ("HUDbars2", "Standard bars", "As HUDbars, but ignore \"tnoHSB.hud_store_pos\"."),
	HUDBARS2LEFT ("HUDbars2Left", "Standard bars - left", "As HUDbarsLeft, but ignore \"tnoHSB.hud_store_pos\""),
	HUDBARS2RIGHT ("HUDbars2Right", "Standard bars - right", "As HUDbarsLeft, but ignore \"tnoHSB.hud_store_pos\""),
	HUDWEAPONLEFT ("HUDweaponLeft", "Weapon icon - left", "To the left of the weapon icon"),
	HUDWEAPONRIGHT ("HUDweaponRight", "Weapon icon - right", "To the right of the weapon icon"),
	HUDWEAPONCENTER ("HUDweaponCenter", "Weapon icon - centered", "Centered relative to the weapon icon"),
	HUDMAGICLEFT ("HUDmagicLeft", "Magic icon - left", "To the left of the magic icon"),
	HUDMAGICRIGHT ("HUDmagicRight", "Magic icon - right", "To the right of the magic icon"),
	HUDMAGICCENTER ("HUDCenter", "Magic icon - centered", "Centered relative to the magic icon"),
	HUDCOMPASSLEFT ("HUDcompassLeft", "Compass - left", "To the left of the compass"),
	HUDCOMPASSRIGHT ("HUDcompassRight", "Compass - right", "To the right of the compass"),
	HUDCOMPASSCENTER ("HUDcompassCenter", "Compass - centered", "Centered relative to the compass"),
	HUDNAMECENTER ("HUDnameCenter", "Reticle name - centered", "Centered relative to the name (of the item currently in the reticle)"),
	HUDNOTICELEFT ("HUDnoticeLeft", "Messages - left", "Position the bar x as the notice/messages in the upper-left corner of the screen."),
	;
	
	public final String code;
	public final String name;
	public final String description;
	
	TokenX (String code, String name, String description){
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
