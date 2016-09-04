package core;

import enums.TokenQF;
import enums.TokenRef;


/**
 * Quick Function
 * @author MarcoForlini
 */
public class QF {
	
	/** The prefix */
	public final String prefix;

	/** The QF type */
	public final TokenQF token;

	/** If true, the QF is negated */
	public final boolean negate;

	/** The type of caller */
	public final TokenRef caller;

	/** The parameters */
	public final String[] params;


	/**
	 * Create a new QF
	 * @param token		The QF type
	 * @param negate	If true, the QF is negated
	 * @param caller	The type of caller
	 * @param params	The parameters
	 */
	public QF(TokenQF token, boolean negate, TokenRef caller, String...params){
		this("", token, negate, caller, params);
	}

	/**
	 * Create a new QF
	 * @param prefix 	The prefix
	 * @param token		The QF type
	 * @param negate	If true, the QF is negated
	 * @param caller	The type of caller
	 * @param params	The parameters
	 */
	public QF(String prefix, TokenQF token, boolean negate, TokenRef caller, String...params){
		this.prefix = prefix;
		this.token = token;
		this.negate = negate;
		this.caller = caller;
		this.params = params;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(prefix);
		if (negate){
			sb.append('!');
		}
		if (caller == null){
			sb.append('$');
		} else {
			sb.append(caller.toCode());
		}
		sb.append(token.toCode());
		for (String param : params){
			sb.append(' ').append(param);
		}
		return sb.toString();
	}
	
}
