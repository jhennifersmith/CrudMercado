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
import java.awt.Color;
import java.awt.Font;

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
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 434, 261);
		frmTelaAlterar.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIdCliente = new JLabel("Identificador do Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdCliente.setBounds(27, 121, 153, 14);
		panel.add(lblIdCliente);

		JLabel lblIdFuncionario = new JLabel("Identificador do funcionario:");
		lblIdFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdFuncionario.setBounds(27, 156, 186, 14);
		panel.add(lblIdFuncionario);

		txtIdFuncionario = new JTextField();
		txtIdFuncionario.setColumns(10);
		txtIdFuncionario.setBounds(228, 155, 165, 20);
		panel.add(txtIdFuncionario);

		JButton btnAlteraProduto = new JButton("Alterar");
		btnAlteraProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		btnAlteraProduto.setBounds(289, 206, 104, 23);
		panel.add(btnAlteraProduto);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(228, 85, 165, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblId = new JLabel("Identificador do produto:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(27, 86, 180, 14);
		panel.add(lblId);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(228, 120, 165, 20);
		panel.add(txtIdCliente);
		
		JLabel lblAlteraoDePedido = new JLabel("Alteração de Pedido");
		lblAlteraoDePedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlteraoDePedido.setBounds(10, 26, 165, 34);
		panel.add(lblAlteraoDePedido);
	}
}
