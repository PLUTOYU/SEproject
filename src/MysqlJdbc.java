import java.sql.*;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlJdbc {
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
		   String sql="insert into count values('4','Tony','tony12345');";        
           Statement stmt=conn.createStatement();//create a Statement object
           stmt.executeUpdate(sql);//execute sql statement
           System.out.println("insert values into database successfully");
           conn.close();
           System.out.println("close database successfully");
		/*   ps = conn.prepareStatement("select * from count;");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("id");
			   String name = rs.getString("name");
			   String password = rs.getString("password");
			   System.out.print(id+"\t"+name+"\t"+ password);
			   System.out.println("");
		   }		*/
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("connect fail");
		}
	}
}
 /* import java.sql.*;

 public class MysqlJdbc {
 
     public static void main(String[] args) {
         try {
             Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
             System.out.println("加载数据库驱动成功");
             String url="jdbc:mysql://localhost:3306/student";//声明数据库test的url
             String user="root";//数据库的用户名
            String password="Shy20190904.";//数据库的密码
             //建立数据库连接，获得连接对象conn(抛出异常即可)
             Connection conn=DriverManager.getConnection(url, user, password);
             System.out.println("连接数据库成功");
             //生成一条mysql语句
             String sql="insert into count values('小别','123456',22,0)";        
             Statement stmt=conn.createStatement();//创建一个Statement对象
             stmt.executeUpdate(sql);//执行sql语句
             System.out.println("插入到数据库成功");
             conn.close();
             System.out.println("关闭数据库成功");
         } catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }//
         catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         
     }
    
 }*/