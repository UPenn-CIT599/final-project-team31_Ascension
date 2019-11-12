package application;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class is an extension of the GameCharacters class. It represents a
 * Warrior game character.
 * 
 * @author Shari Sinclair
 *
 */
public class Warrior extends GameCharacters {
	
	/**
	 * The constructor sets the stats(attack,defense and stamina) of the Warrior
	 * object, and also sets the values needed to display the image instance
	 * variable in the GUI.
	 */
	public Warrior() {
		// Stat values will be changed
		setAttack(175);
		setDefense(70);
		setStamina(500);
		setCurrentStamina(getStamina());
		setX(100);
		setY(240);
		setWidth(450);
		setHeight(470);
		setLevel(1);
		setCharacterImage(new Image("Warrior.png",getWidth(), getHeight(), false, false));
		setType("Warrior");
	}

}
