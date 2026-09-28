import java.util.Arrays;

//O que é necessário para movimentar uma peça?
//A peça precisa existir na casa de origem antes de poder ser movida
//O movimento deve ser válido para aquele tipo de peça
//Deve ser a sua vez de jogar
//O movimento não pode ser feito se ele expor o rei a um ataque direto de alguma peça inimiga

public class Tabuleiro{
    private char[][] grade = new char[8][8];

    char[] ordem = {'t', 'c', 'b', 'd', 'r', 'b', 'c', 't'};

    public Tabuleiro(){
        for(char[] linha : grade){
            Arrays.fill(linha, ' ');
        }
        
        // Letras maiúsculas representam peças brancas e letras minúsculas peças pretas
        for(int coluna = 0; coluna < 8; coluna++){
            grade[0][coluna] = ordem[coluna];
            grade[7][coluna] = Character.toUpperCase(ordem[coluna]);
        }

        for(int i = 0; i < 8; i++){
            grade[1][i] = 'p';
            grade[6][i] = 'P';
        }
    }

    private String simbolo(char peca) {
    switch (peca) {
        case 'R': return "♔";
        case 'D': return "♕";
        case 'T': return "♖";
        case 'B': return "♗";
        case 'C': return "♘";
        case 'P': return "♙";
        case 'r': return "♚";
        case 'd': return "♛";
        case 't': return "♜";
        case 'b': return "♝";
        case 'c': return "♞";
        case 'p': return "♟";
        default:  return " ";
    }
}

    public void exibir(){
    String separador = "+---".repeat(8) + "+";
    int indicador = 8;

    System.out.println(separador);
    for(char[] linha : grade){
        for(char casa : linha){
            System.out.print("|" + simbolo(casa) + "  ");
        }
        System.out.println("| " + indicador--);
        System.out.println(separador);
    }

    System.out.println("  a   b   c   d   e   f   g   h");
    
}

    public boolean temPeca(Posicao pos){
        int linha = pos.getLinha();
        int coluna = pos.getColuna();

        return (grade[linha][coluna] != ' ');
    }

    public void mover(Posicao origem, Posicao destino){
            int linhaOrigem = origem.getLinha();
            int colunaOrigem = origem.getColuna();
        
            int linhaDestino = destino.getLinha();
            int colunaDestino = destino.getColuna();

            grade[linhaDestino][colunaDestino] = grade[linhaOrigem][colunaOrigem];
            grade[linhaOrigem][colunaOrigem] = ' ';
    }

    public boolean ehPecaBranca(Posicao pos){
        return Character.isUpperCase(grade[pos.getLinha()][pos.getColuna()]);
    }

    public boolean ehPecaPreta(Posicao pos){
        return Character.isLowerCase(grade[pos.getLinha()][pos.getColuna()]);
    }

    private boolean caminhoLivre(Posicao origem, Posicao destino){
            int passoLinha = Integer.compare(destino.getLinha(), origem.getLinha());
            int passoColuna = Integer.compare(destino.getColuna(), origem.getColuna());

            int linha = origem.getLinha() + passoLinha;
            int coluna =  origem.getColuna() + passoColuna;

            while(linha != destino.getLinha() || coluna != destino.getColuna()){
                if(grade[linha][coluna] != ' ') return false;
                linha += passoLinha;
                coluna += passoColuna;
            }
            return true;
    }

    public Posicao acharRei(boolean brancas){
        char rei = brancas ? 'R' : 'r';

        for(int i = 0; i < 8; i++){
            for(int y = 0; y < 8; y++){
                if(grade[i][y] == rei){
                    return new Posicao(i, y);
                }
            }
        }
        return null;
    }

    public boolean estaEmXeque(boolean brancas){
        Posicao rei = acharRei(brancas);
        
        for(int i = 0; i < 8; i++){
            for(int y = 0; y < 8; y++){
                Posicao casa = new Posicao(i, y);
                if(temPeca(casa) && ehPecaBranca(casa) != brancas){
                    if(ehMovimentoValido(casa, rei)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ehMovimentoValido(Posicao origem, Posicao destino){
        int difLinha = Math.abs(destino.getLinha() - origem.getLinha());
        int difColuna = Math.abs(destino.getColuna() - origem.getColuna());

        if(difLinha == 0 && difColuna == 0) return false;
        if(temPeca(destino) && ehPecaBranca(origem) == ehPecaBranca(destino)) return false;

        char peca = Character.toLowerCase(grade[origem.getLinha()][origem.getColuna()]);

        if(peca == 'c'){
            return ((difLinha == 2 && difColuna == 1) || (difLinha == 1 && difColuna == 2));
        }
        else if(peca == 't'){
            return (difLinha == 0 || difColuna == 0) && caminhoLivre(origem, destino);
        }
        else if(peca == 'b'){
            return (difLinha == difColuna) && caminhoLivre(origem, destino);
        }
        else if(peca == 'd'){
            return (difLinha == 0 || difColuna == 0 || difLinha == difColuna)  && caminhoLivre(origem, destino);
        }
        else if(peca == 'r'){
            return (difLinha <= 1 && difColuna <= 1);
        }
        else if(peca == 'p'){
            int sentido = ehPecaBranca(origem) ? -1 : 1;
            int avanco = (destino.getLinha() - origem.getLinha()) * sentido;
            int linhaInicial = (ehPecaBranca(origem)) ? 6 : 1;

            if((avanco == 1 && difColuna == 0) && !temPeca(destino)) return true;

            if((avanco == 2 && difColuna == 0) && origem.getLinha() == linhaInicial && !temPeca(destino) && caminhoLivre(origem, destino)) return true;

            if(avanco == 1 && difColuna == 1 && temPeca(destino)) return true;

            return false;
        }
        return false;
    }
}