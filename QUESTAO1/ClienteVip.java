package QUESTAO1;

public class ClienteVip extends Cliente{
    private double percentualDesconto;

    public ClienteVip(String nome, String cpf, String email, String endereco, double percentualDesconto){
        super(nome, cpf, email, endereco);
        this.percentualDesconto = percentualDesconto;
    }

    @Override 
    public String toString(){
        return super.toString() +  " | VIP (" + (percentualDesconto * 100) + "%)";
    }
}
