package vehicleDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class Database {
	private static Hashtable<String, String> friendlyNames = new Hashtable<String, String>();
	
	public Database() {
		friendlyNames(friendlyNames);
	}
			
	public static void main(String[] args) {
		
//		executeStatement(SqlModel.deleteModelTable());
//		executeStatement(SqlManufacturer.deleteManufacturerTable());
//		executeStatement(SqlVehicleIndex.deleteVehicleIndex());
		
//		executeStatement(SqlManufacturer.createManufacturerTable());
//		executeStatement(SqlModel.createModelTable());
//		executeStatement(SqlVehicleIndex.createVehicleIndexTable());
		
//		executeStatement(SqlManufacturer.fillManufacturerTable());
//		executeStatement(SqlModel.fillModelTable());
//		executeStatement(SqlVehicleIndex.fillVehicleIndexTable());
		
		//ArrayList<String> querys = new ArrayList<String>();
		executeQueries(SqlManufacturer.getAllManufacturers(), SqlModel.getAllModels());
	
		System.out.println();

		System.out.println("done!");
	
	}
	
	public static void executeQueries(String... queries) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
				Statement statement = connection.createStatement();){
				
				for(String query:queries) {
				ResultSet results = statement.executeQuery(query);
				ResultSetMetaData metaData = results.getMetaData();
				
					while(results.next()) {
						
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							System.out.printf("%15s", results.getObject(i).toString());
						}
						System.out.println();
					}
					
					System.out.println();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public static void executeStatement(String sqlStatement) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
				Statement statement = connection.createStatement();){
				
			
				statement.execute(sqlStatement);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				
				String[] tableNames = {};
				
				for(String query:queries) {
					ResultSet results = statement.executeQuery(query);
					ResultSetMetaData metaData = results.getMetaData();
					
					for(int i = 1; i <= metaData.getColumnCount(); i++) {
						tableNames[i] = friendlyNames.get(metaData.getColumnName(i));
						
					}
					
					
					while(results.next()) {
						Object[] row = new Object[metaData.getColumnCount()];
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							row[i - 1] = results.getObject(i);
						}
						model.addRow(row);
					}
					
				}
				model.setColumnIdentifiers(tableNames);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	public static void friendlyNames(Hashtable<String, String> friendlyNames) {
		friendlyNames.put("Model ID", "ModelID");
		friendlyNames.put("Manufacturer", "Make");
		friendlyNames.put("Model Name", "Name");
		friendlyNames.put("Body Type", "Type");
		friendlyNames.put("Year", "ModelYear");
		friendlyNames.put("Price", "Price");
		friendlyNames.put("Country", "Country");
		friendlyNames.put("Manufacturer ID", "ManufacturerID");
}
	

}
