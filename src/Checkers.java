/*
 * Author: Tiffany Seeley
 * Course: MSc. Intelligent and Adaptive Systems
 * Institution: University of Sussex, Brighton, UK
 */

//necessary imports
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


//start of main class
public class Checkers {
	
	//declare scanner to get user input
	static Scanner input = new Scanner(System.in);

	/*
	 * declare and initialize  global variables
	 */
	
	//board variables
	public static int rows = getRows();
	public static int tuples = getTuples();
	public static Color color1 = Color.black;
	public static Color color2 = Color.red;
	
	
	//main method
	public static void main(String[] args) {
		
		//create board using java functions
		JFrame checkerBoard = new JFrame();
		checkerBoard.setSize(500, 500);
		checkerBoard.setTitle("CheckerBoard");
		Container pane = checkerBoard.getContentPane();
		pane.setLayout(new GridLayout(rows, tuples));
		
		//create checkered board
		Color tmp;
		for(int i=0; i < rows; i++) {
			if(i%2 == 0) {
				tmp = color1;
			}
			else {
				tmp = color2;
			}
			for(int j=0; j < tuples; j++) {
				JPanel panel = new JPanel();
				panel.setBackground(tmp);
				if(tmp.equals(color1)) {
					tmp = color2;
				}
				else {
					tmp = color1;
				}
				pane.add(panel);
			}
		}
		checkerBoard.setVisible(true);
		System.out.println("End");
	}

	private static int getTuples() {
		
		System.out.print("Enter number of CheckerBoard tuples: ");
		int num_tups = Integer.parseInt((input.nextLine()));
		return num_tups;
	}

	private static int getRows() {
				
		System.out.print("Enter number of CheckerBoard rows: ");
		int num_rows = Integer.parseInt((input.nextLine()));
		return num_rows;
	}
}
