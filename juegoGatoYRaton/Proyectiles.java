import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Proyectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proyectiles extends Actor
{
        private int tiempoDeVida=50;
    private boolean iniciar=false;
    
    /**
     * Act - do whatever the Proyectiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                tiempoDeVida--;
        if(tiempoDeVida < 0)
        {
            getWorld().removeObject(this);
            tiempoDeVida= 50;
        }
            limitesDelMapa();
            apuntar();
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
        int x = getX();
        int y = getY();
        //Si es el borde derecho
        if((x + (anchura/2)) > anchuraDelMapa)
        {
            getWorld().removeObject(this);
        }
        //Si es el borde izquierda
        if((x - (anchura/2)) < 0)
        {
            getWorld().removeObject(this);
            
        }
        //Si es el borde superior
        if((y + (altura/2)) > alturaDelMapa)
        {
            getWorld().removeObject(this);
        }
        //Si es el borde inferior
        if((y - (altura/2)) < 0)
        {
            getWorld().removeObject(this);
        }
    }
    /**
     * Añade el movimiento hacia donde apunte el gato.
     */
    public void apuntar()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      Gato gato = world.getGato();
      int apuntandoA= gato.getRotation();
      //Si apunta a la derecha
      if(apuntandoA==0)
      {
          int derecha = getX() + 5;
          turnTowards(getWorld().getWidth(),getY());
          setLocation(derecha, getY());
      }
      //Si apunta hacia abajo
      if(apuntandoA==90)
      {
          int abajo = getY() + 5;
          turnTowards(getX(),getWorld().getHeight());
          setLocation(getX(), abajo);
      }
      //Si apunta hacia la izquierda
      if(apuntandoA==180)
      {
          int izquierda = getX() - 5;
          turnTowards(0,getY());
          setLocation(izquierda, getY());
      }
      //Si apunta hacia arriba
      if(apuntandoA==270)
      {
          int arriba = getY() - 5;
          turnTowards(getX(),0);
          setLocation(getX(), arriba);
      }
      intersectar();
      intersectarOmega();
    }
    /**
     * Si el disparo intersecta, elimina al enemigo.
     */
    public void intersectar()
    {
        Actor enemigo = getOneObjectAtOffset(0,0,Raton.class);
      if (enemigo != null) {
          sumarPuntuacion();
          getWorld().removeObject(enemigo);
          getWorld().removeObject(this);
      }
    }
        /**
     * Si el disparo intersecta, baja vida al enemigo.
     */
    public void intersectarOmega()
    {
         if(getWorld()==null){return;}
        Actor enemigo = getOneObjectAtOffset(0,0,RatonOmega.class);
      if (enemigo != null) {
          restarVidaEnemigo();
          getWorld().removeObject(this);
      }
    }
    /**
     * Sumar 1 a la puntuacion total.
     */
    public void sumarPuntuacion()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      Puntuacion puntuacion = world.getPuntuacion();
      puntuacion.sumarUnPunto();
    }
    /**
     * Restar 1 a la vida del enemigo.
     */
    public void restarVidaEnemigo()
    {
        if(getWorld()==null){return;}
      MyWorld world = (MyWorld) getWorld();
      vidaTemporal vidatemp = world.obtenerVidaTemporal();
      vidatemp.restarUnPuntoVida();
    }
}
