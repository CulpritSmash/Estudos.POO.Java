package Guis;
import ControleSaude.Consulta;
import Usuarios.Veterinario;
import ParteAnimal.Animal;

import javax.swing.*;
import java.awt.*;

public class TelaConsulta extends JFrame {
    // Atributos da tela
    private JTextField txtData;
    private JTextField txtHorario;
    private JTextField txtMotivo;
    private JTextArea txtAvaliacaoClinica;
    private JTextField txtDiagnostico;
    private JTextField txtExamesSolicitados;
    private JTextArea txtObservacoes;

    // Método auxiliar pra poupar tempo na adição de linhas na GUI
    private JPanel criarLinha(String textoRotulo, JComponent campo){
        JPanel linha = new JPanel(new BorderLayout(8, 0));
        JLabel rotulo = new JLabel(textoRotulo);
        rotulo.setPreferredSize(new Dimension(150, 25));
        linha.add(rotulo, BorderLayout.WEST);
        linha.add(campo, BorderLayout.CENTER);
        return linha;
    }
    
    public TelaConsulta(Veterinario vet, Animal animal) {
        setTitle("Registrar Consulta");
        setSize(540, 440);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Inicialização dos atributos dos campos
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

        // Adição dos rótulos e campos na GUI
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
        
        // Adição do botão de salvar e sua ação
        JButton btnSalvar = new JButton("Salvar Consulta");
        btnSalvar.addActionListener(e -> {
            String data = txtData.getText();
            String horario = txtHorario.getText();
            String motivo = txtMotivo.getText();
            String avaliacao = txtAvaliacaoClinica.getText();
            String diagnostico = txtDiagnostico.getText();
            String exames = txtExamesSolicitados.getText();
            String observacoes = txtObservacoes.getText();
            Consulta consulta = new Consulta(data, horario, animal, vet, avaliacao, diagnostico, exames, observacoes);
            dispose();
        });

        add(painelCampos, BorderLayout.NORTH);
        add(btnSalvar, BorderLayout.SOUTH);
    }
}
