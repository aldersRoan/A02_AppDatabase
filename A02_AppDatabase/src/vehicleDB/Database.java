package vehicleDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class Database {

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
	
	/**
	 * Updates a row in the table taking in an SQL query.
	 * @param query
	 */
	static void executeRowUpdate(String query) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
		
				Statement statement = connection.createStatement();){
				statement.executeUpdate(query);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
}
