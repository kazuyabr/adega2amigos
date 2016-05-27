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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import classes.RegVendas;
import classes.sql.Conexao;
import classes.sql.VenderDAO;

@SuppressWarnings("serial")
public class Vendas extends JInternalFrame {
	private JTextField txtNome;
	private Conexao conect;
	private JButton btnConsultar;
	private JButton btnSair;
	private JTable table;
	private DefaultTableModel modelo;
	private String[] campos = new String[] {"idVenda", "atendente", "cliente", "nomeProduto", "precoVenda", "descricaoVenda"};
	private String[][] dados = {{"", "", "", "", "", ""}};
	
		
	public Vendas() {
		setIconifiable(true);
		setFrameIcon(null);
		
		setTitle("Consulta Fluxo: Vendass");
		setResizable(true);
				
		setMaximizable(true);		
		setBounds(100, 100, 702, 461);		
		setSize(724, 485);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
				
		JPanel jpNorte = new JPanel();
		getContentPane().add(jpNorte, BorderLayout.NORTH);
		jpNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNome = new JLabel("Nome do Atendente:");
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
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		jpSul.add(btnImprimir);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		jpCentro.add(scrollPane, gbc_scrollPane);
		
		modelo = new DefaultTableModel(dados, campos);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null, null, null, ""},
			},
			new String[] {
				"NUMERO", "DATA", "HORA", "ATENDENTE", "CLIENTE", "CODIGO DE BARRA", "PRODUTO", "QUANTIDADE", "VALOR"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		getBtnSair();

	}

	
	
	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public JButton getBtnConsultar() {
		 btnConsultar.addActionListener(new ActionListener() {

		 @Override
		 public void actionPerformed(ActionEvent arg0) {
		 String consulta = "%";
		 conect = new Conexao();
		 conect.conectar();
		 VenderDAO venderDAO = new VenderDAO(conect);


		 modelo = new DefaultTableModel();
		 modelo.setColumnIdentifiers(campos);

		 if(txtNome.getText().toUpperCase().equals("")){
		 consulta = "%"; 
		 }else{
			 consulta = txtNome.getText().toUpperCase();
		 }

		 for(RegVendas vendas : venderDAO.consultar(consulta)){
		 modelo.addRow(new Object[] {vendas.getIdVendas(), vendas.getAtendente(), vendas.getCliente(), vendas.getProduto(), vendas.getPreco(), vendas.getDescricao()} );
		 }

		 table.setModel(modelo);
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
