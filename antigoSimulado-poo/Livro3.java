//Questão 3

public class Livro3{
	private String titulo;
	private double preco;
	private Autor3 autor;

	Livro3(String titulo, double preco, Autor3 autor){
		this.titulo = titulo;
		this.preco = preco;
		this.autor = autor;
	}

	public void exibirDetalhes(){
		System.out.println("Título: " + titulo);
		System.out.println("Autor: " + autor.nome);
		System.out.printf("Preço: %.2f%n", preco); 
	}
}
