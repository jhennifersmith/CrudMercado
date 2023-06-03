package dominio;

public class Pessoa {

	private Integer idPessoa;
	private String nome;
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(Integer idPessoa, String nome, String endereco) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
