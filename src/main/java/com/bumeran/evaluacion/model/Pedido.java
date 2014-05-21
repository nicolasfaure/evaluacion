package com.bumeran.evaluacion.model;

public class Pedido {
	private int id=0;
	private String nombre="";
	private double monto=0;
	private double descuento=0;
	
	public Pedido(){
	}
	
	
	@Override
	public String toString()
	{
		return "Pedido@" + this.getId();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null){
			return false;
		}
		Pedido otroPedido = (Pedido)obj;
		return otroPedido.getId() == this.getId() &&
				otroPedido.getNombre() == this.getNombre() &&
				otroPedido.getMonto()==this.getMonto() &&
				otroPedido.getDescuento()==this.getDescuento();
		
	}
	@Override
	public int hashCode(){
		return super.hashCode();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
