package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Usuario;
import br.com.fintech.jdbc.FintechDBManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection conexao;
	
	@Override
	public void Cadastrar(Usuario usuario) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_USUARIO(NR_CPF, NM_NOME, NM_SOBRENOME, DS_EMAIL, DS_SENHA) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSobrenome());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getSenha());
			
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
			result = stmt.executeQuery();
			
			while(result.next()) {
				String cpf = result.getString("NR_CPF");
				String nome = result.getString("NM_NOME");
				String sobrenome = result.getString("NM_SOBRENOME");
				String email = result.getString("DS_EMAIL");
				String senha = result.getString("DS_SENHA");
				Usuario usuario = new Usuario(cpf, nome, sobrenome, email, senha);
					
				lista.add(usuario);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public void remover(String cpf) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "REMOVE FROM T_USUARIO WHERE NR_CPF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				stmt.close();
				conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	}
	
	@Override
	public Usuario buscaPorCPF(String cpfBusca) {

		PreparedStatement stmt = null;
		Usuario usuario = null;
		ResultSet result = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "SELECT * FROM T_USUARIO WHERE NR_CPF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpfBusca);
			result = stmt.executeQuery();
			
			if(result.next()) {
				String cpf = result.getString("NR_CPF");
				String nome = result.getString("NM_NOME");
				String sobrenome = result.getString("NM_SOBRENOME");
				String email = result.getString("DS_EMAIL");
				String senha = result.getString("DS_SENHA");
				usuario = new Usuario(cpf, nome, sobrenome, email, senha);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
	@Override
	public void atualizar(Usuario usuario) {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_USUARIO SET NM_NOME = ?, NM_SOBRENOME = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE NR_CPF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getCpf());
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
