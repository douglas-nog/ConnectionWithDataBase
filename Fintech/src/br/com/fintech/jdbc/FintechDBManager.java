package br.com.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FintechDBManager {
	
	public static Connection obterConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM94522", "160794");
			
			System.out.println("Conectou!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
