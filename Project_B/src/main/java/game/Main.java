package game;

import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static String RunCommand(String inputstr) {
		
		
		String lowstr = inputstr.trim().toLowerCase();
		
		if (lowstr.equals("")) {
			lowstr = "You must enter a command";
		} else {
			System.out.println("\"You walk " + lowstr + "\"" );
			
		}
		return lowstr;
	}
	public static void main(String[] args) throws IOException {
		
		String Input;
		String output;
		
		RoomManager Game = new RoomManager();
		
		
		
		System.out.println("As you take a stroll around the block you stumble upon a weird blue glowing rock, and \n"
				+ "you love collecting rocks and don't hesitate to pick it up.\n\n" 
				+ "As you pick it up you notice the rock is heavy like lead.\n"
				+ "You decide to place it in your pocket to add to your rock collection back home which you cherish deeply\n");
		System.out.println("When you place it in your rock collection you notice the rock begins to glow even more\n"
				+ "To your surprise a large red rock you found a month ago begins to glow as well.\n\n"
				+ "You're too curious and decide to examine the red rock by picking it up!!\n"
				+ "You're hand cramps and you grip it tighter. The rooms spinning! You pass out while standing before you can even feel your body hit the floor!\n"
				+ "You awake in front of a massive pyramid in the middle of the desert with the entrance in front of you.\n\n"
				+ "You're in shock and disbelief, noticing a weird SandStorm is approaching and the glowing red rock still in your hands\n"
				+ "you think to yourself \"What now.\"");
		
		Scanner input = new Scanner(System.in);
		
	System.out.println("Your current room is " + Game.getPlayer().getRoom().getName() );
		
		do {
//			System.out.println("Options to input: \n________________"
//					+ "North" + playerOne. )
			
			System.out.println("Movement Options  \n__________________\n" 
					+ "north = " + Game.ExitNames(Game.getPlayer().getRoom().getN()) + "\n" 
					+ "south = " + Game.ExitNames(Game.getPlayer().getRoom().getS()) + "\n"
					+ "west = " + Game.ExitNames(Game.getPlayer().getRoom().getW()) + "\n"
					+ "east = " + Game.ExitNames(Game.getPlayer().getRoom().getE()) + "\n"
					+ "up = " + Game.ExitNames(Game.getPlayer().getRoom().getUp()) + "\n"
					+ "down = " + Game.ExitNames(Game.getPlayer().getRoom().getDown()) 
					+ "\n" + "Input \"q\" to Quit. \n____________________" );
			System.out.print( "> ");
			 Input = input.nextLine();
			 output = RunCommand(Input);
			 System.out.println(Game.ParseCommand(output));
			 
			 if ("q".equals(Input)) {
			 System.out.println("Ending Program: Goodbye!");
			 }
			 if (Game.getPlayer().getRoom().getName() == "The Kings Treasure Room" & Game.getPlayer().getItem() == 1) {
				 System.out.println("This concludes the Game! Thank You");
				 Input = "q";
			 }
		} while (!"q".equals(Input));
		
		input.close();
	}
}
