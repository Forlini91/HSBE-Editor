package ui_elements;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Customized GridBatoConstraints
 * @author MarcoForlini
 */
public class GridBagConstraintsExtended extends GridBagConstraints {

	private static final long serialVersionUID = -7505596536967581792L;
	
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * @param row	The row index
	 */
	public GridBagConstraintsExtended (int row) {
		insets = new Insets(0, 0, 0, 0);
		anchor = WEST;
		fill = BOTH;
		gridwidth = 3;
		gridx = 0;
		gridy = row;
	}
	
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * @param row		The row index
	 * @param column	The column index
	 */
	public GridBagConstraintsExtended (int row, int column){
		insets = new Insets((row == 0 ? 5 : 0), (column == 0 ? 5 : 0), 5, 5);
		anchor = WEST;
		fill = BOTH;
		gridx = column;
		gridy = row;
	}
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * @param row		The row index
	 * @param column	The column index
	 * @param fillMode		The fill mode
	 */
	public GridBagConstraintsExtended (int row, int column, int fillMode){
		fill = fillMode;
		gridx = column;
		gridy = row;
	}

	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * This is made for the bar editor fields
	 * @param top			Top border
	 * @param left			Left border
	 * @param bottom		Bottom border
	 * @param right			Right border
	 * @param row			The row index
	 * @param column		The column index
	 */
	public GridBagConstraintsExtended (int top, int left, int bottom, int right, int row, int column){
		insets = new Insets(top, left, bottom, right);
		fill = HORIZONTAL;
		gridx = column;
		gridy = row;
	}
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * This is made for the bar editor labels/separators
	 * @param top			Top border
	 * @param left			Left border
	 * @param bottom		Bottom border
	 * @param right			Right border
	 * @param row			The row index
	 * @param column		The column index
	 * @param fillAnchor	If true, set fill to BOTH and anchor to EAST
	 */
	public GridBagConstraintsExtended (int top, int left, int bottom, int right, int row, int column, boolean fillAnchor){
		insets = new Insets(top, left, bottom, right);
		if (fillAnchor){
			fill = BOTH;
			anchor = EAST;
		}
		gridx = column;
		gridy = row;
	}
	

	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * This is made for the bar editor labels/separators
	 * @param top			Top border
	 * @param left			Left border
	 * @param bottom		Bottom border
	 * @param right			Right border
	 * @param row			The row index
	 * @param column		The column index
	 * @param nRows			Num of occuiped rows
	 * @param nColumns		Num of occupied columns
	 * @param fillMode		The fill mode
	 */
	public GridBagConstraintsExtended (int top, int left, int bottom, int right, int row, int column, int nRows, int nColumns, int fillMode){
		insets = new Insets(top, left, bottom, right);
		fill = fillMode;
		gridx = column;
		gridy = row;
		gridheight = nRows;
		gridwidth = nColumns;
	}
	

}
