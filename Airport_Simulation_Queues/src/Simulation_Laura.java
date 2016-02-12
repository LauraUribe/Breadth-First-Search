//PURPOSE: 
//run 15 minutes time intervals up to 120 minutes.
/* each time interval must have: number of planes arriving at take off and landing queue, and plane ID */
//generate random plane (ID (even - take off; odd - landing))
//randomly decide plane to take off/land

//will use: Executors, ScheduledExecuterService, TimeUnit;
import java.util.Random;
public class Simulation_Laura
{
	// class object and new instance;
	Random rand = new Random(); // use for how many planes come in/out
		
	int plane_ID = 1;  // set it; doesn't do anything else; set this to 1 because I set plane_ID == 0 towards the bottom;
	
	cuecue<Integer> landing = new cuecue<Integer>();  // creates queue for landing  
	cuecue<Integer> takeoff = new cuecue<Integer>(); // creates queue for take off  
	
	int time_counter = 10;  // time outside of loop;
	int total_landing = 0;
	int total_takeoff = 0;
	int average_landing = 1;
	int average_takeoff = 1;
	public void generates_randNum(int min, int max)  // 'generates_randNum' is a library already set to generate a random integer
	// between the minimum value of 0 and the maximum value of 3; 
	// only void and not int because it does not return anything in general;
	{
		// landing.enqueue(1); // this creates elements in the landing queue that will add the integer you want in here. 
		// only do one enqueue because queue's only care about the first one it can access;
	
		// takeoff.enqueue(1); // creates elements in the take off queue and adds them in there when needed;
				
		// clock that runs up to 120 minutes;
		while (time_counter <= 120)
		{	
			int random = rand.nextInt(4);  // range of planes that can take off/land; randomizes plane_ID;
			int random2 = rand.nextInt(4);
			int temp = 0;
			int temp2 = 0;
			while(temp < random)  // while random (the number of planes that can come in)
				// is greater than temp, then place the number of planes in the take off queue
			{
				takeoff.enqueue(1);
				total_takeoff++;
				temp++;
			}
			
			while(temp2 < random2)
			{
				landing.enqueue(1);
				total_landing++;
				temp2++;
			}
			
			System.out.println(time_counter + " minutes have passed.");
			//landing.enqueue(plane_ID);  // ready or preparing to land 
			//takeoff.enqueue(plane_ID); // ready or preparing to take off
			
			// REMEMBER landing and take off queue is equal to each other;
			// only assign plane_ID after enters queue.
				
			System.out.println("Landing Queue: " + landing.size());  // how many things are actually in the queue;
			System.out.println("Takeoff Queue: " + takeoff.size());
			/*if (landing.size() == takeoff.size() && landing.size() != 0 && takeoff.size() != 0)
			{	
				landing.dequeue();
				plane_ID++;
			}*/
			if (landing.size() == 0)
			{
				System.out.println("No plane needs to land.");
				plane_ID++;
			}
			
			if (takeoff.size() == 0)
			{
				System.out.println("No plane needs to takeoff.");
				plane_ID++;
			}
			
			if (landing.size() < takeoff.size())
			{
				takeoff.dequeue();  // dequeue takes off an object; enqueue takes on an integer;
				System.out.println("Plane " + plane_ID + " has taken off.");
				average_takeoff +=(takeoff.size()/average_takeoff); // average take off in queues;
				plane_ID++;
				// System.out.println("Reached the end of the while loop.");
			}
			
			if (landing.size() >= takeoff.size() && (landing.size() != 0 || takeoff.size()!= 0))  // going to land if it meets these conditions; 
			{ // this basically says that if the landing queue is more filled than the take off queue, prioritize landing
				landing.dequeue();  // plane has landed; dequeued so size of queue less than original so <= comparison must be beforehand.
				System.out.println("Plane " + plane_ID + " has landed.");
				average_landing+=(landing.size()/average_landing);
				plane_ID++;
			}
			
			
		/*
		if (plane_ID == 0) // REMEMBER that if plane ID is 0, then print out there is no plane that needs to land and do whatever else necessary.
		{
			System.out.println("No plane needs to land or take off.");
		}
		if (plane_ID % 2 == 0)  // if even, then......
		{
			int even_planeID = plane_ID;
			System.out.println("Take off plane ID is: "+ even_planeID);
			System.out.println("Landing: " + landing.size());

			plane_ID++;  // avoids duplicates; 
			// adds here --> odd statement --> comes back here;
		}	
				// return even_planeID;
				// return must always be at end. Nothing seen after a return.
		else  // if odd, then.......
		{
			int odd_planeID = plane_ID;
			System.out.println("landing plane ID is: " + odd_planeID);
			if (takeoff.size() > landing.size())
			{
				takeoff.dequeue();
				System.out.println("Plane " + odd_planeID + " has taken off.");
				plane_ID++;  // to update so no infinite loop;
			}
			else
			{
				landing.dequeue();
				System.out.println("Plane " + even_planeID + " has landed.");
				plane_ID++;
			}
		} 	*/
		time_counter+=10;  // add 10 minutes to clock once it has gone through this process;
	}
	System.out.println("Total Takeoff in Queue: " + total_takeoff);
	System.out.println("Average Takeoff in Queue: " + average_takeoff);
	System.out.println("Total Landing in Queue: " + total_landing);
	System.out.println("Average Landing in Queue: " + average_landing);
	}}
