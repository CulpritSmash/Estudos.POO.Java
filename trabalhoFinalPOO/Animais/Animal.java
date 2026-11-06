package Animais;
import ControleSaude.InformacoesMedicas;
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
    private String sexo;
    private double peso;
    private InformacoesMedicas dadosMedicos;

    private static List<Animal> animais = new ArrayList<>();

    public Animal(String nome, String especie, String raca, int idade, String porte, String estadoSaude, String dataResgate, String statusAdocao, String sexo, double peso){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.estadoSaude = estadoSaude;
        this.dataResgate = dataResgate;
        this.statusAdocao = statusAdocao;
        this.sexo = sexo;
        this.peso = peso;

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

    public String getSexo(){
        return sexo;
    }

    public String getRaca(){
        return raca;
    }

    public double getPeso(){
        return peso;
    }
}
