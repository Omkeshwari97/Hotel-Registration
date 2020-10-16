package hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorUsingLocalDate implements DateValidator
{

	private DateTimeFormatter dateFormatter;
    
    public DateValidatorUsingLocalDate(DateTimeFormatter dateFormatter) 
    {
        this.dateFormatter = dateFormatter;
    }
 
    @Override
    public boolean isValid(String dateString) 
    {
        try 
        {
            LocalDate.parse(dateString, this.dateFormatter);
        } 
        catch (DateTimeParseException e) 
        {
            return false;
        }
        return true;
    }
}
