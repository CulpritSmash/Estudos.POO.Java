package Cadastros;
import Usuarios.Usuario;
import java.util.List;
import java.util.ArrayList;

public class Cadastro {
    private static final List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(Usuario user){
        // Tenho que validar esse cadastro depois
        usuarios.add(user);
    }
}
