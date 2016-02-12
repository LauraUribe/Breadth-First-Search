import javax.swing.ImageIcon;

public class Bishop extends Piece
{
	public Bishop(boolean isBlack)
	{
		super(isBlack);  // gets the value passed from 'Piece' so we can get the correct output from "boolean isBlack" which is before this line.
		
		if (isBlack)
		{
			icon = new ImageIcon("bbishop.gif");
		}
		else
		{
			icon = new ImageIcon("wbishop.gif");
		}
	}
	
	@Override
	public boolean canMove(int ysource, int xsource, int xdest, int ydest)  // changed ysource and xsource;
	{
		// underneath here: move diagonally as many spaces as they want -- bishop  
		// do not allow bishop to jump over anyone;
		System.out.println(xsource+ " ," +ysource);
		if (Math.abs(ydest - ysource) == (Math.abs(xdest - xsource)) &&  // diagonal movement
				// space is filled and a different color is there OR space is empty;
				((Chess.position[ydest][xdest] != null && (Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack)) 
						|| (Chess.position[ydest][xdest] == null)))
		{
			// checks to see what is in its way to move, otherwise cannot move if there is something. 
			
			// checks movement (right-based)
			int tsource = ysource;  // tsource becomes ysource;  // down right
			if (xsource < xdest && ysource < ydest)  // so we don't enter wrong for loop  // if we are moving // we are assuming we are black
			{
				System.out.println("down right");
				for (int zsource = xsource; zsource < xdest; zsource++)  // zsource becomes xsource
				{
					// down and right
					if(Chess.position[tsource + 1][zsource + 1] != null)  // all values in between source and destination and if it finds a filled space, then...
						{
							return false;  // it is an invalid movement.
						}
					tsource += 1;	
				}
			}
			
			else if (xsource < xdest && ysource > ydest)  // up right;
			{
				System.out.println("up right,"+xsource+","+xdest+","+ysource+","+ydest+",");  // DEBUGGING!!!!!!!!!!
				for (int zsource = xsource; zsource < xdest; zsource++)
					// up right
					if(Chess.position[tsource - 1][zsource + 1] != null)  // all values in between source and destination and if it finds a filled space, then...
						{
							return false;  // it is an invalid movement.
						}
					tsource -= 1;
			}
			
			else if (xsource > xdest && ysource > ydest)  // up left
			{
				System.out.println("up left");  // DEBUGGING!!
				for (int zsource = xsource; zsource < xdest; zsource--)
					// up right
					if(Chess.position[tsource - 1][zsource - 1] != null)  // all values in between source and destination and if it finds a filled space, then...
						{
							return false;  // it is an invalid movement.
						}
					tsource -= 1;
			}
			
			else if (ysource < ydest && xsource > xdest)  // down left;
			{
				System.out.println("down left");
				for (int zsource = xsource; zsource < xdest; zsource--)
					// up right
					if(Chess.position[tsource + 1][zsource - 1] != null)  // all values in between source and destination and if it finds a filled space, then...
						{
							return false;  // it is an invalid movement.
						}
					tsource += 1;
			}
			
			return true;  // valid move
		}
		/* if (Math.abs(ydest - ysource) == (Math.abs(xdest - xsource)) && 
				// space is filled and a different color OR space is empty;
				((Chess.position[ydest][xdest] != null && (Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack)) 
						|| (Chess.position[ydest][xdest] == null)))
		{
			return true;  // valid move
		}
		if (Math.abs(ydest - ysource) == (Math.abs(xdest - xsource)) && 
				// space is filled and a different color OR space is empty;
				((Chess.position[ydest][xdest] != null && (Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack)) 
						|| (Chess.position[ydest][xdest] == null)))
		{
			return true;  // valid move
		}
		if (Math.abs(ydest - ysource)== (Math.abs(xdest - xsource)) && 
				// space is filled and a different color OR space is empty;
				((Chess.position[ydest][xdest] != null && (Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack)) 
						|| (Chess.position[ydest][xdest] == null)))
		{
			return true;  // valid move
		}
		*/
		
		return false;
	}
}
