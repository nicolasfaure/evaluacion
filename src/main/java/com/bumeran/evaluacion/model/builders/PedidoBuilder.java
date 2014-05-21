package com.bumeran.evaluacion.model.builders;

import com.bumeran.evaluacion.model.Pedido;

public class PedidoBuilder implements Builder<Pedido>{
	
	private Pedido pedido;
	
	public PedidoBuilder(){
		this.setPedido(new Pedido());
	}

	public PedidoBuilder withNombre(String nombre){
		this.getPedido().setNombre(nombre);
		return this;
	}
	
	public PedidoBuilder withMonto(double monto){
		this.getPedido().setMonto(monto);
		return this;
	}
	
	public PedidoBuilder withDescuento(double descuento){
		this.getPedido().setDescuento(descuento);
		return this;
	}

	public Pedido build() {
		return this.getPedido();
	}

	protected Pedido getPedido() {
		return pedido;
	}
	
	protected void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
