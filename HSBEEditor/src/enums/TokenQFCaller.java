package enums;

/**
 * All possible QF callers
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenQFCaller {
	
	NOTHING ("Doesn't need a caller reference"),
	ACTOR ("Require an actor"),
	ITEM ("Require an object"),
	WEAPON ("Require a weapon"),
	ARMOR ("Require an armor"),
	ACTOR_OR_ITEM ("Require either an actor or an object"),
	ACTOR_OR_WEAPON ("Require either an actor or a weapon"),
	ACTOR_OR_LIGHT ("Require either an actor or a light"),
	ACTOR_AND_ITEM ("Require an actor in hud_ref and an object in hud_ref_2"),
	ACTOR_AND_ACTOR ("Require an actor in hud_ref and another actor in hud_ref_2"),
	ACTOR_AND_FACTION ("Require an actor in hud_ref and a faction in hud_ref_2"),
	;

	public final String description;
	
	TokenQFCaller(String description){
		this.description = description;
	}

	@Override
	public String toString(){
		return description;
	}

}
