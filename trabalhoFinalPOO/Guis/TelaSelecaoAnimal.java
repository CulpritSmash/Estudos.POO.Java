package Guis;
import ParteAnimal.Animal;
import Usuarios.Veterinario;

import javax.swing.*;

import ControleSaude.Consulta;

import java.awt.*;
import java.util.List;

public class TelaSelecaoAnimal extends JFrame {
    public TelaSelecaoAnimal(Veterinario vet, List<Animal> animais){
        setTitle("Selecionar Animal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));
        
        DefaultListModel<Animal> modelo = new DefaultListModel<>();
        for(Animal a : animais){
            modelo.addElement(a);
        }

        JList<Animal> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        

        JButton btnNova = new JButton("Nova Consulta");
        btnNova.addActionListener(e -> {
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um animal.");
                return;
            }
            new TelaConsulta(vet, lista.getSelectedValue()).setVisible(true);;
            dispose();
        });
        JButton btnVer = new JButton("Ver Consultas Anteriores");
        btnVer.addActionListener(e ->{
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(btnNova, "Selecione um animal.");
                return;
            }
            new TelaListaConsultas(Consulta.getConsultasDoAnimal(escolhido)).setVisible(true);
        });
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            dispose();
            return;
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 8, 8));
        painelBotoes.add(btnNova);
        painelBotoes.add(btnVer);
        painelBotoes.add(btnVoltar);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }
}
