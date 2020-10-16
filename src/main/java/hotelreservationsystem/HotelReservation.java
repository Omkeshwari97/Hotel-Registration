package hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class HotelReservation 
{	
	public int min = 999999;
	List<Hotel> weekendHotelList = new ArrayList<Hotel>();
	List<Hotel> weekdayHotelList = new ArrayList<Hotel>();
	Map<Integer, List<Hotel>> dayHotelMap = new HashMap<Integer, List<Hotel>>();
	Map<String, Integer> hotelRatingMap = new HashMap<String, Integer>();
	Map<String, Integer> totalRateMap = new HashMap<String, Integer>();
	
	public void addHotel(String hotelName, String weekType, int hotelRate, int rating)
	{
		Hotel hotelObj = new Hotel(hotelName, hotelRate, rating);
		
		if(weekType.equals("weekend"))
			weekendHotelList.add(hotelObj);
		
		if(weekType.equals("weekday"))
			weekdayHotelList.add(hotelObj);
		
		dayHotelMap.put(1, weekdayHotelList);
		dayHotelMap.put(2, weekendHotelList);
		hotelRatingMap.put(hotelName, rating);
	}
	
	public void displayHotel()
	{
		for(Entry<Integer, List<Hotel>> e : dayHotelMap.entrySet())
		{
			for(Hotel hobj : e.getValue())
			{
				if(e.getKey() == 1)
					System.out.println("Hotel Name : " + hobj.getHotelName() + " WeekDay " + " Rates : " + hobj.getHotelRate() + " Rating : " + hobj.getRating());
				
				if(e.getKey() == 2)
					System.out.println("Hotel Name : " + hobj.getHotelName() + " WeekEnd " + " Rates : " + hobj.getHotelRate() + " Rating : " + hobj.getRating());
			}
		}
	}
	
	public int findCheapestHotel(LocalDate ...dates)
	{
		int countWeekend = 0, countWeekday = 0;
		int rateWeekend = 0, rateWeekday = 0;
		int totalRate = 0;
		String hName = null;
		
		for(LocalDate date : dates)
		{
			if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
			{
				countWeekend ++;
			}
			else
			{
				countWeekday ++;
			}
		}
		
		for(Entry<String, Integer> obj : hotelRatingMap.entrySet())
		{
			rateWeekday = getWeekendRate(obj.getKey());
			rateWeekend = getWeekdayRate(obj.getKey());
			
			totalRate = countWeekday * rateWeekday + countWeekend * rateWeekend;

			if(totalRate <= min)
			{
				min = totalRate;
				hName = obj.getKey();
				totalRateMap.put(hName, min);
			}
		}
		
		for(Entry<String, Integer> obj : totalRateMap.entrySet())
		{
			if(obj.getValue() == min)
			{
				System.out.println("Cheapest Hotel Name : " + obj.getKey() + " Total Rates : " + obj.getValue());
			}
		}
		
		return min;
	}
	
	public int getWeekdayRate(String hotelName) 
	{
		for(Entry<Integer, List<Hotel>> e : dayHotelMap.entrySet())
		{
			for(Hotel hobj : e.getValue())
			{
				if(hotelName.equals(hobj.getHotelName()) && e.getKey().equals(1))
				{
					return hobj.getHotelRate();
				}		
			}
		}
		
		return 0;
	}
	
	public int getWeekendRate(String hotelName) 
	{
		for(Entry<Integer, List<Hotel>> e : dayHotelMap.entrySet())
		{
			for(Hotel hobj : e.getValue())
			{				
				if(hotelName.equals(hobj.getHotelName()) && e.getKey().equals(2))
				{
					return hobj.getHotelRate();
				}
			}
		}
		
		return 0;
	}
	
	public Entry<String, Integer> cheapestBestRatedHotel(LocalDate ...dates)
	{
		findCheapestHotel(dates);
		
		int maxrating = 0;
		Entry<String, Integer> obj = null;
		
		for(Entry<String, Integer> objrate : totalRateMap.entrySet())
		{
			for(Entry<String, Integer> objrating : hotelRatingMap.entrySet())
			{
				if(objrate.getValue() == min && objrating.getValue() > maxrating && objrate.getKey() == objrating.getKey())
				{
					obj = objrating;
					maxrating = objrating.getValue();
				}
			}
		}
		
		System.out.println("Cheapest Best Rated Hotel Name : " + obj.getKey() + "Rating : " + obj.getValue() + " Total Rates : " + min);
		return obj;
	}
	
	public String bestratedHotel(LocalDate ...dates) 
	{
		int countWeekend = 0, countWeekday = 0;
		int rateWeekend = 0, rateWeekday = 0;
		int totalRate, maxRating = 0;
		Entry<String, Integer> rateObj = null;
		
		for(LocalDate date : dates)
		{
			if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
			{
				countWeekend ++;
			}
			else
			{
				countWeekday ++;
			}
		}
		
		for(Entry<String, Integer> obj : hotelRatingMap.entrySet())
		{
			if(obj.getValue() > maxRating)
			{
				maxRating = obj.getValue();
				rateObj = obj;
			}
		}
		
		rateWeekday = getWeekdayRate(rateObj.getKey());
		rateWeekend = getWeekendRate(rateObj.getKey());
		
		totalRate = countWeekday * rateWeekday + countWeekend * rateWeekend; 
		
		System.out.println("Best Rated Hotel : " + rateObj.getKey() + " Total Rates : " + totalRate);
		
		return rateObj.getKey();
	}
}
