
package co.edu.udea.monopoly.entidades.juego;

import java.util.ArrayList;

/**
 *
 * @author DANNA
 */
public class Dado {

    private final ArrayList<Integer> numeros;

    public Dado() {
        this.numeros = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            this.numeros.add(i);
        }
    }
    
    public int getNumero() {
        int numero;
        do {
            numero = (int) (Math.random() * this.numeros.size());
        } while (numero < 1 || numero > 6);
        return numero;
    }

}
