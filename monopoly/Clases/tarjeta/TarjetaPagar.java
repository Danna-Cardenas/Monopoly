
package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public abstract class TarjetaPagar extends Tarjeta{
    
    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta(tipoTarjeta); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje(mensaje); 
    
       }
    
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
     
       }
    
    @Override
     public String getMensaje() {
       return super.getMensaje();
       
    }
}
