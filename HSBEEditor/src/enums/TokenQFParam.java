package enums;


/**
 * All possible QF parameters
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenQFParam {
	
	DX_KEYCODE2("DX scancode", "The <url=http://cs.elderscrolls.com/index.php?title=IsKeyPressed2>DX scancode</url> for the chosen key"),
	DX_KEYCODE3("DX scancode", "The <url=http://cs.elderscrolls.com/index.php?title=IsKeyPressed3>DX scancode</url> for the chosen key"),
	CONTROL_CODE("Control code", "The <url=http://cs.elderscrolls.com/index.php?title=IsControlPressed>control code</url>"),
	HEALTH_FRAC("HealthFrac", "A number between 0 and 1 which represent the percent of remaining health"),
	AV_CODE("AV Code", "The <url=http://cs.elderscrolls.com/index.php?title=Category:Actor_Values>AV code</url>"),
	VALUE_CODE_D("Value code", "The <url=http://cs.elderscrolls.com/index.php?title=GetObjectValue>value code</url>"),
	SLOT_CODE_D("Slot code", "The <url=http://cs.elderscrolls.com/index.php?title=GetObjectValue>slot code</url>"),
	SLOT_CODE("Slot code", "The <url=http://cs.elderscrolls.com/index.php?title=GetEquippedObject>slot code</url>"),
	ITEM("Item", "The item base object"),
	WEAPON_TYPE("Weapon type", "The <url=http://cs.elderscrolls.com/index.php?title=GetWeaponType>type</url> of the weapon"),
	STATS_CODE("Stats code", "The <url=http://cs.elderscrolls.com/index.php?title=GetPCMiscStat>stats code</url>"),
	;

	public final String name;
	public final String description;
	
	TokenQFParam(String name, String description){
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString(){
		return name;
	}
	
}