package br.com.impacta.prateleiradigital.apresentacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.impacta.prateleiradigital.controle.FilmeController;
import br.com.impacta.prateleiradigital.negocio.Filme;

public class SortearFilmeConsole {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** SORTEAR FILME ***");
		System.out.print("GENÊRO: ");
		String genero = scan.nextLine();
		System.out.print("DIRETOR: ");
		String diretor = scan.nextLine();
		System.out.print("NOTA ACIMA DE: ");
		double notaMin = Double.parseDouble(scan.nextLine());
		System.out.print("NUMERO DE VOTOS ACIMA DE: ");
		int votosMin = Integer.parseInt(scan.nextLine());
		scan.close();
		
		FilmeController controller = new FilmeController();
		Filme filmeSorteado = null;
		try {
			filmeSorteado = controller.sortearFilme(genero, diretor, notaMin, votosMin);
			System.out.println("...");
			System.out.printf("Filme %s foi sorteado!", filmeSorteado.getTitulo());
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro Ocorrido", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
