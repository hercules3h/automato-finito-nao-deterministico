import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FabricaEstados {

	private File arquivo;
	//leitura de baixo n�vel (bytes)
	private FileInputStream fs;
	//convers�o de bytes para caracteres
	private InputStreamReader ir;
	private BufferedReader br;
	
	public FabricaEstados(String caminhoArqEstados) throws Exception{
		this.arquivo = new File(caminhoArqEstados);
		
		if(!this.arquivo.exists()){
			throw new Exception("Arquivo n�o encontrado.");		
		}
		
		this.fs = new FileInputStream(arquivo);
		this.ir = new InputStreamReader(fs);
		this.br = new BufferedReader(ir);
	}
	
	public Estado criarEstado(){
		Estado estado = null;
		
		
		return estado;
		
	}
}
