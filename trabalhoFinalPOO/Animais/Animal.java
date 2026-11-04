package Animais;
import java.util.List;
import java.util.ArrayList;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String estadoSaude;
    private String dataResgate;
    private String statusAdocao;
    private int id;

    private static List<Animal> animais = new ArrayList<>();

    public Animal(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.estadoSaude = estadoSaude;
        this.dataResgate = dataResgate;
        this.statusAdocao = statusAdocao;

        
        animais.add(this);
    }

    public static List<Animal> getAnimais(){
        return animais;
    }

    public String getStatusAdocao(){
        return statusAdocao;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getEspecie(){
        return especie;
    }

}
