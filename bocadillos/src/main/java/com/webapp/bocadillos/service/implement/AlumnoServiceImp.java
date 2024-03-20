package com.webapp.bocadillos.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bocadillos.model.Alumno;
import com.webapp.bocadillos.repository.AlumnoRepo;
import com.webapp.bocadillos.service.AlumnoService;
@Service
public class AlumnoServiceImp implements AlumnoService{
	
	@Autowired
	private AlumnoRepo AlumnoRepo;
	
	@Override
	public Alumno insertarAlumnoNombre(String nombre) {
		Alumno emp = new Alumno();
		emp.setNombre(nombre);
		//emp.setSalario(salario);
		
		return AlumnoRepo.save(emp);
	}
	
	@Override
	public Alumno insertarAlumno(Alumno alumno) {
		return AlumnoRepo.save(alumno);
	}
	
	@Override
	public List<Alumno> listadoAlumnos(){
		//return AlumnoRepo.findAll();
		return AlumnoRepo.findAll();
	}
	
	@Override
	public Alumno obtenerAlumno(Integer id) {
		int idInt = (int) id;
		return AlumnoRepo.findById(idInt).orElse((null));
	}
	
	@Override
	public List<Alumno> obtenerTodas(){
		return AlumnoRepo.findAll();
	}
	
	@Override
	public Alumno obtenerAlumno(String nombre) {
		return AlumnoRepo.findByNombre(nombre).orElse((null));
	}
	
	@Override
	public void eliminarAlumno(Integer id) {
		//int idInt = (int) id;
		AlumnoRepo.deleteById(id);
	}

	@Override
	public List<Alumno> findAllAlumnos() {
		// TODO Auto-generated method stub
		return AlumnoRepo.findAll();
	}
	
	

}