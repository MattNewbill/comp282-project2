/**
 * @author Matt Newbill
 * @author Matt Hamersky
 * Comp 282 
 * Project 2
 * Spring 2013
 * Driver2 Class
 */

/**
 * An instance of a door contains the weight of required to open the door,
 * the room its coming from and the room it is going to.
 * @author Matt
 *
 */
public class Door {
    int weight;
    int from;
    int to;
    public Door (int from,int to, int weight){
	this.from = from;
	this.to = to;
	this.weight = weight;
    }
    
}
