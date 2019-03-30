import java.sql.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC","root","");  
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from alguem_me_mata_pfvr");  
				while(rs.next())  
					System.out.println("id = "+rs.getInt(1)
				+"  descricao = "+rs.getString(2));  
			con.close();  
		}catch(Exception e) {
			System.out.println("catch");
			System.out.println(e.getMessage());
		}
	}

}