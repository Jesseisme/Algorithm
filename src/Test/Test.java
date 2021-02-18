package Test;

import java.util.HashMap;

public class Test {
	public static void main(String[] args){
		int i= 12;
		i+=i-=i*=i;
		int j =12;
		j*=j;
		j-=j;
		j+=j;
		System.out.println(i);
		System.out.println(j);
		Light.YELLOW.name();
	}
}



