import javax.swing.ImageIcon;

public class Queen extends Piece
{
	public Queen(boolean isBlack)
	{
		super(isBlack);
		
		if (isBlack)
		{
			icon = new ImageIcon("bqueen.gif");
		}
		else
		{
			icon = new ImageIcon("wqueen.gif");
		}
	}

	@Override
	public boolean canMove(int ysource, int xsource, int xdest, int ydest) 
	{
		// move anywhere as a rook - rook can either move in y OR in x. // move diagonally as a bishop
					// queen is a combo of rook and bishop so do ||
		
		if (Math.abs(ydest - ysource) <= 7 && (Math.abs(xdest - xsource) <= 7) &&
				// space is filled and a different color OR space is empty;
				((Chess.position[ydest][xdest] != null && (Chess.position[ydest][xdest].isBlack != Chess.position[ysource][xsource].isBlack)) 
						|| (Chess.position[ydest][xdest] == null)))
			
		{
			return true;
		}
		return false;
	}
}
