package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.PedidoDAO;
import dominio.Pedido;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastrarPedido {

	private JFrame frmCadastroDePedidos;
	private JTextField inputIdFuncionario;
	private JTextField inputIdCliente;
	private JTextField inputIdPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarPedido window = new TelaCadastrarPedido();
					window.frmCadastroDePedidos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDePedidos = new JFrame();
		frmCadastroDePedidos.getContentPane().setBackground(new Color(128, 128, 255));
		frmCadastroDePedidos.setTitle("Cadastro de Pedidos");
		frmCadastroDePedidos.setBounds(100, 100, 450, 300);
		frmCadastroDePedidos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDePedidos.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 414, 239);
		frmCadastroDePedidos.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroPedido = new JLabel("Cadastro de Pedidos");
		lblCadastroPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroPedido.setBounds(10, 13, 139, 34);
		panel.add(lblCadastroPedido);

		JLabel lblIdFuncionario = new JLabel("Digite o id do funcionário:");
		lblIdFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdFuncionario.setBounds(20, 74, 150, 14);
		panel.add(lblIdFuncionario);

		inputIdFuncionario = new JTextField();
		inputIdFuncionario.setBounds(196, 73, 139, 20);
		panel.add(inputIdFuncionario);
		inputIdFuncionario.setColumns(10);

		JLabel lblIdCliente = new JLabel("Digite o id do Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdCliente.setBounds(20, 119, 139, 14);
		panel.add(lblIdCliente);

		inputIdCliente = new JTextField();
		inputIdCliente.setBounds(196, 118, 139, 20);
		panel.add(inputIdCliente);
		inputIdCliente.setColumns(10);

		inputIdPedido = new JTextField();
		inputIdPedido.setColumns(10);
		inputIdPedido.setBounds(10, 57, 139, 20);
		panel.add(inputIdPedido).setVisible(false);;

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idPedido = 0;
				Float valorTotal = (float) 0;
				LocalDate dataPedido = LocalDate.now();
				int idCliente = Integer.parseInt(inputIdCliente.getText());
				int idFuncionario = Integer.parseInt(inputIdFuncionario.getText());
				Pedido p = new Pedido(idPedido, valorTotal, dataPedido, idCliente, idFuncionario);
				PedidoDAO pd = new PedidoDAO();
				pd.create(p, frmCadastroDePedidos);
				frmCadastroDePedidos.dispose();
			}
		});
		btnCadastrar.setBounds(20, 176, 139, 23);
		panel.add(btnCadastrar);
	}
	
	public JFrame getFrame() {
		return frmCadastroDePedidos;
	}

}
