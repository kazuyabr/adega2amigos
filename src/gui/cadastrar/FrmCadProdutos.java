package gui.cadastrar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.RegProdutos;
import classes.sql.Conexao;
import classes.sql.ProdutosDAO;
import lib.gui.JTextFieldSomenteNumeros;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class FrmCadProdutos extends JInternalFrame {
	private JTextFieldSomenteNumeros txtCODIGO_DE_BARRA_UNITARIO;
	private JTextField txtNome;
	private JTextFieldSomenteNumeros txtQuantidadeEstoque;
	private JTextFieldSomenteNumeros txtPrecoVarejo;
	private JTextFieldSomenteNumeros txtPrecoAtacado;
	private JButton btnCadastrar;		
	private Conexao conect;
	private RegProdutos produtos;
	private ProdutosDAO produtosDAO;
	private JButton btnLimpar;
	private JLabel lblCodigo;
	private JTextField jtfBdProduto;
	private JLabel lblCODIGO_DE_BARRA_PACK;
	private JTextField textFieldCODIGO_DE_BARRA_PACK;
	private JLabel labelcusto;
	private JTextField txtCusto;
	private JLabel lblMARQUE_LUCRO_EM_PORCENTAGEM;
	private JTextField margemdelucro;
	private JLabel lblREPRESENTANTE;
	private JTextField txtRepresentante;
	private JLabel lbl_TELEFONE_DO_REPRESENTANTE;
	private JTextField txtTelefones;
	private JLabel lblEMAIL_DO_REPRESENTANTE;
	private JTextField txtEmailRepresentante;
	private JTextField margemdelucroporcetagem;
	private JRadioButton rdbtnRetonavel;
	

	public FrmCadProdutos() {
		setResizable(true);
		setTitle("Cadastro de Produtos");
		setFrameIcon(null);
		setClosable(true);
		setBounds(100, 100, 693, 457);		
		getContentPane().setLayout(new BorderLayout());
		
		conect = new Conexao();
		conect.conectar();
		
		produtosDAO = new ProdutosDAO(conect);
		
		JPanel jpCenter = new JPanel();
		jpCenter.setToolTipText("EXIBE A MARQUE DE LUCRO EM PORCENTAGEM");
		getContentPane().add(BorderLayout.CENTER, jpCenter);
		
		JPanel jpSul = new JPanel();		
		jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(BorderLayout.SOUTH, jpSul);
		GridBagLayout gbl_jpCenter = new GridBagLayout();
		gbl_jpCenter.columnWidths = new int[]{25, 140, 62, 68, 42, 41, 251, 25, 0};
		gbl_jpCenter.rowHeights = new int[]{30, 20, 23, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 25, 0};
		gbl_jpCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpCenter.setLayout(gbl_jpCenter);
		
		lblCodigo = new JLabel("Codigo:");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 1;
		gbc_lblCodigo.gridy = 1;
		jpCenter.add(lblCodigo, gbc_lblCodigo);
		
		jtfBdProduto = new JTextFieldSomenteNumeros();
		jtfBdProduto.setEditable(false);
		jtfBdProduto.setToolTipText("Codigo do banco de dados");
		GridBagConstraints gbc_jtfBdProduto = new GridBagConstraints();
		gbc_jtfBdProduto.anchor = GridBagConstraints.NORTH;
		gbc_jtfBdProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBdProduto.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBdProduto.gridx = 2;
		gbc_jtfBdProduto.gridy = 1;
		jpCenter.add(jtfBdProduto, gbc_jtfBdProduto);
		jtfBdProduto.setColumns(10);
		
		JLabel lblStatus = new JLabel("STATUS:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 4;
		gbc_lblStatus.gridy = 1;
		jpCenter.add(lblStatus, gbc_lblStatus);
		
		JLabel STATUS_ATIVO_INATIVO = new JLabel("");
		STATUS_ATIVO_INATIVO.setIcon(new ImageIcon(FrmCadProdutos.class.getResource("/img/certo.png")));
		STATUS_ATIVO_INATIVO.setFont(new Font("Arial Black", Font.BOLD, 19));
		STATUS_ATIVO_INATIVO.setForeground(Color.GREEN);
		GridBagConstraints gbc_STATUS_ATIVO_INATIVO = new GridBagConstraints();
		gbc_STATUS_ATIVO_INATIVO.anchor = GridBagConstraints.NORTH;
		gbc_STATUS_ATIVO_INATIVO.insets = new Insets(0, 0, 5, 5);
		gbc_STATUS_ATIVO_INATIVO.gridx = 5;
		gbc_STATUS_ATIVO_INATIVO.gridy = 1;
		jpCenter.add(STATUS_ATIVO_INATIVO, gbc_STATUS_ATIVO_INATIVO);
		
		JLabel lblCODIGO_DE_BARRA_UNITARIO = new JLabel("CODIGO DE BARRAS UNI:");
		GridBagConstraints gbc_lblCODIGO_DE_BARRA_UNITARIO = new GridBagConstraints();
		gbc_lblCODIGO_DE_BARRA_UNITARIO.anchor = GridBagConstraints.EAST;
		gbc_lblCODIGO_DE_BARRA_UNITARIO.insets = new Insets(0, 0, 5, 5);
		gbc_lblCODIGO_DE_BARRA_UNITARIO.gridx = 1;
		gbc_lblCODIGO_DE_BARRA_UNITARIO.gridy = 2;
		jpCenter.add(lblCODIGO_DE_BARRA_UNITARIO, gbc_lblCODIGO_DE_BARRA_UNITARIO);
		
		rdbtnRetonavel = new JRadioButton("RETONAVEL");		
		rdbtnRetonavel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnRetonavel.isSelected() && !txtPrecoAtacado.isEditable())
					txtPrecoAtacado.setEditable(true);					
				if(txtPrecoAtacado.isEditable() && !rdbtnRetonavel.isSelected())
					txtPrecoAtacado.setEditable(false);
					txtPrecoAtacado.setText("0");
				
			
			}
		});
		
		txtCODIGO_DE_BARRA_UNITARIO = new JTextFieldSomenteNumeros();
		txtCODIGO_DE_BARRA_UNITARIO.setToolTipText("Informe o codigo de identifica\u00E7\u00E3o da loja para o produto");
		GridBagConstraints gbc_txtCODIGO_DE_BARRA_UNITARIO = new GridBagConstraints();
		gbc_txtCODIGO_DE_BARRA_UNITARIO.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCODIGO_DE_BARRA_UNITARIO.insets = new Insets(0, 0, 5, 5);
		gbc_txtCODIGO_DE_BARRA_UNITARIO.gridwidth = 3;
		gbc_txtCODIGO_DE_BARRA_UNITARIO.gridx = 2;
		gbc_txtCODIGO_DE_BARRA_UNITARIO.gridy = 2;
		jpCenter.add(txtCODIGO_DE_BARRA_UNITARIO, gbc_txtCODIGO_DE_BARRA_UNITARIO);
		txtCODIGO_DE_BARRA_UNITARIO.setColumns(10);
		GridBagConstraints gbc_rdbtnRetonavel = new GridBagConstraints();
		gbc_rdbtnRetonavel.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnRetonavel.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRetonavel.gridx = 6;
		gbc_rdbtnRetonavel.gridy = 2;
		jpCenter.add(rdbtnRetonavel, gbc_rdbtnRetonavel);
		
		lblCODIGO_DE_BARRA_PACK = new JLabel("CODIGO DE BARRAS PACK:");
		GridBagConstraints gbc_lblCODIGO_DE_BARRA_PACK = new GridBagConstraints();
		gbc_lblCODIGO_DE_BARRA_PACK.anchor = GridBagConstraints.EAST;
		gbc_lblCODIGO_DE_BARRA_PACK.insets = new Insets(0, 0, 5, 5);
		gbc_lblCODIGO_DE_BARRA_PACK.gridx = 1;
		gbc_lblCODIGO_DE_BARRA_PACK.gridy = 3;
		jpCenter.add(lblCODIGO_DE_BARRA_PACK, gbc_lblCODIGO_DE_BARRA_PACK);
		
		textFieldCODIGO_DE_BARRA_PACK = new JTextField();
		textFieldCODIGO_DE_BARRA_PACK.setToolTipText("Informe o codigo de identifica\u00E7\u00E3o da loja para o produto");
		textFieldCODIGO_DE_BARRA_PACK.setText("");
		textFieldCODIGO_DE_BARRA_PACK.setColumns(10);
		GridBagConstraints gbc_textFieldCODIGO_DE_BARRA_PACK = new GridBagConstraints();
		gbc_textFieldCODIGO_DE_BARRA_PACK.anchor = GridBagConstraints.NORTH;
		gbc_textFieldCODIGO_DE_BARRA_PACK.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCODIGO_DE_BARRA_PACK.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCODIGO_DE_BARRA_PACK.gridwidth = 3;
		gbc_textFieldCODIGO_DE_BARRA_PACK.gridx = 2;
		gbc_textFieldCODIGO_DE_BARRA_PACK.gridy = 3;
		jpCenter.add(textFieldCODIGO_DE_BARRA_PACK, gbc_textFieldCODIGO_DE_BARRA_PACK);
		
		JLabel lblNome = new JLabel("DESCRI\u00C7\u00C3O DO PRODUTO");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 4;
		jpCenter.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Informe o nome da pe\u00E7a ou produto");
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.NORTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridwidth = 5;
		gbc_txtNome.gridx = 2;
		gbc_txtNome.gridy = 4;
		jpCenter.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em Estoque:");
		GridBagConstraints gbc_lblQuantidadeEmEstoque = new GridBagConstraints();
		gbc_lblQuantidadeEmEstoque.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidadeEmEstoque.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidadeEmEstoque.gridx = 1;
		gbc_lblQuantidadeEmEstoque.gridy = 5;
		jpCenter.add(lblQuantidadeEmEstoque, gbc_lblQuantidadeEmEstoque);
		
		txtQuantidadeEstoque = new JTextFieldSomenteNumeros();
		txtQuantidadeEstoque.setToolTipText("Informe a quantidade comprada que sera adcionada ao estoque");
		GridBagConstraints gbc_txtQuantidadeEstoque = new GridBagConstraints();
		gbc_txtQuantidadeEstoque.anchor = GridBagConstraints.NORTH;
		gbc_txtQuantidadeEstoque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantidadeEstoque.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantidadeEstoque.gridx = 2;
		gbc_txtQuantidadeEstoque.gridy = 5;
		jpCenter.add(txtQuantidadeEstoque, gbc_txtQuantidadeEstoque);
		txtQuantidadeEstoque.setColumns(10);
		
		labelcusto = new JLabel("CUSTO:");
		GridBagConstraints gbc_labelcusto = new GridBagConstraints();
		gbc_labelcusto.anchor = GridBagConstraints.EAST;
		gbc_labelcusto.insets = new Insets(0, 0, 5, 5);
		gbc_labelcusto.gridx = 1;
		gbc_labelcusto.gridy = 6;
		jpCenter.add(labelcusto, gbc_labelcusto);
		
		txtCusto = new JTextFieldSomenteNumeros();
		txtCusto.setToolTipText("Informe o pre\u00E7o de venda");
		txtCusto.setColumns(10);
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.anchor = GridBagConstraints.NORTH;
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 5);
		gbc_txtCusto.gridx = 2;
		gbc_txtCusto.gridy = 6;
		jpCenter.add(txtCusto, gbc_txtCusto);
		
		lblMARQUE_LUCRO_EM_PORCENTAGEM = new JLabel("MARGEM DE LUCRO:");
		lblMARQUE_LUCRO_EM_PORCENTAGEM.setToolTipText("CUSTO/POR PRE\u00C7O FINAL");
		GridBagConstraints gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM = new GridBagConstraints();
		gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM.anchor = GridBagConstraints.EAST;
		gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM.insets = new Insets(0, 0, 5, 5);
		gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM.gridx = 1;
		gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM.gridy = 7;
		jpCenter.add(lblMARQUE_LUCRO_EM_PORCENTAGEM, gbc_lblMARQUE_LUCRO_EM_PORCENTAGEM);
		
		margemdelucro = new JTextFieldSomenteNumeros();
		margemdelucro.setToolTipText("valor em real");
		margemdelucro.setEditable(false);
		GridBagConstraints gbc_margemdelucro = new GridBagConstraints();
		gbc_margemdelucro.anchor = GridBagConstraints.NORTH;
		gbc_margemdelucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_margemdelucro.insets = new Insets(0, 0, 5, 5);
		gbc_margemdelucro.gridx = 2;
		gbc_margemdelucro.gridy = 7;
		jpCenter.add(margemdelucro, gbc_margemdelucro);
		margemdelucro.setColumns(10);
		
		JLabel label = new JLabel("%");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 7;
		jpCenter.add(label, gbc_label);
		
		margemdelucroporcetagem = new JTextFieldSomenteNumeros();
		margemdelucroporcetagem.setText("0");
		margemdelucroporcetagem.setEditable(false);
		margemdelucroporcetagem.setToolTipText("valor em porcentagem");
		GridBagConstraints gbc_margemdelucroporcetagem = new GridBagConstraints();
		gbc_margemdelucroporcetagem.anchor = GridBagConstraints.NORTH;
		gbc_margemdelucroporcetagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_margemdelucroporcetagem.insets = new Insets(0, 0, 5, 5);
		gbc_margemdelucroporcetagem.gridx = 5;
		gbc_margemdelucroporcetagem.gridy = 7;
		jpCenter.add(margemdelucroporcetagem, gbc_margemdelucroporcetagem);
		margemdelucroporcetagem.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		GridBagConstraints gbc_lblPreco = new GridBagConstraints();
		gbc_lblPreco.anchor = GridBagConstraints.EAST;
		gbc_lblPreco.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreco.gridx = 1;
		gbc_lblPreco.gridy = 8;
		jpCenter.add(lblPreco, gbc_lblPreco);
		
		txtPrecoVarejo = new JTextFieldSomenteNumeros();
		txtPrecoVarejo.setToolTipText("Informe o pre\u00E7o de venda");
		GridBagConstraints gbc_txtPrecoVarejo = new GridBagConstraints();
		gbc_txtPrecoVarejo.anchor = GridBagConstraints.NORTH;
		gbc_txtPrecoVarejo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecoVarejo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecoVarejo.gridx = 2;
		gbc_txtPrecoVarejo.gridy = 8;
		jpCenter.add(txtPrecoVarejo, gbc_txtPrecoVarejo);
		txtPrecoVarejo.setColumns(10);
		
		JLabel lblAtacado = new JLabel("Pre\u00E7o C/ RETONAVEL:");
		GridBagConstraints gbc_lblAtacado = new GridBagConstraints();
		gbc_lblAtacado.anchor = GridBagConstraints.EAST;
		gbc_lblAtacado.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtacado.gridx = 1;
		gbc_lblAtacado.gridy = 9;
		jpCenter.add(lblAtacado, gbc_lblAtacado);
		
		txtPrecoAtacado = new JTextFieldSomenteNumeros();
		txtPrecoAtacado.setEditable(false);
		txtPrecoAtacado.setToolTipText("Informe o pre\u00E7o de venda por atacado");
		GridBagConstraints gbc_txtPrecoAtacado = new GridBagConstraints();
		gbc_txtPrecoAtacado.anchor = GridBagConstraints.NORTH;
		gbc_txtPrecoAtacado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecoAtacado.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecoAtacado.gridx = 2;
		gbc_txtPrecoAtacado.gridy = 9;
		jpCenter.add(txtPrecoAtacado, gbc_txtPrecoAtacado);
		txtPrecoAtacado.setColumns(10);
		
		lblREPRESENTANTE = new JLabel("REPRESENTANTE:");
		GridBagConstraints gbc_lblREPRESENTANTE = new GridBagConstraints();
		gbc_lblREPRESENTANTE.anchor = GridBagConstraints.EAST;
		gbc_lblREPRESENTANTE.insets = new Insets(0, 0, 5, 5);
		gbc_lblREPRESENTANTE.gridx = 1;
		gbc_lblREPRESENTANTE.gridy = 10;
		jpCenter.add(lblREPRESENTANTE, gbc_lblREPRESENTANTE);
		
		txtRepresentante = new JTextField();
		GridBagConstraints gbc_txtRepresentante = new GridBagConstraints();
		gbc_txtRepresentante.anchor = GridBagConstraints.NORTH;
		gbc_txtRepresentante.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRepresentante.insets = new Insets(0, 0, 5, 5);
		gbc_txtRepresentante.gridwidth = 5;
		gbc_txtRepresentante.gridx = 2;
		gbc_txtRepresentante.gridy = 10;
		jpCenter.add(txtRepresentante, gbc_txtRepresentante);
		txtRepresentante.setColumns(10);
		
		lbl_TELEFONE_DO_REPRESENTANTE = new JLabel("TELEFONES:");
		GridBagConstraints gbc_lbl_TELEFONE_DO_REPRESENTANTE = new GridBagConstraints();
		gbc_lbl_TELEFONE_DO_REPRESENTANTE.anchor = GridBagConstraints.EAST;
		gbc_lbl_TELEFONE_DO_REPRESENTANTE.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_TELEFONE_DO_REPRESENTANTE.gridx = 1;
		gbc_lbl_TELEFONE_DO_REPRESENTANTE.gridy = 11;
		jpCenter.add(lbl_TELEFONE_DO_REPRESENTANTE, gbc_lbl_TELEFONE_DO_REPRESENTANTE);
		
		txtTelefones = new JTextField();
		GridBagConstraints gbc_txtTelefones = new GridBagConstraints();
		gbc_txtTelefones.anchor = GridBagConstraints.NORTH;
		gbc_txtTelefones.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefones.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefones.gridwidth = 5;
		gbc_txtTelefones.gridx = 2;
		gbc_txtTelefones.gridy = 11;
		jpCenter.add(txtTelefones, gbc_txtTelefones);
		txtTelefones.setColumns(10);
		
		lblEMAIL_DO_REPRESENTANTE = new JLabel("EMAIL DO REPRESENTANTE:");
		GridBagConstraints gbc_lblEMAIL_DO_REPRESENTANTE = new GridBagConstraints();
		gbc_lblEMAIL_DO_REPRESENTANTE.anchor = GridBagConstraints.WEST;
		gbc_lblEMAIL_DO_REPRESENTANTE.insets = new Insets(0, 0, 5, 5);
		gbc_lblEMAIL_DO_REPRESENTANTE.gridx = 1;
		gbc_lblEMAIL_DO_REPRESENTANTE.gridy = 12;
		jpCenter.add(lblEMAIL_DO_REPRESENTANTE, gbc_lblEMAIL_DO_REPRESENTANTE);
		
		txtEmailRepresentante = new JTextField();
		GridBagConstraints gbc_txtEmailRepresentante = new GridBagConstraints();
		gbc_txtEmailRepresentante.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmailRepresentante.anchor = GridBagConstraints.NORTH;
		gbc_txtEmailRepresentante.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailRepresentante.gridwidth = 5;
		gbc_txtEmailRepresentante.gridx = 2;
		gbc_txtEmailRepresentante.gridy = 12;
		jpCenter.add(txtEmailRepresentante, gbc_txtEmailRepresentante);
		txtEmailRepresentante.setColumns(10);
		
		btnCadastrar = new JButton("SALVAR");
		btnCadastrar.setToolTipText("SALVA DADOS CADASTRADOS");
		
		jpSul.add(btnCadastrar);

		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setToolTipText("LIMPA INFORMA\u00C7\u00D5ES MAS NAO SALVA ");
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
				produtosDAO = new ProdutosDAO(conect);
				produtos = new RegProdutos();
				
				// passando os valores dos textfields para uma classe separada
				produtos.setIdCodProduto(produtosDAO.proximoCodigo());
				produtos.setIdCodBarUni(Integer.parseInt(txtCODIGO_DE_BARRA_UNITARIO.getText()));
				produtos.setIdCodBarPack(Integer.parseInt(textFieldCODIGO_DE_BARRA_PACK.getText()));
				produtos.setDescricaoProduto(txtNome.getText());
				produtos.setQtdEstoque(Integer.parseInt(txtQuantidadeEstoque.getText()));
				produtos.setCusto(Float.parseFloat(txtCusto.getText()));
				
				//valor deve ser calculado e gerado antes de se colocar nesta variavel.
				//criar uma variavel auxiliar para calcular a margem de lucro antes de passar para esta variavel.				
				//produtos.setMargemdelucro(Float.parseFloat(margemdelucro.getText()));
				produtos.setMargemdelucro(0);
				//porcentagem = ? - calculo a ser definido se margem de lucro for definida por padrão ou pelo usuario.
								
				produtos.setPreco(Float.parseFloat(txtPrecoVarejo.getText()));
				produtos.setPrecoComRetornavel(Float.parseFloat(txtPrecoAtacado.getText()));
				produtos.setRepresentante(txtRepresentante.getText());
				produtos.setTelefones(txtTelefones.getText());
				produtos.setEmailRepresentante(txtEmailRepresentante.getText());
				produtos.setRepresentante(txtRepresentante.getText());
				produtos.setInativo(0);//no cadastro o padrão sera sempre (zero = ativo)								
						
				
				//este é mais complicado mas vou deixar um esboço
				//inicio
				if(rdbtnRetonavel.isSelected()){
					produtos.setRetornavel(1);
				}else{
					produtos.setRetornavel(0);
				}
				//fim
				
				produtosDAO.Incluir(produtos);
				conect.desconecta();
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!", "INFO", JOptionPane.INFORMATION_MESSAGE);
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
	
	private void limparCampos() {

		conect.conectar();
		int codigo = produtosDAO.proximoCodigo();
		conect.desconecta();
		
		jtfBdProduto.setText(String.valueOf(codigo));
		txtCODIGO_DE_BARRA_UNITARIO.setText("");
		textFieldCODIGO_DE_BARRA_PACK.setText("");
		txtNome.setText("");
		txtQuantidadeEstoque.setText("");
		margemdelucro.setText("0,00");
		txtCusto.setText("");
		txtPrecoVarejo.setText("");
		txtPrecoAtacado.setText("0");
		txtRepresentante.setText("");
		txtTelefones.setText("");
		txtEmailRepresentante.setText("");
		txtRepresentante.setText("");
		

	}
}
