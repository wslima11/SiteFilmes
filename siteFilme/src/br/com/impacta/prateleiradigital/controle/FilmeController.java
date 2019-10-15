package br.com.impacta.prateleiradigital.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.impacta.prateleiradigital.negocio.Filme;
import br.com.impacta.prateleiradigital.persistencia.FilmeDAO;
import br.com.impacta.prateleiradigital.utilitario.FilmesUtil;

/**
 * Representa o papel do controlador/coordenador para todos os fluxos de neg�cio realacionados ao filme
 * 
 * @author Diego Sousa
 *
 */
public class FilmeController {
	
	FilmeDAO dao = new FilmeDAO();
	/**
	 * Adiciona um novo filme  no cat�logo de filmes
	 * 
	 * @param titulo Titulo do filme
	 * @param diretores Texto contendo os diretores do filme separados por virgula
	 * @param nota Nota m�dia atribu�da ao filme. Deve estar entre 0 e 10 inclusive
	 * @param duracao Dura��o do filme em minutos. Deve ser maior ou igual a zero
	 * @param ano Ano de lan�amento do filme. Deve ser maior ou igual a zero
	 * @param generos Texto contendo os generos do filme separados por virgula
	 * @param numDeVotos Quantidade de votos recebida pelos usu�rios. Deve ser maior ou igual a zero
	 * @param url URL que cont�m mais informa��es do filme, como Trailer, Sinopse e etc.
	 * 
	 * @throws Exception Se alguma falha ocorrer na solicita��o de cria��o de um filme
	 * 
	 */
	public void criarFilme(String titulo, String diretores, double nota, int duracao, int ano,
								String generos, int numDeVotos, String url) throws Exception {
		Filme f = new Filme(titulo, diretores, nota, duracao, ano, generos, numDeVotos, url);
		dao.adicionar(f);
		
	}
	
	/**
	 * Baseado no filtro informado, realiza a consulta de filmes na base dados
	 * 
	 * @param titulo Titulo total ou parcial, podendo ser ent�o apenas uma parte do titulo do filme
	 * @param genero Um dos generos que se enquadra o filme para a busca
	 * @param anoDe Ano inicial de lan�amento do filme. (Limite inferior da busca)
	 * @param anoAte Ano final de lan�amento do filme. (Limite superior da busca)
	 * 
	 * @return Lista de filmes que atendem ao filtro informado
	 * 
	 * @throws Exception caso ocorra uma falha ao consultar filmes na base dados
	 * 
	 */
	public List<Filme> consultarFilme(String titulo, String genero, int anoDe, int anoAte) throws Exception {
		List<Filme> filmes = dao.consultar(titulo, genero, anoDe, anoAte);
		return filmes;
	}
	
	/**
	 * Remove um filme da base de dados
	 * 
	 * @param filme Filme que deve ser removida da base de dados
	 * 
	 * @throws Exception se o filme informado n�o puder ser removido
	 * 
	 */
	public void removerFilme(Filme filme) throws Exception {
		if(filme != null) {
			dao.remover(filme);
		}
	}

	/**
	 * A patir dos par�metros informados, seleciona um filme na base de dados que atenda o crit�rio
	 * 
	 * @param genero Genero do filme
	 * @param diretor Diretor do filme
	 * @param notaMin Nota minima estipulada
	 * @param votosMin Quantidade minima de votos
	 * 
	 * @return Um filme que atenda as restri��es informadas acima
	 * 
	 * @throws Exception Se n�o for posssivel sortear um filme 
	 */
	public Filme sortearFilme(String genero, String diretor, double notaMin, int votosMin) throws Exception {
		List<Filme> filmes = dao.consultar(genero, diretor, notaMin, votosMin);
		Collections.shuffle(filmes);
		
		return filmes.get(0);
	}
	
	/**
	 * Realiza a importa��o de diversos filmes atrav�s de um arquivo CSV
	 * 
	 * @param pathFile Caminho f�sico do arquivo que cont�m os filmes que ser�o inseridos na base de dados
	 * 
	 */
	public void importarFilmes(String pathFile) throws Exception {
		List<Filme> filmes = FilmesUtil.extrairFilmesFromFile(pathFile);
		dao.importar(filmes);
	}
	
}
