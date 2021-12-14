package elevators;

public class Elevators {
	final static String manufacturer = "Otis";
	final static int topFloor = 10;
	final static int maxOccupants = 25;
	static boolean powerOn = true;

	private int floor = 1;
	private int people = 0;
	private boolean doorsOpen = false;

	Elevators() {}

	Elevators(int floor) {
		if (floor < 0 || floor > topFloor) {
			floor = 1;
		}
	}

	static void setPowerState (boolean newState) {
		if (newState != powerOn) {
			System.out.println("The state of the power has changed");
			powerOn = newState;
		}
	}

	//
	void up() {
		if (!doorsOpen && powerOn && floor++<= topFloor) {} 
		}

	//Goes down if doors are closed, power is on and is greater than 0
	void down() {
		if (!doorsOpen && powerOn && floor-- >= 0) {} 
	}

	//Opens door if power is on
	void openDoors() {
		if (powerOn) {
			doorsOpen = true;
		} else {
			System.out.println("Error! Power is not on!");
		}
	}

	//Closes door if power is on
	void closeDoors() {
		if (powerOn) {
			doorsOpen = false;
		}else {
			System.out.println("Error! Power is not on!");
		}
	}

	//Travels to fTraveled if doors are closed, power is on and the floor is valid
	void goToFloor(int fTraveled) {
		if (!doorsOpen&& powerOn && floor+fTraveled < topFloor && fTraveled>0) {
			floor = fTraveled;
		}
	}

	//Adds people if doors are open and produces a valid number
	void addPeople(int morePeople) {
		if (doorsOpen&& people+morePeople <= maxOccupants && morePeople >= 0) {
			people+= morePeople; 
		}
	}

	//Removes people if doors are open and produces a valid number
	void removePeople(int lessPeople) {
		if (doorsOpen && people-lessPeople >= 0 && lessPeople >= 0) {
			people-= lessPeople; 
		}
	}


	@Override
	public String toString() {
		String s = " Floor=" + floor + ", people=" + people + ", doors are " + (doorsOpen ? "Open" : "Closed");
		s = "Building power is " + (powerOn ? "ON" : "OFF") + s;
		return s;
	}
}
