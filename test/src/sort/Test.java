package sort;

public class Test {
	public static void main(String[] args) {
//		int a = getTast();
//		int a = 'A';
//		System.out.println(a);
		
		int[] a = Utils.createArray(20);
		BinarySort.binarySort(a);
		BubblingSort.bubbleSort(a);
		HeapSort.heapSort(a);
		InsertSort.insertSort(a);
		RadixSort.radixSort(a);
		SelectSort.selectSort(a);
		ShellSort.shellSort(a);
	}
	
	public static int getTast() {
		for(;;) {
			System.out.println("----");
			if (true) {
				return 100;
			} else {
				System.out.println("=====");	
			} 
		}
	}
}
