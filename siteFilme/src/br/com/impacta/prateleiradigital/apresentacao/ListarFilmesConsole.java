package br.com.impacta.prateleiradigital.apresentacao;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.impacta.prateleiradigital.controle.FilmeController;
import br.com.impacta.prateleiradigital.negocio.Filme;

public class ListarFilmesConsole {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** CONSULTA DE FILMES ***");
		System.out.print("TITULO (PARCIAL): ");
		String titulo = scan.nextLine();
		System.out.print("GÊNERO: ");
		String genero = scan.nextLine();
		System.out.print("ANO (DE): ");
		int anoDe = Integer.parseInt(scan.nextLine());
		System.out.print("ANO (ATE): ");
		int anoAte = Integer.parseInt(scan.nextLine());
		scan.close();
		
		FilmeController controller = new FilmeController();
		try {
			List<Filme> filmes = controller.consultarFilme(titulo, genero, anoDe, anoAte);
			filmes.forEach(System.out::println);
			
			System.out.println("...");
			System.out.println("Filmes consultados com sucesso!");
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Ocorrido", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
