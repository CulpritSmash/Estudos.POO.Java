package Usuarios;
import java.util.List;
import java.util.ArrayList;

public abstract class Usuario {
    private final String email;
    private String senha;

    protected Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }
}
