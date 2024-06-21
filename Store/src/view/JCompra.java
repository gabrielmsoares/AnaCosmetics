package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JCompra extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldCodigo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCompra frame = new JCompra();
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
    public JCompra() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 245));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("ANA COSMETICS");
        lblTitulo.setFont(new Font("Myanmar MN", Font.BOLD, 20));
        
        JLabel lblTelaPagamento = new JLabel("Tela de pagamento");
        lblTelaPagamento.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

        JLabel lblAviso = new JLabel("No momento só estamos aceitando pagamento via PIX");
        lblAviso.setFont(new Font("Academy Engraved LET", Font.PLAIN, 14));

        JLabel lblEmail = new JLabel("Informe um e-mail para receber o código para pagamento:");
        lblEmail.setFont(new Font("Academy Engraved LET", Font.PLAIN, 14));

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(20); // Ajusta o tamanho do campo de e-mail

        JButton btnGerarCodigo = new JButton("Gerar código de pagamento");
        btnGerarCodigo.setFont(new Font("Arial", Font.BOLD, 14));

        textFieldCodigo = new JTextField();
        textFieldCodigo.setColumns(32);
        textFieldCodigo.setEditable(false);

        JLabel lblInstrucoes = new JLabel("Utilize o código copie e cole para pagar. Assim que o pagamento for confirmado,");
        JLabel lblInstrucoes2 = new JLabel("a confirmação e informações serão enviadas pelo e-mail informado.");
        lblInstrucoes.setFont(new Font("Academy Engraved LET", Font.PLAIN, 14));
        lblInstrucoes2.setFont(new Font("Academy Engraved LET", Font.PLAIN, 14));

        JButton btnVoltarCarrinho = new JButton("Voltar ao Carrinho");
        btnVoltarCarrinho.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.BOLD, 14));

        btnGerarCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(JCompra.this, "Por favor, informe um e-mail.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String codigo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
                    textFieldCodigo.setText(codigo);
                }
            }
        });

        btnVoltarCarrinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCarrinho carrinhoFrame = new JCarrinho();
                carrinhoFrame.setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addComponent(lblTitulo)
        		.addComponent(lblTelaPagamento)
        		.addComponent(lblAviso)
        		.addComponent(lblEmail)
        		.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
        		.addComponent(btnGerarCodigo)
        		.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
        		.addComponent(lblInstrucoes)
        		.addComponent(lblInstrucoes2)
        		.addComponent(btnVoltarCarrinho)
        		.addComponent(btnSair)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblTitulo)
        			.addComponent(lblTelaPagamento)
        			.addComponent(lblAviso)
        			.addComponent(lblEmail)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnGerarCodigo)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblInstrucoes)
        			.addComponent(lblInstrucoes2)
        			.addComponent(btnVoltarCarrinho)
        			.addComponent(btnSair))
        );
        contentPane.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }
}
