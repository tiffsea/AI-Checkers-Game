/*
 * Author: Tiffany Seeley
 * Course: MSc. Intelligent and Adaptive Systems
 * Institution: University of Sussex, Brighton, UK
 */

import java.util.Scanner;

public class Checkers {
	
	/* declare first player (human) as "white" */
	private static String player = "white";

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //initialize scanner for user input
		
		String[][] board = new String [8][8]; //console checker board will be 8x8 array
		final String EMPTY = "-", //declare final variables to hold string values of either white, black, or respective kings
					WHITE = "W",
					WHITE_KING = "WK",
					BLACK = "B",
					BLACK_KING = "BK";
		
		/* create grid */
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if ( row % 2 == col % 2 ) {
					if (row < 3)
						board[row][col] = BLACK;
					else if (row > 4)
						board[row][col] = WHITE;
					else
						board[row][col] = EMPTY;
				}
				else {
					board[row][col] = EMPTY;
				}
			}
		}
		
		boolean gameIsRunning = true;
		while (gameIsRunning) {
			/* print grid */
			for (int i = 0; i < 8; i++) {
				System.out.println();
				for (int j = 0; j < 8; j++) {
					System.out.print(board[i][j]);
				}
			}
					
			/* human input as move; save moves as array; print moves*/
			int moves[] = new int[4]; //moves[] will be ints of row, col, row, col - user needs to press enter to store next int
			int moveTo[] = new int[2]; //moveTo[] will hold 2 values ints row, col
			int moveFrom[] = new int[2]; //moveFrom[] will hold 2 values ints row, col
			System.out.println("\nchoose a move: (from row, col; to row, col)");
			for(int i=0; i<4; i++){ //store user input in moves[]
	            moves[i]=scanner.nextInt();
	        }
			for (int i = 0; i < moves.length; i++) { //start for loop to print moveFrom and moveTo
				if (i == 0) {
					moveFrom[0] = moves[i];
				}
				if (i == 1) {
					moveFrom[1] = moves[i];
				}
				if (i == 2) {
					moveTo[0] = moves[i];
				}
				if (i == 3) {
					moveTo[1] = moves[i];
				}
			}
					
			/* ensure move is possible */
			boolean moveIsPossible;
			if (board[moveFrom[0]][moveFrom[1]] == EMPTY) {
				System.out.println("\ncannot move from empty space");
			}
			for (int row = 0; row < 8; row++) { //iterate through the board
				for (int col = 0; col < 8; col++) {
					if (player == "white") { //if black player
						if (moveTo[0] == row && moveTo[1] == col) { //if moveTo == the current iteration on board
							if (board[row][col] == EMPTY) { //is the space empty?
								if (row < moveFrom[0]) { //is moveTo space forward?
									System.out.println("\nmove is possible: ");
									moveIsPossible = true;
									break;
								}
								else { //if moveTo space not forward
									moveIsPossible = false;
									System.out.println("\nmove is impossible; non-king tokens can only move forward: ");
									break;
								}
							}
							else { //if not empty, then break
								System.out.println("\nboard[rw][cl] is NOT empty: " + board[row][col]);
								break;
							}
						}						
					}
					else { //if black player
						if (moveTo[0] == row && moveTo[1] == col) { //if moveTo == the current iteration on board
							if (board[row][col] == EMPTY) { //is the space empty?
								if (row > moveFrom[0]) { //is moveTo space forward?
									System.out.println("\nmove is possible: ");
									moveIsPossible = true;
									break;
								}
								else { //if moveTo space not forward
									moveIsPossible = false;
									System.out.println("\nmove is impossible; non-king tokens can only move forward: ");
									break;
								}
							}
							else { //if not empty, then break
								System.out.println("\nboard[rw][cl] is NOT empty: " + board[row][col]);
								break;
							}
						}						
					}
				}
			}
					
			/* do human moves on board */
			board[moveFrom[0]][moveFrom[1]] = EMPTY;//mark space at moveFrom as empty
			if (player == "white") {	
				board[moveTo[0]][moveTo[1]] = WHITE; //mark space at moveTo as white token
			}
			else
				board[moveTo[0]][moveTo[1]] = BLACK; //mark space at moveTo as white token
			
			/* ask if game is over */
			System.out.println("\nis game over? type char 'y' or 'n'");
			char s = scanner.next().charAt(0);
			if (s == 'y'){ //store user input in moves[]
	            gameIsRunning = false;
	        }
			else
				gameIsRunning = true;
				player = "black";
		}
	}
}