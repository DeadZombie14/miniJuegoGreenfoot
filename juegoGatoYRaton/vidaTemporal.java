import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class vidaTemporal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vidaTemporal extends Actor
{
    private int vidaRatonOmega = 20;
    private int vidaTemp=vidaRatonOmega;
    /**
     * Act - do whatever the vidaTemporal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void restarUnPuntoVida()
    {
        vidaTemp--;
    }
    public int compartirVida()
    {
        return vidaTemp;
    }
    public void resetearVida()
    {
        vidaTemp = vidaRatonOmega;
    }
}
