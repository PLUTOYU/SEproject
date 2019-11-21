import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
	public static void main(String []args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("loading success");
	        } catch (Exception ex) {
	        	System.out.println("loading fail");
	            // handle the error
	        }
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/student?serverTimezone=UTC","root","Shy20190904.");
		   System.out.println("connect successfully");
		   ps = conn.prepareStatement("select * from count;");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("id");
			   String name = rs.getString("name");
			   String password = rs.getString("password");
			   System.out.print(id+"\t"+name+"\t"+ password);
			   System.out.println("");
		   }		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("connect fail");
		}
	}
}

