package monitoraggioAmb;

/**
 * Prima implementazione dell'interfaccia Strategy. La classe ha lo scopo che se verificata una determinata condizione mi restituirà
 * il codice "Verde".
 * 
 * @author Pierno Francesco Pio
 */

public class CodiceVerde implements Strategy{
	
	/**
	 * @param n Passo la stringa "Codice".
	 * @return String il metodo dovrà ritornare una stringa "Verde".
	 */
	@Override
	public String getCode(String n)
	{
		return "Verde";
	}

}
