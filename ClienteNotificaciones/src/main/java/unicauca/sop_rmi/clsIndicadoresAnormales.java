package unicauca.sop_rmi;

import java.io.Serializable;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsIndicadoresAnormales implements Serializable
{
    private int atrNumeroHabitacion;
    private String atrNombreIndicador;
    private double atrValorIndicador;
    
    /**
     *
     * 
     * @param prmNumeroHabitacion
     * @param prmNombreIndicador
     * @param prmValorIndicador
     */
    public clsIndicadoresAnormales(int prmNumeroHabitacion, String prmNombreIndicador, double prmValorIndicador)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
        atrNombreIndicador = prmNombreIndicador;
        atrValorIndicador = prmValorIndicador;
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
    public String getNombreIndicador()
    {
        return atrNombreIndicador;
    }
    
    /**
     * 
     * @param prmNombreIndicador
     */
    public void setNombreIndicador(String prmNombreIndicador)
    {
        atrNombreIndicador = prmNombreIndicador;
    }
    
    /**
     * 
     * @return 
     */
    public double getValorIndicador()
    {
        return atrValorIndicador;
    }
    
    /**
     * 
     * @param prmValorIndicador
     */
    public void setValorIndicador(double prmValorIndicador)
    {
        atrValorIndicador = prmValorIndicador;
    }
}
