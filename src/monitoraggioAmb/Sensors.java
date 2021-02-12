package monitoraggioAmb;

/**
 * Creazione classe Sensors. Questa classe andrà ad implementare il metodo dichiarato in precedenza nell'interfaccia Observer, stampando
 * le informazioni conservate.
 * 
 * @author Pierno Francesco Pio
 *
 */

public class Sensors implements Observer{
	
	
	/**
	 * Implementazione del metodo update. Metodo che conserva i dati salvati nell'observer.
	 */
	@Override
	public void update(Message message)
	{
		
		System.out.println("IDSensore: " + message.getId());
		System.out.println("Misura temperatura: " + message.getTemperature());
		System.out.println("Misura inquinamento: " + message.getPollution());
		System.out.println("Misura traffico: " + message.getTraffic());
		System.out.println("Strada: " + message.getStreet());
	}

}
