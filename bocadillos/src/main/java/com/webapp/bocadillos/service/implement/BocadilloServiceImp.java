package com.webapp.bocadillos.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bocadillos.model.Bocadillo;
import com.webapp.bocadillos.model.Ingrediente;
import com.webapp.bocadillos.repository.BocadilloRepo;
import com.webapp.bocadillos.service.BocadilloService;

@Service
public class BocadilloServiceImp implements BocadilloService{
	@Autowired
	private BocadilloRepo BocadilloRepo;

//	@Override
//	public Bocadillo insertarBocadilloNombre(String nombre) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Bocadillo> listadoBocadillos() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Bocadillo obtenerBocadillo(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void eliminarBocadillo(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Bocadillo obtenerBocadillo(String nombre) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	@Override
	public Bocadillo insertarBocadillo(Bocadillo bocadillo) {
		return BocadilloRepo.save(bocadillo);
	}
//
//	@Override
//	public List<Bocadillo> obtenerTodas() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	 @Override
//	    public Bocadillo agregarIngredienteABocadillo(Integer idBocadillo, Ingrediente ingrediente) {
//	        Bocadillo bocadillo = BocadilloRepo.obtenerBocadillo(idBocadillo);
//	        if (bocadillo != null) {
//	            bocadillo.getIngredientes().add(ingrediente);
//	            return BocadilloRepo.guardarBocadillo(bocadillo);
//	        } else {
//	            // Manejo de error si el bocadillo no se encuentra
//	            return null;
//	        }
//	    }
	}
//	
	
	
	
	


