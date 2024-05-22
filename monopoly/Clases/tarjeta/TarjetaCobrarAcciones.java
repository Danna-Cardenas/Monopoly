
package co.edu.udea.monopoly.entidades.tarjeta;
import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaCobrarAcciones extends TarjetaCobrar {

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun");
    }

    @Override
    public void setMensaje(String mensaje) {
        super.setMensaje("Cobrar venta Acciones $50 "); 
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int acciones = 50;
        //Se abonan 50 en dinero al jugador por la venta de acciones
        jugador.getCuenta().agregarDinero(acciones);
        //Se restan 50 en dinero al banco
        juego.getBanco().restarDinero(acciones);

    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}
