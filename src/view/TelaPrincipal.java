package view;

import java.awt.EventQueue;
import dominio.Produto;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.ProdutoDAO;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		
		JMenuItem mntmAlteraProd;
		
		JMenuItem mntmExcluirProd;
		
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
		mntmConsultaC = new JMenuItem("Consultar");
		mntmConsultaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.getFrmConsultaCliente().setVisible(true);
			}
		});
		mnCliente.add(mntmConsultaC);
		
		JMenuItem mntmAlterarC;
		mntmAlterarC = new JMenuItem("Alterar");
		mntmAlterarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.getFrmConsultaCliente().setVisible(true);
			}
		});
		mnCliente.add(mntmAlterarC);
		
		JMenuItem mntmExcluirC;
		mntmExcluirC = new JMenuItem("Excluir");
		mntmExcluirC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.getFrmConsultaCliente().setVisible(true);
			}
		});
		mnCliente.add(mntmExcluirC);
		
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
		mntmConsultaF = new JMenuItem("Consultar");
		mntmConsultaF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario tcf = new TelaConsultaFuncionario();
				tcf.getFrmConsultaFuncionario().setVisible(true);
			}
		});
		mnFuncionario.add(mntmConsultaF);
		
		JMenuItem mntmAlterarF;
		mntmAlterarF = new JMenuItem("Alterar");
		mntmAlterarF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario tcf = new TelaConsultaFuncionario();
				tcf.getFrmConsultaFuncionario().setVisible(true);
			}
		});
		mnFuncionario.add(mntmAlterarF);
		
		JMenuItem mntmExcluirF;
		mntmExcluirF = new JMenuItem("Excluir");
		mntmExcluirF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario tcf = new TelaConsultaFuncionario();
				tcf.getFrmConsultaFuncionario().setVisible(true);
			}
		});
		mnFuncionario.add(mntmExcluirF);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		mntmCadastraProd = new JMenuItem("Cadastrar");
		mntmCadastraProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tcp = new TelaCadastroProduto();
				tcp.frame().setVisible(true);
			}
		});
		mnProduto.add(mntmCadastraProd);
		mntmConsultaProd = new JMenuItem("Consultar");
		mnProduto.add(mntmConsultaProd);
		mntmAlteraProd = new JMenuItem("Alterar");
		mnProduto.add(mntmAlteraProd);
		mntmExcluirProd = new JMenuItem("Excluir");
		mnProduto.add(mntmExcluirProd);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmCadastraPed = new JMenuItem("Cadastrar");
		mnPedido.add(mntmCadastraPed);
		
		JMenuItem mntmConsultaPed = new JMenuItem("Consultar");
		mnPedido.add(mntmConsultaPed);
		
		JMenuItem mntmAlterarPed = new JMenuItem("Alterar");
		mnPedido.add(mntmAlterarPed);
		
		JMenuItem mntmExcluirPed = new JMenuItem("Excluir");
		mnPedido.add(mntmExcluirPed);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
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
