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
}
