package unicauca.presentacion;

import unicauca.modelo.clsFabricaServidor;
import unicauca.modelo.clsPlantillaServidor;
import unicauca.utilidades.UtilidadesConsola;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsServidorLogs 
{
    public static void main(String[] args) 
    {
        try 
        {
            String varServidorTipo = "concurrente";
            int varPuertoEscucha = 0;
            
            System.out.println("Ingrese el puerto de escucha del servidor:");
            varPuertoEscucha = UtilidadesConsola.leerEntero();
            
            clsFabricaServidor objFabrica = new clsFabricaServidor();
            
            clsPlantillaServidor objServidor = objFabrica.obtenerServidor(varServidorTipo);
            
            objServidor.inicializarServidor(varPuertoEscucha);
            
            objServidor.ejecutarServidor();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
