import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 /**
 * Esta clase sólo sirve para almacenar variables globales de objetos temporales y algunas veces, objetos normales.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class variablesGlobales extends Actor
{
    //ESCRIBIR VARIABLES AQUI
    private int posicionXOmega=0,posicionYOmega=0,color=0;
    
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    //ESCRIBIR FUNCIONES DE LLAMADO, RESETEO Y ASIGNACION AQUI
    public void asignarOmegaPos(int x,int y)
    {
        posicionXOmega= x;
        posicionYOmega= y;
    }
    public int obtenerOmegaX()
    {
        return posicionXOmega;
    }
    public int obtenerOmegaY()
    {
        return posicionYOmega;
    }
        
    public void sumarColor()
    {
        color++;
    }
    public int obtenerColor()
    {
        return color;
    }
    public void resetearColor()
    {
        color=0;
    }
}
