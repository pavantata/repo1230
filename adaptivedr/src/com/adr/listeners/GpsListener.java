package com.adr.listeners;
 
 import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
 
 import com.adr.listeners.Listener;
import com.adr.Adr;

import java.io.File;
import java.io.FileWriter;

public class GpsListener extends Listener implements LocationListener
{
    public GpsListener()
    {
    }

    public boolean register(LocationManager locationManager)
    {
	try
	    {
		Log.e("adaptivedr", "register GpsListener");
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
		return true;
	    }
	catch(Exception e)
	    {
		return false;
	    }
    }

    public void onLocationChanged(Location location)
    {
    	 if(location == null)
				Log.e("apativedr", "location is null inside GpsListener.onLocationChanged");
			else
				Log.e("apativedr", "location has value inside GpsListener.onLocationChanged" + location.toString());

	this.data.addLocation(location);
    }

    public void onProviderDisabled(String provider)
    {
    	Log.e("adaptivedr", "onProviderDisEnabled Gps");
	this.data.gpsDisabled();
    }

    public void onProviderEnabled(String provider)
    {
    	Log.e("adaptivedr", "onProviderEnabled Gps");
	this.data.gpsEnabled();
    }

    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    	Log.e("adaptivedr", "onStatusChanged Gps");
	this.data.gpsStatusChanged(status);
    }

    public void onStop()
    {
    }
 }