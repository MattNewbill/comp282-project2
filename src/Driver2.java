/**
 * @author Matt Newbill
 * @author Matt Hamersky
 * Comp 282 
 * Project 2
 * Spring 2013
 * Driver2 Class
 */
import java.io.*;
import java.util.*;
public class Driver2 {
	/* Global fields */
	private static Scanner screen; 
	private static Room theRooms[];
	private static int k;
	
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Welcome to castle helper.\n");
		File inputFile = new File("sample.txt");
		screen = new Scanner(inputFile);
		initializeSpookiness();
		blockedDoors();
		
	}

	/** Read (from the data file) and set the spookiness for each room */
	private static void initializeSpookiness() {
		String tempSize = screen.nextLine(); //pull out K from file
		tempSize = tempSize.trim();
		k = Integer.parseInt(tempSize);
		
		theRooms = new Room[k * k];  //Intialize array of Room
		for(int i = 0; i < theRooms.length; i++) {
			String tempSpookiness = screen.nextLine();
			tempSpookiness = tempSpookiness.trim();
			int spookiness = Integer.parseInt(tempSpookiness);
			theRooms[i] = new Room(spookiness, i, k);
		}
	}
	
	/** Remove the blocked off doorways */
	private static void blockedDoors() {
		while(screen.hasNext()) {
			String tempBlockedDoor = screen.nextLine();
			String[] temp = tempBlockedDoor.split("\\s+");
			int firstDoor = Integer.parseInt(temp[0]);
			int secondDoor = Integer.parseInt(temp[1]);
			theRooms[firstDoor].removeDoor(secondDoor);
			theRooms[secondDoor].removeDoor(firstDoor);
		}
	}
	
	private static void calculateReachableRooms() {
		Queue<Integer> visited = new Queue<Integer>();
		
		System.out.println("The reachable rooms are: " + ".\n");
	}
	
	private static void calculateMinWorkToOpenAllRooms() {
		int n = 0;
		
		System.out.println("The minimum amount of work necessary to open " +
						   "doors so that all rooms are accessable is: " + n);
		
	}
	
	private static void calculateMinWorkBetweenTwoRooms() {
		
	}
	
	private static void calculateTotalSpookiness() {
		// TODO Auto-generated method stub
		
	}

	private static void calculateMaxSpookiness() {
		// TODO Auto-generated method stub
		
	}

}
