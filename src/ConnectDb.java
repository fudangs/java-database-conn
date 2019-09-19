import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectDb {
	private static String[][] vets;
	public static Connection dbConn () {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC","root","");
			return con;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e, "Erro ao conectar ao banco de dados", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	public static void closeConn (Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "Erro ao conectar fechar a conexão do banco de dados", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static int auth (String u, String s) throws SQLException{
		int r = 0;
		Connection conn = ConnectDb.dbConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id FROM usuario WHERE login = '"+u+"' AND senha = MD5('"+s+"')");
		if(rs.next()) {
			r = rs.getInt(1);
		}
		ConnectDb.closeConn(conn);
		return r;
	}
	public static String getNome(int u) throws SQLException{
		Connection conn = ConnectDb.dbConn();
		ResultSet rs = null;
		String r = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT nome FROM usuario WHERE id = "+Integer.toString(u));
		}catch(SQLException e) {
			r = null;
			System.out.println(e.getMessage());
		}	
		if(rs.next()) {
			r = rs.getString(1);
		}
		ConnectDb.closeConn(conn);
		return r;
	}
	public static boolean newUsuario(String u, String s, String n) {
		Connection conn = ConnectDb.dbConn();
		boolean r = false;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario (login, nome, senha) VALUES (?, ?, MD5(?))");
			stmt.setString(1, u);
			stmt.setString(2, n);
			stmt.setString(3, s);
			if(stmt.execute()) {
				r = true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		ConnectDb.closeConn(conn);
		return r;
	}
	public static String[][] getUsers() throws SQLException{
		Connection conn = ConnectDb.dbConn();
		ResultSet rs = null;
		String u;
		String n;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT login, nome FROM usuario");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}	
		vets = null;
		int i = 0;
		if(rs.next()) {
			u = rs.getString(1);
			n = rs.getString(2);
			vets[i][0] = u;
			vets[i][1] = n;
		}
		ConnectDb.closeConn(conn);
		return vets;
	}
}
