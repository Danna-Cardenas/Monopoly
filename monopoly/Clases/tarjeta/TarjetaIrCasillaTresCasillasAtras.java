

package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaIrCasillaTresCasillasAtras extends TarjetaIrCasilla{

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("casualidades"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Regresa 3 casillas atras"); 
       
    }
    
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int pos =jugador.getFicha().getPosicion();
        jugador.getFicha().setPosicion(pos - 3);
        }
    

    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }
    
}
