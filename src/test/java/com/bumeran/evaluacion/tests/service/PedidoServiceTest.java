package com.bumeran.evaluacion.tests.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.VerboseMockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.bumeran.evaluacion.daos.PedidoDAO;
import com.bumeran.evaluacion.model.Pedido;
import com.bumeran.evaluacion.model.builders.PedidoBuilder;
import com.bumeran.evaluacion.service.PedidoService;

@RunWith(VerboseMockitoJUnitRunner.class)
public class PedidoServiceTest {

	@Test
	public void testCrearoInsertarNuevoPedido()
	{
		Pedido pedido = this.buildPedido();
		PedidoDAO mockedPedidoDAO = this.BuildMockedPedidoDAO();
		PedidoService service = new PedidoService(mockedPedidoDAO);
		service.insertOrUpdate(pedido);
		verify(mockedPedidoDAO,times(1)).insertOrUpdate(pedido);
	}
	
	@Test
	public void testEliminarPedido()
	{
		Pedido pedido = this.buildPedido();
		PedidoDAO mockedPedidoDAO = this.BuildMockedPedidoDAO();
		PedidoService service = new PedidoService(mockedPedidoDAO);
		service.delete(pedido);
		verify(mockedPedidoDAO,times(1)).delete(pedido);
	}

	@Test
	public void testObtenerPedidoConIDExistente()
	{
		PedidoDAO mockedPedidoDAO = this.BuildMockedPedidoDAO();
		PedidoService service = new PedidoService(mockedPedidoDAO);
		Pedido actual = service.select(123);
		Pedido expected = this.buildPedido();
		verify(mockedPedidoDAO,times(1)).select(123);
		org.junit.Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testObtenerPedidoConIDInexistente()
	{
		PedidoDAO mockedPedidoDAO = this.BuildMockedPedidoDAO();
		PedidoService service = new PedidoService(mockedPedidoDAO);
		Pedido actual = service.select(1234);
		verify(mockedPedidoDAO,times(1)).select(1234);
		org.junit.Assert.assertNull(actual);
	}
	
	private Pedido buildPedido() {
		//Omito mockear Pedido, por ser una clase sin comportamiento
		Pedido pedido = new PedidoBuilder()
								.withNombre("UnNombre")
								.withDescuento(250)
								.withMonto(1000)
								.build();
		return pedido;
	}

	private PedidoDAO BuildMockedPedidoDAO() {
		PedidoDAO pedidoDAO = mock(PedidoDAO.class);
		when(pedidoDAO.select(123)).thenReturn(this.buildPedido());
		when(pedidoDAO.select(1234)).thenReturn(null);
		return pedidoDAO;
	}
	
}
