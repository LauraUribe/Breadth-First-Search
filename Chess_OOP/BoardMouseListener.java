// identifies which piece is selected by the user’s mouse;
// calls the appropriate methods to move it


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ARRAY GOES Y,X !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{
	// BoardComponent boardRPT;  // BoardComponent is static - so it must be a global variable;
	int x, y;
	boolean isTurnBlack;

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		e.getX(); 
		e.getY();
		
		x = e.getX() / 44;  // converting initial index row value (remember position[row][col]) into x and y coordinates 
		y = e.getY() / 44;
		System.out.println("x coord:" + x + ", y coord: " + y);

	}
	

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		int row, col;  // converting final (moved piece) index row value to x,y coord's.
		col = e.getX() / 44;
		row = e.getY() / 44;
		
		// BIG MOVEMENT PIECE (PART OF A BLUEPRINT FOR THEM, RELATES TO MOUSELISTENER SO IT'S HERE) && KEEPS TRACK OF WHOSE TURN IT IS;
		// System.out.println("col:" + col + ", row: " + row);  // <--- DEBUGGING
		if (Chess.position[y][x] != null) //filled
		{
			if (Chess.position[y][x].isBlack == isTurnBlack) // black piece
			{
				if(Chess.position[row][col] == null || Chess.position[row][col].isBlack != isTurnBlack) // new empty space or blacke piece
				{
					if(Chess.position[y][x].canMove(y, x, col, row))
					{
						Chess.position[row][col] = Chess.position[y][x];  // final piece = initial piece; // updating position
						Chess.position[y][x] = null;  // makes initial empty
						
						Chess.boardcomponent.repaint();  // repainting all changes
						
						if(isTurnBlack)  // saying whether it is actually true or false that it's black's turn;
						{
							isTurnBlack = false;  // no return bc this is a void function; // make it white's turn;
						}
						else 
						{
							isTurnBlack = true;
						}
					}	
				}
			}
				
		}
		
			// if initial position is filled; we grab a piece AND it is a valid movement;
		// (blah || blah) --> final position is empty or if it is black, then you can take over that piece. 
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
