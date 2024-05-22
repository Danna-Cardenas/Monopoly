/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.monopoly.entidades.tarjeta;
import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class TarjetaCobrarOpera extends TarjetaCobrar{
    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Noche de Opera Recibe $ 50 de cada jugador "); 
    
       }
    
     @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro = 50;
        //Recorrer o restar a cada jugador 10 
        for (Jugador j : juego.getJugadores()) {
            j.getCuenta().restarDinero(cobro);
            jugador.getCuenta().agregarDinero(cobro);   //se agregan 10 por cada jugador
    }
    }
    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}
