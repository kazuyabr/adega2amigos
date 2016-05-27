package gui.consultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import classes.RegFornecedores;
import classes.sql.Conexao;
import classes.sql.FornecedoresDAO;

@SuppressWarnings("serial")
public class Fornecedores extends JInternalFrame {
	private JTextField txtNome;
	private Conexao conect;
	private JButton btnConsultar;
	private JButton btnSair;
	private DefaultTableModel modelo;
	private String[] campos = new String[] {"idFornec", "nome", "endereco", "numero", "cidade", "bairro", "estado", "telefone", "contatoResponsavel", "email"};
	private String[][] dados = {{"", "", "", "", "", "", "", "", "", ""}};
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
	private JTextField txtAtivo;
	
		
	public Fornecedores() {
		setIconifiable(true);
		setFrameIcon(null);
		
		setTitle("Consulta Pessoas: Fornecedores");
		setResizable(true);
				
		setMaximizable(true);
		setBounds(100, 100, 702, 461);		
		setSize(580, 307);
		
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
		
		JButton btnNewButton_1 = new JButton("INATIVAR");
		jpSul.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("ALTERA");
		jpSul.add(btnNewButton);
		
		btnSair = new JButton("SAIR");
		jpSul.add(btnSair);
		
		JPanel jpCentro = new JPanel();
		getContentPane().add(jpCentro, BorderLayout.CENTER);
		GridBagLayout gbl_jpCentro = new GridBagLayout();
		gbl_jpCentro.columnWidths = new int[]{434, 0};
		gbl_jpCentro.rowHeights = new int[]{149, 0};
		gbl_jpCentro.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpCentro.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		jpCentro.setLayout(gbl_jpCentro);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		jpCentro.add(panel, gbc_panel);
		
		JLabel label = new JLabel("Codigo:");
		label.setBounds(56, 33, 37, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("Codigo do banco de dados");
		textField.setText("0");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(98, 30, 65, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(62, 58, 31, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Informe o nome do fornecedor");
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(98, 55, 437, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Endere\u00E7o:");
		label_2.setBounds(44, 83, 49, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("informe o endere\u00E7o");
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(98, 80, 274, 20);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Numero:");
		label_3.setBounds(403, 83, 41, 14);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("informe o numero do endere\u00E7o");
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBounds(449, 80, 86, 20);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setBounds(56, 108, 37, 14);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("informe a cidade");
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(98, 105, 437, 20);
		panel.add(textField_4);
		
		JLabel label_5 = new JLabel("Bairro:");
		label_5.setBounds(61, 133, 32, 14);
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("informe o bairro");
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBounds(98, 130, 162, 20);
		panel.add(textField_5);
		
		JLabel label_6 = new JLabel("Estado:");
		label_6.setBounds(377, 133, 37, 14);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Informe o estado");
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBounds(419, 130, 116, 20);
		panel.add(textField_6);
		
		JLabel label_7 = new JLabel("Telefone:");
		label_7.setBounds(47, 158, 46, 14);
		panel.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("informe o telefone");
		textField_7.setText("");
		textField_7.setColumns(10);
		textField_7.setBounds(98, 155, 162, 20);
		panel.add(textField_7);
		
		JLabel label_8 = new JLabel("Contato Responsavel:");
		label_8.setBounds(265, 158, 107, 14);
		panel.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Informe o contato(Email ou telefone ou outros...)");
		textField_8.setText("");
		textField_8.setColumns(10);
		textField_8.setBounds(377, 155, 158, 20);
		panel.add(textField_8);
		
		JLabel label_9 = new JLabel("Email:");
		label_9.setBounds(65, 183, 28, 14);
		panel.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Informe o email do Fornecedor");
		textField_9.setText("");
		textField_9.setColumns(10);
		textField_9.setBounds(98, 180, 437, 20);
		panel.add(textField_9);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(216, 33, 46, 14);
		panel.add(lblStatus);
		
		txtAtivo = new JTextField();
		txtAtivo.setText("ATIVO");
		txtAtivo.setBounds(272, 30, 86, 20);
		panel.add(txtAtivo);
		txtAtivo.setColumns(10);
		
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
		 FornecedoresDAO fornecedoresDAO = new FornecedoresDAO(conect);


		 modelo = new DefaultTableModel();
		 modelo.setColumnIdentifiers(campos);

		 if(txtNome.getText().toUpperCase().equals("")){
			 consulta = "%"; 
			 }else{
				 consulta = txtNome.getText().toUpperCase();
			 }

		 for(RegFornecedores fnc : fornecedoresDAO.consultar(consulta)){
		 modelo.addRow(new Object[] {fnc.getCodFornec(), fnc.getNomeFornecedor(), fnc.getEnderecoFornecedor(), fnc.getNumeroFornecedor(), fnc.getCidadeFornecedor(), fnc.getBairroFornecedor(), fnc.getEstadoFornecedor(), fnc.getTelefoneFornecedor(), fnc.getContatoResponsavel(), fnc.getEmailFornecedor()} );
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
