
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
  prod_id serial NOT NULL,
  prod_nome character varying(80),
  prod_preco double precision,
  prod_fabricante character varying(60),
  prod_descricao character varying(400),
  prod_qtd bigint,
  prod_imagem character varying(400),
  CONSTRAINT produto_pkey PRIMARY KEY (prod_id)
);

create table pedido (ped_id serial primary key,
                     prod_id int,
                     pes_id int not null,
                     fpg_id int not null,
                     ped_dataemissao date not null,
                     ped_status varchar(15) not null,
                     ped_qtdparcelas int,
                     ped_data_autorizacao date,
                     ped_total float,
                     ped_desconto float,
                     constraint fkprod foreign key (prod_id) references produto(prod_id),
                     constraint fkpes foreign key (pes_id) references pessoa(pes_id),
                     constraint fkfpg foreign key (fpg_id) references forma_pgto(fpg_id)
                     );

create table itens_pedido (ipe_id serial,
                           ped_id integer not null,
                           prod_id integer,
                           ipe_qtde integer not null,
                           ipe_valorunit float,
                           ipe_subtotal float,
                           constraint fkipp foreign key (prod_id) references produto(prod_id),
                           constraint fkip foreign key (ped_id) references pedido(ped_id)
                           );
insert into pessoa(pes_nome, pes_email, pes_senha, pes_tipo)
values('hugo', '11', '11', 'ROLE_ADMINISTRADOR')