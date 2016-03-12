package br.com.philo.repositorio;

import java.util.ArrayList;

import br.com.philo.negocio.Aparelho;

public class RepoAparelho implements IRepoAparelho{
	
	private ArrayList<Aparelho> listaAparelho = new ArrayList<Aparelho>();

	public RepoAparelho() {
		super();
		
	}

	@Override
	public void incluirAparelho(Aparelho aparelho) throws RepoAparelhoException{
		if(aparelhoExiste(aparelho)){
			throw new RepoAparelhoException("Número de Série já cadastrado!");
		}
		listaAparelho.add(aparelho);
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoModelo(String modelo) throws RepoAparelhoException{
		ArrayList<Aparelho> listaAp = new ArrayList<Aparelho>();

		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho ap = listaAparelho.get(i);

			if(ap.getModelo() == modelo){
				listaAp.add(ap);				
			}			
		}
		if (listaAp.isEmpty()){
			throw new RepoAparelhoException("Nenhum aparelho encontrado!");
		}
		return listaAp;
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoPreco(double preco) throws RepoAparelhoException {
		ArrayList<Aparelho> listaAp = new ArrayList<Aparelho>();
		
		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho ap = listaAparelho.get(i);
			
			if(ap.getPreco() == preco){
				listaAp.add(ap);				
			}			
		}
		if (listaAp.isEmpty()){
			throw new RepoAparelhoException("Nenhum aparelho encontrado!");
		}
		return listaAp;
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoCor(String cor) throws RepoAparelhoException{
		ArrayList<Aparelho> listaAp = new ArrayList<Aparelho>();
		
		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho ap = listaAparelho.get(i);
			
			if(ap.getCor() == cor){
				listaAp.add(ap);				
			}			
		}
		if (listaAp.isEmpty()){
			throw new RepoAparelhoException("Nenhum aparelho encontrado!");
		}
		return listaAp;
	}

	@Override
	public ArrayList<Aparelho> pesquisarAparelhoCapacidade(double capacidade) throws RepoAparelhoException {
		ArrayList<Aparelho> listaAp = new ArrayList<Aparelho>();

		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho ap = listaAparelho.get(i);

			if(ap.getArmazenamento() == capacidade){
				listaAp.add(ap);				
			}			
		}
		if (listaAp.isEmpty()){
			throw new RepoAparelhoException("Nenhum aparelho encontrado!");
		}
		return listaAp;
	}

	@Override
	public Aparelho pesquisarAparelhoNumSerie(String numSerie) {
		Aparelho returnAparelho = null;
		
		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho aparelho = listaAparelho.get(i);
			
			if(aparelho.getNumeroSerie() == numSerie){
				returnAparelho = aparelho;
			}
		}
		return returnAparelho;
	}

	@Override
	public void excluirAparelho(Aparelho aparelho) throws RepoAparelhoException{
		if(!aparelhoExiste(aparelho)){
			throw new RepoAparelhoException("Aparelho não existe!");
		}
		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho ap = listaAparelho.get(i);
			
			if(ap.getNumeroSerie() == aparelho.getNumeroSerie()){
				listaAparelho.remove(ap);
				break;
			}
		}		
	}
	
	public boolean aparelhoExiste(Aparelho aparelho){
		boolean aparelhoExiste = false;
		
		for (int i = 0; i < listaAparelho.size(); i++) {
			Aparelho aparelho1 = listaAparelho.get(i);
			
			if(aparelho1.getNumeroSerie() == aparelho.getNumeroSerie()){
				aparelhoExiste = true;
			}
		}
		return aparelhoExiste;	
	}

}
