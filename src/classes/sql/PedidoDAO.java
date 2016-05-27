package classes.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.RegPedidos;

public class PedidoDAO {

	private Conexao conexao;
	private ResultSet rs;
	private PreparedStatement ps;	

	public PedidoDAO(Conexao con) {
		this.conexao = con;
	}
	
	public int proximoCodigo(){
		 int cod = 0;
		 String sql = "select max(idPedidos) from pedidos";

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

	public void Incluir(RegPedidos pedidos) {
		String sql = "insert into pedidos values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conexao.getCon().prepareStatement(sql);
			ps.setInt(1, pedidos.getIdPedidos());
			ps.setString(2, pedidos.getAtendente());
			ps.setString(3, pedidos.getCliente());
			ps.setString(4, pedidos.getPedido());
			ps.setDate(5, new java.sql.Date(pedidos.getDataPedido().getTime()));
			ps.setDate(6, new java.sql.Date(pedidos.getDataEntrega().getTime()));
			ps.setString(7, pedidos.getEndereçoEntrega());
			ps.setInt(8, pedidos.getNumeroEndereco());
			ps.setString(9, pedidos.getBairro());
			ps.setString(10, pedidos.getCidade());
			ps.setString(11, pedidos.getEstado());
			ps.setString(12, pedidos.getContato());
			ps.setString(13, pedidos.getHoraEntrega());
			
			ps.execute();

		} catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void alterar(RegPedidos pedido) {
		 String sql = "update pedidos set atendente = ?,cliente = ?, pedido = ?, dataPedido = ?, dataEntrega = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, horaEntrega = ?" +  "where idPedidos = ?";

		 try {
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(13, pedido.getIdPedidos());
		 ps.setString(1, pedido.getAtendente());
		 ps.setString(2, pedido.getCliente());
		 ps.setString(3, pedido.getPedido());
		 ps.setDate(4, new java.sql.Date(pedido.getDataPedido().getTime()));
		 ps.setDate(5, new java.sql.Date(pedido.getDataEntrega().getTime()));
		 ps.setString(6, pedido.getEndereçoEntrega());
		 ps.setInt(7, pedido.getNumeroEndereco());
		 ps.setString(8, pedido.getBairro());
		 ps.setString(9,pedido.getCidade());
		 ps.setString(10, pedido.getEstado());
		 ps.setString(11, pedido.getContato());
		 ps.setString(12, pedido.getHoraEntrega());

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
		 String sql = "delete from pedidos where idPedidos = ?";

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
		 
		public RegPedidos consultar(int nome){
		 RegPedidos pedido = new RegPedidos();

		 
		 try {

				String sql = "select * from pedidos where idPedidos = ?";
						 
		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, nome);
		 			
			 rs = ps.executeQuery();
		 

		 if(rs.next()){

		 pedido.setIdPedidos(rs.getInt("idPedidos"));
		 pedido.setAtendente(rs.getString("atendente"));
		 pedido.setCliente(rs.getString("cliente"));		 
		 pedido.setPedido(rs.getString("pedido"));
		 pedido.setDataPedido(rs.getDate("dataPedido"));
		 pedido.setDataEntrega(rs.getDate("dataEntrega"));
		 pedido.setEndereçoEntrega(rs.getString("endereco"));
		 pedido.setNumeroEndereco(rs.getInt("numero"));
		 pedido.setBairro(rs.getString("bairro"));
		 pedido.setCidade(rs.getString("cidade"));
		 pedido.setEstado(rs.getString("estado"));
		 pedido.setContato(rs.getString("contato"));
		 pedido.setHoraEntrega(rs.getString("horaEntrega"));


		 }
		 else{
		 pedido = null;
		 }


		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return pedido;

		 }
		 
		 /**
		 * Consulta uma cidade com base no nome e retorna uma lista de objetos.
		 * Como uma das possibilidades da POO, o metodo utiliza o polimorfismo. Ele tem o mesmo
		 * nome de outro método nesta classe, porem com assinatura diferente
		 */
		 public List<RegPedidos> consultar(String nome){
		 RegPedidos pedido = null;
		 List<RegPedidos> pedidoList = new ArrayList<RegPedidos>();

		 String sql = "select * from Cidade where nome like ? order by nome";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setString(1, nome);
		 rs = ps.executeQuery();

		 while(rs.next()){
		 pedido = new RegPedidos();

		 pedido.setIdPedidos(rs.getInt("idPedidos"));
		 pedido.setAtendente(rs.getString("atendente"));
		 pedido.setCliente(rs.getString("cliente"));		 
		 pedido.setPedido(rs.getString("pedido"));
		 pedido.setDataPedido(rs.getDate("dataPedido"));
		 pedido.setDataEntrega(rs.getDate("dataEntrega"));
		 pedido.setEndereçoEntrega(rs.getString("localEntrega"));
		 pedido.setHoraEntrega(rs.getString("horaEntrega"));

		 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return pedidoList;

		 }

		 /**
		 *
		 * Recebe um codigo do estado e retorna todas as cidades daquele estado
		 *
		 * Neste metodo tambem eh chamado uma funcao criada no banco internamente
		 */
		 public List<RegPedidos> consultarPorEstado(int codigoEstado){
		 RegPedidos pedido = null;
		 List<RegPedidos> pedidoList = new ArrayList<RegPedidos>();

		 String sql = "select *, fIdade(dataFundacao) idade from Cidade where codigoEstado = ? order by nome";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, codigoEstado);
		 rs = ps.executeQuery();


		 while(rs.next()){
			 pedido = new RegPedidos();

			 pedido.setIdPedidos(rs.getInt("idPedidos"));
			 pedido.setAtendente(rs.getString("atendente"));
			 pedido.setCliente(rs.getString("cliente"));		 
			 pedido.setPedido(rs.getString("pedido"));
			 pedido.setDataPedido(rs.getDate("dataPedido"));
			 pedido.setDataEntrega(rs.getDate("dataEntrega"));
			 pedido.setEndereçoEntrega(rs.getString("localEntrega"));
			 pedido.setHoraEntrega(rs.getString("horaEntrega"));

			 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return pedidoList;

		 }

		 /**
		 *
		 * Este metodo recebe um mes e devolve uma Lista de objetos cidades
		 */
		 public List<RegPedidos> consultarPorMes(int mes){
		 RegPedidos pedido = null;
		 List<RegPedidos> pedidoList = new ArrayList<RegPedidos>();

		 String sql = "select *, fIdade(dataFundacao) idade from Cidade where month(dataFundacao) = ? " +  "order by dataFundacao";

		 try {

		 ps = conexao.getCon().prepareStatement(sql);
		 ps.setInt(1, mes);
		 rs = ps.executeQuery();

		 while(rs.next()){
			 pedido = new RegPedidos();
			 
			 pedido.setIdPedidos(rs.getInt("idPedidos"));
			 pedido.setAtendente(rs.getString("atendente"));
			 pedido.setCliente(rs.getString("cliente"));		 
			 pedido.setPedido(rs.getString("pedido"));
			 pedido.setDataPedido(rs.getDate("dataPedido"));
			 pedido.setDataEntrega(rs.getDate("dataEntrega"));
			 pedido.setEndereçoEntrega(rs.getString("localEntrega"));
			 pedido.setHoraEntrega(rs.getString("horaEntrega"));
			 
			 }

		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro na inserção dos dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro existente: "+e.getMessage(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		 }

		 return pedidoList;

		 }

}
