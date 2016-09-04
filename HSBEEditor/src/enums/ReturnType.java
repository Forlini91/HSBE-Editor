package enums;


/**
 * All possible fields return types
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum ReturnType {

	BOOL("0 or 1"),
	INT("Integer"),
	FLOAT("Float"),
	REF("Base object or Reference"),
	ARMORER ("1.25 if Armorer >= 75, 1 otherwise"),
	RANGE_0_5 ("An integer between 0 and 5"),
	RANGE_0_6 ("An integer between 0 and 6"),
	RANGE_0_31 ("An integer between 0 and 31"),
	RANGE_0_24 ("A float between 0 and 24"),
	RANGE_0_100 ("A number between 0 and 100"),
	MULTI ("Anything")
	;
	
	public final String description;

	ReturnType(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
}
