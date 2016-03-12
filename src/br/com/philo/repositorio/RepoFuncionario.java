package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Funcionario;

public class RepoFuncionario implements IRepoFuncionario{
	
	private ArrayList<Funcionario> listaFunc = new ArrayList<Funcionario>();

	public RepoFuncionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) throws RepoFuncionarioException{
		if(funcionarioExiste(funcionario)){
			throw new RepoFuncionarioException("Funcionário já cadastrado para este CPF!");
		}
		listaFunc.add(funcionario);		
	}

	@Override
	public ArrayList<Funcionario> pesquisarFuncionarioNome(String nome) throws RepoFuncionarioException {
		ArrayList<Funcionario> listaF = new ArrayList<Funcionario>();
		
		for (int i = 0; i < listaFunc.size(); i++) {
			Funcionario f = listaFunc.get(i);
			
			if(f.getNome() == nome){
				listaF.add(f);
			}
			
			if(listaF.isEmpty()){
				throw new RepoFuncionarioException("Nenhum funcionário encontrado");
			}			
		}
		return listaF;		
	}

	@Override
	public Funcionario pesquisarFuncionarioCpf(String cpf) throws RepoFuncionarioException {
		Funcionario returnFunc = null;
		
		for (int i = 0; i < listaFunc.size(); i++) {
			Funcionario f = listaFunc.get(i);
			
			if(f.getCpf() == cpf){
				returnFunc = f;
			}
		}
		if(returnFunc == null){
			throw new RepoFuncionarioException("Funcionário não encontrado para este CPF");
		}
		return returnFunc;
	}
	
	@Override
	public void excluirFuncionario(Funcionario funcionario) throws RepoFuncionarioException {
		if(!funcionarioExiste(funcionario)){
			throw new RepoFuncionarioException("Funcionário não encontrado");
		}
		listaFunc.remove(funcionario);
	}
	
	public boolean funcionarioExiste(Funcionario func){
		boolean funcExiste = false;
		
		for (int i = 0; i < listaFunc.size(); i++) {
			Funcionario funcionario = listaFunc.get(i);
			
			if(funcionario.getCpf() == func.getCpf()){
				funcExiste = true;
			}			
		}
		return funcExiste;
	}

}
