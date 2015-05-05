package P36_Sudoku_Solver;

import java.util.Arrays;

public class Solution {
	private boolean isValidSudoku(char[][] board, int row, int column) {
		int i, j;
		int[] valid1 = new int[10];
		int[] valid2 = new int[10];
		int[] valid3 = new int[10];
		for (i = 0; i < 9; i++) {
			if (board[i][column] != '.') {
				if (valid1[board[i][column] - '0'] > 0)
					return false;
				valid1[board[i][column] - '0']++;
			}
			if (board[row][i] != '.') {
				if (valid2[board[row][i] - '0'] > 0)
					return false;
				valid2[board[row][i] - '0']++;
			}
		}
		for (i = (row / 3) * 3; i < (row / 3 + 1) * 3; i++) {
			for (j = (column / 3) * 3; j < (column / 3 + 1) * 3; j++) {
				if (board[i][j] != '.') {
					if (valid3[board[i][j] - '0'] > 0)
						return false;
					valid3[board[i][j] - '0']++;
				}
			}
		}
		return true;
	}

	private boolean internalSolveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = (char) ('0' + k);
						if (isValidSudoku(board, i, j)
								&& internalSolveSudoku(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	public void solveSudoku(char[][] board) {
		internalSolveSudoku(board);
	}

	public static void main(String[] args) {
		String[] str = new String[] { "...2...63", "3....54.1", "..1..398.",
				".......9.", "...538...", ".3.......", ".263..5..",
				"5.37....8", "47...1..." };
		char[][] board = new char[str.length][];
		for (int i = 0; i < str.length; i++) {
			board[i] = str[i].toCharArray();
		}
		Solution s = new Solution();
		s.solveSudoku(board);
		for (int i = 0; i < str.length; i++) {
			System.out.println(Arrays.toString(board[i]));
//			for (int j = 0; j < 9; j++)
//				System.out.print(board[i][j]);
//			System.out.println();
		}
	}
}
