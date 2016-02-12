import javax.swing.ImageIcon;

public class Pawn extends Piece
{
	public Pawn(boolean isBlack)  // constructor, always name after class and include '()' after it.
	{
		super(isBlack);  // super for Pawns.
		
		if (isBlack)
		{
			icon = new ImageIcon("bpawn.gif");
		}
		else
		{
			icon = new ImageIcon("wpawn.gif");
		}
	}

	@Override  // MOVEMENT FOR PAWN
	public boolean canMove(int ysource, int xsource, int xdest, int ydest) 
	{
		if ((Chess.position[ysource][xsource].isBlack && ((ydest - ysource == 1 && xdest - xsource == 0))) || (Chess.position[ydest][xdest] != null 
				//filled destination
				&& (!Chess.position[ydest][xdest].isBlack && ydest - ysource == 1 && xdest - xsource == 1)))  // black pieces move 
			
		// clicked on black piece, now check to see if move if 1 (y direction going down);
		// pawns can only move in the y direction. Not x.
		{
			return true;  // valid movement for black piece
		}
		
		if ((!Chess.position[ysource][xsource].isBlack && ((ydest - ysource == -1 && xdest - xsource == 0))) || (Chess.position[ydest][xdest] != null 
				//filled
				&& (!Chess.position[ydest][xdest].isBlack && ydest - ysource == 1 && xdest - xsource == 1))) // white pieces move
		{
			return true;  // valid movement for white piece
		}
	
		// this bottom portion allows pawns to move a max of 2 spaces up/down (depending on whether it is a black or white pawn);
		if (!Chess.position[ysource][xsource].isBlack && ysource == 6 && (ydest - ysource == -2 && xdest - xsource == 0) &&
				Chess.position[ydest - 1][xdest] == null && Chess.position[ydest][xdest] == null)  // white piece
		{
			return true;
		}
		
		else if (Chess.position[ysource][xsource].isBlack && ysource == 1 && (ydest - ysource == 2 && xdest - xsource == 0) &&
				Chess.position[ydest + 1][xdest] == null && Chess.position[ydest][xdest] == null)  // black piece
		{
			return true;
		}
		
		// MOVEMENT underneath here move pawn diagonally and take over
		if ((Chess.position[ysource][xsource].isBlack && ((ydest - ysource == 1 && (xdest - xsource == 1 || xdest - xsource == -1)))
				&& (Chess.position[ydest][xdest] != null) 
				//filled destination
				// black
				|| (!Chess.position[ysource][xsource].isBlack && (ydest - ysource == -1 && (xdest - xsource == 1 || (xdest - xsource == -1)) 
				&& (Chess.position[ydest][xdest] != null)))))  // white pieces move
		{
			return true;
		}
					
		return false;  // else, white/black piece is making an invalid move.
		
	}
}