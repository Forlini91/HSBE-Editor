package enums;

import interfaces.Token;


/**
 * All possible TextDisplay modes
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenTextDisplay implements Token {

	HUDDEFAULT ("HUDdefault", "Default", "HUDtxtNoValue if bar is visible, HUDtxtValue if only text is visible"),
	HUDTXTNOVALUE ("HUDtxtNoValue", "Only name/name2. No value", "Only display the text given in hud_name, not the current value"),
	HUDTXTVALUE ("HUDtxtValue", "Value - no decimals", "Display the value"),
	HUDTXTVALUE1 ("HUDtxtValue1", "Value - 1 decimal", "Display the value with 1 decimal"),
	HUDTXTVALUE2 ("HUDtxtValue2", "Value - 2 decimals", "Display the value with 2 decimals"),
	HUDTXTVALUEREAL ("HUDtxtValueReal", "Value - all decimals", "Display the value with all decimals"),
	HUDTXTVALUEOFMAX ("HUDtxtValueOfMax", "Value/Max - no decimals", "Display as <value> <of> <max> (no decimals), where <of> is the text set in tnoHSB.textDivider (default: \" of \")"),
	HUDTXTVALUEOFMAX1 ("HUDtxtValueOfMax1", "Value/Max - 1 decimal", "Display as <value> <of> <max> (with 1 decimal), where <of> is the text set in tnoHSB.textDivider (default: \" of \")"),
	HUDTXTVALUEOFMAX2 ("HUDtxtValueOfMax2", "Value/Max - 2 decimals", "Display as <value> <of> <max> (with 2 decimals), where <of> is the text set in tnoHSB.textDivider (default: \" of \")"),
	HUDTXTVALUEOFMAXREAL ("HUDtxtValueOfMaxReal", "Value/Max - all decimals", "Display as <value> <of> <max> (with all decimals), where <of> is the text set in tnoHSB.textDivider (default: \" of \")"),
	HUDTXTPERCENT ("HUDtxtPercent", "Percent - no decimals", "Display value in percent of max without decimals"),
	HUDTXTPERCENT1 ("HUDtxtPercent1", "Percent - 1 decimal", "Display value in percent of max with 1 decimal"),
	HUDTXTPERCENT2 ("HUDtxtPercent2", "Percent - 2 decimals", "Display value in percent of max with 2 decimals"),
	HUDTXTPERCENTREAL ("HUDtxtPercentReal", "Percent - all decimals", "Display value in percent of max with all decimals"),
	HUDTXTTIME2 ("HUDtxtTime2", "HH:MM, 24H", "Display the value in time format HH:MM in 24H format"),
	HUDTXTTIME3 ("HUDtxtTime3", "HH:MM:SS, 24H", "Display the value in time format HH:MM:SS in 24H format"),
	HUDTXTTIME2H12 ("HUDtxtTime2H12", "HH:MM, 12H", "Display the value in time format HH:MM in 12H format (with am/pm)"),
	HUDTXTTIME3H12 ("HUDtxtTime3H12", "HH:MM:SS, 12H", "Display the value in time format HH:MM:SS in 12H format (with am/pm)"),
	HUDTXTTIME02 ("HUDtxtTime02", "HH:MM, 24H (with trailing 0)", "Display the value in time format HH:MM in 24H format, with a trailing 0 in the hour (if needed)"),
	HUDTXTTIME03 ("HUDtxtTime03", "HH:MM:SS, 24H (with trailing 0)", "Display the value in time format HH:MM:SS in 24H format, with a trailing 0 in the hour (if needed)"),
	HUDTXTTIME02H12 ("HUDtxtTime02H12", "HH:MM, 12H (with trailing 0)", "Display the value in time format HH:MM in 12H format (with am/pm), with a trailing 0 in the hour (if needed)"),
	HUDTXTTIME03H12 ("HUDtxtTime03H12", "HH:MM:SS, 12H (with trailing 0)", "Display the value in time format HH:MM in 12H format (with am/pm), with a trailing 0 in the hour (if needed)"),
	HUDTXTDAYOFWEEK ("HUDtxtDayOfWeek", "Day of week - Game", "Display the game day of week in the game language/alphabet"),
	HUDTXTDAYOFWEEKENG ("HUDtxtDayOfWeekEng", "Day of week - English", "Display the game day of week in english"),
	HUDTXTDAYOFWEEKITA ("HUDtxtDayOfWeekIta", "Day of week - Italian", "Display the game day of week in italian"),
	HUDTXTMONTH ("HUDtxtMonth", "Month - Game", "Display the game month in the game language/alphabet"),
	HUDTXTMONTHENG ("HUDtxtMonthEng", "Month - English", "Display the game month in the english"),
	HUDTXTMONTHITA ("HUDtxtMonthIta", "Month - Italian", "Display the game month in the italian"),
	;

	public final String code;
	public final String name;
	public final String description;

	TokenTextDisplay (String code, String name, String description){
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
