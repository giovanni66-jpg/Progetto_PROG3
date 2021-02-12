package monitoraggioAmb;
/**
 * Creazione della classe Context che invocherà la classe Strategy. Questa classe ha lo scopo di andar ad implementare/inizializzare la strategia da adottare, definita 
 * dall'interfaccia Strategy e dalle sue tre implementazioni.
 * 
 * 
 * @author Pierno Francesco Pio
 *
 */


public class Context {
	
	/**
	 * Dichiarazione della variabile privata Strategy.
	 */
	private Strategy strategy;
	
	/**
	 * Costruttore context che inizializzerà lo Strategy.
	 * @param strategy il costruttore prenderà in input l'interfaccia Strategy.
	 */
	
	public Context(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	/**
	 * Il metodo executeStrategy() avrà lo scopo di decidere quale strategia andar ad adottare.
	 * 
	 * 
	 * @return Strategy
	 */
	public String executeStrategy()
	{
		return this.strategy.getCode("Codice");
	}

}
