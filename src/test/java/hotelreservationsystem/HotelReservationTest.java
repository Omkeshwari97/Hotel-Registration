package hotelreservationsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

import org.junit.Test;

public class HotelReservationTest 
{	
	DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
	DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
	
	@Test
	public void givenDates_findCheapestBestRatedHotelforRegularCustomer_shouldReturnCheapestBestRatedHotel()
	{	
		String customerType = HotelReservation.getCustomerType();
		
		assertEquals("regular", customerType);
		
		HotelReservation regularCustomer = new HotelReservation();
		
		regularCustomer.addHotel("Lakewood", "weekday", 110, 3);
		regularCustomer.addHotel("Lakewood", "weekend", 90, 3);
		
		regularCustomer.addHotel("Bridgewood", "weekday", 150, 4);
		regularCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		regularCustomer.addHotel("Ridgewood", "weekday", 220, 5);
		regularCustomer.addHotel("Ridgewood", "weekend", 150, 5);
		
		regularCustomer.displayHotel();
		
		String d1 = HotelReservation.getDate();
		String d2 = HotelReservation.getDate();
		
		assertEquals(true, validator.isValid(d1));
		assertEquals(true, validator.isValid(d2));
		
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		  
		Entry<String, Integer> obj = regularCustomer.cheapestBestRatedHotel(date1, date2); 
		assertEquals("Bridgewood", obj.getKey());
		assertEquals(4, (int)obj.getValue());
	}

	@Test
	public void givenDates_findBestRatedHotelforRegularCustomer_shouldReturnBestRatedHotel()
	{
		String customerType = HotelReservation.getCustomerType();

		assertEquals("regular", customerType);

		HotelReservation regularCustomer = new HotelReservation();
		
		regularCustomer.addHotel("Lakewood", "weekday", 110, 3);
		regularCustomer.addHotel("Lakewood", "weekend", 90, 3);
		
		regularCustomer.addHotel("Bridgewood", "weekday", 150, 4);
		regularCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		regularCustomer.addHotel("Ridgewood", "weekday", 220, 5);
		regularCustomer.addHotel("Ridgewood", "weekend", 150, 5);
		
		regularCustomer.displayHotel();

		String d1 = HotelReservation.getDate();
		String d2 = HotelReservation.getDate();
		
		assertEquals(true, validator.isValid(d1));
		assertEquals(true, validator.isValid(d2));
		
		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		
		String bestRatedHotelname = regularCustomer.bestratedHotel(date1, date2);
		
		assertEquals("Ridgewood", bestRatedHotelname);
	}
	
	@Test
	public void givenDates_findCheapestBestRatedHotelforRewardCustomer_shouldReturnCheapestBestRatedHotel()
	{	
		String customerType = HotelReservation.getCustomerType();

		assertEquals("reward", customerType);

		HotelReservation rewardCustomer = new HotelReservation();
		
		rewardCustomer.addHotel("Lakewood", "weekday", 80, 3);
		rewardCustomer.addHotel("Lakewood", "weekend", 80, 3);
		
		rewardCustomer.addHotel("Bridgewood", "weekday", 110, 4);
		rewardCustomer.addHotel("Bridgewood", "weekend", 50, 4);
		
		rewardCustomer.addHotel("Ridgewood", "weekday", 100, 5);
		rewardCustomer.addHotel("Ridgewood", "weekend", 40, 5);
		
		rewardCustomer.displayHotel();

		String d1 = HotelReservation.getDate();
		String d2 = HotelReservation.getDate();
		
		assertEquals(true, validator.isValid(d1));
		assertEquals(true, validator.isValid(d2));

		LocalDate date1 = LocalDate.of(2020, 9, 11); 
		LocalDate date2 = LocalDate.of(2020, 9, 12);
		  
		Entry<String, Integer> obj = rewardCustomer.cheapestBestRatedHotel(date1, date2); 
		assertEquals("Ridgewood", obj.getKey());
		assertEquals(5, (int)obj.getValue());
	}
	
	@Test
	public void givenCustomerType_whenRegularType_shouldReturnEqual()
	{
		String customerType = HotelReservation.getCustomerType();
		assertEquals("regular", customerType);
	}
	
	@Test
	public void givenCustomerType_whenRewardType_shouldReturnEqual()
	{
		String customerType = HotelReservation.getCustomerType();
		assertEquals("reward", customerType);
	}
	
	@Test
	public void givenDates_whenValidatedIfCorrect_shouldReturnTrue()
	{
		DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
		DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

		assertEquals(true, validator.isValid("20190228"));
	}
	
	public void givenDates_whenValidatedIfIncorrect_shouldReturnFalse()
	{
		DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
		DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

		assertEquals(false, validator.isValid("20190230"));
	}
}
