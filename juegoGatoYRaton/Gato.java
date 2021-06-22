import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gato extends Actor
{
    private int velocidadControl=2,temporizador1=0,temporizadorGiro=0;
    private boolean iniciarConteo= false, iniciarConteoGiro=false,iniciarMusica=true;
    private int cVidas=5;
    GreenfootSound music = new GreenfootSound("music.mp3");
    
    public Gato()
    {
        
    }
    /**
     * Act - do whatever the Gato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(iniciarConteo)
        {
            temporizador1++;
        }
        if(iniciarConteoGiro)
        {
            temporizadorGiro++;
        }
        musica();
        siTocaEnemigo();
        limitesDelMapa();
        controlesBasicos();
        siTocaEnemigoG();
    }
    /**
     * Añade los controles básicos al personaje.
     */
    public void controlesBasicos()
    {
          if(getWorld()==null){return;}
        controlFlechaArriba();
        controlFlechaAbajo();
        controlFlechaDerecha();
        controlFlechaIzquierda();
        controlGirar();
        controlDisparar();
    }
    public void controlFlechaIzquierda()
    {
        boolean teclaIzquierda= Greenfoot.isKeyDown("left");
        if(teclaIzquierda)
        {
            setLocation(getX()-velocidadControl,getY());
        }
    }
    public void controlFlechaDerecha()
    {
        boolean teclaDerecha= Greenfoot.isKeyDown("right");
        if(teclaDerecha)
        {
            setLocation(getX()+velocidadControl,getY());
        }
    }
    public void controlFlechaArriba()
    {
        boolean teclaArriba= Greenfoot.isKeyDown("up");
        if(teclaArriba)
        {
            setLocation(getX(),getY()-velocidadControl);
        }
    }
    public void controlFlechaAbajo()
    {
        boolean teclaAbajo= Greenfoot.isKeyDown("down");
        if(teclaAbajo)
        {
            setLocation(getX(),getY()+velocidadControl);
        }
    }
    public void controlGirar()
    {
        boolean teclaGirar= Greenfoot.isKeyDown("Space");
        if(teclaGirar)
        {
            iniciarConteoGiro=true;
            if(temporizadorGiro > 30)
            {
                turn(90);
                temporizadorGiro=0;
                iniciarConteoGiro=false;
            }
        }
    }
    public void controlDisparar()
    {
        boolean teclaX= Greenfoot.isKeyDown("x");
        if(teclaX)
        {
            disparar();
        }
    }
    /**
     * Añade el efecto de desaperecer esta entidad si es tocada.
     */
    public void siTocaEnemigo()
    {
          if(getWorld()==null){return;}
        Actor presa = getOneObjectAtOffset(0,0,Raton.class);
        if(presa!=null)
        {
            if(cVidas==0)
            {
                music.stop();
                getWorld().removeObject(this);
                World menu = new Menu();
                Greenfoot.setWorld(menu);
            }
            else
            {
                setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()),Greenfoot.getRandomNumber(getWorld().getHeight()));
                cVidas = cVidas -1;
            }
        }
        else
        {

        }
    }
 
        /**
     * Añade el efecto de desaperecer esta entidad si es tocada.
     */
    public void siTocaEnemigoG()
    {
          if(getWorld()==null){return;}
        Actor presa = getOneObjectAtOffset(0,0,RatonOmega.class);
        if(presa!=null)
        {
            if(cVidas==0)
            {
                music.stop();
                World world = getWorld();
                getWorld().removeObject(this);
                World menu = new Menu();
                Greenfoot.setWorld(menu);
            }
            else
            {
                setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()),Greenfoot.getRandomNumber(getWorld().getHeight()));
                cVidas = cVidas -1;
            }
        }
        else
        {

        }
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
     * Añade los disparos al personaje.
     */
    public void disparar()
    {
        iniciarConteo=true;
        if(temporizador1 > 20)
        {
            Proyectiles proyectil = new Proyectiles();
            getWorld().addObject(proyectil, getX(), getY());
            temporizador1=0;
            iniciarConteo=false;
        }
    }
    /**
     * Añade musica de fondo al juego.
     */
    public void musica()
    {
        if(iniciarMusica)
        {
            
            music.playLoop();
            music.setVolume(20);
            iniciarMusica=false;
        }
    }
    /**
     * Permite a otros objetos conocer la cantidad de vidas.
     */
    public int vidas()
    {
        return cVidas;
    }
    /**
     * Permite sumar una vida.
     */
    public void sumarUnaSolaVida()
    {
        cVidas++;
    }
}
