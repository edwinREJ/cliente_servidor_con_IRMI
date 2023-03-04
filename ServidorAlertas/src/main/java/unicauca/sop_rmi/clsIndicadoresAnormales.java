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
     */
    public clsIndicadoresAnormales(int prmNumeroHabitacion, String prmNombreIndicador, double prmValorIndicador)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
        atrNombreIndicador = prmNombreIndicador;
        atrValorIndicador = prmValorIndicador;
    }
    
    /**
     * 
     */
    public int getNumeroHabitacion()
    {
        return atrNumeroHabitacion;
    }
    
    /**
     * 
     */
    public void setNumeroHabitacion(int prmNumeroHabitacion)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
    }
    
    /**
     * 
     */
    public String getNombreIndicador()
    {
        return atrNombreIndicador;
    }
    
    /**
     * 
     */
    public void setNombreIndicador(String prmNombreIndicador)
    {
        atrNombreIndicador = prmNombreIndicador;
    }
    
    /**
     * 
     */
    public double getValorIndicador()
    {
        return atrValorIndicador;
    }
    
    /**
     * 
     */
    public void setValorIndicador(double prmValorIndicador)
    {
        atrValorIndicador = prmValorIndicador;
    }
}
