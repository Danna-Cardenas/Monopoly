

package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaCarcelSalirCarcel extends TarjetaCarcel{

   @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
   @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Sale de la carcel, si no esta en la carcel puede conservar comodin"); //To change body of generated methods, choose Tools | Templates.
    
       }
    
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        jugador.setEstado(Jugador.EstadoLibre);
//        jugador.getFicha().setPosicion(this.getPosicion());
    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
