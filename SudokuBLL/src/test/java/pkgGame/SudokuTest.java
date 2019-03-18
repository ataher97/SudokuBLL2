package pkgGame;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;

public class SudokuTest {

	@Test(expected = Exception.class)
	public void Sudoku_test1() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4, 5 }, { 2, 3, 1, 5, 4 }, { 5, 4, 3, 2, 1 }, { 4, 5, 2, 1, 3 },
				{ 1, 2, 3, 4, 5 } };

		new Sudoku(MySquare.length);

	}

	@Test(expected = Exception.class)
	public void Sudoku_test2() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4, 5 }, { 2, 3, 1, 5, 4 }, { 5, 4, 3, 2, 1 }, { 4, 5, 2, 1, 3 },
				{ 1, 2, 3, 4, 5 } };

		new Sudoku(MySquare);

	}

	@Test
	public void getRegionNbr_test1() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(0);
		int[] region = { 1, 2, 4, 1 };

		assertTrue(Arrays.equals(arr, region));

	}

	@Test
	public void getRegionNbr_test2() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(3);
		int[] region = { 1, 2, 4, 1 };

		assertTrue(Arrays.equals(arr, region));

	}

	@Test(expected = Exception.class)
	public void getRegionNbr_test3() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(10);
		int[] region = { 1, 2, 4, 1 };

		assertTrue(Arrays.equals(arr, region));

	}

	@Test
	public void getRegion_test1() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(0, 0);
		int[] region = { 1, 2, 4, 1 };

		assertTrue(Arrays.equals(arr, region));
	}

	@Test
	public void getRegion_test2() throws Exception {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(3, 3);
		int[] region = { 1, 2, 4, 1 };

		assertTrue(Arrays.equals(arr, region));
	}

	@Test
	public void isSudoku_test1() throws Exception {

		int[][] MySquare = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertTrue(S.isSudoku());
	}

	@Test
	public void isSudoku_test2() throws Exception {

		int[][] MySquare = { { 5, 5, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isSudoku());
	}

	@Test
	public void isSudoku_test3() throws Exception {

		int[][] MySquare = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isSudoku());
	}

	@Test
	public void isSudoku_test4() throws Exception {

		int[][] MySquare = { { 10, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isSudoku());
	}

	@Test
	public void isPartialSudoku_test1() throws Exception {

		int[][] MySquare = { { 0, 0, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertTrue(S.isPartialSudoku());
	}

	@Test
	public void isPartialSudoku_test2() throws Exception {

		int[][] MySquare = { { 5, 5, 0, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isPartialSudoku());
	}

	@Test
	public void isPartialSudoku_test3() throws Exception {

		int[][] MySquare = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isPartialSudoku());
	}

	@Test
	public void isValueValid_test1() throws Exception {

		int[][] MySquare = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertTrue(S.isValueValid(5, 0, 0));
	}

	@Test
	public void isValueValid_test2() throws Exception {

		int[][] MySquare = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.isValueValid(6, 0, 0));
	}

	@Test
	public void hasDuplicates_test1() throws Exception {

		int[][] MySquare = { { 3, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertTrue(S.hasDuplicates());
	}

	@Test
	public void hasDuplicates_test2() throws Exception {

		int[][] MySquare = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		Sudoku S = new Sudoku(MySquare);

		assertFalse(S.hasDuplicates());
	}

}