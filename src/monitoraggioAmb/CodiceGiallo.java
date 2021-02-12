package monitoraggioAmb;

/**
 * Seconda implementazione dell'interfaccia Strategy. Questa classe andrà a definire la seconda strategia da adottare se verificata una determinata
 * condizione.
 * 
 * @author Pierno Francesco Pio
 *
 */


public class CodiceGiallo implements Strategy{
	/*/
	 * @param n passo la stringa codice.
	 * @return String Mi restituirà il codice "Giallo".
	 */
	
	
	@Override
	public String getCode(String code)
	{
		return "Giallo";
	}
}
