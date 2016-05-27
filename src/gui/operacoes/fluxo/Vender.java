package gui.operacoes.fluxo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.RegVendas;
import classes.sql.Conexao;
import classes.sql.VenderDAO;

@SuppressWarnings("serial")
public class Vender extends JInternalFrame {
	private JTextField txtCodVenda;
	private JTextField txtAtendente;
	private JTextField txtCliente;
	private JTextField txtProduto;
	private JButton btnVender;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JEditorPane txtDescricao;
	private JLabel lblPreo;
	private JTextField txtPreco;
	private Conexao conect;
	private VenderDAO venderDAO;
	private RegVendas vendas;

	
	public Vender() {
		setClosable(true);
		setFrameIcon(null);
		setResizable(true);
		setMaximizable(true);
		setTitle("Formulario de Vendas");
		setBounds(100, 100, 503, 428);
		
		conect = new Conexao();
		conect.conectar();
		
		
		venderDAO = new VenderDAO(conect);
		
		JPanel jpSul = new JPanel();
		getContentPane().add(jpSul, BorderLayout.SOUTH);
		jpSul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnVender = new JButton("VENDER");
		jpSul.add(btnVender);
		
		btnAlterar = new JButton("ALTERAR");
		jpSul.add(btnAlterar);
		
		btnConsultar = new JButton("CONSULTAR");
		jpSul.add(btnConsultar);
		
		btnExcluir = new JButton("EXCLUIR");
		jpSul.add(btnExcluir);
		
		btnLimpar = new JButton("LIMPAR");
		jpSul.add(btnLimpar);
		
		JPanel jpCentro = new JPanel();
		getContentPane().add(jpCentro, BorderLayout.CENTER);
		GridBagLayout gbl_jpCentro = new GridBagLayout();
		gbl_jpCentro.columnWidths = new int[]{20, 67, 271, 20, 0};
		gbl_jpCentro.rowHeights = new int[]{20, 20, 20, 20, 20, 0, 0, 0};
		gbl_jpCentro.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_jpCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpCentro.setLayout(gbl_jpCentro);
		
		JLabel lblIdvendas = new JLabel("Codigo:");
		GridBagConstraints gbc_lblIdvendas = new GridBagConstraints();
		gbc_lblIdvendas.anchor = GridBagConstraints.EAST;
		gbc_lblIdvendas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdvendas.gridx = 1;
		gbc_lblIdvendas.gridy = 1;
		jpCentro.add(lblIdvendas, gbc_lblIdvendas);
		
		txtCodVenda = new JTextField(10);
		txtCodVenda.setToolTipText("Codigo do banco de dados");
		GridBagConstraints gbc_txtCodVenda = new GridBagConstraints();
		gbc_txtCodVenda.anchor = GridBagConstraints.WEST;
		gbc_txtCodVenda.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodVenda.gridx = 2;
		gbc_txtCodVenda.gridy = 1;
		jpCentro.add(txtCodVenda, gbc_txtCodVenda);
		txtCodVenda.setColumns(10);
		
		JLabel lblAtendente = new JLabel("Atendente:");
		GridBagConstraints gbc_lblAtendente = new GridBagConstraints();
		gbc_lblAtendente.anchor = GridBagConstraints.EAST;
		gbc_lblAtendente.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtendente.gridx = 1;
		gbc_lblAtendente.gridy = 2;
		jpCentro.add(lblAtendente, gbc_lblAtendente);
		
		txtAtendente = new JTextField();
		txtAtendente.setToolTipText("nome do atendente");
		GridBagConstraints gbc_txtAtendente = new GridBagConstraints();
		gbc_txtAtendente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAtendente.insets = new Insets(0, 0, 5, 5);
		gbc_txtAtendente.gridx = 2;
		gbc_txtAtendente.gridy = 2;
		jpCentro.add(txtAtendente, gbc_txtAtendente);
		txtAtendente.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 3;
		jpCentro.add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setToolTipText("nome do cliente");
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 3;
		jpCentro.add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto:");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.EAST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 1;
		gbc_lblProduto.gridy = 4;
		jpCentro.add(lblProduto, gbc_lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setToolTipText("nome do produto");
		GridBagConstraints gbc_txtProduto = new GridBagConstraints();
		gbc_txtProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtProduto.gridx = 2;
		gbc_txtProduto.gridy = 4;
		jpCentro.add(txtProduto, gbc_txtProduto);
		txtProduto.setColumns(10);
		
		lblPreo = new JLabel("Pre\u00E7o:");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.anchor = GridBagConstraints.EAST;
		gbc_lblPreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreo.gridx = 1;
		gbc_lblPreo.gridy = 5;
		jpCentro.add(lblPreo, gbc_lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setToolTipText("Valor do produto no formato R$##,##");
		GridBagConstraints gbc_txtPreco = new GridBagConstraints();
		gbc_txtPreco.anchor = GridBagConstraints.WEST;
		gbc_txtPreco.insets = new Insets(0, 0, 5, 5);
		gbc_txtPreco.gridx = 2;
		gbc_txtPreco.gridy = 5;
		jpCentro.add(txtPreco, gbc_txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 6;
		jpCentro.add(lblDescrio, gbc_lblDescrio);
		
		txtDescricao = new JEditorPane();
		txtDescricao.setToolTipText("Descri\u00E7\u00E3o da venda");
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.insets = new Insets(0, 0, 0, 5);
		gbc_txtDescricao.fill = GridBagConstraints.BOTH;
		gbc_txtDescricao.gridx = 2;
		gbc_txtDescricao.gridy = 6;
		jpCentro.add(txtDescricao, gbc_txtDescricao);
		
		getBtnVender();
		getBtnAlterar();
		getBtnConsultar();
		getBtnExcluir();
		getBtnLimpar();
		
		limparCampos();

	}


	public JButton getBtnVender() {
		
		btnVender.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				conect.conectar();
				venderDAO = new VenderDAO(conect);
				vendas = new RegVendas();
				
				// passando os valores dos textfields para uma classe separada
				vendas.setIdVendas(venderDAO.proximoCodigo());
				vendas.setAtendente(txtAtendente.getText());
				vendas.setCliente(txtCliente.getText());
				vendas.setProduto(txtProduto.getText());
				vendas.setPreco(txtPreco.getText());
				vendas.setDescricao(txtDescricao.getText());

								 
				venderDAO.Vender(vendas);
				conect.desconecta();
				limparCampos();
				
			}
			
		});
		
		return btnVender;
	}


	public void setBtnVender(JButton btnVender) {
		this.btnVender = btnVender;
	}


	 public JButton getBtnAlterar() {
		 btnAlterar.addActionListener(new ActionListener() {

		 @Override
		 public void actionPerformed(ActionEvent arg0) {

			 vendas = new RegVendas();
				
				int confirmAlter = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar o registro?", "INFO", JOptionPane.YES_NO_OPTION);
				
				if(confirmAlter == JOptionPane.YES_OPTION){
				// passando os valores dos textfields para uma classe separada
				vendas.setIdVendas(Integer.parseInt(txtCodVenda.getText()));
				vendas.setAtendente(txtAtendente.getText());
				vendas.setCliente(txtCliente.getText());
				vendas.setProduto(txtProduto.getText());
				vendas.setPreco(txtPreco.getText());
				vendas.setDescricao(txtDescricao.getText());

		 conect.conectar();
		 venderDAO = new VenderDAO(conect);
		 venderDAO.alterar(vendas);
		 conect.desconecta();
		 JOptionPane.showMessageDialog(null, "Alteracao efetuada!");
		 limparCampos();
				}
				else{
					JOptionPane.showMessageDialog(null, "Alteração Cancelada pelo usuario!", "INFO", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				}
		 }
		 });
		 return btnAlterar;
		 }

	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public JButton getBtnExcluir() {
		
		btnExcluir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este registro?", "INFO", JOptionPane.YES_NO_OPTION);
				
				if(confirm == JOptionPane.YES_OPTION){
				
				int codigo = Integer.parseInt(txtCodVenda.getText());
				
				conect.conectar();
				venderDAO = new VenderDAO(conect); 
				venderDAO.excluir(codigo);
				conect.desconecta();
				JOptionPane.showMessageDialog(null, "Exclusão efetuada!", "INFO", JOptionPane.INFORMATION_MESSAGE);
				limparCampos();
					
			}else{
				JOptionPane.showMessageDialog(null, "Exclusão cancelada pelo usuario!", "INFO", JOptionPane.INFORMATION_MESSAGE);
				limparCampos();
			}
			
				
			}
		});
		
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnConsultar() {

		btnConsultar.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent arg0) {

			 conect.conectar();
			 venderDAO = new VenderDAO(conect);
			 
			 vendas = venderDAO.consultar(Integer.parseInt(txtCodVenda.getText()));
			 
			 if(vendas != null){
				 				 
			 txtCodVenda.setText(String.valueOf(vendas.getIdVendas()));
			 txtAtendente.setText(vendas.getAtendente());			
			 txtCliente.setText(vendas.getCliente());
			 txtProduto.setText(vendas.getProduto());//a String é convertida para o formato float
			 txtPreco.setText(String.valueOf(vendas.getPreco()));//a String é convertida para o formato float
			 txtDescricao.setText(vendas.getDescricao());
			 
			 }
			 else{
			 JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			 }

			 conect.desconecta();

			 }
			 });
			 return btnConsultar;
			 }
	
	
	public void limparCampos(){
		conect = new Conexao();
		conect.conectar();
		
		venderDAO = new VenderDAO(conect);
		txtCodVenda.setText(String.valueOf(venderDAO.proximoCodigo()));
		txtAtendente.setText("");
		txtCliente.setText("");
		txtProduto.setText("");
		txtPreco.setText("");
		txtDescricao.setText("");
		conect.desconecta();
		
	}


	public JButton getBtnLimpar() {
		btnLimpar.addActionListener(new ActionListener(){

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
	
	
}
