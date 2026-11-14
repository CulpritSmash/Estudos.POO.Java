package Guis;
import ParteAnimal.Animal;
import Usuarios.Veterinario;

import javax.swing.*;
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

        JButton btnSelecionar = new JButton("Consultar");
        btnSelecionar.addActionListener(e -> {
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um animal.");
                return;
            }
            new TelaConsulta(vet, escolhido).setVisible(true);
            dispose();
        });

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(btnSelecionar, BorderLayout.SOUTH);
    }
}
