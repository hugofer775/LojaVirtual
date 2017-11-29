package negocio;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import beans.FormaPgto;
import beans.ItensPedido;
import beans.Pedido;
import beans.Pessoa;
import beans.Produto;
import persistencia.PedidoDAO;

@ManagedBean
@SessionScoped
public class PedidoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido = new Pedido();
	private Produto produto = new Produto();
	private ItensPedido itens = new ItensPedido();
	private FormaPgto formaPgto = new FormaPgto();
	private Pessoa pessoa;
	private boolean desabilitarParcelas = true;




	public String adicionarProdutoAoCarrinho(Produto p) { 	// Adiciona produtos no carrinho
		this.itens.getListaProdutos().add(p);
		return null;
	}

	public String actionPagamento() {
		return "/cliente/forma_de_pagamento?faces-redirect=true";
	}

	public Date dataDoSistema() { // Pega a data atual
		Date hoje = new Date();
		return hoje;
	}

	public boolean isDesabilitarParcelas() {
		return desabilitarParcelas;
	}
	public String actionPedido() {
		valorDoPedido();
		return "itens_pedido?faces-redirect=true";
	}
	public void valorDoPedido() { // Varre a lista de produtos e soma todos os preços
									
		float valorTotal = 0;
		for (int i = 0; i < itens.getListaProdutos().size(); i++) {
			valorTotal += itens.getListaProdutos().get(i).getPreco();
		}
		// this.itens.setSubTotal(valorTotal);
		this.pedido.setTotal(valorTotal);
	}

	public String calcQuantidadeProduto(Produto p) { // pega a quantidade de produtos que o cliente solicitou e o preço (subtotal)
										
		valorDoPedido();
		this.itens.setSubTotal(p.getPreco());
		this.pedido.setTotal(p.getPreco());
		if (itens.getQuantidade() > 1) {
			float subtotalAtualizado = this.itens.getSubTotal() - p.getPreco();
			int qtd = itens.getQuantidade();
			this.itens.setSubTotal(subtotalAtualizado + (p.getPreco() * qtd));
			this.pedido.setTotal(subtotalAtualizado + (p.getPreco() * qtd));
		}
		
		return null;
	}

	public String excluirProdutoDoCarrinho(Produto p) {
		for (int i = 0; i < this.itens.getListaProdutos().size(); i++) {
			if (this.itens.getListaProdutos().get(i).getId() == p.getId()) {
				this.itens.getListaProdutos().remove(i);
				this.itens.setSubTotal(this.getItens().getSubTotal() - p.getPreco());
			}
		}
		return null;
	}

	public void setDesabilitarParcelas(boolean desabilitarParcelas) {
		this.desabilitarParcelas = desabilitarParcelas;
	}

	public String definirParcelas() { // para saber se a opção de forma de pagamento é de cartão de crédito, boleto ou débito
									
		if (this.formaPgto.getId() == 6) {

			this.desabilitarParcelas = false;

		} else {
			this.desabilitarParcelas = true;
			pedido.setQtdParcelas(0);

		}
		return null;
	}

	public void gravarPedido() {
		
		try {
			Pessoa userLogado = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
			System.out.println(userLogado.getEmail());
			PedidoDAO.inserir(pedido);
			
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar gravar um pedido.");
			erro.printStackTrace();
			// return null;
		}

	}

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItensPedido getItens() {
		return itens;
	}

	public void setItens(ItensPedido itens) {
		this.itens = itens;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
