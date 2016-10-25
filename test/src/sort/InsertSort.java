package sort;

/**
 * 直接插入排序
 * @author weilongzhang
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] a = Utils.createArray(10);
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j --;
			}
			if (j != i ) {
				a[j + 1] = temp;
			}
		}
		
		Utils.printArray(a);
	}
}
