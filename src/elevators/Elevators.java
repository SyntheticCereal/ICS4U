package elevators;

public class Elevators {
	static String manufacturer = "Otis";
	static int topFloor = 10;
	static int maxOccupants = 25;
	final static boolean powerOn = true;

	private int floor = 1;
	private int people = 0;
	private boolean doorsOpen = false;

	Elevators() {

	}

	Elevators(int floor) {
		if (floor < 0 || floor > topFloor) {
			floor = 0;
		}
	}

	static void setPowerState () {
	}

	void up () {
		floor++;
	}

	void down() {
		floor--;
	}

	void goToFloor(boolean doorsOpen, boolean powerOn) {
		if (doorsOpen = false && powerOn = true && floor+n <= topFloor) {
			floor += n; 
		} else System.out.println("Please check if doors are closed, the power is on and you only to to the top floor");
	}

	void addPeople() {
		if (doorsOpen = true && people+n <= maxOccupants && n >= 0) {
			people+= n; 
		}
	}

	void removePeople() {
		if (doorsOpen = true && people-n >= 0 && n >= 0) {
			people-= n; 
		}
	}

	@Override
	public String toString() {
		String s = " Floor=" + floor + ", people=" + people + ", doors are " + (doorsOpen ? "Open" : "Closed");
		s = "Building power is " + (powerOn ? "ON" : "OFF") + s;
		return s;
	}
}
