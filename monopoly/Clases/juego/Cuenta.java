
package co.edu.udea.monopoly.entidades.juego;

import co.edu.udea.monopoly.entidades.tablero.CasillaPropiedad;
import java.util.ArrayList;

/**
 *
 * @author DANNA
 */
public class Cuenta {

    private int dinero;
    private final ArrayList<CasillaPropiedad> propiedades;

    public Cuenta() {
        this.propiedades = new ArrayList<>();
        this.dinero = 2000;
    }

    public boolean agregarPropiedad(CasillaPropiedad p) {
        try {
            propiedades.add(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borraPropiedad(CasillaPropiedad propiedad) {
        try {
            propiedades.remove(propiedad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public ArrayList<CasillaPropiedad> getPropiedades() {
        return propiedades;
    }

    public void agregarDinero(int dinero) {
        this.dinero += dinero;
    }

    public boolean restarDinero(int dinero) {
        this.dinero -= dinero;
        if (this.dinero < 0) {
            this.dinero += dinero;
            return false;
        }
        return true;
    }

}
