package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
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
		JLabel lblSkin = new JLabel("COSMETICS");
		lblSkin.setFont(new Font("Myanmar MN", Font.PLAIN, 20));

		JLabel lblSubtitulo = new JLabel("Entre em sua conta para continuar");
		lblSubtitulo.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEntrar.addActionListener(e -> {
			String login = textFieldLogin.getText();
			String senha = new String(passwordField.getPassword());
			if (login.isEmpty() || senha.isEmpty()) {
				UIManager.put("OptionPane.background", new Color(255, 240, 245));
				UIManager.put("Panel.background", new Color(255, 240, 245));
				JOptionPane.showMessageDialog(null, "Erro! Preencha os campos solicitados para continuar.",
						"Erro ao fazer login", JOptionPane.ERROR_MESSAGE);
			} else {
				// Mensagem de boas-vindas
				UIManager.put("OptionPane.background", new Color(255, 240, 245));
				UIManager.put("Panel.background", new Color(255, 240, 245));
				JOptionPane.showMessageDialog(null, "Olá " + login + ", você está sendo redirecionado(a) para o nosso catálogo de produtos.",
						"Login bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
				
				// Abre a janela JCatalogo
				JCatalogo catalogoFrame = new JCatalogo();
				catalogoFrame.setVisible(true);
				dispose(); // Fecha a janela atual
			}
		});

		JButton btnVoltar = new JButton("Voltar");
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
					.addGap(0)
					.addComponent(lblSkin))
				.addComponent(lblSubtitulo)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lblLogin)
					.addComponent(textFieldLogin))
				.addGroup(layout.createSequentialGroup()
					.addComponent(lblSenha)
					.addComponent(passwordField))
				.addComponent(btnEntrar)
				.addComponent(btnVoltar)
		);

		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblAna)
					.addComponent(lblSkin))
				.addComponent(lblSubtitulo)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblLogin)
					.addComponent(textFieldLogin))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblSenha)
					.addComponent(passwordField))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnEntrar)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnVoltar)
		);
	}
}
