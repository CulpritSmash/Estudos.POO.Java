package Menus;

import java.util.Scanner;

import ParteAnimal.Animal;
import ControleSaude.*;

public class MenuVeterinario{
    private static final int INDEFINIDA = -1;

    public static void exibir(){
        System.out.println("=".repeat(45));
        System.out.println("     MENU DO VETERINÁRIO     ");
        System.out.println("=".repeat(45) + "\n");

        System.out.println("(1) - Consultar Animais");
        System.out.println("(2) - Registrar Atendimento");
        System.out.println("(3) - Atualizar Tratamento");
        System.out.println("(4) - Registrar Vacinação");
        System.out.println("(5) - Emitir Relatório Médico");
        System.out.println("(6) - Notificações");
        System.out.println("(0) - Sair" + "\n");
    }

    public Animal selecionarAnimal(Scanner sc){
        int opcao = INDEFINIDA;
    
        do{
            System.out.print("Digite o ID do animal que você quer consultar: ");

            try{
                opcao = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
            }
        } while(opcao == INDEFINIDA);
        

        /* O ID dos animais é gerado por ordem de criação, o primeiro animal recebe ID 1, o segundo ID 2, e assim em diante 
           Por isso verifico se a opção é válida checando se ela está dentro do número de animais que existem */
        if(opcao > Animal.getAnimais().size() || opcao < Animal.getAnimais().size()){
            System.out.println("ID de Animal não encontrado");
            throw new IllegalArgumentException("Esse ID de animal não existe.");
        } 

        return Animal.getAnimais().get(opcao - 1); 
    }

    public static void lerOpcao(Scanner sc){
        int opcao = INDEFINIDA;

        do{
            System.out.print("Digite uma opção: ");

            try{
                opcao = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Erro. Digite um número entre 0 e 6");
                return;
            }

            switch(opcao){
                case 1:
                    Animal.exibirAnimais();
                    try{
                        Consulta consulta = new Consulta();
                    }
                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 0:

                default:

            }
        } while(opcao != 0);
    }
}