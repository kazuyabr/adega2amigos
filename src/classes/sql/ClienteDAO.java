package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegCliente;

public class ClienteDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;
	String sql;

	public ClienteDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idClientes) from clientes";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 rs = ps.executeQuery();

		 if(rs.next()){
		 cod = rs.getInt(1);
		 
		 }
		 else{
		 cod = 0;
		 }
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return cod+1;
		 }

	public void Incluir(RegCliente cliente) {
			sql = "insert into clientes values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try{
				
			ps = conexao.getCon().prepareStatement(sql);			
			ps.setInt(1, cliente.getCodcli());
			ps.setString(2, cliente.getNomeCliente().toUpperCase());
			ps.setString(3, cliente.getSexoCliente());
			ps.setDate(4, new java.sql.Date(cliente.getDataNascCliente().getTime()));
			ps.setString(5, cliente.getRgCliente());
			ps.setString(6, cliente.getCpfCnpjCliente());
			ps.setString(7, cliente.getEnderecoCliente());
			ps.setInt(8, cliente.getNumeroCliente());
			ps.setString(9, cliente.getBairroCliente());
			ps.setString(10, cliente.getCidadeCliente());
			ps.setString(11, cliente.getEstadoCliente());
			ps.setString(12, cliente.getCepCliente());
			ps.setString(13, cliente.getTelefoneCliente());
			ps.setString(14, cliente.getCelularCliente());
			ps.setString(15, cliente.getEmailCliente());
			ps.setInt(16, 0);

			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro efetuado!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			


			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}
		

	}
	
	public void alterar(RegCliente cliente) {
		 String sql = "update clientes set nome = ?, sexo = ?, datanasccliente = ?, rg = ?, cpfcnpj = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, celular = ?, email = ?" + "where idClientes = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(15, cliente.getCodcli()); 
		 ps.setString(1, cliente.getNomeCliente().toUpperCase());
		 ps.setString(2, cliente.getSexoCliente());
		 ps.setDate(3, new java.sql.Date(cliente.getDataNascCliente().getTime()));
		 ps.setString(4, cliente.getRgCliente());
		 ps.setString(5, cliente.getCpfCnpjCliente());
		 ps.setString(6, cliente.getEnderecoCliente());
		 ps.setInt(7, cliente.getNumeroCliente());
		 ps.setString(8, cliente.getBairroCliente());
		 ps.setString(9, cliente.getCidadeCliente());
		 ps.setString(10, cliente.getEstadoCliente());
		 ps.setString(11, cliente.getCepCliente());
		 ps.setString(12, cliente.getTelefoneCliente());
		 ps.setString(13, cliente.getCelularCliente());
		 ps.setString(14, cliente.getEmailCliente());
		 
		 ps.execute();
		 conexao.getCon().close();

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 }

		 /**
		 * Exclui uma cidade com base no seu codigo
		 */
		 public void excluir(int codigo) {
		 String sql = "delete from clientes where idClientes = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, codigo);

		 ps.execute();
		 conexao.getCon().close();

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 }

		 /**
		 * Consulta uma cidade com base no seu codigo e retorna um objeto
		 */
		 
		public RegCliente consultar(int nome){
		 RegCliente cliente = new RegCliente();

		 
		 try {

				 sql = "select * from clientes where idClientes = ?";
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 cliente.setCodcli(rs.getInt("idClientes"));
		 cliente.setNomeCliente(rs.getString("nome"));
		 cliente.setSexoCliente(rs.getString("sexo"));		 
		 cliente.setDataNascCliente(rs.getDate("datanasccliente"));
		 cliente.setRgCliente(rs.getString("rg"));
		 cliente.setCpfCnpjCliente(rs.getString("cpfcnpj"));
		 cliente.setEnderecoCliente(rs.getString("endereco"));
		 cliente.setNumeroCliente(rs.getInt("numero"));
		 cliente.setBairroCliente(rs.getString("bairro"));
		 cliente.setCidadeCliente(rs.getString("cidade"));
		 cliente.setEstadoCliente(rs.getString("estado"));
		 cliente.setCepCliente(rs.getString("cep"));
		 cliente.setTelefoneCliente(rs.getString("telefone"));
		 cliente.setCelularCliente(rs.getString("celular"));
		 cliente.setEmailCliente(rs.getString("email"));


		 }
		 else{
		 cliente = null;
		 
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return cliente;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegCliente> consultar(String nome){
		 RegCliente cliente = null;
		 List<RegCliente> clienteList = new ArrayList<RegCliente>();

		 String sql = "select * from clientes where nome like ? order by idClientes";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 cliente = new RegCliente();

		 cliente.setCodcli(rs.getInt("idClientes"));
		 cliente.setNomeCliente(rs.getString("nome"));
		 cliente.setSexoCliente(rs.getString("sexo"));		 
		 cliente.setDataNascCliente(rs.getDate("datanasccliente"));
		 cliente.setRgCliente(rs.getString("rg"));
		 cliente.setCpfCnpjCliente(rs.getString("cpfcnpj"));
		 cliente.setEnderecoCliente(rs.getString("endereco"));
		 cliente.setNumeroCliente(rs.getInt("numero"));
		 cliente.setBairroCliente(rs.getString("bairro"));
		 cliente.setCidadeCliente(rs.getString("cidade"));
		 cliente.setEstadoCliente(rs.getString("estado"));
		 cliente.setCepCliente(rs.getString("cep"));
		 cliente.setTelefoneCliente(rs.getString("telefone"));
		 cliente.setCelularCliente(rs.getString("celular"));
		 cliente.setEmailCliente(rs.getString("email"));

		 clienteList.add(cliente);
		 
		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return clienteList;

		 }


}


