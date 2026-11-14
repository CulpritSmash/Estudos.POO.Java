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
                        vet.selecionarAnimal(); // Esse método abre o GUI pra selecionar o animal da consulta e de lá ele abre 
                    case 2:

                    case 3:

                    case 4:

                    case 5: 

                    case 6:

                    case 0:

                }
            } while(opcao != 0);
        } 
    }
}