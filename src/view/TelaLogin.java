package view;

import java.awt.EventQueue;
import dominio.Login;
import dao.LoginDAO;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaLogin {

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
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
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
		
		txtUser = new JTextField();
		txtUser.setBounds(64, 36, 164, 30);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String pass = String.valueOf(pswPass.getPassword());
				Login l = new Login(1, user, pass);
				LoginDAO ld = new LoginDAO();
				ld.autenticar(l, frmLogin);
			}
		});
		btnLogin.setBounds(92, 157, 76, 30);
		panel.add(btnLogin);
		
		pswPass = new JPasswordField();
		pswPass.setBounds(64, 84, 164, 30);
		panel.add(pswPass);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/logo.png")));
		lblNewLabel.setBounds(61, 11, 132, 128);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.setBackground(new Color(128, 128, 255));
		frmLogin.setBounds(100, 100, 279, 413);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
