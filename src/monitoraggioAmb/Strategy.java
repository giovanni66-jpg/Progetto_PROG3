package monitoraggioAmb;
/**
 * 
 * Dichiarazione dell'interfaccia strategy(implementazione dello Strategy design pattern) che verrà implementata
 * da tre sottoclassi che definiranno le tre strategie da adottare.
 * 
 * @author Pierno Francesco Pio
 * 
 */


public interface Strategy {
	
	/**
	 * Dichiarazione del metodo con input la stringa "codice".
	 * @param code Passo una stringa "codice".
	 * @return String 
	 */
	
	public String getCode(String code);
	

}
