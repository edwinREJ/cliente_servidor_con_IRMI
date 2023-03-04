package unicauca.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya
 */
public interface IClienteNotificacionesCallback extends Remote
{
    /**
     * 
     * @param prmObjNotificacion
     * @throws java.rmi.RemoteException
     */
    public void notificar(clsNotificacion prmObjNotificacion) throws RemoteException;
}
