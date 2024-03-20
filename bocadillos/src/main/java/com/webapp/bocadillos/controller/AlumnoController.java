package com.webapp.bocadillos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.bocadillos.model.Alumno;
import com.webapp.bocadillos.service.implement.AlumnoServiceImp;

@RequestMapping("/alumnos")
@Controller
public class AlumnoController {

	@Autowired
	private AlumnoServiceImp alumnoService;
	
	//private AlumnoServiceImp alumnoService = new AlumnoServiceImp(); 
	
	@PostMapping("api/estudiantes")
	public Alumno guardarEstudiante(@RequestBody Alumno estudiante) {
		
		System.out.println(estudiante);	
		
		alumnoService.insertarAlumno(estudiante);
		return estudiante;
	}

	//private Crud<Alumno> crudAlumno = new Crud<>(Alumno.class);
	
	
	
	@GetMapping(value={"","/"})
	String alumnos(Model model) {

		List<Alumno> lista = alumnoService.obtenerTodas();
		model.addAttribute("alumnos",lista );
		model.addAttribute("nuevoAlumno",new Alumno() );
		model.addAttribute("alumnoaEditar", new Alumno());    
		model.addAttribute("nombreNuevo", "");    
		return "alumnos";
	}

	@GetMapping(value="/add/{nombre}")
	public String insertarAlumno(Model model, @PathVariable String nombre ) {
		
		 
		///crudAlumno.insertarRegistroHIBERNATE(alumno);
		//alumnoService.insertarAlumno(nombre);	
		alumnoService.insertarAlumnoNombre(nombre);
		System.out.println("Insertando alumno nuevo: "+nombre);		
		
		return "redirect:/alumnos";
	}
	
	
	@PostMapping("/add")
	public String addAlumno(@ModelAttribute("nuevoAlumno") Alumno alumno, BindingResult bindingResult) {
		
		alumnoService.insertarAlumno(alumno);
		System.out.println("Insertando alumno nuevo: "+alumno.getNombre());			
				
		return "redirect:/alumnos";	
	}
	
	@PostMapping("/edit/{id}")
	public String editarAlumno(@PathVariable Integer id, @ModelAttribute("alumnoaEditar") Alumno alumno,BindingResult bindingResult) {
		
		Alumno alumnoAEditar = alumnoService.obtenerAlumno(id);
		//crudAlumno.eliminarRegistro(alumno);
		alumnoAEditar.setNombre(alumno.getNombre());
		alumnoService.insertarAlumno(alumnoAEditar);
		
		return "redirect:/alumnos";
		 
	}
	
	 
	/*@GetMapping("/edit/{id}")
	public String editarAlumnoe(@PathVariable Integer id ) {
		
		Alumno alumnoAEditar = alumnoService.obtenerAlumno(id);
		//crudAlumno.eliminarRegistro(alumno);
		alumnoService.insertarAlumno(alumnoAEditar);
		
		return "redirect:/alumnos";		 
	} */
	
	
	@GetMapping({"/{id}"})
	public String obtenerAlumno(Model model, @PathVariable Integer id) {
	 
		model.addAttribute("alumno", alumnoService.obtenerAlumno(id));
		
		return "alumno";
	}
	
	@GetMapping({"/buscar/{nombre}"})
	public String obtenerAlumno(@PathVariable String nombre) {
		Alumno Alumno = alumnoService.obtenerAlumno(nombre);
		return "alumno";
	}
	
	@GetMapping({"/delete/{id}"})
	public String borrarAlumno(@PathVariable Integer id) {
		
		//Alumno alumno = crudAlumno.buscarPorId(id);
		//crudAlumno.eliminarRegistro(alumno);
		alumnoService.eliminarAlumno(id);
		
		return "redirect:/alumnos";
		 
	}
	
//	@GetMapping("/listarLAumnos")
//	public String mostrarAlumando(Model model) {
//		List<Alumno> lista = crudAlumno.listarRegistros("Alumno");
//		model.addAttribute("listaPersonas",lista );
//		
//		
//		return "listar";
//	}
//	
	
	
}
