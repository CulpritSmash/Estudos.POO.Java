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
}
