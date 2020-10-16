package hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Map.Entry;

import org.junit.Test;

public class HotelReservationTest 
{	
	@Test
	public void givenDates_findCheapestBestRatedHotelforRegularCustomer_shouldReturnCheapestBestRatedHotel()
	{	
		HotelReservation regularCustomer = new HotelReservation();
		
		regularCustomer.addHotel("Lakewood", "weekday", 110, 3);
		regularCustomer.addHotel("Lakewood", "weekend", 90, 3);
		
		regularCustomer.addHotel("Bridgewood", "weekday", 150, 4);
		regularCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		regularCustomer.addHotel("Ridgewood", "weekday", 220, 5);
		regularCustomer.addHotel("Ridgewood", "weekend", 150, 5);
		
		regularCustomer.displayHotel();
		  
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		  
		Entry<String, Integer> obj = regularCustomer.cheapestBestRatedHotel(date1, date2); 
		assertEquals("Bridgewood", obj.getKey());
		assertEquals(4, (int)obj.getValue());
	}

	@Test
	public void givenDates_findBestRatedHotelforRegularCustomer_shouldReturnBestRatedHotel()
	{
		HotelReservation regularCustomer = new HotelReservation();
		
		regularCustomer.addHotel("Lakewood", "weekday", 110, 3);
		regularCustomer.addHotel("Lakewood", "weekend", 90, 3);
		
		regularCustomer.addHotel("Bridgewood", "weekday", 150, 4);
		regularCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		regularCustomer.addHotel("Ridgewood", "weekday", 220, 5);
		regularCustomer.addHotel("Ridgewood", "weekend", 150, 5);
		
		regularCustomer.displayHotel();
		
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		
		String bestRatedHotelname = regularCustomer.bestratedHotel(date1, date2);
		
		assertEquals("Ridgewood", bestRatedHotelname);
	}
	
	@Test
	public void givenDetails_addDetailsforRewardCustomer_shouldAddDetails()
	{	
		HotelReservation rewardCustomer = new HotelReservation();
		
		rewardCustomer.addHotel("Lakewood", "weekday", 80, 3);
		rewardCustomer.addHotel("Lakewood", "weekend", 80, 3);
		
		rewardCustomer.addHotel("Bridgewood", "weekday", 110, 4);
		rewardCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		rewardCustomer.addHotel("Ridgewood", "weekday", 100, 5);
		rewardCustomer.addHotel("Ridgewood", "weekend", 40, 5);
		
		rewardCustomer.displayHotel();
	}
}
