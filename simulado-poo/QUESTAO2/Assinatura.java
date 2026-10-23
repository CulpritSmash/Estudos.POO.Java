package QUESTAO2;

public class Assinatura extends Produto{
    private int meses;

    public Assinatura(String codigo, String nome, double precoBase, int estoque, int meses){
        super(codigo, nome, precoBase, estoque);
        this.meses = meses;
    }

    public double calcularPrecoFinal(){   // 90% do valor corresponde a um desconto de 10%
        return (meses >= 6) ? (getPrecoBase() * meses) * 0.90 : (getPrecoBase() * meses);
    }
}
