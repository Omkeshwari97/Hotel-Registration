package hotelreservationsystem;

import java.time.LocalDate;
import java.util.*;

public class HotelReservation 
{	
	List<Hotel> hotelList =new ArrayList<Hotel>();
	
	public void addHotel(String hotelName, int hotelRate)
	{
		Hotel hotelObj = new Hotel(hotelName, hotelRate);
		hotelList.add(hotelObj);
	}
	
	public void displayHotel()
	{
		for(Hotel hotelListobj : hotelList)
		{
			System.out.println("Hotel Name : " + hotelListobj.getHotelName() + " Rates : " + hotelListobj.getHotelRate());
		}
	}
	
	public Hotel findCheapestHotel(LocalDate ...dates)
	{
		Hotel obj = null;
		int rate = 0;
		int min = 99999;
		
		for(Hotel hotelListobj : hotelList)
		{
			rate = 0;
			for(LocalDate date : dates)
			{
				rate = rate + hotelListobj.getHotelRate();
			}
			
			if(rate < min)
			{
				min = rate;				
				obj = hotelListobj;
			}
		}
		
		System.out.println("Cheapest Hotel Name : " + obj.getHotelName() + " Total Rates : " + min);
		return obj;
	}
}
