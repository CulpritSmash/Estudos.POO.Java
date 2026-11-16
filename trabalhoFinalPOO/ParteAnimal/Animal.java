package ParteAnimal;
import Exceções.*;
import Usuarios.Veterinario;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String estadoSaude;
    private String dataResgate;
    private String statusAdocao; //DISPONIVEL ou INDISPONIVEL
    private String sexo;
    private double peso;
    private Veterinario vetResponsavel;
    private static int animaisTotais = 0;
    private int id;
    private boolean ativo = true;

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
        this.id = ++animaisTotais;

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

    public String getDataResgate(){
        return dataResgate;
    }

    public String getPorte(){
        return porte;
    }

    public String getEstadoSaude(){
        return estadoSaude;
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

    public Veterinario getVetResponsavel(){
        return vetResponsavel;
    }

    public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setRaca(String raca){ 
        this.raca = raca;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setPorte(String porte){
        this.porte = porte;
    }

    public void setEstadoSaude(String estadoSaude){
        this.estadoSaude = estadoSaude;
    }

    public void setDataResgate(String dataResgate){
        this.dataResgate = dataResgate;
    }

    public void setStatusAdocao(String statusAdocao){
        this.statusAdocao = statusAdocao;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public boolean isAtivo(){
        return ativo;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }

    public static void exibirAnimais(){
        for(Animal a : animais){
            System.out.println(a.toString());
        }
        System.out.println("");
    }

    public static List<Animal> getAnimaisDisponiveisAdocao(){
        List<Animal> animaisDisponiveisAdocao = new ArrayList<>();
        for(Animal a : animais){
            if(a.getStatusAdocao().toLowerCase().equals("disponivel")){
                animaisDisponiveisAdocao.add(a);
            }
        }
        return animaisDisponiveisAdocao;
    }

    @Override
    public String toString(){
        return "ID: " + id + " - " + nome + " (" + especie + ")";
    }
}
