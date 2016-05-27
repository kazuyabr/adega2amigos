package gui.cadastrar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import classes.RegFuncionario;
import classes.sql.Conexao;
import classes.sql.FuncionarioDAO;
import lib.GerarHash;

@SuppressWarnings("serial")
public class FrmCadFunc extends JInternalFrame {
	private JTextField txtNomeFunc;
	private JFormattedTextField txtDataFuncionario;
	private MaskFormatter mfdatanasc;
	private JTextField txtCargo;
	private JTextField txtRg;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField jtfEstado;
	private JTextField jtfCep;
	private JTextField jtfTelefone;
	private JTextField jtfCelular;
	private JTextField jtfEmail;
	private JTextField jtfBairro;
	private JTextField jtfUsuario;
	private JPasswordField jpfSenha;
	private JButton btnCadastrar;
	private ButtonGroup bgSex;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;	
	private Conexao conect;
	private RegFuncionario funcionario;
	private FuncionarioDAO funcionarioDAO;
	private JLabel lblNumero;
	private JTextField txtNum;
	private JButton btnLimpar;
	private JLabel lblCodigo;
	private JTextField txtCodFuncionario;
	private JTextField textField;

	public FrmCadFunc() {
		setResizable(true);
		setClosable(true);
		setFrameIcon(null);
		setTitle("Cadastrar Funcionario");
		setBounds(100, 100, 647, 489);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		conect = new Conexao();
		conect.conectar();
		
		funcionarioDAO = new FuncionarioDAO(conect);
		
		try {
			mfdatanasc = new MaskFormatter("##/##/####");
			mfdatanasc.setValidCharacters("1234567890");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(BorderLayout.CENTER, jpCenter);
		jpCenter.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(95, 25, 37, 14);
		jpCenter.add(lblCodigo);
		
		txtCodFuncionario = new JTextField();
		txtCodFuncionario.setBounds(137, 22, 81, 20);
		txtCodFuncionario.setEditable(false);
		txtCodFuncionario.setToolTipText("Codigo do banco de dados");
		jpCenter.add(txtCodFuncionario);
		txtCodFuncionario.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(101, 50, 31, 14);
		jpCenter.add(lblNome);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(137, 47, 462, 20);
		txtNomeFunc.setToolTipText("Informe o nome completo do funcionario");
		jpCenter.add(txtNomeFunc);
		txtNomeFunc.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(104, 72, 28, 23);
		jpCenter.add(lblSexo);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(137, 72, 81, 23);
		rdbtnMasculino.setSelected(true);
		jpCenter.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(223, 72, 67, 23);
		jpCenter.add(rdbtnFeminino);

		bgSex = new ButtonGroup();
		bgSex.add(rdbtnMasculino);
		bgSex.add(rdbtnFeminino);
		
		if(rdbtnMasculino.isSelected()){
			System.out.println(bgSex.getSelection().getActionCommand());
		}else{
			System.out.println(bgSex.getSelection().getActionCommand());
		}

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(32, 103, 100, 14);
		jpCenter.add(lblDataDeNascimento);

		txtDataFuncionario = new JFormattedTextField(mfdatanasc);
		txtDataFuncionario.setBounds(137, 100, 167, 20);
		txtDataFuncionario.setToolTipText("Informe a data de nascimento no formato DD/MM/AAAA");
		jpCenter.add(txtDataFuncionario);
		txtDataFuncionario.setColumns(10);
		
				JLabel lblRg = new JLabel("RG:");
				lblRg.setBounds(465, 103, 18, 14);
				jpCenter.add(lblRg);

		txtRg = new JTextField();
		txtRg.setBounds(488, 100, 111, 20);
		txtRg.setToolTipText("Informe o RG");
		jpCenter.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblCpf_Cnpj = new JLabel("CPF/CNPJ:");
		lblCpf_Cnpj.setBounds(80, 129, 52, 14);
		jpCenter.add(lblCpf_Cnpj);

		txtCPF = new JTextField();
		txtCPF.setBounds(137, 126, 167, 20);
		txtCPF.setToolTipText("Informe o cpf/cnpj");
		jpCenter.add(txtCPF);
		txtCPF.setColumns(10);
		
				JLabel lblCep = new JLabel("CEP:");
				lblCep.setBounds(460, 129, 23, 14);
				jpCenter.add(lblCep);

		jtfCep = new JTextField();
		jtfCep.setBounds(488, 126, 111, 20);
		jtfCep.setToolTipText("Informe o CEP");
		jpCenter.add(jtfCep);
		jtfCep.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(83, 154, 49, 14);
		jpCenter.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(137, 151, 264, 20);
		txtEndereco.setToolTipText("informe o endereco");
		jpCenter.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(442, 154, 41, 14);
		jpCenter.add(lblNumero);
		
		txtNum = new JTextField();
		txtNum.setBounds(488, 151, 111, 20);
		jpCenter.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(95, 179, 37, 14);
		jpCenter.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(137, 176, 462, 20);
		txtCidade.setToolTipText("Informe a cidade");
		jpCenter.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(100, 204, 32, 14);
		jpCenter.add(lblBairro);

		jtfBairro = new JTextField();
		jtfBairro.setBounds(137, 201, 264, 20);
		jtfBairro.setToolTipText("informe o bairro");
		jpCenter.add(jtfBairro);
		jtfBairro.setColumns(10);
				
						JLabel lblEstado = new JLabel("Estado:");
						lblEstado.setBounds(446, 204, 37, 14);
						jpCenter.add(lblEstado);
		
				jtfEstado = new JTextField();
				jtfEstado.setBounds(488, 201, 111, 20);
				jtfEstado.setToolTipText("informe o estado");
				jpCenter.add(jtfEstado);
				jtfEstado.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(86, 229, 46, 14);
		jpCenter.add(lblTelefone);

		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(137, 226, 167, 20);
		jtfTelefone.setToolTipText("Informe o telefone");
		jpCenter.add(jtfTelefone);
		jtfTelefone.setColumns(10);
				
						JLabel lblCelular = new JLabel("Celular:");
						lblCelular.setBounds(400, 229, 37, 14);
						jpCenter.add(lblCelular);
		
				jtfCelular = new JTextField();
				jtfCelular.setBounds(442, 226, 157, 20);
				jtfCelular.setToolTipText("informe o celular");
				jpCenter.add(jtfCelular);
				jtfCelular.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(104, 254, 28, 14);
		jpCenter.add(lblEmail);

		jtfEmail = new JTextField();
		jtfEmail.setBounds(137, 251, 462, 20);
		jtfEmail.setToolTipText("Informe o email");
		jpCenter.add(jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(99, 279, 33, 14);
		jpCenter.add(lblCargo);

		txtCargo = new JTextField();
		txtCargo.setBounds(137, 276, 111, 20);
		txtCargo.setToolTipText("informe o cargo");
		jpCenter.add(txtCargo);
		txtCargo.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(264, 279, 40, 14);
		jpCenter.add(lblUsuario);

		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(309, 276, 128, 20);
		jtfUsuario.setToolTipText("Informe o nome de usuario que sera usado no sistema");
		jpCenter.add(jtfUsuario);
		jtfUsuario.setColumns(10);
				
						JLabel lblSenha = new JLabel("Senha:");
						lblSenha.setBounds(449, 279, 34, 14);
						jpCenter.add(lblSenha);
		
				jpfSenha = new JPasswordField();
				jpfSenha.setBounds(488, 276, 111, 20);
				jpfSenha.setToolTipText("informe a senha");
				jpfSenha.setEchoChar('*');
				jpCenter.add(jpfSenha);
				
				JLabel lblNivelDeAcesso = new JLabel("NIVEL DE ACESSO");
				lblNivelDeAcesso.setBounds(32, 311, 100, 14);
				jpCenter.add(lblNivelDeAcesso);
				
				textField = new JTextField();
				textField.setToolTipText("AQUI COLOCA O NUMERO DE NIVEL QUE O USUARIO PODERA ACESSAR");
				textField.setBounds(137, 308, 86, 20);
				jpCenter.add(textField);
				textField.setColumns(10);

		JPanel jpSul = new JPanel();
		getContentPane().add(BorderLayout.SOUTH, jpSul);
		jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnCadastrar = new JButton("CADASTRAR");
		jpSul.add(btnCadastrar);
		
		btnLimpar = new JButton("LIMPAR");
		jpSul.add(btnLimpar);
		
		getBtnCadastrar();
		getBtnLimpar();
		
		limparCampos();

	}

	public JTextField getTxtNomeFunc() {
		return txtNomeFunc;
	}

	public void setTxtNomeFunc(JTextField txtNomeFunc) {
		this.txtNomeFunc = txtNomeFunc;
	}

	public JTextField getTxtDataFuncionario() {
		return txtDataFuncionario;
	}

	public void setTxtDataFuncionario(JFormattedTextField txtDataFuncionario) {
		this.txtDataFuncionario = txtDataFuncionario;
	}

	public JTextField getTxtCargo() {
		return txtCargo;
	}

	public void setTxtCargo(JTextField txtCargo) {
		this.txtCargo = txtCargo;
	}

	public JTextField getTxtRg() {
		return txtRg;
	}

	public JTextField getTxtNum() {
		return txtNum;
	}

	public void setTxtNum(JTextField txtNum) {
		this.txtNum = txtNum;
	}

	public void setTxtRg(JTextField txtRg) {
		this.txtRg = txtRg;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public void setTxtCidade(JTextField txtCidade) {
		this.txtCidade = txtCidade;
	}

	public JTextField getJtfEstado() {
		return jtfEstado;
	}

	public void setJtfEstado(JTextField jtfEstado) {
		this.jtfEstado = jtfEstado;
	}

	public JTextField getJtfCep() {
		return jtfCep;
	}

	public void setJtfCep(JTextField jtfCep) {
		this.jtfCep = jtfCep;
	}

	public JTextField getJtfTelefone() {
		return jtfTelefone;
	}

	public void setJtfTelefone(JTextField jtfTelefone) {
		this.jtfTelefone = jtfTelefone;
	}

	public JTextField getJtfCelular() {
		return jtfCelular;
	}

	public void setJtfCelular(JTextField jtfCelular) {
		this.jtfCelular = jtfCelular;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public void setJtfEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}

	public JTextField getJtfBairro() {
		return jtfBairro;
	}

	public void setJtfBairro(JTextField jtfBairro) {
		this.jtfBairro = jtfBairro;
	}

	public JTextField getJtfUsuario() {
		return jtfUsuario;
	}

	public void setJtfUsuario(JTextField jtfUsuario) {
		this.jtfUsuario = jtfUsuario;
	}

	public JPasswordField getJpfSenha() {
		return jpfSenha;
	}

	public void setJpfSenha(JPasswordField jpfSenha) {
		this.jpfSenha = jpfSenha;
	}

	public JRadioButton getRdbtnMasculino() {
		return rdbtnMasculino;
	}

	public void setRdbtnMasculino(JRadioButton rdbtnMasculino) {
		this.rdbtnMasculino = rdbtnMasculino;
	}

	public JRadioButton getRdbtnFeminino() {
		return rdbtnFeminino;
	}

	public void setRdbtnFeminino(JRadioButton rdbtnFeminino) {
		this.rdbtnFeminino = rdbtnFeminino;
	}

	public JButton getBtnCadastrar() {

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				conect.conectar();				
				funcionarioDAO = new FuncionarioDAO(conect);
				funcionario = new RegFuncionario();
				
				//passando os valores dos textfields para uma classe separada
				funcionario.setCodigoFuncionario(funcionarioDAO.proximoCodigo());
				funcionario.setUsuario(jtfUsuario.getText().toLowerCase());
				funcionario.setSenhaOriginal(String.valueOf(jpfSenha.getPassword()));
				funcionario.setSenhaCrypt(GerarHash.stringHexa(GerarHash.gerarHash(String.valueOf(jpfSenha.getPassword()), "MD5")));
				funcionario.setNomeFuncionario(txtNomeFunc.getText().toUpperCase());
				if(rdbtnMasculino.isSelected()){
				funcionario.setSexoFuncionario("M");
				}else{
					funcionario.setSexoFuncionario("F");
				}
				try{
				funcionario.setDataNascFuncionario(new SimpleDateFormat("dd/MM/yyyy").parse(txtDataFuncionario.getText()));
				} catch (ParseException e) {
					 
					 e.printStackTrace();
					 }
				funcionario.setRgFuncionario(Integer.parseInt(txtRg.getText()));
				funcionario.setCpfFuncionario(Long.parseLong(txtCPF.getText()));
				funcionario.setEnderecoFuncionario(txtEndereco.getText());
				funcionario.setNumeroEndereco(Integer.parseInt(txtNum.getText()));
				funcionario.setCidadeFuncionario(txtCidade.getText());
				funcionario.setBairroFuncionario(jtfBairro.getText());
				funcionario.setEstadoFuncionario(jtfEstado.getText());
				funcionario.setCepFuncionario(Integer.parseInt(jtfCep.getText()));
				funcionario.setTelefoneFuncionario(jtfTelefone.getText());
				funcionario.setCelularFuncionario(jtfCelular.getText());
				funcionario.setEmailFuncionario(jtfEmail.getText());
				funcionario.setCargoFuncionario(txtCargo.getText());
								
				funcionarioDAO.Incluir(funcionario);
				conect.desconecta();
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
				limparCampos();		

			}
		});

		return btnCadastrar;
	}

	
	private void limparCampos(){
		
		conect.conectar();
		int codigo = funcionarioDAO.proximoCodigo();
		conect.desconecta();
		
		txtCodFuncionario.setText(String.valueOf(codigo));
		txtNomeFunc.setText("");
		txtDataFuncionario.setText("");
		txtCargo.setText("");
		txtRg.setText("");
		txtCPF.setText("");
		txtEndereco.setText("");
		txtNum.setText("");
		txtCidade.setText("");
		jtfEstado.setText("");
		jtfCep.setText("");
		jtfTelefone.setText("");
		jtfCelular.setText("");
		jtfEmail.setText("");
		jtfBairro.setText("");
		jtfUsuario.setText("");
		jpfSenha.setText("");		
		rdbtnMasculino.setSelected(false);
		rdbtnFeminino.setSelected(false);		
		
	
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

	
}
