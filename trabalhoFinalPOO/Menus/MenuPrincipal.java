package Menus;
import java.util.Scanner;
import Menus.*;

public class MenuPrincipal {
    public static void exibirMenuPrincipal(Scanner sc){
        System.out.println("=".repeat(45));
        System.out.println("     MENU PRINCIPAL     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Fazer login");
        System.out.println("(2) - Realizar cadastro");
        System.out.println("(3) - Visualizar animais disponíveis");
        System.out.println("(4) - Sobre o Sistema");
        System.out.println("(0) - Encerrar Programa" + "\n");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao){
            case 1: 
                MenuLogin.exibirMenuLogin(sc);
                break;
            case 2: 
                MenuCadastro.exibirMenuCadastro(sc);
                break;
            case 3:
                
                break;
            case 4:

                break;
            case 5:

            default:
                System.out.println("Encerrando programa...");
                System.exit(0);
        }
    }
}
