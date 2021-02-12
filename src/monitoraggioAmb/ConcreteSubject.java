package monitoraggioAmb;

import java.util.ArrayList;
import java.util.List;



/**
 * classe ConcreteSubject che implementerà i metodi dichiarati nell'interfaccia Subject.
 * 
 * @author Pierno Francesco Pio.
 *
 */

public class ConcreteSubject implements Subject{
	
/**
 * Dichirazioni variabili private.
 */
	
	private List<Observer> observers = new ArrayList<>();
	
	/**
	 * Implementazione per l'aggiunta degli Observers tramite il metodo della 
	 * libreria ArrayList add.
	 */
	@Override
	public void attach(Observer o)
	{
		this.observers.add(o);
	}
	/**
	 * Implementazione per l'eliminazione degli Observers tramite il metodo della 
	 * libreria ArrayList remove.
	 */
	
	@Override
	public void detach(Observer o)
	{
		this.observers.remove(o);
	}
	
	/**
	 * Implementazione del metodo di notifica per i vari Observers.
	 */
	
	@Override
	public void notifyObservers(Message data) {
		for(Observer o:observers)
			o.update(data); 
	}

}


