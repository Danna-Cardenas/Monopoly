
package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;
import co.edu.udea.monopoly.entidades.tablero.CasillaEspecialCarcel;

/**
 *
 * @author DANNA
 */
public abstract class TarjetaCarcel extends Tarjeta{
 
   

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("casualidades"); 
    }

       @Override
       public void setMensaje(String mensaje) {
       super.setMensaje("Ir a la Carcel sin posibilidad de Fianza "); //To change body of generated methods, choose Tools | Templates.
    
       }
       
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        
        jugador.setEstado(Jugador.EstadoEncarcelado);
        //Ajustar posicion de ficha
//      jugador.getFicha().setPosicion(CasillaEspecialCarcel.getPosicion());
        
    }
    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }

}