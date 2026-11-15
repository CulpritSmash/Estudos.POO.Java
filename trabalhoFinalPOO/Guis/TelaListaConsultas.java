package Guis;
import ControleSaude.*;
import ParteAnimal.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaListaConsultas extends JFrame{
    private void escolherTratamento(Consulta consulta){
        List<Tratamento> tratamentos = consulta.getTratamentos();
        if(tratamentos.isEmpty()){
            JOptionPane.showMessageDialog(this, "Essa consulta não tem tratamentos");
            return;
        }

        JList<Tratamento> listaTrat = new JList<>(tratamentos.toArray(new Tratamento[0]));
        listaTrat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int opcao = JOptionPane.showConfirmDialog(this, new JScrollPane(listaTrat), 
            "Escolha o tratamento", JOptionPane.OK_CANCEL_OPTION);

        if(opcao ==  JOptionPane.OK_OPTION){
            Tratamento escolhido = listaTrat.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um tratamento");
                return;
            }
            editarTratamento(escolhido);
        }
    }

    private void editarTratamento(Tratamento t){
        JTextField txtMed = new JTextField();
        JTextField txtDose = new JTextField();
        JTextField txtVia = new JTextField();
        JTextField txtDias = new JTextField();
        JCheckBox chkConcluido = new JCheckBox("Concluido", t.getStatus());

        Object[] campos = {
            "Medicamento:", txtMed,
            "Dosagem:", txtDose,
            "Via:", txtVia,
            "Duração (dias):", txtDias,
            chkConcluido
        };

        int opcao = JOptionPane.showConfirmDialog(this, campos, "Atualizar Tratamento", JOptionPane.OK_CANCEL_OPTION);
        if(opcao == JOptionPane.OK_OPTION){
            try{
                int dias = Integer.parseInt(txtDias.getText().trim());
                t.atualizar(txtMed.getText(), txtDose.getText(), txtVia.getText(), dias, chkConcluido.isSelected());

                JOptionPane.showMessageDialog(this, "Tratamento atualizado");
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Digite um número válido para os dias", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public TelaListaConsultas(List<Consulta> consultas){
        setTitle("Consultas Anteriores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));
        
        DefaultListModel<Consulta> modelo = new DefaultListModel<>();
        for(Consulta c : consultas){
            modelo.addElement(c);
        }

        JList<Consulta> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton btnVer = new JButton("Visualizar");
        btnVer.addActionListener(e ->{
            Consulta escolhida = lista.getSelectedValue();
            if(escolhida == null){
                JOptionPane.showMessageDialog(this, "Selecione uma consulta.");
                return;
            }
            new TelaConsulta(escolhida).setVisible(true);
        });
        JButton btnAtualizar = new JButton("Atualizar Tratamento");
        btnAtualizar.addActionListener(e ->{
            Consulta consulta = lista.getSelectedValue();
            if(consulta == null){
                JOptionPane.showMessageDialog(this, "Selecione uma consulta");
                return;
            }
            escolherTratamento(consulta);
        });
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            dispose();
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 8, 8));
        painelBotoes.add(btnVer);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnVoltar);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }
}
