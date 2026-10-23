package QUESTAO2;
import QUESTAO3.Entregavel;

public class ProdutoFisico extends Produto implements Entregavel{
    private double pesoKg;

    public ProdutoFisico(String codigo, String nome, double precoBase, int estoque, double pesoKg){
        super(codigo, nome, precoBase, estoque);
        this.pesoKg = pesoKg;
    }

    public double calcularPrecoFinal(){
        return getPrecoBase() + (getPrecoBase() * 0.10);
    }

    
    @Override
    public double calcularFrete(){
        return 15 + (2 * pesoKg);
    }

    @Override
    public int prazoEntregaDias(String cep){
        return (cep.startsWith("6")) ? 7 : 12;
    }
}
