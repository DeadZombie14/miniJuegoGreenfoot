import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Dificultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificultad extends Actor
{
    private int dificultad=0;
    private String texto = "";
    private String facil = "facil";
    private String medio = "medio";
    private String dificil = "dificil";
    private String imposible = "imposible";
    /**
     * Act - do whatever the Puntuacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage(new GreenfootImage("Nivel de aparacion: " + texto, 20, Color.WHITE, Color.BLACK));
        obtenerDificultad();
    }    
    public void obtenerDificultad()
    {
        MyWorld world = (MyWorld) getWorld();
        dificultad= world.obtenerDificultadTotal();
        if(dificultad == 1)
        {
            texto = facil;
        }
        if(dificultad == 2)
        {
            texto = medio;
        }
        if(dificultad == 3)
        {
            texto = dificil;
        }
        if(dificultad == 4)
        {
            texto = imposible;
        }
    }
}

