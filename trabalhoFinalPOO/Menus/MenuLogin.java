package Menus;

import java.util.Scanner;

public class MenuLogin {

    public static void exibirMenuLogin(Scanner sc) {
        System.out.println("=".repeat(45));
        System.out.println("     LOGIN     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();
        
        // Preciso validar o login depois
    }
}