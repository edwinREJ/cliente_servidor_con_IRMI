package unicauca.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public interface IControladorServidorNotificaciones extends Remote
{
    /**
     * 
     * @param objClienteNotificaciones
     * @return 
     * @throws java.rmi.RemoteException
     */
    public boolean registrarReferenciaClienteNotificaciones(IClienteNotificacionesCallback objClienteNotificaciones)throws RemoteException;
    
    /**
     * 
     * @param prmObjNotificacion
     * @throws java.rmi.RemoteException
     */
    public void enviarMensaje(clsNotificacion prmObjNotificacion)throws RemoteException;
}
