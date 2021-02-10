package monitoraggioAmb;

/**
 * Creazione classe Message. La classe Message andrà a definire le informazioni che verranno raccolte nei vari Observer.
 * @author Asus
 *
 */

public class Message {
	
	/*
	 * Dichiarazioni delle variabili private.
	 */
	private String id;
	private double temperature;
	private int pollution;
	private int traffic;
	private String street;

	/**
	 * Costruttore Message. Il costruttore ha lo scopo di inizializzare le mie informazioni.
	 * @param id ID dell'observer
	 * @param temperature Parametro temperatura
	 * @param pollution Parametro inquinamento
	 * @param traffic Parametro traffico
	 * @param street Nome della strada in questione.
	 */
	public Message(String id, double temperature, int pollution, int traffic, String street)
	{
		this.id = id;
		this.temperature = temperature;
		this.pollution = pollution;
		this.traffic = traffic;
		this.street = street;
		
	}
	
	/**
	 * metodo getId() che restituisce l'ID.
	 * @return id
	 */
	public String getId(){
		
		return id;
	}
	/**
	 * metodo getTemperatura() che ritorna la temperatura inizializzata in precedenza.
	 * @return temperature.
	 */
	public double getTemperature() {
		
		return temperature;
	}
	/**
	 * metodo getPollution() che restituisce il valore dell'inquinamento dell'aria.
	 * @return pollution
	 */
	public int getPollution() {
		
		return pollution;
	}
	/**
	 * metodo getTraffic() che restituisce il numero di auto transitate.
	 * @return traffic
	 */
	
	public int getTraffic() {
		
		return traffic;
		
	}
	/**
	 * metodo getStreet() che restituisce il nome della strada.
	 * @return street
	 */
	public String getStreet() {
		
		return street;
	}

}
