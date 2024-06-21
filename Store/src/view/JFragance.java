package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class JFragance extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<String> carrinho = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFragance frame = new JFragance();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFragance() {
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
        JLabel lblFragance = new JLabel("FRAGANCE");
        lblFragance.setFont(new Font("Myanmar MN", Font.PLAIN, 20));

        JLabel lblSubtitulo = new JLabel("Selecione um produto");
        lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        // Adicionando produtos com imagens redimensionadas
        JLabel lblPerfume1 = new JLabel("100ml - $78");
        lblPerfume1.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/perfume1.jpg", 100, 100));
        JCheckBox chckbxPerfume1 = new JCheckBox();

        JLabel lblPerfume2 = new JLabel("50ml - $60");
        lblPerfume2.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/perfume2.jpg", 100, 100));
        JCheckBox chckbxPerfume2 = new JCheckBox();

        JLabel lblPerfume3 = new JLabel("30ml - $48");
        lblPerfume3.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/perfume3.jpg", 100, 100));
        JCheckBox chckbxPerfume3 = new JCheckBox();

        // Adicionando botões
        JButton btnAddToCart = new JButton("Adicionar ao Carrinho");
        btnAddToCart.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean produtoSelecionado = false;

                if (chckbxPerfume1.isSelected()) {
                    carrinho.add("100ml - $78");
                    produtoSelecionado = true;
                }
                if (chckbxPerfume2.isSelected()) {
                    carrinho.add("50ml - $60");
                    produtoSelecionado = true;
                }
                if (chckbxPerfume3.isSelected()) {
                    carrinho.add("30ml - $48");
                    produtoSelecionado = true;
                }
                if (produtoSelecionado) {
                    UIManager.put("OptionPane.background", new Color(255, 240, 245));
                    UIManager.put("Panel.background", new Color(255, 240, 245));
                    JOptionPane.showMessageDialog(JFragance.this, "Produto(s) adicionado(s) ao carrinho", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(JFragance.this, "Nenhum produto foi selecionado, selecione um produto para continuar", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnViewCart = new JButton("Ver Carrinho");
        btnViewCart.setFont(new Font("Arial", Font.BOLD, 14));
        btnViewCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCarrinho carrinhoFrame = new JCarrinho();
                carrinhoFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnBack = new JButton("Voltar ao Catálogo");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCatalogo catalogoFrame = new JCatalogo();
                catalogoFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblAna)
                    .addGap(0)
                    .addComponent(lblFragance))
                .addComponent(lblSubtitulo)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPerfume1)
                    .addComponent(chckbxPerfume1))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPerfume2)
                    .addComponent(chckbxPerfume2))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPerfume3)
                    .addComponent(chckbxPerfume3))
                .addComponent(btnAddToCart)
                .addComponent(btnViewCart)
                .addComponent(btnBack)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblAna)
                    .addComponent(lblFragance))
                .addComponent(lblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblPerfume1)
                    .addComponent(chckbxPerfume1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblPerfume2)
                    .addComponent(chckbxPerfume2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblPerfume3)
                    .addComponent(chckbxPerfume3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
                .addComponent(btnAddToCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addComponent(btnViewCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addComponent(btnBack)
        );
    }

    private ImageIcon resizeImageIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
