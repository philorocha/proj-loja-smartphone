package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Funcionario;

public interface IRepoFuncionario {

	public void inserirFuncionario(Funcionario funcionario) throws RepoFuncionarioException;

	public ArrayList<Funcionario> pesquisarFuncionarioNome(String nome) throws RepoFuncionarioException;
	
	public Funcionario pesquisarFuncionarioCpf(String cpf) throws RepoFuncionarioException;

	public void excluirFuncionario(Funcionario funcionario) throws RepoFuncionarioException;

}
