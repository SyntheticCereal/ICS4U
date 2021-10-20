package ObjectLesson;

class Car {

	//Instance variables
	final String make; //final = once set it cannot be changed
	private int odometer = 12;

	//Constructor
	Car(String make){
		this.make = make;
	}

	//Constructor
	Car(String make, int odo){
		this.make = make;
		odometer = odo;
	}

	//Nobody can access
	private Car() {
		make = "unknown";
	}

	void drive(int distance) {
		this.odometer += Math.abs(distance);
	}
	
	int getOdometer() {return odometer;}
	
	void setOdometer(int n) {
		
	}

	@Override
	public String toString() {
		String s = "Make:" + make + "\tOdometer:" + odometer;
		return s;
	}
}