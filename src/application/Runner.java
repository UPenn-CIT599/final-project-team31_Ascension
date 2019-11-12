package application;
import java.util.*;

import javafx.embed.swing.JFXPanel;


/**
 * @author David Cai
 * This Runner class is for TESTING purposes only. It allows us to test the game
 * in console before the completion of the GUI interface. It lets us prototype
 * and balance the game quickly in concurrence with the development of the GUI.
 * 
 * THIS CLASS WILL BE DEPRECATED as soon as GUI implementation is complete. 
 * Furthermore, design in this particular class is not reflective of the design 
 * implementation for this project due to the focus on quick prototyping.
 */
public class Runner {
	public static void main(String[] args) {
		JFXPanel jfxPanel = new JFXPanel();
		int floor = 1;
		Boolean gameOn = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("What class are you: Warrior/Archer/Mage?");
		String playerChoice = scan.next();
		while (!playerChoice.equals("Warrior") && !playerChoice.equals("Archer") && !playerChoice.equals("Mage")) {
			System.out.println("Invalid choice. Please choose either Warrior/Archer/Mage.");
			playerChoice = scan.next();
		}
		
		GameCharacters player = null;
		
		if (playerChoice.equals("Warrior")) {
			player = new Warrior();
		} else if (playerChoice.equals("Archer")) {
			player = new Archer();
		} else {
			player = new Mage();
		}

		
		
		while (gameOn) {
			int healerCount = 0;
			ArrayList<GameCharacters> enemyList = new ArrayList<GameCharacters>();
			//min 1 enemy + random num from 0 to 1 + sqrt(floor) rounded down
		//	int numEnemies = 1 + (int) (Math.random() * ((1) + 1)) + (int) Math.sqrt(floor); 
			int numEnemies = 1 + (int) Math.sqrt(floor); //no randomization
		//	int totalEnemyHealth = 0;
			for (int i = 0; i < numEnemies; i++) {
				if (floor == 10) {
					enemyList.add(new BossEnemy(floor));
				} else {
					int randEnemy = (int) (Math.random() * ((2) + 1));
					while (randEnemy == 2 && healerCount == 1) { //max one healer per battle
						randEnemy = (int) (Math.random() * ((2) + 1));
					}
					
					if (randEnemy == 0) {
						enemyList.add(new MeleeEnemy(floor));
					} else if (randEnemy == 1) {
						enemyList.add(new RangedEnemy(floor));
					} else {
						enemyList.add(new HealerEnemy(floor));
						healerCount++;
					}
				}
			//	totalEnemyHealth += enemyList.get(i).getCurrentStamina();
			}
			
			while (player.getCurrentStamina() > 0 && numEnemies > 0 && gameOn && floor <= 10) {
				//player turn
				System.out.println("\nThis is floor: " + floor);
				System.out.println("\nYour health: " + player.getCurrentStamina());
				System.out.println("\nYou are facing these enemies: ");
				for (int i = 0; i < numEnemies; i++) {
					System.out.println(enemyList.get(i).getType() + " - Health: " + enemyList.get(i).getCurrentStamina());
				}
				System.out.println("\nIt is your turn. Do you want to:\n1. Attack\n2. Defend\n3. Use item\nOnly attack and defense work now");
				int choice = scan.nextInt();
				if (choice == 1) { //attack
					System.out.println("\nWho do want to attack?");
					for (int i = 0; i < numEnemies; i++) {
						System.out.println(i + 1 + ". " + enemyList.get(i).getType());
					}
					int attackChoice = scan.nextInt();
				
					int attackAmount = player.attack(enemyList.get(attackChoice - 1));
					System.out.println("\nYou dealt " + attackAmount + " damage. Target enemy health: " + enemyList.get(attackChoice - 1).getCurrentStamina());
					if (enemyList.get(attackChoice - 1).getCurrentStamina() <= 0) {
						System.out.println("You have killed the enemy.");
						enemyList.remove(attackChoice - 1);
						numEnemies--;
					}
				} else if (choice == 2) { //defend
					player.setIsDefending(true);
					
				}

				//enemy turn
				System.out.println("\nIt is the enemy's turn.");
				for (int i = 0; i < numEnemies; i++) {
					if (player.getCurrentStamina() > 0) {
						int attackAmount = enemyList.get(i).attack(player);
						System.out.println("The " + enemyList.get(i).getType() + " enemy attacked you!");
						if (attackAmount <= 0) {
							System.out.println("The enemy's attack had no effect on you!");
						} else {
							System.out.println("Your health is now " + player.getCurrentStamina() + ".");
							if (player.isDefending()) {
								System.out.println("Your defense blocked " + attackAmount / 2 + " damage!");
							}
						}
					}
				}
				player.setIsDefending(false);
				if (player.getCurrentStamina() <= 0) {
					System.out.println("\nGame Over.");
					gameOn = false;
				}
				if (numEnemies == 0) {
					System.out.println("\nCongratulations, you have advanced to the next floor!");
					floor++;
					gameOn = true;
				}
			}
			
			if (floor == 11) {
				System.out.println("\nCongratulations, you have finished the game!");
				gameOn = false;
			}
			

		}
	}
}