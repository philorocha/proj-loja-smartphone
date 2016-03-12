package br.com.philo.negocio;

import java.util.ArrayList;

import br.com.philo.repositorio.IRepoFuncionario;
import br.com.philo.repositorio.RepoFuncionario;
import br.com.philo.repositorio.RepoFuncionarioException;

public class ControladorFuncionario {
	
	private IRepoFuncionario repoFunc;
	
	public ControladorFuncionario() {
		super();
		this.repoFunc = new RepoFuncionario();
	}

	public void inserirFuncionario(Funcionario funcionario) throws RepoFuncionarioException{
		this.repoFunc.inserirFuncionario(funcionario);
	}
	
	public ArrayList<Funcionario> pesquisarFuncionarioNome(String nome) throws ControladorFuncionarioException, RepoFuncionarioException{
		if(nome.isEmpty()){
			throw new ControladorFuncionarioException("Nome inválido");
		}
		return this.repoFunc.pesquisarFuncionarioNome(nome);
	}
	
	public Funcionario pesquisarFuncionarioCpf(String cpf) throws ControladorFuncionarioException, RepoFuncionarioException{
		if(cpf.isEmpty()){
			throw new ControladorFuncionarioException("CPF inválido");
		}
		return this.repoFunc.pesquisarFuncionarioCpf(cpf);
	}
	
	public void excluirFuncionario(Funcionario funcionario) throws ControladorFuncionarioException, RepoFuncionarioException{
		this.repoFunc.excluirFuncionario(funcionario);
	}	

}
