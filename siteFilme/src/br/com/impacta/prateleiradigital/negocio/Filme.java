package br.com.impacta.prateleiradigital.negocio;

import java.util.Calendar;

/**
 * Classe que representa o conceito de Filme dentro do domínio do negócio da aplicação desenvolvida
 * 
 * @author Diego Sousa
 *
 */
public class Filme {
	public static final int NOTA_MIN = 0;
	public static final int NOTA_MAX = 10;
	public static final int ANO_ATUAL = Calendar.getInstance().get(Calendar.YEAR);
	
	
	private String titulo;
	private String diretores;
	private double nota;
	private int duracao;
	private int ano;
	private String generos;
	private int numDeVotos;
	private String url;
	
	public Filme() {}

	/**
	 * Construtor que recebe os dados dos atributos da classe Filme
	 * 
	 * @param titulo Titulo do filme
	 * @param diretores Texto contendo os diretores do filme separados por virgula
	 * @param nota Nota média atribuída ao filme. Deve estar entre 0 e 10 inclusive
	 * @param duracao Duração do filme em minutos. Deve ser maior ou igual a zero
	 * @param ano Ano de lançamento do filme. Deve ser maior ou igual a zero
	 * @param generos Texto contendo os generos do filme separados por virgula
	 * @param numDeVotos Quantidade de votos recebida pelos usuários. Deve ser maior ou igual a zero
	 * @param url URL que contém mais informações do filme, como Trailer, Sinopse e etc.
	 */
	public Filme(String titulo, String diretores, double nota, int duracao, int ano, 
															String generos, int numDeVotos, String url) {
		super();
		setTitulo(titulo);
		setDiretores(diretores);
		setNota(nota);
		setDuracao(duracao);
		setAno(ano);
		setGeneros(generos);
		setNumDeVotos(numDeVotos);
		setUrl(url);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretores() {
		return diretores;
	}

	public void setDiretores(String diretores) {
		this.diretores = diretores;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		if(nota >= NOTA_MIN && nota <= NOTA_MAX) {
			this.nota = nota;
		}
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		if(duracao > 0) {
			this.duracao = duracao;
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if(ano >= 1895 && ano <= ANO_ATUAL) {
			this.ano = ano;
		}
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public int getNumDeVotos() {
		return numDeVotos;
	}

	public void setNumDeVotos(int numDeVotos) {
		if(numDeVotos >= 0) {
			this.numDeVotos = numDeVotos;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", diretores=" + diretores + ", nota=" + nota + ", "
				+ "duracao=" + duracao + ", ano=" + ano + ", generos=" + generos + ", "
				+ "numDeVotos=" + numDeVotos + ", url=" + url + "]";
	}
}
