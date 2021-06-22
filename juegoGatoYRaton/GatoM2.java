import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GatoM2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GatoM2 extends Actor
{
    private int temporizadorGiro=0;
    
    public GatoM2()
    {
        setLocation(66,64);
        setRotation(45);
    }
    /**
     * Act - do whatever the GatoM2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        temporizadorGiro++;
        if(temporizadorGiro > 30)
        {
            move(5);
        }
        limitesDelMapa();
    }
    
    /**
     * Añade los limites del mapa
     */
    public void limitesDelMapa()
    {
          if(getWorld()==null){return;}
        int altura= getImage().getHeight();
        int anchura= getImage().getWidth();
        int anchuraDelMapa= getWorld().getWidth();
        int alturaDelMapa= getWorld().getHeight();
        //Si es el borde derecho
        if((getX() + (anchura/2)) > anchuraDelMapa)
        {
            turn(20);
        }
        //Si es el borde izquierda
        if((getX() - (anchura/2)) < 0)
        {
            turn(20);
        }
        //Si es el borde superior
        if((getY() + (altura/2)) > alturaDelMapa)
        {
            turn(20);
        }
        //Si es el borde inferior
        if((getY() - (altura/2)) < 0)
        {
            turn(20);
        }
    }
}
