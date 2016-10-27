package sort;

/**
 * 基数排序
 * 
 * @author weilongzhang
 *
 */
public class RadixSort {
	public static void main(String[] args) {
		int[] a = Utils.createArray(10, 1000);
		radixSort(a);
		Utils.printArray(a);
	}

	public static void radixSort(int[] a) {
		System.out.println("基数排序");
		int maxBit = 0;
		int max = a[0];
		// 取出最大值，然后求出最大值的位数
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		while (max > 0) {
			max /= 10;
			maxBit++;
		}
		// 三次冒泡排序后正确
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length - i - 1; j++) {
		// if (a[j] % 10 > a[j + 1] % 10) {
		// int temp = a[j];
		// a[j] = a[j + 1];
		// a[j + 1] = temp;
		// }
		// }
		// }
		// Utils.printArray("第一次：",a);
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length - i - 1; j++) {
		// if (a[j] / 10 % 10 > a[j + 1] / 10 % 10) {
		// int temp = a[j];
		// a[j] = a[j + 1];
		// a[j + 1] = temp;
		// }
		// }
		// }
		// Utils.printArray("第二次：",a);
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length - i - 1; j++) {
		// if (a[j] / 100 % 10 > a[j + 1] / 100 % 10) {
		// int temp = a[j];
		// a[j] = a[j + 1];
		// a[j + 1] = temp;
		// }
		// }
		// }
		// Utils.printArray("第三次：",a);
		// 开始循环
		for (int n = 0; n < maxBit; n++) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (a[j] / Math.pow(10, n) % 10 > a[j + 1] / Math.pow(10, n) % 10) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				}
			}
		}
		Utils.printArray(a);
	}
}
