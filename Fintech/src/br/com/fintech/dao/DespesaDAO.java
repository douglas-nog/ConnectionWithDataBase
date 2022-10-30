package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Despesa;

public interface DespesaDAO {
	
public void Cadastrar(Despesa despesa);
	
	public List <Despesa> listar();
	
	public void remover(int codigo);
	
	public Despesa buscaPorCD(int codigoBusca);
	
	public void atualizar(Despesa despesa);	

}
