package fixtures;

public class Room extends Fixture {

	//I eventually want to convert this to a map(dictionary) 
	//to print out a value with each key.
	
	private int north, south, west, east, up, down;
	

	

	
	public Room( String name, String shortDescription, String longDescription, int aN, int aS, int aW, int aE, int aUp, int aDown) {
		
		super(name, shortDescription, longDescription);
		this.north = aN;
		this.south = aS;
		this.west = aW;
		this.east = aE;
		this.up = aUp;
		this.down = aDown;
	
}

	public int getN() {
		return north;
	}
	
	public void setN(int aN) {
		this.north = aN;
	}
	
	public int getS() {
		return south;
	}
	
	public void setS(int aS) {
		this.south = aS;
	}
	
	public int getW() {
		return west;
	}
	
	public void setW(int aW) {
		this.west = aW;
	}
	
	public int getE() {
		return east;
	}
	
	public void setE(int aE) {
		this.east = aE;
	}
	
	public int getDown() {
		return down;
	}
	
	public void setDown(int aDown) {
		this.down = aDown;
	}
	
	public int getUp() {
		return up;
	}
	
	public void setUp(int aUp) {
		this.up = aUp;
	}
	
}