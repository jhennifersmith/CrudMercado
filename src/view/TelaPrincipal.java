package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;

public class TelaPrincipal {

	private JFrame frmTelaPrincipal;
	
	public JFrame getFrmTelaPrincipal() {
		return frmTelaPrincipal;
	}

	public void setFrmTelaPrincipal(JFrame frmTelaPrincipal) {
		this.frmTelaPrincipal = frmTelaPrincipal;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.getContentPane().setBackground(new Color(128, 128, 255));
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/logo.png")));
		frmTelaPrincipal.setBounds(100, 100, 433, 326);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaPrincipal.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 417, 287);
		frmTelaPrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 520, 22);
		panel.add(menuBar);
		
		JMenuItem mntmCadastraProd;
		
		JMenuItem mntmConsultaProd;
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastraC;
		mntmCadastraC = new JMenuItem("Cadastrar");
		mntmCadastraC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarCliente tcc = new TelaCadastrarCliente();
				tcc.frmCadastroCliente().setVisible(true);
			}
		});
		mnCliente.add(mntmCadastraC);
		
		JMenuItem mntmConsultaC;
		mntmConsultaC = new JMenuItem("Consultar, Alterar, Excluir");
		mntmConsultaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.getFrmConsultaCliente().setVisible(true);
			}
		});
		mnCliente.add(mntmConsultaC);
		
		JMenu mnFuncionario = new JMenu("Funcionario");
		menuBar.add(mnFuncionario);
		
		JMenuItem mntmCadastraF;
		mntmCadastraF = new JMenuItem("Cadastrar");
		mntmCadastraF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
				tcf.frmCadastroFuncionario().setVisible(true);
			}
		});
		mnFuncionario.add(mntmCadastraF);
		
		JMenuItem mntmConsultaF;
		mntmConsultaF = new JMenuItem("Consultar, Alterar, Excluir");
		mntmConsultaF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario tcf = new TelaConsultaFuncionario();
				tcf.getFrmConsultaFuncionario().setVisible(true);
			}
		});
		mnFuncionario.add(mntmConsultaF);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		mntmCadastraProd = new JMenuItem("Cadastrar");
		mntmCadastraProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tcp = new TelaCadastroProduto();
				tcp.getFrame().setVisible(true);
			}
		});
		mnProduto.add(mntmCadastraProd);
		mntmConsultaProd = new JMenuItem("Consultar, Alterar, Excluir");
		mntmConsultaProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaProduto tcp = new TelaConsultaProduto();
				tcp.getFrame().setVisible(true);
			}
		});
		mnProduto.add(mntmConsultaProd);
	
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmCadastraPed = new JMenuItem("Cadastrar");
		mntmCadastraPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarPedido tcp = new TelaCadastrarPedido();
				tcp.getFrame().setVisible(true);
			}
		});
		mnPedido.add(mntmCadastraPed);
		
		JMenuItem mntmConsultaPed = new JMenuItem("Consultar, Alterar, Excluir");
		mntmConsultaPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaPedido tcp = new TelaConsultaPedido();
				tcp.getFrame().setVisible(true);
			}
		});
		mnPedido.add(mntmConsultaPed);
		
		JMenu mnLogin = new JMenu("Login");
		menuBar.add(mnLogin);
		
		JMenuItem mntmCadastraL = new JMenuItem("Cadastrar");
		mntmCadastraL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLogin tcl = new TelaCadastroLogin();
				tcl.frmLogin().setVisible(true);
			}
		});
		mnLogin.add(mntmCadastraL);
		
		JMenuItem mntmConsultaL = new JMenuItem("Consultar, Alterar, Excluir"); 
		mntmConsultaL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaLogin tcl = new TelaConsultaLogin();
				tcl.getFrmConsultaLogin().setVisible(true);
			}
		});
		mnLogin.add(mntmConsultaL);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo!");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(23, 45, 157, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nosso programa em Java permite o gerenciamento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(23, 69, 384, 57);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("de clientes, funcionários, pedidos e produtos,");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(23, 110, 341, 57);
		panel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("que podem estar associados à pedidos.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(23, 149, 331, 57);
		panel.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Faça login ou cadastre-se para continuar!");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(23, 190, 331, 57);
		panel.add(lblNewLabel_4);
		
		JButton btnCadastrar = new JButton("Login");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				tl.getFrmLogin().setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(290, 241, 89, 25);
		panel.add(btnCadastrar);
	
		
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmTelaPrincipal, "Software para gerenciamento de\n"
						+ "Produtos, Pedidos, Clientes e Funcionários\n\n"
						+ "Desenvolvido por:\n"
						+ "Jhennifer Smith e Maria Carolina");
			}
		});

		
	}
}
