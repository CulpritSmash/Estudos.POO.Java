package Menus;

import java.util.Scanner;

import ParteAnimal.Animal;
import ControleSaude.*;

public class MenuVeterinario{
    private static final int INDEFINIDA = -1;

    public static void exibir(){
        System.out.println("=".repeat(45));
        System.out.println("     MENU DO VETERINÁRIO     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Consultas de Animais");
        System.out.println("(2) - Registrar Vacinação");
        System.out.println("(3) - Emitir Relatório Médico");
        System.out.println("(4) - Notificações");
        System.out.println("(0) - Sair" + "\n");
    }

    public static int lerOpcao(Scanner sc){
        int opcao = INDEFINIDA;

        do{
            System.out.print("Digite uma opção: ");

            try{
                opcao = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida");
            }

            if(opcao < 0 || opcao > 6) System.out.println("Opção inválida. Digite uma opção entre 0 e 6");
        } while(opcao < 0 || opcao > 6);
        
        return opcao;
    }
}