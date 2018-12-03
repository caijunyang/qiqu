package com.huabang.ofo.utils;

import java.text.DecimalFormat;

import com.huabang.ofo.domain.HbShare;

public class LatAndLntUtils {

	private static double EARTH_RADIUS = 6371.393;  
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    } 
    
    public static double latAndLnt(HbShare s,String lat , String lng){
    	DecimalFormat    df   = new DecimalFormat("######0.00");
    	String[] latLng = s.getSharePot().split(",");
		Double lat2 =Double.parseDouble(latLng[0]);
		Double lng2 =Double.parseDouble(latLng[1]);
		Double lat1=Double.parseDouble(lat);
		Double lng1 = Double.parseDouble(lng);
		double radLat1 = rad(lat1);  
        double radLat2 = rad(lat2);  
        double a = radLat1 - radLat2;      
        double b = rad(lng1) - rad(lng2);  
        double km = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +   
        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
        km = km * EARTH_RADIUS;
    	String km2 = df.format(km);
    	double d = Double.parseDouble(km2);
    	return  d;
    }
    
}
