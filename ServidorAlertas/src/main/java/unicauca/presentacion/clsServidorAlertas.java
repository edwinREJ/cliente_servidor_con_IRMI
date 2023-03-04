
package unicauca.presentacion;

import unicauca.sop_rmi.clsControladorServidorNotificaciones;
import unicauca.sop_rmi.clsGestionAlertas;
import unicauca.utilidades.UtilidadesConsola;
import unicauca.utilidades.UtilidadesRegistroS;
/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsServidorAlertas 
{

    public static void main(String[] args) 
    {
        /* Datos de conexión para Servidor de Alertas */
        int varPuertoRMIRegistry = 0;
        String varDireccionIPRMIRegistry = "";

        int varPuertoSocketServer = 0;
        String varDireccionIPSocketServer = "";
    
        System.out.println("Ingese la dirección IP donde está el Servidor Log desde el Servidor de Alertas:");
        varDireccionIPSocketServer = UtilidadesConsola.leerCadena();    
        System.out.println("Ingrese el puerto de escucha donde se encuentra el Servidor Log desde el Servidor de Alertas:");
        varPuertoSocketServer = UtilidadesConsola.leerEntero();
        System.out.println("Ingrese la dirección IP donde se encuentra el RMIregistry del Servidor de Alertas:");
        varDireccionIPRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el número de puerto por donde escucha el RMIregistry del Servidor de Alertas:");
        varPuertoRMIRegistry = UtilidadesConsola.leerEntero();
        try 
        {
            clsControladorServidorNotificaciones objRemotoNotificaciones = new clsControladorServidorNotificaciones();
           
            clsGestionAlertas objRemotoAlerta = new clsGestionAlertas(objRemotoNotificaciones, varDireccionIPSocketServer, varPuertoSocketServer);
            UtilidadesRegistroS.arrancarNS(varPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoAlerta, varDireccionIPRMIRegistry, varPuertoRMIRegistry, "ObjetoRemotoAlertas");
           
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoNotificaciones, varDireccionIPRMIRegistry, varPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
        } 
        catch (Exception e) 
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
