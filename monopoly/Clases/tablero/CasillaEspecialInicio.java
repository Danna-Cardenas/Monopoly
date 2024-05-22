/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.monopoly.entidades.tablero;

import co.edu.udea.monopoly.entidades.juego.Juego;
import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public class CasillaEspecialInicio extends CasillaEspecial {
    
    private static final int Regalo = 200;

    public CasillaEspecialInicio(int posicion, String nombre) {
        super(posicion, nombre);
        this.setTipoCasillaEspecial(CasillaEspecial.TipoCasillaEspecialInicio);
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        jugador.getCuenta().agregarDinero(CasillaEspecialInicio.Regalo);
        juego.getBanco().restarDinero(CasillaEspecialInicio.Regalo);
    }

}
