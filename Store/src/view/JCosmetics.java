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

public class JCosmetics extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<String> carrinho = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCosmetics frame = new JCosmetics();
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
    public JCosmetics() {
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

        JLabel lblSubtitulo = new JLabel("Selecione um produto");
        lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        // Adicionando produtos com imagens redimensionadas
        JLabel lblBatom = new JLabel("Batom - $20");
        lblBatom.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/batom3.jpg", 100, 100));
        JCheckBox chckbxBatom = new JCheckBox();

        JLabel lblMascara = new JLabel("Máscara de Cílios - $25");
        lblMascara.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/batom1.jpg", 100, 100));
        JCheckBox chckbxMascara = new JCheckBox();

        JLabel lblKitBatom = new JLabel("Kit Batom - $100");
        lblKitBatom.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/batom2.jpg", 100, 100));
        JCheckBox chckbxKitBatom = new JCheckBox();

        // Adicionando botões
        JButton btnAddToCart = new JButton("Adicionar ao Carrinho");
        btnAddToCart.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean produtoSelecionado = false;

                if (chckbxBatom.isSelected()) {
                    carrinho.add("Batom - $20");
                    produtoSelecionado = true;
                }
                if (chckbxMascara.isSelected()) {
                    carrinho.add("Máscara de Cílios - $25");
                    produtoSelecionado = true;
                }
                if (chckbxKitBatom.isSelected()) {
                    carrinho.add("Kit Batom - $100");
                    produtoSelecionado = true;
                }

                if (produtoSelecionado) {
                    UIManager.put("OptionPane.background", new Color(255, 240, 245));
                    UIManager.put("Panel.background", new Color(255, 240, 245));
                    JOptionPane.showMessageDialog(JCosmetics.this, "Produto(s) adicionado(s) ao carrinho", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(JCosmetics.this, "Nenhum produto foi selecionado, selecione um produto para continuar", "Erro", JOptionPane.ERROR_MESSAGE);
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
                    .addComponent(lblCosmetics))
                .addComponent(lblSubtitulo)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblBatom)
                    .addComponent(chckbxBatom))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblMascara)
                    .addComponent(chckbxMascara))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblKitBatom)
                    .addComponent(chckbxKitBatom))
                .addComponent(btnAddToCart)
                .addComponent(btnViewCart)
                .addComponent(btnBack)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblAna)
                    .addComponent(lblCosmetics))
                .addComponent(lblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblBatom)
                    .addComponent(chckbxBatom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblMascara)
                    .addComponent(chckbxMascara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10) // Espaço adicional
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblKitBatom)
                    .addComponent(chckbxKitBatom))
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
