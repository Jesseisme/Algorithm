package gogogo;

import java.util.Scanner;

public class KthInArray {

	public static void main(String res[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); 
		
		// 正则把多个空格变成一个
		String[] scanin =str.split(" ");
		int  k = sc.nextInt();
		sc.close();
		int[] nums = new int[scanin.length];
		for(int i =0;i<scanin.length;i++) {
			nums[i] = Integer.parseInt(scanin[i]);
		}
		System.out.println(findKthLargest(nums,k));
	}
	
	 public static int findKthLargest(int[] nums, int k) {
		 int l=nums.length;
		return select(nums,l-k);
	 }
    private static int select(int[] nums, int k) {
    	if(nums.length==1)return nums[0];
    	int lo=0;int hi=nums.length-1;
    	while(lo<hi){
    		int j=partition(nums,lo,hi);
    		if(j==k) return  nums[k];
    		else if(j>k) hi=j-1;
    		else if(j<k) lo=j+1;
    	}
		return nums[k];
    	

	}

    private static int partition(int[] a, int lo, int hi) {
		int v = a[lo];
		int i=lo,j=hi+1;
		while(true){
			while(v>=a[++i]) if(i==hi) break;
			while(v<=a[--j]) if(j==lo) break;
			if(i>=j) break;
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
		}
		int temp = a[j];
		a[j]=a[lo];
		a[lo]=temp;
		//Collections.swap(a, lo, j);
		return j;
	}

}
