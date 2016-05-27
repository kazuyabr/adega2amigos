package classes.sql;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;

	public void conectar() {

		
		/*url = "jdbc:mysql://localhost:3306/adega";
		usuario = "root";
		senha = "fox891191";
		*/
		
		url = "jdbc:mysql://localhost:3306/adega";
		usuario = "root";
		senha = ""; 
		
		
		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("conectado ao banco");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não conectou", "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	public void desconecta(){
		
		try {
			 con.close();
			 System.out.println("desconectado ao banco");
			 } catch (SQLException e) {
			 System.out.println(e.getMessage());
			 }
	}

	public Connection getCon() {
		return con;
	}
}