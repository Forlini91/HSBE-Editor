package enums;

import java.util.Arrays;

import interfaces.Token;
import ui_frames.IniEditor;

/**
 * All fields you can define in the file ini
 * @author MarcoForlini
 */
@SuppressWarnings ("javadoc")
public enum TokenField implements Token {
	
	ID (0, "ID", "A unique ID to identify the bar in scripts", TokenFieldType.TEXT),
	TYPE (0, "type", "Type of the bar", TokenFieldType.NUMBER),
	DIRECTION (0, "direction", "How the bar fill", TokenFieldType.TOKEN),
	
	REF (1, "ref", "Object reference/base 1",TokenFieldType.EXPRESSION),
	REF_2 (1, "ref_2", "Object reference/base 2. If you don't use a reference, every command there automatically use hud_ref as base", TokenFieldType.EXPRESSION),
	TMP (1, "tmp", "Temporary variable 1, where you can store a value to be used in another field", TokenFieldType.EXPRESSION),
	TMP_2 (1, "tmp_2", "Temporary variable 2, where you can store a value to be used in another field. Can use tnoHSB.tmp.", TokenFieldType.EXPRESSION),
	MIN (1, "min", "How to calculate the max value", TokenFieldType.EXPRESSION),
	MAX (1, "max", "How to calculate the min value", TokenFieldType.EXPRESSION),
	VAL (1, "val", "How to calculate the current value", TokenFieldType.EXPRESSION),
	SPELL_EFFECT (1, "spell_effect", "What spell effect to use with the type HUDbarEffectIcon.", TokenFieldType.TOKEN),
	QUEST (1, "quest", "Quest ID", TokenFieldType.TEXT),
	
	VISIBLE (2, "visible", "Visibility condition", TokenFieldType.EXPRESSION),
	VISIBLE_ON (2, "visible_on", "Trigger visibility if the ref/result of this field change", TokenFieldType.EXPRESSION),
	VISIBLE_TIME (2, "visible_time", "How many seconds the bar stay visible if visibility become false?", TokenFieldType.NUMBER),
	VISIBLE_FIRST (2, "visible_first", "If checked, all bar visibility fields will be checked immediately, before any other field, but you can't use any field result.", TokenFieldType.FLAG),

	COLOR (3, "color", "If result is 0, the bar is hidden, else the result must be between 1 and 15 for the corresponding color.", TokenFieldType.EXPRESSION),
	COLOR_R (3, "color_r", "(RGB) Red color", TokenFieldType.EXPRESSION),
	COLOR_G (3, "color_g", "(RGB) Green color", TokenFieldType.EXPRESSION),
	COLOR_B (3, "color_b", "(RGB) Blue color", TokenFieldType.EXPRESSION),
	COLOR_EMPTY (3, "color_empty", "What color the bar will be if frac is <= 0?", TokenFieldType.TOKEN),
	COLOR_MIN (3, "color_min", "What color the bar will be if frac is <= \"color_low\"", TokenFieldType.TOKEN),
	COLOR_HALF (3, "color_half", "What color the bar will be if frac is between \"color_midLow\" and \"color_midHigh\"?", TokenFieldType.TOKEN),
	COLOR_MAX (3, "color_max", "What color the bar will be if frac is >= \"color_high\"?", TokenFieldType.TOKEN),
	COLOR_FULL (3, "color_full", "What color the bar will be if frac is 100%?", TokenFieldType.TOKEN),
	COLOR_LOW (3, "color_low", "If frac <= this, the bar color will be exactly color_min (or color_empty, if frac is <= 0)", TokenFieldType.TOKEN),
	COLOR_MIDLOW (3, "color_midLow", "If frac is between \"color_low\" and \"color_midLow\", the bar will fade between \"color_min\" and \"color_half\"", TokenFieldType.TOKEN),
	COLOR_MIDHIGH (3, "color_midHigh", "If frac is between \"color_midHigh\" and \"color_high\", the bar will fade between \"color_half\" and \"color_max\"", TokenFieldType.TOKEN),
	COLOR_HIGH (3, "color_high",  "If frac >= this, the bar color will be exactly color_max (or color_full, if frac is >= 100%)", TokenFieldType.TOKEN),
	
	SIZE (4, "size", "Size of the bar. You can use a value between 0 and 100 or a token.", TokenFieldType.NUMBER),
	X (4, "x", "X position of the bar. You can use a percent between 0 and 100 or a token.", TokenFieldType.NUMBER),
	Y (4, "y", "Y position of the bar. You can use a percent between 0 and 100 or a token.", TokenFieldType.NUMBER),
	X_ADJUST (4, "x_adjust", "X position of the bar in pixels, will be added to the X value.", TokenFieldType.NUMBER),
	Y_ADJUST (4, "y_adjust", "Y position of the bar in pixels, will be added to the Y value.", TokenFieldType.NUMBER),
	DEPTH (4, "depth", "Depth of the bar", TokenFieldType.NUMBER),

	ALPHA (5, "alpha", "Bar's (max) alpha, a value between 0 and 255", TokenFieldType.NUMBER),
	ALPHA_MIN (5, "alpha_min", "Bar's min alpha, a value between 0 and 255", TokenFieldType.NUMBER),
	ALPHA_INV (5, "alpha_inv", "If frac <= this, the bar's alpha will be \"alpha_min\"", TokenFieldType.NUMBER),
	ALPHA_VIS (5, "alpha_vis", "If frac >= this, the bar's alpha will be \"alpha_max\"", TokenFieldType.NUMBER),

	SPEED (6, "speed", "How fast the bar will update the current value/fill. If 0: instant update value and fill; if < 0 instant update value and fade fill; if > 0 fade both value and fill.", TokenFieldType.NUMBER),
	FADE_IN (6, "fade_in", "How fast the bar will fade in when it become visible?", TokenFieldType.NUMBER),
	FADE_OUT (6, "fade_out", "How fast the bar will fade out when it become invisible?",  TokenFieldType.NUMBER),
	POPUP_IN (6, "popup_in", "How fast the bar will enter the screen when it become visible?", TokenFieldType.NUMBER),
	POPUP_OUT (6, "popup_out", "How fast the bar will exit the screen when it become invisible?", TokenFieldType.NUMBER),
	POPUP_DIRIN (6, "popup_dirin", "From which screen border the bar will enter when it become visible?", TokenFieldType.TOKEN),
	POPUP_DIROUT (6, "popup_dirout", "From which screen border the bar will exit when it become invisible", TokenFieldType.TOKEN),
	BLINK (6, "blink", "If result is > 0, the bar will blink. The blink speed depends on the result itself.", TokenFieldType.EXPRESSION),

	NAME (7, "name", "Bar text to be displayed before the value", TokenFieldType.TEXT),
	NAME_2 (7, "name_2", "Bar text to be displayed after the value", TokenFieldType.TEXT),
	TEXTDISPLAY (7, "textDisplay", "What value will be displayed?", TokenFieldType.TOKEN),
	TEXTTYPE (7, "textType", "Font of the text", TokenFieldType.TOKEN),
	TEXTSIZE (7, "textSize", "Size of the text (Ineffective with vanilla fonts)", TokenFieldType.TOKEN),
	TEXTCOLOR (7, "textColor", "Color of the text. Same rules as the \"color\" field. If result is 0, the text is hidden (but not the bar).", TokenFieldType.EXPRESSION),
	TEXTPOS_X (7, "textPos_x", "X position of the text", TokenFieldType.TOKEN),
	TEXTPOS_Y (7, "textPos_y", "Y position of the text", TokenFieldType.TOKEN),
	TEXTADJUST_X (7, "textAdjust_x", "X position of the text in pixels, to be added to the X value.", TokenFieldType.NUMBER),
	TEXTADJUST_Y (7, "textAdjust_y", "Y position of the text in pixels, to be added to the Y value.", TokenFieldType.NUMBER),
	TEXTSHADOWCOLOR (7, "textShadowColor", "Color of the text's shadow.", TokenFieldType.EXPRESSION),
	TEXTSHADOW_X (7, "textShadow_x", "Text shadow offset from the text", TokenFieldType.NUMBER),
	TEXTSHADOW_Y (7, "textShadow_y", "Text shadow offset from the text", TokenFieldType.NUMBER),
	TEXTWRAPWIDTH(7, "textWrapWidth", "Max width in pixels for the bar's text field", TokenFieldType.NUMBER),
	TEXTWRAPLINES(7, "textWrapLines", "Max lines for the bar's text field", TokenFieldType.NUMBER),
	
	CUSTOM (8, "custom", "Custom bar fill filepath", TokenFieldType.TEXT),
	CUSTOM_BACK (8, "custom_back", "Custom bar background filepath", TokenFieldType.TEXT),
	CUSTOM_EDGE (8, "custom_edge", "Custom bar edge filepath", TokenFieldType.TEXT),
	CUSTOM_FRONT (8, "custom_front", "Custom bar fill filepath", TokenFieldType.TEXT),
	CUSTOM_W (8, "custom_w", "Custom bar fill width", TokenFieldType.NUMBER),
	CUSTOM_H (8, "custom_h", "Custom bar fill height", TokenFieldType.NUMBER),
	CUSTOM_BW (8, "custom_bw", "Custom bar background width", TokenFieldType.NUMBER),
	CUSTOM_BH (8, "custom_bh", "Custom bar background height", TokenFieldType.NUMBER),
	CUSTOM_EW (8, "custom_ew", "Custom bar edge width", TokenFieldType.NUMBER),
	CUSTOM_EH (8, "custom_eh", "Custom bar edge height", TokenFieldType.NUMBER),
	CUSTOM_EO (8, "custom_eo", "Offset of the edge texture", TokenFieldType.NUMBER),
	CUSTOM_X (8, "custom_x", "Custom bar x offset (the distance between the left of the background and the left of the filled bar)", TokenFieldType.NUMBER),
	CUSTOM_Y (8, "custom_y", "Custom bar y offset (the distance between the top of the background and the top of the filled bar)", TokenFieldType.NUMBER),
	CUSTOM_OFFSET (8, "custom_offset", "How much of the filled bar should be visible when bar is empty", TokenFieldType.NUMBER),

	STORE_POS (9, "store_pos", "Store this bar position in \"HUDbars\"", TokenFieldType.FLAG),
	UPDATEINTERVAL (9, "updateInterval", "The bar will update every X seconds", TokenFieldType.NUMBER),
	DEBUG (9, "debug", "1 to enable the bar debug, 2 to also obtian some initialization informations", TokenFieldType.TOKEN)
	;

	public final int group;
	public final String code;
	public final String description;
	public final TokenFieldType type;
	
	public static final char[] CODE_SET = "set tnoHSB.hud_".toCharArray();
	public static final char[] CODE_TO1 = " to sv_Construct".toCharArray();
	public static final char[] CODE_TO2 = " to".toCharArray();

	TokenField (int group, String code, String description, TokenFieldType type){
		this.group = group;
		this.code = code;
		this.description = description;
		this.type = type;
	}

	@Override
	public String toString(){
		return code;
	}

	@Override
	public String toCode(){
		return code;
	}
	
	public String toCode(Object field){
		final int minSize = 50;
		int c = 16 + code.length();
		if (type == TokenFieldType.EXPRESSION || type == TokenFieldType.TEXT){
			c += 16;
			return new StringBuilder(minSize).append(CODE_SET).append(code).append(CODE_TO1).append(getSpaces(minSize-c)).append('\"').append(field).append('\"').toString();
		}
		return new StringBuilder(minSize).append(CODE_SET).append(code).append(CODE_TO2).append(getSpaces(minSize-c)).append(field).toString();
	}
	
	public static String getSpaces(int c){
		int t = 1 + (int) Math.ceil(c / (float)IniEditor.tabSize);
		try{
			char[] spaces = new char[t];
			Arrays.fill(spaces, 0, t, '\t');
			return new String(spaces);
		} catch (Exception e){
			System.out.println("Negative: " + t);
			return " ";
		}

	}
	
}
