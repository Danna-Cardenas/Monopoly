/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.monopoly.entidades.tablero;

import co.edu.udea.monopoly.entidades.juego.Jugador;

/**
 *
 * @author DANNA
 */
public abstract class CasillaPropiedad extends Casilla {

    public static final String TipoCasillaPropiedadTerreno = "terreno";
    public static final String TipoCasillaPropiedadServicio = "servicio";

    public static final String Hipoteca = "hipotecada";
    public static final String Disponible = "disponible";
    public static final String Adquirida = "adquirida";

    private String estado;
    private int renta;
    private final int rentaBase;
    private String tipoCasillaPropiedad;
    private final int valor;
    private final int valorHipoteca;
    private Jugador propietario;

    public CasillaPropiedad(int posicion, String nombre, int rentaBase,
            int valor, int valorHipoteca) {
        super(posicion, nombre);
        this.setTipoCasilla(Casilla.TipoCasillaPropiedad);
        this.rentaBase = rentaBase;
        this.valor = valor;
        this.valorHipoteca = valorHipoteca;
        this.estado = CasillaPropiedad.Disponible;
        this.renta = this.rentaBase;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public int getRentaBase() {
        return rentaBase;
    }

    public String getTipoCasillaPropiedad() {
        return tipoCasillaPropiedad;
    }

    public int getValor() {
        return valor;
    }

    public int getValorHipoteca() {
        return valorHipoteca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract void calculaRenta();

    public void setTipoCasillaPropiedad(String tipoCasillaPropiedad) {
        this.tipoCasillaPropiedad = tipoCasillaPropiedad;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

}
