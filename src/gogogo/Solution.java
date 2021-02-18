package gogogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static  void  main(String re[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		minBrace(s);
		
	}
	public static void minBrace(String s) {
		int size = s.length();
		int[][] mb =new int[size+1][size+1];
		for(int i=1;i<=size;i++) {
			mb[i][i] =1;
		}
		for(int d=1;d<size;d++) {
			for(int i=1;i+d<=size;i++) {
				int j=i+d;
				mb[i][j] =Math.min(mb[i][j-1], mb[i+1][j])+1;
				for(int k=i;k<=j-1;k++) {
					if(match(s.charAt(k-1),s.charAt(j-1))==true) {
						mb[i][j] = Math.min(mb[i][j], mb[i][k-1]+mb[k+1][j-1]);
					}
				}
			}
		}
		System.out.println(mb[1][size]);
	}
	static boolean match(char a,char b ) {
		if(a=='('&&b==')') {
			return true;
		}
		if(a=='['&&b==']') {
			return true;
		}
		return false;
	}

}