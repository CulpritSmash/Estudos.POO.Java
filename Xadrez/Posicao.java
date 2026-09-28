public class  Posicao{
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {return linha;}
    public int getColuna() {return coluna;}

    public static Posicao deTexto(String posicao){
        if(posicao.charAt(0) >= 'a' && posicao.charAt(0) <= 'h' ){
            char letra = posicao.charAt(0);
            char digito = posicao.charAt(1);
            int numero = digito - '0';
            int linha = 8 - numero;
            int coluna = letra - 'a';

            return new Posicao(linha, coluna);
        }
        else{
            System.out.println("Posição inválida.");
            return null;
        }


    }
}