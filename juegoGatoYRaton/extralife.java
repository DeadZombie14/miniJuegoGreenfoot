import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class extralife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class extralife extends Actor
{
    private int tiempoDeVida=0;
    public extralife()
    {
        
    }
    /**
     * Act - do whatever the extralife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        tiempoDeVida++;
        if(tiempoDeVida > 120)
        {
            getWorld().removeObject(this);
        }
        comprobarContacto();
    }    
    public void comprobarContacto()
    {
        if(getWorld()==null){return;}
       Actor actor = getOneObjectAtOffset(0,0,Gato.class);
        if(actor!=null)
        {
            sumarUnaVida();
        }
    }
    public void sumarUnaVida()
    {
      if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      Gato gato = world.getGato();
      gato.sumarUnaSolaVida();
      getWorld().removeObject(this);
    }
}
