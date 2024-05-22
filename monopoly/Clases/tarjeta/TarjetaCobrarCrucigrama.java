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
public class TarjetaCobrarCrucigrama extends TarjetaCobrar {

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("casualidades");
    }

    @Override
    public void setMensaje(String mensaje) {
        super.setMensaje("Gano concurso crucigramas Recibe 100");

    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro = 100;
        //Se abonan 25 en dinero al jugador Recibe $ 100 Concurso Crucigramas 
        jugador.getCuenta().agregarDinero(cobro);
        //Se restan 100 en dinero al banco
        juego.getBanco().restarDinero(cobro);

    }
    
    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}
