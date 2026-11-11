package Usuarios;
import Textos.*;
import java.util.List;

import ParteAnimal.Animal;

import java.util.ArrayList;

import java.util.ArrayList;

public class Veterinario extends Usuario{
    public Veterinario(String login, String senha){
        super(login, senha);
    }

    public void acessarInformacoesMedicas(Animal animal, String novasInformacoes){   // Esse método permite que o próprio veterinário salve e altere as informações médicas dos animais
        InformacoesMedicas.abrirEditor();                                                         // Essas informações não existem como variável, mas são definidas em texto por meio desse método pelo veterinário
    }                                                                                // Assim, apenas um veterinário pode ver e alterá-las

    public void realizarConsulta(Animal animal){
        
    }
}
