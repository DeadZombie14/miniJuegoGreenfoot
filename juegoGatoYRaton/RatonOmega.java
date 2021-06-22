import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RatonOmega here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RatonOmega extends Actor
{
    /**
     * Act - do whatever the RatonOmega wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int velocidadMovimiento=2,temporizador1=0;
    private int vida=0;
    public void act() 
    {
        // Add your action code here.
        movimientoBasico();
        limitesDelMapa();
        IA();
        obtenerVidaTotal();
        matar();
        pasarLocalizacion();
    }  
    /**
     * Transfiere la localizacion actual a las variables globales.
     */
    public void pasarLocalizacion()
    {
        if(getWorld()==null){return;}
        MyWorld world = (MyWorld) getWorld();
        variablesGlobales variables = world.obtenerVariables();
        variables.asignarOmegaPos(getX(), getY());
    }
    /**
     * Añade los limites del mapa
     */
    public void limitesDelMapa()
    {
        int altura= getImage().getHeight();
        int anchura= getImage().getWidth();
        int anchuraDelMapa= getWorld().getWidth();
        int alturaDelMapa= getWorld().getHeight();
        //Si es el borde derecho
        if((getX() + (anchura/2)) > anchuraDelMapa)
        {
            setLocation(0 + (anchura/2), getY());
        }
        //Si es el borde izquierda
        if((getX() - (anchura/2)) < 0)
        {
            setLocation(anchuraDelMapa - (anchura/2), getY());
        }
        //Si es el borde superior
        if((getY() + (altura/2)) > alturaDelMapa)
        {
            setLocation(getX(), 0 + (altura/2));
        }
        //Si es el borde inferior
        if((getY() - (altura/2)) < 0)
        {
            setLocation(getX(), alturaDelMapa - (altura/2));
        }
    }
    /**
     * Añade el movimiento básico al ratón.
     */
    public void movimientoBasico()
    {
        move(velocidadMovimiento);
    }
    /**
     * Añade el efecto IA.
     */
    public void IA()
    {
        //Si el raton ve al gato
        viendoEnemigo();
        
    }
    
    public void viendoEnemigo()
    {
        MyWorld world = (MyWorld) getWorld();
        Gato enemigo = world.getGato();
        if(enemigo.getWorld()==null){return;}
        temporizador1++;
        if(temporizador1 > 50)
        {
            turnTowards(enemigo.getX(),enemigo.getY());
            temporizador1=0;
        }
    }
    /**
     * Actualiza la vida del enemigo.
     */
    public void obtenerVidaTotal()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      vidaTemporal vidatemp = world.obtenerVidaTemporal();
      vida= vidatemp.compartirVida();
    }
    /**
     * Permite matar a esta unidad en caso de que ya no tenga mas vida.
     */
    public void matar()
    {
        if(vida==0)
        {
            if(getWorld()==null){return;}
            MyWorld world = (MyWorld) getWorld();
            variablesGlobales variables = world.obtenerVariables();
            variables.sumarColor();
            world.jefeMuerto();
            world.sumarDificultadExtra();
            getWorld().removeObject(this);
        }
    }
}

