package beans;

import javax.persistence.*;

@Entity
@Table (name="Produto")
public class Produto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="pro_id")
	private int id;
	@Column (name="prod_nome", length = 60, nullable = true)
	private String nome;
	@Column (name="prod_fabricante", nullable = true)
	private String fabricante;
	@Column (name="prod_preco", nullable = true)
	private float preco;
	@Column (name="prod_descricao", nullable = true)
	private String descricao;
	@Column (name="prod_qtd")
	private long quantidade;
	
	@Transient
	private String caminhoFotoProduto;
	
	public String getCaminho() {
		return caminhoFotoProduto;
	}
	public void setCaminho(String caminho) {
		this.caminhoFotoProduto = caminho;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
