package array;

import java.util.ArrayList;

public class ArrayTest {
	public static void main(String[] args) {
		ArrayList<String> where = new ArrayList<>();
		where.add("1");
		where.add("2");
		where.add("3");
		int len = where.size();
        for (int i = 0; i < len; ++i) {
            String info = where.get(i);
            if (info.equals("2")) {
                where.remove(i);
                break;
            }
        }
	}
}
