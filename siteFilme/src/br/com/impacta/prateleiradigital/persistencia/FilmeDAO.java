package br.com.impacta.prateleiradigital.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.prateleiradigital.negocio.Filme;

/**
 * Representa a classe que realiza o procedimento de mapeamento objeto-relacional da classe Filme
 * 
 * @author Diego Sousa
 *
 */
public class FilmeDAO {

	/**
	 * Adiciona um novo filme no repositório de dados
	 * 
	 * @param filme Encapsula os dados do filme a ser inserido no repositório de dados
	 * 
	 * @throws Exception Se alguma falha ocorrer durante a inserção de um filme
	 */
	public void adicionar(Filme filme) throws Exception {
		String query = "INSERT INTO tb_filmes(titulo, diretores, nota, duracao, ano, generos, numVotos, url) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			PreparedStatement insertCMD = conn.prepareStatement(query);
			insertCMD.setString(1, filme.getTitulo());
			insertCMD.setString(2, filme.getDiretores());
			insertCMD.setDouble(3, filme.getNota());
			insertCMD.setInt(4, filme.getDuracao());
			insertCMD.setInt(5, filme.getAno());
			insertCMD.setString(6, filme.getGeneros());
			insertCMD.setInt(7, filme.getNumDeVotos());
			insertCMD.setString(8, filme.getUrl());
			
			insertCMD.execute();
			
		} catch (SQLException e) {
			throw new Exception("Problema ao inserir registro na base de dados! ", e); 
		} finally {
			this.closeConnection(conn);
		}
	}
	
	/**
	 * Realiza uma consulta no repositório de dados baseado nos dados informados
	 * 
	* @param titulo Titulo total ou parcial, podendo ser então apenas uma parte do titulo do filme
	 * @param genero Um dos generos que se enquadra o filme para a busca
	 * @param anoDe Ano inicial de lançamento do filme. (Limite inferior da busca)
	 * @param anoAte Ano final de lançamento do filme. (Limite superior da busca)
	 * 
	 * @return Lista de filmes que atendem ao filtro informado
	 * 
	 * @throws Caso alguma falha ocorra no acesso ao banco de dados
	 * 
	 */
	public List<Filme> consultar(String titulo, String genero, int anoDe, int anoAte) throws Exception {
		String query = "SELECT * FROM tb_filmes WHERE titulo LIKE ? and generos LIKE ?  and ano > ? and ano < ?";
		List<Filme> filmes = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			PreparedStatement selectCMD = conn.prepareStatement(query);
			selectCMD.setString(1, (titulo != null ? '%'+titulo.trim()+'%' : ""));
			selectCMD.setString(2, (genero != null ? '%'+genero.trim()+'%' : ""));
			selectCMD.setInt(3, anoDe);
			selectCMD.setInt(4, anoAte);
			
			ResultSet rs = selectCMD.executeQuery();
			
			while(rs.next()) {
				String tituloFilme = rs.getString("titulo");
				String diretores = rs.getString("diretores");
				double nota = rs.getDouble("nota");
				int duracao = rs.getInt("duracao");
				int ano = rs.getInt("ano");
				String generos = rs.getString("generos");
				int numVotos = rs.getInt("numVotos");
				String url = rs.getString("url");
				
				Filme filme = new Filme(tituloFilme, diretores, nota, duracao, ano, generos, numVotos, url);
				filmes.add(filme);
			}
			
		} catch (SQLException e) {
			throw new Exception("Problemas ao consultar filme!", e);
		} finally {
			this.closeConnection(conn);
		}
		return filmes;
	}

	/**
	 * Remove um filme da base dados
	 * 
	 * @param filme Filme que deve ser removido da base de dados
	 * 
	 * @throws Exceptions caso ocorra falha na comunicação do banco de dados
	 * 
	 */
	public void remover(Filme filme) throws Exception {
		//TODO IMPLEMENTAR O CÓDIGO PARA REMOVER UM FILME
	}

	/**
	 * A patir dos parâmetros informados, seleciona um filme na base de dados que atenda o critério
	 * 
	 * @param genero Genero do filme
	 * @param diretor Diretor do filme
	 * @param notaMin Nota minima estipulada
	 * @param votosMin Quantidade minima de votos
	 * 
	 * @return Lista de filmes que atedam ao critério
	 * 
	 * @throws Exceptions caso ocorra falha na comunicação do banco de dados 
	 * 
	 */
	public List<Filme> consultar(String genero, String diretor, double notaMin, int votosMin) throws Exception {
		//TODO IMPLEMENTAR O CÓDIGO PARA REALIZAR A CONSULTA DE UM SORTEIO
		return null;
	}
	
	private Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/imdb";
		String usuario = "impacta";
		String senha = "impacta";
		
		Connection conn = DriverManager.getConnection(url, usuario, senha);
		
		return conn;
	}
	
	private void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void importar(List<Filme> filmes) throws Exception {
		String query = "INSERT INTO tb_filmes(titulo, diretores, nota, duracao, ano, generos, numVotos, url) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = this.getConnection();
			
			PreparedStatement insertCMD = conn.prepareStatement(query);
			for(Filme filme : filmes) {
					insertCMD.setString(1, filme.getTitulo());
					insertCMD.setString(2, filme.getDiretores());
					insertCMD.setDouble(3, filme.getNota());
					insertCMD.setInt(4, filme.getDuracao());
					insertCMD.setInt(5, filme.getAno());
					insertCMD.setString(6, filme.getGeneros());
					insertCMD.setInt(7, filme.getNumDeVotos());
					insertCMD.setString(8, filme.getUrl());
					
					insertCMD.execute();
			}
			
		} catch (SQLException e) {
			throw new Exception("Problema ao inserir registro na base de dados! ", e); 
		} finally {
			this.closeConnection(conn);
		}
	}
}

















