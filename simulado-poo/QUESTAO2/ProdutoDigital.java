package QUESTAO2;

public class ProdutoDigital extends Produto{
    private int tamanhoMB;

    public ProdutoDigital(String codigo, String nome, double precoBase, int estoque, int tamanhoMB){
        super(codigo, nome, precoBase, estoque);
        this.tamanhoMB = tamanhoMB;
    }

    public double calcularPrecoFinal(){
        return getPrecoBase() - (getPrecoBase() * 0.05);
    }
}
