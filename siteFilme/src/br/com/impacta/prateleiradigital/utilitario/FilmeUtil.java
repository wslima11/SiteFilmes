package br.com.impacta.prateleiradigital.utilitario;

import java.util.ArrayList;
import java.util.List;

import br.com.impacta.prateleiradigital.negocio.Filme;

/**
 * Representa a classe utilitária que apoia a classe Filme para atividades específicas
 * 
 * @author Diego Sousa
 *
 */
public class FilmeUtil {
	
	/**
	 * Gera uma quantidade determinada de filmes fake para gerar massa de testes
	 * 
	 * @param quantidade Determina a quantiadde de filmes gerados para o array
	 * 
	 * @return Array com a quantidade de filmes determinada pelo parametro informado
	 */
	public static List<Filme> gerarFilmesFake(int quantidade) {
		List<Filme> filmes = new ArrayList<>();
		
		for (int i = 0; i < quantidade; i++) {
			filmes.add(new Filme("Titulo - " + i,
									"Diretor - " +  i , 
										i+1, i+1*2, 1895+i, "Generos - " + i, 
																500 + i, "www.filme"+i+".com.br"));
		}
		return filmes;
	}

}
