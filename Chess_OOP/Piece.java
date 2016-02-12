// abstract class modeling an individual piece
import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Piece // ABSTRACT : template other things must follow;

{
	ImageIcon icon;
	boolean isBlack;
	
	public void drawPiece(Graphics g, int xposition, int yposition) // draw icons here
	{
		g.drawImage(icon.getImage(), xposition, yposition, null);  // draw an image using Graphics g...
	// System.out.println(icon.getImage().getHeight(null));  // <----DEBUGGING
	}
	public Piece(boolean isBlack)
	{
		this.isBlack = isBlack;  // 'isBlack' on the right is the one being passed;
		
	}
	
	public abstract boolean canMove(int ysource,int xsource, int xdest, int ydest);  // you only have brackets when you do something for this specifically;	
}
