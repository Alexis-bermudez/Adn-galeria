update obra
set titulo = :titulo,
	tipo_obra = :tipoObra,
	precio = :precio,
	vendido = :vendido
where id = :id and vendido = 0