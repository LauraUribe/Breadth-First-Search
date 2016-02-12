import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import java.awt.color.*;

// draws squares and pieces in their position

// JComponent is for drawing
public class BoardComponent extends JComponent

{
	Chess chess; // class object

	public BoardComponent(Chess chess) // passes 'chess' object to
										// 'BoardComponent' so the things here
										// can get drawn on the window;
	{
		super(); // overrides paint component in JComponent with what we have
					// here
		this.chess = chess; // this passes 'BoardComponent' to 'Chess' which is
							// the window
	}

	public void paintComponent(Graphics g) // paint squares on screen
	{
		for (int row = 0; row < 4; row++) // x squares - yellow
		{
			for (int col = 0; col < 8; col++) 
			{
				if (col % 2 == 0) // even rows and columns
				{
					// images are 44 pixels each
					g.setColor(new Color(177, 113, 24)); // creating a new
															// instance of
															// Color....
					g.fillRect(88 * row + 44, col * 44, 44, 44); // even row
					// 88 is distance between two of the same colors

					g.setColor(new Color(233, 174, 95));
					g.fillRect(88 * row, col * 44, 44, 44); // even column
				}

				else // odd rows and columns
				{
					g.setColor(new Color(233, 174, 95));
					g.fillRect(88 * row + 44, col * 44, 44, 44); // odd row

					g.setColor(new Color(177, 113, 24));
					g.fillRect(88 * row, col * 44, 44, 44); // odd column
				}

			}
		}
		for (int col = 0; col < 8; col++) // go through each piece and paint them
		{
			for (int row = 0; row < 8; row++) 
			{
				if (chess.position[col][row] != null) // if position is filled;
				{
					chess.position[col][row].drawPiece(g, row * 44, col * 44); // draw the piece that is in that position	
					// System.out.println("I'm in this if statement");  <-----DEBUGGING
				}
			}
		}
		/* for (int col = 0; col < 8; col++)  // repaints the moved pieces to their new 'home';  -- just need to call
		{
			for (int row = 0; row < 8; row++)
			{
				if (Chess.position[row][col] == null);  // if new home is not filled;
				{
					Chess.position[row][col].drawPiece(g, row * 44, col * 44);  // draw piece in new home;
				}
				
			}
		} */
	}
}


	
	

