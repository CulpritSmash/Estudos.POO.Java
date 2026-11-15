package Guis;
import ControleSaude.*;
import Usuarios.Veterinario;
import ParteAnimal.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class TelaConsulta extends JFrame {
    // Atributos da tela
    private JTextField txtData;
    private JTextField txtHorario;
    private JTextField txtMotivo;
    private JTextArea txtAvaliacaoClinica;
    private JTextField txtDiagnostico;
    private JTextField txtExamesSolicitados;
    private JTextArea txtObservacoes;
    private DefaultListModel<Tratamento> modeloTratamentos = new DefaultListModel<>();
    private List<Tratamento> tratamentosTemporarios = new ArrayList<>();

    // Método auxiliar pra poupar tempo na adição de linhas na GUI
    private JPanel criarLinha(String textoRotulo, JComponent campo){
        JPanel linha = new JPanel(new BorderLayout(8, 0));
        JLabel rotulo = new JLabel(textoRotulo);
        rotulo.setPreferredSize(new Dimension(150, 25));
        linha.add(rotulo, BorderLayout.WEST);
        linha.add(campo, BorderLayout.CENTER);
        return linha;
    }

    private JPanel montarFormulario(){
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15,15));

        txtData = new JTextField();
        txtHorario = new JTextField();
        txtMotivo = new JTextField(); 
        txtAvaliacaoClinica = new JTextArea(5, 20); 
        txtAvaliacaoClinica.setLineWrap(true);
        txtAvaliacaoClinica.setWrapStyleWord(true);
        txtDiagnostico = new JTextField(); 
        txtExamesSolicitados = new JTextField();
        txtObservacoes = new JTextArea(5, 20);
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);

        painelCampos.add(criarLinha("Data:", txtData));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Horário:", txtHorario));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Motivo da consulta:", txtMotivo));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Avaliação Clínica:", new JScrollPane(txtAvaliacaoClinica)));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Diagnóstico:", txtDiagnostico));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Exames solicitados:", txtExamesSolicitados));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Observações/Retorno:", new JScrollPane(txtObservacoes)));

        return painelCampos;
    }

    private JPanel montarPainelTratamentos(){
        JPanel painel = new JPanel(new BorderLayout(5, 5));
        painel.setBorder(BorderFactory.createTitledBorder("Tratamentos Prescritos"));

        JList<Tratamento> listaTratamentos = new JList<>(modeloTratamentos);
        painel.add(new JScrollPane(listaTratamentos), BorderLayout.CENTER);

        return painel;
    }

    private void abrirDialogoTratamento(){
        JTextField txtMed = new JTextField();
        JTextField txtDose = new JTextField();
        JTextField txtVia = new JTextField();
        JTextField txtDias = new JTextField();

        Object[] campos = {
            "Medicamento:", txtMed,
            "Dosagem (ex: 1 comp 12/12h):", txtDose,
            "Via (Oral, Injetável, Tópica):", txtVia,
            "Duração (dias):", txtDias
        };

        int opcao = JOptionPane.showConfirmDialog(this, campos, "Novo Tratamento", JOptionPane.OK_CANCEL_OPTION);
        if(opcao == JOptionPane.OK_OPTION){
            try{
                int dias = Integer.parseInt(txtDias.getText().trim());
                Tratamento t = new Tratamento(txtMed.getText(), txtDose.getText(), txtVia.getText(), dias);
                tratamentosTemporarios.add(t);
                modeloTratamentos.addElement(t);
            } catch(NumberFormatException er){
                JOptionPane.showMessageDialog(this, "Digite um número válido para os dias.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
            
    }
    
    // Construtor no modo de escrita
    public TelaConsulta(Veterinario vet, Animal animal) {
        setTitle("Registrar Consulta");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Adição dos botões e suas ações
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 8, 8));
        JPanel painelTrat = montarPainelTratamentos();

        JButton btnSalvar = new JButton("Salvar Consulta");
        btnSalvar.addActionListener(e -> {
            String data = txtData.getText();
            String horario = txtHorario.getText();
            String motivo = txtMotivo.getText();
            String avaliacao = txtAvaliacaoClinica.getText();
            String diagnostico = txtDiagnostico.getText();
            String exames = txtExamesSolicitados.getText();
            String observacoes = txtObservacoes.getText();
            Consulta novaConsulta = new Consulta(data, horario, motivo, animal, vet, avaliacao, diagnostico, exames, observacoes);
            for(Tratamento t : tratamentosTemporarios){
                novaConsulta.adicionarTratamento(t);
            }
            new TelaSelecaoAnimal(vet, Animal.getAnimais()).setVisible(true);
            dispose();
        });

        JButton btnAddTratamento = new JButton("+ Adicionar tratamento");
        btnAddTratamento.addActionListener(e -> {
            abrirDialogoTratamento();
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e ->{
            new TelaSelecaoAnimal(vet, Animal.getAnimais()).setVisible(true);
            dispose();
        });

        painelTrat.add(btnAddTratamento, BorderLayout.SOUTH);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnVoltar);

        add(montarFormulario(), BorderLayout.NORTH);
        
        add(painelBotoes, BorderLayout.SOUTH);
        add(painelTrat, BorderLayout.CENTER);
    }

    // Construtor no modo de leitura
    public TelaConsulta(Consulta consulta){
        setTitle("Consulta de " + consulta.getData());
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(montarFormulario(), BorderLayout.NORTH);
        add(montarPainelTratamentos(), BorderLayout.CENTER);

        txtData.setText(consulta.getData());
        txtHorario.setText(consulta.getHorario());
        txtMotivo.setText(consulta.getMotivo());
        txtAvaliacaoClinica.setText(consulta.getAvaliacaoClinica());
        txtDiagnostico.setText(consulta.getDiagnostico());
        txtExamesSolicitados.setText(consulta.getExamesSolicitados());
        txtObservacoes.setText(consulta.getObservacoes());

        txtData.setEditable(false);
        txtHorario.setEditable(false);
        txtMotivo.setEditable(false);
        txtAvaliacaoClinica.setEditable(false);
        txtDiagnostico.setEditable(false);
        txtExamesSolicitados.setEditable(false);
        txtObservacoes.setEditable(false);

        for(Tratamento t : consulta.getTratamentos()){
            modeloTratamentos.addElement(t);
        }

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> {
            new TelaListaConsultas(Consulta.getConsultasDoAnimal(consulta.getAnimal()));
            dispose();
        });

        add(btnFechar, BorderLayout.SOUTH);
    }
}
