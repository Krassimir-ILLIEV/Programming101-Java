package CompanyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/OurCompany";
			c = DriverManager.getConnection(url, "postgres", "admin");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return c;
	}

	public static void main(String[] args) {
		Connection cDB = getConnection();
	
		if (cDB != null) {
		
			Statement st = null;
			String sql = "SELECT * from \"Employees\""
					+ " where department_id=1"; 
			try {
				st = cDB.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				//System.out.println(rs.getRow());
				while (rs.next()) {
					String name = rs.getString("name");
					int employee_id = rs.getInt("employee_id");
					int department_id=rs.getInt("department_id");
				System.out.println("name: "+name);
				System.out.println("employee_id: "+employee_id);
				System.out.println("department_id: "+department_id);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
