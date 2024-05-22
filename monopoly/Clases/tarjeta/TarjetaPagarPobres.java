
package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaPagarPobres extends TarjetaPagar{
   @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("casualidades"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Pagar Impuesto para ayudar a los pobres $ 15"); 
       
    }
    
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro=15;
        int dinero=jugador.getCuenta().getDinero();
        //Se restan 15 en dinero al jugador 
        jugador.getCuenta().setDinero(dinero - cobro );
        //Se suman 15 en dinero al banco
        juego.getBanco().agregarDinero(cobro);
        
    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }
}