
package co.edu.udea.monopoly.entidades.tablero;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class CasillaEspecialImpuesto extends CasillaEspecial {

    public static final int ImpuestoDeclaracion = 200;
    public static final int ImpuestoLujos = 75;

    public CasillaEspecialImpuesto(int posicion, String nombre) {
        super(posicion, nombre);
        this.setTipoCasillaEspecial(CasillaEspecial.TipoCasillaEspecialImpuesto);
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int dineroJugador = jugador.getCuenta().getDinero();
        switch (jugador.getFicha().getPosicion()) {
            case 5:
                //se pagan 200 al caer en la casilla de impuestos numero 5
                jugador.getCuenta().setDinero(dineroJugador - ImpuestoDeclaracion);
                juego.getBanco().agregarDinero(ImpuestoDeclaracion);
                break;
            case 39:
                //se pagan 75 al caer en la casilla de impuestos 39
                jugador.getCuenta().setDinero(dineroJugador - ImpuestoLujos);
                juego.getBanco().agregarDinero(ImpuestoLujos);
                break;
        }
    }
}
