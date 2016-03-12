package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Cliente;

public class RepoCliente implements IRepoCliente{
	
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public RepoCliente() {
		super();
	}

	@Override
	public void incluirCliente(Cliente cliente) throws RepoClienteException {
		if(clienteExiste(cliente)){
			throw new RepoClienteException("Cliente já cadastrado para este CPF");
		}
		this.listaClientes.add(cliente);
	}

	@Override
	public ArrayList<Cliente> pesquisarClienteNome(String nome)	throws RepoClienteException {
		ArrayList<Cliente> cliList = new ArrayList<Cliente>();
		
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			
			if(c.getNome() == nome){
				cliList.add(c);
			}
		}
		if(cliList.isEmpty()){
			throw new RepoClienteException("Nenhum Cliente encontrado");
		}		
		return cliList;
	}

	@Override
	public Cliente pesquisarClienteCpf(String cpf) throws RepoClienteException {
		Cliente cli = null;
		
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			
			if(c.getCpf() == cpf){
				cli = c;
			}
		}
		if(cli == null){
			throw new RepoClienteException("Nenhum Cliente encontrado para este CPF");
		}		
		return cli;
	}

	@Override
	public void excluirCliente(Cliente cliente) throws RepoClienteException {
		if(!clienteExiste(cliente)){
			throw new RepoClienteException("Cliente não encontrado!");
		}
		listaClientes.remove(cliente);
	}

	public boolean clienteExiste(Cliente cliente){
		boolean cliExiste = false;
		
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = listaClientes.get(i);
			
			if(c.getCpf() == cliente.getCpf()){
				cliExiste = true;
			}
		}
		return cliExiste;		
	}

}
