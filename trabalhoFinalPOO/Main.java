import Menus.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        MenuPrincipal.exibirMenuPrincipal(sc);
        
        sc.close();
    }
}
