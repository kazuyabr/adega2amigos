package gui.cadastrar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import classes.RegPedidos;
import classes.sql.Conexao;
import classes.sql.PedidoDAO;

@SuppressWarnings("serial")
public class FrmCadPedido extends JInternalFrame {
	private JTextField txtAtendente;
	private JTextField txtpedidos;
	private JFormattedTextField txtDataDoPedido;
	private JFormattedTextField txtDataDeEntrega;
	private MaskFormatter mfData;
	private MaskFormatter mfDataPed;
	private JTextField txtHoraDaEntrega;
	private JButton btnCadastrar;
	private JPanel jpCenter;
	private JPanel jpSul;
	private Conexao conect;
	private RegPedidos pedidos;
	private PedidoDAO pedidoDAO;
	private JLabel lblCliente;
	private JTextField txtCliente;
	private JLabel lblLocalEntrega;
	private JTextField txtEndereco;
	private JButton btnLimpar;
	private JLabel lblCodigo;
	private JTextField txtCodPedido;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtEstado;
	private JTextField txtContato;
	
	public FrmCadPedido() {
		setResizable(true);
		setTitle("Cadastro Pedido");
		setFrameIcon(null);
		setClosable(true);
		setBounds(100, 100, 540, 372);		
		getContentPane().setLayout(new BorderLayout());
		
		conect = new Conexao();
		conect.conectar();
		
		pedidoDAO = new PedidoDAO(conect);
		
		try {
			mfData = new MaskFormatter("##/##/####");
			mfData.setValidCharacters("1234567890");
			mfDataPed = new MaskFormatter("##/##/####");
			mfDataPed.setValidCharacters("1234567890");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jpCenter = new JPanel();
		getContentPane().add(BorderLayout.CENTER, jpCenter);
		
		jpSul = new JPanel();		
		getContentPane().add(BorderLayout.SOUTH, jpSul);
		jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GridBagLayout gbl_jpCenter = new GridBagLayout();
		gbl_jpCenter.columnWidths = new int[]{30, 83, 111, 87, 0, 37, 24, 68, 0};
		gbl_jpCenter.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 20, 0};
		gbl_jpCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpCenter.setLayout(gbl_jpCenter);
		
		lblCodigo = new JLabel("Codigo:");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 1;
		gbc_lblCodigo.gridy = 1;
		jpCenter.add(lblCodigo, gbc_lblCodigo);
		
		txtCodPedido = new JTextField(15);
		txtCodPedido.setEditable(false);
		txtCodPedido.setToolTipText("Codigo do banco de dados");
		GridBagConstraints gbc_txtCodPedido = new GridBagConstraints();
		gbc_txtCodPedido.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtCodPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodPedido.gridx = 2;
		gbc_txtCodPedido.gridy = 1;
		jpCenter.add(txtCodPedido, gbc_txtCodPedido);
		txtCodPedido.setColumns(10);
		
		JLabel lblAtendente = new JLabel("Atendente:");
		GridBagConstraints gbc_lblAtendente = new GridBagConstraints();
		gbc_lblAtendente.anchor = GridBagConstraints.EAST;
		gbc_lblAtendente.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtendente.gridx = 1;
		gbc_lblAtendente.gridy = 2;
		jpCenter.add(lblAtendente, gbc_lblAtendente);
		
		txtAtendente = new JTextField();
		txtAtendente.setToolTipText("Nome do atendente");
		GridBagConstraints gbc_txtAtendente = new GridBagConstraints();
		gbc_txtAtendente.anchor = GridBagConstraints.NORTH;
		gbc_txtAtendente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAtendente.insets = new Insets(0, 0, 5, 0);
		gbc_txtAtendente.gridwidth = 6;
		gbc_txtAtendente.gridx = 2;
		gbc_txtAtendente.gridy = 2;
		jpCenter.add(txtAtendente, gbc_txtAtendente);
		txtAtendente.setColumns(10);
		
		lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 3;
		jpCenter.add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setToolTipText("nome do cliente");
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtCliente.gridwidth = 6;
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 3;
		jpCenter.add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblpedido = new JLabel("pedido:");
		GridBagConstraints gbc_lblpedido = new GridBagConstraints();
		gbc_lblpedido.anchor = GridBagConstraints.EAST;
		gbc_lblpedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblpedido.gridx = 1;
		gbc_lblpedido.gridy = 4;
		jpCenter.add(lblpedido, gbc_lblpedido);
		
		txtpedidos = new JTextField();
		txtpedidos.setToolTipText("Nome do produto ou pe\u00E7a do pedido");
		GridBagConstraints gbc_txtpedidos = new GridBagConstraints();
		gbc_txtpedidos.anchor = GridBagConstraints.NORTH;
		gbc_txtpedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpedidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtpedidos.gridwidth = 6;
		gbc_txtpedidos.gridx = 2;
		gbc_txtpedidos.gridy = 4;
		jpCenter.add(txtpedidos, gbc_txtpedidos);
		txtpedidos.setColumns(10);
		
		JLabel lblDataDoPedido = new JLabel("Data do Pedido:");
		GridBagConstraints gbc_lblDataDoPedido = new GridBagConstraints();
		gbc_lblDataDoPedido.anchor = GridBagConstraints.EAST;
		gbc_lblDataDoPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDoPedido.gridx = 1;
		gbc_lblDataDoPedido.gridy = 5;
		jpCenter.add(lblDataDoPedido, gbc_lblDataDoPedido);
		
		txtDataDoPedido = new JFormattedTextField(mfDataPed);
		txtDataDoPedido.setToolTipText("data do pedido no formato DD/MM/AAAA");
		GridBagConstraints gbc_txtDataDoPedido = new GridBagConstraints();
		gbc_txtDataDoPedido.anchor = GridBagConstraints.NORTH;
		gbc_txtDataDoPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDataDoPedido.insets = new Insets(0, 0, 5, 0);
		gbc_txtDataDoPedido.gridwidth = 6;
		gbc_txtDataDoPedido.gridx = 2;
		gbc_txtDataDoPedido.gridy = 5;
		jpCenter.add(txtDataDoPedido, gbc_txtDataDoPedido);
		txtDataDoPedido.setColumns(10);
		
		JLabel lblDataDeEntrega = new JLabel("Data de Entrega:");
		GridBagConstraints gbc_lblDataDeEntrega = new GridBagConstraints();
		gbc_lblDataDeEntrega.anchor = GridBagConstraints.WEST;
		gbc_lblDataDeEntrega.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDeEntrega.gridx = 1;
		gbc_lblDataDeEntrega.gridy = 6;
		jpCenter.add(lblDataDeEntrega, gbc_lblDataDeEntrega);
		
		txtDataDeEntrega = new JFormattedTextField(mfData);
		txtDataDeEntrega.setToolTipText("Data de entrega no formato DD/MM/AAAA");
		GridBagConstraints gbc_txtDataDeEntrega = new GridBagConstraints();
		gbc_txtDataDeEntrega.anchor = GridBagConstraints.NORTH;
		gbc_txtDataDeEntrega.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDataDeEntrega.insets = new Insets(0, 0, 5, 0);
		gbc_txtDataDeEntrega.gridwidth = 6;
		gbc_txtDataDeEntrega.gridx = 2;
		gbc_txtDataDeEntrega.gridy = 6;
		jpCenter.add(txtDataDeEntrega, gbc_txtDataDeEntrega);
		txtDataDeEntrega.setColumns(10);
		
		lblLocalEntrega = new JLabel("Endere\u00E7o:");
		GridBagConstraints gbc_lblLocalEntrega = new GridBagConstraints();
		gbc_lblLocalEntrega.anchor = GridBagConstraints.EAST;
		gbc_lblLocalEntrega.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalEntrega.gridx = 1;
		gbc_lblLocalEntrega.gridy = 7;
		jpCenter.add(lblLocalEntrega, gbc_lblLocalEntrega);
		
		txtEndereco = new JTextField();
		txtEndereco.setToolTipText("informe o endere\u00E7o do cliente para entrega");
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.anchor = GridBagConstraints.NORTH;
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.gridwidth = 2;
		gbc_txtEndereco.gridx = 2;
		gbc_txtEndereco.gridy = 7;
		jpCenter.add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridwidth = 2;
		gbc_lblNumero.gridx = 5;
		gbc_lblNumero.gridy = 7;
		jpCenter.add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setToolTipText("informe o numero ou caixa");
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.anchor = GridBagConstraints.NORTH;
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.gridx = 7;
		gbc_txtNumero.gridy = 7;
		jpCenter.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 1;
		gbc_lblCidade.gridy = 8;
		jpCenter.add(lblCidade, gbc_lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setToolTipText("informe a cidade do cliente");
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridwidth = 2;
		gbc_txtCidade.gridx = 2;
		gbc_txtCidade.gridy = 8;
		jpCenter.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 5;
		gbc_lblBairro.gridy = 8;
		jpCenter.add(lblBairro, gbc_lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setToolTipText("informe o bairro");
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.anchor = GridBagConstraints.NORTH;
		gbc_txtBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 0);
		gbc_txtBairro.gridwidth = 2;
		gbc_txtBairro.gridx = 6;
		gbc_txtBairro.gridy = 8;
		jpCenter.add(txtBairro, gbc_txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 9;
		jpCenter.add(lblEstado, gbc_lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setToolTipText("Informe o estado");
		GridBagConstraints gbc_txtEstado = new GridBagConstraints();
		gbc_txtEstado.anchor = GridBagConstraints.SOUTH;
		gbc_txtEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEstado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEstado.gridx = 2;
		gbc_txtEstado.gridy = 9;
		jpCenter.add(txtEstado, gbc_txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato:");
		GridBagConstraints gbc_lblContato = new GridBagConstraints();
		gbc_lblContato.anchor = GridBagConstraints.EAST;
		gbc_lblContato.insets = new Insets(0, 0, 5, 5);
		gbc_lblContato.gridx = 3;
		gbc_lblContato.gridy = 9;
		jpCenter.add(lblContato, gbc_lblContato);
		
		txtContato = new JTextField();
		txtContato.setToolTipText("informe o contato(email, telefone ou outro)");
		GridBagConstraints gbc_txtContato = new GridBagConstraints();
		gbc_txtContato.anchor = GridBagConstraints.SOUTH;
		gbc_txtContato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContato.insets = new Insets(0, 0, 5, 0);
		gbc_txtContato.gridwidth = 4;
		gbc_txtContato.gridx = 4;
		gbc_txtContato.gridy = 9;
		jpCenter.add(txtContato, gbc_txtContato);
		txtContato.setColumns(10);
		
		JLabel lblHoraDaEntrega = new JLabel("Hora da Entrega:");
		GridBagConstraints gbc_lblHoraDaEntrega = new GridBagConstraints();
		gbc_lblHoraDaEntrega.anchor = GridBagConstraints.WEST;
		gbc_lblHoraDaEntrega.insets = new Insets(0, 0, 0, 5);
		gbc_lblHoraDaEntrega.gridwidth = 2;
		gbc_lblHoraDaEntrega.gridx = 1;
		gbc_lblHoraDaEntrega.gridy = 10;
		jpCenter.add(lblHoraDaEntrega, gbc_lblHoraDaEntrega);
		
		txtHoraDaEntrega = new JTextField();
		txtHoraDaEntrega.setToolTipText("Informe o horario da entrega no formato( 24h)");
		GridBagConstraints gbc_txtHoraDaEntrega = new GridBagConstraints();
		gbc_txtHoraDaEntrega.anchor = GridBagConstraints.NORTH;
		gbc_txtHoraDaEntrega.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraDaEntrega.gridwidth = 6;
		gbc_txtHoraDaEntrega.gridx = 2;
		gbc_txtHoraDaEntrega.gridy = 10;
		jpCenter.add(txtHoraDaEntrega, gbc_txtHoraDaEntrega);
		txtHoraDaEntrega.setColumns(10);
		
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
		int codigo = pedidoDAO.proximoCodigo();
		conect.desconecta();
		
		txtCodPedido.setText(String.valueOf(codigo));
		txtAtendente.setText("");
		txtCliente.setText("");
		txtpedidos.setText("");
		txtDataDoPedido.setText("");
		txtDataDeEntrega.setText("");
		txtEndereco.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtEstado.setText("");
		txtContato.setText("");
		txtHoraDaEntrega.setText("");
		
	}

	public JButton getBtnCadastrar() {
		
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				conect.conectar();
				pedidoDAO = new PedidoDAO(conect);
				pedidos = new RegPedidos();
				
				// passando os valores dos textfields para uma classe separada
				pedidos.setIdPedidos(pedidoDAO.proximoCodigo());
				pedidos.setAtendente(txtAtendente.getText());
				pedidos.setCliente(txtCliente.getText());
				pedidos.setPedido(txtpedidos.getText());
				
				try {
					pedidos.setDataPedido(new SimpleDateFormat("dd/MM/yyyy").parse(txtDataDoPedido.getText()));
					pedidos.setDataEntrega(new SimpleDateFormat("dd/MM/yyyy").parse(txtDataDeEntrega.getText()));
				} catch (ParseException e) {

					e.printStackTrace();
				}

				pedidos.setEndereçoEntrega(txtEndereco.getText());
				pedidos.setNumeroEndereco(Integer.parseInt(txtNumero.getText()));
				pedidos.setBairro(txtBairro.getText());
				pedidos.setCidade(txtCidade.getText());
				pedidos.setEstado(txtEstado.getText());
				pedidos.setContato(txtContato.getText());
				pedidos.setHoraEntrega(txtHoraDaEntrega.getText());
				
				pedidoDAO.Incluir(pedidos);
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
