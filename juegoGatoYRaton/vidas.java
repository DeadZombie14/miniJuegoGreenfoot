import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class vidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vidas extends Actor
{
    private int vidas=0;
    /**
     * Act - do whatever the vidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public vidas() 
    {
        // Add your action code here.
        
    }    
    public void act()
    {
        obtenerVidas();
        setImage(new GreenfootImage("VIDAS: " + vidas, 20, Color.WHITE, Color.BLACK));
    }
    public void obtenerVidas()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      Gato gato = world.getGato();
      vidas = gato.vidas();
    }
}
