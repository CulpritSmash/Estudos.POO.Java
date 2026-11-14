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
    
    // GUI para selecionar o animal da consulta
    // De lá ele abre a GUI de consulta baseado no animal que foi selecionado
    public void selecionarAnimal(){
        new TelaSelecaoAnimal(this, Animal.getAnimais());
    }
}
