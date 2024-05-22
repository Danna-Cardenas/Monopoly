/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.monopoly.entidades.tablero;

/**
 *
 * @author DANNA
 */
public class Casilla {

    public static final String TipoCasillaPropiedad = "propiedad";
    public static final String TipoCasillaEspecial = "especial";

    private final int posicion;
    private String tipoCasilla;
    private final String nombre;

    public Casilla(int posicion, String nombre) {
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

   
    public String getTipoCasilla() {
        return tipoCasilla;
    }

    public void setTipoCasilla(String tipoCasilla) {
        this.tipoCasilla = tipoCasilla;
    }

    public String getNombre() {
        return nombre;
    }
}
