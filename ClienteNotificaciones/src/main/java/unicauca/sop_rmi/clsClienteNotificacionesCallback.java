
package unicauca.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import unicauca.presentacion.GUIClienteNotificaciones;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsClienteNotificacionesCallback extends UnicastRemoteObject implements IClienteNotificacionesCallback
{

    GUIClienteNotificaciones objGUIClienteNotificaciones = new GUIClienteNotificaciones();
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public clsClienteNotificacionesCallback(GUIClienteNotificaciones prmObjGUIClienteNotificaciones) throws RemoteException
    {
        //paso 6 se asigna el puerto de manera implicita
        super();
        objGUIClienteNotificaciones = prmObjGUIClienteNotificaciones;
    }
    
    /**
     * @param prmObjNotificacion 
     * @throws java.rmi.RemoteException
     */
    @Override
    public void notificar(clsNotificacion prmObjNotificacion) throws RemoteException 
    {
        System.out.println("--- CALLBACK DESDE EL SERVIDOR ALERTAS ---");
        
        List<clsIndicadoresAnormales> cmpIndicadoresAnormales = prmObjNotificacion.getIndicadoresAnormales();
        
        objGUIClienteNotificaciones.mostrarAlertaNotificacion(prmObjNotificacion);
    }
    
}
