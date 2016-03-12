package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Aparelho;

public interface IRepoAparelho {

	void incluirAparelho(Aparelho aparelho) throws RepoAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoModelo(String modelo) throws RepoAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoPreco(double preco) throws RepoAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoCor(String cor) throws RepoAparelhoException;

	ArrayList<Aparelho> pesquisarAparelhoCapacidade(double capacidade) throws RepoAparelhoException;

	Aparelho pesquisarAparelhoNumSerie(String numSerie) throws RepoAparelhoException;

	void excluirAparelho(Aparelho aparelho) throws RepoAparelhoException;
	
}
