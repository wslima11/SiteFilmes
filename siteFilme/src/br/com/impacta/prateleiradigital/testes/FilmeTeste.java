package br.com.impacta.prateleiradigital.testes;

import br.com.impacta.prateleiradigital.negocio.Filme;

public class FilmeTeste {
	public static void main(String[] args) {
		Filme f1 = new Filme();
		System.out.println(f1);
		
		f1.setTitulo("Corra");
		f1.setDiretores("Jordan Peele");
		f1.setNota(-9.0);
		f1.setDuracao(-120);
		f1.setAno(1800);
		f1.setGeneros("Suspense");
		f1.setNumDeVotos(-85438);
		f1.setUrl("www.corra.com.br");
		System.out.println(f1);
		
		Filme f2 = new Filme("Avatar", "James Cameron", -8.7, -155, 1800, "Aventura", -125546, "www.avatar.com.br");
		System.out.println(f2);
	}
}
