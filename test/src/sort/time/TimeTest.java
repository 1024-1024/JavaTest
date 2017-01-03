package sort.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
	static int minute = 11;
	static int hour = 0;
	static int day = 1;
	public static void main(String[] args) {
//		System.out.println(formateDate(87161l, "yyyy-MM-dd HH:mm:ss"));
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				time();
//			}
//		}, 1000, 1000);
//		System.out.println(87161/60);
//		System.out.println(getCostTime(87161));
		
//		int a = (int) 1.63;
//		System.out.println(a);
//		double bb = Double.valueOf("1");
//		System.out.println(bb);
		
		//-2147483648
		//-2147483549
		//2147483647
		int a = Integer.MAX_VALUE + Integer.MAX_VALUE;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(a);
	}
		
	
	
	public static String getCostTime(long time) {
		if (time <= 0)
			return "00'00\"00";
		else {
			int nonosecond = (int) (time % 1000);
			int minute = (int) (time / 1000 / 60);
			int second = (int) (time / 1000 - minute * 60);
			return unitFormat(minute) + "'" + unitFormat(second) + "\""
					+ unitFormat(nonosecond / 10);
		}
	}

	public static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}
	
	public static void time() {
		if (minute > 0) {
            minute -- ;
        } else {
            if (hour > 0) {
                hour --;
                minute = 59;
            } else {
                if (day > 0) {
                    day --;
                    hour = 23;
                    minute = 59;
                } else {
                    day = 0;
                    hour = 0;
                    minute = 0;
                }
            }
        }
        System.out.print(((day>=0 && day < 10) ? "0" + day + ":" : (day+":")));
        System.out.print(((hour>=0 && hour < 10) ? "0" + hour + ":" : (hour+":")));
        System.out.print(((minute>=0 && minute < 10) ? "0" + minute + ":" : (minute+"")));
        System.out.println();
	}
	
	public static final String formateDate(long milliseconds, String template) {
		SimpleDateFormat sdf = new SimpleDateFormat(template, Locale.getDefault());
		return sdf.format(new Date(milliseconds));
	}
}
