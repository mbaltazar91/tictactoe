package com.mitch.UI;


public class Board {
	
	private final int rows;
	private final int columns;
	private final String[][] board;
	
	public Board(int rows) {
		this.rows = rows;
		this.columns = rows;
		this.board = new String[rows][columns];
	}
	
	public void drawBoard() {
		for(int i = 0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				if(board[i][j]==null) {
					
					board[i][j] = "# ";
				}
					System.out.print(board[i][j]);
				
		}
			System.out.println();
	}
		System.out.println();
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public String[][] getBoard(){
		return board;
	}
	
	
	
	
	

}
