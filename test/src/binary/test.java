package binary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		System.out.println("fjeiofawjefoawie");
		String aa = "你好吗11aa";
		System.out.println(aa.length());
		String a = null ;
		System.out.println("".equals(null));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println(simpleDateFormat.format(new Date(1468548719*1000l)));
		System.out.println(simpleDateFormat.format(new Date(1467388800000l)));
		try {
			Date date = simpleDateFormat.parse("2016年07月02日");
			System.out.println(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
