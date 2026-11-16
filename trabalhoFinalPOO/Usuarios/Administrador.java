package Usuarios;
import Usuarios.*;
import ParteAnimal.*;
import Menus.MenuAdmin;
import Utilidades.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Administrador extends Usuario{
    public Administrador(){
        super("caio@admin.com", "admin", "Admin");
    }

    public Animal cadastrarAnimal(Scanner sc){
        System.out.print("Nome do animal: ");
        String nome = sc.nextLine().trim();
        System.out.print("Espécie: ");
        String especie = sc.nextLine().trim();
        System.out.print("Raça: ");
        String raca = sc.nextLine().trim();
        System.out.print("Idade: ");
        int idade;
        while(true){
            try{
                idade = Integer.parseInt(sc.nextLine().trim());
                if(idade >= 0){
                    break;
                }
                System.out.println("Opção inválida. A idade não pode ser negativa!");
            } catch(NumberFormatException e){
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
        System.out.print("Porte (Mini, Pequeno, Médio, Grande): ");
        String porte = sc.nextLine().trim();
        System.out.print("Estado de Saúde: ");
        String estadoDeSaude = sc.nextLine().trim();
        System.out.print("Data de Resgate: ");
        String dataDeResgate = sc.nextLine().trim();
        System.out.print("Status de Adoção (DISPONIVEL ou INDISPONIVEL): ");
        String statusAdocao = sc.nextLine().trim();
        System.out.print("Sexo: ");
        String sexo = sc.nextLine().trim();
        System.out.print("Peso (Kg): ");
        double peso;
        while(true){
            try{
                peso = Double.parseDouble(sc.nextLine().trim());
                    if(peso > 0){
                        break;
                    }
                    System.out.println("Opção inválida. O peso não pode ser negativo!");
                } catch(NumberFormatException e){
                    System.out.println("Entrada inválida. Digite apenas números,");
                }
        }

        Animal novoAnimal = new Animal(nome, especie, raca, idade, porte, estadoDeSaude, dataDeResgate, statusAdocao, sexo, peso);
        System.out.println("\nAnimal cadastrado com sucesso!\n");
        return novoAnimal;
    }

    public void editarRegistro(Scanner sc){

    }

    public void removerRegistro(Scanner sc){
        
    }

    public void gerenciarAnimais(Scanner sc, List<Animal> animais){
        if(animais.isEmpty()){
            System.out.println("Não há nenhum animal cadastrado no sistema.");
            if(Entradas.lerConfirmacao(sc, "Deseja cadastrar um animal?")){
                cadastrarAnimal(sc);
            } else{
                System.out.println("Retornando...");
                return;
            }
        } else{
            for(Animal a : animais){
                System.out.println(a.toString());
            }
            System.out.println("");
            MenuAdmin.exibirMenuGestaoAnimal();

            int opcao = Entradas.lerOpcao(sc, 0, 3);
            switch(opcao){
                case 1:
                    cadastrarAnimal(sc);
                case 2:

                case 3:

                case 0:
                    System.out.println("Voltando...");
                    return;
            }
        }
    }
}
