
import java.util.*;

/**
 * This program simulates a game of dreidel. It does this by taking the rules typical game of dreidal 
 * and applying them. First it gives 10 chips to each player, and then a number of spins take place 
 * where depending on what is rolled,  different conditions are applied. This goes on until one player 
 * has all of the chips, where the players either choose to end the program, or play another game 
 * of dreidal.
 * @author dliu
 */
//Check whose turn it is once, 
//four if statements once

public class dreidelDanny {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		System.out.print("Welcome to the Dreidal Game!\nFor instructions press \"1\"\nTo start the game press \"2\": ");
		byte cnt = in.nextByte();

		//Asks if they want instructions
		if (cnt == 1){ 
			System.out.println("\nINSTRUCTIONS:");
			System.out.println("Every player has 10 chips \nEach player puts one chip in the pot at the start of the game");
			System.out.println("Next each player will spin the dreidal \nDepending on what the dreidal lands on various things will happen:");
			System.out.println("\tIf נ (nun) is facing up,\n\t\tThe player does nothing.");
			System.out.println("\tIf ג (gimel) is facing up,\n\t\tThe player gets everything in the pot.");
			System.out.println("\t\tIf the pot is empty then each player then puts a chip in and the game continues.");
			System.out.println("\tIf ה (hei) is facing up\n\t\tThe player gets half of the chips in the pot.");
			System.out.print("\t\tIf there are an odd number of chips in the pot, ");
			System.out.println("the player takes the half the pot rounded up to the nearest whole number.");
			System.out.println("\tIf ש (shin) is facing up,\n\t\tThe player adds 2 chips to the pot.");
			System.out.println("Everyone spins the dreidal until all but one player loses all of their chips.");
			System.out.println("\nReady to start the game? Press Enter to start: ");
			in.nextLine();
		}

		in.nextLine();
		System.out.println("\nPlayer 1, enter your name: ");
		String name1 = in.nextLine();
		System.out.println("Player 2, enter your name: ");
		String name2 = in.nextLine();

		//Runs the game, replays the game if player wants
		do {
			int play1 = 10;
			int play2 = 10;
			int pot = 0;
			cnt = 1;

			System.out.println("\n" + name1 + " has " + play1 + " chips");
			System.out.println(name2 + " has " + play2 + " chips");
			System.out.println("Everyone puts one chip in the pot");
			Thread.sleep(1000);

			//Each player adds one chip to the pot 
			pot += 2;
			play1--;
			play2--;

			//Starts the game, goes on until one person has all of the chips
			do{
				System.out.println("\n" + name1 + " " + play1 + " chips");
				System.out.println(name2 + " has " + play2 + " chips");
				System.out.println("There are " + pot + " chips in the pot");

				//Decide whose turn it is
				if (cnt == 1) {
					System.out.print("\n" + name1 + "'s turn (Press enter to spin!): ");
				}
				else {
					System.out.print("\n" +name2 + "'s turn (Press enter to spin!): ");
				}
				in.nextLine();

				//Puts time between "." to simulate how you wait when a dreidel spins
				for (int i = 0; i < 3; i ++) {
					Thread.sleep(1000);
					System.out.print(". ");
					Thread.sleep(1000);
				}
				//What the dreidel spun
				int randDre = (int)(Math.random()*4+1);

				//Different things happen depending on what the dreidel spun
				switch (randDre) {

				//If nun is spun
				case 1:
					System.out.println("\nנ (nun) Nothing happens.");
					//Check whose turn, allows other player to go
					if (cnt == 1) {
						//Add 1 to the counter so player 2 will go
						cnt++;
					}
					else {
						//Subtract 1 to the counter so player 1 will go
						cnt--;
					}
					break;

					//If gimel is spun
				case 2:
					System.out.println("\nג (gimel) The player gets everything in the pot.");
					//if pot is empty add to pot, else apply condition to player
					if (pot == 0) {
						System.out.println("There are 0 chips in the pot, too bad!");
						System.out.println("Everyone puts one chip in the pot");
						//Take 1 from each player, add 2 to pot
						pot += 2;
						play1--;
						play2--;
						//Check whose turn, allows other player to go
						if (cnt == 1) {
							//Add 1 to the counter so player 2 will go 
							cnt++;
						} 
						else {
							//Subtract 1 to the counter so player 1 will go
							cnt--;
						}
						break;
					}
					else if (cnt == 1) {
						//Player takes all chips in pot
						play1 = play1 + pot;
						pot = 0;
						//Add 1 to the counter so player 2 will go 
						cnt++;
					}
					else{
						//Player takes all chips in pot
						play2 = play2 + pot;
						pot = 0;
						//Subtract 1 to the counter so player 1 will go
						cnt--;
					}
					break;

					//If hei is spun
				case 3:
					System.out.println("\nה (hei) The player gets half of the chips in the pot.");
					//if pot is empty add to pot, else apply condition to player
					if (pot == 0) {
						System.out.println("There are 0 chips in the pot, too bad!");
						System.out.println("Everyone puts one chip in the pot");
						//Take 1 from each player, add 2 to pot
						pot += 2;
						play1--;
						play2--;
					}
					else if (cnt == 1) {
						// Take half chips from pot, rounds up
						play1 = play1 + ((int)((pot/2.0) + 0.5));
						pot = pot - ((int)((pot/2.0) + 0.5));
						// Add 1 to the counter so player 2 will go
						cnt++;
					}
					else {
						// Take half chips from pot, rounds up
						play2 = play2 + ((int)((pot/2.0) + 0.5));
						pot = pot - ((int)((pot/2.0) + 0.5));
						// Subtract 1 to the counter so player 1 will go
						cnt--;
					}
					break;

					//If shin is spun
				case 4:
					System.out.println("\nש (shin) the player adds 2 chips to the pot.");
					//Check whose turn it is
					if (cnt == 1) {
						//Takes 2 chips to the player
						play1 = play1 - 2;
						// Add 1 to the counter so player 2 will go
						cnt++;
					}
					else {
						//Take 2 from player 2
						play2 = play2 - 2;
						// subtract 1 to the counter so player 1 will go
						cnt--;
					}
					//Add 2 chips to the pot
					pot = pot + 2;
					break;
				}
			} while (play1 > 0 && play2 > 0);
			//Check who won
			if (play1 <= 0) {
				System.out.print(name2 + " Wins!\nPress 0 to end! Press 1 to play again! ");
			}
			else if (play2 <= 0) {
				System.out.print(name1 + " Wins!\nPress 0 to end! Press 1 to play again! ");
			}	
			cnt = in.nextByte();
		} while (cnt != 0);
	} 
}
