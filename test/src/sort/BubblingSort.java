package sort;

/**
 * 冒泡排序
 * @author weilongzhang
 *
 */
public class BubblingSort {
	public static void main(String[] args) {
		int[] array = {5,6,78,9,0,-5,6,7,8,90,3,4,56,7,8,93,45,6,78,9};
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
