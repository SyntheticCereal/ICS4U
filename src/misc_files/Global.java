package misc_files;

public class Global {
	//Global
	static int x =5;
	public static void main(String[] args) {
		//Local
		int x =-5;
		x++;
		System.out.println(x);
		printme(x);
		printx();
		
		
		//If static use class name
		Global.x =77;
		//Not static use "this"
		//this.x =77;
	}
	
	static void printx() {
		System.out.println(x);
	}
	
	static void printme(int x) {
		System.out.println(x);
	}
}
