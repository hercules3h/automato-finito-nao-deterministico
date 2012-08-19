import java.util.List;
import java.util.Map;

public class Estado {
	
	private String nome;
	private boolean ehAceitacao = false;
	private Map<String, List<Estado>> funcaoTransicao;
	
	public Estado(){
		
	}
	
	public Estado(String indice, Map<String,List<Estado>>funcaoTransicao){
		this.nome = "q"+indice;
		this.funcaoTransicao = funcaoTransicao;
	}	
	
	public Estado(String indice, Map<String,List<Estado>>funcaoTransicao, boolean ehFinal){
		this(indice, funcaoTransicao);
		this.ehAceitacao = ehFinal;
	}
	
	public Estado(Estado aux){
		this.ehAceitacao = aux.ehAceitacao;
		this.funcaoTransicao = aux.funcaoTransicao;
		this.nome = aux.nome;
	}
	
	public List<Estado> executarTransicao(String simbolo){
		return this.funcaoTransicao.get(simbolo);
	}
	
	public void addTransacao(String simbolo, Estado proximo){
		this.funcaoTransicao.get(simbolo).add(proximo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEhAceitacao() {
		return ehAceitacao;
	}

	public void setEhAceitacao(boolean ehFinal) {
		this.ehAceitacao = ehFinal;
	}

	public Map<String, List<Estado>> getFuncaoTransicao() {
		return funcaoTransicao;
	}

	public void setFuncaoTransicao(Map<String, List<Estado>> funcaoTransicao) {
		this.funcaoTransicao = funcaoTransicao;
	}	
}
