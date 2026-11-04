package Cadastros;
import Usuarios.Usuario;
import java.util.List;
import Exceções.*;

import Exceções.CadastroInvalidoException;

import java.util.ArrayList;

public class Cadastro {
    private static final List<Usuario> usuariosCadastrados = new ArrayList<>();

    public List<Usuario> getUsuarios(){
        return usuariosCadastrados;
    }

    public void cadastrar(Usuario user) throws CadastroInvalidoException{
        for(Usuario u : usuariosCadastrados){
            if(u.getEmail().equals(user.getEmail())){
                throw new CadastroInvalidoException("Não foi possível realizar o cadastro. Esse email já está cadastrado no sistema.");
            }
        }
        usuariosCadastrados.add(user);
    }
}
