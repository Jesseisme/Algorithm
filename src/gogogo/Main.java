package gogogo;

import java.util.Scanner;

public class Main {


	public static void main (String res[]) {
		
		Scanner sc= new Scanner(System.in);
		String s = sc.nextLine();
		getRes(s);
	}
	private static int getRes(String s) {
		String A ="A";
		String C ="C";
		String G ="G";
		String T ="T";
		if(s==null) {
			
			System.out.println(0);
			return 0;
		}
		for(int i = 0;i<s.length();i++) {

			int index1 = s.indexOf(A);
			if(index1 ==-1) {
				System.out.println(i); break; 
				
			} 
			A=A+"A";
			int index2 = s.indexOf(C);
			if(index2 ==-1) {
				System.out.println(i); break; 
				
			} 
			C=C+"C";
			
			int index3 = s.indexOf(G);
			if(index3 ==-1) {
				System.out.println(i); break; 
				
			} 
			G=G+"G";
			
			int index4 = s.indexOf(T);
			if(index4 ==-1) {
				System.out.println(i); break; 
				
			} 
			T=T+"T";
			
		}

		return 0;
	}
}