package unicauca.sop_rmi;

import java.io.Serializable;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsIndicadorClinico implements Serializable
{
    private int atrNumeroHabitacion;
    private double atrFrecuenciaCaridiaca;
    private double atrPresionSistolica;
    private double atrPresionDiastolica;
    private double atrFrecuenciaRespiratoria;
    private double atrTemperatura;
    private double atrSaturacionOxigeno;
    
    /**
     * 
     * @param prmNumeroHabitacion
     * @param prmFrecuenciaCaridiaca 
     * @param prmPresionSistolica
     * @param prmPresionDiastolica 
     * @param prmFrecuenciaRespiratoria 
     * @param prmTemperatura 
     * @param prmSaturacionOxigeno 
     */
    public clsIndicadorClinico(int prmNumeroHabitacion, double prmFrecuenciaCaridiaca, double prmPresionSistolica, double prmPresionDiastolica, double prmFrecuenciaRespiratoria, double prmTemperatura, double prmSaturacionOxigeno)
    {
        atrNumeroHabitacion = prmNumeroHabitacion;
        atrFrecuenciaCaridiaca = prmFrecuenciaCaridiaca;
        atrPresionSistolica = prmPresionSistolica;
        atrPresionDiastolica = prmPresionDiastolica;
        atrFrecuenciaRespiratoria = prmFrecuenciaRespiratoria;
        atrTemperatura = prmTemperatura;
        atrSaturacionOxigeno = prmSaturacionOxigeno;
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
        atrFrecuenciaCaridiaca = prmNumeroHabitacion;
    }
    
    /**
     * 
     */
    public double getFrecuenciaCardiaca()
    {
        return atrFrecuenciaCaridiaca;
    }
    
    /**
     * 
     */
    public void setFrecuenciaCardiaca(double prmFrecuenciCardiaca)
    {
        atrFrecuenciaCaridiaca = prmFrecuenciCardiaca;
    }
    
    /**
     * 
     */
    public double getPresionSistolica()
    {
        return atrPresionSistolica;
    }
    
    /**
     * 
     */
    public void setPresionSistolica(double prmPresionSistolica)
    {
        atrPresionSistolica = prmPresionSistolica;
    }
    
    /**
     * 
     */
    public double getPresionDiastolica()
    {
        return atrPresionDiastolica;
    }
    
    /**
     * 
     */
    public void setPresionDiastolica(double prmPresionDiastolica)
    {
        atrPresionDiastolica = prmPresionDiastolica;
    }
    
    /**
     * 
     */
    public double getFrecuenciaRespiratoria()
    {
        return atrFrecuenciaRespiratoria;
    }
    
    /**
     * 
     */
    public void setFrecuenciaRespiratoria(double prmFrecuenciaRespiratoria)
    {
        atrFrecuenciaRespiratoria = prmFrecuenciaRespiratoria;
    }
    
    /**
     * 
     */
    public double getTemperatura()
    {
        return atrTemperatura;
    }
    
    /**
     * 
     */
    public void setTemperatura(double prmTemperatura)
    {
        atrTemperatura = prmTemperatura;
    }
    
    /**
     * 
     */
    public double getSaturacionOxigeno() 
    {
        return atrSaturacionOxigeno;
    }
    
    /**
     * 
     */
    public void setSaturacionOxigeno(double prmSaturacionOxigeno)
    {
        atrSaturacionOxigeno = prmSaturacionOxigeno;
    }
}
