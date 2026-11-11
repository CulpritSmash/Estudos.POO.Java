package Cadastros;
import Exceções.LoginInvalidoException;
import Usuarios.*;

public class SessaoLogin {
    public Usuario realizarLogin(String login, String senha){
        for(Usuario u : Cadastro.getUsuarios()){
            if(u.getEmail().equals(login) && u.getSenha().equals(senha)){ // Se o email ou a senha não baterem, essa condição já ativa
                System.out.println("Login realizado com sucesso!");
                return u;
            }
        }
        return null;
    }

}
