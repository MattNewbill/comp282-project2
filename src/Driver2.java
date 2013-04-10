/**
 * @author Matt Newbill
 * @author Matt Hamersky
 * Comp 282 
 * Project 2
 * Spring 2013
 * Driver2 Class
 */
import java.util.*;
public class Driver2 {
	private Scanner screen; 
	private int k;
	
	public Driver2(){
		screen = new Scanner(System.in);
	}
	
	public static void main(String[] args){
		Driver2 driver = new Driver2();
		System.out.println("Welcome to castle helper.\n");
		driver.readFile();
		driver.calculateReachableRooms();
		driver.calculateMinWorkToOpenAllRooms();
		driver.calculateTotalSpookiness();
		driver.calculateMaxSpookiness();
	}

	private void readFile() {
		// TODO Auto-generated method stub
		
	}

	private void calculateMaxSpookiness() {
		// TODO Auto-generated method stub
		
	}

	private void calculateTotalSpookiness() {
		// TODO Auto-generated method stub
		
	}

	private void calculateMinWorkToOpenAllRooms() {
		// TODO Auto-generated method stub
		
	}

	private void calculateReachableRooms() {
		// TODO Auto-generated method stub
		System.out.println("The reachable rooms are: " + ".\n");
	}

}
