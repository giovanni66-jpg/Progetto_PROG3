package monitoraggioAmb;
import java.sql.*; //importo le librerie inerenti a MYSQL
/**
 * 
 * Creazione della classe Conn. Questa classe andrà a creare la connessione al mio database MySQL.
 * Per la creazione della classe è stato utilizzando il design pattern Singleton. Il Singleton ha lo scopo
 * di garantire la creazione di una sola istanza nella classe.
 * 
 * @author Pierno Francesco Pio
 *
 */


public class Conn {
	/**
	 * Dichiarazioni variabili private.
	 */
	private static Conn instance;
	private Connection c;
	private String url = "jdbc:mysql://localhost:3306/my_db"; //Stringa che contiene l'url
	private String username = "root"; //utente root
	private String password = "root";
	
	/**
	 * costruttore Conn(). La parola chiave "throws" indica quale tipo di eccezione può essere generato da un metodo accompagnato anche
	 * da un costrutto try-catch.
	 * Tramite il try definisco il blocco da "testare" per gli errori ed il catch consente di definire un blocco di codice da eseguire, 
	 * se si verifica un errore nel blocco try.
	 * @throws SQLException prova
	 * 
	 */
	private Conn() throws SQLException //Metodo che mi permette di creare una connessione al mio database MySQL
	{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.c = DriverManager.getConnection(url, username, password); //Ottengo la connessione
				System.out.println("Connesso!"); //Stampa che la connessione è avvenuta con successo
				
			  } catch (Exception e) { //Se la connessione non va a buon fine, il compilatore lancia un errore
				// TODO: handle exception
				System.out.println(e);
			}
	}
	/**
	 * 
	 * Dichiarazione del metodo getConnection() che restituirà la connessione.
	 * @return c
	 */
	public Connection getConnection(){
		
		return c; //Restituisce la connessione;
	}
	/**
	 * Creazione del metodo getInstance(). Questo metodo ha lo scopo di creare l'unica istanza di accesso.
	 *  Le successive invocazioni di getInstance() restituiscono il riferimento allo stesso oggetto
	 * @return instance
	 * @throws SQLException Un'eccezione che fornisce informazioni su un errore di accesso al database o altri errori.
	 */
	
	public static Conn getInstance() throws SQLException
	{
		if(instance == null)
		{
			instance = new Conn();
		
	} else if (instance.getConnection().isClosed()){
		instance = new Conn();
	}
	 return instance;
	}
}
