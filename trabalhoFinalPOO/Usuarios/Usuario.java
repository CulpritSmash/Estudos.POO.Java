package Usuarios;
import java.util.List;
import java.util.ArrayList;

public abstract class Usuario {
    private final String email;
    private String senha;
    private String nome;

    protected Usuario(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;            
    }
}
