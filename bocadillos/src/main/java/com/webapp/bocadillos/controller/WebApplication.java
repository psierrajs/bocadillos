package com.webapp.bocadillos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.webapp.bocadillos.model.Alumno;
import com.webapp.bocadillos.model.Bocadillo;
import com.webapp.bocadillos.model.Ingrediente;
import com.webapp.bocadillos.model.Pedido;
import com.webapp.bocadillos.service.implement.AlumnoServiceImp;
import com.webapp.bocadillos.service.implement.BocadilloServiceImp;
import com.webapp.bocadillos.service.implement.IngredienteServiceImp;
import com.webapp.bocadillos.service.implement.PedidoServiceImp;


@Controller
public class WebApplication {
	
	@Autowired
	private AlumnoServiceImp alumnoService;
	@Autowired
	private PedidoServiceImp pedidoService;
	@Autowired
	private BocadilloServiceImp bocadilloService;
	@Autowired
	private IngredienteServiceImp ingService;
	
	@GetMapping("/")
	String home() {
		return "index";
	}
	
	@GetMapping("/iniciarTablas")
	String llenarTablas() {
		llenarTablasDeDatos();
		return "index";
	}
	
	private void llenarTablasDeDatos() {
		// Creamos bocadillo choripan con dos ingredientes
		Ingrediente in1 = new Ingrediente("Lomo", false);
		Ingrediente in2 = new Ingrediente("Queso de Cabrales", true);
		Bocadillo bocata1 = new Bocadillo("Bocadillo de lomoqueso", false, 6.75);
		bocata1.getIngredientes().add(in1);
		bocata1.getIngredientes().add(in2);
		in1.getBocadillos().add(bocata1);
		in2.getBocadillos().add(bocata1);
		
		//creamos bocadillo lomocompi con dos ingredientes
		Ingrediente in3 = new Ingrediente("pimiento", false);
		Ingrediente in4 = new Ingrediente("aceitunas rellenas", true);
		Bocadillo bocata2 = new Bocadillo ("Bocadillo de pimientos", false, 5.85);
		bocata2.getIngredientes().add(in3);
		bocata2.getIngredientes().add(in4);
		in3.getBocadillos().add(bocata2);
		in4.getBocadillos().add(bocata2);
		
		Pedido pedido = new Pedido();
		
		//Creamos alumno y asociamos el pedido anterior
		Alumno alumno = new Alumno("Paquita");
		Alumno alumno2 = new Alumno("Juan");
		alumno.getPedidos().add(pedido);
		pedido.setAlumno(alumno);
		
		alumnoService.insertarAlumno(alumno);
		alumnoService.insertarAlumno(alumno2);
		//Test
		bocadilloService.insertarBocadillo(bocata1);
		bocadilloService.insertarBocadillo(bocata2);
		
		pedido.addBocadillo(bocata2,5);
		pedido.addBocadillo(bocata1,6);
		
		//pedido.cacularPrecio();
		
		pedidoService.insertarPedido(pedido);
		
		ingService.insertarIngrediente(in1);
		ingService.insertarIngrediente(in2);
		ingService.insertarIngrediente(in3);
		ingService.insertarIngrediente(in4);
	}

}
