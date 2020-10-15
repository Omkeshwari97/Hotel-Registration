package hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class HotelReservationTest 
{	
	@Test
	public void givenRates_addHotelRates()
	{	
		HotelReservation hotelReservationobj = new HotelReservation();
		
		hotelReservationobj.addHotel("Lakewood", 110);
		hotelReservationobj.addHotel("Bridgewood", 160);
		hotelReservationobj.addHotel("Ridgewood", 220);
		hotelReservationobj.displayHotel();
		
		int numOfDates = 2;
		LocalDate date1 = LocalDate.of(2020, 9, 10);  
		LocalDate date2 = LocalDate.of(2020, 9, 11);  
		
		Hotel hotelobj = hotelReservationobj.findCheapestHotel(date1, date2); 
		
		assertEquals("Lakewood", hotelobj.getHotelName());
		assertEquals(220, 2*hotelobj.getHotelRate());
	}
	
}
