package gogogo;

import java.util.ArrayList;
import java.util.Scanner;

public class LostThree {
	public static void main(String resg[]){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		while(sc.hasNextInt()) {
			a.add(sc.nextInt());
		}
		sc.close();
		System.out.println(getRes(a,res));
	}
	private static long getRes(ArrayList<Integer> a,ArrayList<Integer> res) {
		int cmp = 1;
		for(int i=0;i<a.size();i++) {
			if(a.get(i)!=cmp) {
				res.add(cmp);
				cmp++;
			}
			cmp++;
		}
		StringBuilder s = new StringBuilder();
		for(int i =0;i<3;i++) {
			s.append(res.get(i));
		}
		String string = s.toString();
		long num = Long.parseLong(string);
		
		return num;
	}

}
