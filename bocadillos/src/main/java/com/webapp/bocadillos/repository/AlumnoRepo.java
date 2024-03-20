package com.webapp.bocadillos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bocadillos.model.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno,Integer>{
	public Optional<Alumno> findByNombre(String nombre);

}
