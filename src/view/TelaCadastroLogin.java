package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.LoginDAO;
import dominio.Login;

public class TelaCadastroLogin {

	private JFrame frmLogin;
	private JTextField txtUser;
	private JPasswordField pswPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLogin window = new TelaCadastroLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo.png")));
		frmLogin.getContentPane().setBackground(new Color(128, 128, 255));
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 147, 539, 374);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Login:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(10, 33, 46, 35);
		panel.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(10, 83, 51, 30);
		panel.add(lblSenha);
		
		JButton btnLogin = new JButton("Cadastre-se");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String pass = String.valueOf(pswPass.getPassword()); 
				Login l = new Login(0, user, pass);
				LoginDAO ld = new LoginDAO();
				ld.create(l, frmLogin);
			}
		});
		btnLogin.setBounds(135, 146, 106, 30);
		panel.add(btnLogin);
		
		JButton btnCadastrar = new JButton("Login");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				tl.getFrmLogin().setVisible(true);
				frmLogin.dispose();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(10, 146, 102, 30);
		panel.add(btnCadastrar);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(77, 42, 164, 30);
		panel.add(txtUser);
		
		pswPass = new JPasswordField();
		pswPass.setBounds(77, 85, 164, 30);
		panel.add(pswPass);
		
		JLabel lblCadastroProduto = new JLabel("Cadastre-se");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroProduto.setBounds(87, 0, 88, 34);
		panel.add(lblCadastroProduto);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/logo.png")));
		lblNewLabel.setBounds(61, 11, 132, 128);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.setBackground(new Color(128, 128, 255));
		frmLogin.setBounds(100, 100, 279, 413);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JFrame frmLogin() {
		return frmLogin;
	}

}
