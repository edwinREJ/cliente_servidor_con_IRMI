package unicauca.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsGestionAlertas extends UnicastRemoteObject implements IGestionAlertas
{
    private IControladorServidorNotificaciones objRemotoNotificaciones;
    private List<clsIndicadoresAnormales> atrListIndicadoresClinicosAnormales;
    private String atrDireccionIPServerSocket;
    private int atrPuertoServerSocket;
            
    public clsGestionAlertas(IControladorServidorNotificaciones prmObjRemotoNotificaciones, String prmDireccionIPServerSocket, int prmPuertoServerSocket) throws RemoteException
    {
        super();
        objRemotoNotificaciones = prmObjRemotoNotificaciones;
        atrDireccionIPServerSocket = prmDireccionIPServerSocket;
        atrPuertoServerSocket = prmPuertoServerSocket;
        
        atrListIndicadoresClinicosAnormales = new ArrayList<>();
    }
    
    /**
     *
     * @param prmObjIndicadorClinico
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean leerIndicadoresClinicos(clsIndicadorClinico prmObjIndicadorClinico) throws RemoteException 
    {
        boolean cmpBanderaLectura = false;
        boolean cmpIsLogIndicadores;
        
        atrListIndicadoresClinicosAnormales = detectarIndicadoresAnormales(prmObjIndicadorClinico);
        
        cmpIsLogIndicadores = isError(prmObjIndicadorClinico);
        
        if(cmpIsLogIndicadores)
        {
            System.out.println("- Log ENVIADO -");
            clsIndicadoresLogs objlogError = new clsIndicadoresLogs(prmObjIndicadorClinico.getNumeroHabitacion());
            
            clsConexionLogServer objConeccionLog = new clsConexionLogServer();
            
            objConeccionLog.serverConexion(atrDireccionIPServerSocket, atrPuertoServerSocket);
            objConeccionLog.peticionRespuesta(objlogError);
        }
        
        if(atrListIndicadoresClinicosAnormales.size() > 1)
        {
            cmpBanderaLectura = true;
            System.out.println(" -- ECO: Hay " + atrListIndicadoresClinicosAnormales.size() + " indicadores clínicos anormales -- ");
            clsNotificacion objNotificacion = new clsNotificacion(prmObjIndicadorClinico.getNumeroHabitacion(), atrListIndicadoresClinicosAnormales);
            objRemotoNotificaciones.enviarMensaje(objNotificacion);
        }
        else
        {
            cmpBanderaLectura = true;
            System.out.println("-- ECO: NO hay anomalías -- ");
        }
        return cmpBanderaLectura;
    }
    
    /**
     * 
     * @param prmObjIndicadorClinico
     * @return 
     */
    public ArrayList<clsIndicadoresAnormales> detectarIndicadoresAnormales(clsIndicadorClinico prmObjIndicadorClinico)
    {
        ArrayList<clsIndicadoresAnormales> cmpIndicadoresAnormales = new ArrayList<>();
        
        /*  Frecuencia cardiaca: Latidos por minuto entre 60 y 80 */
        if(prmObjIndicadorClinico.getFrecuenciaCardiaca() < 60.0 || prmObjIndicadorClinico.getFrecuenciaCardiaca() > 80.0)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Frecuencia caridiaca", prmObjIndicadorClinico.getFrecuenciaCardiaca());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
        
        /* Presión sistólica entre 110 y 140 */
        if(prmObjIndicadorClinico.getPresionSistolica() < 110.0 || prmObjIndicadorClinico.getPresionSistolica() > 140.0)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Presión sistólica", prmObjIndicadorClinico.getPresionSistolica());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
        
        /* Presión diastólica entre 70 y 90 */
        if(prmObjIndicadorClinico.getPresionDiastolica()  < 70.0 || prmObjIndicadorClinico.getPresionSistolica() > 90.0)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Presión diastólica", prmObjIndicadorClinico.getPresionDiastolica());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
        
        /*  Frecuencia respiratoria: ventilaciones por minuto entre 12 y 20 */
        if(prmObjIndicadorClinico.getFrecuenciaRespiratoria() < 12 || prmObjIndicadorClinico.getFrecuenciaRespiratoria() > 20)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Frecuencia respiratoria", prmObjIndicadorClinico.getFrecuenciaRespiratoria());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
        
        /* 36.2 grados centígrados y 37.2 grados centígrados */
        if(prmObjIndicadorClinico.getTemperatura() < 36.2 || prmObjIndicadorClinico.getTemperatura() > 37.2)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Temperatura", prmObjIndicadorClinico.getTemperatura());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
        
        /* Saturación de oxigeno: entre 95% y 100%. */
        if(prmObjIndicadorClinico.getSaturacionOxigeno() < 0.95 || prmObjIndicadorClinico.getSaturacionOxigeno() > 1.0)
        {
            clsIndicadoresAnormales objIndicadoresAnormales = new clsIndicadoresAnormales(prmObjIndicadorClinico.getNumeroHabitacion(), "Saturación Oxígeno", prmObjIndicadorClinico.getSaturacionOxigeno());
            cmpIndicadoresAnormales.add(objIndicadoresAnormales);
        }
       
        return cmpIndicadoresAnormales;
    }
    
    public boolean isError(clsIndicadorClinico prmObjIndicadorClinico)
    {
        boolean cmpIsError = false;
        
        if(prmObjIndicadorClinico.getFrecuenciaCardiaca() <= 0)
        {
            cmpIsError = true;
        }
        
        if(prmObjIndicadorClinico.getPresionSistolica() <= 0)
        {
            cmpIsError = true;
        }
        
        if(prmObjIndicadorClinico.getPresionDiastolica() <= 0)
        {
            cmpIsError = true;
        }
        
        if(prmObjIndicadorClinico.getFrecuenciaRespiratoria() <= 0)
        {
            cmpIsError = true;
        }
        
        if(prmObjIndicadorClinico.getTemperatura() <= 0)
        {
            cmpIsError = true;
        }
        
        if(prmObjIndicadorClinico.getSaturacionOxigeno() <= 0)
        {
            cmpIsError = true;
        }
        return cmpIsError;
    }
}
