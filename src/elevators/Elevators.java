package elevators;

public class Elevators {
	final static String manufacturer = "Otis";
	final static int topFloor = 10;
	final static int maxOccupants = 25;
	static boolean powerOn = true;

	private int floor = 1;
	private int people = 0;
	private boolean doorsOpen = false;

	Elevators() {

	}

	Elevators(int floor) {
		if (floor < 0 || floor > topFloor) {
			floor = 1;
		}
	}

	static void setPowerState (boolean newState) {
		if (newState != powerOn) {
			System.out.println("The state of the power has changed");
		}
		newState = powerOn;
	}

	void up() {
		if (doorsOpen == false && powerOn == true && floor++ <= topFloor) {
			floor++;
		}
	}

	void down() {
		if (doorsOpen == false && powerOn == true && floor-- >= topFloor) {
			floor--;
		} 
	}

	void openDoors() {
		if (powerOn == true) {
			doorsOpen = true;
		} else {
			System.out.println("Error! Power is not on!");
		}
	}

	void closeDoors() {
		if (powerOn == true) {
			doorsOpen = false;
		}else {
			System.out.println("Error! Power is not on!");
		}
	}

	void goToFloor(int fTraveled) {
		if (doorsOpen == false && powerOn == true && floor+fTraveled <= topFloor && floor-fTraveled > 0) {
			floor += fTraveled; 
		} else if (powerOn == false) {
			System.out.println("Please check if power is on");
		} else if (doorsOpen == true) {
			System.out.println("Please close the door");
		} else if (floor+fTraveled > topFloor || floor-fTraveled <= 0) {
			System.out.println("Please travel to a valid floor");
		}
		
	}

	void addPeople(int morePeople) {
		if (doorsOpen == true && people+morePeople <= maxOccupants && morePeople >= 0) {
			people+= morePeople; 
		}
	}

	void removePeople(int lessPeople) {
		if (doorsOpen == true && people-lessPeople >= 0 && lessPeople >= 0) {
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
