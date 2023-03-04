package unicauca.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public interface IGestionAlertas extends Remote
{
    /**
     * 
     * @param prmObjIndicadorClinico
     * @return 
     * @throws java.rmi.RemoteException
     */
    public boolean leerIndicadoresClinicos(clsIndicadorClinico prmObjIndicadorClinico) throws RemoteException;
}
