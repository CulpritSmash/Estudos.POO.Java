package Menus;
import Cadastros.SessaoLogin;
import Usuarios.*;

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

        if(usuario instanceof Voluntario){
            System.out.println("Ainda em construção...");
            return;
        } else if(usuario instanceof Veterinario){
            MenuVeterinario.exibir();
            MenuVeterinario.lerOpcao(sc);
        }
    }
}