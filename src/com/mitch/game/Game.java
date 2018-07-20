package com.mitch.game;

import java.util.Scanner;

import com.mitch.UI.Board;

public class Game {
	
	private static Scanner sc = new Scanner(System.in);
	private int playerNumber;

	private Board board;
	private Player player1;
	private Player player2;
	
	public Game() {
		playerNumber = 1;
	}

	public void play() {
		boolean playing = true;
		while(playing) {
		player1 = createPlayer();
		player2 = createPlayer();
		board = createBoard();
		while(true) {
			System.out.println(player1.getName()+":");
			board.drawBoard();
			player1.playMove(board);
		    if(BoardChecker.checkForWin(board)) {
				board.drawBoard();
				System.out.println(player1.getName() + " wins!");
				break;
			}
			if(BoardChecker.checkGameOver(board)) {
				System.out.println("No one wins!");
				break;
			}
			System.out.println(player2.getName()+":");
			board.drawBoard();
			player2.playMove(board);
		    if(BoardChecker.checkForWin(board)) {
				board.drawBoard();
				System.out.println(player2.getName() + " wins!");
				break;
			}
			if(BoardChecker.checkGameOver(board)) {
				System.out.println("No one wins!");
				break;
			}
		}
		System.out.println("Play Again?(y/n)");
		String playAgain = sc.nextLine();
		if(playAgain.toLowerCase().equals("n")) {
			break;
		}
		
		
		

	}
	}
	
	public Board createBoard() {
		System.out.print("Enter size of board: ");
		int boardSize = Integer.parseInt(sc.nextLine());
		return new Board(boardSize);
	}
	
	public Player createPlayer() {
		playerNumber = (playerNumber>2)?1:playerNumber;
		String icon = (playerNumber<2)?"X ":"O ";
		System.out.print("Enter name for player" + playerNumber + ": ");
		String name = sc.nextLine();
		playerNumber++;
		return new Player(name,icon);
	}

}

