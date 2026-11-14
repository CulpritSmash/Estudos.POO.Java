package Usuarios;
import ParteAnimal.Animal;
import ControleSaude.*;
import Guis.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Veterinario extends Usuario{
    public Veterinario(String login, String senha, String nome){
        super(login, senha, nome);
    }

    public void acessarInformacoesMedicas(Animal animal, String novasInformacoes){   // Esse método permite que o próprio veterinário salve e altere as informações médicas dos animais
        InformacoesMedicas.abrirEditor();                                                         // Essas informações não existem como variável, mas são definidas em texto por meio desse método pelo veterinário
    }                                                                                // Assim, apenas um veterinário pode ver e alterá-las
}
