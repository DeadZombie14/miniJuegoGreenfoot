import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Construye el mensaje de game over.
     */
    public GameOver() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("Game Over", 48, Color.RED, Color.BLACK));
    }    
}
