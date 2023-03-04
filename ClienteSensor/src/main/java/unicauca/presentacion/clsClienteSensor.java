package unicauca.presentacion;

import unicauca.sop_rmi.IGestionAlertas;
import unicauca.sop_rmi.clsIndicadorClinico;
import unicauca.utilidades.UtilidadesConsola;
import unicauca.utilidades.UtilidadesRegistroC;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya(EE.UU)
 */
public class clsClienteSensor 
{
    private static IGestionAlertas objRemotoAlertas;
    
    public static void main(String[] args) 
    {
        /* Datos de conexión para Servidor de Alertas */
        int varPuertoRMIRegistry = 0;
        String varDireccionIPRMIRegistry = "";
        
        System.out.println("Ingrese la dirección IP donde se encuentra el RMIregistry del Servidor de Alertas:");
        varDireccionIPRMIRegistry = UtilidadesConsola.leerCadena();
        
        System.out.println("Ingrese el número de puerto por donde escucha el RMIregistry del Servidor de Alertas:");
        varPuertoRMIRegistry = UtilidadesConsola.leerEntero();
        
        objRemotoAlertas = (IGestionAlertas)UtilidadesRegistroC.obtenerObjRemoto(varDireccionIPRMIRegistry, varPuertoRMIRegistry, "ObjetoRemotoAlertas");
    
        leerIndicadoresClinicos();
    }
    
    private static void leerIndicadoresClinicos()
    {
        do {
            try {
                System.out.println("- Número de habitación: ");
                int varNumeroHabitacion = UtilidadesConsola.leerEntero();
                System.out.println("-- Lectura de indicadores clínicos --");
                System.out.println("- Frencuencia cardiaca:");
                double varFrecuenciaCardiaca = UtilidadesConsola.leerDouble();
                System.out.println("- Presión sistólica:");
                double varPresionSistolica = UtilidadesConsola.leerDouble();
                System.out.println("- Presión diastólica:");
                double varPresionDiastolica = UtilidadesConsola.leerDouble();
                System.out.println("- Frecuencia respiratoria:");
                double varFrencuenciaRespiratoria = UtilidadesConsola.leerDouble();
                System.out.println("- Temperatura:");
                double varTemperatura = UtilidadesConsola.leerDouble();
                System.out.println("- Saturación de oxígeno:");
                double varSaturacionOxigeno = UtilidadesConsola.leerDouble();

                clsIndicadorClinico objIndicadorClinico = new clsIndicadorClinico(varNumeroHabitacion, varFrecuenciaCardiaca, varPresionSistolica, varPresionDiastolica, varFrencuenciaRespiratoria, varTemperatura, varSaturacionOxigeno);

                boolean varIsLectura = objRemotoAlertas.leerIndicadoresClinicos(objIndicadorClinico);

                if (varIsLectura) {
                    System.out.println("-- Lectura de indicadores exitosa --");
                } else {
                    System.out.println("-- No se pudo realizar la lectura de los indicadores --");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }while(true);
    }
}
