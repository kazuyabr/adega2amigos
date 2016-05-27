package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegFornecedores;

public class FornecedoresDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;	

	public FornecedoresDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idFornec) from fornecedores";

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

	public void Incluir(RegFornecedores fornecedor) {
		String sql = "insert into fornecedores values( ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?)";
		
		try {
			ps = conexao.getCon().prepareStatement(sql);
			ps.setInt(1, fornecedor.getCodFornec());
			ps.setString(2, fornecedor.getNomeFornecedor());
			ps.setString(3, fornecedor.getEnderecoFornecedor());
			ps.setInt(4, fornecedor.getNumeroFornecedor());
			ps.setString(5, fornecedor.getCidadeFornecedor());
			ps.setString(6, fornecedor.getBairroFornecedor());
			ps.setString(7, fornecedor.getEstadoFornecedor());
			ps.setInt(8, fornecedor.getTelefoneFornecedor());
			ps.setString(9, fornecedor.getContatoResponsavel());
			ps.setString(10, fornecedor.getEmailFornecedor());

			ps.execute();

		} catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	public void alterar(RegFornecedores fornecedores) {
		 String sql = "update fornecedores set nome = ?, endereco = ?, numero = ?, cidade = ?, bairro = ?, estado = ?, telefone = ?, contatoResponsavel = ?, email = ?" +  "where idFornec = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(10, fornecedores.getCodFornec());
		 ps.setString(1, fornecedores.getNomeFornecedor());
		 ps.setString(2, fornecedores.getEnderecoFornecedor());
		 ps.setInt(3, fornecedores.getNumeroFornecedor());
		 ps.setString(4, fornecedores.getCidadeFornecedor());
		 ps.setString(5, fornecedores.getBairroFornecedor());
		 ps.setString(6, fornecedores.getEstadoFornecedor());
		 ps.setInt(7, fornecedores.getTelefoneFornecedor());
		 ps.setString(8, fornecedores.getContatoResponsavel());
		 ps.setString(9, fornecedores.getEmailFornecedor());

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
		 String sql = "delete from fornecedores where idFornec = ?";

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
		 
		public RegFornecedores consultar(int nome){
		 RegFornecedores fornecedor = new RegFornecedores();

		 
		 try {

				String sql = "select * from fornecedores where idFornec = ?";
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 fornecedor.setCodFornec(rs.getInt("idFornec"));
		 fornecedor.setNomeFornecedor(rs.getString("nome"));
		 fornecedor.setEnderecoFornecedor(rs.getString("endereco"));		 
		 fornecedor.setNumeroFornecedor(rs.getInt("numero"));
		 fornecedor.setCidadeFornecedor(rs.getString("cidade"));
		 fornecedor.setBairroFornecedor(rs.getString("bairro"));
		 fornecedor.setEstadoFornecedor(rs.getString("estado"));
		 fornecedor.setTelefoneFornecedor(rs.getInt("telefone"));
		 fornecedor.setContatoResponsavel(rs.getString("contatoResponsavel"));
		 fornecedor.setEmailFornecedor(rs.getString("email"));


		 }
		 else{
		 fornecedor = null;
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return fornecedor;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegFornecedores> consultar(String nome){
		 RegFornecedores fornecedores = null;
		 List<RegFornecedores> fornecedorList = new ArrayList<RegFornecedores>();

		 String sql = "select * from fornecedores where nome like ? order by idFornec";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 fornecedores = new RegFornecedores();

		 fornecedores.setCodFornec(rs.getInt("idFornec"));
		 fornecedores.setNomeFornecedor(rs.getString("nome"));
		 fornecedores.setEnderecoFornecedor(rs.getString("endereco"));		 
		 fornecedores.setNumeroFornecedor(rs.getInt("numero"));
		 fornecedores.setCidadeFornecedor(rs.getString("cidade"));
		 fornecedores.setBairroFornecedor(rs.getString("bairro"));
		 fornecedores.setEstadoFornecedor(rs.getString("estado"));
		 fornecedores.setTelefoneFornecedor(rs.getInt("telefone"));
		 fornecedores.setContatoResponsavel(rs.getString("contatoResponsavel"));
		 fornecedores.setEmailFornecedor(rs.getString("email"));
		 
		 fornecedorList.add(fornecedores);

		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return fornecedorList;

		 }

		
}
