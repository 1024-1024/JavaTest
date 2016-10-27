package sort;

/**
 * 冒泡排序
 * @author weilongzhang
 *
 */
public class BubblingSort {
	public static void main(String[] args) {
		int[] array = Utils.createArray(10);
		bubbleSort(array);
		Utils.printArray(array);
	}

	public static void bubbleSort(int[] array) {
		System.out.println("冒泡排序");
		int length = array.length;
		for(int i = 0 ; i < length; i ++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (array[j] > array[j +1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j+1] = temp;
				}
			}
		}
		Utils.printArray(array);
	}
}
