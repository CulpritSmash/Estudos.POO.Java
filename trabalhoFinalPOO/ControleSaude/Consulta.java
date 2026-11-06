package ControleSaude;
import java.util.List;
import java.util.ArrayList;
import Animais.Animal;
import Usuarios.Veterinario;

public class Consulta {
    private static final List<Consulta> registroConsultas = new ArrayList<>();

    private String data; // dd/mm/aa
    private String horario; // 00:00
    private String motivo;
    private Veterinario profissionalResponsavel;
    private String anamnese;
    private String prescricao;
    
    private final Animal animal;

    public Consulta(String data, String horario, String motivo, Animal animal, String anamnese, String prescricao){
        this.data = data;
        this.horario = horario;
        this.motivo = motivo;
        this.animal = animal;
        this.anamnese = anamnese;
        this.prescricao = prescricao;

        registroConsultas.add(this);
    }

    public void exibirConsulta(){
        System.out.println("Consulta realizada no dia " + data + " às " + horario + "\n");

        System.out.println("Nome: " + animal.getNome());
        System.out.println("Espécie: " + animal.getEspecie());
        System.out.println("Raça: " + animal.getRaca());
        System.out.println("Idade: " + animal.getIdade());
        System.out.println("Peso: " + animal.getPeso());
        System.out.println("Sexo: " + animal.getSexo());

        System.out.println("Motivo da consulta: " + motivo);
        System.out.println("Anamnese: " + anamnese);
        System.out.println("Exame físico: " + animal.dadosMedicos);
        System.out.println("Conduta e prescrição: " + prescricao);
        System.out.println("Exames solicitados: " + );
        System.out.println("Orientações ao tutor: ");
        System.out.println("Retorno previsto: ");
        System.out.println("Profissional responsável: " + profissionalResponsavel.getUsername());

    }
}
