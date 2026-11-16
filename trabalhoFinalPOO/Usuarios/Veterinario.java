package Usuarios;
import ParteAnimal.Animal;
import ControleSaude.*;
import Guis.*;
import Interfaces.Registravel;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Veterinario extends Usuario{
    public Veterinario(String login, String senha, String nome){
        super(login, senha, nome);
    }
    
    // GUI para selecionar o animal da consulta
    // De lá ele abre a GUI de consulta baseado no animal que foi selecionado
    public void selecionarAnimal(){
        new TelaVetSelecaoAnimal(this, Animal.getAnimais());
    }

    public void emitirRelatorio(Animal animal) {
        StringBuilder texto = new StringBuilder();

        texto.append("===== RELATÓRIO MÉDICO =====\n");
        texto.append("Emitido por: ").append(getNome()).append("\n");
        texto.append("Nome: ").append(animal.getNome()).append("\n");
        texto.append("Espécie: ").append(animal.getEspecie()).append("\n");

        List<Registravel> historico = new ArrayList<>();
        historico.addAll(Consulta.getConsultasDoAnimal(animal));
        historico.addAll(Vacinacao.getVacinacoesDoAnimal(animal));

        texto.append("\n===== Histórico =====\n");
        if (historico.isEmpty()) {
            texto.append("Nenhum registro.\n");
        }
        for (Registravel r : historico) {
            texto.append(r.getData()).append(" ").append(r.getHorario()).append(" - ").append(r.resumo()).append("\n");
        }

        System.out.println(texto);
    }
}
