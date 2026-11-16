package Guis;
import ParteAnimal.Animal;
import Usuarios.Administrador;

import javax.swing.*;

import ControleSaude.Consulta;
import ControleSaude.Vacinacao;

import java.awt.*;
import java.util.List;

public class TelaAdminSelecaoAnimal extends JFrame {

    public TelaAdminSelecaoAnimal(List<Animal> animais){
        setTitle("Selecionar Animal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));
        
        DefaultListModel<Animal> modelo = new DefaultListModel<>();
        for(Animal a : animais){
            modelo.addElement(a);
        }

        JList<Animal> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton btnCadastrar = new JButton("Cadastrar Animal");
        btnCadastrar.addActionListener(e ->{
            new TelaCadastroAnimal();
        });

        JButton btnEditar = new JButton("Editar registro");
        btnEditar.addActionListener(e -> {
            
        });

        JButton btnRemover = new JButton("Remover registro");
        btnRemover.addActionListener(e ->{

        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            dispose();
            return;
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 8, 8));
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnVoltar);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        setVisible(true);
    }
}
