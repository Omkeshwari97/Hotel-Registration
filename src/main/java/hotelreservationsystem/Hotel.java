package hotelreservationsystem;

public class Hotel 
{
	private String hotelName;
	private int hotelRate;
	private String weekType;
	
	public Hotel(String hotelName, String weekType, int hotelRate)
	{
		this.hotelName = hotelName;
		this.hotelRate = hotelRate;
		this.setWeekType(weekType);
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

	public String getWeekType() {
		return weekType;
	}

	public void setWeekType(String weekType) {
		this.weekType = weekType;
	}
}
