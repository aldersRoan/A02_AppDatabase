package vehicleDB;

public class SqlModel {
	/**TODO
	 * 
	 * @return
	 */
	public static String createModelTable() {
		return "create table Model ( "
					+ "id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 101, INCREMENT BY 1),"
					+ "Name varchar(256),"
					+ "Type varchar(256),"
					+ "ModelYear int,"
					+ "Price int)";//TODO change to money
	}
	
	/**TODO
	 * 
	 * @return
	 */
	public static String fillModelTable() { 
			
			return  ""
			+ "INSERT INTO Model (Name,Type,ModelYear,Price)"
			+ "VALUES "
			+ "('Camaro','Coupe',2016,40000),"
			+ "('Tahoe','SUV',2010,75000),"
			+ "('Silverado','Truck',2020,55000)";
		}
	
	public static String getAllModels() { 
		
		return  ""
		+ "select * from Model";
	}
	
	public static String deleteModelTable() { 
		
		return  ""
		+ "drop table Model";
	}
	
	public static String delRowFromModelTable(String row) {
		return String.format(""
		+ "DELETE FROM Model WHERE id = %s", row);
	}
	
	public static String addToModelTable() {
		return "INSERT into Model"
		+ "(Name,Type,ModelYear,Price) VALUES ('Silverado','Truck','2020','57000')";
	}
}
