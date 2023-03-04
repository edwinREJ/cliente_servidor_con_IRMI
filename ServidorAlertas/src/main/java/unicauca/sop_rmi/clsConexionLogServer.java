package unicauca.sop_rmi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import unicauca.utilidades.clsConversorGSON;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya
 */
public class clsConexionLogServer 
{
    private String atrDireccionIP;
    private int atrPuertoServidor;
    private DataInputStream objFlujoEntrada;
    private DataOutputStream objFlujoSalida;
    private Socket objSocket;
    
    /**
     * 
     * @param prmDireccionIP
     * @param prmPueroServidor
     */
    public void serverConexion(String prmDireccionIP, int prmPueroServidor)
    {
        try 
        {
            setDireccionIP(prmDireccionIP);
            setPuertoServidor(prmPueroServidor);
            setSocket(new Socket(prmDireccionIP, prmPueroServidor));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void peticionRespuesta(clsIndicadoresLogs prmObjIndicadoresLog)
    {
        try 
        {
            String Json = clsConversorGSON.objectToJson(prmObjIndicadoresLog);
            objFlujoSalida.writeUTF(Json);
            getSocket().close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public String getDireccionIP()
    {
        return atrDireccionIP;
    }
    
    public void setDireccionIP(String prmDireccionIP)
    {
        atrDireccionIP = prmDireccionIP;
    }
    
    public int getPuertoServidor()
    {
        return atrPuertoServidor;
    }
    
    public void setPuertoServidor(int prmPuertoServidor)
    {
        atrPuertoServidor = prmPuertoServidor;
    }
    
    public DataInputStream getFlujoEntrada()
    {
        return objFlujoEntrada;
    }
    
    public void setFlujoEntrada(DataInputStream prmFlujoEntrada)
    {
        objFlujoEntrada = prmFlujoEntrada;
    }
    
    public DataOutputStream getFlujoSalida()
    {
        return objFlujoSalida;
    }
    
    public void setFlujoSalida(DataOutputStream prmFlujoSalida)
    {
        objFlujoSalida = prmFlujoSalida;                
    }
    
    public Socket getSocket()
    {
        return objSocket;
    }
    
    public void setSocket(Socket prmSocket)
    {
        objSocket = prmSocket;
    }
}
