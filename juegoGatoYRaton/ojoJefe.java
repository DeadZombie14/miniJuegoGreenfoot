import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ojoJefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ojoJefe extends Actor
{
    private int temporizador1=0,temporizadorMuerte=0,spawneoX=0,spawneoY=0;
    private boolean jefe=false;
    /**
     * Act - do whatever the ojoJefe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        jefe = world.comprobarJefe();
        
        
        explotar();
        
        if(jefe)
        {
            girarHaciaEnemigo();
            movimientoPegadoAJefe();
        }
    }    
    /**
     * Lanzar una explosión en caso de que no se encuentre ningun jefe en el mapa.
     */
    public void explotar()
    {
        if(getWorld()==null){return;}
        MyWorld world = (MyWorld) getWorld();
        jefe = world.comprobarJefe();
        if(!jefe)
        {
            temporizador1++;
            temporizadorMuerte++;
                turn(20);
            if(temporizador1 > 20)
            {
                spawneoX++;
                spawneoY++;
                getWorld().addObject(new Raton(),getX()+spawneoX,getY()+spawneoY);
                temporizador1=0;
            }
            if(temporizadorMuerte > 300)
            {
                temporizadorMuerte=0;
                getWorld().removeObject(this);
            }
        }
    }
    /**
     * Permite cambiar la posicion del ojo para perseguir al enemigo.
     */
    public void girarHaciaEnemigo()
    {
        if(getWorld()==null){return;}
        MyWorld world = (MyWorld) getWorld();
        Gato enemigo = world.getGato();
        if(enemigo.getWorld()==null){return;}
        turnTowards(enemigo.getX(),enemigo.getY());
    }
    public void movimientoPegadoAJefe()
    {
        if(getWorld()==null){return;}
        int x, y;
        MyWorld world = (MyWorld) getWorld();
        variablesGlobales variables = world.obtenerVariables();
        x= variables.obtenerOmegaX();
        y= variables.obtenerOmegaY();
        setLocation(x,y);
    }

}
