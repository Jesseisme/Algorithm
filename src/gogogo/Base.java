package gogogo;

public class Base {
	 static Base a = new Base();
	 {
		 System.out.print("C");
	 }
	 static {
		 System.out.print("S");
	 }
	 Base(){}

	public static void main(String[] args) {
		new Base();
	}

}
