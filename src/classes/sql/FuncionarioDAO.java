package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegFuncionario;

public class FuncionarioDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;	

	public FuncionarioDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idFunc) from funcionarios";

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

	public void Incluir(RegFuncionario funcionario) {
		String sql = "insert into funcionarios values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			ps = conexao.getCon().prepareStatement(sql);
			ps.setInt(1, funcionario.getCodigoFuncionario());
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3, funcionario.getSenhaCrypt());
			ps.setString(4, funcionario.getNomeFuncionario());
			ps.setString(5, funcionario.getSexoFuncionario());
			ps.setDate(6, new java.sql.Date(funcionario.getDataNascFuncionario().getTime()));
			ps.setInt(7, funcionario.getRgFuncionario());
			ps.setLong(8, funcionario.getCpfFuncionario());
			ps.setString(9, funcionario.getEnderecoFuncionario());
			ps.setInt(10, funcionario.getNumeroEndereco());
			ps.setString(11, funcionario.getBairroFuncionario());
			ps.setString(12, funcionario.getCidadeFuncionario());
			ps.setString(13, funcionario.getEstadoFuncionario());
			ps.setInt(14, funcionario.getCepFuncionario());
			ps.setString(15, funcionario.getTelefoneFuncionario());
			ps.setString(16, funcionario.getCelularFuncionario());
			ps.setString(17, funcionario.getEmailFuncionario());
			ps.setString(18, funcionario.getCargoFuncionario());

			ps.execute();

		} catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void alterar(RegFuncionario funcionario) {
		 String sql = "update funcionarios set usuario = ?, senha = ?, nome = ?, sexo = ?, dataDeNasc = ?, rg = ?, cpf = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, celular = ?, email = ?, cargo = ?" +  "where idFunc = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(18, funcionario.getCodigoFuncionario());
		 ps.setString(1, funcionario.getUsuario());
		 ps.setString(2, funcionario.getSenhaCrypt());
		 ps.setString(3, funcionario.getNomeFuncionario());
		 ps.setString(4, funcionario.getSexoFuncionario());
		 ps.setDate(5, new java.sql.Date(funcionario.getDataNascFuncionario().getTime()));
		 ps.setInt(6, funcionario.getRgFuncionario());
		 ps.setLong(7, funcionario.getCpfFuncionario());
		 ps.setString(8, funcionario.getEnderecoFuncionario());
		 ps.setInt(9, funcionario.getNumeroEndereco());
		 ps.setString(10, funcionario.getBairroFuncionario());
		 ps.setString(11, funcionario.getCidadeFuncionario());
		 ps.setString(12, funcionario.getEstadoFuncionario());
		 ps.setInt(13, funcionario.getCepFuncionario());
		 ps.setString(14, funcionario.getTelefoneFuncionario());
		 ps.setString(15, funcionario.getCelularFuncionario());
		 ps.setString(16, funcionario.getEmailFuncionario());
		 ps.setString(17, funcionario.getCargoFuncionario());

		 ps.execute();
		 //conexao.getCon().close();

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
		 String sql = "delete from funcionarios where idFunc = ?";

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
		 
		public RegFuncionario consultar(int nome){
		 RegFuncionario funcionario = new RegFuncionario();

		 
		 try {

				String sql = "select * from funcionarios where idFunc = ?";
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 funcionario.setCodigoFuncionario(rs.getInt("idFunc"));
		 funcionario.setUsuario(rs.getString("usuario"));
		 funcionario.setSenhaOriginal(rs.getString("senha"));
		 funcionario.setNomeFuncionario(rs.getString("nome"));
		 funcionario.setSexoFuncionario(rs.getString("sexo"));
		 funcionario.setDataNascFuncionario(rs.getDate("dataDeNasc"));
		 funcionario.setRgFuncionario(rs.getInt("rg"));
		 funcionario.setCpfFuncionario(rs.getLong("cpf"));
		 funcionario.setEnderecoFuncionario(rs.getString("endereco"));
		 funcionario.setNumeroEndereco(rs.getInt("numero"));
		 funcionario.setBairroFuncionario(rs.getString("bairro"));
		 funcionario.setCidadeFuncionario(rs.getString("cidade"));
		 funcionario.setEstadoFuncionario(rs.getString("estado"));
		 funcionario.setCepFuncionario(rs.getInt("cep"));
		 funcionario.setTelefoneFuncionario(rs.getString("telefone"));
		 funcionario.setCelularFuncionario(rs.getString("celular"));
		 funcionario.setEmailFuncionario(rs.getString("email"));
		 funcionario.setCargoFuncionario(rs.getString("cargo"));


		 }
		 else{
		 funcionario = null;
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return funcionario;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegFuncionario> consultar(String nome){
		 RegFuncionario funcionario = null;
		 List<RegFuncionario> funcionarioList = new ArrayList<RegFuncionario>();

		 String sql = "select * from funcionarios where nome like ? order by idFunc";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 funcionario = new RegFuncionario();

		 funcionario.setCodigoFuncionario(rs.getInt("idFunc"));
		 funcionario.setUsuario(rs.getString("usuario"));
		 funcionario.setSenhaOriginal("********");//simbulos para não exibir o hash da senha na consulta.
		 funcionario.setNomeFuncionario(rs.getString("nome"));
		 funcionario.setSexoFuncionario(rs.getString("sexo"));
		 funcionario.setDataNascFuncionario(rs.getDate("dataDeNasc"));
		 funcionario.setRgFuncionario(rs.getInt("rg"));
		 funcionario.setCpfFuncionario(rs.getLong("cpf"));
		 funcionario.setEnderecoFuncionario(rs.getString("endereco"));
		 funcionario.setNumeroEndereco(rs.getInt("numero"));
		 funcionario.setBairroFuncionario(rs.getString("bairro"));
		 funcionario.setCidadeFuncionario(rs.getString("cidade"));
		 funcionario.setEstadoFuncionario(rs.getString("estado"));
		 funcionario.setCepFuncionario(rs.getInt("cep"));
		 funcionario.setTelefoneFuncionario(rs.getString("telefone"));
		 funcionario.setCelularFuncionario(rs.getString("celular"));
		 funcionario.setEmailFuncionario(rs.getString("email"));
		 funcionario.setCargoFuncionario(rs.getString("cargo"));
		 
		 funcionarioList.add(funcionario);

		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return funcionarioList;

		 }

	
}
