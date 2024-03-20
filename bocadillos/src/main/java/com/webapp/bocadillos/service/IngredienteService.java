package com.webapp.bocadillos.service;

import java.util.List;

import com.webapp.bocadillos.model.Ingrediente;

public interface IngredienteService {
	public Ingrediente insertarIngredienteNombre(String nombre);
	public List<Ingrediente> listadoIngredientes();
	public Ingrediente obtenerIngrediete(Integer id);
	public void eliminarIngrediete(Integer id);
	public Ingrediente obtenerIngrediete(String nombre);
	public Ingrediente insertarIngrediente(Ingrediente ingrediente);
	public List<Ingrediente> obtenerTodas();

}
