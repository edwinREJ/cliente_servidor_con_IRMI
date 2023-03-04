package unicauca.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import unicauca.sop_rmi.clsIndicadoresLogs;
import unicauca.utilidades.clsGestionGSON;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya
 */
public class clsGestionHilo extends Thread
{
    private Socket atrSocketCliente;
    
    public clsGestionHilo(Socket prmSocketCliente) 
    {
        atrSocketCliente = prmSocketCliente;
    }
    
    @Override
    public void run()
    {
        try 
        {
            System.out.println("- ID del Hilo Principal: " + Thread.currentThread().getId());
            System.out.println("- Atendiendo Hilo del Servidor de Alertas...");
            
            DataInputStream objFlujoEntrada;
            DataOutputStream objFlujoSalida;
            
            String cmpMessage;
            
            objFlujoEntrada = new DataInputStream(atrSocketCliente.getInputStream());
            objFlujoSalida = new DataOutputStream(atrSocketCliente.getOutputStream());
            
            cmpMessage = objFlujoEntrada.readUTF(); //Operación Bloqueante
            
            clsIndicadoresLogs objIndicadorLogs = new clsIndicadoresLogs();
            objIndicadorLogs = clsGestionGSON.jsonToObject(cmpMessage);
            
            System.out.println("Fecha excepción: " + LocalDateTime.now() + ". Habitación de la excepción: " + objIndicadorLogs.getNumeroHabitacion());
            
            atrSocketCliente.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
