package Menus;
import java.util.Scanner;
import Cadastros.Cadastro;
import Usuarios.*;

public class MenuCadastro {
    public static void exibirMenuCadastro(Scanner sc){
        System.out.println("=".repeat(45));
        System.out.println("     MENU DE CADASTRO     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Cadastrar-se como voluntário");
        System.out.println("(2) - Cadastrar-se como veterinário");
        System.out.println("(0) - Voltar");

        System.out.print("Digite sua opção: ");
        int opcao = Integer.parseInt(sc.nextLine());

        if(opcao == 0){
            return;
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Cadastro cadastro = new Cadastro();

        if(opcao == 1){
            Usuario novoUsuarioCadastrado = new Voluntario(email, senha);
            cadastro.cadastrar(novoUsuarioCadastrado);
        }
        else if(opcao == 2){
            Usuario novoUsuarioCadastrado = new Veterinario(email, senha);
            cadastro.cadastrar(novoUsuarioCadastrado);
        }
    }
}
