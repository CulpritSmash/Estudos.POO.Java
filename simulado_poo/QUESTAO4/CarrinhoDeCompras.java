package QUESTAO4;
import java.util.List;
import java.util.ArrayList;
import QUESTAO2.*;
import QUESTAO3.*;
import QUESTAO5.EstoqueInsuficienteException;

public class CarrinhoDeCompras {
    private List<Produto> itens = new ArrayList<>();

    public List<Produto> getItens(){
        return itens;
    }

    public void adicionar(Produto p){
        itens.add(p);
    }
    
    public void adicionar(Produto p, int quantidade) throws EstoqueInsuficienteException{
        if(quantidade > p.getEstoque()){
            throw new EstoqueInsuficienteException(p.getNome(), p.getEstoque());
        }
        
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
