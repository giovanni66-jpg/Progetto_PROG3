package monitoraggioAmb;
/**
 * 
 * Creazione dell'interfaccia Observer. Specifica un'interfaccia per la notifica di eventi agli oggetti
 * @author Pierno Francesco Pio
 *
 */

public interface Observer {
	
	/**
	 * Dichiarazione del metodo update()
	 * @param data il metodo dell'interfaccia accetterà in input una variabile di tipo Message, che sarà la classe in cui si conserveranno
	 * le informazioni per gli observer.
	 */
	public void update(Message data);

}
