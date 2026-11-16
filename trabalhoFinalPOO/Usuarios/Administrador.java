package Usuarios;
import Usuarios.*;
import ParteAnimal.*;
import Menus.MenuAdmin;
import Utilidades.*;
import Guis.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Administrador extends Usuario{
    public Administrador(){
        super("caio@admin.com", "admin", "Admin");
    }

    public void gerenciarAnimais(Scanner sc, List<Animal> animais){
        if(animais.isEmpty()){
            System.out.println("Não há nenhum animal cadastrado no sistema.");
            if(Entradas.lerConfirmacao(sc, "Deseja cadastrar um animal?")){
                new TelaCadastroAnimal();
            } else{
                System.out.println("Retornando...");
                return;
            }
        } else{
            new TelaAdminSelecaoAnimal(Animal.getAnimais());
        }
    }
}
