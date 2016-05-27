package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegVendas;

public class VenderDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;
	private RegVendas vendas;
	String sql;

	public VenderDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idVenda) from vendas";

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
	
	public String atendente(){
		 String nome = "";
		 vendas = new RegVendas();
		 String sql = "select nome from funcionarios where usuario = "+vendas.getAtendente();
		 System.out.println("Informação do atendente no VenderDAO: "+vendas.getAtendente());

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 rs = ps.executeQuery();

		 if(rs.next()){
		 nome = rs.getString(1);
		 
		 }
		 else{
		 nome = "";
		 }
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return nome;
		 }

	public void Vender(RegVendas vender) {
			sql = "insert into vendas values( ?, ?, ?, ?, ?, ?)";
			
			try{
				
			ps = conexao.getCon().prepareStatement(sql);			
			ps.setInt(1, vender.getIdVendas());
			ps.setString(2, vender.getAtendente().toUpperCase());
			ps.setString(3, vender.getCliente().toUpperCase());
			ps.setString(4, vender.getProduto());
			ps.setString(5, vender.getPreco());
			ps.setString(6, vender.getDescricao());
			

			ps.execute();
			JOptionPane.showMessageDialog(null, "Venda efetuada!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			


			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}
		

	}
	
	public void alterar(RegVendas vender) {
		 String sql = "update vendas set atendente = ?, cliente = ?, nomeProduto = ?, precoVenda = ?, descricaoVenda = ?" + "where idVendas = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(6, vender.getIdVendas()); //especificando valor de consulta where = ?
		 ps.setString(1, vender.getAtendente().toUpperCase());
		 ps.setString(2, vender.getCliente().toUpperCase());
		 ps.setString(3, vender.getProduto());
		 ps.setString(4, vender.getPreco());
		 ps.setString(5, vender.getDescricao());
		 		 
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
		 String sql = "delete from vendas where idVenda = ?";

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
		 
		public RegVendas consultar(int nome){
		 RegVendas vendas = new RegVendas();

		 
		 try {

				 sql = "select * from vendas where idVenda = ?";//criar view.
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 vendas.setIdVendas(rs.getInt("idVenda"));
		 vendas.setAtendente(rs.getString("atendente"));
		 vendas.setCliente(rs.getString("cliente"));		 
		 vendas.setProduto(rs.getString("nomeProduto"));
		 vendas.setPreco(rs.getString("precoVenda"));
		 vendas.setDescricao(rs.getString("descricaoVenda"));
		 
		 }
		 else{
		 vendas = null;
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return vendas;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegVendas> consultar(String nome){
		 RegVendas vendas = null;
		 List<RegVendas> vendasList = new ArrayList<RegVendas>();

		 String sql = "select * from vendas where atendente like ? order by idVenda";//criar view

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 vendas = new RegVendas();

		 vendas.setIdVendas(rs.getInt("idVenda"));
		 vendas.setAtendente(rs.getString("atendente"));
		 vendas.setCliente(rs.getString("cliente"));		 
		 vendas.setProduto(rs.getString("nomeProduto"));
		 vendas.setPreco(rs.getString("precoVenda"));
		 vendas.setDescricao(rs.getString("descricaoVenda"));

		 vendasList.add(vendas);
		 
		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return vendasList;

		 }


}


