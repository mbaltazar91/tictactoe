package com.mitch.game;

import com.mitch.UI.Board;

public class BoardChecker {

	public static boolean checkDiagonals(Board board) {
		boolean leftDiagonal = true;
		boolean rightDiagonal = true;
		String firstValueLeft = board.getBoard()[0][0];
		String firstValueRight = board.getBoard()[0][board.getColumns() - 1];



		for (int i = 0; i < board.getRows(); i++) {
			if (board.getBoard()[i][i].equals("# ")||board.getBoard()[i][i] != firstValueLeft) {
				leftDiagonal = false;
				break;
			}
		}
		for (int i = 0; i < board.getRows(); i++) {
			if (board.getBoard()[i][board.getColumns() - (i + 1)].equals("# ")||board.getBoard()[i][board.getColumns() - (i + 1)] != firstValueRight) {
				rightDiagonal = false;
				break;
			}
		}
		return leftDiagonal || rightDiagonal;
	}

	public static boolean checkRows(Board board) {
		boolean row = true;
		for (int i = 0; i < board.getRows(); i++) {
			row = true;
			String firstValue = board.getBoard()[i][0];
			for (int j = 0; j < board.getColumns(); j++) {
				if (board.getBoard()[i][j].equals("# ")||!board.getBoard()[i][j].equals(firstValue)) {
					row = false;
					break;
				}
			}
			if(row){
				break;
			}

		}
		return row;
	}

	public static boolean checkColumns(Board board) {
		boolean column = true;
		for (int i = 0; i < board.getRows(); i++) {
			column = true;
			String firstValue = board.getBoard()[0][i];
			for (int j = 0; j < board.getColumns(); j++) {
				if (board.getBoard()[j][i].equals("# ")||!board.getBoard()[j][i].equals(firstValue)) {
					column = false;
					break;
				}
			}
			if(column){
				break;
			}

		}
		return column;
	}

	public static boolean checkForWin(Board board) {
		return checkDiagonals(board)||checkRows(board)||checkColumns(board);
	}

	public static boolean checkGameOver(Board board) {

		boolean gameOver = true;

		for(int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				gameOver = (board.getBoard()[i][j].equals("# "))?false:gameOver;
			}
		}
		return gameOver;
	}

}
