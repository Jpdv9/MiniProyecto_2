
package com.mycompany.memoria;

import Vista.VentanaJuegoMemoria;
import Vista.VentanaJugador;
import javax.swing.JFrame;
import Vista.ventanaInicio;


/**
 *
 * @author jeanp
 */
public class Memoria {   
    public static ventanaInicio ventanainicio;
    public static VentanaJugador ventanajugador;
    public static VentanaJuegoMemoria ventanajuegomemoria;

    public static void main(String[] args) {
       ventanainicio = new ventanaInicio();
       ventanajugador = new VentanaJugador();
       ventanajuegomemoria = new VentanaJuegoMemoria();
              
       ventanajugador.setVisible(false);
       ventanajuegomemoria.setVisible(false);
       ventanainicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
