package pkgGame;

import java.util.Arrays;
import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;
import pkgHelper.PuzzleViolation;

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
		int index = 0;
		for (int iRow = rowStart; iRow < rowStart + iSqrtSize; iRow++) {
			for (int iCol = columnStart; iCol < columnStart + iSqrtSize; iCol++) {
				region[index] = getPuzzle()[iRow][iCol];
				index++;
			}
		}
		return region;
	}

	protected int[] getRegion(int iCol, int iRow) {
		int iRegionNbr = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		return getRegion(iRegionNbr);
	}

	protected boolean isSudoku() {
		setbIgnoreZero(false);
		boolean isSudoku = true;

		if (hasDuplicates()) {
			isSudoku = false;
		}

		if (ContainsZero()) {
			// AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.ContainsZero, i));
			isSudoku = false;
		}

		for (int i = 0; i < iSize; i++) {
			if (!hasAllValues(getRegion(i), getRow(0))) {
				isSudoku = false;
				break;
			}
		}

		return isSudoku;
	}

	protected boolean isPartialSudoku() {
		setbIgnoreZero(true);
		boolean isPartialSudoku = true;

		if (hasDuplicates()) {
			isPartialSudoku = false;
		}

		if (!ContainsZero()) {
			// AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.MissingZero, i));
			isPartialSudoku = false;
		}

		return isPartialSudoku;
	}

	protected boolean isValueValid(int iValue, int iCol, int iRow) {
		boolean isValueValid = true;

		if (doesElementExist(getRow(iRow), iValue)) {
			//AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRow, iRow));
			isValueValid = false;
		}

		if (doesElementExist(getColumn(iCol), iValue)) {
			//AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupCol, iCol));
			isValueValid = false;
		}

		if (doesElementExist(getRegion(iCol, iRow), iValue)) {
			// AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRow, i));
			isValueValid = false;
		}

		if (!isValueValid) {
			// AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.InvalidValue, i));
		}

		return isValueValid;
	}

	@Override
	public boolean hasDuplicates() {
		boolean hasDuplicates = false;

		if (super.hasDuplicates()) {
			hasDuplicates = true;
		} else {
			for (int i = 0; i < iSize; i++) {
				if (hasDuplicates(getRegion(i))) {
					// AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRegion, i));
					hasDuplicates = true;
					break;
				}
			}
		}
		return hasDuplicates;
	}
}