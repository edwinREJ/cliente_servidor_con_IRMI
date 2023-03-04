package unicauca.modelo;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsServidorConcurrente extends clsPlantillaServidor
{

    @Override
    public void atenderPeticiones() 
    {
        try 
        {
            while(true)
            {
                System.out.println("ID del Hilo Principal: " + Thread.currentThread().getId());
                atrSocket = atrServidor.accept();
                
                System.out.println("Servidor Alertas conectado...");
                
                new clsGestionHilo(atrSocket).start();
            }
        } 
        catch (Exception excep) 
        {
            excep.printStackTrace();
        }
    }
    
}
