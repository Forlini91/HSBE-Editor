package core;


/**
 * Represents a field with a value and comment
 * @author MarcoForlini
 */
public class Field {
	
	/** Disabled flag */
	public final boolean disabled;

	/** Field value */
	public final String value;

	/** Field comment */
	public final String comment;
	
	/**
	 * Create a new Field
	 * @param value		The value
	 */
	public Field (String value){
		this(value, "", false);
	}
	
	/**
	 * Create a new Field
	 * @param value		The value
	 * @param comment	The comment
	 */
	public Field (String value, String comment){
		this(value, comment, false);
	}

	/**
	 * Create a new Field
	 * @param value		The value
	 * @param disabled	The disabled flag
	 */
	public Field (String value, boolean disabled){
		this(value, "", disabled);
	}
	
	/**
	 * Create a new Field
	 * @param value		The value
	 * @param comment	The comment
	 * @param disabled	The disabled flag
	 */
	public Field (String value, String comment, boolean disabled){
		this.value = value;
		this.disabled = disabled;
		this.comment = comment;
	}

	@Override
	public String toString(){
		return value + (comment.isEmpty() ? "" : "\t\t; " + comment);
	}
	
}
