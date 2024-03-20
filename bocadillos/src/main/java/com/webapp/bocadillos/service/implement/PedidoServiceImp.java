package com.webapp.bocadillos.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bocadillos.model.Pedido;
import com.webapp.bocadillos.repository.PedidoRepo;
import com.webapp.bocadillos.service.PedidoService;

@Service
public class PedidoServiceImp implements PedidoService{

	@Autowired
	private PedidoRepo PedidoRepo;
	
	@Override
	public Pedido insertarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return PedidoRepo.save(pedido);
	}

	@Override
	public List<Pedido> obtenerTodas() {
		// TODO Auto-generated method stub
		return null;
	}



}

