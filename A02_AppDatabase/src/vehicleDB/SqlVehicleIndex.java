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
			+ "(3, 101),"
			+ "(3, 102),"
			+ "(3, 103),"
			+ "(3, 104),"
			+ "(3, 105),"
			+ "(5, 106),"
			+ "(1, 107),"
			+ "(7, 108),"
			+ "(6, 109),"
			+ "(7, 110),"
			+ "(6, 111),"
			+ "(8, 112),"
			+ "(9, 113),"
			+ "(9, 114),"
			+ "(6, 115),"
			+ "(1, 116),"
			+ "(2, 117),"
			+ "(10, 118),"
			+ "(11, 119),"
			+ "(12, 120)";
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
	
	public static String deleteVehicleIndex() { 
		
		return  ""
		+ "drop table VehicleIndex";
	}
}
