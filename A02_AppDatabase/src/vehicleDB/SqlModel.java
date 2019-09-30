package vehicleDB;

public class SqlModel {
	/**TODO
	 * 
	 * @return
	 */
	public static String createModelTable() {
		return "create table Model ( "
					+ "ModelID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 101, INCREMENT BY 1) PRIMARY KEY,"
					+ "Name varchar(256),"
					+ "Type varchar(256),"
					+ "ModelYear int,"
					+ "Price int,"
					+ "ManufacturerID int,"
					+ "FOREIGN KEY (ManufacturerID) "
					+ "REFERENCES Manufacturer(ManufacturerID))";
	}
	
	/**TODO
	 * 
	 * @return
	 */
	public static String fillModelTable() { 
			
		return "" + "INSERT INTO Model (Name,Type,ModelYear,Price,ManufacturerID)" + "VALUES " 
				+ "('Camaro','Coupe',2016,40000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Chevrolet')),"
				+ "('Tahoe','SUV',2010,75000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Chevrolet'))," 
				+ "('Silverado','Truck',2020,55000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Chevrolet')),"
				+ "('Corvette','Coupe',1953,5000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Chevrolet'))," 
				+ "('Corvette','Coupe',1954,6500,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Chevrolet')),"
				+ "('Fleetwood','Sedan',1954,20000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Cadillac'))," 
				+ "('Thunderbird','Sport',1954,9000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Ford')),"
				+ "('600','MicroCar',1957,8500,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Fillmore'))," 
				+ "('Mini','MicroCar',1959,10000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Austin'))," 
				+ "('Fillmore','Van',1960,5000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Fillmore')),"
				+ "('Mini Cooper','MicroCar',1961,8000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Austin'))," 
				+ "('Avanti','Coupe',1960,25000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Studebaker')),"
				+ "('Tempest','Automobile',1961,16000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Pontiac'))," 
				+ "('Grand Prix','Automobile',1962,13000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Pontiac')),"
				+ "('Mini Cooper S','MicroCar',1961,9000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Austin'))," 
				+ "('Fairlane','Truck',1965,8000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Ford')),"
				+ "('Civic','Automobile',1980,7000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Honda'))," 
				+ "('Aries','Coupe',1981,12000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Dodge')),"
				+ "('Celica','Automobile',1982,5000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Toyota'))," 
				+ "('RX-7','Sport',1983,3000,(SELECT ManufacturerID FROM Manufacturer WHERE Name = 'Mazda'))";
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
	
	public static String updateModelTable(String field, String newValue, String ID) {
		return "" 
		+ "UPDATE Model SET " + field + " = " + newValue + " WHERE ModelID = " + ID;
	}
	
	public static String queryVehicleIndex() {
		return ""
				+ "SELECT Model.ModelID as Model, Manufacturer.Name as Manufacturer,"
				+ "Model.Name as Model, Model.Type as Model, Model.ModelYear as Model, Model.Price as Model "
				+ "FROM Model "
				+ "INNER JOIN Manufacturer "
				+ "ON Model.ManufacturerID = Manufacturer.ManufacturerID";
	}

}
