
package co.edu.udea.monopoly.entidades.tablero;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author DANNA
 */
public class CasillaPropiedadTerreno extends CasillaPropiedad {

    public static final String ColorLightGreen = "Light Green";
    public static final String ColorViolet = "Violet";
    public static final String ColorOrange = "Orange";
    public static final String ColorRed = "Red";
    public static final String ColorYellow = "Yellow";
    public static final String ColorDarkGreen = "Dark Green";
    public static final String ColorDarkBlue = "Dark Blue";
    public static final String ColorPurple = "Purple";

    private final int costoCasa;
    private final int costoHotel;
    private final String color;
    private final ArrayList<Mejora> mejoras;

    public CasillaPropiedadTerreno(String nombre, int posicion,
            int valor, int rentaBase, int valorHipoteca,
            int costoCasa, int costoHotel, String color) {
        super(posicion, nombre, rentaBase, valor, valorHipoteca);
        this.setTipoCasillaPropiedad(CasillaPropiedad.TipoCasillaPropiedadTerreno);
        this.color = color;
        this.costoCasa = costoCasa;
        this.costoHotel = costoHotel;
        this.mejoras = new ArrayList<>();
    }

    public int getCostoCasa() {
        return costoCasa;
    }

    public int getCostoHotel() {
        return costoHotel;
    }

    public String getColor() {
        return color;
    }

    public Collection<Mejora> getMejoras() {
        return mejoras;
    }

    public void addMejora(Mejora mejora) {
        int contCasas;
        if (mejoras.isEmpty() == true && mejora.getTipoMejora().equals("hotel")) {
            System.out.println("Un hotel sin casa? traqueto o que?");
        } else if (mejoras.isEmpty() == true && mejora.getTipoMejora().equals("casa")) {
            mejoras.add(mejora);
        } else {
            contCasas = cuentaCasas();
            if (contCasas < 4 && mejora.getTipoMejora().equals("casa")) {
                mejoras.add(mejora);
            } else {
                System.out.print("No mas espacio para casas, se agrega un hotel");
                for (Mejora mejora1 : mejoras) {    //hacer un metodo para remover todas las casas de una.
                    if (mejora1.getTipoMejora().equals("casa")) {
                        mejoras.remove(mejora1);
                    }
                }
                mejoras.add(mejora);
            }
        }
    }

    public void removeMejora(String tipoMejora) {
        for (Mejora mejora : mejoras) {
            if (mejora.getTipoMejora().equals(tipoMejora)) {
                mejoras.remove(mejora);
                return;
            }
        }
    }

    @Override
    public void calculaRenta() {
        int renta = getRentaBase();
        if (mejoras.isEmpty() == true) {
            setRenta(renta);
        } else {
            for (Mejora mejora : mejoras) {
                switch (mejora.getTipoMejora()) {
                    case "casa":
                        renta += renta + costoCasa;
                        break;
                    case "hotel":
                        renta += renta + costoHotel;
                        break;
                }
            }
            setRenta(renta);
        }
    }

    public int cuentaCasas() {
        int contCasas = 0;
        for (Mejora mejora1 : mejoras) {
            if (mejora1.getTipoMejora().equals("casa")) {
                contCasas++;
            }
        }
        return contCasas;
    }

    public int cuentaHoteles() {
        int contHoteles = 0;
        for (Mejora mejora1 : mejoras) {
            if (mejora1.getTipoMejora().equals("hotel")) {
                contHoteles++;
            }
        }
        return contHoteles;
    }
}
