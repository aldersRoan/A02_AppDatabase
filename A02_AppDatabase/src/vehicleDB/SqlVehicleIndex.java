package vehicleDB;

public class SqlVehicleIndex {
	/**TODO
	 * 
	 * @return
	 */
	public static String createVehicleIndexTable() {
		return "create table VehicleIndex ("
					+ "ManufacturerID int,"
					+ "ModelID int)";
	}
	
	/**TODO
	 * 
	 * @return
	 */
	public static String fillVehicleIndexTable() { 
			
			return  ""
			+ "INSERT INTO VehicleIndex (ManufacturerID,ModelID)"
			+ "VALUES "
			+ "(1, 101),"
			+ "(2, 102),"
			+ "(3, 103)";
		}
	
	public static String getAllVehicles() { 
		
		return  ""
		+ "select * from VehicleIndex";
	}
	
	public static String queryVehicleIndex() {
		return "SELECT Model.id as Model, Manufacturer.Name as Manufacturer"
				+ ", Model.Name as Model, Model.ModelYear as Model, Model.Price as Model "
				+ "FROM VehicleIndex "
				+ "INNER JOIN Manufacturer "
				+ "ON VehicleIndex.ManufacturerID = Manufacturer.id "
				+ "INNER JOIN Model "
				+ "ON VehicleIndex.ModelID = Model.id";
	}
}
