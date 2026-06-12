create table consertos(
    id bigint not null auto_increment,
    data_entrada varchar(20) not null,
    data_saida varchar(20),
    nome varchar(100) not null,
    experiencia  varchar(50),
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano varchar(4) not null,
    primary key(id)
);
