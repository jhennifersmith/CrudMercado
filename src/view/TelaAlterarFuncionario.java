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

import dao.FuncionarioDAO;
import dominio.Funcionario;

public class TelaAlterarFuncionario {

	private JFrame frmTelaAlterar;
	private JTextField txtIdFuncionario;
	private JTextField txtNome;
	private JTextField txtSalario;
	private JTextField txtComissao;

	
	public JFrame getFrmTelaAlterar() {
		return frmTelaAlterar;
	}

	public void setFrmTelaAlterar(JFrame frmTelaAlterar) {
		this.frmTelaAlterar = frmTelaAlterar;
	}

	public JTextField getTxtIdFuncionario() {
		return txtIdFuncionario;
	}

	public void setTxtIdFuncionario(String txtIdFuncionario) {
		this.txtIdFuncionario.setText(txtIdFuncionario);;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);;
	}

	public JTextField getTxtSalario() {
		return txtSalario;
	}

	public void setTxtSalario(String txtSalario) {
		this.txtSalario.setText(txtSalario);;
	}

	public JTextField getTxtComissao() {
		return txtComissao;
	}

	public void setTxtComissao(String txtComissao) {
		this.txtComissao.setText(txtComissao);;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarFuncionario window = new TelaAlterarFuncionario();
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
	public TelaAlterarFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Funcionario");
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
		lblId.setBounds(20, 53, 77, 14);
		panel.add(lblId);

		JLabel lblComissao = new JLabel("Comissao:");
		lblComissao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComissao.setBounds(22, 168, 77, 14);
		panel.add(lblComissao);

		JLabel lblNome = new JLabel("Nome completo: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(22, 91, 104, 14);
		panel.add(lblNome);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalario.setBounds(22, 130, 77, 14);
		panel.add(lblSalario);

		txtIdFuncionario = new JTextField();
		txtIdFuncionario.setColumns(10);
		txtIdFuncionario.setBounds(152, 52, 249, 23);
		panel.add(txtIdFuncionario);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(152, 90, 249, 23);
		panel.add(txtNome);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(152, 129, 249, 23);
		panel.add(txtSalario);
		
		txtComissao = new JTextField();
		txtComissao.setColumns(10);
		txtComissao.setBounds(152, 167, 249, 23);
		panel.add(txtComissao);

		JButton btnAlteraFuncionario = new JButton("Alterar");
		btnAlteraFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlteraFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdFuncionario.getText());
				String nome = txtNome.getText();
				Float salario = Float.parseFloat(txtSalario.getText());
				Float comissao = Float.parseFloat(txtComissao.getText());
				Funcionario f = new Funcionario(id, nome, salario, comissao);
				f.setIdFuncionario(id);
				FuncionarioDAO fd = new FuncionarioDAO();
				fd.Alterar(f);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraFuncionario.setBounds(300, 227, 104, 23);
		panel.add(btnAlteraFuncionario);
		
		JLabel lblAlteraoDeFuncionario = new JLabel("Alteração de Funcionario");
		lblAlteraoDeFuncionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDeFuncionario.setBounds(10, 10, 198, 34);
		panel.add(lblAlteraoDeFuncionario);
		
	
		
	}
	
}

