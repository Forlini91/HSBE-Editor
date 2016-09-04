package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

import enums.TokenField;
import enums.TokenFieldType;
import ui_frames.AbstractBarPanel;
import ui_frames.IniEditor;

/**
 * Represent a single bar
 * @author MarcoForlini
 */
public class Bar implements Comparable<Bar> {
	
	private int i;
	private String name;
	private String description = "";
	private Map<TokenField, Field> fields = new TreeMap<>();
	private boolean enabled = true;
	private boolean selected = false;
	private boolean nameSet = false;
	private AbstractBarPanel panel = null;
	
	
	
	/**
	 * Create a new bar
	 * @param name			The bar
	 * @param description	The description
	 * @param i				The bar index
	 */
	public Bar (String name, String description, int i){
		this.i = i;
		this.name = name;
		this.description = description;
		nameSet = false;
	}
	
	/**
	 * Create a new bar
	 * @param name	The bar
	 * @param i		The bar index
	 * @param sc	The scanner to read
	 */
	public Bar (String name, int i, Scanner sc){
		this(name, "", i);
		readCode(sc);
	}
	
	/**
	 * Create a new bar
	 * @param code	The code to be parsed
	 * @param i		The bar index
	 */
	public Bar(String code, int i){
		this.i = i;
		readCode(code);
		if (numFields() <= 0){
			name = code;
		}
	}

	/**
	 * Create a new bar by cloning another one
	 * @param bar	The bar to clone
	 * @param i		The bar index
	 */
	public Bar(Bar bar, int i){
		this.i = i;
		name = bar.name;
		description = bar.description;
		fields = new HashMap<>(bar.fields);
		enabled = bar.enabled;
		nameSet = true;
	}


	/**
	 * Get the index
	 * @return	the index
	 */
	public int getI () {
		return i;
	}

	/**
	 * Set the index
	 * @param i		The new index
	 */
	public void setI (int i) {
		this.i = i;
	}

	/**
	 * Get the name
	 * @return	The name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Set the name
	 * @param name	The new name
	 */
	public void setName(String name){
		nameSet = true;
		this.name = name;
	}

	/**
	 * Get the description
	 * @return	the description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set the description
	 * @param description	The new description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	 * Add to the existing description
	 * @param description	The description to add
	 */
	public void addDescription(String description){
		this.description += description;
	}
	
	/**
	 * Enable/Disable the bar
	 * @param enabled	The new state
	 */
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	/**
	 * Check if the bar is enabled
	 * @return	true if enabled, false otherwise
	 */
	public boolean isEnabled(){
		return enabled;
	}
	
	/**
	 * Check if the bar is selected in the GUI
	 * @return	true if selected, false otherwise
	 */
	public boolean isSelected () {
		return selected;
	}

	/**
	 * Set/Unset the selection flag
	 * @param selected	true to set the flag, false to unset it
	 */
	public void setSelected (boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * Set the nameSet flag
	 * @param nameSet	the new flat state
	 */
	public void nameIsSet(boolean nameSet){
		this.nameSet = nameSet;
	}

	/**
	 * Check the nameSet flag
	 * @return	true if the flag is set, false otherwise
	 */
	public boolean isNameSet(){
		return nameSet;
	}

	/**
	 * Get the associated bar panel in the GUI
	 * @return	The associated bar panel in the GUI
	 */
	public AbstractBarPanel getPanel(){
		return panel;
	}
	
	/**
	 * Associate to this gui panel from the GUI
	 * @param panel		The panel to associate
	 */
	public void setPanel(AbstractBarPanel panel){
		this.panel = panel;
	}
	
	
	
	
	/**
	 * Get the value associated to the given field
	 * Will return null if the field has not been used in the bar
	 * @param field		The field
	 * @return			The value if defined, null otherwise.
	 */
	public Field get(TokenField field){
		return fields.get(field);
	}

	/**
	 * Set a new value to the given field
	 * @param field		The field
	 * @param value		The new value
	 * @return			The previous value if any, null otherwise
	 */
	public Field set(TokenField field, Field value){
		return fields.put(field, value);
	}
	
	/**
	 * Delete the given field from the bar
	 * @param field		The field to delete
	 */
	public void unset(TokenField field){
		fields.remove(field);
	}
	
	/**
	 * Get the number of defined fields in the bar
	 * @return	The number of defined fields
	 */
	public int numFields(){
		return fields.size();
	}

	/**
	 * Convert the bar data to .ini code
	 * @return	The code to print in the file .ini
	 */
	public String toCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("; ===== ").append(name).append('\n');
		sb.append("; ").append(description).append('\n');
		int group = -1;
		int count = 0;
		for(Entry<TokenField, Field> field : fields.entrySet()){
			if (group == -1){
				group = field.getKey().group;
				count++;
			} else if (group == field.getKey().group) {
				if (count > IniEditor.maxGroup){
					sb.append('\n');
					count = 1;
				} else {
					count++;
				}
			} else {
				if (count > IniEditor.minGroup){
					sb.append('\n');
					count = 1;
				} else {
					count++;
				}
				group = field.getKey().group;
			}
			sb.append('\n');
			if (field.getValue().disabled){
				sb.append(';');
			}
			sb.append('\t').append(field.getKey().toCode(field.getValue()));
		}
		sb.append("\n\n\tSetStage tnoHSB 10\n");
		return sb.toString();
	}

	@Override
	public String toString(){
		return (i+1) + " - " + name;
	}
	
	@Override
	public int compareTo(Bar o){
		return (i == o.i) ? 0 : ((i < o.i) ? -1 : 1);
	}

	
	/**
	 * Update the associated panel in the GUI with the bar informations
	 */
	public void updatePanel(){
		if (panel != null){
			panel.label1.setText("" + (i+1));
			panel.label2.setText(name);
			panel.label3.setText(description);
		}
	}

	
	/**
	 * Read the scanner and build the bar data.
	 * Gives the bar a name if missing.
	 * @param sc	The scanner to read
	 */
	public void readCode(Scanner sc){
		nameSet = false;
		String line;
		while(sc.hasNextLine()){
			line = sc.nextLine();
			if (readLine(line)) {
				break;
			}
		}
		if (!nameSet){
			setName("Bar " + i);
		}
	}
	
	/**
	 * Read and parse the given string/code and build the bar data
	 * Gives the bar a name if missing.
	 * @param code	The code to parse
	 */
	public void readCode(String code){
		try(Scanner sc = new Scanner(code)){
			nameSet = false;
			while(sc.hasNextLine()){
				if (readLine(sc.nextLine())) {
					break;
				}
			}
		}
		if (!nameSet){
			setName("Bar " + i);
		}
	}

	/**
	 * Read and parse the given line of code and set field (if it's a valid line)
	 * @param line		The line read
	 * @return			true if the line is a valid field assignment, false otherwise
	 */
	public boolean readLine(String line){
		TokenField tokenField = null;
		String lineTab = line.replace('\t', ' ').trim();
		String lineLc = lineTab.toLowerCase();
		boolean disabled = false;
		if (lineTab.isEmpty()){
			return false;
		} else if (lineTab.charAt(0) == ';'){
			lineTab = lineTab.substring(1).trim();
			if (numFields() == 0){
				if (!isNameSet()) {
					if (lineTab.matches("(=)+.*[^; =]+.*")){
						lineTab = lineTab.replace('=', ' ').trim();
						setName(lineTab);
						return false;
					}
				} else if (!lineLc.contains("set tnohsb.hud_")){
					addDescription(lineTab);
					return false;
				}
			}
			disabled = true;
			lineLc = lineTab.toLowerCase();
		}
		
		if (lineLc.equals("setstage tnohsb 10")){
			return true;
		} else if (lineLc.startsWith("set ")){
			StringTokenizer st = new StringTokenizer(lineTab, "_");
			try{
				st.nextToken();	//drop "set tnoHSB_"
				lineTab = st.nextToken(" ").substring(1).toUpperCase();	//take "<field name>"
				tokenField = TokenField.valueOf(lineTab);
				st.nextToken();	//drop "to"
				if (tokenField.type == TokenFieldType.EXPRESSION || tokenField.type == TokenFieldType.TEXT){
					st.nextToken("\""); //drop "sv_Construct"
					lineTab = st.nextToken("").trim();  //take ""<text/expression>""
					lineTab = lineTab.substring(1, lineTab.length()-1); //remove surrounding ""
				} else {
					lineTab = st.nextToken("").trim(); //take "<numeric value>"
				}
				set(tokenField, new Field(lineTab, disabled));
			} catch (Exception e){
				System.out.println(this + " | " + line + '\n' + e.getMessage());
				return false;
			}
		}
		return false;
	}
	
}
