package vehicleDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class GUI extends JFrame {

	private final String[] inventoryFields = {"Model ID", "Manufacturer", "Model Name", "Body Type", "Year", "Price"};
	private DefaultTableModel vehicleModel = new DefaultTableModel(inventoryFields, 0);
	private JPanel contentPane;
	private JTextField modelIDField;
	private JTextField newValueField;
	private JTable vehicleTable;
	private JTextField txtManufacturerName;
	private JTextField txtCountry;
	private JTable tblManufacturer;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private String txtModelID;
	private String txtNewValue;
	private String txtFieldUpdate;
	private JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel inventoryPanel = inventoryPanel();
		layeredPane.add(inventoryPanel, "name_5617185482348");
		
		JPanel manufacturerPanel = manufacturerPanel();
		layeredPane.add(manufacturerPanel, "name_5640955118678");
		
		
		JPanel modelPanel = modelPanel();
		layeredPane.add(modelPanel, "name_5522190835335");
		
		
		JPanel btnPanel = btnPanel();
		contentPane.add(btnPanel, BorderLayout.NORTH);
	}

	/**
	 * Provides three buttons at the top of the user interface to switch between the layered panels;
	 * inventory, manufacturer and model.
	 * 
	 * @return JPanel of buttons.
	 */
	private JPanel btnPanel() {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inventoryPanel());
			}
		});
		btnPanel.add(btnInventory);
		
		JButton btnManufacturer = new JButton("Manufacturer");
		btnManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(manufacturerPanel());
			}
		});
		btnPanel.add(btnManufacturer);
		
		JButton btnModel = new JButton("Model");
		btnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(modelPanel());
			}
		});
		btnPanel.add(btnModel);

		return btnPanel;
	}

	/**
	 * Provides fields to add or remove a model from the the model table in the database. Also includes
	 * a scroll panel that displays the current model table in the database.
	 * 
	 * @return JPanel of the model table.
	 */
	private JPanel modelPanel() {
		JPanel modelPanel = new JPanel();
		JLabel lblModel = new JLabel("Model");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		
		JLabel lblYear = new JLabel("Year");
		
		JLabel lblType = new JLabel("Type");
		
		JLabel lblPrice = new JLabel("Price");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblManufacturer_1 = new JLabel("Manufacturer");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnRemove = new JButton("Remove");
		GroupLayout gl_modelPanel = new GroupLayout(modelPanel);
		gl_modelPanel.setHorizontalGroup(
			gl_modelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_modelPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_modelPanel.createSequentialGroup()
							.addGroup(gl_modelPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_modelPanel.createSequentialGroup()
									.addComponent(lblYear)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblType))
								.addGroup(gl_modelPanel.createSequentialGroup()
									.addComponent(lblName_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblManufacturer_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_modelPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_modelPanel.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_modelPanel.setVerticalGroup(
			gl_modelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_modelPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManufacturer_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		modelPanel.setLayout(gl_modelPanel);

		return modelPanel;
	}

	/**
	 * Provides fields to add or remove a manufacturer from the manufacturer table in the database.
	 * Also includes a scroll panel that displays the current manufacturer table in the databse.
	 * 
	 * @return JPanel of the manufacturer table.
	 */
	private JPanel manufacturerPanel() {
		JPanel manufacturerPanel = new JPanel();
		JLabel lblManufacturer = new JLabel("Manufacturer");
		
		txtManufacturerName = new JTextField();
		txtManufacturerName.setColumns(10);
		
		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		
		JButton btnAddManufacturer = new JButton("Add");
		
		JButton btnRemoveManufacturer = new JButton("Remove");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblCountry = new JLabel("Country");
		
		JScrollPane scrollPaneManufacturer = new JScrollPane();
		GroupLayout gl_manufacturerPanel = new GroupLayout(manufacturerPanel);
		gl_manufacturerPanel.setHorizontalGroup(
			gl_manufacturerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_manufacturerPanel.createSequentialGroup()
					.addGroup(gl_manufacturerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_manufacturerPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtManufacturerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCountry)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_manufacturerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblManufacturer))
						.addGroup(gl_manufacturerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAddManufacturer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveManufacturer))
						.addGroup(gl_manufacturerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneManufacturer, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_manufacturerPanel.setVerticalGroup(
			gl_manufacturerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_manufacturerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblManufacturer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_manufacturerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtManufacturerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(lblCountry)
						.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_manufacturerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddManufacturer)
						.addComponent(btnRemoveManufacturer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneManufacturer, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(4))
		);
		
		tblManufacturer = new JTable();
		scrollPaneManufacturer.setViewportView(tblManufacturer);
		manufacturerPanel.setLayout(gl_manufacturerPanel);

		return manufacturerPanel;
	}

	/**
	 * Provides fields to update rows in the database including fields from both the manufacturer and
	 * tables. It also includes a scroll panel that displays the current inventory of vehicles in the 
	 * database with information from both the manufacturer and model tables.
	 * 
	 * @return JPanel of the inventory of vehicles in the database.
	 */
	private JPanel inventoryPanel() {
		JPanel inventoryPanel = new JPanel();
		JLabel lblInventory = new JLabel("Inventory");
		
		// The entry for "Model ID"
		JLabel lblModelId = new JLabel("Model ID");
		modelIDField = new JTextField();
		modelIDField.setColumns(10);
		
		// Gets the "Model ID" user input from JTextField and stores as a string.
		modelIDField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtModelID = e.toString();	
			}
		});

		// The entry for "New Value" to be entered in the database
		JLabel lblNewValue = new JLabel("New Value");
		newValueField = new JTextField();
		newValueField.setColumns(10);
		
		//Gets "New Value" user input into JTextField and stores as a string.
		newValueField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNewValue = e.toString();
			}
		});

		// Drop Down Menu for the "Field to Update"
		JLabel lblFieldUpdate = new JLabel("Field to Update"); 
		JComboBox<String> fieldToUpdate = new JComboBox<String>(inventoryFields);
			fieldToUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 txtFieldUpdate = e.toString();
				}
			});
		
		// Houses the JTable
		JScrollPane scrollPane = new JScrollPane();
		
		// Update button click event handler
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFieldUpdate == "Manufacturer") {
					Database.executeStatement(SqlManufacturer.updateManufacturerTable(txtFieldUpdate, txtNewValue, txtModelID));
				}
				else {
					Database.executeStatement(SqlModel.updateModelTable(txtFieldUpdate, txtNewValue, txtModelID));
				}
				
				// Updates the table model with the update tables.
				Database.executeTableUpdate(vehicleModel, SqlModel.queryVehicleIndex());
			}
		});
		
		
		GroupLayout gl_inventoryPanel = new GroupLayout(inventoryPanel);
		gl_inventoryPanel.setHorizontalGroup(
			gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inventoryPanel.createSequentialGroup()
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInventory, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblModelId)
								.addComponent(lblNewValue))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inventoryPanel.createSequentialGroup()
									.addComponent(modelIDField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFieldUpdate))
								.addComponent(newValueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUpdate)
								.addComponent(fieldToUpdate, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
					.addGap(10))
		);
		gl_inventoryPanel.setVerticalGroup(
			gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inventoryPanel.createSequentialGroup()
					.addComponent(lblInventory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(modelIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFieldUpdate)
						.addComponent(fieldToUpdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModelId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(newValueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewValue)
						.addComponent(btnUpdate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
					.addGap(5))
		);
		
		vehicleTable = new JTable();
		
		
		vehicleModel = Database.executeTableUpdate(vehicleModel, SqlModel.queryVehicleIndex());		// Populates vehicle model.
		vehicleTable.setModel(vehicleModel);														// Adds vehicleModel to vehicleTable
		scrollPane.setViewportView(vehicleTable);													// Adds vehicleTable JTable to the scroll pane at the bottom of the Inventory tab.
		inventoryPanel.setLayout(gl_inventoryPanel);

		return inventoryPanel;
	}
	
	/**
	 * Provides the logic to switch between the three panels in user interface.
	 * 
	 * @param panel
	 */
	private void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
