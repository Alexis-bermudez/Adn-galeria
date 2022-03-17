update recibo
set total = :total,
	entrega_inmediata = :entregaInmediata,
	fecha_compra = :fechaCompra,
	fecha_entrega = :fechaEntrega,
	tipo_obra = :tipoObra,
	id_obra = :idObra
where id = :id