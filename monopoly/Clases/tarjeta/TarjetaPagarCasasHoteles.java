
package co.edu.udea.monopoly.entidades.tarjeta;
import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaPagarCasasHoteles extends TarjetaPagar{
     @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Pagar Reparaciones $25 Casa $100 Hotel"); 
       
    }
    
     @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        //Recorrer propiedades y descontar 25 por casa y 100 por hotel
//        for (int i=1 to jugador.getCuenta().getPropiedades().size();){
//        if(jugador.getCuenta().getPropiedades().)
        int cobro=25;
        int dinero=jugador.getCuenta().getDinero();
        //Se abonan 25 en dinero al jugador 
        jugador.getCuenta().setDinero(dinero - cobro );
        //Se restan 100 en dinero al banco
       juego.getBanco().agregarDinero(cobro);
        }
    

    @Override
    public String getMensaje() {
        return super.getMensaje();
    }
}

