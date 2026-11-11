package Textos;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class InformacoesMedicas{
    public static void abrirEditor(){
        JFrame janela = new JFrame("Informações Médicas");
        janela.setSize(600, 480);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        try{
            Path arquivo = Paths.get("textoSalvo.txt");
            if(Files.exists(arquivo)){
                area.setText(Files.readString(arquivo));
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(clique -> {
            try{
                Files.writeString(Paths.get("textoSalvo.txt"), area.getText());
            } catch (IOException ex){
                JOptionPane.showMessageDialog(janela, "Erro ao salvar: " + ex.getMessage());
            }
        });

        janela.add(new JScrollPane(area), BorderLayout.CENTER);
        janela.add(salvar, BorderLayout.SOUTH);
        janela.setVisible(true);
    }
}
