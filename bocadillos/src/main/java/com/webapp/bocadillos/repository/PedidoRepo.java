package com.webapp.bocadillos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bocadillos.model.Pedido;

public interface PedidoRepo extends JpaRepository<Pedido,Integer>{
	//public Optional<Pedido> findByNombre(String nombre);

}
