package br.com.impacta.prateleiradigital.apresentacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.impacta.prateleiradigital.controle.FilmeController;
import br.com.impacta.prateleiradigital.negocio.Filme;

public class RemoverFilmeConsole {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** REMOVER FILME ***");
		System.out.print("Titulo: ");
		String titulo = scan.nextLine();
		
		Filme filme = new Filme();
		filme.setTitulo(titulo);
		scan.close();
		
		FilmeController controller = new FilmeController();
		try {
			controller.removerFilme(filme);
			System.out.println("...");
			System.out.println("Filme removido com sucesso!");
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Ocorrido", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
