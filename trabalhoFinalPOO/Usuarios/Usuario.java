package Usuarios;
import java.util.List;
import java.util.ArrayList;

public abstract class Usuario {
    private final String email;
    private String senha;
    private String username;

    protected Usuario(String email, String senha, String username){
        this.email = email;
        this.senha = senha;
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public String getUsername(){
        return username;
    }
}
