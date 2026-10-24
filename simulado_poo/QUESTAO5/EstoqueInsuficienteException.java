package QUESTAO5;

public class EstoqueInsuficienteException extends Exception{
    public EstoqueInsuficienteException(String nomeProduto, int quantidadeDisponivel){
        String mensagem = "Estoque insuficiente para " + nomeProduto + ". Disponível: " + quantidadeDisponivel;
        super(mensagem);
    }
}