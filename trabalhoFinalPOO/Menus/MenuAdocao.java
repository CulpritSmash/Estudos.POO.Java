package Menus;

import Animais.Animal;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdocao{

    public static void exibirAnimaisDisponiveisAdocao(List<Animal> animais){
        int numero = 0;
        for(Animal animal : animais){
            if(animal.getStatusAdocao().toLowerCase().equals("disponivel")){
                System.out.println(String.format("%02d", numero) + "  " + animal.getNome() + " ".repeat(14) + animal.getEspecie() + "  " + animal.getIdade() + "  " + animal.getStatusAdocao());
            }
        }
        System.out.println("-".repeat(45));
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