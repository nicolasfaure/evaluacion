package com.bumeran.evaluacion.daos;

import com.bumeran.evaluacion.model.Pedido;

public interface DAO<T>{

	void insertOrUpdate(T entity);
	void delete(Pedido entity);
	Pedido select(Integer entity);
}
