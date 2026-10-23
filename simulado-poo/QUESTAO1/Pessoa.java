package QUESTAO1;

public abstract class Pessoa{
    private String nome, cpf, email;

    public Pessoa(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String toString(){
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}