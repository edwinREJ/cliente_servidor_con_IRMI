package unicauca.sop_rmi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsNotificacion implements Serializable
{
    private int atrNumeroHabitacion;
    private List<clsIndicadoresAnormales> atrListIndicadoresAnormales;
    
    /**
     * 
     * @param prmNumeroHabitacion
     * @param prmListIndicadoresAnormales
     */
    public clsNotificacion(int prmNumeroHabitacion, List<clsIndicadoresAnormales> prmListIndicadoresAnormales)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
        atrListIndicadoresAnormales = new ArrayList<>();
        atrListIndicadoresAnormales = prmListIndicadoresAnormales;
    }
    
    /**
     * 
     * @return 
     */
    public int getNumeroHabitacion()
    {
        return atrNumeroHabitacion;
    }
 
    /**
     * 
     * @param prmNumeroHabitacion
     */
    public void setNumeroHabitacion(int prmNumeroHabitacion)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
    }
    
    /**
     * 
     * @return 
     */
    public List<clsIndicadoresAnormales> getIndicadoresAnormales()
    {
        return atrListIndicadoresAnormales;
    }
    
    /**
     * 
     * @param prmListIndicadoresAnormales
     */
    public void serIndicadoresAnormales(List<clsIndicadoresAnormales> prmListIndicadoresAnormales)
    {
        atrListIndicadoresAnormales = prmListIndicadoresAnormales;
    }
}