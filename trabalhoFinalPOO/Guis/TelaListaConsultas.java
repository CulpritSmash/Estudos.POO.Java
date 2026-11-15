package Guis;
import ControleSaude.Consulta;
import ParteAnimal.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaListaConsultas extends JFrame{
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
            if(lista.getSelectedValue() == null){
                JOptionPane.showMessageDialog(btnVer, "Selecione uma consulta.");
                return;
            }
            new TelaConsulta(escolhida).setVisible(true);
        });
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            dispose();
            return;
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 8, 8));
        painelBotoes.add(btnVer);
        painelBotoes.add(btnVoltar);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }
}
