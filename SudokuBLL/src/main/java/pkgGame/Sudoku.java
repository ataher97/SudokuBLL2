package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {

	private int iSize = getPuzzle().length;
	private int iSqrtSize = (int) Math.sqrt(iSize);

	public Sudoku() {
		super();
	}

	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}

	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}

	protected int[] getRegion(int iRegionNbr) {

		int columnStart = iRegionNbr % iSqrtSize * iSqrtSize;
		int rowStart = iRegionNbr / iSqrtSize * iSqrtSize;

		int[] region = new int[iSize];
		int index = 0; // Fix naming in for loop----------------------------
		for (int i = columnStart; i < columnStart + iSqrtSize; i++) {
			for (int j = rowStart; j < rowStart + iSqrtSize; j++) {
				region[index] = getPuzzle()[i][j];
				index++;
			}
		}
		return region;
	}

	protected int[] getRegion(int iCol, int iRow) {
		int iRegionNbr = (iCol % iSqrtSize) + ((iRow % iSqrtSize) * iSqrtSize);
		return getRegion(iRegionNbr);
	}

	protected boolean isSudoku() {
		setbIgnoreZero(false);
		boolean isSudoku = false;

		if (isPartialSudoku() && !ContainsZero()) { // Will this work with how isPartialSudoku() is implemented?
			isSudoku = true;
		}
		return isSudoku;
	}

	protected boolean isPartialSudoku() {
		setbIgnoreZero(true);
		boolean isPartialSudoku = true;

		if (!isLatinSquare()) {
			isPartialSudoku = false;
		}
		if(hasDuplicates()) {
			isPartialSudoku = false;
		}
		for(int i = 0; i < iSize; i++) { // Is this right?-------------------
			if(hasAllValues(getRegion(i),getRow(0))) {
				isPartialSudoku = false;
				break;
			}
		}
		if(!ContainsZero()) { // How can this be used with isSudoku()?---------
			isPartialSudoku = false;
		}

		return isPartialSudoku;
	}

	protected boolean isValueValid(int iValue, int iCol, int iRow) {
		boolean isValueValid = true;

		

		return isValueValid;
	}

	@Override
	public boolean hasDuplicates() {
		boolean hasDuplicates = false;

		if (!super.hasDuplicates()) {
			for (int i = 0; i < iSize; i++) {
				if (hasDuplicates(getRegion(i))) {
					hasDuplicates = true;
					break;
				}
			}
		}
		return hasDuplicates;
	}

}