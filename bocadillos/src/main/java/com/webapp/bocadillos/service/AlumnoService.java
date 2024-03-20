package com.webapp.bocadillos.service;

import java.util.List;

import com.webapp.bocadillos.model.Alumno;

public interface AlumnoService {
	public Alumno insertarAlumnoNombre(String nombre);
	public List<Alumno> listadoAlumnos();
	public Alumno obtenerAlumno(Integer id);
	public void eliminarAlumno(Integer id);
	public Alumno obtenerAlumno(String nombre);
	public Alumno insertarAlumno(Alumno alumno);
	public List<Alumno> findAllAlumnos();
	public List<Alumno> obtenerTodas();

}
