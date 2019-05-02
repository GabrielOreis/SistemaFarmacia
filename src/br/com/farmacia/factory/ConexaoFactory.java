package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC";
	//jdbc:mysql://localhost/SistemaLogin?useTimezone=true&serverTimezone=UTC
	
	public static Connection conectar() throws SQLException {
	
		//Referencia ao drive mysql
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			
		Connection conexao = ConexaoFactory.conectar();
		System.out.println("Conexão realizada");
		}catch(SQLException e ) {
			System.out.println("Erro de conexão ");
			e.printStackTrace();
		}
	}

}
