package ControleSaude;
import ParteAnimal.*;
import Usuarios.Veterinario;

import java.util.List;
import java.util.ArrayList;

public class Vacinacao {
    private static final List<Vacinacao> registroVacinacoes = new ArrayList<>();

    String data;
    String horario;
    String vacinaAplicada;
    private final Animal vacinado;
    private Veterinario vet;

    public Vacinacao(String data, String horario, String vacinaAplicada, Animal animal, Veterinario vet){
        this.data = data;
        this.horario = horario;
        this.vacinaAplicada = vacinaAplicada;
        this.vacinado = animal;
        this.vet = vet;
        registroVacinacoes.add(this);
    }

    public static List<Vacinacao> getVacinacoesDoAnimal(Animal animal){
        List<Vacinacao> resultado = new ArrayList<>();
        for(Vacinacao v : registroVacinacoes){
            if(v.vacinado == animal) resultado.add(v);
        }
        return resultado;
    }

    @Override 
    public String toString(){
        return data + " às " + horario + " - " + vacinaAplicada;
    }
}
