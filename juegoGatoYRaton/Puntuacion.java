import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Puntuacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntuacion extends Actor
{
    private int puntaje=0,puntajeTemp=0;
    /**
     * Act - do whatever the Puntuacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("Puntuacion: " + puntaje, 20, Color.WHITE, Color.BLACK));
        if(puntajeTemp >= 50)
        {
            puntajeTemp = 0;
            crearNuevoJefe();
        }
    }    
    public void sumarUnPunto()
    {
        puntaje++;
        puntajeTemp++;
    }
    public int obtenerPuntuacionTemporal()
    {
        return puntajeTemp;
    }
    public int obtenerPuntuacion()
    {
        return puntaje;
    }
    /**
     * Permite crear un nuevo Jefe.
     */
    public void crearNuevoJefe()
    {
        if(getWorld()==null){return;}
        MyWorld world = (MyWorld) getWorld();
      int x = Greenfoot.getRandomNumber(world.getWidth());
      int y = Greenfoot.getRandomNumber(world.getHeight());
      world.jefeEnJuego();
      world.addObject(new RatonOmega(),x, y);
      world.addObject(new ojoJefe(), x,y);
      inicializarVidaJefe();
    }
    public void inicializarVidaJefe()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      vidaTemporal vidatemp = world.obtenerVidaTemporal();
      vidatemp.resetearVida();
    }
}
