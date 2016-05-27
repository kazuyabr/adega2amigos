package gui.consultas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ConsultaPedido extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField jtfAtendente;
	private JTextField jtfCliente;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField txtAtivo;
	private JFormattedTextField jtfDataPedido;
	private JFormattedTextField jtfDataEntrega;
	private MaskFormatter mfdata;	

	public ConsultaPedido() {
		setTitle("CONSULTAR PEDIDOS");
		setBounds(100, 100, 757, 428);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPedidos = new JLabel("NUMERO DO PEDIDO:");
		panel.add(lblPedidos);
		
		textField = new JTextField(25);
		textField.setToolTipText("Utilize % para fazer pesquisa aproximada.");
		panel.add(textField);
		
		JButton button = new JButton("CONSULTAR");
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Codigo:");
		label.setBounds(76, 33, 37, 14);
		panel_1.add(label);
		
		textField_1 = new JTextField(10);
		textField_1.setBounds(118, 30, 86, 20);
		textField_1.setToolTipText("Codigo do banco de dados");
		textField_1.setText("0");
		textField_1.setEditable(false);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("Atendente:");
		label_1.setBounds(58, 58, 55, 14);
		panel_1.add(label_1);
		
		jtfAtendente = new JTextField();
		jtfAtendente.setBounds(118, 55, 223, 20);
		jtfAtendente.setToolTipText("Nome do atendente");
		jtfAtendente.setText("");
		jtfAtendente.setColumns(10);
		panel_1.add(jtfAtendente);
		
		JLabel label_2 = new JLabel("Cliente:");
		label_2.setBounds(76, 83, 37, 14);
		panel_1.add(label_2);
		
		jtfCliente = new JTextField();
		jtfCliente.setBounds(118, 80, 469, 20);
		jtfCliente.setToolTipText("nome do cliente");
		jtfCliente.setText("");
		jtfCliente.setColumns(10);
		panel_1.add(jtfCliente);
		
		JLabel label_3 = new JLabel("pedido:");
		label_3.setBounds(77, 108, 36, 14);
		panel_1.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(118, 105, 469, 20);
		textField_4.setToolTipText("Nome do produto ou pe\u00E7a do pedido");
		textField_4.setText("");
		textField_4.setColumns(10);
		panel_1.add(textField_4);
		
		JLabel label_4 = new JLabel("Data do Pedido:");
		label_4.setBounds(36, 133, 77, 14);
		panel_1.add(label_4);
		
		try {
			mfdata = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mfdata.setValidCharacters("1234567890");
		
		jtfDataPedido = new JFormattedTextField(mfdata);
		jtfDataPedido.setBounds(118, 130, 469, 20);
		jtfDataPedido.setToolTipText("data do pedido no formato DD/MM/AAAA");
		jtfDataPedido.setText("");
		jtfDataPedido.setColumns(10);
		panel_1.add(jtfDataPedido);
		
		JLabel label_5 = new JLabel("Data de Entrega:");
		label_5.setBounds(30, 158, 83, 14);
		panel_1.add(label_5);
		
		jtfDataEntrega = new JFormattedTextField(mfdata);
		jtfDataEntrega.setBounds(118, 155, 287, 20);
		jtfDataEntrega.setToolTipText("Data de entrega no formato DD/MM/AAAA");
		jtfDataEntrega.setText("");
		jtfDataEntrega.setColumns(10);
		panel_1.add(jtfDataEntrega);
		
		JLabel label_6 = new JLabel("Endere\u00E7o:");
		label_6.setBounds(64, 183, 49, 14);
		panel_1.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(118, 180, 287, 20);
		textField_5.setToolTipText("informe o endere\u00E7o do cliente para entrega");
		textField_5.setText("");
		textField_5.setColumns(10);
		panel_1.add(textField_5);
		
		JLabel label_7 = new JLabel("Numero:");
		label_7.setBounds(420, 183, 41, 14);
		panel_1.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(471, 180, 86, 20);
		textField_6.setToolTipText("informe o numero ou caixa");
		textField_6.setText("");
		textField_6.setColumns(10);
		panel_1.add(textField_6);
		
		JLabel label_8 = new JLabel("Cidade:");
		label_8.setBounds(76, 208, 37, 14);
		panel_1.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(118, 205, 287, 20);
		textField_7.setToolTipText("informe a cidade do cliente");
		textField_7.setText("");
		textField_7.setColumns(10);
		panel_1.add(textField_7);
		
		JLabel label_9 = new JLabel("Bairro:");
		label_9.setBounds(420, 208, 32, 14);
		panel_1.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(471, 205, 116, 20);
		textField_8.setToolTipText("informe o bairro");
		textField_8.setText("");
		textField_8.setColumns(10);
		panel_1.add(textField_8);
		
		JLabel label_10 = new JLabel("Estado:");
		label_10.setBounds(76, 233, 37, 14);
		panel_1.add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(118, 230, 55, 20);
		textField_9.setToolTipText("Informe o estado");
		textField_9.setText("");
		textField_9.setColumns(10);
		panel_1.add(textField_9);
		
		JLabel label_11 = new JLabel("Contato:");
		label_11.setBounds(183, 236, 43, 14);
		panel_1.add(label_11);
		
		textField_10 = new JTextField();
		textField_10.setBounds(236, 230, 183, 20);
		textField_10.setToolTipText("informe o contato(email, telefone ou outro)");
		textField_10.setText("");
		textField_10.setColumns(10);
		panel_1.add(textField_10);
		
		JLabel label_12 = new JLabel("Hora da Entrega:");
		label_12.setBounds(30, 258, 83, 14);
		panel_1.add(label_12);
		
		textField_11 = new JTextField();
		textField_11.setBounds(118, 255, 134, 20);
		textField_11.setToolTipText("Informe o horario da entrega no formato( 24h)");
		textField_11.setText("");
		textField_11.setColumns(10);
		panel_1.add(textField_11);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.setBounds(297, 335, 91, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(255, 33, 46, 14);
		panel_1.add(lblStatus);
		
		txtAtivo = new JTextField();
		txtAtivo.setText("ATIVO");
		txtAtivo.setBounds(319, 30, 86, 20);
		panel_1.add(txtAtivo);
		txtAtivo.setColumns(10);

	}
}
