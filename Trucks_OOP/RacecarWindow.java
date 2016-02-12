// this program creates the window
// must create window
// must create graphics of cars

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

//rc.cars[i].draw(g)  <--- not necessarily part of this tab
public class RacecarWindow implements MouseListener // contains all the methods related to this class
{
	static final int WINDOWWIDTH = 500, WINDOWHEIGHT = 500;
	// global variable
	Car cars[];  // creating array for cars
	Trucks trucks[];  // creating array for trucks
	CarComponent carcomponent;
	// TruckComponent truckcomponent;
	
	// construct method for RacecarWindow
	public RacecarWindow()
	{
		// class object
		JFrame myFrame = new JFrame("Window");  // create object myFrame in class JFrame;
		myFrame.setSize(WINDOWWIDTH, WINDOWHEIGHT);  // size of window
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // this allows user to press 'x' to close
		
		cars = new Car[3];  // creating 3 cars based on 'Car'
		trucks = new Trucks[2];  // creating 2 trucks based on class 'Trucks';
		
		for (int i = 0; i < cars.length; i++)
		{
			// third value is velocity
			cars[0] = new Car(100, 100, 10, new Color(50, 135, 144), this);  // 'this' passes all of 'RacecarWindow' to 'Vehicle'
			cars[1] = new Car(100, 150, 20, new Color(40, 150, 110), this);
			cars[2] = new Car(100, 200, 30, new Color(190, 135, 123), this);
			// cars[3] = new Car(100, 250, 40, new Color(100, 200, 113));
			// cars[4] = new Car(100, 300, 50, new Color(140, 185, 170));
		}
		
		for (int i = 0; i < trucks.length; i++)
		{
			trucks[0] = new Trucks(100, 250, 40, new Color(150, 105, 144), this);  
			trucks[1] = new Trucks(100, 300, 50, new Color(179, 120, 110), this);
		}
		
		carcomponent = new CarComponent(this);  // this passes everything from 'RacecarWindow' to 'CarComponent'
		// truckcomponent = new TruckComponent(this);
		myFrame.add(carcomponent);  // adding class CarComponent (in variable 'carcomponent' into 'RacecarWindow's myFrame
		// myFrame.add(truckcomponent);
		myFrame.addMouseListener(this);  // adding all methods of 'MouseListener' to this window ('RacecarWindow')
		// ADD mouselistener here;
		myFrame.setVisible(true);  //JFrame automatically sets it to 'false', so must set it to 'true' to make it
		// visible....this line must be at the end so everything can be visible in the window
		
		// movement occurs after 'setVisible'

		for (int i = 0; i < cars.length; i++)  // format of a thread
		{
			new Thread(cars[i]).start();  // lets computer know there is a thread
		}

		for (int i = 0; i < trucks.length; i++)
		{
			new Thread(trucks[i]).start();
		}
		// !!! make cars and trucks move in this section .... make a thread
			// how to make a thread?
	}


	public static void main(String[] args) 
	{
		// todo
		new RacecarWindow();  // to call a method, you must have 'new' beforehand....
		// it's creating a new instance of the object.
		// 'RacecarWindow()' takes care of connecting 'Car' and 'CarComponent' so no worries about
		// putting these other methods in main.
	}


	@Override
	public void mouseClicked(MouseEvent e) 
	{
	//System.out.println(e.getX());  // <--- debugging
		for (int i = 0; i < cars.length; i++)
		{
			// System.out.println(e.getX());
			// check if it's clicked, if so, then print out velocity
			if (cars[i].clicked(e.getX(), e.getY()))
			{
				// System.out.println(e.getX());
				cars[i].velocity();
			}
		}
		for (int i = 0; i < trucks.length; i++)
		{
			if (trucks[i].clicked(e.getX(), e.getY()))
			{
				trucks[i].velocity();  // tells the velocity of truck x
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

	

