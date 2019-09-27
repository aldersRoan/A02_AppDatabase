package vehicleDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVehicleMenu extends JFrame {

	private JPanel contentPane;
	StringBuilder newVehicle = new StringBuilder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicleMenu frame = new AddVehicleMenu();
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
	public AddVehicleMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Text fields for the AddVehicle form
		JTextField txtManufacturer = newTxtManufacturer();
		contentPane.add(txtManufacturer);
		
		JTextField txtModel = newTxtModel();
		contentPane.add(txtModel);
		
		JTextField txtYear = newTxtYear();
		contentPane.add(txtYear);
		
		JTextField txtPrice = newTxtPrice();
		contentPane.add(txtPrice);
		
		// Labels for the AddVehicle form
		JLabel lblManufacturer = newLblManufacturer();
		contentPane.add(lblManufacturer);
		
		JLabel lblModel = newLblModel();
		contentPane.add(lblModel);
		
		JLabel lblYear = newLblYear();
		contentPane.add(lblYear);
		
		JLabel lblPrice = newLblPrice();
		contentPane.add(lblPrice);
		
		// Buttons to submit or cancel adding a vehicle
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleGUI.executeRowUpdate(newVehicle.toString());
			}
		});
		btnSubmit.setBounds(65, 231, 117, 29);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(293, 231, 117, 29);
		contentPane.add(btnCancel);
	}

	private JTextField newTxtManufacturer() {
		JTextField textManufacturer = new JTextField();
		textManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manufacturer = textManufacturer.getText();
				newVehicle.append(manufacturer + ",");
			}
		});
		
		textManufacturer.setBounds(149, 25, 134, 28);
		textManufacturer.setColumns(10);
		return textManufacturer;
	}
	
	private JTextField newTxtModel() {
		JTextField textModel = new JTextField();
		textModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String model = textModel.getText();
				newVehicle.append(model + ",");

			}
		});
		textModel.setBounds(149, 65, 134, 28);
		textModel.setColumns(10);
		return textModel;
	}
		
	private JTextField newTxtYear() {
		JTextField textYear = new JTextField();
		textYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String year = textYear.getText();
				newVehicle.append(year + ",");
			}
		});
		textYear.setBounds(149, 105, 134, 28);
		textYear.setColumns(10);
		return textYear;
	}	
		
	private JTextField newTxtPrice() {
		JTextField textPrice = new JTextField();
		textPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String price = textPrice.getText();
				newVehicle.append(price);
			}
		});
		textPrice.setBounds(149, 145, 134, 28);
		textPrice.setColumns(10);
		return textPrice;
	}

	private JLabel newLblManufacturer() {
		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblManufacturer.setBounds(40, 31, 98, 16);
		return lblManufacturer;
	}
	
	private JLabel newLblModel() {
		JLabel lblModel = new JLabel("Model");
		lblModel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModel.setBounds(40, 71, 98, 16);
		return lblModel;
	}
	
	private JLabel newLblYear() {
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setBounds(40, 111, 98, 16);
		return lblYear;
	}
	
	private JLabel newLblPrice() {
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(40, 151, 98, 16);
		return lblPrice;
	}
}
