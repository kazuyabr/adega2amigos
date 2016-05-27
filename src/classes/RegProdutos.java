package classes;

public class RegProdutos {
 
	private int idCodProduto;//Variavel auxiliar para idcod do BD
	
	private int idCodBarUni;//Variavel auxiliar para Código de barra unitario do BD
	 
	private int idCodBarPack;//Variavel auxiliar para código de barra de pack do BD
	 
	private String descricaoProduto;//Variavel auxiliar para descrição do produto no BD
	 
	private int qtdEstoque;//Variavel auxiliar para quantidade em estoque no BD
	 
	private float custo;//Variavel auxiliar para custo no bd
	 
	private float margemdelucro;//Variavel auxiliar para margem de lucro em decimal 00000,00 no BD
	
	private float preco;//Variavel auxiliar para preço em decimal 00000,00 no BD
	
	private float precoComRetornavel;//Variavel auxiliar para preço C/ retornavel em decimal 00000,00 no BD
	 
	private String representante;//Variavel auxiliar para nome do representante	
	
	private String telefones;//Variavel auxiliar sem formatação para disposição de todos os telefones da empresa em uma só celula no bd
	
	private String emailRepresentante;//Variavel auxiliar para o email do representante
	
	private int inativo;
	
	private int retornavel;

	public int getIdCodProduto() {
		return idCodProduto;
	}

	public void setIdCodProduto(int idCodProduto) {
		this.idCodProduto = idCodProduto;
	}

	public int getIdCodBarUni() {
		return idCodBarUni;
	}

	public void setIdCodBarUni(int idCodBarUni) {
		this.idCodBarUni = idCodBarUni;
	}

	public int getIdCodBarPack() {
		return idCodBarPack;
	}

	public void setIdCodBarPack(int idCodBarPack) {
		this.idCodBarPack = idCodBarPack;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public float getMargemdelucro() {
		return margemdelucro;
	}

	public void setMargemdelucro(float margemdelucro) {
		this.margemdelucro = margemdelucro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getPrecoComRetornavel() {
		return precoComRetornavel;
	}

	public void setPrecoComRetornavel(float precoComRetornavel) {
		this.precoComRetornavel = precoComRetornavel;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmailRepresentante() {
		return emailRepresentante;
	}

	public void setEmailRepresentante(String emailRepresentante) {
		this.emailRepresentante = emailRepresentante;
	}

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
	}

	public int getRetornavel() {
		return retornavel;
	}

	public void setRetornavel(int retornavel) {
		this.retornavel = retornavel;
	}

	
	 
	
	 
}
 
