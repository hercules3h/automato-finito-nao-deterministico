package automatoFinito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomatoUtils {
	
	public static AutomatoFinito criaAutomato(int[] cabecalho, int[] estadosAceitacao, List<Integer[]> transicoes){
		
		AutomatoFinito automato;
		Map<Integer, Estado> estados = new HashMap<Integer, Estado>();
		
		//criar estados
		for(int i = 0; i < cabecalho[0]; i++){
			estados.put(i, new Estado(i));
		}
		
		//set estado inicial
		estados.get(cabecalho[3]).setEhInicial(true);
		
		//set estados de Aceitação
		for(int i : estadosAceitacao){
			estados.get(i).setEhAceitacao(true);
		}
		
		//set transições
		for(Integer[] transicao : transicoes){
			int simbolo = transicao[1];			
			Estado origem = estados.get(transicao[0]);
			Estado destino = estados.get(transicao[2]);
			origem.adicionaTransicao(simbolo, destino);
		}
		
		automato = new AutomatoFinito(cabecalho[3], estados);
		return automato;
	}
	
	public static Integer[] deStringArrayToIntegerArray(String[] arrayStr){
			 
		Integer[] retorno = new Integer[arrayStr.length];
		for(int i = 0; i < arrayStr.length; i++){
			retorno[i] =  Integer.parseInt(arrayStr[i]);
		}
		
		return retorno;
	}
	
	
	
	public static List<Estado> ExecutaTransicaoVazia(Estado estado){
		return estado.executaTransicao(0);		
	}

}
