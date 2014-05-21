package com.bumeran.evaluacion.service;

import org.apache.log4j.Logger;

import com.bumeran.evaluacion.cache.BumexMemcached;
import com.bumeran.evaluacion.daos.PedidoDAO;
import com.bumeran.evaluacion.exceptions.PersistenceLayerException;
import com.bumeran.evaluacion.model.Pedido;

public class PedidoService {
	
	private PedidoDAO pedidoDAO;
	private Logger logger = Logger.getLogger("com.bumeran.evaluacion.service.PedidoService");
	public PedidoService(){
		this.setPedidoDAO(new PedidoDAO());
	}
	
	public PedidoService(PedidoDAO pedidoDAO){
		this.setPedidoDAO(pedidoDAO);
	}
	
	public void insertOrUpdate(Pedido pedido) {
		try
		{
			this.getPedidoDAO().insertOrUpdate(pedido);
			BumexMemcached.getInstance().set(pedido.toString(), pedido);
		}catch(PersistenceLayerException ex){
			this.getLogger().error("Se produjo una excepcion mientras se persistia " + pedido.toString(), ex);
			throw ex;
		}
	}

	public void delete(Pedido pedido) {
		try
		{
			this.getPedidoDAO().delete(pedido);
			BumexMemcached.getInstance().delete(pedido.toString());
		}catch(PersistenceLayerException ex){
			this.getLogger().error("Se produjo una excepcion mientras se intentó eliminar " + pedido.toString(), ex);
			throw ex;
		}
	}

	public Pedido select(int idPedido) {
		Pedido pedido = (Pedido)BumexMemcached.getInstance().get("pedido@" + idPedido);
		if(pedido==null){
			pedido = this.getPedidoDAO().select(idPedido);
		}
		return pedido;
	}

	protected PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	protected void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

	protected Logger getLogger() {
		return logger;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}
}
