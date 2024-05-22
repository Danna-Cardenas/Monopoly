
package co.edu.udea.monopoly.entidades.juego;

/**
 *
 * @author DANNA
 */
public class Ficha {

    private final String id;
    private int posicion;

    public Ficha(String id) {
        this.id = id;
        this.posicion = 0;
    }

    public String getId() {
        return id;
    }

    public int getPosicion() {
        return posicion;
    }

    
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    public void restarPosicion(int p) {
        setPosicion(posicion - p);
        if (getPosicion() < 1) {
            setPosicion(1);
        }
    }
    
     public void subirPosicion(int p) {
        int posicionActual = getPosicion();
        int proximaPosicion = posicionActual + p;
        if (proximaPosicion > 40) {
            setPosicion(proximaPosicion - 40);
        } else {
            setPosicion(proximaPosicion);
        }
    }

}
