package gogogo;

import java.util.Scanner;

public class BigDataM {
	public static void main(String res[]) {
		Scanner sc = new Scanner(System.in);
		String l = sc.nextLine();
		String[] split = l.split(" ");
		String snum1= split[0];
		String snum2= split[1];
		sc.close();
		System.out.println(multiply(snum1,snum2));
	}
	private static String multiply(String snum1, String snum2) {
		StringBuilder num1 = new StringBuilder(snum1);
		StringBuilder num2 = new StringBuilder(snum2);
		int d[] =new int[num1.length()+num2.length()-1];
		for(int i = 0;i<num1.length();i++) {
			int a = num1.charAt(i)-'0';
			for(int j=0;j<num2.length();j++) {
				int b = num2.charAt(j)-'0';
				d[i+j]+=a*b;
			}
		}

		StringBuilder res = new StringBuilder();
		for(int i= d.length-1;i>=0;i--) {
			 int digit = d[i] % 10;
			 int carry = d[i] / 10;
			 res.insert(0, digit);
			 if(i>0) {
				 d[i-1]+=carry;
			 }else {
				 if(carry!=0) {
					 res.insert(0, carry);
				 }
			 }
			 
		}
		 /*while (res.length() > 0 && res.charAt(0) == '0') {
			 res.deleteCharAt(0);
		 }*/
		 return res.length() == 0 ? "0" : res.toString();
	}
}
