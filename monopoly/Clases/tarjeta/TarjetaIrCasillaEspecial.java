
package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaIrCasillaEspecial extends TarjetaIrCasilla{

    

    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
