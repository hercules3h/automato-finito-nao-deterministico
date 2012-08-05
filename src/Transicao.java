public class Transicao {
	
	private String valor;
	private Estado proximo;
	
	public Transicao(String valor, Estado estado){
		this.valor = valor;
		this.proximo = estado;
	}
	
	
	public Estado verificarTransicao(String valor){
		if(this.valor.equals(valor)){
			return this.proximo;
		}
		
		return null;
	}
}
