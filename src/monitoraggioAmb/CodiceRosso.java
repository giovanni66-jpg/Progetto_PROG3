package monitoraggioAmb;

/**
 * Terza implementazione dell'interfaccia Strategy. La classe ha lo scopo che se verificata l'ultima condizione 
 * mi restituirà il codice "Rosso".
 * 
 * @author Pierno Francesco Pio
 *
 */


public class CodiceRosso implements Strategy{
	
	/**
	 * @param n Passo la stringa "Codice".
	 * @return String 
	 * 
	 */
	
	@Override
	public String getCode(String n)
	{
		return "Rosso";
	}

}
