package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class is responsible for creating and playing the sound 
 * effects of the game. It has a single media player as its 
 * instance variable.
 * 
 * @author JiayuZhu and Shari Sinclair
 *
 */
public class SoundEffect {
	private MediaPlayer mediaPlayer;
	
	// Battle sound effects//
	/**
	 * This method plays the sword swing sound effect.
	 */
	public void swingSound() {
		String musicFile = "./src/swing2.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.1);
	}

	/**
	 * This method plays the sound effect when magic is used.
	 */
	public void magicSound() {
		String musicFile = "./src/fireball.mp3";
		Media sound2 = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound2);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.06);
	}
	
	/**
	 * This method plays a sound when the enemy is killed.
	 */
	public void enemyDeathSound() {
		String musicFile = "./src/enemyDeath.wav";
		Media sound3 = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound3);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.5);		
	}
	/**
	 * This method plays a sound when the hero is killed.
	 */
	public void heroDeathSound() {
		String musicFile = "./src/heroDeath2.wav";
		Media sound3 = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound3);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.5);		
	}
	
	/**
	 * This method plays a sound when the hero uses any types of the potion. 
	 */
	public void healSound() {
		String musicFile = "./src/healSound.wav";
		Media sound3 = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound3);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.5);		
	}
	
	
	// Shop sound effect//
	/**
	 * This method plays a sound when the player buy or sell an item. 
	 */
	public void moneySound() {
		String musicFile = "./src/goldSound.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());		
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.3);		
	}
	
	// Event sound effect//
	/**
	 * This method creates the chest opening sound effect. 
	 */
	
	public void openChestSound() {
		String musicFile = "./src/chestOpening.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.8);		
	}
	
	// General sound effect//
	
	/**
	 * This method plays a sound when there is an error.
	 */
	public void errorSound() {
		String musicFile = "./src/error.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.6);		
	}
	/**
	 * Method allows us to play the same sound when buttons are pressed
	 */
	public void transitionSound() {
	    String musicFile = "./src/startSound.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setVolume(0.1);
	}
	
	// Creating media players for songs//
	
	/**
	 * Method creates opening music media player
	 * 
	 * @return mediaPlayer music media player
	 */
	public MediaPlayer openingMusic() {
	    String musicFile = "./src/startMusic.wav";
	    Media sound = new Media(new File(musicFile).toURI().toString());
	    mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.setVolume(0.2);
	    return mediaPlayer;
	}
	
	/**
	 * Method creates music media player for when the game is over
	 * 
	 * @return mediaPlayer  music media player
	 */
	public MediaPlayer gameOverMusic() {
	    String musicFile = "./src/gameoverMusic.wav";
	    Media sound = new Media(new File(musicFile).toURI().toString());
	    mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.setVolume(0.2);
	    return mediaPlayer;
	}

	/**
	 * Method creates music media player for when you win the game
	 * 
	 * @return mediaPlayer  music media player
	 */
	public MediaPlayer youWinMusic() {
	    String musicFile = "./src/youWinSong.wav";
	    Media sound = new Media(new File(musicFile).toURI().toString());
	    mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.setVolume(0.2);
	    return mediaPlayer;
	}
	
	/**
	 * Method creates background/battle music media player
	 * 
	 * @return mediaPlayer music media player
	 */
	public MediaPlayer backgroundMusic() {
	    String musicFile = "./src/fightmusiccut.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(0.03);
		return mediaPlayer;
	}

	
	
}