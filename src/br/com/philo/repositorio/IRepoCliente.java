package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Cliente;
import br.com.philo.negocio.ControladorClienteException;

public interface IRepoCliente {

	void incluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException;

	ArrayList<Cliente> pesquisarClienteNome(String nome) throws ControladorClienteException, RepoClienteException;

	Cliente pesquisarClienteCpf(String cpf) throws ControladorClienteException, RepoClienteException;

	void excluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException;

}
