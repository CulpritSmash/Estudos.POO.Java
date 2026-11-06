package Usuarios;
import Animais.Animal;
import java.util.List;
import java.util.ArrayList;
import ControleSaude.AlteraInfosMed;
import ControleSaude.InformacoesMedicas;

public class Veterinario extends Usuario implements AlteraInfosMed{
    public Veterinario(String login, String senha, String username){
        super(login, senha, username);
    }

    public List<String> getInformacoesMedicas(InformacoesMedicas dados){
        return dados.
    }

    public void setInformacoesMedicas(InformacoesMedicas dados){

    }
}
