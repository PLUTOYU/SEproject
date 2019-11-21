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
             Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
             System.out.println("�������ݿ������ɹ�");
             String url="jdbc:mysql://localhost:3306/student";//�������ݿ�test��url
             String user="root";//���ݿ���û���
            String password="Shy20190904.";//���ݿ������
             //�������ݿ����ӣ�������Ӷ���conn(�׳��쳣����)
             Connection conn=DriverManager.getConnection(url, user, password);
             System.out.println("�������ݿ�ɹ�");
             //����һ��mysql���
             String sql="insert into count values('С��','123456',22,0)";        
             Statement stmt=conn.createStatement();//����һ��Statement����
             stmt.executeUpdate(sql);//ִ��sql���
             System.out.println("���뵽���ݿ�ɹ�");
             conn.close();
             System.out.println("�ر����ݿ�ɹ�");
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