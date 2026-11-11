package Exceções;

public class LoginInvalidoException extends RuntimeException{
    public LoginInvalidoException(String m){
        super(m);
    }
}
