package com.webapp.bocadillos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bocadillos.model.Bocadillo;

public interface BocadilloRepo extends JpaRepository<Bocadillo,Integer>{
	public Optional<Bocadillo> findByNombre(String nombre);
//	public Optional<Bocadillo> findById(Integer id);
//	public Bocadillo obtenerBocadillo(Integer idBocadillo);
//	public Bocadillo guardarBocadillo(Bocadillo bocadillo);

}
