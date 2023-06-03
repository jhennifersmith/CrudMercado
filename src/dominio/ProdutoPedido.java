package dominio;

public class ProdutoPedido {
	private int id;
	private int idPedido;
	private int idProduto;
	private int quantidade;
	private Float precoCotado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPrecoCotado() {
		return precoCotado;
	}

	public void setPrecoCotado(Float precoCotado) {
		this.precoCotado = precoCotado;
	}

	public ProdutoPedido(int id, int idPedido, int idProduto, int quantidade, Float precoCotado) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.precoCotado = precoCotado;
	}

	public ProdutoPedido() {
		super();
	}

}
