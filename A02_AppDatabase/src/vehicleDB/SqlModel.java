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
			
		return "" + "INSERT INTO Model (Name,Type,ModelYear,Price)" + "VALUES " + "('Camaro','Coupe',2016,40000),"
				+ "('Tahoe','SUV',2010,75000)," + "('Silverado','Truck',2020,55000),"
				+ "('Corvette','Coupe',1953,5000)," + "('Corvette','Coupe',1954,6500),"
				+ "('Fleetwood','Sedan',1954,20000)," + "('Thunderbird','Sport',1954,9000),"
				+ "('600','MicroCar',1957,8500)," + "('Mini','MicroCar',1959,10000)," + "('Fillmore','Van',1960,5000),"
				+ "('Mini Cooper','MicroCar',1961,8000)," + "('Avanti','Coupe',1960,25000),"
				+ "('Tempest','Automobile',1961,16000)," + "('Grand Prix','Automobile',1962,13000),"
				+ "('Mini Cooper S','MicroCar',1961,9000)," + "('Fairlane','Truck',1965,8000),"
				+ "('Civic','Automobile',1980,7000)," + "('Aries','Coupe',1981,12000),"
				+ "('Celica','Automobile',1982,5000)," + "('RX-7','Sport',1983,3000)";
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
