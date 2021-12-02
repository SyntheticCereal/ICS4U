package elevators;

public class ElevatorTest {

	public static void main (String[] args) {
		Elevators east = new Elevators(5);
		Elevators south = new Elevators();

		south.addPeople(10);
		south.toString();
		south.closeDoors();
		south.goToFloor(4);
		south.openDoors();
		south.removePeople(3);
		south.toString();
		south.closeDoors();
		south.goToFloor(25);
		south.openDoors();
		south.removePeople(6);
		south.toString();
		
		east.addPeople(8);
		east.toString();
		east.closeDoors();
		east.goToFloor(8);
		east.openDoors();
		east.addPeople(30);
		east.toString();
		
		east.closeDoors();
		east.goToFloor(-1);
		east.goToFloor(26);
		
		south.closeDoors();
		south.goToFloor(-1);
		south.goToFloor(26);
		
		east.goToFloor(2);
		south.goToFloor(2);
		
		east.openDoors();
		
		Elevators.setPowerState(false);
		
		east.up();
		east.down();
		east.openDoors();
		east.closeDoors();
		
		south.up();
		south.down();
		south.openDoors();
		south.closeDoors();
		
		Elevators.setPowerState(true);
		Elevators.setPowerState(true);
		
		south.goToFloor(1);
		
		for (int i = 0; i <=10; i++) {
			south.closeDoors();
			south.up();
			south.openDoors();
		}
		
	}
}
