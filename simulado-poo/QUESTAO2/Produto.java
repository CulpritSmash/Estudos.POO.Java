package QUESTAO2;

public abstract class Produto {
    private String codigo, nome;
    private double precoBase;
    private int estoque;

    public Produto(String codigo,  String nome, double precoBase, int estoque){
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.estoque = estoque;
    }

    public double getPrecoBase(){
        return precoBase;
    }

    public abstract double calcularPrecoFinal();

    public String exibirResumo(){
        return codigo + " - " + nome + ": R$" + calcularPrecoFinal();
    }

    public void baixarEstoque(int quantidade){
        estoque -= quantidade;
    }
}
