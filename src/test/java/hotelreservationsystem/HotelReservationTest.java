package hotelreservationsystem;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class HotelReservationTest 
{	
	@Test
	public void givenRates_addHotelRates_WhenWeekndWeekday()
	{	
		HotelReservation hotelReservationobj = new HotelReservation();
		
		hotelReservationobj.addHotel("Lakewood", "weekday", 110);
		hotelReservationobj.addHotel("Bridgewood", "weekday", 160);
		hotelReservationobj.addHotel("Ridgewood", "weekday", 220);
		hotelReservationobj.addHotel("Lakewood", "weekend", 90);
		hotelReservationobj.addHotel("Bridgewood", "weekend", 60);
		hotelReservationobj.addHotel("Ridgewood", "weekend", 150);
		
		hotelReservationobj.displayHotel();
	}
	
}
