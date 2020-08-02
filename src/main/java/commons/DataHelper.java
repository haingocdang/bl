package commons;

import java.util.GregorianCalendar;
import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale locale=new Locale("en");
	private Faker faker=new Faker(locale);
	String firstName, lastName;
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	public String getFullName() {
		firstName= faker.name().firstName();
		lastName=faker.name().lastName();
		return firstName+ " " + lastName;
	}
	
	public String getAddress() {
		return faker.address().streetAddress();
	}
	
	public String getEmailAddress() {
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@yopmail.com";
	}
	
	public String getPhone() {
		return faker.phoneNumber().cellPhone().replace("-", "");
	}
	
	public String getCity() {
		return faker.address().city();
	
	}
	
	public String getCityName() {
		return faker.address().cityName();
	
	}
	
	public String getState() {
		return faker.address().state();
	
	}
	
	public String getPIN() {
		return faker.number().digits(6);
	}
	
	public String getPassword() {
		return faker.internet().password(6,20);
	}
	
	public String getCompany() {
		return faker.company().name();
	}
	
	public String getBirthDate() {
		GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        
        //System.out.println(gc.get(gc.MONTH) + "/" + (gc.get(gc.DAY_OF_MONTH) + 1) + "/" + gc.get(gc.YEAR));
        int intMonth=  gc.get(gc.MONTH)+1;
        String month = "01";
        if (intMonth>=1 && intMonth <9) {
        	month="0"+ intMonth;
        }
        
        int intDay=  gc.get(gc.DAY_OF_MONTH)+1;
        String day = "01";
        if (intDay>=1 && intDay <9) {
        	day="0"+ intDay;
        }
        
        //System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

        return month + "/" + day + "/" + gc.get(gc.YEAR);
	}
	
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

}
