package sort;

public class Utils {

	public static void printArray(int[] a ) {
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "、");
		}
	}
	
	public static int[] createArray(int length) {
		System.out.println("排序之前：");
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * 100);
			System.out.print(array[i] + "、");
		}
		return array;
	}
	
}
