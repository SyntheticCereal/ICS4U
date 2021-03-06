package elevators;

/*
 * Chris S
 * ICS4U1
 * 16/12/21
 * Elevator object
 * Runs methods created in Elevators
 */

public class ElevatorTest {

	public static void main (String[] args) {
		Elevators east = new Elevators(5);
		Elevators south = new Elevators();

		south.openDoors();
		south.addPeople(10);
		System.out.println(south.toString());
		south.closeDoors();
		south.goToFloor(4);
		south.openDoors();
		south.removePeople(3);
		System.out.println(south.toString());
		south.closeDoors();
		south.goToFloor(25);
		south.openDoors();
		south.removePeople(6);
		System.out.println(south.toString());
		
		east.openDoors();
		east.addPeople(8);
		System.out.println(east.toString());
		east.closeDoors();
		east.goToFloor(8);
		east.openDoors();
		east.addPeople(30);
		System.out.println(east.toString());
		
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
		System.out.println(south.toString());
		
		for (int i = 0; i <9; i++) {
			south.closeDoors();
			south.up();;
			south.openDoors();
			System.out.println(south.toString());
		}
		
	}
}
