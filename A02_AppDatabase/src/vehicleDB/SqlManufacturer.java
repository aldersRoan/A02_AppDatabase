package vehicleDB;

public class SqlManufacturer {
	
	/**TODO
	 * 
	 * @return
	 */
	public static String createManufacturerTable() {
		return "create table Manufacturer ( "
					+ "id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ "Name varchar(256), "
					+ "Country varchar(256))";
	}
	
	/**TODO
	 * 
	 * @return
	 */
	public static String fillManufacturerTable() { 
			
			return  ""
			+ "INSERT INTO Manufacturer (Name,Country)"
			+ "VALUES "
			+ "('Ford','USA'),"
			+ "('Honda','Japan'),"
			+ "('Chevrolet','USA')";
		}
	
	public static String getAllManufacturers() { 
		
		return  ""
		+ "select * from Manufacturer";
	}
}
