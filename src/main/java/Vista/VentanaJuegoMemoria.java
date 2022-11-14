
package Vista;

import Usuario.Jugador;
import Logica.JuegoMemoria;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Logica.JuegoMemoria;
import com.mycompany.memoria.Memoria;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author jeanp
 */
public class VentanaJuegoMemoria extends JFrame{
    int [][] matriz = new int [4][5];
    
    private JLabel jlMatriz [][];
    private JLabel jlTiempo;
    private JLabel jlCronometro;
    private JLabel jlJugador;
    private JLabel jlNombreJugador;
    private JPanel jpContenido;
    private JuegoMemoria juegoMemoria;
    
    public VentanaJuegoMemoria(){
        juegoMemoria = new JuegoMemoria();
        iniciarComponentes();
        setVisible(false);
        setTitle("MEMORIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,500);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    protected void iniciarComponentes(){
        
        
        //Configuracion del contenido
        
        jpContenido = new JPanel();
        add(jpContenido);
        
        jlJugador = new JLabel("JUGADOR : ");
        jlJugador.setBounds(10, 2, 100, 20);
        jlJugador.setForeground(Color.BLACK);
        jlJugador.setFont(new Font ("arial", Font.BOLD, 13));
        
        String nombre = getJuegoMemoria().getJugador();
        
        nombre = nombre.substring(0,1).toUpperCase() +
                 nombre.substring(1).toLowerCase();
        jlNombreJugador = new JLabel(nombre);
        jlNombreJugador.setBounds(85,0, 100,25);
        jlNombreJugador.setForeground(Color.GRAY);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 18));
        
        jlTiempo = new JLabel("TIEMPO: ");
        jlTiempo.setBounds(600,2,100,40);
        jlTiempo.setFont(new Font ("arial", Font.BOLD, 13));
        
        
        
        
        jlMatriz = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 5; j++) {
                System.out.println(jlMatriz);
                jlMatriz[i][j] = new JLabel();
                jlMatriz[i][j].setSize(jlMatriz[i][j].getWidth(), jlMatriz[i][j].getHeight());
                jlMatriz[i][j].setBounds(150+(j*125),30+(i*156), 400, 400);
                jlMatriz[i][j].setIcon(new ImageIcon("src/main/java/Imagenes/figuras/" + matriz[i][j] + ".png"));
                //colocamos que la matriz se muestre en pantalla
                jlMatriz[i][j].setVisible(true);
                //aqui se añaden junto con la 0
                jpContenido.add(jlMatriz[i][j]);           
            } 
        }    
            
        
        jlCronometro = new JLabel();
        System.out.println(JuegoMemoria.cronometro);
        jlCronometro.setBounds(660,2,100,40);
        
        jpContenido.setSize(750,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        
        
        jpContenido.add(jlJugador);
        jpContenido.add(jlNombreJugador);
        jpContenido.add(jlTiempo);
        jpContenido.add(jlCronometro);
        
    }
    
    public void updateNombreJugador()
    {
        this.jlNombreJugador.setText(this.juegoMemoria.getJugador());
    }
    
    public void actualizarTiempo(final String crono)
    {
        this.jlCronometro.setText(crono);
    }
    
    public JuegoMemoria getJuegoMemoria(){
        return juegoMemoria;
    }
}