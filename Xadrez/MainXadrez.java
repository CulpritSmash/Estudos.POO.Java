import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


public class MainXadrez{

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Jogo jogo = new Jogo();
        Scanner scanner = new Scanner(System.in);
        String origem, destino;

        while(true){
            jogo.exibir();
            System.out.print("Digite qual posição você quer mexer (ex: e2, d2): ");
            origem = scanner.nextLine();

            System.out.print("Digite para onde você quer mexê-la: ");
            destino = scanner.nextLine();
            System.out.println();
            jogo.jogar(Posicao.deTexto(origem), Posicao.deTexto(destino));
            jogo.limparTela();
        }
    }
}