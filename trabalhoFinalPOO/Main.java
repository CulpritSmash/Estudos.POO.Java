import Menus.*;
import javax.swing.JOptionPane;

import Animais.Animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            MenuPrincipal.exibirMenuPrincipal();
            opcao = sc.nextInt();

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
                    MenuPrincipal.exibirSobre();
                    break;

                default:
                    while(opcao != 0){
                        System.out.println("Erro. Digite uma opção entre 0 e 4: ");
                        opcao = Integer.parseInt(sc.nextLine());
                    }
                    System.out.println("Encerrando programa...");
                    System.exit(0);
            }
        } while (opcao != 0);
        
        sc.close();
    }
}
