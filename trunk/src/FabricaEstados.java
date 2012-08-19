import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FabricaEstados {

	private File arquivo;
	//leitura de baixo nível (bytes)
	private FileInputStream fs;
	//conversão de bytes para caracteres
	private InputStreamReader ir;
	private BufferedReader br;
	
	private Map<String,Estado> estados = new TreeMap<String, Estado>();
	private int totalIndices;
	private int quantEstadosAceitacao;
	private String[] indicesEstadosAceitacao;
	private List<String[]> transicoes;
	
	
	public FabricaEstados(String caminhoArqEstados) throws Exception{
		this.arquivo = new File(caminhoArqEstados);
		
		if(!this.arquivo.exists()){
			throw new Exception("Arquivo não encontrado.");		
		}
		
		this.fs = new FileInputStream(arquivo);
		this.ir = new InputStreamReader(fs);
		this.br = new BufferedReader(ir);
	}	
	
	
	public void lerArquivoEntrada(){
		
	}
	
	public void iniciarEstados(){
		criarEstados();
		definirEstadosAceitacao();	
		definirFuncoesTransicao();		
	}
	
	public void criarEstados(){
		Estado aux;
		for(int i=0; i < this.totalIndices; i++){
			aux = new Estado();
			aux.setNome("q"+i);
			this.estados.put(aux.getNome(), aux);
		}		
	}	
	
	public void definirEstadosAceitacao(){
		for(String indice : indicesEstadosAceitacao){
			this.estados.get(indice).setEhAceitacao(true);
		}
	}
	
	public void definirTransicao(String indiceInicio,String simbolo, String indiceFim){
		Estado aux = this.estados.get(indiceInicio);
		Estado proximo = this.estados.get(indiceFim);
		aux.addTransacao(simbolo, proximo);		
	}
	
	public void definirFuncoesTransicao(){
		String indiceInicio;
		String indiceFim;
		String simbolo;
		for(String[] aux : this.transicoes){
			indiceInicio = aux[0];
			indiceFim = aux[1];
			simbolo = aux[2];
			
			definirTransicao(indiceInicio, simbolo, indiceFim);
		}
	}
	

}
