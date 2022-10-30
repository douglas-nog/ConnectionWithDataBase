package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Despesa;
import br.com.fintech.dao.OracleDespesaDAO;

public class TesteListagemDespesa {

	public static void main(String[] args) {


		OracleDespesaDAO dao = new OracleDespesaDAO();
		
		List<Despesa> lista = dao.listar();
			for(Despesa item: lista) {
				System.err.println(item.getCodigo() + " " + item.getCpf() + " " + item.getTipo() + " " +
						item.getDescricao()+ " " + item.getData_despesa().getTime() + " " + item.getValor_despesa() + " " +
						item.getRecorrencia() + " " + item.getQtd_repeticao());
			}
		}

	}


