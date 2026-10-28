package Usuarios;

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
