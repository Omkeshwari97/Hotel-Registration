package hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class HotelReservationTest 
{	
	@Test
	public void givenDates_findCheapestHotel_WhenWeekndWeekday()
	{	
		HotelReservation hotelReservationobj = new HotelReservation();
		
		hotelReservationobj.addHotel("Lakewood", "weekday", 110);
		hotelReservationobj.addHotel("Bridgewood", "weekday", 160);
		hotelReservationobj.addHotel("Ridgewood", "weekday", 220);
		hotelReservationobj.addHotel("Lakewood", "weekend", 90);
		hotelReservationobj.addHotel("Bridgewood", "weekend", 60);
		hotelReservationobj.addHotel("Ridgewood", "weekend", 150);
		
		hotelReservationobj.displayHotel();
		
		int numOfDates = 2;
		LocalDate date1 = LocalDate.of(2020, 9, 11);  
		LocalDate date2 = LocalDate.of(2020, 9, 12);  

		int totalRate = hotelReservationobj.findCheapestHotel(date1, date2); 

		assertEquals(200, totalRate);
	}
	
}
