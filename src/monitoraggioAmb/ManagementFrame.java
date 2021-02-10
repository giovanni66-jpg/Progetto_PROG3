package monitoraggioAmb;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.proteanit.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Creazione del frame ManagementFrame. Il presente frame mi consentirà di andare ad effettuare le varie operazioni di aggiunta
 * sensori, mostrare i dati salvati del database all'interno di una tabella e di verificare lo stato di un sensore.
 * 
 * @author Pierno Francesco Pio
 *
 */

public class ManagementFrame {

	
	private JFrame frame;
	private JTextField textId;
	private JTextField textTemp;
	private JTextField textPoll;
	private JTextField textTraff;
	private JTextField textPerc;
	private JTable table_1;
	private Observer sensors;

	/**
	 * Lancio dell'applicazione ManagementFrame
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementFrame window = new ManagementFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creo l'applicazione.
	 */
	public ManagementFrame() {
		initialize();
	}

	/**
	 * Inizializzo il contenuto del frame.
	 */
	private void initialize() {
		ConcreteSubject datas = new ConcreteSubject();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus\\Desktop\\logo.png"));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 795, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(21, 72, 55, 34);
		frame.getContentPane().add(lblID);
		
		JLabel lblTemp = new JLabel("Temperatura");
		lblTemp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setBounds(25, 132, 99, 18);
		frame.getContentPane().add(lblTemp);
		
		JLabel lblNewLabel_2 = new JLabel("Inquinamento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(25, 181, 99, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblTraff = new JLabel("Traffico");
		lblTraff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTraff.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraff.setBounds(21, 232, 75, 26);
		frame.getContentPane().add(lblTraff);
		
		JLabel lblNewLabel_4 = new JLabel("Percorso");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(31, 277, 74, 47);
		frame.getContentPane().add(lblNewLabel_4);
		
		textId = new JTextField();
		textId.setBounds(170, 82, 96, 19);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		textTemp = new JTextField();
		textTemp.setBounds(170, 131, 96, 19);
		frame.getContentPane().add(textTemp);
		textTemp.setColumns(10);
		
		textPoll = new JTextField();
		textPoll.setBounds(170, 187, 96, 19);
		frame.getContentPane().add(textPoll);
		textPoll.setColumns(10);
		
		textTraff = new JTextField();
		textTraff.setBounds(170, 238, 96, 19);
		frame.getContentPane().add(textTraff);
		textTraff.setColumns(10);
		
		textPerc = new JTextField();
		textPerc.setBounds(170, 293, 96, 19);
		frame.getContentPane().add(textPerc);
		textPerc.setColumns(10);
		
		JButton btnAdd = new JButton("Aggiungi");
		btnAdd.setForeground(SystemColor.inactiveCaptionBorder);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String idString = textId.getText();
				double temperature = Double.parseDouble(textTemp.getText());
				int pollution = Integer.parseInt(textPoll.getText());
				int traffico = Integer.parseInt(textTraff.getText());
				String stradaString = textPerc.getText();
				
				try {
					
					Conn conn = Conn.getInstance();

					PreparedStatement st;
					String query = "INSERT INTO my_db.sensore values(?,?,?,?,?)";
					st = conn.getConnection().prepareStatement(query);
			        st.setString(1, idString);
			        st.setDouble(2, temperature);
			        st.setInt(3, pollution);
			        st.setInt(4, traffico);
			        st.setString(5, stradaString);
					st.executeUpdate();
					sensors = new Sensors();
					datas.attach(sensors);
					datas.notifyObservers(new Message(idString, temperature, pollution, traffico, stradaString));
					JOptionPane.showMessageDialog(null, "Operazione eseguita");
						
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.setFont(btnAdd.getFont().deriveFont(btnAdd.getFont().getStyle() | Font.BOLD));
		btnAdd.setBounds(39, 386, 99, 40);
		frame.getContentPane().add(btnAdd);
		
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.addMouseListener(new MouseAdapter() {
			
			//Metodo mouseListener che mi permette di salvare le variabili, con il click del mouse, all'interno dei campi.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				textId.setText(model.getValueAt(i, 0).toString());
			    textTemp.setText(model.getValueAt(i, 1).toString());
				textPoll.setText(model.getValueAt(i, 2).toString());
				textTraff.setText(model.getValueAt(i, 3).toString());
				textPerc.setText(model.getValueAt(i, 4).toString());
				
				
			 }
		});
        table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_1.setBounds(354, 39, 380, 432);
		frame.getContentPane().add(table_1);
		
		JButton btnView = new JButton("Mostra");
		btnView.setForeground(SystemColor.controlLtHighlight);
		btnView.setBackground(SystemColor.textHighlight);
		btnView.setFont(btnView.getFont().deriveFont(btnView.getFont().getStyle() | Font.BOLD));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Conn conn = Conn.getInstance();
					String query = "SELECT * from my_db.sensore";
					PreparedStatement st = conn.getConnection().prepareStatement(query);
					ResultSet rs = st.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs)); //Tramite la libreria DBUtils inserisco nella tabella i valori
					// all'interno del database prendendo come argomento il risultato della query.
					
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
			}
		});
		btnView.setBounds(181, 455, 99, 40);
		frame.getContentPane().add(btnView);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(354, 10, 417, 402);
		frame.getContentPane().add(scrollPane);
		
		JButton btnModify = new JButton("Modifica");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idString = textId.getText();
				double temperature = Double.parseDouble(textTemp.getText());
				int pollution = Integer.parseInt(textPoll.getText());
				int traffico = Integer.parseInt(textTraff.getText());
				String stradaString = textPerc.getText();
				
			   try {
					
					Conn conn = Conn.getInstance();
					int row = table_1.getSelectedRow();
					String value = (String) (table_1.getModel().getValueAt(row, 0));
		            String query = ("UPDATE my_db.sensore SET Temperatura = ?, Inquinamento = ?, Traffico = ?, Strada = ? WHERE idSensore = '" + value +"'"); 
					PreparedStatement st;
					st = conn.getConnection().prepareStatement(query);
			        st.setDouble(1, temperature);
			        st.setInt(2, pollution);
			        st.setInt(3, traffico);
			        st.setString(4, stradaString);
					st.executeUpdate();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
					sensors = new Sensors();
					sensors.update(new Message(idString, temperature, pollution, traffico, stradaString));
					JOptionPane.showMessageDialog(null, "Operazione eseguita");
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnModify.setForeground(SystemColor.text);
		btnModify.setBackground(SystemColor.textHighlight);
		btnModify.setFont(btnModify.getFont().deriveFont(btnModify.getFont().getStyle() | Font.BOLD));
		btnModify.setBounds(181, 386, 99, 40);
		frame.getContentPane().add(btnModify);
		
		JButton btnBack = new JButton("Indietro");
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				MenuFrame menuFrame = new MenuFrame();
				frame.dispose();
				menuFrame.main(null);
			}
		});
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setFont(btnBack.getFont().deriveFont(btnBack.getFont().getStyle() | Font.BOLD));
		btnBack.setForeground(SystemColor.text);
		btnBack.setBounds(418, 455, 104, 40);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Stato");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Imposto le soglie per i tre parametri.
				final double tempSoglia = 37;
				final int traffSoglia = 40;
				final int pollSoglia = 60;
				
				//Estraggo i tre valori nella tabella e li inserisco in tre variabili.
				double temperature = Double.parseDouble(textTemp.getText());
				int pollution = Integer.parseInt(textPoll.getText());
				int traffico = Integer.parseInt(textTraff.getText());
				if(temperature < tempSoglia && pollution < pollSoglia && traffico < traffSoglia)
				{
					Context context = new Context(new CodiceVerde());
					JOptionPane.showMessageDialog(null, context.executeStrategy());
					System.out.println(context.executeStrategy());
				}
				else if(temperature > tempSoglia && pollution > pollSoglia && traffico > traffSoglia)
				{
					Context context = new Context(new CodiceRosso());
					JOptionPane.showMessageDialog(null, context.executeStrategy(), "Codice",JOptionPane.WARNING_MESSAGE);
					System.out.println(context.executeStrategy());
				}
				else if(temperature > tempSoglia && pollution > pollSoglia )
				{
					Context context = new Context(new CodiceGiallo());
					JOptionPane.showMessageDialog(null, context.executeStrategy(), "Codice", JOptionPane.DEFAULT_OPTION);
					System.out.println(context.executeStrategy());
				}
				else 
				{
					Context context = new Context(new CodiceVerde());
					JOptionPane.showMessageDialog(null, context.executeStrategy(), "Codice", JOptionPane.DEFAULT_OPTION);
					System.out.println(context.executeStrategy());
				}
				
				
			}
		});
		btnNewButton.setBounds(586, 455, 99, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textId.setText(null);
				textTemp.setText(null);
				textPoll.setText(null);
				textTraff.setText(null);
				textPerc.setText(null);
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD));
		btnNewButton_1.setBounds(39, 455, 99, 40);
		frame.getContentPane().add(btnNewButton_1);
	}
}
