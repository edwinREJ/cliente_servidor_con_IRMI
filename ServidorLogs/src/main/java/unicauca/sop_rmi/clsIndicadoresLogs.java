package unicauca.sop_rmi;

import java.io.Serializable;
//import java.time.LocalDate;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsIndicadoresLogs implements Serializable
{
    private int atrNumeroHabitacion;
    //private LocalDate atrFechaLog;

    public clsIndicadoresLogs() 
    {}
  
    
    /**
     * 
     * @param prmNumeroHabitacion
     */
    public clsIndicadoresLogs(int prmNumeroHabitacion)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
        //atrFechaLog = LocalDate.now();
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
     * @param prmNumeroHabiracion
     */
    public void setNumeroHabitacion(int prmNumeroHabiracion)
    {
        atrNumeroHabitacion = prmNumeroHabiracion;
    }
    
    /**
     * 
     * @return 
     */
    /*public LocalDate getFechaLog()
    {
        return atrFechaLog;
    }*/
    
    /**
     * 
     * @param prmFechaLog
     */
    /*public void setFechaLog(LocalDate prmFechaLog)
    {
        atrFechaLog = prmFechaLog;
    }*/
}
