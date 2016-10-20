package test1;

import java.text.DecimalFormat;

public class master1 {
	public static void main(String[] args) {
		int time = 20;
		DecimalFormat mDecimalFormat = new DecimalFormat("00");
		int second = time % 60;
		int minute = time / 60;
		StringBuilder sb = new StringBuilder();
		sb.append(mDecimalFormat.format(minute));
		sb.append(":");
		sb.append(mDecimalFormat.format(second));
		System.out.println(sb.toString());
	}
}
