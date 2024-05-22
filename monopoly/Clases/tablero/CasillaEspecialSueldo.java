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
public class CasillaEspecialSueldo extends CasillaEspecial {

    private static final int Sueldo = 200;

    public CasillaEspecialSueldo(int posicion, String nombre) {
        super(posicion, nombre);
        this.setTipoCasillaEspecial(CasillaEspecial.TipoCasillaEspecialSueldo);
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        //se cobra un sueldo de 200 al pasar por la casilla 1
        jugador.getCuenta().agregarDinero(Sueldo);
        juego.getBanco().restarDinero(Sueldo);
    }

}
