/**
 * @author Matt Newbill
 * @author Matt Hamersky
 * Comp 282 
 * Project 2
 * Spring 2013
 * Driver2 Class
 */

/**
 * A Room consists of a level of spookiness and 6 adjacent doors.
 * Door 0 = the top left door
 * Door 1 = the top door
 * Door 2 = the top right door
 * Door 3 = the bottom left door
 * Door 4 = the bottom door
 * Door 5 = the bottom right door
 */
public class Room {
    int spookiness;
    Door[] adjacentDoors = new Door[6];
    int k;
    /**
     * Creates a room with an integer level of spookiness and 
     * 6 adjacent doors in the form of an array of Doors.
     * 
     * @param spookiness - spookiness of the room
     * @param i - the room index we are currently adding
     * @param k - the k value of the castle
     */
    public Room(int spookiness, int i, int k) {
	this.spookiness = spookiness;
	int nextRoom;
	//sets top left door
	nextRoom = (i-1>=0 && i-1<k*k) ? i-1 : -1;
	adjacentDoors[0] = new Door(i, nextRoom, Math.abs(i-nextRoom));
	//sets top door
	nextRoom = (i-k>=0 && i<k*k) ? i-k : -1;
	adjacentDoors[1] = new Door(i, nextRoom, Math.abs(i-nextRoom));
	//sets top right door
	nextRoom = (i-k+1>=0 && i<k*k) ? i-k+1 : -1;
	adjacentDoors[2] = new Door(i, nextRoom, Math.abs(i-nextRoom));
	//sets bottom left door
	nextRoom = (i+k-1>=0 && i<k*k) ? i+k-1 : -1;
	adjacentDoors[3] = new Door(i, nextRoom, Math.abs(i-nextRoom));
	//sets bottom door
	nextRoom = (i+k>=0 && i<k*k) ? i+k : -1;
	adjacentDoors[4] = new Door(i, nextRoom, Math.abs(i-nextRoom));
	//sets bottom right door
	nextRoom = (i+k+1>=0 && i<k*k) ? i+k+1 : -1;
	adjacentDoors[5] = new Door(i, nextRoom, Math.abs(i-nextRoom));
    }
    /*
     * Getters
     */
    public Door getTopLeftDoor(){
	return adjacentDoors[0];
    }

    public Door getTopDoor(){
	return adjacentDoors[1];
    }

    public Door getTopRightDoor(){
	return adjacentDoors[2];
    }

    public Door getBottomLeft(){
	return adjacentDoors[3];
    }
    
    public Door getBottom(){
	return adjacentDoors[4];
    }

    public Door getBottomRight(){
	return adjacentDoors[5];
    }

    public int getSpookiness() {
	return spookiness;
    }
    
    /*
     * Setters
     */
    /*
    public void setTopLeftDoor(int value){
	this.adjacentDoors[0] = value;
    }

    public void setTopDoor(int value){
	this.adjacentDoors[1] = value;
    }

    public void setTopRightDoor(int value){
	this.adjacentDoors[2] = value;
    }

    public void setBottomLeft(int value){
	this.adjacentDoors[3] = value;
    }
    
    public void setBottom(int value){
	this.adjacentDoors[4] = value;
    }

    public void setBottomRight(int value){
	this.adjacentDoors[5] = value;
    }*/

    public void setSpookiness(int spookiness) {
	this.spookiness = spookiness;
    }




}
