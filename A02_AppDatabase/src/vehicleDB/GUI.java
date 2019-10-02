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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class GUI extends JFrame {

	private DefaultTableModel vehicleModel = new DefaultTableModel();
	private Hashtable<String, String> friendlyNames = new Hashtable<String, String>();
	private JPanel contentPane;
	private JTextField modelIDField;
	private JTextField newValueField;
	private JComboBox<String> fieldToUpdate = new JComboBox<String>();
	private JTable vehicleTable;
	private JTextField txtManufacturerName;
	private JTextField txtCountry;
	private JTable tblManufacturer;
	private JTextField modelName;
	private JTextField modelType;
	private JTextField modelYear;
	private JTextField modelPrice;
	private JTable table;
	private Integer txtModelID;
	private String txtNewValue;
	private String txtFieldUpdate;
	private JLayeredPane layeredPane = new JLayeredPane();
	
	//Used in model tab
	private String modelNameContent;
	private String yearContent;
	private String typeContent;
	private String priceContent;
	private String modelCBSelection;
	private String modelCBContent;
	private JTextField modelRemovalID = new JTextField();
	private String modelIDContent;
	//private final String[] modelComboBoxFields = new String[Database.executeTableUpdate(model, queries));]

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
		setBounds(100, 100, 700, 600);
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
		
		Database.friendlyNames(friendlyNames);
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
		
		JLabel lblName = new JLabel("Name");
		modelName = new JTextField();
		modelName.setColumns(10);
		
		// Stores input name into modelNameContent.
		modelName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField source = (JTextField) e.getSource();
				String textInput = source.getText();
				modelNameContent = textInput;
			}
		});
		
		JLabel lblType = new JLabel("Type");
		modelType = new JTextField();
		modelType.setColumns(10);
		
		// Stores input name of type into typeContent.
		//modelType.addActionListener();
		JLabel lblYear = new JLabel("Year");
		modelYear = new JTextField();
		modelYear.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		modelPrice = new JTextField();
		modelPrice.setColumns(10);
		
		
		
		
		
		
		
		
		
		JScrollPane scrollPaneModel = new JScrollPane();
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		JComboBox comboBoxManufacturer = new JComboBox();
		
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
									.addComponent(modelYear, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(modelPrice, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblType))
								.addGroup(gl_modelPanel.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(modelName, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblManufacturer, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(gl_modelPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxManufacturer, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(modelType, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_modelPanel.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove))
						.addComponent(scrollPaneModel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_modelPanel.setVerticalGroup(
			gl_modelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_modelPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(modelName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManufacturer, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxManufacturer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(modelYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(modelPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType)
						.addComponent(modelType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_modelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneModel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPaneModel.setViewportView(table);
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
		lblInventory.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		// The entry for "Model ID"
		JLabel lblModelId = new JLabel("Model ID");
		modelIDField = new JTextField();
		modelIDField.setColumns(10);
		
//		// Gets the "Model ID" user input from JTextField and stores as a string.
//		modelIDField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				txtModelID = Integer.parseInt(e.getActionCommand());
//			}
//		});

		// The entry for "New Value" to be entered in the database
		JLabel lblNewValue = new JLabel("New Value");
		newValueField = new JTextField();
		newValueField.setColumns(10);
		
//		//Gets "New Value" user input into JTextField and stores as a string.
//		newValueField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				txtNewValue = e.getActionCommand();
//			}
//		});

		// Drop Down Menu for the "Field to Update"
		JLabel lblFieldUpdate = new JLabel("Field to Update"); 
		for(int i = 1; i < friendlyNames.size(); i++) {
			fieldToUpdate.addItem(friendlyNames.get(vehicleModel.getColumnName(i)));
		}
//			fieldToUpdate.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					txtFieldUpdate = friendlyNames.get(e.getActionCommand());
//				}
//			});
		
		// Houses the JTable
		JScrollPane scrollPane = new JScrollPane();
		
		// Update button click event handler
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				submitUpdateInventory();
			}
			
			public void focusLost(FocusEvent e) {
				submitUpdateInventory();
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("Manufacturer");
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		
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
								.addComponent(lblNewLabel)
								.addGroup(gl_inventoryPanel.createSequentialGroup()
									.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewValue)
										.addComponent(lblModelId))
									.addGap(9)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inventoryPanel.createSequentialGroup()
									.addComponent(modelIDField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFieldUpdate))
								.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(newValueField, Alignment.LEADING)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inventoryPanel.createSequentialGroup()
									.addGap(45)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(73)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnUpdate)
								.addComponent(fieldToUpdate, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)))
					.addGap(10))
				.addGroup(gl_inventoryPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFilters)
					.addContainerGap(645, Short.MAX_VALUE))
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
						.addComponent(btnUpdate)
						.addComponent(lblNewValue))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFilters)
					.addGap(11)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		
		vehicleTable = new JTable();																// Creates a new JTable to hold the vehicle inventory.
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
	
	private void submitUpdateInventory() {
		
		txtModelID = Integer.parseInt(modelIDField.getText());
		txtNewValue = newValueField.getText();
		txtFieldUpdate = fieldToUpdate.getToolTipText();
		
		System.out.println("Model ID: " + txtModelID);
		System.out.println("New Value: " + txtNewValue);
		System.out.println("Manufacturer: " + txtFieldUpdate);
		
		if(txtNewValue.matches("(\\d+)")){
			int newIntValue = Integer.parseInt(txtNewValue);
			Database.executeStatement(SqlModel.updateModelTable(txtFieldUpdate, newIntValue, txtModelID));
		} else {
			Database.executeStatement(SqlModel.updateModelTable(txtFieldUpdate, txtNewValue, txtModelID));
		}
		Database.executeTableUpdate(vehicleModel, SqlModel.queryVehicleIndex());
	}
}
