import javax.swing.ImageIcon;

public class Rook extends Piece
{
	public Rook(boolean isBlack)
	{
		super(isBlack);
		
		if (isBlack)
		{
			icon = new ImageIcon("brook.gif");
		}
		else
		{
			icon = new ImageIcon("wrook.gif");
		}
	}

	@Override
	public boolean canMove(int ysource, int xsource, int xdest, int ydest) 
	{
		// move anywhere as a rook - rook can either move in y OR in x. // space is filled and a different color OR space is empty;
		if (((Math.abs(xdest - xsource) == 0 && Math.abs(ydest - ysource) != 0) && (Chess.position[ydest][xdest] != null 
				&& Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack 
				|| Chess.position[ydest][xdest] == null))
			|| ((Math.abs(xdest - xsource) != 0 && Math.abs(ydest - ysource) == 0) 
			&& (Chess.position[ydest][xdest] != null && Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack
					|| Chess.position[ydest][xdest] == null)))
		{
			return true;
		}
		return false;
	}
}
