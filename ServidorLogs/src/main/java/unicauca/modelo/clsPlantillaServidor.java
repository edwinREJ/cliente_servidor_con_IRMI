package unicauca.modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya
 */
public abstract class clsPlantillaServidor 
{
    private int PUERTO;
    protected ServerSocket atrServidor;
    protected Socket atrSocket;
    
    public abstract void atenderPeticiones();
    
    public void ejecutarServidor()
    {
        atenderPeticiones();
    }
    
    public boolean inicializarServidor(int prmPuerto)
    {
        try 
        {
            PUERTO = prmPuerto;
            atrServidor = new ServerSocket(PUERTO);
            return true;
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
        return false;
    }
}
