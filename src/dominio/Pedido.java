package dominio;

import java.time.LocalDate;

public class Pedido {
	private int id;
	private Float valorTotal;
	private LocalDate dataPedido;
	private int idCliente;
	private int idFuncionario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Pedido(int id, Float valorTotal, LocalDate dataPedido, int idCliente, int idFuncionario) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.dataPedido = dataPedido;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
	}

	public Pedido() {
		super();
	}

}
