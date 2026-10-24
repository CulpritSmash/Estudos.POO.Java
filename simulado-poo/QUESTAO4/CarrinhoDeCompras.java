package QUESTAO4;
import java.util.List;
import java.util.ArrayList;
import QUESTAO2.*;
import QUESTAO3.*;

public class CarrinhoDeCompras {
    List<Produto> itens = new ArrayList<>();

    public void adicionar(Produto p){
        itens.add(p);
    }

    public void adicionar(Produto p, int quantidade){
        for(int i = 1; i <= quantidade; i++){
            itens.add(p);
        }
    }

    public double calcularTotal(){
        double total = 0;

        for(Produto p : itens){
            total += p.calcularPrecoFinal();
        }

        return total;
    }

    public double calcularFreteTotal(){
        double freteTotal = 0;

        for(Produto p : itens){
            if(p instanceof Entregavel){
                ProdutoFisico q = (ProdutoFisico) p;
                freteTotal += q.calcularFrete();
            }
        }

        return freteTotal;
    }
}
