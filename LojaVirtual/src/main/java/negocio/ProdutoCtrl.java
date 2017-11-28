package negocio;


import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import persistencia.ProdutoDAO;
import beans.Produto;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable{

	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Produto prodSelecionado;
	
	public List<Produto> getListagem(){
		return ProdutoDAO.listagem("");
	}
	
	public String actionGravar(){
		

		if(produto.getId() == 0){
			ProdutoDAO.inserir(produto);
			return actionInserir();
		}else{
			ProdutoDAO.alterar(produto);
			return "/produto/lista_produto";
		}		
	}
	
	public String actionInserir(){
		produto = new Produto();
		return "/admin/lista_produto";
	}
	
	public String actionExcluir(Produto produto){
		ProdutoDAO.excluir(produto);
		return "/produto/lista_produto";
	}
	
	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			produto.setCaminho(arquivoTemp.toString());
			//Messages.addGlobalInfo(produto.getCaminho());
			//System.out.println("Caminho: " + produto.getCaminho());
		} catch (IOException erro) {
			//Messages.addGlobalInfo("Ocorreu um erro ao tentar realizar o upload de arquivo");
			erro.printStackTrace();
		}
	}
		
	public String actionFecharDialogo(){
		produto = new Produto();
		
		return "/admin/lista_produto";
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdSelecionado() {
		return prodSelecionado;
	}

	public void setProdSelecionado(Produto prodSelecionado) {
		this.prodSelecionado = prodSelecionado;
	}


}
