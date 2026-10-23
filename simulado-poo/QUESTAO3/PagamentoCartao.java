package QUESTAO3;

public class PagamentoCartao implements Pagamento{
    private int parcelas;

    public PagamentoCartao(int parcelas){
        this.parcelas = parcelas;
    }

    @Override
    public double calcularValorFinal(double valor){
        return (parcelas <= 3) ? valor : valor * 1.08;
    }

    @Override
    public String getDescricao(){
        return "cartão";
    }
}
