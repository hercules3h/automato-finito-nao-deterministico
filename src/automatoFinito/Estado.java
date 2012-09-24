package automatoFinito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estado {
	
	private String nome;
	private boolean ehAceitacao = false;
	private boolean ehInicial;
	private Map<Integer, List<Estado>> funcaoTransicao;
	
	public Estado(){
		
	}
	
	public Estado(int indice){
		this.nome = "q"+indice;
		this.funcaoTransicao = new HashMap<Integer, List<Estado>>();
	}		
	
	public boolean getEhInicial() {
		return ehInicial;
	}

	public void setEhInicial(boolean ehInicial) {
		this.ehInicial = ehInicial;
	}

	public List<Estado> executaTransicao(Integer simbolo){
		return this.funcaoTransicao.get(simbolo);
	}
	
	public void adicionaTransicao(int simbolo, Estado proximo){
		if(this.funcaoTransicao.get(simbolo) == null){
			ArrayList<Estado> list = new ArrayList<Estado>();
			list.add(proximo);
			this.funcaoTransicao.put((Integer)simbolo, list);
			return;
		}
		this.funcaoTransicao.get(simbolo).add(proximo);	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getEhAceitacao() {
		return ehAceitacao;
	}

	public void setEhAceitacao(boolean ehFinal) {
		this.ehAceitacao = ehFinal;
	}
	
}
