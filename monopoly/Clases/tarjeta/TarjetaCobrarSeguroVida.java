

package co.edu.udea.monopoly.entidades.tarjeta;
import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaCobrarSeguroVida extends TarjetaCobrar{
  @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Cobra seguro de vida $ 100"); 
    
       }
    
     @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro=100;
        int dinero=jugador.getCuenta().getDinero();
        //Se abonan 100 en dinero al Reembolso de impuestos
        jugador.getCuenta().setDinero(dinero + cobro );
        //Se restan 100 en dinero al banco
       juego.getBanco().restarDinero(cobro);
    }
    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }
}

