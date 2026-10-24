package QUESTAO6;

import QUESTAO1.Cliente;
import QUESTAO1.ClienteVip;
import QUESTAO2.Produto;
import QUESTAO3.Pagamento;
import QUESTAO4.CarrinhoDeCompras;

public class Pedido {
    Cliente cliente;
    CarrinhoDeCompras carrinho;

    public Pedido(Cliente cliente, CarrinhoDeCompras carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public void finalizar(Pagamento pagamento) {
    double subtotal = carrinho.calcularTotal() + carrinho.calcularFreteTotal();

    if (cliente instanceof ClienteVip vip) {
        subtotal -= subtotal * (vip.getPercentualDesconto() / 100.0);
    }

    double valorFinal = pagamento.calcularValorFinal(subtotal);
    pagamento.exibirComprovante(valorFinal);

    int pontos = (int) (valorFinal / 10.0);
    cliente.adicionarPontos(pontos);
}

}
