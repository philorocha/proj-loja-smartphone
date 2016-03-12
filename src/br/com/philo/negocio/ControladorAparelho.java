package br.com.philo.negocio;

import java.util.ArrayList;

import br.com.philo.repositorio.IRepoAparelho;
import br.com.philo.repositorio.RepoAparelho;
import br.com.philo.repositorio.RepoAparelhoException;

public class ControladorAparelho {
	
	private IRepoAparelho repoAparelho;
	
	public ControladorAparelho() {
		super();
		this.repoAparelho = new RepoAparelho();
	}

	public void incluirAparelho(Aparelho aparelho) throws RepoAparelhoException, ControladorAparelhoException{
		if(aparelho.getArmazenamento() <= 0){
			throw new ControladorAparelhoException("Capacidade de Armazenamento Inv�lido!");
		}else if(aparelho.getCor().isEmpty()){
			throw new ControladorAparelhoException("Cor n�o informada!");
		}else if (aparelho.getModelo().isEmpty()){
			throw new ControladorAparelhoException("Modelo n�o informado!");
		}else if (aparelho.getNumeroSerie().isEmpty()){
			throw new ControladorAparelhoException("N�mero de s�rie n�o informado!");
		}else if (aparelho.getPreco() <= 0){
			throw new ControladorAparelhoException("Valor inv�lido!");
		}		
		this.repoAparelho.incluirAparelho(aparelho);
	}
	
	public ArrayList<Aparelho> pesquisarAparelhoModelo(String modelo) throws RepoAparelhoException, ControladorAparelhoException{
		if(modelo.isEmpty()){
			throw new ControladorAparelhoException("Favor informar o modelo do Aparelho!");
		}
		return this.repoAparelho.pesquisarAparelhoModelo(modelo);
	}
	
	public ArrayList<Aparelho> pesquisarAparelhoPreco(double preco) throws RepoAparelhoException, ControladorAparelhoException{
		if(preco <= 0){
			throw new ControladorAparelhoException("Valor informado inv�lido");
		}
		return this.repoAparelho.pesquisarAparelhoPreco(preco);
	}
	
	public ArrayList<Aparelho> pesquisarAparelhoCor(String cor) throws RepoAparelhoException, ControladorAparelhoException{
		if(cor.isEmpty()){
			throw new ControladorAparelhoException("Favor informar a cor do Aparelho!");
		}
		return this.repoAparelho.pesquisarAparelhoCor(cor);
	}
	
	public ArrayList<Aparelho> pesquisarAparelhoCapacidade(double capacidade) throws RepoAparelhoException, ControladorAparelhoException{
		if(capacidade <= 0){
			throw new ControladorAparelhoException("Valor informado inv�lido");
		}
		return this.repoAparelho.pesquisarAparelhoCapacidade(capacidade);
	}
	
	public Aparelho pesquisarAparelhoNumSerie(String numSerie) throws RepoAparelhoException, ControladorAparelhoException{
		if(numSerie.isEmpty()){
			throw new ControladorAparelhoException("Favor informar o N�mero de S�rie do Aparelho!");
		}
		return this.repoAparelho.pesquisarAparelhoNumSerie(numSerie);
	}
	
	public void excluirAparelho(Aparelho aparelho) throws RepoAparelhoException{
		this.repoAparelho.excluirAparelho(aparelho);
	}

}
