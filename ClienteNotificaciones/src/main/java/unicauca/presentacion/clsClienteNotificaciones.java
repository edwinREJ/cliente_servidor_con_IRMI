package unicauca.presentacion;

import unicauca.sop_rmi.clsClienteNotificacionesCallback;
import unicauca.utilidades.UtilidadesConsola;
import unicauca.utilidades.UtilidadesRegistroC;
import unicauca.sop_rmi.IControladorServidorNotificaciones;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsClienteNotificaciones 
{
    private static IControladorServidorNotificaciones objRemotoNotificaciones;
    public static void main(String[] args) 
    {
        /* Datos de conexión para Servidor de Alertas */
        int varPuertoRMIRegistry = 0;
        String varDireccionIPRMIRegistry = "";
        
        System.out.println("Ingrese la dirección IP donde se encuentra el RMIregistry del Cliente Notificaciones:");
        varDireccionIPRMIRegistry = UtilidadesConsola.leerCadena();
        
        System.out.println("Ingrese el número de puerto por donde escucha el RMIregistry del Cliente de Notificaciones:");
        varPuertoRMIRegistry = UtilidadesConsola.leerEntero();
            
        try 
        {
            objRemotoNotificaciones = (IControladorServidorNotificaciones)UtilidadesRegistroC.obtenerObjRemoto
            (varPuertoRMIRegistry, varDireccionIPRMIRegistry, "ObjetoRemotoNotificaciones");
            
            GUIClienteNotificaciones objGUIClienteNotificaciones = new GUIClienteNotificaciones();
            //objGUIClienteNotificaciones.setVisible(true);
            
            //Crear el objeto remoto.
            clsClienteNotificacionesCallback objClienteNotificacionesNuevo = new clsClienteNotificacionesCallback(objGUIClienteNotificaciones);
            
            //paso 7
            objRemotoNotificaciones.registrarReferenciaClienteNotificaciones(objClienteNotificacionesNuevo);
            
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
    }
}
