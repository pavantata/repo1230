package com.adr.resources;
  
  import android.location.Location;
import android.util.Log;
  
  public class Position extends DataHandler
  {
      public Position()
      {
      }
 
     public void handleLocation(long time, Location location)
     {
    	 if(location == null)
				Log.e("apativedr", "location is null inside Position.handleLocation");
			else
				Log.e("apativedr", "location has value inside Position.handleLocation" + location.toString());
 	this.location = location;
 	this.updated = true;
     }
 
     public void handleGpsEnabled(long time)
     {
 	this.enabled = true;
     }
 
     public void handleGpsDisabled(long time)
     {
 	this.enabled = false;
     }
 
     public void handleGpsStatusChanged(long time, int status)
     {
 	this.status = status;
     }
 
     public void restart()
     {
 	this.updated = false;
     }
 
     public Location getLocation()
     {
 	return this.location;
     }
 
     public int getStatus()
     {
 	return this.status;
     }
 
     public boolean getUpdated()
     {
 	return this.updated;
     }
 
     public void start()
     {
 	
     }
 
     public void stop()
     {
 	
     }
 
     public void update()
     {
 	
     }
 
     private Location location = null;
     private boolean enabled = false;
     private int status = 0;
     private boolean updated = false;
 }