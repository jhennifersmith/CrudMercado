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

public class TelaCadastrarPedido {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Cadastro de Pedido");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroPedido = new JLabel("Cadastro Pedido");
		lblCadastroPedido.setBounds(10, 0, 108, 34);
		panel.add(lblCadastroPedido);

		JLabel lblIdFuncionario = new JLabel("Digite o id do funcionário:");
		lblIdFuncionario.setBounds(10, 88, 150, 14);
		panel.add(lblIdFuncionario);

		inputIdFuncionario = new JTextField();
		inputIdFuncionario.setBounds(10, 109, 139, 20);
		panel.add(inputIdFuncionario);
		inputIdFuncionario.setColumns(10);

		JLabel lblIdCliente = new JLabel("Digite o Id do Cliente:");
		lblIdCliente.setBounds(10, 140, 139, 14);
		panel.add(lblIdCliente);

		inputIdCliente = new JTextField();
		inputIdCliente.setBounds(10, 165, 139, 20);
		panel.add(inputIdCliente);
		inputIdCliente.setColumns(10);

		JLabel lblIdPedido = new JLabel("Digite o id do pedido:");
		lblIdPedido.setBounds(10, 41, 150, 14);
		panel.add(lblIdPedido);

		inputIdPedido = new JTextField();
		inputIdPedido.setColumns(10);
		inputIdPedido.setBounds(10, 57, 139, 20);
		panel.add(inputIdPedido);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idPedido = Integer.parseInt(inputIdPedido.getText());
				Float valorTotal = (float) 0;
				LocalDate dataPedido = LocalDate.now();
				int idCliente = Integer.parseInt(inputIdCliente.getText());
				int idFuncionario = Integer.parseInt(inputIdFuncionario.getText());
				Pedido p = new Pedido(idPedido, valorTotal, dataPedido, idCliente, idFuncionario);
				PedidoDAO pd = new PedidoDAO();
				pd.create(p, frame);
				frame.dispose();
			}
		});
		btnCadastrar.setBounds(10, 196, 89, 23);
		panel.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(156, 196, 89, 23);
		panel.add(btnVoltar);
	}

}
