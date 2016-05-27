package gui.cadastrar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.RegFornecedores;
import classes.sql.Conexao;
import classes.sql.FornecedoresDAO;

@SuppressWarnings("serial")
public class FrmCadFornec extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtContatoResponsavel;
	private JTextField txtNumero;
	private JButton btnCadastrar;
	private Conexao conect;
	private RegFornecedores fornecedores;
	private FornecedoresDAO fornecedoresDAO;
	private JButton btnLimpar;
	private JLabel lblCodigo;
	private JTextField jtfCodFornec;
	private JLabel lblBairro;
	private JTextField jtfBairro;
	private JLabel lblEstado;
	private JTextField jtfEstado;

	public FrmCadFornec() {
		setResizable(true);
		setTitle("Cadastro de Fornecedores");
		setFrameIcon(null);
		setClosable(true);
		setBounds(100, 100, 554, 280);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		conect = new Conexao();
		conect.conectar();
		
		fornecedoresDAO = new FornecedoresDAO(conect);
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(BorderLayout.CENTER, jpCenter);
		jpCenter.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(56, 33, 37, 14);
		jpCenter.add(lblCodigo);
		
		jtfCodFornec = new JTextField();
		jtfCodFornec.setEditable(false);
		jtfCodFornec.setBounds(98, 30, 65, 20);
		jtfCodFornec.setToolTipText("Codigo do banco de dados");
		jpCenter.add(jtfCodFornec);
		jtfCodFornec.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(62, 58, 31, 14);
		jpCenter.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(98, 55, 437, 20);
		txtNome.setToolTipText("Informe o nome do fornecedor");
		jpCenter.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(44, 83, 49, 14);
		jpCenter.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(98, 80, 274, 20);
		txtEndereco.setToolTipText("informe o endere\u00E7o");
		jpCenter.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(403, 83, 41, 14);
		jpCenter.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(449, 80, 86, 20);
		txtNumero.setToolTipText("informe o numero do endere\u00E7o");
		jpCenter.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(56, 108, 37, 14);
		jpCenter.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(98, 105, 437, 20);
		txtCidade.setToolTipText("informe a cidade");
		jpCenter.add(txtCidade);
		txtCidade.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(61, 133, 32, 14);
		jpCenter.add(lblBairro);
		
		jtfBairro = new JTextField();
		jtfBairro.setBounds(98, 130, 162, 20);
		jtfBairro.setToolTipText("informe o bairro");
		jpCenter.add(jtfBairro);
		jtfBairro.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(377, 133, 37, 14);
		jpCenter.add(lblEstado);
		
		jtfEstado = new JTextField();
		jtfEstado.setBounds(419, 130, 116, 20);
		jtfEstado.setToolTipText("Informe o estado");
		jpCenter.add(jtfEstado);
		jtfEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(47, 158, 46, 14);
		jpCenter.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(98, 155, 162, 20);
		txtTelefone.setToolTipText("informe o telefone");
		jpCenter.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblContatoResponsavel = new JLabel("Contato Responsavel:");
		lblContatoResponsavel.setBounds(265, 158, 107, 14);
		jpCenter.add(lblContatoResponsavel);
		
		txtContatoResponsavel = new JTextField();
		txtContatoResponsavel.setBounds(377, 155, 158, 20);
		txtContatoResponsavel.setToolTipText("Informe o contato(Email ou telefone ou outros...)");
		jpCenter.add(txtContatoResponsavel);
		txtContatoResponsavel.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(65, 183, 28, 14);
		jpCenter.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(98, 180, 437, 20);
		txtEmail.setToolTipText("Informe o email do Fornecedor");
		jpCenter.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel jpSul = new JPanel();
		getContentPane().add(BorderLayout.SOUTH, jpSul);
		
		btnCadastrar = new JButton("CADASTRAR");
		jpSul.add(btnCadastrar);
		
		btnLimpar = new JButton("LIMPAR");
		jpSul.add(btnLimpar);

		getBtnCadastrar();
		getBtnLimpar();
		
		
		
		limparCampos();
		
	}

	private void limparCampos() {

		conect.conectar();
		int codigo = fornecedoresDAO.proximoCodigo();
		conect.desconecta();
		
		jtfCodFornec.setText(String.valueOf(codigo));
		txtNome.setText("");
		txtEndereco.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		jtfBairro.setText("");
		jtfEstado.setText("");
		txtTelefone.setText("");
		txtContatoResponsavel.setText("");
		txtEmail.setText("");

	}
	
	public JButton getBtnCadastrar() {
		
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				conect.conectar();
				fornecedores = new RegFornecedores();
				
				// passando os valores dos textfields para uma classe separada
				fornecedores.setCodFornec(Integer.parseInt(jtfCodFornec.getText()));
				fornecedores.setNomeFornecedor(txtNome.getText());
				fornecedores.setEnderecoFornecedor(txtEndereco.getText());
				fornecedores.setNumeroFornecedor(Integer.parseInt(txtNumero.getText()));
				fornecedores.setCidadeFornecedor(txtCidade.getText());
				fornecedores.setBairroFornecedor(jtfBairro.getText());
				fornecedores.setEstadoFornecedor(jtfEstado.getText());
				fornecedores.setTelefoneFornecedor(Integer.parseInt(txtTelefone.getText()));
				fornecedores.setContatoResponsavel(txtContatoResponsavel.getText());
				fornecedores.setEmailFornecedor(txtEmail.getText());
						 
				fornecedoresDAO.Incluir(fornecedores);
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
}
