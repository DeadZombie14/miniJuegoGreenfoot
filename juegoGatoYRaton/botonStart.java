import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class botonStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botonStart extends Actor
{
    private int color=1,tempColor=0;
    /**
     * Act - do whatever the botonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public botonStart()
    {
        setImage(new GreenfootImage("Reiniciar", 40, Color.RED, Color.WHITE));
    }
    public void act() 
    {
        // Add your action code here.
        tempColor++;
        if(tempColor >= 30)
        {
            cambiarColor();
            tempColor=0;
        }
        if(Greenfoot.mouseClicked(this))
        {
            World world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }    
    /**
     * Hace cambiar de color al boton.
     */
    public void cambiarColor()
    {
        if(color == 1)
        {
            setImage(new GreenfootImage("Reiniciar", 40, Color.RED, Color.BLACK));
            color++;
        }
        else
        {
            
         if(color == 2)
         {
            setImage(new GreenfootImage("Reiniciar", 40, Color.RED, Color.WHITE));
            color++;
         }
         else
         {
            if(color > 2)
            {
            color=1;
            }
         }
        }
        
    }
}
