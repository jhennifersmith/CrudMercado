package dominio;

public class Cliente extends Pessoa {

	private Integer idCliente;
	private String telefone;

	public Cliente() {
	}

	public Cliente(Integer idPessoa, String nome, String endereco, Integer idCliente, String telefone) {
		super(idPessoa, nome, endereco);
		this.idCliente = idCliente;
		this.telefone = telefone;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
