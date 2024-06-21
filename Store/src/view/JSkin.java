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

public class JSkin extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<String> carrinho = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JSkin frame = new JSkin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JSkin() {
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
        JLabel lblSkin = new JLabel("SKIN");
        lblSkin.setFont(new Font("Myanmar MN", Font.PLAIN, 20));

        JLabel lblSubtitulo = new JLabel("Selecione um produto");
        lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        JLabel lblProduto1 = new JLabel("Kit hidratação - $35");
        lblProduto1.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/skin1.jpg", 100, 100));
        JCheckBox chckbxProduto1 = new JCheckBox();

        JLabel lblProduto2 = new JLabel("Creme - $28");
        lblProduto2.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/skin2.jpg", 100, 100));
        JCheckBox chckbxProduto2 = new JCheckBox();

        JLabel lblProduto3 = new JLabel("Kit vanilla - $71");
        lblProduto3.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/skin3.jpg", 100, 100));
        JCheckBox chckbxProduto3 = new JCheckBox();

        JButton btnAddToCart = new JButton("Adicionar ao Carrinho");
        btnAddToCart.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean produtoSelecionado = false;

                if (chckbxProduto1.isSelected()) {
                    carrinho.add("Produto 1 - $35");
                    produtoSelecionado = true;
                }
                if (chckbxProduto2.isSelected()) {
                    carrinho.add("Produto 2 - $28");
                    produtoSelecionado = true;
                }
                if (chckbxProduto3.isSelected()) {
                    carrinho.add("Produto 3 - $71");
                    produtoSelecionado = true;
                }
                if (produtoSelecionado) {
                    UIManager.put("OptionPane.background", new Color(255, 240, 245));
                    UIManager.put("Panel.background", new Color(255, 240, 245));
                    JOptionPane.showMessageDialog(JSkin.this, "Produto(s) adicionado(s) ao carrinho", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(JSkin.this, "Nenhum produto foi selecionado, selecione um produto para continuar", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnViewCart = new JButton("Ver Carrinho");
        btnViewCart.setFont(new Font("Arial", Font.BOLD, 14));
        btnViewCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCarrinho carrinhoFrame = new JCarrinho();
                carrinhoFrame.setVisible(true);
                dispose();
            }
        });

        JButton btnBack = new JButton("Voltar ao Catálogo");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCatalogo catalogoFrame = new JCatalogo();
                catalogoFrame.setVisible(true);
                dispose();
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblAna)
                    .addGap(0)
                    .addComponent(lblSkin))
                .addComponent(lblSubtitulo)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblProduto1)
                    .addComponent(chckbxProduto1))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblProduto2)
                    .addComponent(chckbxProduto2))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblProduto3)
                    .addComponent(chckbxProduto3))
                .addComponent(btnAddToCart)
                .addComponent(btnViewCart)
                .addComponent(btnBack)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblAna)
                    .addComponent(lblSkin))
                .addComponent(lblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblProduto1)
                    .addComponent(chckbxProduto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblProduto2)
                    .addComponent(chckbxProduto2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblProduto3)
                    .addComponent(chckbxProduto3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20)
                .addComponent(btnAddToCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
                .addComponent(btnViewCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 10)
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
