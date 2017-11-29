
create table pessoa
(pes_id	serial primary key,
pes_nome	varchar(60),
pes_cpf	char(14),
pes_rg	varchar(20),
pes_data_nasc	date,
pes_rua	varchar(60),
pes_bairro	varchar(30),
pes_cidade	varchar(30),
pes_uf	char(2),
pes_cep	integer,
pes_email	varchar(40),
pes_senha	varchar(32),
pes_tipo varchar(30));

create table fone
(
fon_id serial primary key,
pes_id integer,
fon_numero varchar(20),
fon_descricao varchar(30),
constraint rel_pessoa_fone foreign key (pes_id) references pessoa (pes_id)
);

create table forma_pgto(
	fpg_id				 	serial primary key,
	fpg_descricao		 	varchar(20),
	fpg_num_max_parc	 	integer,
	fpg_num_padrao_parc	 	integer,
	fpg_intervalo_dias	 	integer,
	fpg_percentual_acres	 float
);

CREATE TABLE produto
(
  pro_id serial NOT NULL,
  prod_nome character varying(80),
  prod_preco double precision,
  prod_fabricante character varying(60),
  prod_descricao character varying(400),
  prod_qtd bigint,
  prod_imagem character varying(400),
  CONSTRAINT produto_pkey PRIMARY KEY (pro_id)
);

create table pedido(
	ped_id	 	serial primary key,
	pes_id	 	integer not null,
	fpg_id	 	integer not null,
	ped_status 	varchar(20),
	ped_data_Autorizacao	 timestamp,
	ped_total 	float,
	ped_desconto  float,
	ped_qtdparcelas float,
	constraint  rel_pessoa_pedido  foreign key  (pes_id)  references  pessoa(pes_id),
	constraint  rel_formapgto_pedido  foreign key  (fpg_id)  references  forma_pgto(fpg_id)
	);
	
create table itens_pedido(
	ipe_id	 	serial primary key,
	ped_id	 	integer not null,
	pro_id	 	integer not null,
	ipe_qtde 	float,
	ipe_valorUnit 	float,
	ipe_subtotal 	float,
	constraint  rel_pedito_itenspedido  foreign key  (ped_id)  references  pedido(ped_id),
	constraint  rel_produto_itenspedido  foreign key  (pro_id)  references  produto(pro_id)
	);
	
	
CREATE TABLE end_estado
(
  est_id 		serial 		NOT NULL		PRIMARY KEY,
  est_nome 		varchar(30),
  est_sigla 	char(2)
);

CREATE TABLE end_cidade
(
  cid_id 		serial 		NOT NULL		PRIMARY KEY,
  est_id 		integer 	NOT NULL,
  cid_nome 		varchar(80),
  CONSTRAINT fk_est_cid FOREIGN KEY (est_id) REFERENCES end_estado (est_id)
);