import java.util.List;

public class Estado {
	
	private String nome;
	private boolean ehFinal = false;
	private List<Transicao> transicoes;
	
	public Estado(String indice, List<Transicao> funcoesTransicao){
		this.nome = "q"+indice;
		this.transicoes = funcoesTransicao;
	}	
}
