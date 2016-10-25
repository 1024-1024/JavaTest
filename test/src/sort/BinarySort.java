package sort;

/**
 * 二分法插入排序
 * @author weilongzhang
 *
 */
public class BinarySort {
	public static void main(String[] args) {
		int[] a = Utils.createArray(10);
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = (left + right)/2;
			while(left <= right) {
				if (a[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				mid = (left + right)/2;
			}
			for (int j = i; j > left; j--) {
				a[j] = a[j - 1];
			}
			a[left] = temp;
		}
		
		Utils.printArray(a);
	}
}
