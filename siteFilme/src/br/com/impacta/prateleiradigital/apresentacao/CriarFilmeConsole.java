package br.com.impacta.prateleiradigital.apresentacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.impacta.prateleiradigital.controle.FilmeController;

public class CriarFilmeConsole {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** CADASTRO DE NOVO FILME ***");
		System.out.print("TITULO: ");
		String titulo = scan.nextLine();
		System.out.print("DIRETORES: ");
		String diretores = scan.nextLine();
		System.out.print("NOTA [0 a 10]: ");
		double nota = Double.parseDouble(scan.nextLine());
		System.out.print("DURAÇÃO (MINUTOS): ");
		int duracao = Integer.parseInt(scan.nextLine());
		System.out.println("ANO: ");
		int ano = Integer.parseInt(scan.nextLine());
		System.out.print("GENEROS: ");
		String generos = scan.nextLine();
		System.out.print("NÚMERO DE VOTOS: ");
		int numDeVotos = Integer.parseInt(scan.nextLine());
		System.out.println("URL: ");
		String url = scan.nextLine();
		scan.close();
		
		FilmeController controller = new FilmeController();
		
		try {
			controller.criarFilme(titulo, diretores, nota, duracao, ano, generos, numDeVotos, url);
			System.out.println("...");
			System.out.println("Filme criado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ocorrido", JOptionPane.ERROR_MESSAGE);
		}
	}
}
