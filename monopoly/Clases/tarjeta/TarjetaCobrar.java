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
public abstract class TarjetaCobrar extends Tarjeta{
    
    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta(tipoTarjeta); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje(mensaje); //To change body of generated methods, choose Tools | Templates.
    
       }
    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
                  
        }

    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}
   