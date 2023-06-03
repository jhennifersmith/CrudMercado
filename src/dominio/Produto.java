package dominio;

public class Produto {
	private int id;
	private String descricao;
	private String codBarras;
	private Float preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Produto(int id, String descricao, String codBarras, Float preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codBarras = codBarras;
		this.preco = preco;
	}

	public Produto() {
		super();
	}

}
