package hotelreservationsystem;

public class Hotel 
{
	private String hotelName;
	private int hotelRate;
	private int rating;
	
	public Hotel(String hotelName, int hotelRate, int rating)
	{
		this.hotelName = hotelName;
		this.hotelRate = hotelRate;
		this.rating = rating;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public int getHotelRate() {
		return hotelRate;
	}
	
	public void setHotelRate(int hotelRate) {
		this.hotelRate = hotelRate;
	}

	public int getRating() 
	{
		return rating;
	}
	
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
}
