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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class JInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicio frame = new JInicio();
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
	public JInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JButton btnNewButton = new JButton("Fazer login");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		JButton btnNewButton_1 = new JButton("Catálogo");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel lblNewLabel_1 = new JLabel("Seja bem-vindo(a)! Escolha uma das opções abaixo:");
		lblNewLabel_1.setFont(new Font("Academy Engraved LET", Font.PLAIN, 16));
		
		// Adicionando a imagem do banner
		JLabel lblBanner = new JLabel();
		lblBanner.setIcon(resizeImageIcon("/Users/visitante/eclipse-workspace/Store/img/banner.png", 200, 150));

		// Adicionando ActionListener para o botão "Fazer login"
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin loginFrame = new JLogin();
				loginFrame.setVisible(true);
				dispose(); // Fecha a janela atual
			}
		});
		
		// Adicionando ActionListener para o botão "Catálogo"
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCatalogo loginFrame = new JCatalogo();
				loginFrame.setVisible(true);
				dispose(); // Fecha a janela atual
			}
		});

		// Adicionando ActionListener para o botão "Sair"
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
				.addComponent(lblBanner)  // Adiciona a imagem do banner
				.addComponent(lblNewLabel_1)
				.addComponent(btnNewButton)
				.addComponent(btnNewButton_1)
				.addComponent(btnNewButton_2)
		);

		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblAna)
					.addComponent(lblSkin))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
				.addComponent(lblBanner)  // Adiciona a imagem do banner
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 20) // Ajustar o espaço aqui
				.addComponent(lblNewLabel_1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, 20) // Espaço adicional
				.addComponent(btnNewButton)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnNewButton_1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnNewButton_2)
		);

		// Ajusta o tamanho da janela ao conteúdo
		pack();
	}

	private ImageIcon resizeImageIcon(String path, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
}
