package Menus;

import java.util.Scanner;

public class MenuAdmin {
    public static void exibirMenuAdmin(){
        StringBuilder texto = new StringBuilder();

        texto.append("===== ÁREA DO ADMINISTRADOR =====\n\n");
        texto.append("1 - Gerenciar Animais").append("\n");
        texto.append("2 - Gerenciar Usuários").append("\n");
        texto.append("3 - Aprovar Adoções").append("\n");
        texto.append("4 - Gerenciar Eventos").append("\n");
        texto.append("5 - Relatórios").append("\n");
        texto.append("0 - Sair").append("\n\n");
        texto.append("Digite a sua opção: ");

        System.out.print(texto);
    }

    public static void exibirMenuGestaoAnimal(){
        StringBuilder texto = new StringBuilder();

        texto.append("===== GESTÃO DE ANIMAIS =====").append("\n\n");
        texto.append("1 - Cadastrar animal").append("\n");
        texto.append("2 - Editar registro").append("\n");
        texto.append("3 - Remover registro").append("\n");
        texto.append("0 - Voltar").append("\n");
        texto.append("Digite a sua opção: ");

        System.out.print(texto);
    }
}
