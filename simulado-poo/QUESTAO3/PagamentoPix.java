package QUESTAO3;

public class PagamentoPix implements Pagamento{
    @Override
    public double calcularValorFinal(double valor){
        return valor * 0.95; // Equivale a 5% de desconto
    }

    @Override 
    public String getDescricao(){
        return "pix";
    }
}
