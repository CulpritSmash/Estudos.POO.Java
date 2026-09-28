public class Jogo{
    private Tabuleiro tabuleiro = new Tabuleiro();
    public int turno = 0;

    public boolean ehVezDasBrancas(){
        return turno % 2 == 0;
    }

    private void passarTurno(){
        turno++;
    }

    public void exibir(){
        tabuleiro.exibir();
    }

    public void moverSemRegras(Posicao origem, Posicao destino){
        tabuleiro.mover(origem, destino);
    }

    public void jogar(Posicao origem, Posicao destino){
        int linha = origem.getLinha();
        int coluna = origem.getColuna();
        
        if(tabuleiro.temPeca(origem)){
            if(ehVezDasBrancas()){
                if(tabuleiro.ehPecaBranca(origem)){
                    if(tabuleiro.ehMovimentoValido(origem, destino)){
                        tabuleiro.mover(origem, destino);
                        passarTurno();
                    }
                    else{
                        System.out.println("Movimento inválido.");
                    }
                }
                else{
                    System.out.println("Não é a vez das pretas. Tente mover uma peça branca.\n");
                }
            } 
            else{
                if(tabuleiro.ehPecaPreta(origem)){
                    if(tabuleiro.ehMovimentoValido(origem, destino)){
                        tabuleiro.mover(origem, destino);
                        passarTurno();
                    }
                    else{
                        System.out.println("Movimento inválido. O cavalo anda em L, tente novamente.");
                    }
                }
                else{
                    System.out.println("Não é a vez das brancas. Tente mover uma peça preta.\n");
                }
            }
        }
        else{
            System.out.println("Não há peça a ser movida na posição selecionada. Tente digitar uma posição que contenha uma peça.\n");
        }
    }

    public boolean teste(){
        if(tabuleiro.estaEmXeque(true)){
            System.out.print("True ");
            return true;
        }
        else{
            System.out.print("False");
            return false;
        }
        
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}