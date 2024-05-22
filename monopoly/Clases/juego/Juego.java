
package co.edu.udea.monopoly.entidades.juego;

import co.edu.udea.monopoly.entidades.tablero.Casilla;
import co.edu.udea.monopoly.entidades.tablero.CasillaEspecial;
import co.edu.udea.monopoly.entidades.tablero.CasillaPropiedad;
import co.edu.udea.monopoly.entidades.tablero.Tablero;
import co.edu.udea.monopoly.entidades.tarjeta.Tarjeta;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCarcelIrCarcel;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCarcelSalirCarcel;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarAcciones;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarBanco;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarConcursoBelleza;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarConsultoria;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarCrucigrama;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarCumpleaños;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarErrorBanco;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarFestivo;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarHerencia;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarImpuestosPrestamos;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarOpera;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarReembolsoImpuesto;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaCobrarSeguroVida;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaIrCasillaCasillaPropiedad;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaIrCasillaCobrarInicio;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaIrCasillaProximaUtilidad;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaIrCasillaTresCasillasAtras;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarArreglosMejoras;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarCasasHoteles;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarDoctor;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarEscuela;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarHospital;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarJugadores;
import co.edu.udea.monopoly.entidades.tarjeta.TarjetaPagarPobres;
import co.edu.udea.monopoly.gui.Monopoly;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DANNA
 */
public class Juego {
    
    private final Tablero tablero;
    private final Banco banco;
    private final Monopoly monopoly;
    private final Dado dadoA;
    private final Dado dadoB;
    private final ArrayList<Tarjeta> tarjetasArcaComun;
    private final ArrayList<Tarjeta> tarjetasCasualidad;
    private final ArrayList<Jugador> jugadores;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.dadoA = new Dado();
        this.dadoB = new Dado();
        this.tablero = new Tablero();
        this.banco = new Banco(tablero.getCasillas());
        this.monopoly = new Monopoly();
        this.tarjetasArcaComun = new ArrayList<>();
        this.tarjetasCasualidad = new ArrayList<>();
        this.monopoly.getJButtonLanzar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getMonopoly().getJButtonLanzar().setEnabled(false);
                jugar();
                getMonopoly().getJButtonLanzar().setEnabled(true);
            }
        });
        this.monopoly.getJButtonRegistrar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = getMonopoly().getJTextFieldUsuario().getText();
                    if (nombre.length() > 1) {
                        registrarJugador(nombre);
                        getMonopoly().mostrarJugadoresEnTabla(getJugadores());
                        habilitarJuego();
                    } else {
                        JOptionPane.showMessageDialog(getMonopoly(), ":(");
                    }
                    getMonopoly().getJTextFieldUsuario().setText("");
                    getMonopoly().getJTextFieldUsuario().requestFocus();
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(getMonopoly(), "Ingrese un nombre válido.");
                }
            }
        });
        this.monopoly.getJButtonIniciar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getMonopoly().getJButtonIniciar().setEnabled(false);
                getMonopoly().getJButtonRegistrar().setEnabled(false);
                getMonopoly().getJTextFieldUsuario().setEnabled(false);
                getMonopoly().getJButtonLanzar().setEnabled(true);
            }
        });
    }

    public void siguienteJugador() {
        getJugadores().add(getJugadores().get(0));
        getJugadores().remove(0);
    }

    public int lanzarDados() {
        return dadoA.getNumero() + dadoB.getNumero();
    }

    public void registrarJugador(String nombre) {
        Ficha ficha = new Ficha("Ficha" + nombre);
        Jugador jugador = new Jugador(ficha, nombre);
        getJugadores().add(jugador);
    }

    public void habilitarJuego() {
        if (getJugadores().size() > 1) {
            getMonopoly().getJButtonIniciar().setEnabled(true);
        }
        if (getJugadores().size() > 7) {
            getMonopoly().getJButtonRegistrar().setEnabled(false);
        }
    }

    public Banco getBanco() {
        return banco;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Tarjeta getTarjetaArcaComun() {
        int tarjeta = (int) (Math.random() * tarjetasArcaComun.size() - 1);
        return tarjetasArcaComun.get(tarjeta);
    }

    public Tarjeta getTarjetaCasualidad() {
        int tarjeta = (int) (Math.random() * tarjetasCasualidad.size() - 1);
        return tarjetasCasualidad.get(tarjeta);
    }

    public void crearTarjetas() {

        //tarjetas para el arreglo de tarjetasArcaComun
        TarjetaIrCasillaCobrarInicio tarjetaIrCasillaCobrarInicio = new TarjetaIrCasillaCobrarInicio();
        TarjetaCobrarErrorBanco tarjetaCobrarErrorBanco = new TarjetaCobrarErrorBanco();
        TarjetaPagarDoctor tarjetaPagarDoctor = new TarjetaPagarDoctor();
        TarjetaCarcelSalirCarcel tarjetaCarcelSalirCarcel = new TarjetaCarcelSalirCarcel();
        TarjetaCarcelIrCarcel tarjetaCarcelIrCarcel = new TarjetaCarcelIrCarcel();
        TarjetaCobrarCumpleaños tarjetaCobrarCumpleaños = new TarjetaCobrarCumpleaños();
        TarjetaCobrarOpera tarjetaCobrarOpera = new TarjetaCobrarOpera();
        TarjetaCobrarReembolsoImpuesto tarjetaCobrarReembolsoImpuesto = new TarjetaCobrarReembolsoImpuesto();
        TarjetaCobrarSeguroVida tarjetaCobrarSeguroVida = new TarjetaCobrarSeguroVida();
        TarjetaPagarHospital tarjetaPagarHospital = new TarjetaPagarHospital();
        TarjetaPagarEscuela tarjetaPagarEscuela = new TarjetaPagarEscuela();
        TarjetaCobrarConsultoria tarjetaCobrarConsultoria = new TarjetaCobrarConsultoria();
        TarjetaPagarCasasHoteles tarjetaPagarCasasHoteles = new TarjetaPagarCasasHoteles();
        TarjetaCobrarConcursoBelleza tarjetaCobrarConcursoBelleza = new TarjetaCobrarConcursoBelleza();
        TarjetaCobrarHerencia tarjetaCobrarHerencia = new TarjetaCobrarHerencia();
        TarjetaCobrarAcciones tarjetaCobrarAcciones = new TarjetaCobrarAcciones();
        TarjetaCobrarFestivo tarjetaCobrarFestivo = new TarjetaCobrarFestivo();

        //agrega al arreglo tarjetasArcaComun todas las tarjetas
        tarjetasArcaComun.add(tarjetaIrCasillaCobrarInicio);
        tarjetasArcaComun.add(tarjetaCobrarErrorBanco);
        tarjetasArcaComun.add(tarjetaPagarDoctor);
        tarjetasArcaComun.add(tarjetaCarcelSalirCarcel);
        tarjetasArcaComun.add(tarjetaCarcelIrCarcel);
        tarjetasArcaComun.add(tarjetaCobrarCumpleaños);
        tarjetasArcaComun.add(tarjetaCobrarOpera);
        tarjetasArcaComun.add(tarjetaCobrarReembolsoImpuesto);
        tarjetasArcaComun.add(tarjetaCobrarSeguroVida);
        tarjetasArcaComun.add(tarjetaPagarHospital);
        tarjetasArcaComun.add(tarjetaPagarEscuela);
        tarjetasArcaComun.add(tarjetaCobrarConsultoria);
        tarjetasArcaComun.add(tarjetaPagarCasasHoteles);
        tarjetasArcaComun.add(tarjetaCobrarConcursoBelleza);
        tarjetasArcaComun.add(tarjetaCobrarHerencia);
        tarjetasArcaComun.add(tarjetaCobrarAcciones);
        tarjetasArcaComun.add(tarjetaCobrarFestivo);

        //tarjetas para el arreglo de Casualidad
        TarjetaIrCasillaCasillaPropiedad tarjetaIrIllinois = new TarjetaIrCasillaCasillaPropiedad();
        TarjetaIrCasillaCobrarInicio tarjetaIrCasillaCobrarInicio1 = new TarjetaIrCasillaCobrarInicio();
        TarjetaIrCasillaProximaUtilidad tarjetaIrCasillaProximaUtilidad = new TarjetaIrCasillaProximaUtilidad();
        TarjetaIrCasillaProximaUtilidad tarjetaIrProximoFerro = new TarjetaIrCasillaProximaUtilidad();
        TarjetaIrCasillaProximaUtilidad tarjetaIrProximoFerro1 = new TarjetaIrCasillaProximaUtilidad();
        TarjetaIrCasillaCasillaPropiedad tarjetaIrStCharles = new TarjetaIrCasillaCasillaPropiedad();
        TarjetaCobrarBanco tarjetaCobrarBanco = new TarjetaCobrarBanco();
        TarjetaCarcelSalirCarcel tarjetaCarcelSalirCarcel1 = new TarjetaCarcelSalirCarcel();
        TarjetaIrCasillaTresCasillasAtras tarjetaIrCasillaTresCasillasAtras = new TarjetaIrCasillaTresCasillasAtras();
        TarjetaCarcelIrCarcel tarjetaCarcelIrCarcel1 = new TarjetaCarcelIrCarcel();
        TarjetaPagarArreglosMejoras tarjetaPagarArreglosMejoras = new TarjetaPagarArreglosMejoras();
        TarjetaPagarPobres tarjetaPagarPobres = new TarjetaPagarPobres();
        TarjetaIrCasillaProximaUtilidad tarjetaIrCasillaReadingFerro = new TarjetaIrCasillaProximaUtilidad();
        TarjetaIrCasillaCasillaPropiedad TarjetaIrCasillaBoardWalk = new TarjetaIrCasillaCasillaPropiedad();
        TarjetaPagarJugadores tarjetaPagarJugadores = new TarjetaPagarJugadores();
        TarjetaCobrarImpuestosPrestamos tarjetaCobrarImpuestosPrestamos = new TarjetaCobrarImpuestosPrestamos();
        TarjetaCobrarCrucigrama tarjetaCobrarCrucigrama = new TarjetaCobrarCrucigrama();

        //agrega al arreglo tarjetasCasualidad todas las tarjetas
        tarjetasCasualidad.add(tarjetaIrIllinois);
        tarjetasCasualidad.add(tarjetaIrCasillaCobrarInicio1);
        tarjetasCasualidad.add(tarjetaIrCasillaProximaUtilidad);
        tarjetasCasualidad.add(tarjetaIrProximoFerro);
        tarjetasCasualidad.add(tarjetaIrProximoFerro1);
        tarjetasCasualidad.add(tarjetaIrStCharles);
        tarjetasCasualidad.add(tarjetaCobrarBanco);
        tarjetasCasualidad.add(tarjetaCarcelSalirCarcel1);
        tarjetasCasualidad.add(tarjetaIrCasillaTresCasillasAtras);
        tarjetasCasualidad.add(tarjetaCarcelIrCarcel1);
//        tarjetasCasualidad.add(tarjetaPagarArreglosMejoras);
        tarjetasCasualidad.add(tarjetaPagarPobres);
        tarjetasCasualidad.add(tarjetaIrCasillaReadingFerro);
        tarjetasCasualidad.add(TarjetaIrCasillaBoardWalk);
        tarjetasCasualidad.add(tarjetaPagarJugadores);
        tarjetasCasualidad.add(tarjetaCobrarImpuestosPrestamos);
        tarjetasCasualidad.add(tarjetaCobrarCrucigrama);
    }

    public void jugar() {
        Jugador jugador = getJugadores().get(0);
        int valorDados;
        valorDados = lanzarDados();
        jugador.getFicha().subirPosicion(valorDados);
        int pos = jugador.getFicha().getPosicion();
        Casilla casilla = tablero.getCasillaPosicion(pos);
        JOptionPane.showMessageDialog(getMonopoly(), "El jugador " + jugador.getNombre()
                + " sacó " + valorDados + "\nCayó en la posicion " + pos + "\n"
                + "" + casilla.getNombre());
        switch (casilla.getTipoCasilla()) {
            case Casilla.TipoCasillaPropiedad:
                CasillaPropiedad propiedad = (CasillaPropiedad) casilla;
                JOptionPane.showMessageDialog(getMonopoly(), "Propiedad "+ propiedad.getNombre().toString()+" Valor "+ propiedad.getValor());
                switch (propiedad.getEstado()) {
                    case CasillaPropiedad.Adquirida:
                        JOptionPane.showMessageDialog(getMonopoly(), "Adquirida");
                        if (!jugador.getCuenta().getPropiedades().contains(propiedad)) {
                            JOptionPane.showMessageDialog(getMonopoly(), "Paga renta");
                            if (propiedad.getPropietario().cobrarRenta(propiedad, jugador)) {
                                JOptionPane.showMessageDialog(getMonopoly(), jugador.getNombre() + "\n"
                                        + "paga " + propiedad.getRenta() + " \n" + propiedad.getPropietario().getNombre());
                            } else {
                                JOptionPane.showMessageDialog(getMonopoly(), "El jugador no puede pagar renta\n"
                                        + "queda endedudado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(getMonopoly(), "Es Propia, no paga renta.");
                        }
                        break;
                    case CasillaPropiedad.Disponible:
                        JOptionPane.showMessageDialog(getMonopoly(), "Disponible");
                        int opcion = JOptionPane.showConfirmDialog(getMonopoly(), "Quiere comprar esta propiedad?");
                        if (opcion == 0) {
                            jugador.comprarPropiedad(banco, propiedad);
                        }
                        break;

                    case CasillaPropiedad.Hipoteca:
                        JOptionPane.showMessageDialog(getMonopoly(), "Hipotecada.\n"
                                + "no se paga renta.");
                        break;
                }
                break;
            case Casilla.TipoCasillaEspecial:
                JOptionPane.showMessageDialog(getMonopoly(), "Especial");
                CasillaEspecial especial = (CasillaEspecial) casilla;
                switch (especial.getTipoCasillaEspecial()) {
                    case (CasillaEspecial.TipoCasillaEspecialEventualidad):
                        JOptionPane.showMessageDialog(getMonopoly(), "Escoge tarjeta");
                        break;
                    default:
                        JOptionPane.showMessageDialog(getMonopoly(), "Ejecuta accion ");
                        especial.ejecutarAccion(jugador, this);
                }
                break;
        }
        siguienteJugador();
        getMonopoly().mostrarJugadoresEnTabla(getJugadores());
    }

    
    
    public Monopoly getMonopoly() {
        return monopoly;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}
