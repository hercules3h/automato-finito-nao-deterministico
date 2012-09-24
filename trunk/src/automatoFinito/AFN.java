package automatoFinito;

import java.util.ArrayList;
import java.util.List;

public class AFN {
	
	public static void main(String[] args) throws Exception{
		
		LeitorArquivo leitor = new LeitorArquivo("C:\\Users\\Hromenique\\Desktop\\automato.txt");
		int nroAutomatos;
		int nroCadeiasTeste;
		int nroTransicoes;
		int[] cabecalho;
		int[] estadosAceitacao;
		List<Integer[]> transicoes = new ArrayList<Integer[]>();
		AutomatoFinito automato;
		int[] cadeiaTeste;
		int[]resultado;
		
		nroAutomatos = leitor.lerLinhaComoArrayInt()[0];
		
		for(int i=0; i < nroAutomatos; i++){
			cabecalho = leitor.lerLinhaComoArrayInt();
			estadosAceitacao = leitor.lerLinhaComoArrayInt();
			nroTransicoes = cabecalho[2];			
			//Montar o autômato finito não determinístico
			for(int j = 0; j < nroTransicoes; j++){
				transicoes.add(leitor.lerLinhaComoArrayInteger());				
			}
			
			automato = AutomatoUtils.criaAutomato(cabecalho, estadosAceitacao, transicoes);
			
			//Testes
			nroCadeiasTeste = leitor.lerLinhaComoArrayInt()[0];
			resultado = new int[nroCadeiasTeste];
			for(int k = 0; k < nroCadeiasTeste; k++){
				cadeiaTeste = leitor.lerLinhaComoArrayInt();
				resultado[k] = automato.verificaCadeia(cadeiaTeste);				
			}
			
			
			//limpar variáveis
			transicoes = new ArrayList<Integer[]>();
		}
		
		
		
	}

}
