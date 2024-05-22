

package co.edu.udea.monopoly.entidades.tarjeta;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;
import co.edu.udea.monopoly.entidades.tablero.Casilla;
import co.edu.udea.monopoly.entidades.tablero.CasillaPropiedadServicio;

/**
 *
 * @author DANNA
 */
public class TarjetaIrCasillaProximaUtilidad extends TarjetaIrCasilla{

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("casualidades"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Avanza al proximo ferrocarril o servicio publico y paga doble renta, Si no tiene dueño puedes comprar"); 
       
    }
    
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        
//        Recorre las casillas a partir de la posicion actual hasta encontrar la primera de servicios.
//        Si tiene dueño paga doble renta, si no tiene dueño puede comprarla
//        for(j  :juego.getTablero().getCasillas())
//            if(j.TIPO_CASILLA_PROPIEDAD.equalsIgnoreCase("servicio")){
//                juego.getTablero().getCasillaByPos(j).
//                
//            }
//        int renta =CasillaPropiedadServicio.
//        int pos =jugador.pagarRenta(null)
//        jugador.getFicha().setPosicion(pos - 3);
        }
    

    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
