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
public class TarjetaCobrarImpuestosPrestamos extends TarjetaCobrar{
    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun"); 
    }
    
    @Override
    public void setMensaje(String mensaje) {
       super.setMensaje("Cobrar impuestos a prestamos "); 
    
       }
    
     @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        //ojo aqui hay que cobrar prestamos
        int cobro=20;
        int dinero=jugador.getCuenta().getDinero();
        //Se abonan 20 en dinero al Reembolso de impuestos
        jugador.getCuenta().setDinero(dinero + cobro );
        //Se restan 20 en dinero al banco
        juego.getBanco().restarDinero(cobro);
    }
    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}

   
