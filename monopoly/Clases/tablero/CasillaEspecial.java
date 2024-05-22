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
public abstract class CasillaEspecial extends Casilla {

    public static final String TipoCasillaEspecialInicio = "inicio";
    public static final String TipoCasillaEspecialCarcel = "carcel";
    public static final String TipoCasillaEspecialDelito = "delito";
    public static final String TipoCasillaEspecialEventualidad = "eventualidad";
    public static final String TipoCasillaEspecialImpuesto = "impuesto";
    public static final String TipoCasillaEspecialParadaLibre = "libre";
    public static final String TipoCasillaEspecialSueldo = "sueldo";

    private String tipoCasillaEspecial;

    public CasillaEspecial(int posicion, String nombre) {
        super(posicion, nombre);
        this.setTipoCasilla(Casilla.TipoCasillaEspecial);
    }

    
    public String getTipoCasillaEspecial() {
        return tipoCasillaEspecial;
    }

    public void setTipoCasillaEspecial(String tipoCasillaEspecial) {
        this.tipoCasillaEspecial = tipoCasillaEspecial;
    }

    public abstract void ejecutarAccion(Jugador jugador, Juego juego);
}
