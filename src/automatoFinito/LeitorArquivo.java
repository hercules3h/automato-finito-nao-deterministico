package automatoFinito;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista<br/>
 * 
 * Classe responsável por ler o arquivo para criação dos autômatos e testes
 *
 */
public class LeitorArquivo {
	
	private File arquivo;
	//leitura de baixo nível (bytes)
	private FileInputStream fs;
	//conversão de bytes para caracteres
	private InputStreamReader ir;
	private BufferedReader br;
	
	public LeitorArquivo(){
		
	}
	
	public LeitorArquivo(String caminho) throws Exception{
		this.arquivo = new File(caminho);
		
		if(!this.arquivo.exists()){
			throw new Exception("Arquivo não encontrado.");		
		}
		
		this.fs = new FileInputStream(arquivo);
		this.ir = new InputStreamReader(fs);
		this.br = new BufferedReader(ir);
	}
	
	public int[] lerLinhaComoArrayInt() throws IOException{
		String linha = this.br.readLine();
		
		if(linha == null){
			return null;
		}
		
		return deStringArrayToIntArray(linha.split(" "));
	}
	
	public Integer[] lerLinhaComoArrayInteger() throws IOException{
		String linha = this.br.readLine();
		
		if(linha == null){
			return null;
		}
		
		return deStringArrayToIntegerArray(linha.split(" "));
	}
	
	private int[] deStringArrayToIntArray(String[] arrayStr){
		 
		int[] retorno = new int[arrayStr.length];
		for(int i = 0; i < arrayStr.length; i++){
			retorno[i] =  Integer.parseInt(arrayStr[i]);
		}
		
		return retorno;
	}
	
	private Integer[] deStringArrayToIntegerArray(String[] arrayStr){
		 
		Integer[] retorno = new Integer[arrayStr.length];
		for(int i = 0; i < arrayStr.length; i++){
			retorno[i] =  Integer.parseInt(arrayStr[i]);
		}
		
		return retorno;
	}
	
	
	
	
	
}
