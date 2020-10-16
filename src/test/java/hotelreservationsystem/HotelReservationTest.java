package hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Map.Entry;

import org.junit.Test;

public class HotelReservationTest 
{	
	@Test
	public void givenDates_findCheapestBestRatedHotel_shouldReturnCheapestBestRatedHotel()
	{	
		HotelReservation hotelReservationobj = new HotelReservation();
		
		hotelReservationobj.addHotel("Lakewood", "weekday", 110, 3);
		hotelReservationobj.addHotel("Lakewood", "weekend", 90, 3);
		
		hotelReservationobj.addHotel("Bridgewood", "weekday", 150, 4);
		hotelReservationobj.addHotel("Bridgewood", "weekend", 50, 4);
		
		hotelReservationobj.addHotel("Ridgewood", "weekday", 220, 5);
		hotelReservationobj.addHotel("Ridgewood", "weekend", 150, 5);
		
		hotelReservationobj.displayHotel();
		  
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		  
		Entry<String, Integer> obj = hotelReservationobj.cheapestBestRatedHotel(date1, date2); 
		assertEquals("Bridgewood", obj.getKey());
		assertEquals(4, (int)obj.getValue());
	}

	@Test
	public void givenDates_findBestRatedHotel_shouldReturnBestRatedHotel()
	{
		HotelReservation hotelReservationobj = new HotelReservation();
		
		hotelReservationobj.addHotel("Lakewood", "weekday", 110, 3);
		hotelReservationobj.addHotel("Lakewood", "weekend", 90, 3);
		
		hotelReservationobj.addHotel("Bridgewood", "weekday", 150, 4);
		hotelReservationobj.addHotel("Bridgewood", "weekend", 50, 4);
		
		hotelReservationobj.addHotel("Ridgewood", "weekday", 220, 5);
		hotelReservationobj.addHotel("Ridgewood", "weekend", 150, 5);
		
		hotelReservationobj.displayHotel();
		
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		
		String bestRatedHotelname = hotelReservationobj.bestratedHotel(date1, date2);
		
		assertEquals("Ridgewood", bestRatedHotelname);
	}
}
