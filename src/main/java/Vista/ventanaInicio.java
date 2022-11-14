
package Vista;

import com.mycompany.memoria.Memoria;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */
public class ventanaInicio extends JFrame{
    private JLabel jlTitulo;
    private JButton btnJugar;
    private JButton btnComojugar;
    private JButton btnParaquesirve;
    private JPanel jpContenido;
    
    public ventanaInicio(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuracion de ventana
        setTitle("MEMORIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,250);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        //Configuracion del encabezado
        jpContenido = new JPanel();
        add(jpContenido);
        
        
        jlTitulo = new JLabel("MEMORIA");
        jlTitulo.setBounds(200, 10, 100, 20);
        jlTitulo.setFont(new Font ("Perpetua Titling MT", Font.ROMAN_BASELINE, 15));
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(190,50,100,40);
        btnComojugar = new JButton("Como Jugar");
        btnComojugar.setBounds(60,100,125,40);
        btnParaquesirve = new JButton("Para que sirve");
        btnParaquesirve.setBounds(295,100,125,40);
        
        jpContenido.setSize(500,250);        
        jpContenido.setBounds(0,0, 500, 250);
        jpContenido.setLayout(null);
        
        jpContenido.add(jlTitulo);
        jpContenido.add(btnJugar);
        jpContenido.add(btnComojugar);
        jpContenido.add(btnParaquesirve);
        
        ActionListener jugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Memoria.ventanainicio.setVisible(false);
                Memoria.ventanajugador.setVisible(true);
            }
        };
        
        btnJugar.addActionListener(jugar);
                
    }
}
