package ControleSaude;
import java.util.List;
import java.util.ArrayList;
import ParteAnimal.*;
import Usuarios.Veterinario;

public class Consulta {
    private static final List<Consulta> registroConsultas = new ArrayList<>();

    private String data; // dd/mm/aa
    private String horario; // 00:00
    private final Animal animal;
    private Veterinario profissionalResponsavel;
    private String motivo;
    private String avaliacaoClinica;
    private String diagnostico;
    private String examesSolicitados;
    private String observacoes;
    private List<Tratamento> tratamentos;

    public Consulta(String data, String horario, Animal animal, Veterinario profissionalResponsavel, String avaliacaoClinica, String diagnostico, String examesSolicitados, String observacoes){
        this.data = data;
        this.horario = horario;
        this.animal = animal;
        this.profissionalResponsavel = profissionalResponsavel;
        this.avaliacaoClinica = avaliacaoClinica;
        this.diagnostico = diagnostico;
        this.examesSolicitados = examesSolicitados;
        this.observacoes = observacoes;
        this.tratamentos = new ArrayList<>();

        registroConsultas.add(this);
    }

    public static List<Consulta> getRegistroConsultas(){
        return registroConsultas;
    }

    public void exibirConsulta(){
        System.out.println("Consulta: " + data + "às" + horario);
        System.out.println("Paciente: " + animal.getNome() + " (" + animal.getEspecie() + " - " + animal.getRaca() + ")");
        System.out.println("Idade: " + animal.getIdade() + " | Peso: " + animal.getPeso() + "kg | Sexo: " + animal.getSexo());
        System.out.println("Veterinário: " + profissionalResponsavel.getNome());
        System.out.println("Motivo: " + motivo);
        System.out.println("Avaliação Clínica: " + avaliacaoClinica);
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Exames solicitados: " + examesSolicitados);
        System.out.println("Observações/Retorno: " + observacoes);

        System.out.println("===== Tratamentos Prescritos =====");
        if(tratamentos.isEmpty()){
            System.out.println("Nenhum tratamento registrado.");
        } else{
            for (Tratamento t : tratamentos){
                t.exibirTratamento();
            }
        }
    }

    public void adicionarTratamento(Tratamento tratamento){
        this.tratamentos.add(tratamento);
    }
}
