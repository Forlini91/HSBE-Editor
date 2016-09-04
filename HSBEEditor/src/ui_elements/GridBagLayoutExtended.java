package ui_elements;

import java.awt.GridBagLayout;
import java.util.Arrays;

/**
 * A customized GridBagLayout
 * @author MarcoForlini
 */
public class GridBagLayoutExtended extends GridBagLayout{
	
	private static final long serialVersionUID = 7191398866484805928L;
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * @param columnWidths	The columns widths
	 * @param rowHeights	The rows heights
	 * @param columnWeights	The columns weights
	 * @param rowWeights	The rows weights
	 */
	public GridBagLayoutExtended (int[] columnWidths, int[] rowHeights, double[] columnWeights, double[] rowWeights) {
		this.columnWidths = columnWidths;
		this.rowHeights = rowHeights;
		this.columnWeights = columnWeights;
		this.rowWeights = rowWeights;
	}
	
	/**
	 * Create a new {@link GridBagConstraintsExtended}
	 * @param columnWidths	The columns widths
	 * @param columnWeights	The columns weights
	 * @param numRows		The number of rows
	 */
	public GridBagLayoutExtended (int[] columnWidths, double[] columnWeights, int numRows) {
		this.columnWidths = columnWidths;
		this.columnWeights = columnWeights;
		rowHeights = new int[numRows];
		rowWeights = new double[numRows];
		Arrays.fill(rowHeights, 0);
		Arrays.fill(rowWeights, 0, numRows-1, 0);
		rowWeights[numRows-1] = Double.MIN_VALUE;
	}

}
