package monitoraggioAmb;

/**
 * Interfaccia Subject. L'interfaccia Subject fornirà operazioni per
 * l'aggiunta, cancellazione, ed operazione di notifica agli Observer.
 * @author Asus
 *
 */

public interface Subject
{
	/**
	 * Metodo attach(Observer o) per l'aggiunta degli Observer.
	 * @param o input Observer
	 */
	public void attach(Observer o);
	
	/**
	 * Metodo detach(Observer o) per l'eliminazione degli Observer.
	 * @param o input Observer
	 */
	
	public void detach(Observer o);
	/**
	 * Metodo notifyObservers(message data) per la notifica agli Observer.
	 * @param data prenderà in input l'informazione, in questo caso la classe Message.
	 */
	public void notifyObservers(Message data);
}