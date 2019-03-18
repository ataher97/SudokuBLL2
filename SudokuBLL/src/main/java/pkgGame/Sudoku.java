package pkgGame;

import java.util.Arrays;
import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;
import pkgHelper.PuzzleViolation;

public class Sudoku extends LatinSquare {

	private int iSize;
	private int iSqrtSize;

	public Sudoku() {
		super();
	}

	public Sudoku(int iSize) throws Exception {
		if ((int) Math.sqrt(iSize) != Math.sqrt(iSize)) {
			throw new Exception("Invalid Size");
		} else {
			this.iSize = iSize;
			this.iSqrtSize = (int) Math.sqrt(iSize);
		}
	}

	public Sudoku(int[][] latinSquare) throws Exception {
		super(latinSquare);
		if ((int) Math.sqrt(latinSquare.length) != Math.sqrt(latinSquare.length)) {
			throw new Exception("Invalid Size");
		} else {
			this.iSize = latinSquare.length;
			this.iSqrtSize = (int) Math.sqrt(latinSquare.length);
		}
	}

	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}

	protected int[] getRegion(int iRegionNbr) throws Exception {

		if ((iRegionNbr + 1 > iSize)) {
			throw new Exception("Bad Region Call");
		}

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

	protected int[] getRegion(int iCol, int iRow) throws Exception {
		int iRegionNbr = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		return getRegion(iRegionNbr);
	}

	protected boolean isSudoku() throws Exception {
		setbIgnoreZero(false);
		boolean isSudoku = true;

		if (hasDuplicates()) {
			isSudoku = false;
		}

		if (ContainsZero()) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.ContainsZero, 0));
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

	protected boolean isPartialSudoku() throws Exception {
		setbIgnoreZero(true);
		boolean isPartialSudoku = true;

		if (hasDuplicates()) {
			isPartialSudoku = false;
		}

		if (!ContainsZero()) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.MissingZero, 0));
			isPartialSudoku = false;
		}

		return isPartialSudoku;
	}

	protected boolean isValueValid(int iValue, int iCol, int iRow) throws Exception {
		boolean isValueValid = true;

		if (doesElementExist(getRow(iRow), iValue)) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRow, iRow));
			isValueValid = false;
		}

		if (doesElementExist(getColumn(iCol), iValue)) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupCol, iCol));
			isValueValid = false;
		}

		if (doesElementExist(getRegion(iCol, iRow), iValue)) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRegion, 0));
			isValueValid = false;
		}

		if (!isValueValid) {
			AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.InvalidValue, 0));
		}

		return isValueValid;
	}

	@Override
	public boolean hasDuplicates() throws Exception {
		boolean hasDuplicates = false;

		if (super.hasDuplicates()) {
			hasDuplicates = true;
		} else {
			for (int i = 0; i < iSize; i++) {
				if (hasDuplicates(getRegion(i))) {
					AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRegion, i));
					hasDuplicates = true;
					break;
				}
			}
		}
		return hasDuplicates;
	}
}