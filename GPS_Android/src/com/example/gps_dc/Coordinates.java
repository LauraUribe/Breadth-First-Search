package com.example.gps_dc;

public class Coordinates 
{
	float latitude;
	float longitude;
	
	// storing coordinates
	public Coordinates(float latitude, float longitude)  // float mentioned here because it is first passed through here and they are stored in their initialized portion up top.
	{
		this.latitude = latitude;  // this makes it accessible to other classes;
		this.longitude = longitude;
	}
}
