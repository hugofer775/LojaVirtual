package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

	@Id
	@GeneratedValue
	@Column(name = "ipe_id")
	private int id;

	@Column(name = "ipe_qtde")
	private int quantidade;

	@Column(name = "ipe_valorunit")
	private float valorUnitario;

	@Column(name = "ipe_subtotal")
	private float subTotal;

	@ManyToOne
	@JoinColumn(name = "ped_id", nullable = false)
	private Pedido pedido;

	@OneToMany
	@JoinColumn(name = "prod_id")
	private List<Produto> listaProdutos = new ArrayList<>();

	// @ManyToOne
	// @JoinColumn(name="prod_id", nullable = false)
	// private Produto produto;

	public Pedido getPedido() {
		return pedido;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Itens_Pedido [id=" + id + "]";
	}
}
