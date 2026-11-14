package Menus;

import java.util.Scanner;

import Cadastros.Cadastro;
import Exceções.CadastroInvalidoException;
import Usuarios.*;

public class MenuCadastro{
    public static void exibirMenuCadastro(Scanner sc){
        System.out.println("=".repeat(45));
        System.out.println("     MENU DE CADASTRO     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Cadastrar-se como voluntário");
        System.out.println("(2) - Cadastrar-se como veterinário");
        System.out.println("(0) - Voltar");

        System.out.print("Digite sua opção: ");

        int opcao;

        try{
            opcao = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e){
            System.out.println("Opção inválida");
            return;
        }

        if(opcao == 0){
            return;
        } 

        if(opcao != 1 && opcao != 2){
            System.out.println("Opção inválida");
            return;
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        Cadastro cadastro = new Cadastro();

        Usuario novoUsuario;
        if(opcao == 1){
            novoUsuario = new Voluntario(email, senha, nome);
        } else{
            novoUsuario = new Veterinario(email, senha, nome);
        }

        try{
            cadastro.cadastrar(novoUsuario);
            System.out.println("Cadastro realizado com sucesso!");
        } catch(CadastroInvalidoException e){
            System.out.println(e.getMessage());
        }
    }
}
