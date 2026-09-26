//Questão 2

public class Retangulo{
	private double largura;
	private double altura;

	public Retangulo(){
		largura = 1.0;
		altura = 1.0;
	}

	public Retangulo(double largura, double altura){
		this.largura = largura;
		this.altura = altura;
	}

	public double getAltura(){
		return altura;
	}

	public double getLargura(){
		return largura;
	}

	public void setAltura(double altura){
		this.altura = altura;
	}

	public void setLargura(double largura){
		this.largura = largura;
	}

	public double calcularArea(){
		return largura * altura;
	}

	public boolean isQuadrado(){
		return altura == largura;
	}

	public static void main(String[] args){
		Retangulo r1 = new Retangulo(5.0, 5.0);
		r1.isQuadrado();

		System.out.println("Área: " + r1.calcularArea());
	}
}
