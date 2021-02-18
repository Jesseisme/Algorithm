package sort;

public class HeapSort {
	
	public static void main(String[] args) {
		int a[] = { 2, 0, 16, 20, 3, 11, 17, 8, 33, 19 };
		HeapSort hs = new HeapSort();
		hs.HeapSort(a);
		for (int i : a) {
			System.out.print(i + ",");
		}
	}
	
	public void HeapSort(int a[]) {
		int size = a.length - 1;
		BuildHeap(a, size);
		//33,20,17,8,19,11,16,2,0,3,
		//一个数字与最后交换，前面的重新开始
		for (int i = size; i > 0; i--) {
			swap(a, i, 0);
			Heapify(a, 0, --size);
		}
	}

	// 自底向上 A[(n/2)+1...n] 为树的叶子节点 O(n)
	public void BuildHeap(int a[], int size) {
		for (int i = size / 2; i >= 0; i--) {
			Heapify(a, i, size);
		}
	}
	

	// root right left 三个节点 比较得出最大的节点 交换做为根节点 O(lgn)
	public void Heapify(int a[], int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;

		if (left <= size && a[left] > a[max]) {
			max = left;
		}
		if (right <= size && a[right] > a[max]) {
			max = right;
		}
		if (max != i) {
			swap(a, max, i);
			Heapify(a, max, size);
		}
	}



	private void swap(int[] a, int max, int i) {
		int temp = a[max];
		a[max] = a[i];
		a[i] = temp;
	}


}
