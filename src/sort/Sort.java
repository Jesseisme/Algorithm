package sort;

public class Sort {
	// n^2
	public static void bubble(int array[]) {
		int N = array.length;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - i; j++) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				}
			}
		}
	}

	public static void bubbleReverse(int array[]){
		int N = array.length;
		for(int i =0;i<N;i++){
			for(int j = N-1;j>i;j--){
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				}
			}
		}
	}

	public static void Insertion(int array[]) {
		int N = array.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j])
					swap(array, j - 1, j);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String res[]) {
		int a[] = { 66, 13, 51, 76, 81, 26, 57, 69, 23 };
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println();
		// bubble(a);
		// insertion(a);
		Insertion(a, 0, 8);
		for (int i : a) {
			System.out.print(i + ",");
		}
	}

	public static void Insertion(int[] a, int lo, int hi) {
		int N = hi - lo + 1;
		for (int i = lo + 1; i < N; i++) {
			for (int j = i; j > lo && a[j - 1] > a[j]; j--) {
				swap(a, j - 1, j);
			}
		}

	}
}
