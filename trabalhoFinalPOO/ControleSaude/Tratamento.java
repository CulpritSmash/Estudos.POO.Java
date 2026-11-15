package ControleSaude;

public class Tratamento {
    private String medicamento;
    private String dosagem;
    private String viaAdministracao;
    private int diasDuracao;
    private boolean concluido;

    public Tratamento(String medicamento, String dosagem, String viaAdministracao, int diasDuracao){
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.viaAdministracao = viaAdministracao;
        this.diasDuracao = diasDuracao;
        this.concluido = false;
    }

    public void concluirTratamento(){
        this.concluido = true;
    }

    public void exibirTratamento(){
        String status = concluido ? "Concluído" : "Em andamento";
        System.out.println("- " + medicamento + " | Dose: " + dosagem + " (" + viaAdministracao + ") | Duração: " + diasDuracao + "dias | Status");
    }

    public void atualizar(String medicamento, String dosagem, String via, int dias, boolean concluido){
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.viaAdministracao = via;
        this.diasDuracao = dias;
        this.concluido = concluido;
    }

    public String getMedicamento(){
        return medicamento;
    }

    public String getDosagem(){
        return dosagem;
    }

    public String viaAdministracao(){
        return viaAdministracao;
    }
    
    public int getDiasDuracao(){
        return diasDuracao;
    }

    public boolean getStatus(){
        return concluido;
    }

    @Override 
    public String toString(){
        return medicamento + " - " + dosagem + " (" + diasDuracao + " dias) - " + (concluido ? "Concluído" : "Em andamento");
    }
}
