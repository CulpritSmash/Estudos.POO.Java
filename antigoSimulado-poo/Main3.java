//Questão 3

public class Main3{
	public static void main(String[] args){
		Autor3 autor3 = new Autor3("Machado de Assis", "brasileiro");
		Livro3 livro3 = new Livro3("Dom Casmurro", 67, autor3);

		livro3.exibirDetalhes();
	}
}
