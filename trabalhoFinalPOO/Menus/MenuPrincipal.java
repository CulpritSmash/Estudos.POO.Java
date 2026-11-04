package Menus;
import java.util.Scanner;
import Animais.Animal;
import Menus.*;

public class MenuPrincipal {
    public static void exibirSobre(){
        System.out.println("\n");
        System.out.println("Sistema de Gerenciamento de Abrigos e Resgates de Animais que está sendo desenvolvido em Java desde 22/10/2026.");
        System.out.println("         /\\    /\\");
        System.out.println("        /==\\__/==\\");
        System.out.println("       /          \\            / \\__");
        System.out.println("      /  @      @  \\          (    @\\___");
        System.out.println("    #=====--o--=====#         /         O");
        System.out.println("      \\     ^     /          /   (_____/");
        System.out.println("       \\_________/          /_____/   U" + "\n");
        System.out.println("Feito pelo estudante Caio Feitosa" + "\n");
        System.out.println("Criado como projeto de faculdade para desenvolver habilidades de Programação Orientada a Objetos (POO).");

    }

    public static void exibirMenuPrincipal(Scanner sc){

        System.out.println("=".repeat(45));
        System.out.println("     MENU PRINCIPAL     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Fazer login");
        System.out.println("(2) - Realizar cadastro");
        System.out.println("(3) - Visualizar animais disponíveis");
        System.out.println("(4) - Sobre o Sistema");
        System.out.println("(0) - Encerrar Programa" + "\n");
        System.out.print("Digite a sua opção: ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao){
            case 1: 
                MenuLogin.exibirMenuLogin(sc);
                break;
            case 2: 
                MenuCadastro.exibirMenuCadastro(sc);
                break;
            case 3:
                MenuAdocao.exibirMenuAdocao(sc, Animal.getAnimais());
                break;
            case 4:
                exibirSobre();
                break;
            case 5:

            default:
                System.out.println("Encerrando programa...");
                System.exit(0);
        }
    }
}
