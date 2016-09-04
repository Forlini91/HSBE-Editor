package enums;

import interfaces.Token;

/**
 * All possible size modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenSize implements Token {

	HUDDEFAULT ("HUDdefault", "Default", "Same size as standard bars for horizontal, vertical and round bars, full size (100) for custom icons, icon_size (global setting) for HUDbarRefIcon and HUDbarEffectIcon icons."),
	HUDWEAPONWIDTH ("HUDweaponWidth", "Weapon widht", "Scaled down to make width the same as the weapon icon. Only use for horizontal/vertical bars."),
	HUDMAGICWIDTH ("HUDmagicWidth", "Magic widht", "Scaled down to make width the same as the magic icon. Only use for horizontal/vertical bars."),
	HUDCOMPASSWIDTH ("HUDCompassWidth", "Compass width", "Scaled to make width the same as the compass. Only use for horizontal/vertical bars."),
	;

	public final String code;
	public final String name;
	public final String description;

	TokenSize (String code, String name, String description){
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
