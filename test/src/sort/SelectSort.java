package sort;

/**
 * 选择排序
 * 
 * @author weilongzhang
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] a = Utils.createArray(10);
		selectSort(a);
		Utils.printArray(a);
	}

	public static void selectSort(int[] a) {
		System.out.println("选择排序");
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int index = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					a[i] = a[j];
					index = j;
				}
			}
			a[index] = temp;
		}
		Utils.printArray(a);
	}
}
