package twoDimensionalArrays;
import java.util.Arrays;

public class Chessboard {
	
	public static void main(String[] args) {

		String [][] chessboard = new String [8][8];
		String [] blackRowOne = {"BRook", "BKnight", "BBishop", "BQueen", "BKing", "BBishop", "BKnight", "BRook"};
		String [] blackRowTwo = {"BPawn", "BPawn", "BPawn", "BPawn", "BPawn", "BPawn", "BPawn", "BPawn"};
		String [] whiteRowSeven = {"WPawn", "WPawn", "WPawn", "WPawn", "WPawn", "WPawn", "WPawn", "WPawn"};
		String [] whiteRowEight = {"WRook", "WKnight", "WBishop", "WQueen", "WKing", "WBishop", "WKnight", "WRook"};
		
		String emptySpace = "empty";
		
		chessboard [0] = blackRowOne;
		chessboard [1] = blackRowTwo;
		chessboard [6] = whiteRowSeven;
		chessboard [7] = whiteRowEight;
		
		for (int row = 2; (row < chessboard.length - 2); row++) {
			for (int col = 0; col < chessboard[row].length; col++) {
				chessboard[row][col] = emptySpace;
			}
		}
		
		int wPawnCounter = 0;
		
		for (int row = 0; row < chessboard.length; row++) {
			for (int col = 0; col < chessboard[row].length; col++) {
				if (chessboard[row][col].equals("WPawn")) {
					wPawnCounter++;
				}
				System.out.print(chessboard[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("\nNumber of white pawns = " + wPawnCounter);
	}
	
}
