package hotelreservationsystem;

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
	}
}
