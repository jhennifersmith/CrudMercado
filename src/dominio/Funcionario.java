package dominio;

public class Funcionario extends Pessoa {

	private Integer idFuncionario;
	private Float comissao;

	public Funcionario() {
	}

	public Funcionario(Integer idPessoa, String nome, String endereco, Integer idFuncionario, Float comissao) {
		super(idPessoa, nome, endereco);
		this.idFuncionario = idFuncionario;
		this.comissao = comissao;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Float getComissao() {
		return comissao;
	}

	public void setComissao(Float comissao) {
		this.comissao = comissao;
	}

}
