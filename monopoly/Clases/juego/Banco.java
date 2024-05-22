
package co.edu.udea.monopoly.entidades.juego;

import co.edu.udea.monopoly.entidades.tablero.CasillaPropiedad;
import co.edu.udea.monopoly.entidades.tablero.Mejora;
import java.util.ArrayList;

/**
 *
 * @author DANNA
 */
public class Banco {

    private int dinero;
    private final ArrayList<CasillaPropiedad> propiedades;
    private final ArrayList<Mejora> mejoras;
    

    public Banco(ArrayList propiedades) {
        this.mejoras = new ArrayList<>();
        this.propiedades = propiedades;
        this.dinero = 50000000; //cincuenta millones
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

    public ArrayList<Mejora> getMejoras() {
        return mejoras;
    }

    public boolean agregarMejora(String tipoMejora) {
        try {
            mejoras.add(new Mejora(tipoMejora));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarMejora(String tipoMejora) {
        for (Mejora m : mejoras) {
            if (m.getTipoMejora().equals(tipoMejora)) {
                mejoras.remove(m);
                return true;
            }
        }
        return false;
    }

    public boolean agregarPropiedad(CasillaPropiedad propiedad) {
        try {
            propiedades.add(propiedad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarPorpiedad(CasillaPropiedad propiedad) {
        try {
            propiedades.remove(propiedad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void agregarDinero(int dinero) {
        this.dinero += dinero;
    }

    public void restarDinero(int dinero) {
        this.dinero -= dinero;
        if (this.dinero <= 0) {
            this.dinero = 1000000;
        }
    }
}
