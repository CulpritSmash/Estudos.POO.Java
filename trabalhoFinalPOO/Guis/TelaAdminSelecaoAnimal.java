package Guis;
import ParteAnimal.Animal;
import Usuarios.Administrador;

import javax.swing.*;

import ControleSaude.Consulta;
import ControleSaude.Vacinacao;

import java.awt.*;
import java.lang.classfile.attribute.StackMapFrameInfo.VerificationTypeInfo;
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
            if(a.isAtivo()){
                modelo.addElement(a);
            }
        }

        JList<Animal> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton btnCadastrar = new JButton("Cadastrar Animal");
        btnCadastrar.addActionListener(e ->{
            new TelaCadastroAnimal();
            dispose();
        });

        JButton btnEditar = new JButton("Editar registro");
        btnEditar.addActionListener(e -> {
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um animal na lista primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new TelaCadastroAnimal(escolhido);
            dispose();
        });

        JButton btnRemover = new JButton("Remover registro");
        btnRemover.addActionListener(e ->{
            Animal escolhido = lista.getSelectedValue();
            if(escolhido ==  null){
                JOptionPane.showMessageDialog(this, "Selecione um animal para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if(escolhido.getStatusAdocao().equalsIgnoreCase("Adotado")){
                JOptionPane.showMessageDialog(this, "Animais já adotados não podem ser removidos.", "Operação bloqueada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover " + escolhido.getNome() + " da lista ativa?", "Confirmar remoção", JOptionPane.YES_NO_OPTION);
            if(confirmacao == JOptionPane.YES_OPTION){
                escolhido.setAtivo(false);
                modelo.removeElement(escolhido);
            }
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
