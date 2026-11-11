import Menus.*;
import ParteAnimal.Animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do{
            MenuPrincipal.exibirMenuPrincipal();
            
            try{
                opcao = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Erro. Digite um número entre 0 e 4.");
                continue;
            }

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
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção entre 0 e 4.");
            }
        } while (opcao != 0);
        
        sc.close();
    }
}
