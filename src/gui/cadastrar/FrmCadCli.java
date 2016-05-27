package gui.cadastrar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import classes.RegCliente;
import classes.sql.ClienteDAO;
import classes.sql.Conexao;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FrmCadCli extends JInternalFrame {

	private JTextField jtfNome;
	private JFormattedTextField jtfDataDeNasc;
	private JTextField jtfRg;
	private JTextField jtfCpfCnpj;
	private JTextField jtfEndereco;
	private JTextField jtfBairro;
	private JTextField jtfEstado;
	private JTextField jtfCep;
	private JTextField jtfTelefone;
	private JTextField jtfCelular;
	private MaskFormatter mfdatanasc;	
	private JTextField jtfEmail;
	private JButton btnCadastrar;
	private RegCliente cliente;
	private ClienteDAO clienteDAO;
	private ButtonGroup bgSex;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private Conexao conect;
	private JLabel lblCidade;
	private JTextField jtfCidade;
	private JLabel lblNumero;
	private JTextField jtfNumero;
	private JButton btnLimpar;
	private JLabel lblCodigo;
	private JTextField jtfCodCli;

	public FrmCadCli(){
		setResizable(true);
		setFrameIcon(null);
		setTitle("Cadastrar Cliente");
		setClosable(true);
		setBounds(100, 100, 619, 316);
		getContentPane().setLayout(new BorderLayout(0, 0));

		conect = new Conexao();
		conect.conectar();
		
		clienteDAO = new ClienteDAO(conect);
		
		try {
			mfdatanasc = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mfdatanasc.setValidCharacters("1234567890");
		
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		GridBagLayout gbl_jpCenter = new GridBagLayout();
		gbl_jpCenter.columnWidths = new int[]{20, 117, 95, 43, 37, 86, 71, 86, 20, 0};
		gbl_jpCenter.rowHeights = new int[]{20, 20, 20, 23, 20, 20, 20, 20, 20, 20, 0};
		gbl_jpCenter.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpCenter.setLayout(gbl_jpCenter);
						
						lblCodigo = new JLabel("Codigo:");
						GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
						gbc_lblCodigo.anchor = GridBagConstraints.EAST;
						gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
						gbc_lblCodigo.gridx = 1;
						gbc_lblCodigo.gridy = 1;
						jpCenter.add(lblCodigo, gbc_lblCodigo);
						
						jtfCodCli = new JTextField();
						jtfCodCli.setEditable(false);
						jtfCodCli.setToolTipText("Codigo do Banco de Dados");
						GridBagConstraints gbc_jtfCodCli = new GridBagConstraints();
						gbc_jtfCodCli.anchor = GridBagConstraints.NORTH;
						gbc_jtfCodCli.fill = GridBagConstraints.HORIZONTAL;
						gbc_jtfCodCli.insets = new Insets(0, 0, 5, 5);
						gbc_jtfCodCli.gridx = 2;
						gbc_jtfCodCli.gridy = 1;
						jpCenter.add(jtfCodCli, gbc_jtfCodCli);
						jtfCodCli.setColumns(10);
						
								JLabel lblNome = new JLabel("Nome:");
								GridBagConstraints gbc_lblNome = new GridBagConstraints();
								gbc_lblNome.anchor = GridBagConstraints.EAST;
								gbc_lblNome.insets = new Insets(0, 0, 5, 5);
								gbc_lblNome.gridx = 1;
								gbc_lblNome.gridy = 2;
								jpCenter.add(lblNome, gbc_lblNome);
								
										jtfNome = new JTextField();
										jtfNome.setToolTipText("Digite o seu nome e sobrenome");
										GridBagConstraints gbc_jtfNome = new GridBagConstraints();
										gbc_jtfNome.anchor = GridBagConstraints.NORTH;
										gbc_jtfNome.fill = GridBagConstraints.HORIZONTAL;
										gbc_jtfNome.insets = new Insets(0, 0, 5, 5);
										gbc_jtfNome.gridwidth = 6;
										gbc_jtfNome.gridx = 2;
										gbc_jtfNome.gridy = 2;
										jpCenter.add(jtfNome, gbc_jtfNome);
										jtfNome.setColumns(10);
						
								JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
								GridBagConstraints gbc_lblDataDeNascimento = new GridBagConstraints();
								gbc_lblDataDeNascimento.anchor = GridBagConstraints.EAST;
								gbc_lblDataDeNascimento.insets = new Insets(0, 0, 5, 5);
								gbc_lblDataDeNascimento.gridx = 1;
								gbc_lblDataDeNascimento.gridy = 3;
								jpCenter.add(lblDataDeNascimento, gbc_lblDataDeNascimento);
				
						jtfDataDeNasc = new JFormattedTextField(mfdatanasc);
						jtfDataDeNasc.setHorizontalAlignment(SwingConstants.CENTER);
						jtfDataDeNasc.setToolTipText("Digite a data de nascimento formato(DD/MM/AAAA)");
						GridBagConstraints gbc_jtfDataDeNasc = new GridBagConstraints();
						gbc_jtfDataDeNasc.fill = GridBagConstraints.HORIZONTAL;
						gbc_jtfDataDeNasc.insets = new Insets(0, 0, 5, 5);
						gbc_jtfDataDeNasc.gridx = 2;
						gbc_jtfDataDeNasc.gridy = 3;
						jpCenter.add(jtfDataDeNasc, gbc_jtfDataDeNasc);		
						jtfDataDeNasc.setColumns(10);
												
						bgSex = new ButtonGroup();
														JLabel lblSexo = new JLabel("Sexo:");
														GridBagConstraints gbc_lblSexo = new GridBagConstraints();
														gbc_lblSexo.anchor = GridBagConstraints.EAST;
														gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
														gbc_lblSexo.gridx = 5;
														gbc_lblSexo.gridy = 3;
														jpCenter.add(lblSexo, gbc_lblSexo);
										
												rdbtnMasculino = new JRadioButton("Masculino");
												rdbtnMasculino.setSelected(true);
												GridBagConstraints gbc_rdbtnMasculino = new GridBagConstraints();
												gbc_rdbtnMasculino.anchor = GridBagConstraints.NORTHWEST;
												gbc_rdbtnMasculino.insets = new Insets(0, 0, 5, 5);
												gbc_rdbtnMasculino.gridx = 6;
												gbc_rdbtnMasculino.gridy = 3;
												jpCenter.add(rdbtnMasculino, gbc_rdbtnMasculino);
												bgSex.add(rdbtnMasculino);
										
										rdbtnFeminino = new JRadioButton("Feminino");
										GridBagConstraints gbc_rdbtnFeminino = new GridBagConstraints();
										gbc_rdbtnFeminino.anchor = GridBagConstraints.NORTH;
										gbc_rdbtnFeminino.insets = new Insets(0, 0, 5, 5);
										gbc_rdbtnFeminino.gridx = 7;
										gbc_rdbtnFeminino.gridy = 3;
										jpCenter.add(rdbtnFeminino, gbc_rdbtnFeminino);
										bgSex.add(rdbtnFeminino);
								
										JLabel lblRg = new JLabel("RG:");
										GridBagConstraints gbc_lblRg = new GridBagConstraints();
										gbc_lblRg.anchor = GridBagConstraints.EAST;
										gbc_lblRg.insets = new Insets(0, 0, 5, 5);
										gbc_lblRg.gridx = 1;
										gbc_lblRg.gridy = 4;
										jpCenter.add(lblRg, gbc_lblRg);
												
														jtfRg = new JTextField();
														jtfRg.setToolTipText("Digite seu RG");
														GridBagConstraints gbc_jtfRg = new GridBagConstraints();
														gbc_jtfRg.anchor = GridBagConstraints.NORTH;
														gbc_jtfRg.fill = GridBagConstraints.HORIZONTAL;
														gbc_jtfRg.insets = new Insets(0, 0, 5, 5);
														gbc_jtfRg.gridwidth = 3;
														gbc_jtfRg.gridx = 2;
														gbc_jtfRg.gridy = 4;
														jpCenter.add(jtfRg, gbc_jtfRg);
														jtfRg.setColumns(10);
										
												JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
												GridBagConstraints gbc_lblCpfcnpj = new GridBagConstraints();
												gbc_lblCpfcnpj.anchor = GridBagConstraints.EAST;
												gbc_lblCpfcnpj.insets = new Insets(0, 0, 5, 5);
												gbc_lblCpfcnpj.gridx = 5;
												gbc_lblCpfcnpj.gridy = 4;
												jpCenter.add(lblCpfcnpj, gbc_lblCpfcnpj);
								
										jtfCpfCnpj = new JTextField();
										jtfCpfCnpj.setToolTipText("Digite seu CPF ou CNPJ");
										GridBagConstraints gbc_jtfCpfCnpj = new GridBagConstraints();
										gbc_jtfCpfCnpj.anchor = GridBagConstraints.NORTH;
										gbc_jtfCpfCnpj.fill = GridBagConstraints.HORIZONTAL;
										gbc_jtfCpfCnpj.insets = new Insets(0, 0, 5, 5);
										gbc_jtfCpfCnpj.gridwidth = 2;
										gbc_jtfCpfCnpj.gridx = 6;
										gbc_jtfCpfCnpj.gridy = 4;
										jpCenter.add(jtfCpfCnpj, gbc_jtfCpfCnpj);
										jtfCpfCnpj.setColumns(10);
										
												JLabel lblEndereo = new JLabel("Endere\u00E7o:");
												GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
												gbc_lblEndereo.anchor = GridBagConstraints.EAST;
												gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
												gbc_lblEndereo.gridx = 1;
												gbc_lblEndereo.gridy = 5;
												jpCenter.add(lblEndereo, gbc_lblEndereo);
										
												jtfEndereco = new JTextField();
												jtfEndereco.setToolTipText("Digite seu endere\u00E7o");
												GridBagConstraints gbc_jtfEndereco = new GridBagConstraints();
												gbc_jtfEndereco.anchor = GridBagConstraints.NORTH;
												gbc_jtfEndereco.fill = GridBagConstraints.HORIZONTAL;
												gbc_jtfEndereco.insets = new Insets(0, 0, 5, 5);
												gbc_jtfEndereco.gridwidth = 4;
												gbc_jtfEndereco.gridx = 2;
												gbc_jtfEndereco.gridy = 5;
												jpCenter.add(jtfEndereco, gbc_jtfEndereco);
												jtfEndereco.setColumns(10);
								
										lblNumero = new JLabel("Numero:");
										GridBagConstraints gbc_lblNumero = new GridBagConstraints();
										gbc_lblNumero.anchor = GridBagConstraints.EAST;
										gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
										gbc_lblNumero.gridx = 6;
										gbc_lblNumero.gridy = 5;
										jpCenter.add(lblNumero, gbc_lblNumero);
								
										jtfNumero = new JTextField();
										jtfNumero.setToolTipText("numero da CASA ou da Caixa");
										GridBagConstraints gbc_jtfNumero = new GridBagConstraints();
										gbc_jtfNumero.fill = GridBagConstraints.HORIZONTAL;
										gbc_jtfNumero.anchor = GridBagConstraints.NORTH;
										gbc_jtfNumero.insets = new Insets(0, 0, 5, 5);
										gbc_jtfNumero.gridx = 7;
										gbc_jtfNumero.gridy = 5;
										jpCenter.add(jtfNumero, gbc_jtfNumero);
										jtfNumero.setColumns(10);
						
								JLabel lblBairro = new JLabel("Bairro:");
								GridBagConstraints gbc_lblBairro = new GridBagConstraints();
								gbc_lblBairro.anchor = GridBagConstraints.EAST;
								gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
								gbc_lblBairro.gridx = 1;
								gbc_lblBairro.gridy = 6;
								jpCenter.add(lblBairro, gbc_lblBairro);
								
										jtfBairro = new JTextField();
										jtfBairro.setToolTipText("Informe o seu bairro");
										GridBagConstraints gbc_jtfBairro = new GridBagConstraints();
										gbc_jtfBairro.anchor = GridBagConstraints.NORTH;
										gbc_jtfBairro.fill = GridBagConstraints.HORIZONTAL;
										gbc_jtfBairro.insets = new Insets(0, 0, 5, 5);
										gbc_jtfBairro.gridx = 2;
										gbc_jtfBairro.gridy = 6;
										jpCenter.add(jtfBairro, gbc_jtfBairro);
										jtfBairro.setColumns(10);
								
										lblCidade = new JLabel("Cidade:");
										GridBagConstraints gbc_lblCidade = new GridBagConstraints();
										gbc_lblCidade.anchor = GridBagConstraints.WEST;
										gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
										gbc_lblCidade.gridx = 4;
										gbc_lblCidade.gridy = 6;
										jpCenter.add(lblCidade, gbc_lblCidade);
						
								jtfCidade = new JTextField();
								jtfCidade.setToolTipText("Informe o nome de sua cidade");
								GridBagConstraints gbc_jtfCidade = new GridBagConstraints();
								gbc_jtfCidade.fill = GridBagConstraints.HORIZONTAL;
								gbc_jtfCidade.anchor = GridBagConstraints.NORTH;
								gbc_jtfCidade.insets = new Insets(0, 0, 5, 5);
								gbc_jtfCidade.gridx = 5;
								gbc_jtfCidade.gridy = 6;
								jpCenter.add(jtfCidade, gbc_jtfCidade);
								jtfCidade.setColumns(10);
								
										JLabel lblEstado = new JLabel("Estado:");
										GridBagConstraints gbc_lblEstado = new GridBagConstraints();
										gbc_lblEstado.anchor = GridBagConstraints.EAST;
										gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
										gbc_lblEstado.gridx = 6;
										gbc_lblEstado.gridy = 6;
										jpCenter.add(lblEstado, gbc_lblEstado);
								
										jtfEstado = new JTextField();
										jtfEstado.setToolTipText("Informe o seu estado(\u00E9 aceito nome inteiro e/ou abreviaturas)");
										GridBagConstraints gbc_jtfEstado = new GridBagConstraints();
										gbc_jtfEstado.fill = GridBagConstraints.HORIZONTAL;
										gbc_jtfEstado.anchor = GridBagConstraints.NORTH;
										gbc_jtfEstado.insets = new Insets(0, 0, 5, 5);
										gbc_jtfEstado.gridx = 7;
										gbc_jtfEstado.gridy = 6;
										jpCenter.add(jtfEstado, gbc_jtfEstado);
										jtfEstado.setColumns(10);
						
								JLabel lblTelefone = new JLabel("Telefone:");
								GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
								gbc_lblTelefone.anchor = GridBagConstraints.EAST;
								gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
								gbc_lblTelefone.gridx = 1;
								gbc_lblTelefone.gridy = 7;
								jpCenter.add(lblTelefone, gbc_lblTelefone);
				
						jtfTelefone = new JTextField();
						jtfTelefone.setToolTipText("Informe o seu telefone");
						GridBagConstraints gbc_jtfTelefone = new GridBagConstraints();
						gbc_jtfTelefone.anchor = GridBagConstraints.NORTH;
						gbc_jtfTelefone.fill = GridBagConstraints.HORIZONTAL;
						gbc_jtfTelefone.insets = new Insets(0, 0, 5, 5);
						gbc_jtfTelefone.gridx = 2;
						gbc_jtfTelefone.gridy = 7;
						jpCenter.add(jtfTelefone, gbc_jtfTelefone);
						jtfTelefone.setColumns(10);
				
						JLabel lblCelular = new JLabel("Celular:");
						GridBagConstraints gbc_lblCelular = new GridBagConstraints();
						gbc_lblCelular.anchor = GridBagConstraints.WEST;
						gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
						gbc_lblCelular.gridx = 4;
						gbc_lblCelular.gridy = 7;
						jpCenter.add(lblCelular, gbc_lblCelular);
		
				jtfCelular = new JTextField();
				jtfCelular.setToolTipText("Informe o seu celular");
				GridBagConstraints gbc_jtfCelular = new GridBagConstraints();
				gbc_jtfCelular.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfCelular.anchor = GridBagConstraints.NORTH;
				gbc_jtfCelular.insets = new Insets(0, 0, 5, 5);
				gbc_jtfCelular.gridx = 5;
				gbc_jtfCelular.gridy = 7;
				jpCenter.add(jtfCelular, gbc_jtfCelular);
				jtfCelular.setColumns(10);
				
						JLabel lblCep = new JLabel("CEP:");
						GridBagConstraints gbc_lblCep = new GridBagConstraints();
						gbc_lblCep.anchor = GridBagConstraints.EAST;
						gbc_lblCep.insets = new Insets(0, 0, 5, 5);
						gbc_lblCep.gridx = 6;
						gbc_lblCep.gridy = 7;
						jpCenter.add(lblCep, gbc_lblCep);
				
						jtfCep = new JTextField();
						jtfCep.setToolTipText("informe o seu cep");
						GridBagConstraints gbc_jtfCep = new GridBagConstraints();
						gbc_jtfCep.fill = GridBagConstraints.HORIZONTAL;
						gbc_jtfCep.anchor = GridBagConstraints.NORTH;
						gbc_jtfCep.insets = new Insets(0, 0, 5, 5);
						gbc_jtfCep.gridx = 7;
						gbc_jtfCep.gridy = 7;
						jpCenter.add(jtfCep, gbc_jtfCep);
						jtfCep.setColumns(10);
		
				JLabel lblEmail = new JLabel("Email:");
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 1;
				gbc_lblEmail.gridy = 8;
				jpCenter.add(lblEmail, gbc_lblEmail);
		
				jtfEmail = new JTextField();
				jtfEmail.setToolTipText("Informe o seu EMAIL");
				GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
				gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
				gbc_jtfEmail.anchor = GridBagConstraints.NORTH;
				gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfEmail.gridwidth = 6;
				gbc_jtfEmail.gridx = 2;
				gbc_jtfEmail.gridy = 8;
				jpCenter.add(jtfEmail, gbc_jtfEmail);
				jtfEmail.setColumns(10);
				

		JPanel jpSul = new JPanel();
		getContentPane().add(jpSul, BorderLayout.SOUTH);

		btnCadastrar = new JButton("CADASTRAR");
		jpSul.add(btnCadastrar);
		
		btnLimpar = new JButton("LIMPAR");
		jpSul.add(btnLimpar);

		getBtnCadastrar();
		getBtnLimpar();
		
		limparCampos();
		
		
	}

	public JButton getBtnCadastrar() {
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				conect.conectar();
				clienteDAO = new ClienteDAO(conect);
				cliente = new RegCliente();
				
				// passando os valores dos textfields para uma classe separada
				cliente.setCodcli(clienteDAO.proximoCodigo());
				cliente.setNomeCliente(jtfNome.getText().toUpperCase());
				if(rdbtnMasculino.isSelected()){
				cliente.setSexoCliente("M");
				}else{
					cliente.setSexoCliente("F");
				}
				try {
					cliente.setDataNascCliente(new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataDeNasc.getText()));
				} catch (ParseException e) {

					e.printStackTrace();
				}
				cliente.setRgCliente(jtfRg.getText());
				cliente.setCpfCnpjCliente(jtfCpfCnpj.getText());
				cliente.setEnderecoCliente(jtfEndereco.getText());
				cliente.setNumeroCliente(Integer.parseInt(jtfNumero.getText()));
				cliente.setBairroCliente(jtfBairro.getText());
				cliente.setCidadeCliente(jtfCidade.getText());
				cliente.setEstadoCliente(jtfEstado.getText());
				cliente.setCepCliente(jtfCep.getText());
				cliente.setTelefoneCliente(jtfTelefone.getText());
				cliente.setCelularCliente(jtfCelular.getText());
				cliente.setEmailCliente(jtfEmail.getText());

								 
				clienteDAO.Incluir(cliente);
				conect.desconecta();				
				limparCampos();

			}
		});

		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JButton getBtnLimpar() {
		
		btnLimpar.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent arg0) {

				limparCampos();
				
			}
			
		});
		
		
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	
	private void limparCampos() {
		conect.conectar();
		int codigoCli = clienteDAO.proximoCodigo();
		conect.desconecta();
		
		jtfCodCli.setText(String.valueOf(codigoCli));
		jtfNome.setText("");
		jtfDataDeNasc.setText("");
		jtfRg.setText("");
		jtfCpfCnpj.setText("");
		jtfEndereco.setText("");
		jtfNumero.setText("");
		jtfCidade.setText("");
		jtfEstado.setText("");
		jtfCep.setText("");
		jtfTelefone.setText("");
		jtfCelular.setText("");
		jtfEmail.setText("");
		jtfBairro.setText("");
		rdbtnMasculino.setSelected(false);
		rdbtnFeminino.setSelected(false);

	}

}
