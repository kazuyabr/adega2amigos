package gui.consultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import classes.RegFuncionario;
import classes.sql.Conexao;
import classes.sql.FuncionarioDAO;

@SuppressWarnings("serial")
public class Funcionarios extends JInternalFrame {
	private JTextField txtNome;
	private Conexao conect;
	private JButton btnConsultar;
	private JButton btnSair;
	private DefaultTableModel modelo;
	private String[] campos = new String[] {"idFunc", "usuario", "senha", "nome", "sexo", "dataDeNasc", "rg", "cpf", "endereco", "numero", "bairro", "cidade", "estado", "cep", "telefone", "celular", "email", "cargo"};
	private String[][] dados = {{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JPasswordField passwordField;
	private JTextField textField_15;
	private JTextField txtAtiva;
	private JFormattedTextField jtfDataDeNasc;
	private MaskFormatter mfdatanasc;	
	
		
	public Funcionarios() {
		setFrameIcon(null);
		
		setTitle("Consulta Pessoas: Funcionarios");
		setResizable(true);
				
		setMaximizable(true);
		setBounds(100, 100, 702, 461);		
		setSize(707, 479);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
				
		JPanel jpNorte = new JPanel();
		getContentPane().add(jpNorte, BorderLayout.NORTH);
		jpNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNome = new JLabel("Nome:");
		jpNorte.add(lblNome);
		
		txtNome = new JTextField(20);
		txtNome.setToolTipText("Utilize % para fazer pesquisa aproximada.");
		jpNorte.add(txtNome);
		txtNome.setColumns(25);
		
		btnConsultar = new JButton("CONSULTAR");
		jpNorte.add(btnConsultar);
		
		
		
		getBtnConsultar();
		
		JPanel jpSul = new JPanel();
		getContentPane().add(jpSul, BorderLayout.SOUTH);
		jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnInativar = new JButton("INATIVAR");
		btnInativar.setToolTipText("INATIVAR/REATIVAR TODOS AS TELA DE CONSULTAR ");
		jpSul.add(btnInativar);
		
		JButton btnNewButton = new JButton("ALTERA");
		btnNewButton.setToolTipText("ALTERA /SALVA TODAS AS TELA DE CONSULTA");
		jpSul.add(btnNewButton);
		
		btnSair = new JButton("SAIR");
		jpSul.add(btnSair);
		
		JPanel jpCentro = new JPanel();
		getContentPane().add(jpCentro, BorderLayout.CENTER);
		jpCentro.setLayout(null);
		
		JLabel label = new JLabel("Codigo:");
		label.setBounds(96, 14, 37, 14);
		jpCentro.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("Codigo do banco de dados");
		textField.setText("0");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(138, 11, 81, 20);
		jpCentro.add(textField);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(102, 39, 31, 14);
		jpCentro.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Informe o nome completo do funcionario");
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(138, 36, 462, 20);
		jpCentro.add(textField_1);
		
		JLabel label_2 = new JLabel("Sexo:");
		label_2.setBounds(105, 61, 28, 23);
		jpCentro.add(label_2);
		
		JRadioButton radioButton = new JRadioButton("Masculino");
		radioButton.setSelected(true);
		radioButton.setBounds(138, 61, 81, 23);
		jpCentro.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Feminino");
		radioButton_1.setSelected(false);
		radioButton_1.setBounds(224, 61, 67, 23);
		jpCentro.add(radioButton_1);
		
		JLabel label_3 = new JLabel("Data de Nascimento:");
		label_3.setBounds(33, 92, 100, 14);
		jpCentro.add(label_3);
		
		try {
			mfdatanasc = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mfdatanasc.setValidCharacters("1234567890");
		
		jtfDataDeNasc = new JFormattedTextField(mfdatanasc);
		jtfDataDeNasc.setToolTipText("Informe a data de nascimento no formato DD/MM/AAAA");
		jtfDataDeNasc.setText("");
		jtfDataDeNasc.setColumns(10);
		jtfDataDeNasc.setBounds(138, 89, 167, 20);
		jpCentro.add(jtfDataDeNasc);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Informe o RG");
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(489, 89, 111, 20);
		jpCentro.add(textField_2);
		
		JLabel label_4 = new JLabel("RG:");
		label_4.setBounds(466, 92, 18, 14);
		jpCentro.add(label_4);
		
		JLabel label_5 = new JLabel("CEP:");
		label_5.setBounds(461, 118, 23, 14);
		jpCentro.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Informe o CEP");
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBounds(489, 115, 111, 20);
		jpCentro.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Informe o cpf/cnpj");
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(138, 115, 167, 20);
		jpCentro.add(textField_4);
		
		JLabel label_6 = new JLabel("Endere\u00E7o:");
		label_6.setBounds(84, 143, 49, 14);
		jpCentro.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("informe o endereco");
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBounds(138, 140, 264, 20);
		jpCentro.add(textField_5);
		
		JLabel label_7 = new JLabel("Numero:");
		label_7.setBounds(443, 143, 41, 14);
		jpCentro.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBounds(489, 140, 111, 20);
		jpCentro.add(textField_6);
		
		JLabel label_8 = new JLabel("Cidade:");
		label_8.setBounds(96, 168, 37, 14);
		jpCentro.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Informe a cidade");
		textField_7.setText("");
		textField_7.setColumns(10);
		textField_7.setBounds(138, 165, 462, 20);
		jpCentro.add(textField_7);
		
		JLabel label_9 = new JLabel("Bairro:");
		label_9.setBounds(101, 193, 32, 14);
		jpCentro.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("informe o bairro");
		textField_8.setText("");
		textField_8.setColumns(10);
		textField_8.setBounds(138, 190, 264, 20);
		jpCentro.add(textField_8);
		
		JLabel label_10 = new JLabel("Estado:");
		label_10.setBounds(447, 193, 37, 14);
		jpCentro.add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("informe o estado");
		textField_9.setText("");
		textField_9.setColumns(10);
		textField_9.setBounds(489, 190, 111, 20);
		jpCentro.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("Informe o telefone");
		textField_10.setText("");
		textField_10.setColumns(10);
		textField_10.setBounds(138, 215, 167, 20);
		jpCentro.add(textField_10);
		
		JLabel label_11 = new JLabel("Telefone:");
		label_11.setBounds(87, 218, 46, 14);
		jpCentro.add(label_11);
		
		JLabel label_12 = new JLabel("Celular:");
		label_12.setBounds(401, 218, 37, 14);
		jpCentro.add(label_12);
		
		textField_11 = new JTextField();
		textField_11.setToolTipText("informe o celular");
		textField_11.setText("");
		textField_11.setColumns(10);
		textField_11.setBounds(443, 215, 157, 20);
		jpCentro.add(textField_11);
		
		JLabel label_13 = new JLabel("Email:");
		label_13.setBounds(105, 243, 28, 14);
		jpCentro.add(label_13);
		
		textField_12 = new JTextField();
		textField_12.setToolTipText("Informe o email");
		textField_12.setText("");
		textField_12.setColumns(10);
		textField_12.setBounds(138, 240, 462, 20);
		jpCentro.add(textField_12);
		
		JLabel label_14 = new JLabel("Cargo:");
		label_14.setBounds(100, 268, 33, 14);
		jpCentro.add(label_14);
		
		textField_13 = new JTextField();
		textField_13.setToolTipText("informe o cargo");
		textField_13.setText("");
		textField_13.setColumns(10);
		textField_13.setBounds(138, 265, 111, 20);
		jpCentro.add(textField_13);
		
		JLabel label_15 = new JLabel("Usuario:");
		label_15.setBounds(265, 268, 40, 14);
		jpCentro.add(label_15);
		
		textField_14 = new JTextField();
		textField_14.setToolTipText("Informe o nome de usuario que sera usado no sistema");
		textField_14.setText("");
		textField_14.setColumns(10);
		textField_14.setBounds(310, 265, 128, 20);
		jpCentro.add(textField_14);
		
		JLabel label_16 = new JLabel("Senha:");
		label_16.setBounds(450, 268, 34, 14);
		jpCentro.add(label_16);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("informe a senha");
		passwordField.setText("");
		passwordField.setEchoChar('*');
		passwordField.setBounds(489, 265, 111, 20);
		jpCentro.add(passwordField);
		
		JLabel label_17 = new JLabel("NIVEL DE ACESSO");
		label_17.setBounds(33, 300, 100, 14);
		jpCentro.add(label_17);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setToolTipText("AQUI COLOCA O NUMERO DE NIVEL QUE O USUARIO PODERA ACESSAR");
		textField_15.setColumns(10);
		textField_15.setBounds(138, 297, 49, 20);
		jpCentro.add(textField_15);
		
		JLabel lblStaus = new JLabel("STAUS");
		lblStaus.setBounds(234, 14, 46, 14);
		jpCentro.add(lblStaus);
		
		txtAtiva = new JTextField();
		txtAtiva.setText("ATIVA");
		txtAtiva.setBounds(290, 11, 86, 20);
		jpCentro.add(txtAtiva);
		txtAtiva.setColumns(10);
		
		modelo = new DefaultTableModel(dados, campos);
		
		getBtnSair();

	}



	public JButton getBtnConsultar() {
		 btnConsultar.addActionListener(new ActionListener() {

		 @Override
		 public void actionPerformed(ActionEvent arg0) {
		 String consulta = "%";
		 conect = new Conexao();
		 conect.conectar();
		 FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conect);


		 modelo = new DefaultTableModel();
		 modelo.setColumnIdentifiers(campos);

		 if(txtNome.getText().toUpperCase().equals("")){
			 consulta = "%"; 
			 }else{
				 consulta = txtNome.getText().toUpperCase();
			 }

		 for(RegFuncionario fun : funcionarioDAO.consultar(consulta)){
		 modelo.addRow(new Object[] {fun.getCodigoFuncionario(), fun.getUsuario(), fun.getSenhaOriginal(), fun.getNomeFuncionario(), fun.getSexoFuncionario(),  new SimpleDateFormat("dd/MM/yyyy").format(fun.getDataNascFuncionario()).toString(), fun.getRgFuncionario(), fun.getCpfFuncionario(), fun.getEnderecoFuncionario(), fun.getNumeroEndereco(), fun.getBairroFuncionario(), fun.getCidadeFuncionario(), fun.getEstadoFuncionario(), fun.getCepFuncionario(), fun.getTelefoneFuncionario(), fun.getCelularFuncionario(), fun.getEmailFuncionario(), fun.getCargoFuncionario()} );
		 }

		
		 conect.desconecta();

		 }
		 });
		 return btnConsultar;
		 }

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}



	public JButton getBtnSair() {
		
		btnSair.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
			
		});
		
		return btnSair;
	}



	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}
}
