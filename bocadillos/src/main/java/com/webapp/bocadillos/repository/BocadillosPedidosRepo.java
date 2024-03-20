package com.webapp.bocadillos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bocadillos.model.BocadilloPedidoId;
import com.webapp.bocadillos.model.BocadillosPedidos;

public interface BocadillosPedidosRepo extends JpaRepository<BocadillosPedidos, BocadilloPedidoId> {
	
	//public Optional<BocadillosPedidos> findById (BocadilloPedidoId id);

}
