package br.com.impacta.prateleiradigital.apresentacao;

import java.util.Scanner;

import br.com.impacta.prateleiradigital.controle.FilmeController;

public class ImportarFilmesConsole {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** IMPORTAR FILMES ***");
		System.out.print("Digite o caminho e nome do arquivo: ");
		String pathFile = scan.nextLine();
		scan.close();
		
		FilmeController controller = new FilmeController();
		try{
			System.out.println("Iniciando a importação de filmes.. AGUARDE..");
			controller.importarFilmes(pathFile);
			System.out.println("...");
			System.out.println("Filmes importados com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao importar filmes! ");
		}
		
		
	}
}
