create table obra (
  id int(11) not null auto_increment,
  titulo varchar(100) not null,
  tipo_obra varchar(45) not null,
  precio int(20) not null,
  vendido boolean not null,
  primary key (id)
);

create table recibo (
  id int(11) not null auto_increment,
  total int(10) not null,
  entrega_inmediata boolean not null,
  fecha_compra date not null,
  fecha_entrega date not null,
  tipo_obra varchar(45) not null,
  id_obra int(11) not null,
  primary  key (id)
);