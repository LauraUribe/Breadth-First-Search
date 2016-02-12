import javax.swing.ImageIcon;

public class Knight extends Piece
{
	public Knight(boolean isBlack)
	{
		super(isBlack);
		
		if (isBlack)
		{
			icon = new ImageIcon("bknight.gif");
		}
		else
		{
			icon = new ImageIcon("wknight.gif");
		}
	}

	@Override
	public boolean canMove(int ysource, int xsource, int xdest, int ydest)   // knight moves in an "L" shape
	{
		/* if((Math.abs(xdest - xsource) <= 1 && (Math.abs(ydest - ysource) == 2)) || 
				((Math.abs(xdest - xsource) == 2) && (Math.abs(ydest - ysource) <= 1))) // move in an "L" shape as a knight
		*/
			
		if ((Math.abs(xdest - xsource) <= 1 && (Math.abs(ydest - ysource) == 2) || (Math.abs(xdest - xsource) <= -1) && (Math.abs(ydest - ysource) == 2)))
		{
			return true;  // valid move
		}
		
		if ((Math.abs(xdest - xsource) == 2 && (Math.abs(ydest - ysource) <= 1) || (Math.abs(xdest - xsource) == 2) && (Math.abs(ydest - ysource) <= -1)))
		{
			return true;
		}
		
		if ((Math.abs(xdest - xsource) == 1 && (Math.abs(ydest - ysource) == -2) || (Math.abs(xdest - xsource) <= -1) && (Math.abs(ydest - ysource) == -2)))
		{
			return true;
		}
		
		if ((Math.abs(xdest - xsource) == 2 && (Math.abs(ydest - ysource) <= 1) || (Math.abs(xdest - xsource) == 2) && (Math.abs(ydest - ysource) <= -1)))
		{
			return true;
		}
		
		return false;
	}
}
