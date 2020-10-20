package Projects;
// Sources: https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/

import java.util.*;
public class Project {
	 private static int i;
	 private static String [] inbox = new String[5];{
	 inbox[0]= "Flashlight";
	 inbox[1]= "Half of a Key";
	 inbox[2]= "Big Blanket";
	 inbox[3]= "empty";
	 inbox[4]= "empty";}
	 
	 static Scanner scanner = new Scanner(System.in);
	 static String answer;
	 
	 public void introduction()
	 {

		 System.out.println("=================STORY=================\n"
			 		+ "You wake up with a bad headache. You look around, you see nothing but darkness around you. (Enter any key to continue) ");
		 answer = scanner.nextLine ();
		 System.out.println("You feel the ground and find a backpack which presumably looks like yours. ");
		 answer= scanner.nextLine();
		 System.out.println("Your eyes adjust to the darkness, and you realise that you are in an ancient egyptian pyramid.\n");
		 answer= scanner.nextLine();
	     System.out.println( "--------------MANUAL-----------------\n"
			 		+ "Type a,b,c or d to select actions you are going to take.");
		 answer= scanner.nextLine();
		 System.out.println("You can only carry up to 5 things in your bagpack.--choose wisely what you will be carrying.\n" 
			 		+ "Good luck!"); 
		 answer= scanner.nextLine();
	 }
	 
	 public static void backpack () {
		 System.out.println("Items in Backpack:");
		 for (i=0; i<5; i++)
		 {
			 System.out.println(inbox[i]);
		 }
		 System.out.println("Would you like to remove an item from your backpack? (y/n)");
		 answer = scanner.nextLine();
		 if (answer.equals("y")) {
			 System.out.println("What item would you like to remove?\nLook above to see the list of items");
			 answer= scanner.nextLine();
			 while (!Arrays.asList(inbox).contains(answer));
			 {
				 if (answer.equals("empty"))
				 {
					 System.out.println("You cannot take out something empty");
				 }
				 System.out.println("Invalid input. Enter your answer again.");
				 answer= scanner.nextLine ();
			 }
			 for(i=0;i<5;i++) {
				 if ((inbox[i]).equals(answer)) {
					 inbox[i]= "empty";
					 System.out.println("Your item has been removed");
				 }
				 
			 }
		 }
	 }
	 
	 public static void Path1() {
		 System.out.println("\nEnter any key to continue");
		 answer = scanner.nextLine ();
		 System.out.println("You look around, and find a door.");
		 answer = scanner.nextLine ();
		 System.out.println("Outside of that door, you see three different paths in front of you\n"
		 		+ "Which one will you take?");
		 System.out.println("a: Very very dark stairway going up-> Flashlight required\n"
		 		+ "b: Another door with a skull attached to it\n"
		 		+ "c: Very very dark stairway going down-> Flashlight requried\n"
		 		+ "d: Check what is in my backpack\n");
		 answer = scanner.nextLine();
		 
		 
		 while ( !answer.equals("a")&& !answer.equals("b") && !answer.equals("c") && !answer.equals("d") &&!answer.equals("e"))
		 {
			 System.out.println("Not a valid input, enter again");
			 answer = scanner.nextLine();
		 }
		 if (answer.equals("a"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="Flashlight")
				 {
					 System.out.println("You manage to pass the very dark stairway.");
					 Project.Golden_Room();
					
				 }
			 }
		 }
		 else if (answer.equals("b"))
		 {
			Project.Skull_Door();
		 }
		 
		 else if (answer.equals("c"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="Flashlight")
				 {
					 System.out.println("You walk carefully downstairs");
					 Project.Down_Stairway ();
					 
				 }
			 }
		 }
		 
		 else if (answer.equals("d"))
		 {
			 Project.backpack ();
			 Project.Path1 ();
		 }
	 }
		 
	 
	 public static void Golden_Room() {
		 answer = scanner.nextLine ();
		 System.out.println("You enter a room filled with treasures and gold");
		 answer = scanner.nextLine ();
		 System.out.println("What will you do?");
		 System.out.println("a:search the room\n"
		 		+ "b: Ignore the treasures and continue forward to another room\n"
		 		+ "c: Go back down the stairway\n"
		 		+ "d: Check what is in my backpack");
		 answer = scanner.nextLine ();
		
		 while (!answer.equals("a")&& !answer.equals("b") && !answer.equals("c") && !answer.equals("d") && !answer.equals("e"))
		 {
			 System.out.println("Not a valid input, enter again");
			 answer = scanner.nextLine();
			 
		 }
		 
		 if (answer.equals("a"))
		 {
			 Project.Search_Golden ();
			 
		 }
		 else if (answer.equals("b"))
		 {
			System.out.println("As you go in the room, you hear the door slam behind you");
			answer = scanner.nextLine ();
			System.out.println("Behind, you see a big boulder being pushed your way, and there is no way to avoid being squished by the boulder");
			answer = scanner.nextLine ();
			System.out.println("Quick! You search for a way out! On the door, you see a keyhole, presumably fitting the one you had in your backpack");
			answer = scanner.nextLine ();
			System.out.println("Do you have the whole key?");
			for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="Whole Key")
				 {
					 System.out.println("Phew... The door opens, and you run out of the room!\nYou luckily have survived!");
					 answer = scanner.nextLine ();
					 Project.Golden_Room();
					 
				 }
				 
			 }
			System.out.println("Oh No!!!! You do not seem to have the whole key :(\n");
			answer = scanner.nextLine ();
			System.out.println("The boulder gets closer and closer, and you get squeezed to death.");
			System.out.println("==========Game Over============");
		 }
		 
		 else if (answer.equals("c"))
		 {
			 Project.Path1();
		 }
		 
		 
		 else if (answer.equals("d"))
		 {
			 Project.backpack();
			 Project.Golden_Room();
		 }
	 }
	 
	 public static void Search_Golden (){
		 System.out.println("Enter any key to continue");
		 answer = scanner.nextLine ();
		 System.out.println("You go closer to the pile of treasures in the middle of the ground\n");
		 answer = scanner.nextLine ();
		 System.out.println("You see and select a few items that may be useful in the future"
		 		+ "What will you take with you?");
		 System.out.println("a: A beautiful golden staff\n"
		 		+ "b: A diamaond the size of someone's hand\n"
		 		+ "c: a half of a key\n"
		 		+ "d: Take nothing\n"
		 		+ "e: Check my backpack");
		 answer = scanner.nextLine ();
		 
		 while (!answer.equals("a")&& !answer.equals("b") && !answer.equals("c") && !answer.equals("d") &&!answer.equals("e"))
		 {
			 System.out.println("Not a valid input, enter again");
			 answer = scanner.nextLine();
		 }
		 if (answer.equals("a"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="empty")
				 {
					 inbox[i]="Golden Staff";
				 }
			 }
		 }
		 
		 else if (answer.equals("b"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="empty")
				 {
					 inbox[i]="Diamond";
				 }
				 else
				 {
					 System.out.println("Sorry, but your backpack is full");
					 answer = scanner.nextLine();
					 System.out.println("W");
				 }
			 }
			 System.out.println("would you like to collect another item? y/n");
			 answer = scanner.nextLine();
			 if (answer.equals("y")) {
				 Project.Search_Golden();
			 }
			 
		 }
		 
		 else if (answer.equals("c"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox[i]=="Half of a Key")
				 {
					 inbox[i]="Whole Key";
				 }
			 }
		 }
		 
		 else if (answer.equals("d"))
		 {
			 for (i=0;i<5;i++)
			 {
				Project.Golden_Room ();
			 }
			 
		 }
		 
		 else if (answer.equals("e"))
		 {
			 Project.backpack();
			 Project.Search_Golden();
		 }
		 
	 } 

	 
	 public static void Skull_Door () {
		 System.out.println("\nEnter any key to continue");
		 answer = scanner.nextLine ();
		 System.out.println("You enter the room");
		 answer = scanner.nextLine ();
		 System.out.println("You look around, and you see two coffins in the shape of canoes, both facing open space which you do not know the destination to");
		 answer = scanner.nextLine ();
		 System.out.println("What will you do?");
		 answer = scanner.nextLine ();
		 System.out.println("a: Ride the canoe on the Right\n"
		 		+ "b: Ride the canoe on the Left\n"
		 		+ "c: Leave the Room and go back to origin\n"
		 		+ "d: Check Backpack");
		 
		 while (!answer.equals("a")&& !answer.equals("b") && !answer.equals("c") && !answer.equals("d") &&!answer.equals("e"))
		 {
			 System.out.println("Not a valid input, enter again");
			 answer = scanner.nextLine();
		 }
		 if (answer.equals("a"))
		 {
			 System.out.println("You ride the canoe on the right");
			 answer = scanner.nextLine();
			 System.out.println("Suddenly, the canoe lurches, and starts to fly forward towards the open space");
			 answer = scanner.nextLine();
			 System.out.println("You see sunlight just above your head just enough for another canoe to fit through");
			 answer = scanner.nextLine ();
			 System.out.println("However, your canoe does not reach that opening.\nUh oh... Your canoe crashes into a wall.");
			 System.out.println("=============GAME OVER============");
		 }
		 
		 else if (answer.equals("b"))
		 {
			 for (i=0;i<5;i++)
			 {
				 if (inbox [i]=="Golden Staff")
				 {
					 System.out.println("You ride the canoe on the left");
					 answer = scanner.nextLine();
					 System.out.println("Suddenly, the canoe lurches, and starts to fly forward towards the open space");
					 answer = scanner.nextLine();
					 System.out.println("You see sunlight in front of you and your canoe passes through that opening.");
					 answer = scanner.nextLine ();
					 System.out.println("When you open your eyes, you realise that you are outside of the Pyramid!");
					 answer = scanner.nextLine ();
					 System.out.println("Well Done! You managed to survive!");
					 for (i=0;i<5;i++)
					 {
						 if (inbox[i]=="Diamond")
						 {
							 System.out.println("Also, you have just become very very rich! Yay!!!!!");
							 answer = scanner.nextLine ();
							 System.out.println("Thank you for playing this game, and I hope you have a nice day!");
						 }
					 }
				 }
			 }
		 }
		 
		 else if (answer.equals("c"))
		 {
			 Project.Path1();
		 }
		 
		 else if (answer.equals("d"))
		 {
			 Project.backpack();
			 Project.Skull_Door ();
		 }
		 
	 }
	 
	 public static void Down_Stairway () {

		 System.out.println("\nEnter any key to continue");
		 answer = scanner.nextLine ();
		 System.out.println("You go into a suddenly very light room");
		 answer = scanner.nextLine ();
		 System.out.println("Instantly, you can feel yourself melting from the heat");
		 answer = scanner.nextLine ();
		 System.out.println("You search for your backpack, and search for something useful to fight the fire that envelopes this room");
		 answer = scanner.nextLine ();
		 System.out.println("What will you use?");
		 System.out.println("a: "+inbox[0]);
		 System.out.println("b: "+inbox[1]);
		 System.out.println("c: "+inbox[2]);
		 
		 while (!answer.equals("a")&& !answer.equals("b") && !answer.equals("c"))
		 {
			 System.out.println("Not a valid input, enter again");
			 answer = scanner.nextLine();
		 }
		 if (answer.equals("a"))
		 {
			 System.out.println("Turning on the Flashlight did not help improve this situation");
			 answer = scanner.nextLine();
			 System.out.println("Sadly, the fires ");
			 System.out.println("You died");
			 System.out.println("=============GAME OVER===============");
		 }
		 
		 else if (answer.equals("b"))
		 {
			 System.out.println("Using the Key did not help improve this situation");
			 answer = scanner.nextLine();
			 System.out.println("You died");
			 System.out.println("=============GAME OVER===============");
		 }
		 
		 else if (answer.equals("c"))
		 {
			 System.out.println("You used the blanket to protect yourself from the flames");
			 answer = scanner.nextLine();
			 System.out.println("After some searching, you find a vent! You are back to your original position.");
			 Project.Path1();
		 }
	 
	 }
	 
	 public static void main(String[]args) {
		 Project a = new Project ();
		 Scanner scanner = new Scanner (System.in);
		 
		 a.introduction ();
		 a.backpack();
		 a.Path1 ();
		 
		 
		 
		 
		 
		 
		 
	 }
	 

}
