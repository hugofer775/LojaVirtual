package negocio;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistencia.PessoaDAO;

import beans.Fone;
import beans.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private Fone fone;

	// Métodos de ações e controles

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem("");
	}

	public String actionGravar() {

		try {
			if (pessoa.getId() == 0) {
				
				
				if(pessoa.getTipo()==null) pessoa.setTipo("ROLE_CLIENTE");
				
				PessoaDAO.inserir(pessoa);
				if(pessoa.getTipo()=="ROLE_CLIENTE") return "/cliente/forma_de_pagamento";
				
				return actionInserir();
			} else {
				PessoaDAO.alterar(pessoa);
				return "/admin/lista_pessoa";
			}

		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar gravar uma nova pessoa.");
			erro.printStackTrace();

			return null;
		}
	}

	public String actionInserir() {

		try {
			pessoa = new Pessoa();

			return "/admin/lista_pessoa";
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar carregar Estados ao abrir o formulário de pessoa.");
			erro.printStackTrace();
			return null;
		}
	}
	
	public String actionInserirPessoaComum() {

		try {
			pessoa = new Pessoa();

			return "/publico/form_cliente";
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar carregar Estados ao abrir o formulário de pessoa.");
			erro.printStackTrace();
			return null;
		}
	}

	public String actionExcluir() {
		PessoaDAO.excluir(pessoa);
		return "/admin/lista_pessoa";
	}


	public String actionInserirFone() {
		Fone fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
		return "";
	}

	public String actionExcluirFone(Fone f) {
		// Os alunos ... pesquisar e codificar

		PessoaDAO.excluirFone(f);
		pessoa.getFones().remove(f);
		return "";
	}

	

	// Métodos Getters e Setters

	public Pessoa getPessoa() {
	
		
			return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Fone getFone() {
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}


	
}
