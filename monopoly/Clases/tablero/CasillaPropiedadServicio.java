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
public abstract class CasillaPropiedadServicio extends CasillaPropiedad {

    public static final String TipoCasillaPropiedadServicioPublico = "publico";
    public static final String TIPO_CASILLA_PROPIEDAD_SERVICIO_FERROCARRIL = "ferrocarril";

    private String tipoCasillaPropiedadServicio;

    public CasillaPropiedadServicio(int posicion, String nombre, int rentaBase,
            int valor, int valorHipoteca) {
        super(posicion, nombre, rentaBase, valor, valorHipoteca);
        this.setTipoCasillaPropiedad(CasillaPropiedad.TipoCasillaPropiedadServicio);
    }

    public String getTipoCasillaPropiedadServicio() {
        return tipoCasillaPropiedadServicio;
    }

    public void setTipoCasillaPropiedadServicio(String tipoCasillaPropiedadServicio) {
        this.tipoCasillaPropiedadServicio = tipoCasillaPropiedadServicio;
    }

}
