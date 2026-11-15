package Menus;
import Cadastros.SessaoLogin;
import Usuarios.*;
import ParteAnimal.*;
import ControleSaude.*;

import java.util.Scanner;

import Exceções.*;

public class MenuLogin{

    public static void exibirMenuLogin(Scanner sc) {
        System.out.println("=".repeat(45));
        System.out.println("     LOGIN     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        SessaoLogin login = new SessaoLogin();
        Usuario usuario = login.realizarLogin(email, senha);

        if(usuario == null){
            throw new LoginInvalidoException("Email ou senha inválidos!");
        }

        if(usuario instanceof Voluntario){
            System.out.println("Ainda em construção...");
            return;
        } else if(usuario instanceof Veterinario){
            Veterinario vet = (Veterinario) usuario;
            MenuVeterinario.exibir();
            int opcao = MenuVeterinario.lerOpcao(sc);

            do{
                switch(opcao){
                    case 1:
                        vet.selecionarAnimal(); // Esse método abre o GUI pra selecionar o animal e lá tem mais opções do que fazer com o animal selecionado 
                    case 2:
                        vet.selecionarAnimal(); // Mesmo caso, mas aqui é esperado atualizar algum tratamento
                    case 3:
                        
                    case 4:


                    case 0:

                }
            } while(opcao != 0);
        } 
    }
}