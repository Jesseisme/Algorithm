package sort;

/**
 * @author jvyhuang
 *
 */
public class Quick {
	private final static int CUTTOFF = 10;

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		
		  if (lo >= hi) return;

		// 对于小序列，直接采用插入排序替代
/*		if (hi - lo <= CUTTOFF - 1) {
			Sort.Insertion(a, lo, hi);
			return;
		}*/
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		while (true) {
			Product	while (a[++i] < v) {
				if (i == hi) { 
					break;
				}
			}
			while (a[--j] > v) {
				if (j == lo) {
					break;
				}
			}
			
			if(i>=j) break;
			swap(a, i, j);
			
		}
		swap(a, j, lo);
		return j;
	}

	private static void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	public static void main(String args[]) {
		int[] a = { 66, 13, 51, 76, 81, 26, 57, 69, 23 };
		sort(a);
		for (int n : a)
			System.out.print(n + ", ");
	}

}
