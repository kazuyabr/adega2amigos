package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.cadastrar.FrmCadCli;
import gui.cadastrar.FrmCadFornec;
import gui.cadastrar.FrmCadFunc;
import gui.cadastrar.FrmCadPedido;
import gui.cadastrar.FrmCadProdutos;
import gui.consultas.Clientes;
import gui.consultas.Fornecedores;
import gui.consultas.Funcionarios;
import gui.consultas.Vendas;
import gui.operacoes.fluxo.Vender;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	public JDesktopPane desktop;
	private TipoPessoa tp;
	private TipoFluxo tf;
	private OperacaoTipo ot;
	private Clientes cliConsulta;

	public Menu() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Adega 2 Amigos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
				
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCadCli fcc;
				fcc = new FrmCadCli();
				desktop.add(fcc);
				fcc.setVisible(true);											
			}
		});
		mnCadastrar.add(mntmClientes);
		
		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadFornec fcfc = new FrmCadFornec();
				desktop.add(fcfc);
				fcfc.setVisible(true);
			}
		});
		mnCadastrar.add(mntmFornecedores);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadFunc fcf = new FrmCadFunc();
				desktop.add(fcf);
				fcf.setVisible(true);
			}
		});
		mnCadastrar.add(mntmFuncionarios);
		
		JMenuItem jmiprodutos = new JMenuItem("Produtos");
		jmiprodutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadProdutos fcpc = new FrmCadProdutos();
				desktop.add(fcpc);
				fcpc.setVisible(true);
				
			}
		});
		mnCadastrar.add(jmiprodutos);
		
		JMenuItem mntmPedidos = new JMenuItem("Pedidos");
		mntmPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadPedido fcp = new FrmCadPedido();
				desktop.add(fcp);
				fcp.setVisible(true);
			}
		});
		mnCadastrar.add(mntmPedidos);
		
		JMenu mnOperacoes = new JMenu("Opera\u00E7\u00F5es");
		
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmConsultaPessoa = new JMenuItem("Consulta Pessoa");
		mntmConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tp = new TipoPessoa();
				tp.setSize(320, 150);
				tp.setVisible(true);
				desktop.add(tp);
								
			}
		});
		mnConsulta.add(mntmConsultaPessoa);
		
		JMenuItem mntmConsultaFluxo = new JMenuItem("Consulta Fluxo");
		mntmConsultaFluxo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf = new TipoFluxo();
				tf.setSize(320, 150);
				tf.setVisible(true);
				desktop.add(tf);
								
			}
		});
		mnConsulta.add(mntmConsultaFluxo);
		
		JMenuItem mntmConsultaPeca = new JMenuItem("Consulta Estoque");
		mnConsulta.add(mntmConsultaPeca);
		
		JMenuItem mntmConsultaOrcamento = new JMenuItem("Consulta Or\u00E7amento");
		mnConsulta.add(mntmConsultaOrcamento);
		
		menuBar.add(mnOperacoes);
	
		JMenuItem mntmFluxoCaixa = new JMenuItem("Fluxo de Caixa");
		mntmFluxoCaixa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ot = new OperacaoTipo();
				ot.setSize(360, 150);
				ot.setVisible(true);
				desktop.add(ot);
				
			}
			
		});
		mnOperacoes.add(mntmFluxoCaixa);
		
		JMenuItem mntmGerarOramento = new JMenuItem("Gerar Or\u00E7amento");
		mnOperacoes.add(mntmGerarOramento);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmEncerramentos = new JMenuItem("Encerramentos");
		mnRelatrios.add(mntmEncerramentos);
		
		JMenuItem mntmLucros = new JMenuItem("Lucros");
		mnRelatrios.add(mntmLucros);
		
		JMenuItem mntmPrejuizos = new JMenuItem("Prejuizos");
		mnRelatrios.add(mntmPrejuizos);
		
		JMenuItem mntmDespesas = new JMenuItem("Despesas");
		mntmDespesas.setHorizontalAlignment(SwingConstants.LEFT);
		mnRelatrios.add(mntmDespesas);
		getContentPane().setLayout(new BorderLayout(0, 0));
	
		desktop = new JDesktopPane();
		desktop.setBackground(Color.WHITE);
		getContentPane().add(desktop);
		desktop.setLayout(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{156, 978, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Version 0.0.0.4");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDesenvolvidoPorMh = new JLabel("Desenvolvido por M.H. Produ\u00E7\u00F5es");
		GridBagConstraints gbc_lblDesenvolvidoPorMh = new GridBagConstraints();
		gbc_lblDesenvolvidoPorMh.gridx = 2;
		gbc_lblDesenvolvidoPorMh.gridy = 0;
		panel.add(lblDesenvolvidoPorMh, gbc_lblDesenvolvidoPorMh);
	}
	
	class TipoPessoa extends JInternalFrame {

		private JPanel contentPane;
		private JButton btnEntrar;
		@SuppressWarnings("rawtypes")
		private JComboBox comboBox;
		public String rsp;
		String[] consultaTipo = {"Clientes", "Funcionarios", "Fornecedores"};
		
		@SuppressWarnings("unchecked")
		public TipoPessoa() {
				setTitle("Tipo da Consulta: Pessoa");
				setBounds(100, 100, 338, 171);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
				setClosable(true);
				setFrameIcon(null);
				
						
				JPanel jpCentro = new JPanel();
				contentPane.add(jpCentro, BorderLayout.CENTER);
				GridBagLayout gbl_jpCentro = new GridBagLayout();
				gbl_jpCentro.columnWidths = new int[]{20, 0, 0, 5, 0};
				gbl_jpCentro.rowHeights = new int[]{20, 0, 30, 0};
				gbl_jpCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_jpCentro.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				jpCentro.setLayout(gbl_jpCentro);
				
				JLabel lblOQueVoce = new JLabel("O que voce deseja consultar?");
				lblOQueVoce.setForeground(Color.RED);
				lblOQueVoce.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 14));
				GridBagConstraints gbc_lblOQueVoce = new GridBagConstraints();
				gbc_lblOQueVoce.gridwidth = 2;
				gbc_lblOQueVoce.insets = new Insets(0, 0, 5, 5);
				gbc_lblOQueVoce.gridx = 1;
				gbc_lblOQueVoce.gridy = 1;
				jpCentro.add(lblOQueVoce, gbc_lblOQueVoce);
				
				JLabel lblOpes = new JLabel("Op\u00E7\u00F5es:");
				lblOpes.setFont(new Font("Stencil Std", Font.ITALIC, 12));
				GridBagConstraints gbc_lblOpes = new GridBagConstraints();
				gbc_lblOpes.insets = new Insets(0, 0, 0, 5);
				gbc_lblOpes.anchor = GridBagConstraints.EAST;
				gbc_lblOpes.gridx = 1;
				gbc_lblOpes.gridy = 2;
				jpCentro.add(lblOpes, gbc_lblOpes);
				
				@SuppressWarnings("rawtypes")
				JComboBox jComboBox = new JComboBox(consultaTipo);
				comboBox = jComboBox;
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 0, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 2;
				jpCentro.add(comboBox, gbc_comboBox);
				
				JPanel jpSul = new JPanel();
				contentPane.add(jpSul, BorderLayout.SOUTH);
				jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				btnEntrar = new JButton("ENTRAR");
				jpSul.add(btnEntrar);
				
				getBtnEntrar();
								
				
			}
		
		public JButton getBtnEntrar() {
			btnEntrar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(comboBox.getSelectedItem() == "Clientes"){
												
						cliConsulta = new Clientes();
						cliConsulta.setVisible(true);
						
						
						desktop.add(cliConsulta);
												
						//serve para deixar a janela Fullscreen
						/*try {
							cliConsulta.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						*/
						dispose();
						
					}else if(comboBox.getSelectedItem() == "Funcionarios"){

						Funcionarios funcConsulta = new Funcionarios();
						funcConsulta.setVisible(true);						
						desktop.add(funcConsulta);
						try{
							funcConsulta.setMaximum(true);
						}catch(PropertyVetoException ex1){
							JOptionPane.showMessageDialog(null, ex1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
							ex1.printStackTrace();
						}
						dispose();
						
					}else if(comboBox.getSelectedItem() == "Fornecedores"){

						Fornecedores fornecConsulta = new Fornecedores();
						fornecConsulta.setVisible(true);						
						desktop.add(fornecConsulta);
						try{
							fornecConsulta.setMaximum(true);
						}catch(PropertyVetoException ex1){
							JOptionPane.showMessageDialog(null, ex1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
							ex1.printStackTrace();
						}
						dispose();
						
					}
					
				}
				
			});
			
			return btnEntrar;
		}

		public void setBtnEntrar(JButton btnEntrar) {
			this.btnEntrar = btnEntrar;
		}


		public String getRsp() {
			return rsp;
		}


		public void setRsp(String rsp) {
			this.rsp = rsp;
		}


		 
		
	}

	
	class TipoFluxo extends JInternalFrame {

		private JPanel contentPane;
		private JButton btnEntrar;
		@SuppressWarnings("rawtypes")
		private JComboBox comboBox;
		public String rsp;
		String[] consultaTipo = {"Vendas", "Pedidos", "Devoluções"};
		
		public TipoFluxo() {
				setTitle("Tipo da Consulta: Fluxo");
				setBounds(100, 100, 338, 171);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
				setClosable(true);
				
						
				JPanel jpCentro = new JPanel();
				contentPane.add(jpCentro, BorderLayout.CENTER);
				GridBagLayout gbl_jpCentro = new GridBagLayout();
				gbl_jpCentro.columnWidths = new int[]{20, 0, 0, 5, 0};
				gbl_jpCentro.rowHeights = new int[]{20, 0, 30, 0};
				gbl_jpCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_jpCentro.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				jpCentro.setLayout(gbl_jpCentro);
				
				JLabel lblOQueVoce = new JLabel("O que voce deseja consultar?");
				lblOQueVoce.setForeground(Color.RED);
				lblOQueVoce.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 14));
				GridBagConstraints gbc_lblOQueVoce = new GridBagConstraints();
				gbc_lblOQueVoce.gridwidth = 2;
				gbc_lblOQueVoce.insets = new Insets(0, 0, 5, 5);
				gbc_lblOQueVoce.gridx = 1;
				gbc_lblOQueVoce.gridy = 1;
				jpCentro.add(lblOQueVoce, gbc_lblOQueVoce);
				
				JLabel lblOpes = new JLabel("Op\u00E7\u00F5es:");
				lblOpes.setFont(new Font("Stencil Std", Font.ITALIC, 12));
				GridBagConstraints gbc_lblOpes = new GridBagConstraints();
				gbc_lblOpes.insets = new Insets(0, 0, 0, 5);
				gbc_lblOpes.anchor = GridBagConstraints.EAST;
				gbc_lblOpes.gridx = 1;
				gbc_lblOpes.gridy = 2;
				jpCentro.add(lblOpes, gbc_lblOpes);
				
				@SuppressWarnings({ "unchecked", "rawtypes" })
				JComboBox jComboBox = new JComboBox(consultaTipo);
				comboBox = jComboBox;
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 0, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 2;
				jpCentro.add(comboBox, gbc_comboBox);
				
				JPanel jpSul = new JPanel();
				contentPane.add(jpSul, BorderLayout.SOUTH);
				jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				btnEntrar = new JButton("ENTRAR");
				jpSul.add(btnEntrar);
				
				getBtnEntrar();
								
				
			}
		
		public JButton getBtnEntrar() {
			btnEntrar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(comboBox.getSelectedItem() == "Vendas"){
												
						Vendas vds = new Vendas();						
						vds.setVisible(true);
						
						desktop.add(vds);
						try {
							vds.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						
					}else if(comboBox.getSelectedItem() == "Pedidos"){

						JOptionPane.showMessageDialog(null, "voce clicou em Pedidos", "INFO", JOptionPane.INFORMATION_MESSAGE);
						
					}else if(comboBox.getSelectedItem() == "Devoluções"){

						JOptionPane.showMessageDialog(null, "voce clicou em Devoluções", "INFO", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}
				
			});
			
			return btnEntrar;
		}

		public void setBtnEntrar(JButton btnEntrar) {
			this.btnEntrar = btnEntrar;
		}


		public String getRsp() {
			return rsp;
		}


		public void setRsp(String rsp) {
			this.rsp = rsp;
		}

	}
		class OperacaoTipo extends JInternalFrame {

			private JPanel contentPane;
			private JButton btnEntrar;
			@SuppressWarnings("rawtypes")
			private JComboBox comboBox;
			public String rsp;
			String[] consultaTipo = {"Vender", "Devolver", "Repor estoque"};
			
			@SuppressWarnings("unchecked")
			public OperacaoTipo() {
					setTitle("Tipo da Consulta: Fluxo");
					setBounds(100, 100, 338, 171);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(new BorderLayout(0, 0));
					setClosable(true);
					setFrameIcon(null);
							
					JPanel jpCentro = new JPanel();
					contentPane.add(jpCentro, BorderLayout.CENTER);
					GridBagLayout gbl_jpCentro = new GridBagLayout();
					gbl_jpCentro.columnWidths = new int[]{20, 0, 0, 5, 0};
					gbl_jpCentro.rowHeights = new int[]{20, 0, 30, 0};
					gbl_jpCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
					gbl_jpCentro.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
					jpCentro.setLayout(gbl_jpCentro);
					
					JLabel lblOQueVoce = new JLabel("Qual operação voce deseja efetuar?");
					lblOQueVoce.setForeground(Color.RED);
					lblOQueVoce.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 14));
					GridBagConstraints gbc_lblOQueVoce = new GridBagConstraints();
					gbc_lblOQueVoce.gridwidth = 2;
					gbc_lblOQueVoce.insets = new Insets(0, 0, 5, 5);
					gbc_lblOQueVoce.gridx = 1;
					gbc_lblOQueVoce.gridy = 1;
					jpCentro.add(lblOQueVoce, gbc_lblOQueVoce);
					
					JLabel lblOpes = new JLabel("Op\u00E7\u00F5es:");
					lblOpes.setFont(new Font("Stencil Std", Font.ITALIC, 12));
					GridBagConstraints gbc_lblOpes = new GridBagConstraints();
					gbc_lblOpes.insets = new Insets(0, 0, 0, 5);
					gbc_lblOpes.anchor = GridBagConstraints.EAST;
					gbc_lblOpes.gridx = 1;
					gbc_lblOpes.gridy = 2;
					jpCentro.add(lblOpes, gbc_lblOpes);
					
					@SuppressWarnings("rawtypes")
					JComboBox jComboBox = new JComboBox(consultaTipo);
					comboBox = jComboBox;
					GridBagConstraints gbc_comboBox = new GridBagConstraints();
					gbc_comboBox.insets = new Insets(0, 0, 0, 5);
					gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
					gbc_comboBox.gridx = 2;
					gbc_comboBox.gridy = 2;
					jpCentro.add(comboBox, gbc_comboBox);
					
					JPanel jpSul = new JPanel();
					contentPane.add(jpSul, BorderLayout.SOUTH);
					jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					
					btnEntrar = new JButton("ENTRAR");
					jpSul.add(btnEntrar);
					
					getBtnEntrar();
									
					
				}
			
			public JButton getBtnEntrar() {
				btnEntrar.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(comboBox.getSelectedItem() == "Vender"){
													
							Vender vd = new Vender();
							vd.setVisible(true);
							
							desktop.add(vd);							
							dispose();
							
						}else if(comboBox.getSelectedItem() == "Devolver"){

							JOptionPane.showMessageDialog(null, "voce clicou em Devolver", "INFO", JOptionPane.INFORMATION_MESSAGE);
							
						}else if(comboBox.getSelectedItem() == "Repor estoque"){

							JOptionPane.showMessageDialog(null, "voce clicou em Repor estoque", "INFO", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
					}
					
				});
				
				return btnEntrar;
			}

			public void setBtnEntrar(JButton btnEntrar) {
				this.btnEntrar = btnEntrar;
			}


			public String getRsp() {
				return rsp;
			}


			public void setRsp(String rsp) {
				this.rsp = rsp;
			}

		 
		
	}
}
