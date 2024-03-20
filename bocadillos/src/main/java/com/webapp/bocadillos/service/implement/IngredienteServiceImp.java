package com.webapp.bocadillos.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bocadillos.model.Alumno;
import com.webapp.bocadillos.model.Ingrediente;
import com.webapp.bocadillos.repository.IngredienteRepo;
import com.webapp.bocadillos.service.IngredienteService;
@Service
public class IngredienteServiceImp implements IngredienteService{

	@Autowired
	private IngredienteRepo IngredienteRepo;
	@Override
	public Ingrediente insertarIngredienteNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingrediente> listadoIngredientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingrediente obtenerIngrediete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarIngrediete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ingrediente obtenerIngrediete(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingrediente insertarIngrediente(Ingrediente ingrediente) {
		return IngredienteRepo.save(ingrediente);
	}

	@Override
	public List<Ingrediente> obtenerTodas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
