package Guis;
import Usuarios.Administrador;
import Usuarios.Veterinario;
import ParteAnimal.Animal;

import javax.swing.*;

import ControleSaude.Consulta;
import ControleSaude.Tratamento;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class TelaCadastroAnimal extends JFrame {
    private JTextField txtNome;
    private JTextField txtEspecie;
    private JTextField txtRaca;
    private JTextField txtIdade;
    private JTextField txtPorte;
    private JTextField txtEstadoSaude;
    private JTextField txtDataResgate;
    private JTextField txtStatusAdocao;
    private JTextField txtSexo;
    private JTextField txtPeso;

    private Animal animalEdicao;

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

        txtNome = new JTextField();
        txtEspecie = new JTextField();
        txtRaca = new JTextField(); 
        txtIdade = new JTextField(); 
        txtPorte = new JTextField(); 
        txtEstadoSaude = new JTextField();
        txtDataResgate = new JTextField();
        txtStatusAdocao = new JTextField();
        txtSexo = new JTextField();
        txtPeso = new JTextField();

        painelCampos.add(criarLinha("Nome:", txtNome));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Espécie:", txtEspecie));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Raça:", txtRaca));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Idade:", txtIdade));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Porte (Mini, Pequeno, Médio, Grande):", txtPorte));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Estado de Saúde:", txtEstadoSaude));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Data de Resgate:", txtDataResgate));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Status de Adoção (Disponível ou Indisponível):", txtStatusAdocao));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Sexo (M ou F):", txtSexo));
        painelCampos.add(Box.createVerticalStrut(8));
        painelCampos.add(criarLinha("Peso (kg):", txtPeso));
        return painelCampos;
    }
    
    private void preencherCampos(Animal a){
        txtNome.setText(a.getNome());
        txtEspecie.setText(a.getEspecie());
        txtRaca.setText(a.getRaca());
        txtIdade.setText(String.valueOf(a.getIdade()));
        txtPorte.setText(a.getPorte());
        txtEstadoSaude.setText(a.getEstadoSaude());
        txtDataResgate.setText(a.getDataResgate());
        txtStatusAdocao.setText(a.getStatusAdocao());
        txtSexo.setText(a.getSexo());
        txtPeso.setText(String.valueOf(a.getPeso()));
    }

    private void salvarOuCadastrar() {
    try {
        String nome = txtNome.getText().trim();
        String especie = txtEspecie.getText().trim();
        String raca = txtRaca.getText().trim();
        int idade = Integer.parseInt(txtIdade.getText().trim());
        if (idade < 0) {
            JOptionPane.showMessageDialog(this, "A idade não pode ser negativa.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String porte = txtPorte.getText().trim();
        String estadoSaude = txtEstadoSaude.getText().trim();
        String dataResgate = txtDataResgate.getText().trim();
        String statusAdocao = txtStatusAdocao.getText().trim();
        String sexo = txtSexo.getText().trim();
        double peso = Double.parseDouble(txtPeso.getText().trim());
        if (peso <= 0) {
            JOptionPane.showMessageDialog(this, "O peso não pode ser negativo ou nulo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (animalEdicao == null) {
            // Modo cadastro: cria um novo registro
            new Animal(nome, especie, raca, idade, porte, estadoSaude, dataResgate, statusAdocao, sexo, peso);
            JOptionPane.showMessageDialog(this, "Animal cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Modo edição: atualiza o objeto que já existe na lista
            animalEdicao.setNome(nome);
            animalEdicao.setEspecie(especie);
            animalEdicao.setRaca(raca);
            animalEdicao.setIdade(idade);
            animalEdicao.setPorte(porte);
            animalEdicao.setEstadoSaude(estadoSaude);
            animalEdicao.setDataResgate(dataResgate);
            animalEdicao.setStatusAdocao(statusAdocao);
            animalEdicao.setSexo(sexo);
            animalEdicao.setPeso(peso);

            JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        new TelaAdminSelecaoAnimal(Animal.getAnimais()).setVisible(true);
        dispose();

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Digite apenas números no peso e números inteiros na idade.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
    }
}

    public TelaCadastroAnimal() {
        this(null);
    }

    public TelaCadastroAnimal(Animal animalParaEditar){
        this.animalEdicao = animalParaEditar;
        boolean isEdicao = (animalParaEditar != null);

        setTitle(isEdicao ? "Edição de Registro" : "Cadastro de Animal");
        setSize(600, 550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(montarFormulario(), BorderLayout.CENTER);

        if(isEdicao){
            preencherCampos(animalParaEditar);
        }

        JButton btnAcao = new JButton(isEdicao ? "Salvar" : "Cadastrar");
        btnAcao.addActionListener(e -> {
            salvarOuCadastrar();
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaAdminSelecaoAnimal(Animal.getAnimais());
            dispose();
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 8, 8));
        painelBotoes.add(btnAcao);
        painelBotoes.add(btnVoltar);
        add(painelBotoes, BorderLayout.SOUTH);
        setVisible(true);
    }
}
