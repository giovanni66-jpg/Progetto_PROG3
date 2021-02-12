package monitoraggioAmb;
import java.awt.EventQueue;


//Importo le librerie.
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Creazione del menù. Questo frame mi consentirà di navigare verso la gestione dei sensori e del grafico che plotterà la 
 * media statistica dei tre parametri.
 * @author Pierno Francesco Pio
 *
 */

public class MenuFrame{

	private JFrame frame;

	/**
	 * 
	 * Lancia l'applicazione MenuFrame che permette di visualizzare il menù del progetto
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame window = new MenuFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Crea l'applicazione
	 * 
	 */
	public MenuFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		//Sostituisco l'icona di default di Swing con una nuova.
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus\\Desktop\\Monitoraggio_ambientale\\src\\monitoraggioAmb\\logo.png"));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 687, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Men\u00F9 monitoraggio");
		//Metodi che personalizzano il frame.
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(181, 10, 325, 91);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Log Out");
		btnBack.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frmLogoutSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLogoutSystem, "Conferma per uscire", "Logout Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					
					LoginFrame loginFrame = new LoginFrame();
					frame.dispose(); //Chiudo la schermata del MenuFrame.
					
					loginFrame.main(null); //Ritorna alla schermata login.
					
				}
      	
			}
		});
		
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setFont(btnBack.getFont().deriveFont(btnBack.getFont().getStyle() | Font.BOLD));
		btnBack.setForeground(SystemColor.text);
		btnBack.setBounds(281, 378, 103, 48);
		frame.getContentPane().add(btnBack);
		
		//Bottone Gestisci che manderà al successivo frame.
		JButton btnSystem = new JButton("Gestisci");
		btnSystem.setForeground(SystemColor.text);
		//Metodo listener che dichiara l'azione da effettuare quando si preme il bottone
		btnSystem.addActionListener(new ActionListener() {
			//Depreco il warning dato dall'IDE.
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				ManagementFrame managementFrame = new ManagementFrame(); //Dichiaro il successivo frame.
				frame.dispose(); //Chiudo il frame corrente.
				managementFrame.main(null); //Apro il nuovo frame.
			}
		});
		btnSystem.setBackground(SystemColor.textHighlight);
		btnSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSystem.setBounds(135, 164, 139, 72);
		frame.getContentPane().add(btnSystem);
		
		JButton btnNewButton = new JButton("Grafico");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DefaultCategoryDataset data = new DefaultCategoryDataset(); //Tramite la liberia .net posso estrarre i dati dal mio database MySQL per poi inserirli nel grafico.
					Conn conn = Conn.getInstance();
					//Utilizzo una query con una funzione aggregata AVG che mi restituisce la media dei tre parametri dando anche un'alias alla colonna risultato.
					String query = "SELECT avg(Temperatura) as Temperatura, avg(Traffico) as Traffico, avg(inquinamento) as Inquinamento FROM my_db.sensore;"; 
					Statement statement = conn.getConnection().createStatement(); //Creo lo statement, che crea l'interfaccia dello statement di MySQL
					ResultSet rs = statement.executeQuery(query); //Eseguo la query precedentemente dichiarata.
					
					
					
					while(rs.next())
					{
						//Inserisco i risultati della query nella variabile data che successivamente li plotta sul grafico
						data.setValue(rs.getDouble("Temperatura"), "Marks", "Temperatura");
						data.setValue(rs.getInt("Traffico"), "Marks", "Traffico");
						data.setValue(rs.getDouble("Inquinamento"), "Marks", "Inquinamento");
					}
					
					//Dichiarazione di variabili per personalizzare il grafico.
					JFreeChart jChart = ChartFactory.createBarChart("Media statistica", "Valori giornalieri", "Measure mark", data, PlotOrientation.VERTICAL, true, true, false);
					CategoryPlot plot = jChart.getCategoryPlot();
					
				
					plot.setRangeGridlinePaint(Color.black);
					
					ChartFrame chartFrame = new ChartFrame("Measure record", jChart, true);
					chartFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\\Asus\\\\Desktop\\\\Monitoraggio_ambientale\\\\src\\\\monitoraggioAmb\\\\logo.png"));
					
					chartFrame.setVisible(true);
					
					
					
					ChartPanel chartPanel = new ChartPanel(jChart);
					chartPanel.setPreferredSize(new java.awt.Dimension(560,400));
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(397, 164, 139, 72);
		frame.getContentPane().add(btnNewButton);
		}
	
	
}
