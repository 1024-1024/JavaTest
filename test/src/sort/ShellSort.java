package sort;

/**
 * 希尔排序
 * 
 * @author weilongzhang
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] a = Utils.createArray(10);
		shellSort(a);
		Utils.printArray(a);
	}

	public static void shellSort(int[] a) {
		System.out.println("希尔排序");
		for (int increment = a.length / 2; increment > 0; increment /= 2) {
			for (int i = 0; i < a.length; i += increment) {
				for (int k = i; k > 0; k -= increment) {
					if (a[k] < a[k - increment]) {
						int tmp = a[k];
						a[k] = a[k - increment];
						a[k - increment] = tmp;
					}
				}
			}
		}
		Utils.printArray(a);
	}

}
