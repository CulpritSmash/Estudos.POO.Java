package Guis;
import Usuarios.Veterinario;
import ParteAnimal.*;
import Guis.*;

public class Teste {
    public static void main(String[] args) {
        Veterinario vet = new Veterinario("fulano@gmail", "230fsda", "Jonas");
        Animal rex = new Animal("rex", "cao", "dobberman", 10, "G", "saudável", "21/08/2026", "DISPONIVEL", "M", 44);
        new TelaVetSelecaoAnimal(vet, Animal.getAnimais()).setVisible(true);
    }
}