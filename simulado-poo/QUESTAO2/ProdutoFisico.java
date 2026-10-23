package QUESTAO2;

public class ProdutoFisico extends Produto{
    private double pesoKg;

    public ProdutoFisico(String codigo, String nome, double precoBase, int estoque, double pesoKg){
        super(codigo, nome, precoBase, estoque);
        this.pesoKg = pesoKg;
    }

    public double calcularPrecoFinal(){
        return getPrecoBase() + (getPrecoBase() * 0.10);
    }
}
