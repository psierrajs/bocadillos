package com.webapp.bocadillos.service;

import java.util.List;

import com.webapp.bocadillos.model.Pedido;

public interface PedidoService {
//	public Pedido insertarPedidoNombre(String nombre);
//	public List<Pedido> listadoPedidos();
//	public Pedido obtenerPedido(Integer id);
//	public void eliminarPedido(Integer id);
//	public Pedido obtenerPedido(String nombre);
	public Pedido insertarPedido(Pedido pedido);
	public List<Pedido> obtenerTodas();

}
