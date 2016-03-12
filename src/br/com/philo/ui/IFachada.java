package br.com.philo.ui;

import java.util.ArrayList;

import br.com.philo.negocio.Aparelho;
import br.com.philo.negocio.Cliente;
import br.com.philo.negocio.ControladorAparelhoException;
import br.com.philo.negocio.ControladorClienteException;
import br.com.philo.negocio.ControladorFuncionarioException;
import br.com.philo.negocio.ControladorVendaException;
import br.com.philo.negocio.Funcionario;
import br.com.philo.repositorio.RepoAparelhoException;
import br.com.philo.repositorio.RepoClienteException;
import br.com.philo.repositorio.RepoFuncionarioException;

public interface IFachada {

	void incluirAparelho(Aparelho aparelho) throws RepoAparelhoException, ControladorAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoModelo(String modelo) throws RepoAparelhoException, ControladorAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoPreco(double preco) throws RepoAparelhoException, ControladorAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoCor(String cor) throws RepoAparelhoException, ControladorAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoCapacidade(double capacidade) throws RepoAparelhoException, ControladorAparelhoException;

	Aparelho pesquisarAparelhoNumSerie(String numSerie) throws RepoAparelhoException, ControladorAparelhoException;

	void excluirAparelho(Aparelho aparelho) throws RepoAparelhoException;

	void inserirFuncionario(Funcionario funcionario) throws RepoFuncionarioException, ControladorFuncionarioException;

	ArrayList<Funcionario> pesquisarFuncionarioNome(String nome) throws RepoFuncionarioException, ControladorFuncionarioException;

	Funcionario pesquisarFuncionarioCpf(String cpf) throws RepoFuncionarioException, ControladorFuncionarioException;

	void excluirFuncionario(Funcionario funcionario) throws RepoFuncionarioException, ControladorFuncionarioException;

	void incluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException;

	ArrayList<Cliente> pesquisarClienteNome(String nome) throws ControladorClienteException, RepoClienteException;

	Cliente pesquisarClienteCpf(String cpf) throws ControladorClienteException, RepoClienteException;

	void excluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException;
	
	void realizarVenda(Aparelho aparelho, Cliente cliente, Funcionario funcionario) throws ControladorVendaException, RepoAparelhoException, ControladorAparelhoException, ControladorFuncionarioException, RepoFuncionarioException, ControladorClienteException, RepoClienteException;

}
