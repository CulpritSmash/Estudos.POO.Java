import Menus.*;
import ParteAnimal.Animal;
import Usuarios.Administrador;
import Utilidades.Entradas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        
        System.out.println("Deseja entrar como administrador? (s/n): ");
        char resposta = sc.next().charAt(0);
        
        if(resposta == 's' || resposta == 'S'){
            Administrador admin = new Administrador();
            sc.nextLine();

            do{
                MenuAdmin.exibirMenuAdmin();
                opcao = Entradas.lerOpcao(sc, 0, 5);

                switch(opcao){
                    case 1:
                        admin.gerenciarAnimais(sc, Animal.getAnimais());
                    case 2:
                        
                    case 3:

                    case 4:

                    case 5:

                    case 0:
                }
            } while(opcao != 0);
        } else{
            do{
                MenuPrincipal.exibirMenuPrincipal();
            
                opcao = Entradas.lerOpcao(sc, 0, 4);
                switch(opcao){
                    case 1:
                        MenuLogin.exibirMenuLogin(sc); 
                    case 2:
                        MenuCadastro.exibirMenuCadastro(sc);
                    case 3:
                        for(Animal a : Animal.getAnimaisDisponiveisAdocao()){
                            System.out.println(a.toString());
                        }
                    case 4:
                        MenuPrincipal.exibirSobre();
                    case 0:
                        System.out.println("Encerrando o programa...");
                        return;
                    }
            } while(opcao != 0);
        }

        sc.close();
    }
}
