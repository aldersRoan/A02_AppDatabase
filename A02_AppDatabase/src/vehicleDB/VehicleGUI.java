package vehicleDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

/**
 * GUI that displays and manipulates an SQL database of vehicles
 * @author TannerK, WinstonF, AaronS
 *
 */
public class VehicleGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] tableColumnsName = { "ID", "MANUFACTURER", "MODEL", "YEAR", "PRICE" };
	private DefaultTableModel model = new DefaultTableModel(tableColumnsName,0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleGUI frame = new VehicleGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VehicleGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 449);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(5, 5, 5, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = buttonPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(10, 10, 10, 10));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		model = executeTableUpdate(model, SqlVehicleIndex.queryVehicleIndex());
		
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	/**
	 * Creates the panel of buttons and provides action listeners and event handlers
	 * for the buttons
	 * 
	 * @return JPanel containing the buttons
	 */
	private JPanel buttonPanel() {
		JPanel upperPanel = new JPanel();
		upperPanel.setBounds(new Rectangle(10, 10, 10, 10));

		upperPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVehicleMenu addVehicle = new AddVehicleMenu();
				addVehicle.setVisible(true);
//				JFrame addVehicleBox = new JFrame("Add Vehicle Dialog Box");
//				String vehicle = JOptionPane.showInputDialog(
//								addVehicleBox,
//								"Enter the vehicle information to add a new vehicle",
//								"Add a Vehicle",
//								JOptionPane.PLAIN_MESSAGE
//								);
				//executeRowUpdate(SqlModel.addToModelTable(vehicle));
			}
		});
		//addButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		upperPanel.add(addButton);

		JButton updateButton = new JButton("UPDATE LIST");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				executeTableUpdate(model, SqlVehicleIndex.queryVehicleIndex());
			}
		});
		upperPanel.add(updateButton);

		JButton deleteButton = new JButton("DELETE ITEM FROM LIST");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame dialogBox = new JFrame("InputDialog Example #2");
				String code = JOptionPane.showInputDialog(
								dialogBox,
								"Enter the ID number of the vehicle you want to delete",
								"Vehicle Deleter",
								JOptionPane.PLAIN_MESSAGE
								);
				executeRowUpdate(SqlModel.delRowFromModelTable(code));
				executeTableUpdate(model, SqlVehicleIndex.queryVehicleIndex());
			}
		});
		upperPanel.add(deleteButton);
		return upperPanel;
	}
	
	/**
	 * Takes a DefaultTableModel and a String of SQL queries and returns a
	 * model for a JTable to be displayed in the GUI.
	 * @param model
	 * @param queries
	 * @return
	 */
	public static DefaultTableModel executeTableUpdate(DefaultTableModel model, String... queries) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
				Statement statement = connection.createStatement();){
				model.setRowCount(0);
				
				for(String query:queries) {
					ResultSet results = statement.executeQuery(query);
					ResultSetMetaData metaData = results.getMetaData();
					
					while(results.next()) {
						Object[] row = new Object[metaData.getColumnCount()];
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							row[i - 1] = results.getObject(i);
						}
						model.addRow(row);
					}
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	static void executeRowUpdate(String query) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
		
				Statement statement = connection.createStatement();){
				statement.executeUpdate(query);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
}
