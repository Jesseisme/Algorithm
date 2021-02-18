package gogogo;

import java.util.Scanner;

public class MaxSummary {
	public static void main(String[] args) {
		// int[] a = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22,
		// 15, -4, 7 };
		// int[] a = { 13,30};

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int a[] = new int[num];

		for (int i = 0; i < num; i++) {
			a[i] = sc.nextInt();
		}
		int res = getMaxSummary(a, 0, num - 1);
		System.out.println(res);
		sc.close();
	}

	private static int getMaxSummary(int a[], int lo, int hi) {
		if (lo == hi) {
			return a[lo];
		} else {
			int mid = (int) Math.floor((lo + hi) / 2);
			;
			int right = getMaxSummary(a, lo, mid);
			int left = getMaxSummary(a, mid + 1, hi);
			int cross = getMaxCross(a, lo, hi, mid);
			if (right >= left && right >= cross) {
				return right;
			} else if (left >= right && left >= cross) {
				return left;
			} else {
				return cross;
			}
		}

	}

	private static int getMaxCross(int[] a, int lo, int hi, int mid) {
		int leftsum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= lo; i--) {
			sum = sum + a[i];
			if (sum > leftsum) {
				leftsum = sum;
			}
		}

		int rightsum = Integer.MIN_VALUE;
		int sum2 = 0;
		for (int i = mid + 1; i <= hi; i++) {
			sum2 = sum2 + a[i];
			if (sum2 > rightsum) {
				rightsum = sum2;
			}
		}

		return rightsum + leftsum;
	}

}