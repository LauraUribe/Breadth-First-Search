package com.example.gps_dc;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;  // to get TextView

public class GPS extends Activity implements Runnable
{
	static PlotView plotview;
	ArrayList <Coordinates> coordArray = new ArrayList <Coordinates>();  // inside <> is the type of the ArrayList (always name it this way)
	// coordArray is the name of this array;
	// ArrayList better than array for infinite amount of items without crashing;
	
	public class PlotView extends View
	{
		Bitmap dcmap; // global variable

		public PlotView(Context context) // constructor
		{
			super(context);
			dcmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dcmap),1000,1000,false);
			// Bitmap is a type
			// creates the map on the canvas;
		}
		
		protected void onDraw(Canvas c)  // onDraw method equivalent to paintComponent from JComponent
		{
			// int min; // "mini" global/local variable
			/* if (c.getWidth() < c.getHeight())  // find if the height or the width of the canvas is smaller, = min;
			{
				min = c.getWidth();
			}
			else
			{
				min = c.getHeight();
			} */
			
		
			
			c.scale(c.getWidth()/(float)1000, c.getHeight()/(float)1000);  // scaling map to window
			// c.scale((min/1000), (min/1000));  // scaling map to window
			Paint paint = new Paint();  //type variable = value;
			
			c.drawBitmap(dcmap, 0, 0, paint);  // draws image on window
			// dcmap.createScaledBitmap(dcmap, c.getWidth()/(float)1000, c.getHeight()/(float)1000, true); 
			
			// for loop that says if have x, then I will get y;
			for (int i = 0; i < coordArray.size(); i++) 
			// ^ for each i in the coordArray, up to it's size, it will continue increasing;
			// (i += 2) is for x since x is even;
			{
				c.drawCircle(coordArray.get(i).longitude, coordArray.get(i).latitude, 10, paint);  // "where I am" dot
				// i is even; i + 1 is odd
				// drawCircle only accepts floats
			}
			
			for (int i = 0; i < coordArray.size() - 1; i++)  // draws lines
			{
				c.drawLine(coordArray.get(i).longitude, coordArray.get(i).latitude, coordArray.get(i+1).longitude, coordArray.get(i+1).longitude, paint);
			}
				
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		/* // class object = new class();
		TextView text = new TextView(this);
		text.setText("Hellow Android World!");
		setContentView(text); */ 
		
		//coordArray.add((float) -77);  // x is even (first # inputted / east-west coords);
		// y is odd numbers (for this project)  
		// can only pass one number in;
		//coordArray.add((float) 38.80);  // north-south coords;
		plotview = new PlotView(this);  // this = class I'm in (main_activity which is the window equivalent).
		setContentView(plotview);  // enables viewership
		new Thread(this).start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.g, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		return super.onOptionsItemSelected(item);
	}
	static final double DC_WEST=-77.119789, DC_EAST=-76.909399, DC_NORTH=38.99554, DC_SOUTH=38.79163;
	   //AU is 38.936989,-77.090637 	   
private LocationManager lm;
private void initializeGPS()
{
	   lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
	   lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, new LocationListener(){
		public void onLocationChanged(Location location) {}
		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}});		   
}

private double getLatitude()
{
	   if (lm==null || lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)==null)
		   return 0;
	   return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();
}
private double getLongitude()
{
	   if (lm==null || lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)==null)
		   return 0;
	   return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();
}

@Override
public void run() 
{
	Looper.prepare();
	while (true)
	{
		// scale the coordinates -- formula
		// adding these coordinates to the array
		coordArray.add(new Coordinates((float) (((getLongitude()-DC_WEST)/(DC_EAST-DC_WEST))*1000), 
				(float) (((getLatitude()-DC_NORTH)/(DC_SOUTH-DC_NORTH))*1000)));
		//coordArray.add(new Coordinates(50,50));

		plotview.postInvalidate();
	try
	{
		Thread.sleep(10000);
	}
	
	catch(InterruptedException e)
	{
		e.printStackTrace();
	
	}
	}
}
}
