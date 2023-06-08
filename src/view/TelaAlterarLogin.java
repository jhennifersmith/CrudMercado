package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.LoginDAO;
import dominio.Login;

public class TelaAlterarLogin {

	private JFrame frmTelaAlterar;
	private JTextField txtIdLogin;
	private JTextField txtUsername;
	private JTextField txtSenha;

	public JTextField getTxtIdLogin() {
		return txtIdLogin;
	}

	public void setTxtIdLogin(String txtIdLogin) {
		this.txtIdLogin.setText(txtIdLogin);
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(String txtUsername) {
		this.txtUsername.setText(txtUsername);
	}

	public JTextField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha.setText(txtSenha);
	}
	
	public JFrame getFrmTelaAlterar() {
		return frmTelaAlterar;
	}	

	public void setFrmTelaAlterar(JFrame frmTelaAlterar) {
		this.frmTelaAlterar = frmTelaAlterar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarLogin window = new TelaAlterarLogin();
					window.frmTelaAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Login");
		frmTelaAlterar.setBounds(100, 100, 450, 299);
		frmTelaAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAlterar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 436, 262);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Identificador:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(20, 71, 77, 14);
		panel.add(lblId);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(20, 119, 120, 14);
		panel.add(lblUsername);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(20, 173, 77, 14);
		panel.add(lblSenha);

		txtIdLogin = new JTextField();
		txtIdLogin.setEditable(false);
		txtIdLogin.setColumns(10);
		txtIdLogin.setBounds(155, 68, 249, 23);
		panel.add(txtIdLogin);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(155, 116, 249, 23);
		panel.add(txtUsername);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(155, 170, 249, 23);
		panel.add(txtSenha);
		
		JButton btnAlteraLogin = new JButton("Alterar");
		btnAlteraLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlteraLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdLogin.getText());
				String username = txtUsername.getText();
				String senha = txtSenha.getText();
				Login c = new Login(id, username, senha);
				c.setId(id);
				LoginDAO cd = new LoginDAO();
				cd.Alterar(c);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraLogin.setBounds(300, 217, 104, 23);
		panel.add(btnAlteraLogin);
		
		JLabel lblAlteraoDeLogin = new JLabel("Alteração de Login");
		lblAlteraoDeLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDeLogin.setBounds(10, 10, 139, 34);
		panel.add(lblAlteraoDeLogin);
		
	}
	
}
