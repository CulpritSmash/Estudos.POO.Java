package Utilidades;

import java.util.Scanner;

public class Entradas {
     public static boolean lerConfirmacao(Scanner sc, String pergunta) {
        while (true) {
            System.out.print(pergunta + " (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();

            if (resposta.equals("s") || resposta.equals("sim")) {
            return true;
            }
            if (resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                return false;
            }
            System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
        }
    }

    public static int lerOpcao(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Escolha uma opção: ");
            String entrada = sc.nextLine().trim();

            try {
                int opcao = Integer.parseInt(entrada);
                if (opcao >= min && opcao <= max) {
                    return opcao;
                }
                System.out.println("Opção inválida. Digite um número entre " + min + " e " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }
}
