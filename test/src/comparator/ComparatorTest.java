package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
	public static void main(String[] args) {
		
		List<Obj> list = new ArrayList<Obj>();
		Obj obj1 = new Obj();
		obj1.a = 2;
		obj1.b = "添加";
		list.add(obj1);
		for (int i = 0; i < 10; i++) {
			Obj obj = new Obj();
			obj.a = i;
			obj.b = "" + i;
			list.add(obj);
		}
		List<Obj> newList = new ArrayList<>();
		newList.addAll(list);
		Collections.sort(newList, new Comparator<Obj>() {

			@Override
			public int compare(Obj o1, Obj o2) {
				return o1.a - o2.a;
			}
		});
		for (int i = 0; i < 11; i++) {
			System.out.println(list.get(i).toString());
		}
		for (int i = 0; i < 11; i++) {
			System.out.println(newList.get(i).toString());
		}
	}
	
	
	static class Obj implements Comparable{
		int a;
		String b;
		@Override
		public int compareTo(Object o) {
			return 0;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "a:" + a + ",b:" +b;
		}
		
	}
}
