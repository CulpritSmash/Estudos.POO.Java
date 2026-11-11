package Menus;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import ParteAnimal.Animal;

public class MenuAdocao{
    public static void exibirAnimaisDisponiveisAdocao(List<Animal> animais){
        int numero = 1;
        for(Animal a : Animal.getAnimais()){
            System.out.println(String.format("%02d", numero) + "  " + a.getNome() + " ".repeat(14) + a.getEspecie() + "  " + a.getIdade() + "  " + a.getStatusAdocao());
        }
        numero++;
    }

    public static void exibirMenuAdocao(Scanner sc, List<Animal> animais){
        System.out.println("/".repeat(45));
        System.out.println("     ANIMAIS DISPONÍVEIS     ");
        System.out.println("/".repeat(45) + "\n");

        System.out.println("-".repeat(45));
        System.out.println("ID" + "  Nome" + " ".repeat(14) + "Espécie" + "  Idade" + "   Status");

        exibirAnimaisDisponiveisAdocao(animais);
    }
}