package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.RegFuncionario;
import classes.sql.Conexao;
import lib.GerarHash;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnEntrar;
	private Conexao con;
	private JPasswordField jpfSenha;
	private JLabel lblVerso;
	private JLabel lblMhProdues;

		public Login() {
		setTitle("Adega 2 Amigos: LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		con = new Conexao();
		con.conectar();
		
		JPanel jpSul = new JPanel();
		contentPane.add(jpSul, BorderLayout.SOUTH);
		GridBagLayout gbl_jpSul = new GridBagLayout();
		gbl_jpSul.columnWidths = new int[]{139, 0, 30, 0};
		gbl_jpSul.rowHeights = new int[]{14, 0};
		gbl_jpSul.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpSul.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jpSul.setLayout(gbl_jpSul);
		
		lblVerso = new JLabel("Vers\u00E3o 0.0.0.4");
		GridBagConstraints gbc_lblVerso = new GridBagConstraints();
		gbc_lblVerso.insets = new Insets(0, 0, 0, 5);
		gbc_lblVerso.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVerso.gridx = 0;
		gbc_lblVerso.gridy = 0;
		jpSul.add(lblVerso, gbc_lblVerso);
		
		lblMhProdues = new JLabel("M.H. Produ\u00E7\u00F5es 2016");
		GridBagConstraints gbc_lblMhProdues = new GridBagConstraints();
		gbc_lblMhProdues.anchor = GridBagConstraints.EAST;
		gbc_lblMhProdues.gridx = 2;
		gbc_lblMhProdues.gridy = 0;
		jpSul.add(lblMhProdues, gbc_lblMhProdues);
		
		JPanel jpCentro = new JPanel();
		contentPane.add(jpCentro, BorderLayout.CENTER);
		GridBagLayout gbl_jpCentro = new GridBagLayout();
		gbl_jpCentro.columnWidths = new int[]{30, 40, 177, 0, 0};
		gbl_jpCentro.rowHeights = new int[]{20, 20, 0, 0, 20, 0};
		gbl_jpCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpCentro.setLayout(gbl_jpCentro);
	
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.RED);
		lblUsuario.setFont(new Font("Stencil", Font.BOLD, 14));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		jpCentro.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField(10);
		txtUsuario.setFont(new Font("Sylfaen", Font.ITALIC, 16));
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.anchor = GridBagConstraints.NORTH;
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		jpCentro.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Stencil", Font.BOLD, 14));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 2;
		jpCentro.add(lblSenha, gbc_lblSenha);
		
		jpfSenha = new JPasswordField(10);
		jpfSenha.setFont(new Font("Sylfaen", Font.ITALIC, 16));
		jpfSenha.setEchoChar('*');
		GridBagConstraints gbc_jpfSenha = new GridBagConstraints();
		gbc_jpfSenha.insets = new Insets(0, 0, 5, 5);
		gbc_jpfSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpfSenha.gridx = 2;
		gbc_jpfSenha.gridy = 2;
		jpCentro.add(jpfSenha, gbc_jpfSenha);
		
		btnEntrar = new JButton("ENTRAR");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.anchor = GridBagConstraints.EAST;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 2;
		gbc_btnEntrar.gridy = 3;
		jpCentro.add(btnEntrar, gbc_btnEntrar);
		
		jpCentro.getRootPane().setDefaultButton(btnEntrar);
		btnEntrar.requestFocus();
		getBtnEntrar();
		
		
		
	}

	public JButton getBtnEntrar() {
		
		
		btnEntrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "select usuario, senha from funcionarios where usuario = '"+txtUsuario.getText()+"'";
				String senhaHash = GerarHash.stringHexa(GerarHash.gerarHash(String.valueOf(jpfSenha.getPassword()), "MD5"));

				if(txtUsuario.getText().equals("") || senhaHash.equals("")){
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha vazios\n Favor preencher!", "INFO", JOptionPane.ERROR_MESSAGE);					
				}else{
				
				try {
					PreparedStatement ps = con.getCon().prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
															
					if(rs.next()){
						String usuario = rs.getString("usuario");
						String senha = rs.getString("senha");
						
						RegFuncionario funcionario = new RegFuncionario();
						funcionario.setSenhaCrypt(String.valueOf(jpfSenha.getPassword()));

						if(txtUsuario.getText().equals(usuario) && senhaHash.equals(senha)){

							Menu mn = new Menu();
							mn.setVisible(true);
							dispose();
							
						}else if(txtUsuario.getText().equals(usuario) && senhaHash != senha){
							JOptionPane.showMessageDialog(null, "senha incorreta!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
												
					}else{
						JOptionPane.showMessageDialog(null, "Usuario não registrado", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage(), "INFO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
				}
			}
		
			
			
		});
		
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}
	
	

}
