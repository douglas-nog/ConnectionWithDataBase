package br.com.fintech.teste;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.OracleUsuarioDAO;

public class TesteAlteracaoUsuario {

	public static void main(String[] args) {


		OracleUsuarioDAO dao = new OracleUsuarioDAO();
		
//		Usuario usuario = dao.buscaPorCPF("07855659900");
//		
//		usuario.setSobrenome("JAVEIRO");
//		
//		dao.atualizar(usuario);
		
		
		//Alterando usuário com nome errado 
		Usuario usuarioErrado = dao.buscaPorCPF("05687412300");
		
		usuarioErrado.setNome("ANDRÉ");
		
		dao.atualizar(usuarioErrado);

	}

}
