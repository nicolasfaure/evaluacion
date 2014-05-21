package com.bumeran.evaluacion.daos;

import com.bumeran.evaluacion.model.Pedido;

public class PedidoDAO implements DAO<Pedido>{

	public void insertOrUpdate(Pedido pedido) {
		if(pedido.getId()==0)
		{
			// TODO: lógica creación
		}else{
			// TODO: lógica actualización 
		}
		
	}

	public void delete(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	public Pedido select(Integer idPedido) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
