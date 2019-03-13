package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgHelper.LatinSquare;

public class SudokuTest {

	@Test
	public void TestRegionNbr() {

		int[][] MySquare = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };
		// int[][] MySquare = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		Sudoku S = new Sudoku(MySquare);

		int[] arr = S.getRegion(0);
		int[] region = { 1, 2, 4, 1 };

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(region));
		
		System.out.println(Arrays.hashCode(arr));
		System.out.println(Arrays.hashCode(region));

		assertEquals(arr, region);

	}
}