import javax.swing.ImageIcon;

public class King extends Piece
{
	public King(boolean isBlack)
	{
		super(isBlack);
		
		if (isBlack)
		{
			icon = new ImageIcon("bking.gif");
		}
		else
		{
			icon = new ImageIcon("wking.gif");
		}
	}

	@Override
	public boolean canMove(int ysource, int xsource, int xdest, int ydest) 
	{
		if(Math.abs(xdest - xsource) <= 1 && Math.abs(ydest - ysource) <= 1) // move anywhere as a king  !!!! DONE WITH KING!!!!
		{
			return true;  // valid move
		}
		return false;
	}
	
}
