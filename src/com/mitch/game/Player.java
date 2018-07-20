package com.mitch.game;

import java.util.Scanner;

import com.mitch.UI.Board;

public class Player {

	private String name;
	private String icon;
	private Scanner sc;

	public Player(String name, String icon) {
		this.name = name;
		this.icon = icon;
		this.sc = new Scanner(System.in);

	}

	public int[] chooseMove(int rows, int columns) {
		int[] move = new int[2];
		while (true) {
			try {
				System.out.print("Choose row: ");
				int row = Integer.parseInt(sc.nextLine());
				System.out.print("Choose Column: ");
				int column = Integer.parseInt(sc.nextLine());
				System.out.println();
				if (row <= rows && column <= columns) {
					move[0] = row;
					move[1] = column;
					break;
				}
			} catch (NumberFormatException n) {
				System.out.println("Enter a number.");
			}
		}
		return move;

	}

	public void playMove(Board board) {
		boolean movePlayed = false;
		while (!movePlayed) {
			int[] move = chooseMove(board.getRows(), board.getColumns());
			if (board.getBoard()[move[0]][move[1]].trim().equals("#")) {
				board.getBoard()[move[0]][move[1]] = icon;
				movePlayed = true;
			} else {
				System.out.println("Pick valid move.");
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getIcon() {
		return icon;
	}

}
