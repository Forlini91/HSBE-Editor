package ui_frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import core.Bar;
import core.QF;
import enums.TokenColor;
import enums.TokenDebug;
import enums.TokenDirection;
import enums.TokenField;
import enums.TokenFont;
import enums.TokenPopup;
import enums.TokenQF;
import enums.TokenSize;
import enums.TokenSpell;
import enums.TokenTextDisplay;
import enums.TokenTextSize;
import enums.TokenTextX;
import enums.TokenTextY;
import enums.TokenType;
import enums.TokenX;
import enums.TokenY;
import interfaces.JComponentEx;
import ui_elements.GridBagConstraintsExtended;
import ui_elements.GridBagLayoutExtended;
import ui_elements.JCheckBoxEx;
import ui_elements.JCheckBoxLabel;
import ui_elements.JComboBoxEx;
import ui_elements.JListEx;
import ui_elements.JSliderEx;
import ui_elements.JTextFieldEx;


/**
 * The bar editor
 * @author MarcoForlini
 */
@SuppressWarnings ("serial")
public class BarEditor extends AbstractFrame {
	
	private static final int colL1 = 0;
	private static final int colF1 = 1;
	private static final int colL2 = 3;
	private static final int colF2 = 4;

	
	private static final GridBagLayout gbl_panelInfo = new GridBagLayoutExtended(new int[] {10, 80}, new int[] {0, 40, 300, 0, 0, 0, 0}, new double[]{0, 1.0}, new double[]{0.0, 0.1, 0.9, 0.0, 0.0, 0.0, Double.MIN_VALUE});
	private static final GridBagLayout gbl_panelFields = new GridBagLayoutExtended(new int[] {30, 60, 5, 30, 60}, new double[] {0, 0.5, 0, 0, 0.5}, 44);
	private static final GridBagLayout gbl_panelExtL = new GridBagLayoutExtended(new int[]{50, 200}, new int[]{0}, new double[]{0.2, 0.8}, new double[]{1.0});
	private static final GridBagLayout gbl_panelExtR = new GridBagLayoutExtended(new int[]{200, 50}, new int[]{0}, new double[]{0.8, 0.2}, new double[]{1.0});


	private static final GridBagConstraints gbc_panelInfoL = new GridBagConstraintsExtended(0, 0, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_scrollPaneL = new GridBagConstraintsExtended(0, 0, 0, 5, 0, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_panelInfoR = new GridBagConstraintsExtended(0, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_scrollPaneR = new GridBagConstraintsExtended(0, 0, 0, 5, 0, 0, 1, 1, GridBagConstraints.BOTH);
	
	
	private static final GridBagConstraints gbc_chkId = new GridBagConstraintsExtended(5, 5, 5, 5, 0, colL1, true);
	private static final GridBagConstraints gbc_fieldID = new GridBagConstraintsExtended(5, 0, 5, 5, 0, colF1);
	private static final GridBagConstraints gbc_chkType = new GridBagConstraintsExtended(0, 5, 5, 5, 1, colL1, true);
	private static final GridBagConstraints gbc_fieldType = new GridBagConstraintsExtended(0, 0, 5, 5, 1, colF1);
	private static final GridBagConstraints gbc_chkDirection = new GridBagConstraintsExtended(0, 5, 5, 5, 2, colL1, true);
	private static final GridBagConstraints gbc_fieldDirection = new GridBagConstraintsExtended(0, 0, 5, 5, 2, colF1);
	
	private static final GridBagConstraints gbc_separator_1 = new GridBagConstraintsExtended(10, 0, 5, 5, 3, colL1, false);

	private static final GridBagConstraints gbc_chkRef = new GridBagConstraintsExtended(0, 5, 5, 5, 4, colL1, true);
	private static final GridBagConstraints gbc_fieldRef = new GridBagConstraintsExtended(0, 0, 5, 5, 4, colF1);
	private static final GridBagConstraints gbc_chkRef_2 = new GridBagConstraintsExtended(0, 5, 5, 5, 5, colL1, true);
	private static final GridBagConstraints gbc_fieldRef_2 = new GridBagConstraintsExtended(0, 0, 5, 5, 5, colF1);
	private static final GridBagConstraints gbc_chkTmp = new GridBagConstraintsExtended(0, 5, 5, 5, 6, colL1, true);
	private static final GridBagConstraints gbc_fieldTmp = new GridBagConstraintsExtended(0, 0, 5, 5, 6, colF1);
	private static final GridBagConstraints gbc_chkTmp_2 = new GridBagConstraintsExtended(0, 5, 5, 5, 7, colL1, true);
	private static final GridBagConstraints gbc_fieldTmp_2 = new GridBagConstraintsExtended(0, 0, 5, 5, 7, colF1);
	private static final GridBagConstraints gbc_chkMin = new GridBagConstraintsExtended(0, 5, 5, 5, 8, colL1, true);
	private static final GridBagConstraints gbc_fieldMin = new GridBagConstraintsExtended(0, 0, 5, 5, 8, colF1);
	private static final GridBagConstraints gbc_chkMax = new GridBagConstraintsExtended(0, 5, 5, 5, 9, colL1, true);
	private static final GridBagConstraints gbc_fieldMax = new GridBagConstraintsExtended(0, 0, 5, 5, 9, colF1);
	private static final GridBagConstraints gbc_chkVal = new GridBagConstraintsExtended(0, 5, 5, 5, 10, colL1, true);
	private static final GridBagConstraints gbc_fieldVal = new GridBagConstraintsExtended(0, 0, 5, 5, 10, colF1);
	private static final GridBagConstraints gbc_chkSpell = new GridBagConstraintsExtended(0, 5, 5, 5, 11, colL1, true);
	private static final GridBagConstraints gbc_fieldSpell = new GridBagConstraintsExtended(0, 0, 5, 5, 11, colF1);
	private static final GridBagConstraints gbc_chkQuest = new GridBagConstraintsExtended(0, 5, 5, 5, 12, colL1, true);
	private static final GridBagConstraints gbc_fieldQuest = new GridBagConstraintsExtended(0, 0, 5, 5, 12, colF1);

	private static final GridBagConstraints gbc_separator_2 = new GridBagConstraintsExtended(10, 0, 5, 5, 13, colL1, false);
	
	private static final GridBagConstraints gbc_chkSize = new GridBagConstraintsExtended(0, 5, 5, 5, 14, colL1, true);
	private static final GridBagConstraints gbc_fieldSize = new GridBagConstraintsExtended(0, 0, 5, 5, 14, colF1);
	private static final GridBagConstraints gbc_chkX = new GridBagConstraintsExtended(0, 5, 5, 5, 15, colL1, true);
	private static final GridBagConstraints gbc_fieldX = new GridBagConstraintsExtended(0, 0, 5, 5, 15, colF1);
	private static final GridBagConstraints gbc_chkY = new GridBagConstraintsExtended(0, 5, 5, 5, 16, colL1, true);
	private static final GridBagConstraints gbc_fieldY = new GridBagConstraintsExtended(0, 0, 5, 5, 16, colF1);
	private static final GridBagConstraints gbc_chkXAdj = new GridBagConstraintsExtended(0, 5, 5, 5, 17, colL1, true);
	private static final GridBagConstraints gbc_fieldXAdj = new GridBagConstraintsExtended(0, 0, 5, 5, 17, colF1);
	private static final GridBagConstraints gbc_chkYAdj = new GridBagConstraintsExtended(0, 5, 5, 5, 18, colL1, true);
	private static final GridBagConstraints gbc_fieldYAdj = new GridBagConstraintsExtended(0, 0, 5, 5, 18, colF1);
	private static final GridBagConstraints gbc_chkDepth = new GridBagConstraintsExtended(0, 5, 5, 5, 19, colL1, true);
	private static final GridBagConstraints gbc_fieldDepth = new GridBagConstraintsExtended(0, 0, 5, 5, 19, colF1);
	
	private static final GridBagConstraints gbc_separator_3 = new GridBagConstraintsExtended(10, 0, 5, 5, 20, colL1, false);

	private static final GridBagConstraints gbc_chkSpeed = new GridBagConstraintsExtended(0, 5, 5, 5, 21, colL1, true);
	private static final GridBagConstraints gbc_fieldSpeed = new GridBagConstraintsExtended(0, 0, 5, 5, 21, colF1);
	private static final GridBagConstraints gbc_chkFadeIn = new GridBagConstraintsExtended(0, 5, 5, 5, 22, colL1, true);
	private static final GridBagConstraints gbc_fieldFadeIn = new GridBagConstraintsExtended(0, 0, 5, 5, 22, colF1);
	private static final GridBagConstraints gbc_chkFadeOut = new GridBagConstraintsExtended(0, 5, 5, 5, 23, colL1, true);
	private static final GridBagConstraints gbc_fieldFadeOut = new GridBagConstraintsExtended(0, 0, 5, 5, 23, colF1);
	private static final GridBagConstraints gbc_chkPopupIn = new GridBagConstraintsExtended(0, 5, 5, 5, 24, colL1, true);
	private static final GridBagConstraints gbc_fieldPopupIn = new GridBagConstraintsExtended(0, 0, 5, 5, 24, colF1);
	private static final GridBagConstraints gbc_chkPopupOut = new GridBagConstraintsExtended(0, 5, 5, 5, 25, colL1, true);
	private static final GridBagConstraints gbc_fieldPopupOut = new GridBagConstraintsExtended(0, 0, 5, 5, 25, colF1);
	private static final GridBagConstraints gbc_chkPopupDirIn = new GridBagConstraintsExtended(0, 5, 5, 5, 26, colL1, true);
	private static final GridBagConstraints gbc_fieldPopupDirIn = new GridBagConstraintsExtended(0, 0, 5, 5, 26, colF1);
	private static final GridBagConstraints gbc_chkPopupDirOut = new GridBagConstraintsExtended(0, 5, 5, 5, 27, colL1, true);
	private static final GridBagConstraints gbc_fieldPopupDirOut = new GridBagConstraintsExtended(0, 0, 5, 5, 27, colF1);
	private static final GridBagConstraints gbc_chkBlink = new GridBagConstraintsExtended(0, 5, 5, 5, 28, colL1, true);
	private static final GridBagConstraints gbc_fieldBlink = new GridBagConstraintsExtended(0, 0, 5, 5, 28, colF1);

	private static final GridBagConstraints gbc_separator_4 = new GridBagConstraintsExtended(10, 0, 5, 5, 29, colL1, false);

	private static final GridBagConstraints gbc_chkName = new GridBagConstraintsExtended(0, 5, 5, 5, 30, colL1, true);
	private static final GridBagConstraints gbc_fieldTextName = new GridBagConstraintsExtended(0, 0, 5, 5, 30, colF1);
	private static final GridBagConstraints gbc_chkName2 = new GridBagConstraintsExtended(0, 5, 5, 5, 31, colL1, true);
	private static final GridBagConstraints gbc_fieldTextName_2 = new GridBagConstraintsExtended(0, 0, 5, 5, 31, colF1);
	private static final GridBagConstraints gbc_chkTxtDisplay = new GridBagConstraintsExtended(0, 5, 5, 5, 32, colL1, true);
	private static final GridBagConstraints gbc_fieldTextDisplay = new GridBagConstraintsExtended(0, 0, 5, 5, 32, colF1);
	private static final GridBagConstraints gbc_chkTxtType = new GridBagConstraintsExtended(0, 5, 5, 5, 33, colL1, true);
	private static final GridBagConstraints gbc_fieldTextType = new GridBagConstraintsExtended(0, 0, 5, 5, 33, colF1);
	private static final GridBagConstraints gbc_chkTxtSize = new GridBagConstraintsExtended(0, 5, 5, 5, 34, colL1, true);
	private static final GridBagConstraints gbc_fieldTextSize = new GridBagConstraintsExtended(0, 0, 5, 5, 34, colF1);
	private static final GridBagConstraints gbc_chkTxtColor = new GridBagConstraintsExtended(0, 5, 5, 5, 35, colL1, true);
	private static final GridBagConstraints gbc_fieldTextColor = new GridBagConstraintsExtended(0, 0, 5, 5, 35, colF1);
	private static final GridBagConstraints gbc_chkTxtX = new GridBagConstraintsExtended(0, 5, 5, 5, 36, colL1, true);
	private static final GridBagConstraints gbc_fieldTextX = new GridBagConstraintsExtended(0, 0, 5, 5, 36, colF1);
	private static final GridBagConstraints gbc_chkTxtY = new GridBagConstraintsExtended(0, 5, 5, 5, 37, colL1, true);
	private static final GridBagConstraints gbc_fieldTextY = new GridBagConstraintsExtended(0, 0, 5, 5, 37, colF1);
	private static final GridBagConstraints gbc_chkTxtXAdj = new GridBagConstraintsExtended(0, 5, 5, 5, 38, colL1, true);
	private static final GridBagConstraints gbc_fieldTextXAdj = new GridBagConstraintsExtended(0, 0, 5, 5, 38, colF1);
	private static final GridBagConstraints gbc_chkTxtYAdj = new GridBagConstraintsExtended(0, 5, 5, 5, 39, colL1, true);
	private static final GridBagConstraints gbc_fieldTextYAdj = new GridBagConstraintsExtended(0, 0, 5, 5, 39, colF1);
	private static final GridBagConstraints gbc_chkShdColor = new GridBagConstraintsExtended(0, 5, 5, 5, 40, colL1, true);
	private static final GridBagConstraints gbc_fieldShadowColor = new GridBagConstraintsExtended(0, 0, 5, 5, 40, colF1);
	private static final GridBagConstraints gbc_chkShdX = new GridBagConstraintsExtended(0, 5, 5, 5, 41, colL1, true);
	private static final GridBagConstraints gbc_fieldShadowX = new GridBagConstraintsExtended(0, 0, 5, 5, 41, colF1);
	private static final GridBagConstraints gbc_chkShdY = new GridBagConstraintsExtended(0, 5, 5, 5, 42, colL1, true);
	private static final GridBagConstraints gbc_fieldShadowY = new GridBagConstraintsExtended(0, 0, 5, 5, 42, colF1);
	private static final GridBagConstraints gbc_chkWrapW = new GridBagConstraintsExtended(0, 5, 5, 5, 43, colL1, true);
	private static final GridBagConstraints gbc_fieldWrapWidth = new GridBagConstraintsExtended(0, 0, 5, 5, 43, colF1);
	private static final GridBagConstraints gbc_chkWrapL = new GridBagConstraintsExtended(0, 5, 5, 5, 44, colL1, true);
	private static final GridBagConstraints gbc_fieldWrapLine = new GridBagConstraintsExtended(0, 0, 5, 5, 44, colF1);

	private static final GridBagConstraints gbc_MiddleSeparator = new GridBagConstraintsExtended(0, 0, 0, 0, 0, 2, 45, 1, GridBagConstraints.BOTH);
	
	private static final GridBagConstraints gbc_chkVisible = new GridBagConstraintsExtended(5, 5, 0, 5, 0, colL2, true);
	private static final GridBagConstraints gbc_fieldVisible = new GridBagConstraintsExtended(5, 0, 5, 5, 0, colF2);
	private static final GridBagConstraints gbc_chkVisibleOn = new GridBagConstraintsExtended(0, 5, 5, 5, 1, colL2, true);
	private static final GridBagConstraints gbc_fieldVisibleOn = new GridBagConstraintsExtended(0, 0, 5, 5, 1, colF2);
	private static final GridBagConstraints gbc_chkVisibleTime = new GridBagConstraintsExtended(0, 5, 5, 5, 2, colL2, true);
	private static final GridBagConstraints gbc_fieldVisibleTime = new GridBagConstraintsExtended(0, 0, 5, 5, 2, colF2);
	private static final GridBagConstraints gbc_chkVisibleFirst = new GridBagConstraintsExtended(0, 5, 5, 5, 3, colL2, true);
	private static final GridBagConstraints gbc_fieldVisibleFirst = new GridBagConstraintsExtended(0, 0, 5, 5, 3, colF2);

	private static final GridBagConstraints gbc_separator_5 = new GridBagConstraintsExtended(10, 0, 5, 5, 4, colL2, false);

	private static final GridBagConstraints gbc_chkColor = new GridBagConstraintsExtended(0, 5, 5, 5, 5, colL2, true);
	private static final GridBagConstraints gbc_fieldColor = new GridBagConstraintsExtended(0, 0, 5, 5, 5, colF2);
	private static final GridBagConstraints gbc_chkColorR = new GridBagConstraintsExtended(0, 5, 5, 5, 6, colL2, true);
	private static final GridBagConstraints gbc_fieldColorR = new GridBagConstraintsExtended(0, 0, 5, 5, 6, colF2);
	private static final GridBagConstraints gbc_chkColorG = new GridBagConstraintsExtended(0, 5, 5, 5, 7, colL2, true);
	private static final GridBagConstraints gbc_fieldColorG = new GridBagConstraintsExtended(0, 0, 5, 5, 7, colF2);
	private static final GridBagConstraints gbc_chkColorB = new GridBagConstraintsExtended(0, 5, 5, 5, 8, colL2, true);
	private static final GridBagConstraints gbc_fieldColorB = new GridBagConstraintsExtended(0, 0, 5, 5, 8, colF2);
	private static final GridBagConstraints gbc_chkColorEmpty = new GridBagConstraintsExtended(0, 5, 5, 5, 9, colL2, true);
	private static final GridBagConstraints gbc_fieldColorEmpty = new GridBagConstraintsExtended(0, 0, 5, 5, 9, colF2);
	private static final GridBagConstraints gbc_chkColorMin = new GridBagConstraintsExtended(0, 5, 5, 5, 10, colL2, true);
	private static final GridBagConstraints gbc_fieldColorMin = new GridBagConstraintsExtended(0, 0, 5, 5, 10, colF2);
	private static final GridBagConstraints gbc_chkColorHalf = new GridBagConstraintsExtended(0, 5, 5, 5, 11, colL2, true);
	private static final GridBagConstraints gbc_fieldColorHalf = new GridBagConstraintsExtended(0, 0, 5, 5, 11, colF2);
	private static final GridBagConstraints gbc_chkColorMax = new GridBagConstraintsExtended(0, 5, 5, 5, 12, colL2, true);
	private static final GridBagConstraints gbc_fieldColorMax = new GridBagConstraintsExtended(0, 0, 5, 5, 12, colF2);
	private static final GridBagConstraints gbc_chkColorFull = new GridBagConstraintsExtended(0, 5, 5, 5, 13, colL2, true);
	private static final GridBagConstraints gbc_fieldColorFull = new GridBagConstraintsExtended(0, 0, 5, 5, 13, colF2);
	private static final GridBagConstraints gbc_chkColorLow = new GridBagConstraintsExtended(0, 5, 5, 5, 14, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeColorLow = new GridBagConstraintsExtended(0, 0, 5, 5, 14, colF2);
	private static final GridBagConstraints gbc_chkColorMidLow = new GridBagConstraintsExtended(0, 5, 5, 5, 15, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeColorMidLow = new GridBagConstraintsExtended(0, 0, 5, 5, 15, colF2);
	private static final GridBagConstraints gbc_chkColorMidHigh = new GridBagConstraintsExtended(0, 5, 5, 5, 16, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeColorMidHigh = new GridBagConstraintsExtended(0, 0, 5, 5, 16, colF2);
	private static final GridBagConstraints gbc_chkHigh = new GridBagConstraintsExtended(0, 5, 5, 5, 17, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeColorHigh = new GridBagConstraintsExtended(0, 0, 5, 5, 17, colF2);

	private static final GridBagConstraints gbc_separator_6 = new GridBagConstraintsExtended(10, 0, 5, 5, 18, colL2, false);

	private static final GridBagConstraints gbc_fieldRangeAlpha = new GridBagConstraintsExtended(0, 0, 5, 5, 19, colF2);
	private static final GridBagConstraints gbc_chkAlpha = new GridBagConstraintsExtended(0, 5, 5, 5, 19, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeAlphaMin = new GridBagConstraintsExtended(0, 0, 5, 5, 20, colF2);
	private static final GridBagConstraints gbc_chkAlphaMin = new GridBagConstraintsExtended(0, 5, 5, 5, 20, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeAlphaInv = new GridBagConstraintsExtended(0, 0, 5, 5, 21, colF2);
	private static final GridBagConstraints gbc_chkAlphaInv = new GridBagConstraintsExtended(0, 5, 5, 5, 21, colL2, true);
	private static final GridBagConstraints gbc_fieldRangeAlphaVis = new GridBagConstraintsExtended(0, 0, 5, 5, 22, colF2);
	private static final GridBagConstraints gbc_chkAlphaVis = new GridBagConstraintsExtended(0, 5, 5, 5, 22, colL2, true);

	private static final GridBagConstraints gbc_separator_7 = new GridBagConstraintsExtended(10, 0, 5, 5, 23, colL2, false);

	private static final GridBagConstraints gbc_chkCust = new GridBagConstraintsExtended(0, 5, 5, 5, 24, colL2, true);
	private static final GridBagConstraints gbc_fieldFileCustom = new GridBagConstraintsExtended(0, 0, 5, 5, 24, colF2);
	private static final GridBagConstraints gbc_chkCustBack = new GridBagConstraintsExtended(0, 5, 5, 5, 25, colL2, true);
	private static final GridBagConstraints gbc_fieldFileCustomBack = new GridBagConstraintsExtended(0, 0, 5, 5, 25, colF2);
	private static final GridBagConstraints gbc_chkCustEdge = new GridBagConstraintsExtended(0, 5, 5, 5, 26, colL2, true);
	private static final GridBagConstraints gbc_fieldFileCustomEdge = new GridBagConstraintsExtended(0, 0, 5, 5, 26, colF2);
	private static final GridBagConstraints gbc_chkCustFront = new GridBagConstraintsExtended(0, 5, 5, 5, 27, colL2, true);
	private static final GridBagConstraints gbc_fieldFileCustomFront = new GridBagConstraintsExtended(0, 0, 5, 5, 27, colF2);
	private static final GridBagConstraints gbc_chkCustW = new GridBagConstraintsExtended(0, 5, 5, 5, 28, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomW = new GridBagConstraintsExtended(0, 0, 5, 5, 28, colF2);
	private static final GridBagConstraints gbc_chkCustH = new GridBagConstraintsExtended(0, 5, 5, 5, 29, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomH = new GridBagConstraintsExtended(0, 0, 5, 5, 29, colF2);
	private static final GridBagConstraints gbc_chkCustBW = new GridBagConstraintsExtended(0, 5, 5, 5, 30, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomBW = new GridBagConstraintsExtended(0, 0, 5, 5, 30, colF2);
	private static final GridBagConstraints gbc_chkCustBH = new GridBagConstraintsExtended(0, 5, 5, 5, 31, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomBH = new GridBagConstraintsExtended(0, 0, 5, 5, 31, colF2);
	private static final GridBagConstraints gbc_chkCustEW = new GridBagConstraintsExtended(0, 5, 5, 5, 32, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomEW = new GridBagConstraintsExtended(0, 0, 5, 5, 32, colF2);
	private static final GridBagConstraints gbc_chkCustEH = new GridBagConstraintsExtended(0, 5, 5, 5, 33, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomEH = new GridBagConstraintsExtended(0, 0, 5, 5, 33, colF2);
	private static final GridBagConstraints gbc_chkCustEO = new GridBagConstraintsExtended(0, 5, 5, 5, 34, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomEO = new GridBagConstraintsExtended(0, 0, 5, 5, 34, colF2);
	private static final GridBagConstraints gbc_chkCustX = new GridBagConstraintsExtended(0, 5, 5, 5, 35, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomX = new GridBagConstraintsExtended(0, 0, 5, 5, 35, colF2);
	private static final GridBagConstraints gbc_chkCustY = new GridBagConstraintsExtended(0, 5, 5, 5, 36, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomY = new GridBagConstraintsExtended(0, 0, 5, 5, 36, colF2);
	private static final GridBagConstraints gbc_chkCustOff = new GridBagConstraintsExtended(0, 5, 5, 5, 37, colL2, true);
	private static final GridBagConstraints gbc_fieldCustomOffset = new GridBagConstraintsExtended(0, 0, 5, 5, 37, colF2);

	private static final GridBagConstraints gbc_separator_8 = new GridBagConstraintsExtended(10, 0, 5, 5, 38, colL2, false);

	private static final GridBagConstraints gbc_chkStorePos = new GridBagConstraintsExtended(0, 5, 5, 5, 39, colL2, true);
	private static final GridBagConstraints gbc_fieldStore = new GridBagConstraintsExtended(0, 0, 5, 5, 39, colF2);
	private static final GridBagConstraints gbc_chkUpdate = new GridBagConstraintsExtended(0, 5, 5, 5, 40, colL2, true);
	private static final GridBagConstraints gbc_fieldUpdate = new GridBagConstraintsExtended(0, 0, 5, 5, 40, colF2);
	private static final GridBagConstraints gbc_chkDebug = new GridBagConstraintsExtended(0, 5, 5, 5, 41, colL2, true);
	private static final GridBagConstraints gbc_fieldDebug = new GridBagConstraintsExtended(0, 0, 5, 5, 41, colF2);

	private static final GridBagConstraints gbc_lblBarName = new GridBagConstraintsExtended(5, 5, 5, 5, 0, 0, true);
	private static final GridBagConstraints gbc_fieldBarName = new GridBagConstraintsExtended(5, 0, 5, 5, 0, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblBarDescription = new GridBagConstraintsExtended(0, 5, 5, 5, 1, 0, true);
	private static final GridBagConstraints gbc_fieldBarDescription = new GridBagConstraintsExtended(0, 0, 5, 5, 1, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_lblQuickFunctions = new GridBagConstraintsExtended(0, 5, 5, 5, 2, 0, false);
	private static final GridBagConstraints gbc_scrollPaneQF = new GridBagConstraintsExtended(0, 0, 5, 5, 2, 1, 1, 1, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_labelInfo = new GridBagConstraintsExtended(0, 5, 5, 5, 3, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btnSave = new GridBagConstraintsExtended(0, 5, 5, 5, 4, 0, 1, 2, GridBagConstraints.BOTH);
	private static final GridBagConstraints gbc_btnCancel = new GridBagConstraintsExtended(0, 5, 5, 5, 5, 0, 1, 2, GridBagConstraints.BOTH);


	

	
	private JCheckBoxLabel chkID, chkType, chkDirection;
	private JCheckBoxLabel chkRef, chkRef_2, chkTmp, chkTmp_2, chkMin, chkMax, chkVal, chkSpell, chkQuest;
	private JCheckBoxLabel chkSize, chkX, chkY, chkXAdj, chkYAdj, chkDepth;
	private JCheckBoxLabel chkSpeed, chkFadeIn, chkFadeOut, chkPopupIn, chkPopupOut, chkPopupDirIn, chkPopupDirOut, chkBlink;
	private JCheckBoxLabel chkName, chkName2, chkTxtDisplay, chkTxtType, chkTxtSize, chkTxtColor, chkTxtX, chkTxtY, chkTxtXAdj, chkTxtYAdj, chkShdColor, chkShdX, chkShdY, chkWrapW, chkWrapL;
	private JCheckBoxLabel chkVisible, chkVisibleOn, chkVisibleTime, chkVisibleFirst;
	private JCheckBoxLabel chkColor, chkColorR, chkColorG, chkColorB, chkColorEmpty, chkColorMin, chkColorHalf, chkColorMax, chkColorFull, chkColorLow, chkColorMidLow, chkColorMidHigh, chkColorHigh;
	private JCheckBoxLabel chkAlpha, chkAlphaMin, chkAlphaInv, chkAlphaVis;
	private JCheckBoxLabel chkCust, chkCustBack, chkCustEdge, chkCustFront, chkCustW, chkCustH, chkCustBW, chkCustBH, chkCustEW, chkCustEH, chkCustEO, chkCustX, chkCustY, chkCustOff;
	private JCheckBoxLabel chkStorePos, chkUpdate, chkDebug;
	private JLabel labelInfo = new JLabel("<html><center>* those checks enable/disable<br>the fields with ;<center>");
	
	private JPanel panelFields, panelInfo;
	private JTextArea fieldBarDescription;
	private JComboBoxEx <Object> fieldSize, fieldX, fieldY, fieldTextType, fieldTextSize, fieldTextX, fieldTextY;
	private JComboBoxEx <TokenType> fieldType;
	private JComboBoxEx <TokenDirection> fieldDirection;
	private JComboBoxEx <TokenSpell> fieldSpell;
	private JComboBoxEx <TokenPopup> fieldPopupDirIn, fieldPopupDirOut;
	private JComboBoxEx <TokenColor> fieldColorEmpty, fieldColorMin, fieldColorHalf, fieldColorMax, fieldColorFull;
	private JComboBoxEx <TokenTextDisplay>	fieldTextDisplay;
	private JComboBoxEx <TokenDebug> fieldDebug;
	private JSliderEx fieldColorLow, fieldColorMidLow, fieldColorMidHigh, fieldColorHigh;
	private JSliderEx fieldAlpha, fieldAlphaMin, fieldAlphaInv, fieldAlphaVis;
	private JCheckBoxEx fieldVisibleFirst;
	private JCheckBoxEx fieldStore;
	private JTextField	fieldBarName;
	private JTextFieldEx fieldID;
	private JTextFieldEx fieldRef, fieldRef_2, fieldTmp, fieldTmp_2, fieldMin, fieldMax, fieldVal, fieldQuest;
	private JTextFieldEx fieldXAdj, fieldYAdj, fieldDepth;
	private JTextFieldEx fieldSpeed, fieldFadeIn, fieldFadeOut, fieldPopupIn, fieldPopupOut, fieldBlink;
	private JTextFieldEx fieldName, fieldName_2, fieldTextColor, fieldTextXAdj, fieldTextYAdj, fieldShadowColor, fieldShadowX, fieldShadowY, fieldWrapWidth, fieldWrapLine;
	private JTextFieldEx fieldVisible, fieldVisibleOn, fieldVisibleTime;
	private JTextFieldEx fieldColor, fieldColorR, fieldColorG, fieldColorB;
	private JTextFieldEx fieldFileCustom, fieldFileCustomBack, fieldFileCustomEdge, fieldFileCustomFront, fieldCustomW, fieldCustomH, fieldCustomBW, fieldCustomBH, fieldCustomEW, fieldCustomEH, fieldCustomEO, fieldCustomX, fieldCustomY, fieldCustomOffset;
	private JTextFieldEx fieldUpdate;

	private JTextFieldEx lastSelected = null;
	private JListEx<TokenQF> listQF;

	private Consumer<JTextFieldEx> textFocusGainedQF = (x) -> {
		lastSelected = x;
		if (x.isUsingQF()){
			setQF(x, x.getQF().token);
		} else {
			listQF.setEnabled(true);
		}
	};
	private Consumer<JTextFieldEx> textFocusGained = (x) -> {
		listQF.setEnabled(false);
	};
	private Consumer<JComponentEx> comboFocusGained = (x) -> {
		listQF.setEnabled(false);
	};


	/**
	 * Initialize the contents of the frame.
	 * @param bar	The bar to edit
	 * @param i		The nth bar
	 * @param n		The number of bars
	 */
	public BarEditor (Bar bar, int i, int n) {
		setTitle("Bar editor");
		setIconImage(IniEditor.IMAGE_ICON.getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(getBounds(this, 0.8, 0.8));
		setMinimumSize(new Dimension(480, 270));

		JPanel panelExt = new JPanel();
		setContentPane(panelExt);
		
		panelFields = new JPanel();
		panelFields.setLayout(gbl_panelFields);
		panelFields.setBounds(0, 0, getWidth(), getHeight());
		JScrollPane scrollPane = new JScrollPane(panelFields);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		panelInfo = new JPanel();
		panelInfo.setLayout(gbl_panelInfo);
		if (IniEditor.UIeditorLeft){
			panelExt.setLayout(gbl_panelExtL);
			panelExt.add(scrollPane, gbc_scrollPaneL);
			panelExt.add(panelInfo, gbc_panelInfoL);
		} else {
			panelExt.setLayout(gbl_panelExtR);
			panelExt.add(scrollPane, gbc_scrollPaneR);
			panelExt.add(panelInfo, gbc_panelInfoR);
		}

		addLabels(panelFields, panelInfo);
		addFields(panelFields, panelInfo, bar);
		loadBar(bar);
		parseAllQF();
		setVisible(true);

		FocusTraversalOnArray focusTraversalOnArray = new FocusTraversalOnArray(new Component[]{fieldID, fieldType, fieldDirection, fieldRef, fieldRef_2, fieldTmp, fieldTmp_2, fieldMin, fieldMax, fieldVal, fieldSpell, fieldQuest, fieldSize, fieldX, fieldY, fieldXAdj, fieldYAdj, fieldDepth, fieldSpeed, fieldFadeIn, fieldFadeOut, fieldPopupIn, fieldPopupOut, fieldPopupDirIn, fieldPopupDirOut, fieldBlink, fieldName, fieldName_2, fieldTextDisplay, fieldTextType, fieldTextSize, fieldTextColor, fieldTextX, fieldTextY, fieldTextXAdj, fieldTextYAdj, fieldShadowColor, fieldShadowX, fieldShadowY, fieldWrapWidth, fieldWrapLine, fieldVisible, fieldVisibleOn, fieldVisibleTime, fieldVisibleFirst, fieldColor, fieldColorR, fieldColorG, fieldColorB, fieldColorEmpty, fieldColorMin, fieldColorHalf, fieldColorMax, fieldColorFull, fieldColorLow, fieldColorMidLow, fieldColorMidHigh, fieldColorHigh, fieldAlpha, fieldAlphaMin, fieldAlphaInv, fieldAlphaVis, fieldFileCustom, fieldFileCustomBack, fieldFileCustomEdge, fieldFileCustomFront, fieldCustomW, fieldCustomH, fieldCustomBW, fieldCustomBH, fieldCustomEW, fieldCustomEH, fieldCustomEO, fieldCustomX, fieldCustomY, fieldCustomOffset, fieldStore, fieldUpdate, fieldDebug});
		setFocusTraversalPolicy(focusTraversalOnArray);
	}
	
	

	/**
	 * Add the labels and info to the UI
	 * @param panelFields	The panel for the fields
	 * @param panelInfo		The panel for the info
	 */
	public void addLabels(JPanel panelFields, JPanel panelInfo){
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setOpaque(true);
		panelFields.add(separator, gbc_MiddleSeparator);

		chkID = new JCheckBoxLabel("ID", TokenField.ID.description);
		panelFields.add(chkID, gbc_chkId);

		chkType = new JCheckBoxLabel("Type", TokenField.TYPE.description);
		panelFields.add(chkType, gbc_chkType);
		
		chkDirection = new JCheckBoxLabel("Direction", TokenField.DIRECTION.description);
		panelFields.add(chkDirection, gbc_chkDirection);
		
		panelFields.add(new JSeparator(), gbc_separator_1);

		chkRef = new JCheckBoxLabel("Reference", TokenField.REF.description);
		panelFields.add(chkRef, gbc_chkRef);

		chkRef_2 = new JCheckBoxLabel("Reference 2", TokenField.REF_2.description);
		panelFields.add(chkRef_2, gbc_chkRef_2);

		chkTmp = new JCheckBoxLabel("Temporary", TokenField.TMP.description);
		panelFields.add(chkTmp, gbc_chkTmp);
		
		chkTmp_2 = new JCheckBoxLabel("Temporary 2", TokenField.TMP_2.description);
		panelFields.add(chkTmp_2, gbc_chkTmp_2);

		chkMin = new JCheckBoxLabel("Min", TokenField.MIN.description);
		panelFields.add(chkMin, gbc_chkMin);
		
		chkMax = new JCheckBoxLabel("Max", TokenField.MAX.description);
		panelFields.add(chkMax, gbc_chkMax);
		
		chkVal = new JCheckBoxLabel("Value", TokenField.VAL.description);
		panelFields.add(chkVal, gbc_chkVal);
		
		chkSpell = new JCheckBoxLabel("Spell effect", TokenField.SPELL_EFFECT.description);
		panelFields.add(chkSpell, gbc_chkSpell);
		
		chkQuest = new JCheckBoxLabel("Quest ID", TokenField.QUEST.description);
		panelFields.add(chkQuest, gbc_chkQuest);

		panelFields.add(new JSeparator(), gbc_separator_2);
		
		chkSize = new JCheckBoxLabel("Size", TokenField.SIZE.description);
		panelFields.add(chkSize, gbc_chkSize);
		
		chkX = new JCheckBoxLabel("X", TokenField.X.description);
		panelFields.add(chkX, gbc_chkX);
		
		chkY = new JCheckBoxLabel("Y", TokenField.Y.description);
		panelFields.add(chkY, gbc_chkY);
		
		chkXAdj = new JCheckBoxLabel("X adjust", TokenField.X_ADJUST.description);
		panelFields.add(chkXAdj, gbc_chkXAdj);
		
		chkYAdj = new JCheckBoxLabel("Y adjust", TokenField.Y_ADJUST.description);
		panelFields.add(chkYAdj, gbc_chkYAdj);
		
		chkDepth = new JCheckBoxLabel("Depth", TokenField.DEPTH.description);
		panelFields.add(chkDepth, gbc_chkDepth);

		panelFields.add(new JSeparator(), gbc_separator_3);
		
		chkSpeed = new JCheckBoxLabel("Speed", TokenField.SPEED.description);
		panelFields.add(chkSpeed, gbc_chkSpeed);
		
		chkFadeIn = new JCheckBoxLabel("Fade in", TokenField.FADE_IN.description);
		panelFields.add(chkFadeIn, gbc_chkFadeIn);
		
		chkFadeOut = new JCheckBoxLabel("Fade out", TokenField.FADE_OUT.description);
		panelFields.add(chkFadeOut, gbc_chkFadeOut);
		
		chkPopupIn = new JCheckBoxLabel("Popup in time", TokenField.POPUP_IN.description);
		panelFields.add(chkPopupIn, gbc_chkPopupIn);
		
		chkPopupOut = new JCheckBoxLabel("Popup out time", TokenField.POPUP_OUT.description);
		panelFields.add(chkPopupOut, gbc_chkPopupOut);
		
		chkPopupDirIn = new JCheckBoxLabel("Popup in direction", TokenField.POPUP_DIRIN.description);
		panelFields.add(chkPopupDirIn, gbc_chkPopupDirIn);
		
		chkPopupDirOut = new JCheckBoxLabel("Popup out direction", TokenField.POPUP_DIROUT.description);
		panelFields.add(chkPopupDirOut, gbc_chkPopupDirOut);
		
		chkBlink = new JCheckBoxLabel("Blink", TokenField.BLINK.description);
		panelFields.add(chkBlink, gbc_chkBlink);

		panelFields.add(new JSeparator(), gbc_separator_4);
		
		chkName = new JCheckBoxLabel("Name", TokenField.NAME.description);
		panelFields.add(chkName, gbc_chkName);

		chkName2 = new JCheckBoxLabel("Name 2", TokenField.NAME_2.description);
		panelFields.add(chkName2, gbc_chkName2);
		
		chkTxtDisplay = new JCheckBoxLabel("Text display", TokenField.TEXTDISPLAY.description);
		panelFields.add(chkTxtDisplay, gbc_chkTxtDisplay);
		
		chkTxtType = new JCheckBoxLabel("Text font", TokenField.TEXTTYPE.description);
		panelFields.add(chkTxtType, gbc_chkTxtType);
		
		chkTxtSize = new JCheckBoxLabel("Text size", TokenField.TEXTSIZE.description);
		panelFields.add(chkTxtSize, gbc_chkTxtSize);
		
		chkTxtColor = new JCheckBoxLabel("Text color", TokenField.TEXTCOLOR.description);
		panelFields.add(chkTxtColor, gbc_chkTxtColor);
		
		chkTxtX = new JCheckBoxLabel("Text X", TokenField.TEXTPOS_X.description);
		panelFields.add(chkTxtX, gbc_chkTxtX);

		chkTxtY = new JCheckBoxLabel("Text Y", TokenField.TEXTPOS_Y.description);
		panelFields.add(chkTxtY, gbc_chkTxtY);
		
		chkTxtXAdj = new JCheckBoxLabel("Text X adjust", TokenField.TEXTADJUST_X.description);
		panelFields.add(chkTxtXAdj, gbc_chkTxtXAdj);

		chkTxtYAdj = new JCheckBoxLabel("Text Y adjust", TokenField.TEXTADJUST_Y.description);
		panelFields.add(chkTxtYAdj, gbc_chkTxtYAdj);

		chkShdColor = new JCheckBoxLabel("Text shadow color", TokenField.TEXTSHADOWCOLOR.description);
		panelFields.add(chkShdColor, gbc_chkShdColor);

		chkShdX = new JCheckBoxLabel("Text shadow X", TokenField.TEXTSHADOW_X.description);
		panelFields.add(chkShdX, gbc_chkShdX);

		chkShdY = new JCheckBoxLabel("Text shadow Y", TokenField.TEXTSHADOW_Y.description);
		panelFields.add(chkShdY, gbc_chkShdY);

		chkWrapW = new JCheckBoxLabel("Text wrap width", TokenField.TEXTWRAPWIDTH.description);
		panelFields.add(chkWrapW, gbc_chkWrapW);

		chkWrapL = new JCheckBoxLabel("Text wrap lines", TokenField.TEXTWRAPLINES.description);
		panelFields.add(chkWrapL, gbc_chkWrapL);

		chkVisible = new JCheckBoxLabel("Visible", TokenField.VISIBLE.description);
		panelFields.add(chkVisible, gbc_chkVisible);

		chkVisibleOn = new JCheckBoxLabel("Visible on", TokenField.VISIBLE_ON.description);
		panelFields.add(chkVisibleOn, gbc_chkVisibleOn);

		chkVisibleTime = new JCheckBoxLabel("Visible time", TokenField.VISIBLE_TIME.description);
		panelFields.add(chkVisibleTime, gbc_chkVisibleTime);

		chkVisibleFirst = new JCheckBoxLabel("Visible first", TokenField.VISIBLE_FIRST.description);
		panelFields.add(chkVisibleFirst, gbc_chkVisibleFirst);

		panelFields.add(new JSeparator(), gbc_separator_5);

		chkColor = new JCheckBoxLabel("Color", TokenField.COLOR.description);
		panelFields.add(chkColor, gbc_chkColor);

		chkColorR = new JCheckBoxLabel("Color R", TokenField.COLOR_R.description);
		panelFields.add(chkColorR, gbc_chkColorR);

		chkColorG = new JCheckBoxLabel("Color G", TokenField.COLOR_G.description);
		panelFields.add(chkColorG, gbc_chkColorG);

		chkColorB = new JCheckBoxLabel("Color B", TokenField.COLOR_B.description);
		panelFields.add(chkColorB, gbc_chkColorB);

		chkColorEmpty = new JCheckBoxLabel("Color empty", TokenField.COLOR_EMPTY.description);
		panelFields.add(chkColorEmpty, gbc_chkColorEmpty);

		chkColorMin = new JCheckBoxLabel("Color min", TokenField.COLOR_MIN.description);
		panelFields.add(chkColorMin, gbc_chkColorMin);

		chkColorHalf = new JCheckBoxLabel("Color half", TokenField.COLOR_HALF.description);
		panelFields.add(chkColorHalf, gbc_chkColorHalf);

		chkColorMax = new JCheckBoxLabel("Color max", TokenField.COLOR_MAX.description);
		panelFields.add(chkColorMax, gbc_chkColorMax);
		
		chkColorFull = new JCheckBoxLabel("Color full", TokenField.COLOR_FULL.description);
		panelFields.add(chkColorFull, gbc_chkColorFull);

		chkColorLow = new JCheckBoxLabel("Color low", TokenField.COLOR_LOW.description);
		panelFields.add(chkColorLow, gbc_chkColorLow);

		chkColorMidLow = new JCheckBoxLabel("Color mid-low", TokenField.COLOR_MIDLOW.description);
		panelFields.add(chkColorMidLow, gbc_chkColorMidLow);

		chkColorMidHigh = new JCheckBoxLabel("Color mid-high", TokenField.COLOR_MIDHIGH.description);
		panelFields.add(chkColorMidHigh, gbc_chkColorMidHigh);

		chkColorHigh = new JCheckBoxLabel("Color high", TokenField.COLOR_HIGH.description);
		panelFields.add(chkColorHigh, gbc_chkHigh);

		panelFields.add(new JSeparator(), gbc_separator_6);

		chkAlpha = new JCheckBoxLabel("Alpha", TokenField.ALPHA.description);
		panelFields.add(chkAlpha, gbc_chkAlpha);
		
		chkAlphaMin = new JCheckBoxLabel("Alpha min", TokenField.ALPHA_MIN.description);
		panelFields.add(chkAlphaMin, gbc_chkAlphaMin);

		chkAlphaInv = new JCheckBoxLabel("Alpha invisible", TokenField.ALPHA_INV.description);
		panelFields.add(chkAlphaInv, gbc_chkAlphaInv);

		chkAlphaVis = new JCheckBoxLabel("Alpha visible", TokenField.ALPHA_VIS.description);
		panelFields.add(chkAlphaVis, gbc_chkAlphaVis);

		panelFields.add(new JSeparator(), gbc_separator_7);

		chkCust = new JCheckBoxLabel("Custom", TokenField.CUSTOM.description);
		panelFields.add(chkCust, gbc_chkCust);

		chkCustBack = new JCheckBoxLabel("Custom back", TokenField.CUSTOM_BACK.description);
		panelFields.add(chkCustBack, gbc_chkCustBack);
		
		chkCustEdge = new JCheckBoxLabel("Custom edge", TokenField.CUSTOM_EDGE.description);
		panelFields.add(chkCustEdge, gbc_chkCustEdge);
		
		chkCustFront = new JCheckBoxLabel("Custom front", TokenField.CUSTOM_FRONT.description);
		panelFields.add(chkCustFront, gbc_chkCustFront);
		
		chkCustW = new JCheckBoxLabel("Custom width", TokenField.CUSTOM_W.description);
		panelFields.add(chkCustW, gbc_chkCustW);
		
		chkCustH = new JCheckBoxLabel("Custom height", TokenField.CUSTOM_H.description);
		panelFields.add(chkCustH, gbc_chkCustH);
		
		chkCustBW = new JCheckBoxLabel("Custom back width", TokenField.CUSTOM_BW.description);
		panelFields.add(chkCustBW, gbc_chkCustBW);
		
		chkCustBH = new JCheckBoxLabel("Custom back height", TokenField.CUSTOM_BH.description);
		panelFields.add(chkCustBH, gbc_chkCustBH);

		chkCustEW = new JCheckBoxLabel("Custom edge width", TokenField.CUSTOM_EW.description);
		panelFields.add(chkCustEW, gbc_chkCustEW);
		
		chkCustEH = new JCheckBoxLabel("Custom edge height", TokenField.CUSTOM_EH.description);
		panelFields.add(chkCustEH, gbc_chkCustEH);
		
		chkCustEO = new JCheckBoxLabel("Custom edge offset", TokenField.CUSTOM_EO.description);
		panelFields.add(chkCustEO, gbc_chkCustEO);

		chkCustX = new JCheckBoxLabel("Custom fill X", TokenField.CUSTOM_X.description);
		panelFields.add(chkCustX, gbc_chkCustX);

		chkCustY = new JCheckBoxLabel("Custom fill Y", TokenField.CUSTOM_Y.description);
		panelFields.add(chkCustY, gbc_chkCustY);

		chkCustOff = new JCheckBoxLabel("Custom fill offset", TokenField.CUSTOM_OFFSET.description);
		panelFields.add(chkCustOff, gbc_chkCustOff);

		panelFields.add(new JSeparator(), gbc_separator_8);

		chkStorePos = new JCheckBoxLabel("Store position", TokenField.STORE_POS.description);
		panelFields.add(chkStorePos, gbc_chkStorePos);

		chkUpdate = new JCheckBoxLabel("Update interval", TokenField.UPDATEINTERVAL.description);
		panelFields.add(chkUpdate, gbc_chkUpdate);

		chkDebug = new JCheckBoxLabel("Debug mode", TokenField.DEBUG.description);
		panelFields.add(chkDebug, gbc_chkDebug);

		JLabel chkBarName = new JLabel("Name");
		chkBarName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfo.add(chkBarName, gbc_lblBarName);

		JLabel chkBarDescription = new JLabel("Description");
		chkBarDescription.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfo.add(chkBarDescription, gbc_lblBarDescription);

		JLabel chkBarQuickFunctions = new JLabel("QF");
		chkBarQuickFunctions.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfo.add(chkBarQuickFunctions, gbc_lblQuickFunctions);

		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfo.add(labelInfo, gbc_labelInfo);

	}
	
	
	private void addFields (JPanel panelFields, JPanel panelInfo, Bar bar){
		fieldID = new JTextFieldEx(TokenField.ID, chkID, textFocusGained);
		panelFields.add(fieldID, gbc_fieldID);

		fieldType = new JComboBoxEx <>(TokenField.TYPE, TokenType.class, TokenType.HUDDEFAULT, chkType, comboFocusGained, true);
		panelFields.add(fieldType, gbc_fieldType);

		fieldDirection = new JComboBoxEx <>(TokenField.DIRECTION, TokenDirection.class, TokenDirection.HUDDEFAULT, chkDirection, comboFocusGained);
		panelFields.add(fieldDirection, gbc_fieldDirection);
		
		fieldRef = new JTextFieldEx(TokenField.REF, chkRef, textFocusGainedQF, JTextFieldEx.Type.REF);
		panelFields.add(fieldRef, gbc_fieldRef);

		fieldRef_2 = new JTextFieldEx(TokenField.REF_2, chkRef_2, textFocusGainedQF, JTextFieldEx.Type.REF);
		panelFields.add(fieldRef_2, gbc_fieldRef_2);
		
		fieldTmp = new JTextFieldEx(TokenField.TMP, chkTmp, textFocusGainedQF);
		panelFields.add(fieldTmp, gbc_fieldTmp);
		
		fieldTmp_2 = new JTextFieldEx(TokenField.TMP_2, chkTmp_2, textFocusGainedQF);
		panelFields.add(fieldTmp_2, gbc_fieldTmp_2);
		
		fieldMin = new JTextFieldEx(TokenField.MIN, chkMin, textFocusGainedQF);
		panelFields.add(fieldMin, gbc_fieldMin);
		
		fieldMax = new JTextFieldEx(TokenField.MAX, chkMax, textFocusGainedQF);
		panelFields.add(fieldMax, gbc_fieldMax);
		
		fieldVal = new JTextFieldEx(TokenField.VAL, chkVal, textFocusGainedQF, JTextFieldEx.Type.VALUE);
		panelFields.add(fieldVal, gbc_fieldVal);

		fieldSpell = new JComboBoxEx <>(TokenField.SPELL_EFFECT, TokenSpell.class, TokenSpell.DEFAULT, chkSpell, comboFocusGained);
		panelFields.add(fieldSpell, gbc_fieldSpell);
		
		fieldQuest = new JTextFieldEx(TokenField.QUEST, chkQuest, textFocusGained);
		panelFields.add(fieldQuest, gbc_fieldQuest);
		
		fieldSize = new JComboBoxEx <>(TokenField.SIZE, TokenSize.class, TokenSize.HUDDEFAULT, chkSize, comboFocusGained, true);
		panelFields.add(fieldSize, gbc_fieldSize);

		fieldX = new JComboBoxEx <>(TokenField.X, TokenX.class, TokenX.HUDPREVBAR, chkX, comboFocusGained, true);
		panelFields.add(fieldX, gbc_fieldX);

		fieldY = new JComboBoxEx <>(TokenField.Y, TokenY.class, TokenY.HUDPREVBARABOVE, chkY, comboFocusGained, true);
		panelFields.add(fieldY, gbc_fieldY);

		fieldXAdj = new JTextFieldEx(TokenField.X_ADJUST, chkXAdj, textFocusGained);
		panelFields.add(fieldXAdj, gbc_fieldXAdj);

		fieldYAdj = new JTextFieldEx(TokenField.Y_ADJUST, chkYAdj, textFocusGained);
		panelFields.add(fieldYAdj, gbc_fieldYAdj);

		fieldDepth = new JTextFieldEx(TokenField.DEPTH, chkDepth, textFocusGained);
		panelFields.add(fieldDepth, gbc_fieldDepth);
		
		fieldSpeed = new JTextFieldEx(TokenField.SPEED, chkSpeed, textFocusGained);
		panelFields.add(fieldSpeed, gbc_fieldSpeed);
		
		fieldFadeIn = new JTextFieldEx(TokenField.FADE_IN, chkFadeIn, textFocusGained);
		panelFields.add(fieldFadeIn, gbc_fieldFadeIn);

		fieldFadeOut = new JTextFieldEx(TokenField.FADE_OUT, chkFadeOut, textFocusGained);
		panelFields.add(fieldFadeOut, gbc_fieldFadeOut);
		
		fieldPopupIn = new JTextFieldEx(TokenField.POPUP_IN, chkPopupIn, textFocusGained);
		panelFields.add(fieldPopupIn, gbc_fieldPopupIn);
		
		fieldPopupOut = new JTextFieldEx(TokenField.POPUP_OUT, chkPopupOut, textFocusGained);
		panelFields.add(fieldPopupOut, gbc_fieldPopupOut);
		
		fieldPopupDirIn = new JComboBoxEx<>(TokenField.POPUP_DIRIN, TokenPopup.class, TokenPopup.HUDDEFAULT, chkPopupDirIn, comboFocusGained);
		panelFields.add(fieldPopupDirIn, gbc_fieldPopupDirIn);
		
		fieldPopupDirOut = new JComboBoxEx<>(TokenField.POPUP_DIROUT, TokenPopup.class, TokenPopup.HUDDEFAULT, chkPopupDirOut, comboFocusGained);
		panelFields.add(fieldPopupDirOut, gbc_fieldPopupDirOut);

		fieldBlink = new JTextFieldEx(TokenField.BLINK, chkBlink, textFocusGainedQF);
		panelFields.add(fieldBlink, gbc_fieldBlink);
		
		fieldName = new JTextFieldEx(TokenField.NAME, chkName, textFocusGained);
		panelFields.add(fieldName, gbc_fieldTextName);
		
		fieldName_2 = new JTextFieldEx(TokenField.NAME_2, chkName2, textFocusGained);
		panelFields.add(fieldName_2, gbc_fieldTextName_2);
		
		fieldTextDisplay = new JComboBoxEx <>(TokenField.TEXTDISPLAY, TokenTextDisplay.class, TokenTextDisplay.HUDDEFAULT, chkTxtDisplay, comboFocusGained);
		panelFields.add(fieldTextDisplay, gbc_fieldTextDisplay);
		
		fieldTextType = new JComboBoxEx <>(TokenField.TEXTTYPE, TokenFont.class, TokenFont.FHUDDEFAULT, "F", chkTxtType, comboFocusGained, true);
		panelFields.add(fieldTextType, gbc_fieldTextType);
		
		fieldTextSize = new JComboBoxEx <>(TokenField.TEXTSIZE, TokenTextSize.class, TokenTextSize.SHUDDEFAULT, "S", chkTxtSize, comboFocusGained, true);
		panelFields.add(fieldTextSize, gbc_fieldTextSize);
		
		fieldTextColor = new JTextFieldEx(TokenField.TEXTCOLOR, chkTxtColor, textFocusGainedQF);
		panelFields.add(fieldTextColor, gbc_fieldTextColor);

		fieldTextX = new JComboBoxEx <>(TokenField.TEXTPOS_X, TokenTextX.class, TokenTextX.HUDDEFAULT, chkTxtX, comboFocusGained, true);
		panelFields.add(fieldTextX, gbc_fieldTextX);

		fieldTextY = new JComboBoxEx <>(TokenField.TEXTPOS_Y, TokenTextY.class, TokenTextY.HUDDEFAULT, chkTxtY, comboFocusGained, true);
		panelFields.add(fieldTextY, gbc_fieldTextY);

		fieldTextXAdj = new JTextFieldEx(TokenField.TEXTADJUST_X, chkTxtXAdj, textFocusGained);
		panelFields.add(fieldTextXAdj, gbc_fieldTextXAdj);

		fieldTextYAdj = new JTextFieldEx(TokenField.TEXTADJUST_Y, chkTxtYAdj, textFocusGained);
		panelFields.add(fieldTextYAdj, gbc_fieldTextYAdj);

		fieldShadowColor = new JTextFieldEx(TokenField.TEXTSHADOWCOLOR, chkShdColor, textFocusGainedQF);
		panelFields.add(fieldShadowColor, gbc_fieldShadowColor);

		fieldShadowX = new JTextFieldEx(TokenField.TEXTSHADOW_X, chkShdX, textFocusGained);
		panelFields.add(fieldShadowX, gbc_fieldShadowX);

		fieldShadowY = new JTextFieldEx(TokenField.TEXTSHADOW_Y, chkShdY, textFocusGained);
		panelFields.add(fieldShadowY, gbc_fieldShadowY);
		
		fieldWrapWidth = new JTextFieldEx(TokenField.TEXTWRAPWIDTH, chkWrapW, textFocusGained);
		panelFields.add(fieldWrapWidth, gbc_fieldWrapWidth);
		
		fieldWrapLine = new JTextFieldEx(TokenField.TEXTWRAPLINES, chkWrapL, textFocusGained);
		panelFields.add(fieldWrapLine, gbc_fieldWrapLine);

		fieldVisible = new JTextFieldEx(TokenField.VISIBLE, chkVisible, textFocusGainedQF);
		panelFields.add(fieldVisible, gbc_fieldVisible);
		
		fieldVisibleOn = new JTextFieldEx(TokenField.VISIBLE_ON, chkVisibleOn, textFocusGainedQF, JTextFieldEx.Type.VISIBLE_ON);
		panelFields.add(fieldVisibleOn, gbc_fieldVisibleOn);
		
		fieldVisibleTime = new JTextFieldEx(TokenField.VISIBLE_TIME, chkVisibleTime, textFocusGained);
		panelFields.add(fieldVisibleTime, gbc_fieldVisibleTime);

		fieldVisibleFirst = new JCheckBoxEx(TokenField.VISIBLE_FIRST, chkVisibleFirst, "First");
		panelFields.add(fieldVisibleFirst, gbc_fieldVisibleFirst);
		
		fieldColor = new JTextFieldEx(TokenField.COLOR, chkColor, textFocusGainedQF);
		panelFields.add(fieldColor, gbc_fieldColor);
		
		fieldColorR = new JTextFieldEx(TokenField.COLOR_R, chkColorR, textFocusGainedQF);
		panelFields.add(fieldColorR, gbc_fieldColorR);
		
		fieldColorG = new JTextFieldEx(TokenField.COLOR_G, chkColorG, textFocusGainedQF);
		panelFields.add(fieldColorG, gbc_fieldColorG);
		
		fieldColorB = new JTextFieldEx(TokenField.COLOR_B, chkColorB, textFocusGainedQF);
		panelFields.add(fieldColorB, gbc_fieldColorB);
		
		fieldColorEmpty = new JComboBoxEx <>(TokenField.COLOR_EMPTY, TokenColor.class, TokenColor.HUDNONE, chkColorEmpty, comboFocusGained);
		panelFields.add(fieldColorEmpty, gbc_fieldColorEmpty);
		
		fieldColorMin = new JComboBoxEx <>(TokenField.COLOR_MIN, TokenColor.class, TokenColor.HUDNONE, chkColorMin, comboFocusGained);
		panelFields.add(fieldColorMin, gbc_fieldColorMin);
		
		fieldColorHalf = new JComboBoxEx <>(TokenField.COLOR_HALF, TokenColor.class, TokenColor.HUDNONE, chkColorHalf, comboFocusGained);
		panelFields.add(fieldColorHalf, gbc_fieldColorHalf);
		
		fieldColorMax = new JComboBoxEx <>(TokenField.COLOR_MAX, TokenColor.class, TokenColor.HUDNONE, chkColorMax, comboFocusGained);
		panelFields.add(fieldColorMax, gbc_fieldColorMax);
		
		fieldColorFull = new JComboBoxEx <>(TokenField.COLOR_FULL, TokenColor.class, TokenColor.HUDNONE, chkColorFull, comboFocusGained);
		panelFields.add(fieldColorFull, gbc_fieldColorFull);
		
		fieldColorLow = new JSliderEx(TokenField.COLOR_LOW, chkColorLow, -1, 100, -1);
		panelFields.add(fieldColorLow, gbc_fieldRangeColorLow);

		fieldColorMidLow = new JSliderEx(TokenField.COLOR_MIDLOW, chkColorMidLow, -1, 100, -1);
		panelFields.add(fieldColorMidLow, gbc_fieldRangeColorMidLow);

		fieldColorMidHigh = new JSliderEx(TokenField.COLOR_MIDHIGH, chkColorMidHigh, -1, 100, -1);
		panelFields.add(fieldColorMidHigh, gbc_fieldRangeColorMidHigh);

		fieldColorHigh = new JSliderEx(TokenField.COLOR_HIGH, chkColorHigh, -1, 100, -1);
		panelFields.add(fieldColorHigh, gbc_fieldRangeColorHigh);

		fieldAlpha = new JSliderEx(TokenField.ALPHA, chkAlpha, -1, 255, -1);
		panelFields.add(fieldAlpha, gbc_fieldRangeAlpha);

		fieldAlphaMin = new JSliderEx(TokenField.ALPHA_MIN, chkAlphaMin, -1, 255, -1);
		panelFields.add(fieldAlphaMin, gbc_fieldRangeAlphaMin);

		fieldAlphaInv = new JSliderEx(TokenField.ALPHA_INV, chkAlphaInv, -1, 100, -1);
		panelFields.add(fieldAlphaInv, gbc_fieldRangeAlphaInv);

		fieldAlphaVis = new JSliderEx(TokenField.ALPHA_VIS, chkAlphaVis, -1, 100, -1);
		panelFields.add(fieldAlphaVis, gbc_fieldRangeAlphaVis);

		fieldFileCustom = new JTextFieldEx(TokenField.CUSTOM, chkCust, textFocusGained);
		panelFields.add(fieldFileCustom, gbc_fieldFileCustom);

		fieldFileCustomBack = new JTextFieldEx(TokenField.CUSTOM_BACK, chkCustBack, textFocusGained);
		panelFields.add(fieldFileCustomBack, gbc_fieldFileCustomBack);

		fieldFileCustomEdge = new JTextFieldEx(TokenField.CUSTOM_EDGE, chkCustEdge, textFocusGained);
		panelFields.add(fieldFileCustomEdge, gbc_fieldFileCustomEdge);

		fieldFileCustomFront = new JTextFieldEx(TokenField.CUSTOM_FRONT, chkCustFront, textFocusGained);
		panelFields.add(fieldFileCustomFront, gbc_fieldFileCustomFront);

		fieldCustomW = new JTextFieldEx(TokenField.CUSTOM_W, chkCustW, textFocusGained);
		panelFields.add(fieldCustomW, gbc_fieldCustomW);

		fieldCustomH = new JTextFieldEx(TokenField.CUSTOM_H, chkCustH, textFocusGained);
		panelFields.add(fieldCustomH, gbc_fieldCustomH);

		fieldCustomBW = new JTextFieldEx(TokenField.CUSTOM_BW, chkCustBW, textFocusGained);
		panelFields.add(fieldCustomBW, gbc_fieldCustomBW);

		fieldCustomBH = new JTextFieldEx(TokenField.CUSTOM_BH, chkCustBH, textFocusGained);
		panelFields.add(fieldCustomBH, gbc_fieldCustomBH);

		fieldCustomEW = new JTextFieldEx(TokenField.CUSTOM_EW, chkCustEW, textFocusGained);
		panelFields.add(fieldCustomEW, gbc_fieldCustomEW);
		
		fieldCustomEH = new JTextFieldEx(TokenField.CUSTOM_EH, chkCustEH, textFocusGained);
		panelFields.add(fieldCustomEH, gbc_fieldCustomEH);

		fieldCustomEO = new JTextFieldEx(TokenField.CUSTOM_EO, chkCustEO, textFocusGained);
		panelFields.add(fieldCustomEO, gbc_fieldCustomEO);

		fieldCustomX = new JTextFieldEx(TokenField.CUSTOM_X, chkCustX, textFocusGained);
		panelFields.add(fieldCustomX, gbc_fieldCustomX);

		fieldCustomY = new JTextFieldEx(TokenField.CUSTOM_Y, chkCustY, textFocusGained);
		panelFields.add(fieldCustomY, gbc_fieldCustomY);

		fieldCustomOffset = new JTextFieldEx(TokenField.CUSTOM_OFFSET, chkCustOff, textFocusGained);
		panelFields.add(fieldCustomOffset, gbc_fieldCustomOffset);

		fieldStore = new JCheckBoxEx(TokenField.STORE_POS, chkStorePos, "Store");
		panelFields.add(fieldStore, gbc_fieldStore);
		
		fieldUpdate = new JTextFieldEx(TokenField.UPDATEINTERVAL, chkUpdate, textFocusGained);
		panelFields.add(fieldUpdate, gbc_fieldUpdate);
		
		fieldDebug = new JComboBoxEx<>(TokenField.DEBUG, TokenDebug.class, TokenDebug.D0, "D", chkDebug, comboFocusGained);
		panelFields.add(fieldDebug, gbc_fieldDebug);



		fieldBarName = new JTextField();
		fieldBarName.setColumns(10);
		panelInfo.add(fieldBarName, gbc_fieldBarName);

		fieldBarDescription = new JTextArea();
		fieldBarDescription.setWrapStyleWord(true);
		fieldBarDescription.setLineWrap(true);
		fieldBarDescription.setColumns(15);
		fieldBarDescription.setRows (3);
		fieldBarDescription.setCaretPosition(0);
		JScrollPane scrollPaneDescription = new JScrollPane(fieldBarDescription);
		panelInfo.add(scrollPaneDescription, gbc_fieldBarDescription);
		
		listQF = new JListEx<>();
		listQF.setToolTipText("Select a quick function to use it in the current field");
		listQF.setListData(TokenQF.values());
		listQF.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()){
				if (lastSelected != null && listQF.getSelectedIndex() >= 0){
					setQF(lastSelected, listQF.getSelectedValue());
				}
				listQF.clearSelection();
			}
		});
		JScrollPane scrollPaneQF = new JScrollPane();
		scrollPaneQF.setViewportView(listQF);
		panelInfo.add(scrollPaneQF, gbc_scrollPaneQF);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(e -> {
			saveBar(bar);
			dispose();
		});
		panelInfo.add(btnSave, gbc_btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e -> {
			dispose();
		});
		panelInfo.add(btnCancel, gbc_btnCancel);
	}
	
	private void loadBar(Bar bar){
		fieldBarName.setText(bar.getName());
		fieldBarDescription.setText(bar.getDescription());
		fieldID.loadFromBar(bar);
		fieldType.loadFromBar(bar);
		fieldDirection.loadFromBar(bar);
		fieldRef.loadFromBar(bar);
		fieldRef_2.loadFromBar(bar);
		fieldTmp.loadFromBar(bar);
		fieldTmp_2.loadFromBar(bar);
		fieldMin.loadFromBar(bar);
		fieldMax.loadFromBar(bar);
		fieldVal.loadFromBar(bar);
		fieldSpell.loadFromBar(bar);
		fieldQuest.loadFromBar(bar);
		fieldSize.loadFromBar(bar);
		fieldX.loadFromBar(bar);
		fieldY.loadFromBar(bar);
		fieldXAdj.loadFromBar(bar);
		fieldYAdj.loadFromBar(bar);
		fieldDepth.loadFromBar(bar);
		fieldSpeed.loadFromBar(bar);
		fieldFadeIn.loadFromBar(bar);
		fieldFadeOut.loadFromBar(bar);
		fieldPopupIn.loadFromBar(bar);
		fieldPopupOut.loadFromBar(bar);
		fieldPopupDirIn.loadFromBar(bar);
		fieldPopupDirOut.loadFromBar(bar);
		fieldBlink.loadFromBar(bar);
		fieldName.loadFromBar(bar);
		fieldName.loadFromBar(bar);
		fieldName_2.loadFromBar(bar);
		fieldTextDisplay.loadFromBar(bar);
		fieldTextType.loadFromBar(bar);
		fieldTextSize.loadFromBar(bar);
		fieldTextColor.loadFromBar(bar);
		fieldTextX.loadFromBar(bar);
		fieldTextY.loadFromBar(bar);
		fieldTextXAdj.loadFromBar(bar);
		fieldTextYAdj.loadFromBar(bar);
		fieldShadowColor.loadFromBar(bar);
		fieldShadowX.loadFromBar(bar);
		fieldShadowY.loadFromBar(bar);
		fieldWrapWidth.loadFromBar(bar);
		fieldWrapLine.loadFromBar(bar);
		fieldVisible.loadFromBar(bar);
		fieldVisibleOn.loadFromBar(bar);
		fieldVisibleTime.loadFromBar(bar);
		fieldVisibleFirst.loadFromBar(bar);
		fieldColor.loadFromBar(bar);
		fieldColorR.loadFromBar(bar);
		fieldColorG.loadFromBar(bar);
		fieldColorB.loadFromBar(bar);
		fieldColorEmpty.loadFromBar(bar);
		fieldColorMin.loadFromBar(bar);
		fieldColorHalf.loadFromBar(bar);
		fieldColorMax.loadFromBar(bar);
		fieldColorFull.loadFromBar(bar);
		fieldColorLow.loadFromBar(bar);
		fieldColorMidLow.loadFromBar(bar);
		fieldColorMidHigh.loadFromBar(bar);
		fieldColorHigh.loadFromBar(bar);
		fieldAlpha.loadFromBar(bar);
		fieldAlphaMin.loadFromBar(bar);
		fieldAlphaInv.loadFromBar(bar);
		fieldAlphaVis.loadFromBar(bar);
		fieldFileCustom.loadFromBar(bar);
		fieldFileCustomBack.loadFromBar(bar);
		fieldFileCustomEdge.loadFromBar(bar);
		fieldFileCustomFront.loadFromBar(bar);
		fieldCustomW.loadFromBar(bar);
		fieldCustomH.loadFromBar(bar);
		fieldCustomBW.loadFromBar(bar);
		fieldCustomBH.loadFromBar(bar);
		fieldCustomEW.loadFromBar(bar);
		fieldCustomEH.loadFromBar(bar);
		fieldCustomEO.loadFromBar(bar);
		fieldCustomX.loadFromBar(bar);
		fieldCustomY.loadFromBar(bar);
		fieldCustomOffset.loadFromBar(bar);
		fieldStore.loadFromBar(bar);
		fieldUpdate.loadFromBar(bar);
		fieldDebug.loadFromBar(bar);
	}

	private void saveBar(Bar bar){
		bar.setName(fieldBarName.getText());
		bar.setDescription(fieldBarDescription.getText());
		fieldID.saveToBar(bar);
		fieldType.saveToBar(bar);
		fieldDirection.saveToBar(bar);
		fieldRef.saveToBar(bar);
		fieldRef_2.saveToBar(bar);
		fieldTmp.saveToBar(bar);
		fieldTmp_2.saveToBar(bar);
		fieldMin.saveToBar(bar);
		fieldMax.saveToBar(bar);
		fieldVal.saveToBar(bar);
		fieldSpell.saveToBar(bar);
		fieldQuest.saveToBar(bar);
		fieldSize.saveToBar(bar);
		fieldX.saveToBar(bar);
		fieldY.saveToBar(bar);
		fieldXAdj.saveToBar(bar);
		fieldYAdj.saveToBar(bar);
		fieldDepth.saveToBar(bar);
		fieldSpeed.saveToBar(bar);
		fieldFadeIn.saveToBar(bar);
		fieldFadeOut.saveToBar(bar);
		fieldPopupIn.saveToBar(bar);
		fieldPopupOut.saveToBar(bar);
		fieldPopupDirIn.saveToBar(bar);
		fieldPopupDirOut.saveToBar(bar);
		fieldBlink.saveToBar(bar);
		fieldName.saveToBar(bar);
		fieldName.saveToBar(bar);
		fieldName_2.saveToBar(bar);
		fieldTextDisplay.saveToBar(bar);
		fieldTextType.saveToBar(bar);
		fieldTextSize.saveToBar(bar);
		fieldTextColor.saveToBar(bar);
		fieldTextX.saveToBar(bar);
		fieldTextY.saveToBar(bar);
		fieldTextXAdj.saveToBar(bar);
		fieldTextYAdj.saveToBar(bar);
		fieldShadowColor.saveToBar(bar);
		fieldShadowX.saveToBar(bar);
		fieldShadowY.saveToBar(bar);
		fieldWrapWidth.saveToBar(bar);
		fieldWrapLine.saveToBar(bar);
		fieldVisible.saveToBar(bar);
		fieldVisibleOn.saveToBar(bar);
		fieldVisibleTime.saveToBar(bar);
		fieldVisibleFirst.saveToBar(bar);
		fieldColor.saveToBar(bar);
		fieldColorR.saveToBar(bar);
		fieldColorG.saveToBar(bar);
		fieldColorB.saveToBar(bar);
		fieldColorEmpty.saveToBar(bar);
		fieldColorMin.saveToBar(bar);
		fieldColorHalf.saveToBar(bar);
		fieldColorMax.saveToBar(bar);
		fieldColorFull.saveToBar(bar);
		fieldColorLow.saveToBar(bar);
		fieldColorMidLow.saveToBar(bar);
		fieldColorMidHigh.saveToBar(bar);
		fieldColorHigh.saveToBar(bar);
		fieldAlpha.saveToBar(bar);
		fieldAlphaMin.saveToBar(bar);
		fieldAlphaInv.saveToBar(bar);
		fieldAlphaVis.saveToBar(bar);
		fieldFileCustom.saveToBar(bar);
		fieldFileCustomBack.saveToBar(bar);
		fieldFileCustomEdge.saveToBar(bar);
		fieldFileCustomFront.saveToBar(bar);
		fieldCustomW.saveToBar(bar);
		fieldCustomH.saveToBar(bar);
		fieldCustomBW.saveToBar(bar);
		fieldCustomBH.saveToBar(bar);
		fieldCustomEW.saveToBar(bar);
		fieldCustomEH.saveToBar(bar);
		fieldCustomEO.saveToBar(bar);
		fieldCustomX.saveToBar(bar);
		fieldCustomY.saveToBar(bar);
		fieldCustomOffset.saveToBar(bar);
		fieldStore.saveToBar(bar);
		fieldUpdate.saveToBar(bar);
		fieldDebug.saveToBar(bar);
		bar.updatePanel();
	}

	private void setQF(JTextFieldEx x, TokenQF token){
		if (token.returnType == null){
			return;
		}
		listQF.setEnabled(false);
		DefineQF dialog = new DefineQF(this, token, x);
		QF qf = x.getQF();
		if (qf != null){
			dialog.setData(x, qf.negate, qf.prefix, qf.caller, qf.params);
		}
		try{
			qf = dialog.get();
			if (qf != null){
				x.useQF(qf);
				listQF.setEnabled(true);
				listQF.requestFocus();
				listQF.setEnabled(false);
			} else {
				listQF.setEnabled(true);
				x.setUsingQF(false);
				x.setText("");
			}
		} catch (Exception e){
			listQF.setEnabled(true);
			listQF.requestFocus();
			listQF.setEnabled(false);
		}
	}
	
	private void parseAllQF(){
		fieldRef.parseQF();
		fieldRef_2.parseQF();
		fieldTmp.parseQF();
		fieldTmp_2.parseQF();
		fieldMin.parseQF();
		fieldMax.parseQF();
		fieldVal.parseQF();
		
		fieldVisible.parseQF();
		fieldVisibleOn.parseQF();
		fieldBlink.parseQF();
		fieldColor.parseQF();
		fieldColorR.parseQF();
		fieldColorG.parseQF();
		fieldColorB.parseQF();
		fieldTextColor.parseQF();
		fieldShadowColor.parseQF();
	}

}