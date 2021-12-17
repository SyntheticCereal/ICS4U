package elevators;

/*
 * Chris S
 * ICS4U1
 * 16/12/21
 * Elevator object
 * Creates methods to do certain things i.e going up and down
 */

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
		if (doorsOpen) {
			System.out.println("Error! Doors are open");
		}
		if (!powerOn) {
			System.out.println("Error! Power is not on!");
		}
		if (floor > topFloor) {
			System.out.println("Error! That floor is out of bounds!");
		}
	}

	//Goes down if doors are closed, power is on and is greater than 0
	void down() {
		if (!doorsOpen && powerOn && floor-- > 0) {} 
		if (doorsOpen) {
			System.out.println("Error! Doors are open");
		}
		if (!powerOn) {
			System.out.println("Error! Power is not on!");
		}
		if (floor+1 <= 0) {
			System.out.println("Error! That floor is out of bounds!");
		}
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
		if (!doorsOpen&& powerOn && fTraveled <= topFloor && fTraveled>0) {
			floor = fTraveled;
		}
		if (!doorsOpen) {
			System.out.println("Error! Doors are closed");
		}
		if (!powerOn) {
			System.out.println("Error! Power is not on!");
		}
		if (floor+fTraveled > topFloor || fTraveled<=0) {
			System.out.println("Error! That floor is invalid!");
		}
		System.out.println("");
	}

	//Adds people if doors are open and produces a valid number
	void addPeople(int morePeople) {
		if (doorsOpen&& people+morePeople <= maxOccupants && morePeople >= 0) {
			people+= morePeople; 
		}	
		if (!doorsOpen) {
			System.out.println("Error! Doors are closed");
		}
		if (people+morePeople > maxOccupants) {
			System.out.println("Error! That exceeds the maximum capacity of " + maxOccupants);
		}
		if (morePeople<0) {
			System.out.println("Error! That is an invalid amount of people");
		}
		System.out.println("");
	}

	//Removes people if doors are open and produces a valid number
	void removePeople(int lessPeople) {
		if (doorsOpen && people-lessPeople >= 0 && lessPeople >= 0) {
			people-= lessPeople; 
		}
		if (!doorsOpen) {
			System.out.println("Error! Doors are closed");
		}
		if (people-lessPeople <0) {
			System.out.println("Error! You are removing too many people");
		}
		if (lessPeople<0) {
			System.out.println("Error! That is an invalid amount of people");
		}
		System.out.println("");
	}


	@Override
	public String toString() {
		String s = " Current Floor:" + floor + ", Current Passangers:" + people + ", The Doors are " + (doorsOpen ? "Open" : "Closed");
		s = "The Building's Power is " + (powerOn ? "ON" : "OFF") + s;
		return s;
	}
}
