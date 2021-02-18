package sort;

public class Quick3Way {
	private static  void Sort(int[] array, int lo, int hi) {
		// 对于小序列，直接采用插入排序替代

		if(lo>= hi) return;
		// 三分区
		int lt = lo, i = lo + 1, gt = hi;
		int v = array[lo];
		while (i <= gt) {
			if (array[i] < v)
				swap(array, lt++, i++);
			else if (array[i] > v)
				swap(array, i, gt--);
			else
				i++;
		}

		// 对左边序列进行递归排序
		Sort(array, lo, lt - 1);
		// 对右边序列进行递归排序
		Sort(array, gt + 1, hi);
	}
	


	private static void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void main(String args[]) {
		int[] a = { 66, 13, 51, 76, 81, 26, 57, 69, 23 };
		
		Sort(a,0,a.length-1);
		for (int n : a)
			System.out.print(n + ", ");
	}
}
