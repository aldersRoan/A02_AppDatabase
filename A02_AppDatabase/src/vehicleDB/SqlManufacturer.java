package vehicleDB;

public class SqlManufacturer {
	
	/**TODO
	 * 
	 * @return
	 */
	public static String createManufacturerTable() {
		return "create table Manufacturer ( "
					+ "ManufacturerID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, "
					+ "Name varchar(256), "
					+ "Country varchar(256))";
	}
	
	/**TODO
	 * 
	 * @return
	 */
	public static String fillManufacturerTable() { 
			
		return ""
				+ "INSERT INTO Manufacturer (Name,Country)"
				+ " VALUES "
				+ "('Ford','USA'),"
				+ "('Honda','Japan'),"
				+ "('Chevrolet','USA'),"
				+ "('BMW', 'Germany'),"
				+ "('Cadillac','USA'),"
				+ "('Austin', 'United Kingdom'),"
				+ "('Fillmore','USA'),"
				+ "('Studebaker','USA'),"
				+ "('Pontiac','USA'),"
				+ "('Dodge','USA'),"
				+ "('Toyota','Japan'),"
				+ "('Mazda','Japan')";
		}
	
	public static String getAllManufacturers() { 
		
		return  ""
		+ "select * from Manufacturer";
	}
	
	public static String deleteManufacturerTable() { 
		
		return  ""
		+ "drop table Manufacturer";
	}
	
	public static String updateManufacturerTable(String field, String newValue, String ID) {
		return String.format(""
		+ "UPDATE Model SET %s = %s WHERE ModelID = %s", field, newValue, ID);
	}
}
