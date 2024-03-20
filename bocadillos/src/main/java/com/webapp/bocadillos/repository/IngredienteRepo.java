package com.webapp.bocadillos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bocadillos.model.Ingrediente;

public interface IngredienteRepo extends JpaRepository<Ingrediente,Integer>{
	public Optional<Ingrediente> findByNombre(String nombre);

}
