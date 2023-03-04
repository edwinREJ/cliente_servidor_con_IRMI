package unicauca.modelo;

/**
 *
 * @author David Marín, Edwin Espinosa y Sebastián Otaya
 */
public class clsFabricaServidor 
{
    public clsPlantillaServidor obtenerServidor(String prmServidor)
    {
        switch(prmServidor)
        {
            case "secuencial":
                return new clsServidorSecuencial();
            case "concurrente":
                return new clsServidorConcurrente();
            default:
                return new clsServidorConcurrente();
        }
    }
}
