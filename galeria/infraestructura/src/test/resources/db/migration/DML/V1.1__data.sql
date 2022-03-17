insert into obra (id, titulo, tipo_obra, precio, vendido)
values(1, 'La Gioconda', 'REALISMO', 3600000, false);

insert into recibo (id, total, entrega_inmediata, fecha_compra, fecha_entrega, tipo_obra, id_obra)
values(1, 3600000, false, '2022-03-16', '2022-03-31', 'REALISMO', 1);