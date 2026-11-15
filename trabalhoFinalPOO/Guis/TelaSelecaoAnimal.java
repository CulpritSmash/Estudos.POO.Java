package Guis;
import ParteAnimal.Animal;
import Usuarios.Veterinario;

import javax.swing.*;

import ControleSaude.Consulta;
import ControleSaude.Vacinacao;

import java.awt.*;
import java.util.List;

public class TelaSelecaoAnimal extends JFrame {
    private Veterinario vet;

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

        this.vet = vet;

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

        JButton btnVacina = new JButton("Registrar vacinação");
        btnVacina.addActionListener(e -> {
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um animal.");
                return;
            }
            registrarVacinacao(escolhido);
        });
        
        JButton btnVerVacinas = new JButton("Ver vacinações");
        btnVerVacinas.addActionListener(e -> {
            Animal escolhido = lista.getSelectedValue();
            if(escolhido == null){
                JOptionPane.showMessageDialog(this, "Selecione um animal.");
                return;
            }
            List<Vacinacao> vacinas = Vacinacao.getVacinacoesDoAnimal(escolhido);
            if(vacinas.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nenhuma vacinação registrada.");
                return;
            }
            JList<Vacinacao> listaVac = new JList<>(vacinas.toArray(new Vacinacao[0]));
            JOptionPane.showMessageDialog(this, new JScrollPane(listaVac), "Vacinações de " + escolhido.getNome(), JOptionPane.PLAIN_MESSAGE);
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            dispose();
            return;
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 8, 8));
        painelBotoes.add(btnNova);
        painelBotoes.add(btnVer);
        painelBotoes.add(btnVacina);
        painelBotoes.add(btnVerVacinas);
        painelBotoes.add(btnVoltar);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void registrarVacinacao(Animal animal){
    JTextField txtData = new JTextField();
    JTextField txtHorario = new JTextField();
    JTextField txtVacina = new JTextField();

    Object[] campos = {
        "Data (dd/mm/aaaa):", txtData,
        "Horário (00:00):", txtHorario,
        "Vacina aplicada:", txtVacina
    };

    int opcao = JOptionPane.showConfirmDialog(this, campos,
            "Registrar vacinação de " + animal.getNome(), JOptionPane.OK_CANCEL_OPTION);
    if(opcao == JOptionPane.OK_OPTION){
        if(txtVacina.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Informe a vacina aplicada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new Vacinacao(txtData.getText(), txtHorario.getText(), txtVacina.getText(), animal, vet);
        JOptionPane.showMessageDialog(this, "Vacinação registrada!");
    }
}
}
