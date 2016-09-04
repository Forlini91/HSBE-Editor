package enums;

import interfaces.Token;


/**
 * All possible QF references
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenRef implements Token{

	R1 ("1$","Reference 1"),
	R2 ("2$","Reference 2"),
	RP ("P$","Player"),
	;

	public final String code;
	public final String name;

	TokenRef (String code, String name){
		this.code = code;
		this.name = name;
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
