package game;

import fixtures.Fixture;
import fixtures.Room;

public class Player extends Fixture {

	private String name;
	private String Description;
	private Room room;
	private int item;
	
	
	public Player(String name, String Description, Room room) {
		super(name, Description);
		this.name = name;
		this.Description = Description;
		this.room = room;
	}

	public int getItem() {
		return item;
	}
	
	public void setItem(int item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	
}
