

package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Banco;
import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;
import co.edu.udea.monopoly.entidades.tablero.CasillaEspecialInicio;

/**
 *
 * @author DANNA
 */
public class TarjetaIrCasillaCobrarInicio extends TarjetaIrCasillaCobrar{
    
    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Ir a Inicio Cobrar $ 200"); 
    }
        
       
    public void ejecutarAccion(Jugador jugador, Juego juego, Banco banco) {
        int cobro=200;
        int dinero=jugador.getCuenta().getDinero();
        //Se abonan 200 en dinero al ir al inicio
        jugador.getCuenta().setDinero(dinero + cobro );
        //Se restan 25 en dinero al banco
        banco.restarDinero(cobro);
//        jugador.getFicha().setPosicion(CasillaEspecialInicio.TIPO_CASILLA_ESPECIAL_INICIO.);
    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); 
    }
}
