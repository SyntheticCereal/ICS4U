
public class SingletonExample {

	 //create an object of SingleObject
	private static SingletonExample  instance = new SingletonExample();
	
	 //make the constructor private so that this class cannot be instantiated
	private SingletonExample() {}

	//Get the only object available
	public static SingletonExample getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}


	public static void main(String[] args) {

		//Get the only object available
		SingletonExample  object = SingletonExample .getInstance();

		//show the message
		object.showMessage();
	}
}