package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegProdutos;

public class ProdutosDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;	

	public ProdutosDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idCod) from produtos";

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

	public void Incluir(RegProdutos produtos) {
		String sql = "insert into produtos values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conexao.getCon().prepareStatement(sql);
			ps.setInt(1, produtos.getIdCodProduto());
			ps.setInt(2, produtos.getIdCodBarUni());
			ps.setInt(3, produtos.getIdCodBarPack());
			ps.setString(4, produtos.getDescricaoProduto());
			ps.setInt(5, produtos.getQtdEstoque());
			ps.setFloat(6, produtos.getCusto());
			ps.setFloat(7, produtos.getMargemdelucro());
			ps.setFloat(8, produtos.getPreco());
			ps.setFloat(9, produtos.getPrecoComRetornavel());
			ps.setString(10, produtos.getRepresentante());
			ps.setString(11, produtos.getTelefones());
			ps.setString(12, produtos.getEmailRepresentante());
			ps.setInt(13, produtos.getInativo());
			ps.setInt(14, produtos.getRetornavel());
			
			ps.execute();

		} catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void alterar(RegProdutos produtos) {
		 String sql = "update produtos set codbaruni = ?, codbarpack = ?, descprod = ?, qtdEstoque = ?, custo = ?, margemdelucro = ?, preco = ?, precocomretornavel = ?, representante = ?, telefones = ?, emaildorepresentante = ?, inativo = ?, retornavel = ?" +  "where idCod = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(14, produtos.getIdCodProduto());
			ps.setInt(1, produtos.getIdCodBarUni());
			ps.setInt(2, produtos.getIdCodBarPack());
			ps.setString(3, produtos.getDescricaoProduto());	
			ps.setInt(4, produtos.getQtdEstoque());
			ps.setFloat(5, produtos.getCusto());
			ps.setFloat(6, produtos.getMargemdelucro());
			ps.setFloat(7, produtos.getPreco());
			ps.setFloat(8, produtos.getPrecoComRetornavel());
			ps.setString(9, produtos.getRepresentante());
			ps.setString(10, produtos.getTelefones());
			ps.setString(11, produtos.getEmailRepresentante());
			ps.setInt(12, produtos.getInativo());
			ps.setInt(13, produtos.getRetornavel());

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
		 String sql = "delete from produtos where idCod = ?";

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
		 
		public RegProdutos consultar(int nome){
		 RegProdutos produtos = new RegProdutos();

		 
		 try {

				String sql = "select * from produtos where idCod = ?";
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 	produtos.setIdCodProduto(rs.getInt("idCod"));
			produtos.setIdCodBarUni(rs.getInt("codbaruni"));
			produtos.setIdCodBarPack(rs.getInt("codbarpack"));
			produtos.setDescricaoProduto(rs.getString("descprod"));
			produtos.setQtdEstoque(rs.getInt("idBdProduto"));
			produtos.setCusto(rs.getFloat("custo"));
			produtos.setMargemdelucro(rs.getFloat("margemdelucro"));
			produtos.setPreco(rs.getFloat("preco"));
			produtos.setPrecoComRetornavel(rs.getFloat("precocomretornavel"));
			produtos.setRepresentante(rs.getString("representante"));
			produtos.setTelefones(rs.getString("telefones"));
			produtos.setEmailRepresentante(rs.getString("emaldorepresentante"));
			produtos.setInativo(rs.getInt("inativo"));
			produtos.setRetornavel(rs.getInt("retornavel"));
		 

		 }
		 else{
		 produtos = null;
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return produtos;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegProdutos> consultar(String nome){
		 RegProdutos produto = null;
		 List<RegProdutos> produtoList = new ArrayList<RegProdutos>();

		 String sql = "select * from Cidade where nome like ? order by nome";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 produto = new RegProdutos();

		 	produto.setIdCodProduto(rs.getInt("idCod"));
			produto.setIdCodBarUni(rs.getInt("codbaruni"));
			produto.setIdCodBarPack(rs.getInt("codbarpack"));
			produto.setDescricaoProduto(rs.getString("descprod"));
			produto.setQtdEstoque(rs.getInt("idBdProduto"));
			produto.setCusto(rs.getFloat("custo"));
			produto.setMargemdelucro(rs.getFloat("margemdelucro"));
			produto.setPreco(rs.getFloat("preco"));
			produto.setPrecoComRetornavel(rs.getFloat("precocomretornavel"));
			produto.setRepresentante(rs.getString("representante"));
			produto.setTelefones(rs.getString("telefones"));
			produto.setEmailRepresentante(rs.getString("emaldorepresentante"));
			produto.setInativo(rs.getInt("inativo"));
			produto.setRetornavel(rs.getInt("retornavel"));

		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return produtoList;

		 }

		 /**
		 *
		 * Recebe um codigo do estado e retorna todas as cidades daquele estado
		 *
		 * Neste metodo tambem eh chamado uma funcao criada no banco internamente
		 */
		 public List<RegProdutos> consultarPorEstado(int codigoEstado){
		 RegProdutos produto = null;
		 List<RegProdutos> produtoList = new ArrayList<RegProdutos>();

		 String sql = "select *, fIdade(dataFundacao) idade from Cidade where codigoEstado = ? order by nome";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, codigoEstado);
		 rs = ps.executeQuery();


		 while(rs.next()){
			 produto = new RegProdutos();

			 	produto.setIdCodProduto(rs.getInt("idCod"));
				produto.setIdCodBarUni(rs.getInt("codbaruni"));
				produto.setIdCodBarPack(rs.getInt("codbarpack"));
				produto.setDescricaoProduto(rs.getString("descprod"));
				produto.setQtdEstoque(rs.getInt("idBdProduto"));
				produto.setCusto(rs.getFloat("custo"));
				produto.setMargemdelucro(rs.getFloat("margemdelucro"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setPrecoComRetornavel(rs.getFloat("precocomretornavel"));
				produto.setRepresentante(rs.getString("representante"));
				produto.setTelefones(rs.getString("telefones"));
				produto.setEmailRepresentante(rs.getString("emaldorepresentante"));
				produto.setInativo(rs.getInt("inativo"));
				produto.setRetornavel(rs.getInt("retornavel"));

			 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return produtoList;

		 }

		 /**
		 *
		 * Este metodo recebe um mes e devolve uma Lista de objetos cidades
		 */
		 public List<RegProdutos> consultarPorMes(int mes){
		 RegProdutos produto = null;
		 List<RegProdutos> produtoList = new ArrayList<RegProdutos>();

		 String sql = "select *, fIdade(dataFundacao) idade from Cidade where month(dataFundacao) = ? " +  "order by dataFundacao";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, mes);
		 rs = ps.executeQuery();

		 while(rs.next()){
			 produto = new RegProdutos();

			 	produto.setIdCodProduto(rs.getInt("idCod"));
				produto.setIdCodBarUni(rs.getInt("codbaruni"));
				produto.setIdCodBarPack(rs.getInt("codbarpack"));
				produto.setDescricaoProduto(rs.getString("descprod"));
				produto.setQtdEstoque(rs.getInt("idBdProduto"));
				produto.setCusto(rs.getFloat("custo"));
				produto.setMargemdelucro(rs.getFloat("margemdelucro"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setPrecoComRetornavel(rs.getFloat("precocomretornavel"));
				produto.setRepresentante(rs.getString("representante"));
				produto.setTelefones(rs.getString("telefones"));
				produto.setEmailRepresentante(rs.getString("emaldorepresentante"));
				produto.setInativo(rs.getInt("inativo"));
				produto.setRetornavel(rs.getInt("retornavel"));

			 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return produtoList;

		 }

}
