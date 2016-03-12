package br.com.philo.ui;

import java.util.ArrayList;

import br.com.philo.negocio.Aparelho;
import br.com.philo.negocio.Cliente;
import br.com.philo.negocio.ControladorAparelho;
import br.com.philo.negocio.ControladorAparelhoException;
import br.com.philo.negocio.ControladorCliente;
import br.com.philo.negocio.ControladorClienteException;
import br.com.philo.negocio.ControladorFuncionario;
import br.com.philo.negocio.ControladorFuncionarioException;
import br.com.philo.negocio.ControladorVendaException;
import br.com.philo.negocio.Funcionario;
import br.com.philo.repositorio.RepoAparelhoException;
import br.com.philo.repositorio.RepoClienteException;
import br.com.philo.repositorio.RepoFuncionarioException;

public class Fachada implements IFachada{
	
	private ControladorAparelho controladorAparelho;
	private ControladorFuncionario controladorFuncionario;
	private ControladorCliente controladorCliente;

	public Fachada() {
		super();
		this.controladorAparelho = new ControladorAparelho();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorCliente = new ControladorCliente();
	}

	@Override
	public void incluirAparelho(Aparelho aparelho) throws RepoAparelhoException, ControladorAparelhoException {
		this.controladorAparelho.incluirAparelho(aparelho);		
	}
	
	@Override
	public ArrayList<Aparelho> pesquisarAparelhoModelo(String modelo) throws RepoAparelhoException, ControladorAparelhoException {
		return this.controladorAparelho.pesquisarAparelhoModelo(modelo);
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoPreco(double preco) throws RepoAparelhoException, ControladorAparelhoException {
		return this.controladorAparelho.pesquisarAparelhoPreco(preco);
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoCor(String cor) throws RepoAparelhoException, ControladorAparelhoException {
		return this.controladorAparelho.pesquisarAparelhoCor(cor);
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoCapacidade(double capacidade) throws RepoAparelhoException, ControladorAparelhoException {
		return this.controladorAparelho.pesquisarAparelhoCapacidade(capacidade);
	}

	@Override
	public Aparelho pesquisarAparelhoNumSerie(String numSerie) throws RepoAparelhoException, ControladorAparelhoException {
		return this.controladorAparelho.pesquisarAparelhoNumSerie(numSerie);
	}

	@Override
	public void excluirAparelho(Aparelho aparelho) throws RepoAparelhoException {
		this.controladorAparelho.excluirAparelho(aparelho);		
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario)	throws RepoFuncionarioException, ControladorFuncionarioException {
		this.controladorFuncionario.inserirFuncionario(funcionario);		
	}

	@Override
	public ArrayList<Funcionario> pesquisarFuncionarioNome(String nome)	throws RepoFuncionarioException, ControladorFuncionarioException {
		return this.controladorFuncionario.pesquisarFuncionarioNome(nome);
	}

	@Override
	public Funcionario pesquisarFuncionarioCpf(String cpf) throws RepoFuncionarioException, ControladorFuncionarioException {
		return this.controladorFuncionario.pesquisarFuncionarioCpf(cpf);
	}

	@Override
	public void excluirFuncionario(Funcionario funcionario)	throws RepoFuncionarioException, ControladorFuncionarioException {
		this.controladorFuncionario.excluirFuncionario(funcionario);		
	}

	@Override
	public void incluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException {
		this.controladorCliente.incluirCliente(cliente);
		
	}

	@Override
	public ArrayList<Cliente> pesquisarClienteNome(String nome)	throws ControladorClienteException, RepoClienteException {
		return this.controladorCliente.pesquisarClienteNome(nome);
	}

	@Override
	public Cliente pesquisarClienteCpf(String cpf) throws ControladorClienteException, RepoClienteException {
		return this.controladorCliente.pesquisarClienteCpf(cpf);
	}

	@Override
	public void excluirCliente(Cliente cliente) throws ControladorClienteException, RepoClienteException {
		this.controladorCliente.excluirCliente(cliente);		
	}

	@Override
	public void realizarVenda(Aparelho aparelho, Cliente cliente, Funcionario funcionario)
			throws ControladorVendaException, RepoAparelhoException, ControladorAparelhoException, ControladorFuncionarioException, RepoFuncionarioException, ControladorClienteException, RepoClienteException {
		this.controladorAparelho.pesquisarAparelhoNumSerie(aparelho.getNumeroSerie());
		this.controladorCliente.pesquisarClienteCpf(cliente.getCpf());
		this.controladorFuncionario.pesquisarFuncionarioCpf(funcionario.getCpf());
		this.controladorAparelho.excluirAparelho(aparelho);
	}

}
