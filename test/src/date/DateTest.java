package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest {
	
	private static SimpleDateFormat mDateFmt = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
	
	public static void main(String[] args) {
		
		System.out.println(formateDate(1469524984 * 1000l, "yyyy年MM月dd日 HH:mm"));
		System.out.println(new Date().getTime());
		System.out.println(mDateFmt.format(new Date(1469524984 * 1000l)));
	}
	
	public static final String formateDate(long milliseconds, String template) {
		SimpleDateFormat sdf = new SimpleDateFormat(template);
		return sdf.format(new Date(milliseconds));
	}
}
