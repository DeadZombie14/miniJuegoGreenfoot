import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private variablesGlobales variables;
    private Gato gato;
    private Dificultad modoDeJuego;
    private Puntuacion puntuacion;
    private vidaTemporal vidaS;
    private int animacion=0,temporizador1=0, dificultad=0,dificultadExtra=0, vidas=0;
    private boolean jefePresente=false;
    private GreenfootImage imagen = new GreenfootImage("fondo.png");
    private GreenfootImage imagen2 = new GreenfootImage("fondo2.png");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(imagen);
        gato = new Gato();
        puntuacion = new Puntuacion();
        vidaS = new vidaTemporal();
        variables = new variablesGlobales();
        modoDeJuego = new Dificultad();
        addObject(gato, 115, 295);
        addObject(new Raton(), 515, 207);
        addObject(new vidas(), 44, 29);
        addObject(puntuacion, 503, 30);
        addObject(new Dificultad(), 475, 392);
    }
    
        public void act()
    {
        temporizador1++;
        obtenerVidas();
        
        seleccionarDificultad();
        
        if(temporizador1 > 60)
        {
            animaciones();
        }
        
        if (Greenfoot.getRandomNumber(1000) < dificultad + dificultadExtra) 
        {
            addObject(new Raton(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        
        if (Greenfoot.getRandomNumber(1000) < 2) 
        {
            addObject(new extralife(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        
        if (Greenfoot.getRandomNumber(1000) < 2) 
        {
            addObject(new extralife(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    /**
     * Suma 1 a la dificultad extra.
     */
    public void sumarDificultadExtra()
    {
        if(dificultadExtra < 50)
        dificultadExtra = dificultadExtra + 5;
    }
    /**
     * Regresa gato.
     */
    public Gato getGato()
    {
        return gato;
    }
        /**
     * Regresa puntuacion.
     */
    public Puntuacion getPuntuacion()
    {
        return puntuacion;
    }
    
    
    public void animaciones()
    {
        if(animacion==0)
        {
            setBackground(imagen);
            animacion++;
        }
        else
        {
            setBackground(imagen2);
            animacion=0;
        }
    }
    
    
    /**
     * Obtiene la clase variables globales.
     */
    public variablesGlobales obtenerVariables()
    {
      return variables;
    }
    
    
    public void obtenerVidas()
    {
        if(this==null){return;}
      Gato gato = this.getGato();
      vidas = gato.vidas();
    }
    
    public void seleccionarDificultad()
    {
        if((vidas > 5) &&(!jefePresente))
        {
            dificultad = 20 + (vidas*2);
        }
        if((vidas==5) &&(!jefePresente))
        {
            dificultad = 40;
        }
        if((vidas==4) &&(!jefePresente))
        {
            dificultad= 35;
        }
        if((vidas==3) &&(!jefePresente))
        {
            dificultad= 30;
        }
        if((vidas==2) &&(!jefePresente))
        {
            dificultad= 25;
        }
        if((vidas==1) &&(!jefePresente))
        {
            dificultad= 20;
        }
        if((vidas==0) &&(!jefePresente))
        {
            dificultad= 50;
        }
    }
    
    /**
     * Obtiene el raton omega.
     */
    public vidaTemporal obtenerVidaTemporal()
    {
      return vidaS;
    }
    
    /**
     * Cambia la aparicion de enemigos normales cuando hay un jefe presente.
     */
    public void jefeEnJuego()
    {
        jefePresente=true;
        dificultad= 1;
    }
    
    /**
     * Cambia la aparicion de enemigos normales cuando el jefe muere.
     */
    public void jefeMuerto()
    {
        jefePresente=false;
    }
    
    /**
     * Comprueba si hay un jefe en juego.
     */
    public boolean comprobarJefe()
    {
        return jefePresente;
    }
    /**
     * Obtiene la dificultad.
     */
    public int obtenerDificultadTotal()
    {
        int nivel = dificultad + dificultadExtra;
        if(dificultad <= 20)
        {
            return 1;
        }
        else
        {
            if((dificultad >20) && (dificultad <=30))
            {
            return 2;
            }
            else
            {
                    if((dificultad >30) && (dificultad <=40))
                    {
                return 3;
                }
                else
                {
                            if(dificultad >= 50)
                            {
                                return 4;
                            }
                            else
                            {
                                return 0;
                            }
                }
            }
        }
    }
}
