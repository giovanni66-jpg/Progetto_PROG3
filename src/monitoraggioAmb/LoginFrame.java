//I seguenti Frame sono stati implementati tramite il plugin di Eclipse "WindowsBuilder" fornendo all'utente un'ottima agevolazione
// per la creazione di frame e per la personalizzazione di quest'ultimi.


package monitoraggioAmb;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;


/**
 * Dichiarazione della classe LoginFrame e delle sue variabili private.
 * @author Pierno Francesco Pio
 */

public class LoginFrame {
  //Dichiarazioni variabili private.
	private JFrame frame;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JFrame frmLoginSystem;

	/**
	 * Lancia l'applicazione e crea il frame Login.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea l'applicazione.
	 */
	public LoginFrame() {
		//Metodo che avvia l'applicazione.
		initialize();
	}

	/**
	 * Inizializza il contenuto del frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		//metodo di JFrame che mi permette di settare l'icona per la finestra in questione.
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus\\Desktop\\logo.png"));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 500, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema monitoraggio ambientale");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 10, 392, 55);
		frame.getContentPane().add(lblNewLabel);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setFont(btnLogin.getFont().deriveFont(btnLogin.getFont().getStyle() | Font.BOLD));
		btnLogin.setBackground(SystemColor.textHighlight);
		/**
		 * Richiamo del metodo addActionListener che prende in input una nuova azione del mouse.
		 * @param MenuFrame Restituisce il successivo frame al login dell'amministratore.
		 * 
		 */
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				//INSERT HERE
			        String password = txtPassword.getText();
					String username = txtUsername.getText();
					if(password.equals("root") && username.equals("admin")) //Se i dati da me inseriti sono giusti, mi effettua il login
					{
						//Resetto i dati inseriti nei campi
						txtPassword.setText(null);
						txtUsername.setText(null);
						//Printo il messaggio che il login � avvenuto con successo.
						System.out.println("Hai effettuato il login!");
						JOptionPane.showMessageDialog(btnLogin, "Benvenuto/a");
						MenuFrame menuFrame = new MenuFrame();
						menuFrame.main(null); //Metodo che mi permette di accedere alla prossima pagina.
						frame.setVisible(false); //Mi chiude la pagina corrente, si utilizza anche il metodo frame.dispose();
						
						}
					else
					{
						//Tramite JOptionPane, mi appare una finestra di avviso che le credenziali inserite sono errori
						JOptionPane.showMessageDialog(null, "Credenziali invalide", "Errore", JOptionPane.ERROR_MESSAGE); 
						//Resetto i campi
						txtPassword.setText(null);
						txtUsername.setText(null);
					}
				
			}
		});
		btnLogin.setBounds(29, 244, 117, 43);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		//Metodi che modificano il design del bottone
		btnReset.setForeground(SystemColor.text);
		btnReset.setFont(btnReset.getFont().deriveFont(btnReset.getFont().getStyle() | Font.BOLD));
		btnReset.setBackground(SystemColor.textHighlight);
		btnReset.setBounds(194, 244, 110, 43);
		frame.getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //Al click del tasto Reset, annullo tutti i dati inseriti nei vari campi.
				txtPassword.setText(null);
				txtUsername.setText(null);
				
			}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(SystemColor.text);
		btnExit.setFont(btnExit.getFont().deriveFont(btnExit.getFont().getStyle() | Font.BOLD));
		btnExit.setBackground(SystemColor.textHighlight);
		btnExit.setBounds(345, 244, 101, 43);
		frame.getContentPane().add(btnExit);
        btnExit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmLoginSystem = new JFrame("Exit");
			
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Conferma per uscire", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					
					//Se decido di premere "Si", il programma termina.
					System.exit(0);
				}
      	
			}
		});
		
		//Dichirazioni di label e textField.
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 94, 92, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(54, 148, 92, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(173, 155, 142, 26);
		frame.getContentPane().add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(173, 101, 142, 27);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
	    
	}
}