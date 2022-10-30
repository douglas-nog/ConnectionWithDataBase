package br.com.fintech.teste;

import br.com.fintech.dao.OracleDespesaDAO;

public class TesteDleteDespesa {

	public static void main(String[] args) {


		OracleDespesaDAO dao = new OracleDespesaDAO();
		
		//Deletando a despesa: "26	05687412300	20	BARZINHO	100	26/10/22		0"
		
		dao.remover(26);

	}

}
