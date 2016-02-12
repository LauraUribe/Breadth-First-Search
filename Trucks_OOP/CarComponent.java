import java.awt.Graphics;
import javax.swing.JComponent;

// this is painting
public class CarComponent extends JComponent
{

RacecarWindow window;
public CarComponent(RacecarWindow window)  // RacecarWindow is the class, 
// window is object...passing it so window can get drawn things
{
	super();
	this.window = window;
}

public void paintComponent(Graphics g)  // 'Graphics' is always for anything creative-drawing

{
	// do for loop for i
	for (int i = 0; i < window.cars.length; i++)  // 'window' so can get what is happening in 'RacecarWindow', which is where 'cars.length' is
	{
		window.cars[i].draw(g);
	
	}
	
	// do for loop for i
	for (int i = 0; i < window.trucks.length; i++)  // 'window' so can get what is happening in 'RacecarWindow', which is where 'cars.length' is
	{
		window.trucks[i].draw(g);
	
	}
}

}
