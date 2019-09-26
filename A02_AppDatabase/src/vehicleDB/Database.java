package vehicleDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {

	public static void main(String[] args) {
		
		//executeStatement(SqlModel.deleteModelTable());
		
//		executeStatement(SqlManufacturer.createManufacturerTable());
//		executeStatement(SqlModel.createModelTable());
//		executeStatement(SqlVehicleIndex.createVehicleIndexTable());
//		
//		executeStatement(SqlManufacturer.fillManufacturerTable());
//		executeStatement(SqlModel.fillModelTable());
//		executeStatement(SqlVehicleIndex.fillVehicleIndexTable());
		
		//ArrayList<String> querys = new ArrayList<String>();
		executeQueries(SqlManufacturer.getAllManufacturers(), SqlModel.getAllModels(), SqlVehicleIndex.getAllVehicles());
	
		System.out.println();

		System.out.println("done!");
	
	}
	
	private static void executeQueries(String... queries) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
				Statement statement = connection.createStatement();){
				
				for(String query:queries) {
				ResultSet results = statement.executeQuery(query);
				ResultSetMetaData metaData = results.getMetaData();
				
					while(results.next()) {
						
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							System.out.print(results.getObject(i).toString()+"\t");
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

	private static void executeStatement(String sqlStatement) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:Database");
				Statement statement = connection.createStatement();){
				
			
				statement.execute(sqlStatement);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
