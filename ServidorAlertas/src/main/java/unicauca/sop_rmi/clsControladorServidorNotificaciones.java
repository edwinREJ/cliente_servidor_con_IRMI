
package unicauca.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsControladorServidorNotificaciones extends UnicastRemoteObject implements IControladorServidorNotificaciones
{

    private final List<IClienteNotificacionesCallback> atrClientesNotificaciones;
    
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public clsControladorServidorNotificaciones() throws RemoteException
    {
        super();
        atrClientesNotificaciones = new ArrayList<>();
    }
    
    /**
     * 
     * @param objClienteNotificaciones 
     * @return 
     * @throws java.rmi.RemoteException
     */
    
    @Override
    public synchronized boolean registrarReferenciaClienteNotificaciones(IClienteNotificacionesCallback objClienteNotificaciones) throws RemoteException 
    {
        System.out.println("-- INVOCANDO AL MÉTODO registrarReferenciaClienteNotificaciones(...) DESDE EL SERVUDOR ALERTAS --");
        boolean cmpBanderaRegistro = false;
        
        if(!atrClientesNotificaciones.contains(objClienteNotificaciones))
        {
            cmpBanderaRegistro = atrClientesNotificaciones.add(objClienteNotificaciones);
        }
        
        System.out.println("Bandera Registro: " + cmpBanderaRegistro);
        return cmpBanderaRegistro;
    }

    /**
     * @param prmObjNotificacion 
     * @throws java.rmi.RemoteException
     */
    @Override
    public void enviarMensaje(clsNotificacion prmObjNotificacion) throws RemoteException 
    {
        System.out.println("-- INVOCANDO AL MÉTODO enviarMensaje(...) DESDE EL SERVIDOR ALERTAS --");
        
        for(IClienteNotificacionesCallback varObjClienteNotificaciones:atrClientesNotificaciones)
        {
            varObjClienteNotificaciones.notificar(prmObjNotificacion);
        }
    }
    
}
