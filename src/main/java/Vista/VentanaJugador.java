
package Vista;

import Usuario.Jugador;
import com.mycompany.memoria.Memoria;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeanp
 */
public class VentanaJugador extends JFrame{
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIniciar;
    private JButton btnAtras;
    private JPanel jpContenido;
    
    public VentanaJugador(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuracion de ventana
        setTitle("MEMORIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Configuracion del contenido
        jpContenido = new JPanel();
        add(jpContenido);
        
        jlNombre = new JLabel("Escriba tu nombre");
        jlNombre.setBounds(175,70,170,50);
        jlNombre.setFont(new Font("Perpetua Titling MT", Font.ROMAN_BASELINE, 15));
        
        txtNombre = new JTextField("");
        txtNombre.setBounds(148,150,200,30);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20));
        
        
        btnIniciar = new JButton("INICIAR");
        btnIniciar.setBounds(175,200,150,40);
        btnIniciar.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnIniciar.setFocusable(false);
        btnIniciar.setFont(new Font ("Agency FB",Font.BOLD,25));
        
        btnAtras = new JButton ("ATRAS");
        btnAtras.setBounds(200,250,100,40);
        btnAtras.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnAtras.setFocusable(false);
        btnAtras.setFont(new Font ("Agency FB",Font.BOLD,25));
        
        jpContenido.setSize(500,400);
        jpContenido.setBounds(0,0,500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(jlNombre);
        jpContenido.add(txtNombre);
        jpContenido.add(btnIniciar);
        jpContenido.add(btnAtras);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnIniciar.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
  
        ActionListener regresar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Memoria.ventanainicio.setVisible(true);
            }
        };
        
        btnAtras.addActionListener(regresar);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
    }
    
    void siguienteVentana(){
        String nombre = txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){      
            
            this.setVisible(false);
            Memoria.ventanajuegomemoria.setVisible(true);
            Memoria.ventanajuegomemoria.getJuegoMemoria().setJugador(nombre);
            Memoria.ventanajuegomemoria.updateNombreJugador();
            
            System.out.println(Memoria.ventanajuegomemoria.getJuegoMemoria().getJugador());
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnIniciar){                
                siguienteVentana();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyCode() == e.VK_ENTER){
                btnIniciar.doClick();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }       
    }
     
    private void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }  
    
}
