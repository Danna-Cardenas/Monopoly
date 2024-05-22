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
public class TarjetaCobrarConcursoBelleza extends TarjetaCobrar {

    @Override
    public void setTipoTarjeta(String tipoTarjeta) {
        super.setTipoTarjeta("arcaComun");
    }

    @Override
    public void setMensaje(String mensaje) {
        super.setMensaje("Gana concurso de belleza 2°Puesto reclama $10 ");

    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        int cobro = 10;
        //Se abonan 10 en dinero al jugador gana concurso de belleza
        jugador.getCuenta().agregarDinero(cobro);
        //Se restan 10 en dinero al banco
        juego.getBanco().restarDinero(cobro);

    }

    @Override
    public String getMensaje() {
        return super.getMensaje(); //To change body of generated methods, choose Tools | Templates.
    }
}
