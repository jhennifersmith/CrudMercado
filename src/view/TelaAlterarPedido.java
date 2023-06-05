package view;

import java.awt.EventQueue;

import dominio.Pedido;
import dao.PedidoDAO;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.awt.event.ActionEvent;

public class TelaAlterarPedido {

	private JFrame frmTelaAlterar;
	private JTextField txtIdFuncionario;
	private JTextField txtId;
	private JTextField txtIdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarPedido window = new TelaAlterarPedido();
					window.frmTelaAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmTelaDeAlterar() {
		return frmTelaAlterar;
	}

	public JFrame getFrmTelaAlterar() {
		return frmTelaAlterar;
	}

	public void setFrmTelaAlterar(JFrame frmTelaAlterar) {
		this.frmTelaAlterar = frmTelaAlterar;
	}


	public JTextField getTextId() {
		return txtId;
	}

	public void setTextId(String textId) {
		this.txtId.setText(textId);
	}
	
	public JTextField getTextIdCliente() {
		return txtIdCliente;
	}

	public void setTextIdCliente(String textId) {
		this.txtIdCliente.setText(textId);
	}

	public JTextField getTextIdFuncionario() {
		return txtIdFuncionario;
	}

	public void setTextIdFuncionario(String txtIdFuncionario) {
		this.txtIdFuncionario.setText(txtIdFuncionario);
	}
	public JTextField getTxtCusto() {
		return txtIdFuncionario;
	}

	public void setTxtCusto(String txtCusto) {
		this.txtIdFuncionario.setText(txtCusto);
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAlterar = new JFrame();
		frmTelaAlterar.setTitle("Alterar Pedido");
		frmTelaAlterar.setBounds(100, 100, 450, 299);
		frmTelaAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaAlterar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setBounds(10, 37, 77, 14);
		panel.add(lblIdCliente);

		JLabel lblIdFuncionario = new JLabel("Id funcionario:");
		lblIdFuncionario.setBounds(10, 74, 104, 14);
		panel.add(lblIdFuncionario);

		txtIdFuncionario = new JTextField();
		txtIdFuncionario.setColumns(10);
		txtIdFuncionario.setBounds(124, 71, 289, 20);
		panel.add(txtIdFuncionario);

		JButton btnAlteraProduto = new JButton("Alterar");
		btnAlteraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				int idCliente = Integer.parseInt(txtIdCliente.getText());
				int idFuncionario = Integer.parseInt(txtIdFuncionario.getText());
				LocalDate dataPedido = LocalDate.now();
				Float valorTotal = (float)1;
				Pedido p = new Pedido(id, valorTotal, dataPedido, idCliente, idFuncionario);
				p.setId(id);
				PedidoDAO pd = new PedidoDAO();
				pd.Alterar(p);
				frmTelaAlterar.dispose();
			}
		});
		btnAlteraProduto.setBounds(300, 227, 104, 23);
		panel.add(btnAlteraProduto);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(115, 187, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 190, 77, 14);
		panel.add(lblId);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(124, 34, 289, 20);
		panel.add(txtIdCliente);
	}
}
