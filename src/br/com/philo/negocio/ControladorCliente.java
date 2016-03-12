package br.com.philo.negocio;

import java.util.ArrayList;

import br.com.philo.repositorio.IRepoCliente;
import br.com.philo.repositorio.RepoCliente;
import br.com.philo.repositorio.RepoClienteException;

public class ControladorCliente {
	
	private IRepoCliente repoCliente;
	
	public ControladorCliente() {
		super();
		this.repoCliente = new RepoCliente();
	}

	public void incluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException{
		if(cliente.getCpf().isEmpty()){
			throw new ControladorClienteException("CPF Inválido");
		}else if(cliente.getNome().isEmpty()){
			throw new ControladorClienteException("Nome Inválido");
		}
		this.repoCliente.incluirCliente(cliente);
	}

	public ArrayList<Cliente> pesquisarClienteNome(String nome) throws ControladorClienteException, RepoClienteException{
		if(nome.isEmpty()){
			throw new ControladorClienteException("Nome inválido");
		}
		return this.repoCliente.pesquisarClienteNome(nome);
	}

	public Cliente pesquisarClienteCpf(String cpf) throws ControladorClienteException, RepoClienteException{
		if(cpf.isEmpty()){
			throw new ControladorClienteException("CPF inválido");
		}
		return this.repoCliente.pesquisarClienteCpf(cpf);
	}

	public void excluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException{
		this.repoCliente.excluirCliente(cliente);
	}

}
