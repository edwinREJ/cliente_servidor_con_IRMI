package unicauca.utilidades;

import com.google.gson.Gson;
import unicauca.sop_rmi.clsIndicadoresLogs;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsConversorGSON 
{
    public static String objectToJson(clsIndicadoresLogs prmObjIndicadores)
    {
        Gson objGson = new Gson();
        
        String cmpResponse;
        
        cmpResponse = objGson.toJson(prmObjIndicadores);
        
        return cmpResponse;
    }
}
