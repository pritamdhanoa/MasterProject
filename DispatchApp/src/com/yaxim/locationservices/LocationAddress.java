package com.yaxim.locationservices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class LocationAddress implements LocationListener {

	protected LocationManager locationManager;
	Location location;
	public static String GMAPPATH = "https://www.google.com/maps/@%s,%s,10z";

	private final long MIN_DISTANCE_FOR_UPDATE = 10;
	private final long MIN_TIME_FOR_UPDATE = 1000 * 60 * 2;

	private final String TAG = "LocationAddress";

	private static LocationAddress locationAddress;

	public static LocationAddress getInstance(Context context) {
		if (locationAddress == null) {
			locationAddress = new LocationAddress(context);
		}
		return locationAddress;
	}

	private LocationAddress(Context context) {
		locationManager = (LocationManager) context
				.getSystemService(context.LOCATION_SERVICE);
	}

	public Location getLocation(String provider) {
		if (locationManager.isProviderEnabled(provider)) {
			locationManager.requestLocationUpdates(provider,
					MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
			if (locationManager != null) {
				location = locationManager.getLastKnownLocation(provider);
				return location;
			}
		}
		return null;
	}

	public void getAddressFromLocation(final double latitude,
			final double longitude, final Context context, final Handler handler) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				Geocoder geocoder = new Geocoder(context, Locale.getDefault());
				String result = null;
				try {
					List<Address> addressList = geocoder.getFromLocation(
							latitude, longitude, 1);
					if (addressList != null && addressList.size() > 0) {
						Address address = addressList.get(0);
						StringBuilder sb = new StringBuilder();
						sb.append(address.getLocality()).append("\n");
						result = sb.toString();
					}
				} catch (IOException e) {
					Log.e(TAG, "Unable connect to Geocoder", e);
				} finally {
					Message message = Message.obtain();
					message.setTarget(handler);
					if (result != null) {
						message.what = 1;
						Bundle bundle = new Bundle();
						// result = result;
						// result = "Latitude: " + latitude + " Longitude: "
						// + longitude + "\n\nAddress:\n" + result;

						result = String.format(GMAPPATH, latitude, longitude)
								+ "\n\nAddress:\n" + result;
						bundle.putString("address", result);
						message.setData(bundle);
					} else {
						message.what = 2;
						Bundle bundle = new Bundle();
						result = "Latitude: " + latitude + " Longitude: "
								+ longitude
								+ "\n Unable to get address for this lat-long.";
						bundle.putString("address", result);
						message.setData(bundle);
					}
					message.sendToTarget();
				}
			}
		};
		thread.start();
	}

	public String getAddressFromLocation(final double latitude,
			final double longitude, final Context context) {
		Geocoder geocoder = new Geocoder(context, Locale.getDefault());
		String result = null;
		try {
			List<Address> addressList = geocoder.getFromLocation(latitude,
					longitude, 1);
			if (addressList != null && addressList.size() > 0) {
				Address address = addressList.get(0);
				StringBuilder sb = new StringBuilder();
				sb.append(address.getLocality()).append("\n");
				result = sb.toString();

			}
			if (result != null) {
				// result = result;
				result = "Latitude: " + latitude + " Longitude: " + longitude
						+ "\n\nAddress:\n" + result;
			} else {
				result = "Latitude: " + latitude + " Longitude: " + longitude
						+ "\n Unable to get address for this lat-long.";
			}
		} catch (IOException e) {
			Log.e(TAG, "Unable connect to Geocoder", e);
		}
		return result;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public static String getMapsLink(String lat,String lon){
		return String.format(LocationAddress.GMAPPATH, lat, lon);
	}

}
