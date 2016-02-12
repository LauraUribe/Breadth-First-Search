import java.awt.Color;
import java.awt.Graphics;


public class Trucks extends Vehicle
{
	// these are global variables so they can continue being used, instead of forgotten from Car to paint(Graphics g);
		/*int xposition, yposition, velocity;
		Color color;
		*/
		
		// constructor for car....these values are passed here and then they will be drawn 
		public Trucks(int xposition, int yposition, int velocity, Color color, RacecarWindow racecarwindow)  // racecarwindow must be passed
		// all of this will be called in draw() method
		{
			super(xposition, yposition, velocity, color, racecarwindow);
			/*this.xposition = xposition;
			this.yposition = yposition;
			this.velocity = velocity;
			this.color = color;
			*/
		}
		
		public void draw(Graphics g)  // because now in 'Vehicle' class
		// x, y, length, height
		{
			g.setColor(color);  // sets the color for these to be drawn on the body; passes 'color'
			g.fillRect(xposition, yposition, 50, 20);  // car body
			g.fillRect(xposition + 5, yposition - 8, 10, 20);  // roof of trucks  // (0,0) is top left corner, must subtract to
			// get the roof to be on the top part;
			g.drawOval(xposition, yposition + 15, 10, 10);  // wheel1
			g.drawOval(xposition + 40, yposition + 15, 10, 10);  // wheel2
		} 
	}

