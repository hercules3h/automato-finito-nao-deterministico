package automatoFinito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutomatoFinito {
	
	private Map<Integer, Estado> estados;
	private List<Estado> folhas;
	private int estadoInicial;
	
	public AutomatoFinito(int estadoInicial, Map<Integer, Estado> estados){
		this.estados = estados;
		this.estadoInicial = estadoInicial;
		this.folhas = new ArrayList<Estado>();
	}
	
	public int verificaCadeia(int[] cadeia){
		
		int resposta = 0;
		Estado estado = estados.get(this.estadoInicial);
		//verificação para o estado inicial
		folhas.add(estado);
		
		List<Estado> proximosEstados = estado.executaTransicao(cadeia[0]);
		folhas.clear();
		folhas = proximosEstados;
		//verificação de transições vazias
		for(Estado aux : proximosEstados){
			List<Estado> transicoesVazias = aux.executaTransicao(0);
			for(Estado aux2 : transicoesVazias){
				folhas.add(aux2);
			}
		}
		
		//verificação para os demais estados
		for(int i = 1; i < cadeia.length && this.folhas != null; i++){
			List<Estado> folhasAux = new ArrayList<Estado>();
			
			for(Estado folha :  folhas){
				proximosEstados = folha.executaTransicao(cadeia[i]);
				folhasAux.addAll(proximosEstados);
				
				for(Estado aux : proximosEstados){
					List<Estado> transicoesVazias = aux.executaTransicao(0);
					for(Estado aux2 : transicoesVazias){
						folhasAux.add(aux2);
					}
				}				
				
			}
			
			folhas.clear();
			folhas =  folhasAux;
		}		
		
		//verificar se algum estado das folhas da árvore é de aceitação
		for(Estado folha : folhas){
			if(folha.getEhAceitacao()){
				resposta = 1;
				break;
			}
		}
		
		return resposta;
	}

}
