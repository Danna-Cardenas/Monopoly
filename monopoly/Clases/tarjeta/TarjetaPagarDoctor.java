
package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaPagarDoctor extends TarjetaPagar{
     @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Pagar Doctor $50"); 
       
    }
    
     @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro=50;
        int dinero=jugador.getCuenta().getDinero();
        //Se restan 50 en dinero al jugador 
        jugador.getCuenta().setDinero(dinero - cobro );
        //Se abonan 50 en dinero al banco
        juego.getBanco().agregarDinero(cobro);
        
    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }
}
