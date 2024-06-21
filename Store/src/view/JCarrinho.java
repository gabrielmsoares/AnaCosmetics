package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JCarrinho extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCarrinho frame = new JCarrinho();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JCarrinho() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 245));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 240, 245));
        contentPane.add(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel lblAna = new JLabel("ANA");
        lblAna.setFont(new Font("Myanmar MN", Font.BOLD, 20));
        JLabel lblCosmetics = new JLabel("COSMETICS");
        lblCosmetics.setFont(new Font("Myanmar MN", Font.PLAIN, 20));

        JLabel lblSubtitulo = new JLabel("Carrinho de compras");
        lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        JButton btnBack = new JButton("Voltar ao Catálogo");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCatalogo catalogoFrame = new JCatalogo();
                catalogoFrame.setVisible(true);
                dispose();
            }
        });

        JButton btnExcluir = new JButton("Excluir produto do carrinho");
        btnExcluir.setFont(new Font("Arial", Font.BOLD, 14));
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui a ação para excluir o produto do carrinho
            }
        });

        JButton btnComprar = new JButton("Comprar");
        btnComprar.setFont(new Font("Arial", Font.BOLD, 14));
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCompra compraFrame = new JCompra();
                compraFrame.setVisible(true);
                UIManager.put("OptionPane.background", new Color(255, 240, 245));
                UIManager.put("Panel.background", new Color(255, 240, 245));
                JOptionPane.showMessageDialog(null, "Você será redirecionado ao pagamento",
                        "Login bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
                // Adicione aqui a ação para comprar os produtos do carrinho
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAna)
                                .addGap(0)
                                .addComponent(lblCosmetics))
                        .addComponent(lblSubtitulo)
                        .addComponent(btnBack)
                        .addComponent(btnExcluir)
                        .addComponent(btnComprar)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAna)
                                .addComponent(lblCosmetics))
                        .addComponent(lblSubtitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
                        .addComponent(btnComprar)
        );
    }
}
