package Guis;
import javax.swing.*;
import java.awt.*;

public class TelaConsulta extends JFrame {

    public TelaConsulta() {
        setTitle("Registrar Consulta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(0, 1, 8, 8));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField txtMotivo = new JTextField();

        JPanel linhaMotivo = new JPanel(new BorderLayout(8, 0));
        JLabel lblMotivo = new JLabel("Motivo da Consulta:");
        lblMotivo.setPreferredSize(new Dimension(150, 25));
        linhaMotivo.add(lblMotivo, BorderLayout.WEST);
        linhaMotivo.add(txtMotivo, BorderLayout.CENTER);

        painelCampos.add(linhaMotivo);
        
        add(painelCampos, BorderLayout.NORTH);
    }
}
