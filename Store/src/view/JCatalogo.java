package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCatalogo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCatalogo frame = new JCatalogo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JCatalogo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 245));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 240, 245));
        panel.setForeground(new Color(255, 240, 245));
        contentPane.add(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel lblAna = new JLabel("ANA");
        lblAna.setFont(new Font("Myanmar MN", Font.BOLD, 20));
        JLabel lblSkin = new JLabel("COSMETICS");
        lblSkin.setFont(new Font("Myanmar MN", Font.PLAIN, 20));

        JLabel lblSubtitulo = new JLabel("Escolha uma categoria do catálogo");
        lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        JButton btnCosmetics = new JButton("Cosmetics");
        btnCosmetics.setFont(new Font("Arial", Font.BOLD, 14));
        btnCosmetics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCosmetics inicioFrame = new JCosmetics();
                inicioFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnFragance = new JButton("Fragance");
        btnFragance.setFont(new Font("Arial", Font.BOLD, 14));
        btnFragance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFragance inicioFrame = new JFragance();
                inicioFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnSkin = new JButton("Skin");
        btnSkin.setFont(new Font("Arial", Font.BOLD, 14));
        btnSkin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JSkin inicioFrame = new JSkin();
                inicioFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnBaby = new JButton("Baby");
        btnBaby.setFont(new Font("Arial", Font.BOLD, 14));
        btnBaby.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JBaby inicioFrame = new JBaby();
                inicioFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInicio inicioFrame = new JInicio();
                inicioFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblAna)
                    .addGap(0)  // Set no gap between the labels
                    .addComponent(lblSkin))
                .addComponent(lblSubtitulo)
                .addComponent(btnCosmetics)
                .addComponent(btnFragance)
                .addComponent(btnSkin)
                .addComponent(btnBaby)
                .addComponent(btnVoltar)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblAna)
                    .addComponent(lblSkin))
                .addComponent(lblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
                .addComponent(btnCosmetics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) // Espaço reduzido
                .addComponent(btnFragance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) // Espaço reduzido
                .addComponent(btnSkin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) // Espaço reduzido
                .addComponent(btnBaby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
                .addComponent(btnVoltar)
        );
    }
}
