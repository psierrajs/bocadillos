package com.webapp.bocadillos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Podemos utilizar @Controller si después serializamos los objetos con @ResponseBody en cada método
//@RestController
//@RequestMapping("/listaAlumnos")
//public class AlumnoControllerRest {
//	@Autowired
//	private AlumnoServiceImpl alumnoService;
//
//	@GetMapping(value="/add/{nombre}")
//	public Alumno insertarAlumno(@PathVariable String nombre);return Alumno;
//
//}
//
////Etiqueta response body serializa los objetos y devuelve un JSON, no hace falta si usamos directamente @RestController
//// public @ResponseBody List<Alumno> listadoAlumnos(){
//	@GetMapping(value = { "", "/" })
//
//	public List<Alumno> listadoAlumnos() {
//		// Log.info("Inicio: Listado de Alumnos");
//		List<Alumno> Alumnos = alumnoService.listadoAlumnos();
//		return Alumnos;
//	}
//
//}
//
//	@GetMapping("/{id}")
//	public Alumno obtenerAlumno(@PathVariable int id) {
//		Alumno Alumno = alumnoService.obtenerAlumno(id);
//		return Alumno;
//	}
//
//	@GetMapping("/buscar/{nombre}")
//	public Alumno obtenerAlumno(@PathVariable String nombre) {
//		Alumno Alumno = alumnoService.obtenerAlumno(nombre);
//		return Alumno;
//	}
//
//@GetMapping("/delete/{id}")
//public Alumno obtenerAlumno(@PathVariable int id) {
//	alumnoService.obtenerAlumno(id);
//}