package unicauca.utilidades;

import com.google.gson.Gson;
import unicauca.sop_rmi.clsIndicadoresLogs;

/**
 *
 * @author USUARIO
 */
public class clsGestionGSON 
{
    public static clsIndicadoresLogs jsonToObject(String prmJson)
    {
        Gson objGson = new Gson();
        
        clsIndicadoresLogs objIndicadorLogResponse;
        
        objIndicadorLogResponse = objGson.fromJson(prmJson, clsIndicadoresLogs.class);
        
        return objIndicadorLogResponse;
    }
}
