/**
 * @author Matt Newbill
 * @author Matt Hamersky
 * Comp 282 
 * Project 2
 * Spring 2013
 * Driver2 Class
 */
import java.util.*;
import java.io.*;
import java.util.*;
public class Driver2 {
	/* Global fields */
	private static Scanner screen; 
	private static Room theRooms[];
	private static int k;
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Welcome to castle helper.\n");
		File inputFile = new File("sample.txt");
		screen = new Scanner(inputFile);
		initializeSpookiness();
		blockedDoors();
		calculateMinWorkBetweenTwoRooms();
		
	}

	/**
	 * Read (from the data file) and set the spookiness for each room
	 */
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
	
	/**
	 * Remove the blocked off doorways
	 */
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
	
	/**
	 * Finds all the rooms that can be reached
	 */
	private static void calculateReachableRooms() {
		ArrayDeque<Integer> visited = new ArrayDeque<Integer>();
		ArrayList<Integer> processed = new ArrayList<Integer>();
		ArrayList<Integer> remaining = new ArrayList<Integer>();
		visited.add(0); //Starts at the entrance which is index 0
		//initializeRemainingRooms(remaining);
		
		System.out.print("The reachable rooms are: ");
		
		while(!visited.isEmpty()) { //while there are items still to be visited
			ArrayList<Integer> adjacentRooms = theRooms[visited.peek()].getValidDoors();
			addAdjacent(adjacentRooms, visited);
			processed.add(visited.peek()); //the first visited room is now finished
			visited.remove(); //delete the first visited from "visited"
		}
		printProcessedRooms(processed);
	}
	
	/**
	 * Adds the array of adjacent rooms into the "visited" queue
	 * @param adjacent
	 * @param visited
	 */
	private static void addAdjacent(ArrayList<Integer> adjacent, 
									ArrayDeque<Integer> visited) {
		for(int i = 0; i < adjacent.size(); i++) {
			visited.push(i);
		}
	}
	
	/**
	 * Indexes through the "processed" array and makes sure there are no
	 * duplicates.  Then it prints them.
	 * @param processed
	 */
	private static void printProcessedRooms(ArrayList<Integer> processed) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < processed.size(); i++) {
			for(int j = 0; j < processed.size(); j++) {
				if((i != j) && (processed.get(i) != processed.get(j))) {
					temp.add(processed.get(i));
				}
			}
		}
	}
	
	/*private static void initializeRemainingRooms(ArrayList<Integer> remaining) {
		for(int i = 1; i < (k * k); i++) {
			remaining.add(i);
		}
	}*/
	
	private static void calculateMinWorkToOpenAllRooms() {
		int n = 0;
		
		System.out.println("The minimum amount of work necessary to open " +
						   "doors so that all rooms are accessable is: " + n);
		
	}
	
	private static void calculateMinWorkBetweenTwoRooms() {
		int[][] result = new int[k*k][k*k];
		for(int col = 0; col<k*k; col++)
		    for(int row = 0; row<k*k; row++)
			result[row][col] = calculateMinWork(row,col);
		System.out.println("Minimum amount of work to move between " +
				"a pair of rooms:");
		printTable(result);
	}

	private static int calculateMinWork(int from, int to){
	    if(from %2 == 0)//for testing print purposes
	    return 0;
	    return 11;
	}
	
	private static void calculateTotalSpookiness() {
		// TODO Auto-generated method stub
		
	}

	private static void calculateMaxSpookiness() {
		// TODO Auto-generated method stub
		
	}
	
	private static void printTable(int[][] result) {
	    for(int row = 0; row<k*k; row++){
		for(int col = 0; col<k*k; col++){
		    if(result[row][col] == -1)
			System.out.printf("%2s ","XX");
		    else
			System.out.printf("%2d ",result[row][col]);
		}
	    System.out.println();
	    }
		    
	    
	}

}
