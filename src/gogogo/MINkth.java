package gogogo;

import java.util.ArrayList;
import java.util.Scanner;

public class MINkth {
	public static void main(String rea[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		getMinKth(a,k);
		for(int i=0;i<k;i++) {
			System.out.print(a[i]+",");
		}
	}
	public static void getMinKth(int a[],int k){
		int lo=0;int hi=a.length-1;
		while(lo<hi) {
			int j = partition(a, lo, hi);
			if(j==k) break;
    		else if(j>k) hi=j-1;
    		else if(j<k) lo=j+1;
		}
	}
	private static int partition(int[] a, int lo, int hi) {
		int i=lo,j=hi+1;
		int v=a[lo];
		while(true) {
			while(v>=a[++i]) if(i==hi) break; 
			while(v<=a[--j]) if(j==lo) break;
			if(i>=j) break;
			swap(a,i,j);
		}
		swap(a,lo,j);
		return j;
	}
	private static void swap(int[] a, int i, int j) {
		int temp= a[j];
		a[j] = a[i];
		a[i]= temp;
	}
}
