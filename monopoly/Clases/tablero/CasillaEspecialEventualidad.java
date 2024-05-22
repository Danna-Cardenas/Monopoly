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
public class CasillaEspecialEventualidad extends CasillaEspecial {

    public static final String TipoCasillaEspecialEventualidadArcaComun = "arca comun";
    public static final String TipoCasillaEspecialEventualidadCasualidad = "casualidad";

    private final String tipoCasillaEspecialEventualidad;

    public CasillaEspecialEventualidad(int posicion, String nombre, String tipoCasillaEspecialEventualidad) {
        super(posicion, nombre);
        this.setTipoCasillaEspecial(CasillaEspecial.TipoCasillaEspecialEventualidad);
        this.tipoCasillaEspecialEventualidad = tipoCasillaEspecialEventualidad;
    }

    public String getTipoCasillaEspecialEventualidad() {
        return tipoCasillaEspecialEventualidad;
    }

    @Override
    public void ejecutarAccion(Jugador jugador, Juego juego) {
        switch (tipoCasillaEspecialEventualidad) {
            case CasillaEspecialEventualidad.TipoCasillaEspecialEventualidadArcaComun:
                juego.getTarjetaArcaComun().ejecutarAccion(jugador, juego);
                break;
            case CasillaEspecialEventualidad.TipoCasillaEspecialEventualidadCasualidad:
                juego.getTarjetaCasualidad().ejecutarAccion(jugador, juego);
                break;
        }
    }
}
