package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity 		//Define que a classe Pessoa ser� uma tabela no banco de dados
@Table (name="Pessoa") 
public class Pessoa {

	@Id //Define um atributo identificador na tabela
	@GeneratedValue (strategy = GenerationType.IDENTITY) //Define a forma que o atributo identificador ir� fazer o incremento
	@Column (name="pes_id")
	private int id;
	@Column (name="pes_nome", length = 60, nullable = true)
	private String nome;
	@Column (name="pes_cpf", length = 14, nullable = true)
	private char cpf;
	@Column (name="pes_rg", length = 20)
	private String rg;
	@Column (name="pes_data_nasc")
	private Date data;
	@Column (name="pes_rua", length = 60)
	private String rua;
	@Column (name="pes_bairro", length = 30)
	private String bairro;
	@Column (name="pes_cidade", length = 30)
	private String cidade;
	@Column (name="pes_uf", length = 2)
	private String uf;
	@Column (name="pes_cep")
	private int cep;
	@Column (name="pes_email", length = 40)
	private String email;
	@Column (name="pes_senha", length = 32)
	private String senha;
	@Column (name="pes_tipo", length = 30)
	private String tipo;
	
	//Relacionamento de 1 para v�rios
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch=FetchType.EAGER) //cascade significa que quando excluir um pessoa da tabela, todos os telefone tamb�m ser�o exclu�dos.
	private List<Fone> fones = new ArrayList<Fone>();
	
	
	
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
	public char getCpf() {
		return cpf;
	}
	public void setCpf(char cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Fone> getFones() {
		return fones;
	}
	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}
	
	
	
	
	
}