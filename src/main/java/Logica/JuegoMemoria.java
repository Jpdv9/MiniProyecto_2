
package Logica;

import Usuario.Jugador;
import com.mycompany.memoria.Memoria;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;


/**
 *
 * @author jeanp
 */
public final class JuegoMemoria {
    int [][] matriz;
    Random aleatorio;
    int segundos = 0;
    int minutos = 0;
    public static String cronometro = "";
    private Jugador jugador;
    
    
    
    public JuegoMemoria(){
        this.jugador = new Jugador();
        this.delaySegundo();
    }
   
    public String getJugador(){
        return jugador.getNombre();
        
    }
    
    public void setJugador(String nombre){
        this.jugador.setNombre(nombre);
    }
    
    
    public void tiempo(){
        segundos++;
                if(segundos == 60){
                    
                    minutos++;
                    segundos = 0;
                }
        cronometro = minutos + ":" + segundos;
        System.out.println(cronometro);
        Memoria.ventanajuegomemoria.actualizarTiempo(cronometro);
        
    }
    
    
   
    private void delaySegundo(){
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask() {
            public void run()
            {
               try{
                    for(int i = 0; i <= 3600; i++){
                        tiempo();
                        Thread.sleep(1000);
                    }
                }catch(Exception e){
                    
                }
                
            }
        };  
       timer.schedule( task, 1000 );
    }
    
}
