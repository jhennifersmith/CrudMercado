package dominio;

public class Funcionario {

	private Integer idFuncionario;
	private String nome;
	private Float salario;
	private Float comissao;
	
	public Funcionario() {}	
	
	public Funcionario(Integer idFuncionario, String nome, Float salario, Float comissao ) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.salario = salario;
		this.comissao = comissao;
	}
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getComissao() {
		return comissao;
	}
	public void setComissao(Float comissao) {
		this.comissao = comissao;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
	
	
}
