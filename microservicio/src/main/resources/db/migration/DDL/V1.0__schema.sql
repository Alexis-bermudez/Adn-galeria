create table obra (
 id int(11) not null auto_increment,
 titulo varchar(100) not null,
 tipoObra varchar(45) not null,
 precio int(20) not null,
 vendido boolean not null
 primary key (id)
);

create table recibo (
 id int(11) not null auto_increment,
 total int(10) not null,
 entregaInmediata boolean not null;
 fechaCompra date not null;
 fechaEntrega date not null;
 idObra int(11) not null;
);