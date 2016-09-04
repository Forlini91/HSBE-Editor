package enums;

import interfaces.Token;

/**
 * All possible Y positions
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenY implements Token {

	HUDDEFAULT ("HUDdefault", "Default", "Above the previous bar (or standard bars for first bar). However, if direction is changed to down, it will be below previous bar instead. Any value marked with + or - changes the direction to up (+) or down (-) for following bars"),
	HUDPREVBAR ("HUDprevBar", "Previous bar", "Top of bar is aligned with previous defined bar"),
	HUDPREVBARLOW ("HUDprevBarLow", "Previous bar - low", "Bottom of bar is aligned with previous defined bar"),
	HUDPREVBARABOVE ("HUDprevBarAbove", "Previous bar - above +", "Above the previously defined bar"),
	HUDPREVBARBELOW ("HUDprevBarBelow", "Previous bar - below -", "Below the previously defined bar"),
	HUDBARSABOVE ("HUDbarsAbove", "Standard/stored bar - above +", "Above the standard bars/the last bar with hud_store_pos set"),
	HUDBARSBELOW ("HUDbarsBelow", "Standard/stored bar - below -", "Below the standard bars/the last bar with hud_store_pos set"),
	HUDBARSHIGH ("HUDbarsHigh", "Standard/stored bar - high", "Top of bar is aligned with the health bar/the last bar with hud_store_pos set"),
	HUDBARSLOW ("HUDbarsLow", "Standard/stored bar - low", "Bottom of bar is aligned with the fatigue bar/the last bar with hud_store_pos set"),
	HUDBARS2ABOVE ("HUDbars2Above", "Standard bar - above +", "As HUDbarsAbove, but ignore \"tnoHSB.hud_store_pos\""),
	HUDBARS2BELOW ("HUDbars2Below", "Standard bar - below -", "As HUDbarsBelow, but ignore \"tnoHSB.hud_store_pos\""),
	HUDBARS2HIGH ("HUDbars2High", "Standard bar - high", "As HUDbarsHigh, but ignore \"tnoHSB.hud_store_pos\""),
	HUDBARS2LOW ("HUDbars2Low", "Standard bar - low", "As HUDbarsLow, but ignore \"tnoHSB.hud_store_pos\""),
	HUDWEAPONABOVE ("HUDweaponAbove", "Weapon icon - above", "Above the weapon icon"),
	HUDWEAPONBELOW ("HUDweaponBelow", "Weapon icon - below", "Below the weapon icon"),
	HUDWEAPONCENTER ("HUDweaponCenter", "Weapon icon - center", "Centered relative to the weapon icon"),
	HUDWEAPONHIGH ("HUDweaponHigh", "Weapon icon - high", "Top of bar is aligned with top of the weapon icon"),
	HUDWEAPONLOW ("HUDweaponLow", "Weapon icon - low", "Bottom of bar is aligned with bottom of the weapon icon"),
	HUDMAGICABOVE ("HUDmagicAbove", "Magic icon - above", "Above the magic icon"),
	HUDMAGICBELOW ("HUDmagicBelow", "Magic icon - below", "Below the magic icon"),
	HUDMAGICCENTER ("HUDmagicCenter", "Magic icon - center", "Centered relative to the magic icon"),
	HUDCOMPASSABOVE ("HUDcompassAbove", "Compass - above", "Above the compass"),
	HUDCOMPASSBELOW ("HUDcompassBelow", "Compass - below", "Below the compass"),
	HUDCOMPASSCENTER ("HUDcompassCenter", "Compass - center", "Centered relative to the compass"),
	HUDCOMPASSHIGH ("HUDcompassHigh", "Compass - high", "Top of bar is aligned with top of the compass"),
	HUDCOMPASSLOW ("HUDcompassLow", "Compass - low", "Bottom of bar is aligned with bottom of the compass"),
	HUDEFFECTSBELOW ("HUDeffectsBelow", "Active effects - below", "Below the magic effects icons"),
	HUDNAMEABOVE ("HUDnameAbove", "Reticle name - above", "Above the name (of the item currently in the reticle)"),
	HUDNAMEBELOW ("HUDnameBelow", "Reticle name - below", "Below the name"),
	HUDNOTICEBELOW ("HUDnoticeBelow", "Messages - below (stack)", "Position the bar below the notice/messages in the upper-left corner of the screen. It automatically stack below all previous bars with this same position."),
	HUDNOTICEBELOW2 ("HUDnoticeBelow2", "Messages - below (don't stack)", "As HUDnoticeBelow, but it doesn't stack and ignore the other bars with the same position."),
	;

	public final String code;
	public final String name;
	public final String description;

	TokenY (String code, String name, String description){
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
