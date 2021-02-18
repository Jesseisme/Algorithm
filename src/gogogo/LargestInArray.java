package gogogo;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		while(sc.hasNextInt()) {
			a.add(sc.nextInt());
		}
		sc.close();
		System.out.println(getMaxSummary(a,0,a.size()-1));
	}

	private static int getMaxSummary(ArrayList<Integer> a, int lo, int hi ) {
		if(lo==hi) return a.get(lo);
		int mid = (int) Math.floor((lo + hi) / 2);
		int left = getMaxSummary(a, lo, mid);
		int right = getMaxSummary(a, mid+1, hi);
		int corss = getMaxCross(a,lo,mid,hi);
		return getMax(left,right,corss);
	}



	private static int getMaxCross(ArrayList<Integer> a, int lo, int mid, int hi) {
		int leftMax = Integer.MIN_VALUE;
		int leftSum = 0;
		for(int i = mid;i>=lo;i--) {
			leftSum = leftSum+a.get(i);
			if(leftSum>leftMax) {
				leftMax = leftSum;
			}
		}
		int rightMax=Integer.MIN_VALUE;
		int rightSum = 0;
		for(int i = mid+1;i<=hi;i++) {
			rightSum = rightSum + a.get(i);
			if(rightSum>rightMax) {
				rightMax=rightSum;
			}
		}
		return rightMax+leftMax;
	}
	private static int getMax(int left, int right, int corss) {
		int max=left;
		if(max<corss) {
			max = corss;
		}
		if(max<right) {
			max= right;
		}
		
		return max;
	}
}
