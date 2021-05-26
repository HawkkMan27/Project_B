package game;
import java.util.*;

import fixtures.Room;
public class RoomManager {

	private ArrayList <Room>Map;
	private Player player;
	
	List<String> commands = new ArrayList<>(Arrays.asList("north", "south", "west", "east", "up","down", "take item", "q"));
	
	public RoomManager() {
		this.Map = new ArrayList<Room>();
		
		//String name, String shortDescription, String longDescription,  aN,  aS, aW, aE, up , down
		Map.add(new Room("The Main Entrance", "A long hallway with worn walls", "While you walk into the Pyramid the ground is covered in sand and steadily clears to a tile mozaic\n" 
						+ "as you walk further in. The walls go from sanded down surfaces to beautiful geometric fractals with each step forward\n" 
						+ "The red rock glows even more, you use it as a light to illuminate the room."  , 2 , 1 , Direction.NoExit , Direction.NoExit, Direction.NoExit, Direction.NoExit ));
		Map.add(new Room("The desert", "A vast and wide Region of Sand and Sun", "Toward the direction of the Pyramid the Sky is clear and bright Sunny!\n" 
							+ "Away from the Pyramid behind you a massive Sandstorm darkens the horizon with specs of lightning and the sound of Thunder beckoning.\n" 
							+ "You should probably head in for shelter" , 0, Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit ));
		Map.add(new Room("The Ceramony Room", "Filled with Statues", "In this room there are a variety of Statues. The statues are all bowing down.", 5 , 0 , 4 , 3 , Direction.NoExit, Direction.NoExit ));
		Map.add(new Room("The Right Downstairs", "Room with a Stairway", "There is a narrow Staircase leading up into the darkness. ", Direction.NoExit, Direction.NoExit, 2 , Direction.NoExit, 6 , Direction.NoExit ));
		Map.add(new Room("The Left Downstairs", "Room with a Stairway", "There is a narrow Staircase leading up into the darkness. ", Direction.NoExit, Direction.NoExit, Direction.NoExit, 2 , 7 , Direction.NoExit));
		Map.add(new Room("The Family Room", "Room full of Coffins", "This room contains four Statues with coffins in front of them!\n" 
						+ "The Statues are 20 feet tall with each in the shape of a family member.\n" 
						+ "A Queen statue, and three Male Pharoah statues stand over you like giants!" , Direction.NoExit, 2 , 8 , 9 , Direction.NoExit, Direction.NoExit ));
		Map.add(new Room("The Right Upstairs", "Entrance to the upper Tomb", "After climbing the Stairs you notice a half opened entrance with a Boulder as a Door.\n" 
						+ "The boulder has a Sun painted on it.", Direction.NoExit, Direction.NoExit, 10 , Direction.NoExit, Direction.NoExit, 3));
		Map.add(new Room("The Left Upstairs", "The upstairs Door is Shut", "Once up the stairs you notice the entrance is blocked off by a massive Boulder with a Tree painted on it", Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit, 4));
		Map.add(new Room("The Left Hallway", "Hallway full of Hieroglyphs", "The walls are covered in heiroglyphs and paintings, mostly depicting farmers and shepards.", 11 , Direction.NoExit, Direction.NoExit, 5 , Direction.NoExit, Direction.NoExit));
		Map.add(new Room("The Right Hallway", "Hallway full of small coffins", "Small coffins of cats and dogs line the walls of this Hallway with nothing enscribed on the walls", 11, Direction.NoExit, 5 , Direction.NoExit, Direction.NoExit, Direction.NoExit));
		Map.add(new Room("The Upper Tomb Entrance", "The Blood Red Fountain", "Statues of Soldiers line the walls. They're all pointing their spears to the North Exit.\n" 
						+ "In the Center of the Room a fountain magically still flows with red colored water\n"
						+ "Your shocked by the design, curious as to how the fountain is able to run", 12 , Direction.NoExit, Direction.NoExit, 6 , Direction.NoExit, Direction.NoExit));
		Map.add(new Room("The Ritual Room", "A bloody Alter with Skeleton sitting on top", "The Room smells funny, and there are many skulls on the floor.\n"
						+ "The walls are covered in paintings of people with faces frowning.\n" 
						+ "Their hands reaching to the ceiling as if they were holding it up", Direction.NoExit, Direction.NoExit, 8 , 9 , Direction.NoExit, 13 ));
		Map.add(new Room("The Kings Sarcophagus", "A bright room with a Sarcophagus in the center", "The Room is well lit as a small slit at the top of the room\nbeams down light which hits a mirror ever so perfectly and bounces light onto other mirrors." 
						+ "\nAnother hole drips water down into a square pool\nwith miniature canals feeding water to the edges of the walls.\nMoss appears to be growing all over the floor like a carpet." 
						+ "\nThere before you lies a massive Golden Sarcophagus in the center" 
						+ "\nof the Turquoise Pool!\n You\'re stunned by its beauty, and enginuity!", Direction.NoExit, 10 , Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit));
		Map.add(new Room("The Kings Treasure Room", "A room full of Treasures", "A massive room full of Gold! \nStatues and chariots covered in gold" 
						+ "\n Bags of gold coins liter the ground!\nYou can't help but grab a handful. ;}", Direction.NoExit, Direction.NoExit, Direction.NoExit, Direction.NoExit, 11 , Direction.NoExit));
		
		player = new Player("player", "a newcomer", Map.get(1));
		
	} 
	String GameWon = "\n\nA portal has appeared at the back of the Treasure Room.\n" 
					 + "You enter the portal and in a blink of an eye you return back to your Room. \"Huh What!\"\n" 
					 + "\"What a Nightmare that was,\" you say to yourself.\n"
					 + "You begin to smile as you look in your hand and there they are.\n The Gold and Red Stones glowing bright!!!\n";
	
	String ExitNames(int index) {
		if (index == Direction.NoExit) {
			return "No Exit";
		} else {
		Room rm = Map.get(index);
		String nextRoom = rm.getName();
		
		
		return nextRoom;
			}
		}

	
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	void moveActorTo(Player p, Room aRoom) {
		p.setRoom(aRoom);
	}
	
	//Define exits for player when in room
	int moveTo(Player anActor, Direction dir) {
		Room r = anActor.getRoom();
		int exit;
		
		switch (dir) {
		case North:
			exit = r.getN();
			break;
		case South:
			exit = r.getS();
			break;
		case East:
			exit = r.getE();
			break;
		case West:
			exit = r.getW();
			break;
		case Up:
			exit = r.getUp();
			break;
		case Down:
			exit = r.getDown();
			break;
		default:
			exit = Direction.NoExit;
			break;
		}
		
		if (exit != Direction.NoExit) {
			moveActorTo(anActor, Map.get(exit));
		}
		return exit;
	}
	
	public int movePlayerTo(Direction dir) {
		return moveTo(player, dir);
	}
	private void goN() {
		updateOutput(movePlayerTo(Direction.North));
	}
	
	private void goS() {
		updateOutput(movePlayerTo(Direction.South));
	}
	private void goW() {
		updateOutput(movePlayerTo(Direction.West));
	
	}
	
	private void goE() {
		updateOutput(movePlayerTo(Direction.East));
	}
	
	private void goUp() {
		updateOutput(movePlayerTo(Direction.Up));
	}
	
	private void goDown() {
		updateOutput(movePlayerTo(Direction.Down));
	}
	
	//
	void updateOutput(int roomNumber) {
		
		String s;
		if (roomNumber == Direction.NoExit) {
			s = "No Exit!";
		} else {
			Room r = getPlayer().getRoom();
			s = "You are in "
					+ r.getName() + ".\n---------------------------------------------------------\n"
					+ r.getShortDescription() + ".\n---------------------------------------------------------\n"
					+ r.getLongDescription() + ".\n_________________________________________________________";
		}
		if (roomNumber == 11 | roomNumber == 10) {
			System.out.println("\nThe red Rock Begins to Glow brighter. Something must be close by");
		}
		
		
		if (roomNumber == 12) {
			System.out.println("You notice as you walk up to the Tomb a gold stone\n"  
								+ "begins to eminate a blinding yellow light" 
								+ " You can't help but to take this rock off of the Tomb\n"
								+ "and take it with you!");
			getPlayer().setItem(1);
		}
		
		if (roomNumber == 13 & getPlayer().getItem() == 1) {
			System.out.println(GameWon);
		}
		
		System.out.println(s);
	}
	//Runs a command if the word inputed matches a word choice
	public String ProcessWord(String input ) {
		String word;
		String msg = "";
		word = input;
	
		if (!commands.contains(word)) {
			msg = word + " is not a known command! ";
		} else {
			switch (word) {
			case "north":
				goN();
				break;
			case "south":
				goS();
				break;
			case "west":
				goW();
				break;
			case "east":
				goE();
				break;
			case "up":
				goUp();
				break;
			case "down":
				goDown();
				break;
			default:
				msg = word + " (not yet implemented)";
				break;
				
				}
			}
		return msg;
	}
	
	public String ParseCommand(String input) {
		String msg;
		msg = ProcessWord(input);
		return msg;
	}
	
	


}

