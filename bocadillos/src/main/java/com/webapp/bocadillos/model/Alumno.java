package com.webapp.bocadillos.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

  

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name="alumnos")
public class Alumno {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;

	
	@OneToMany(cascade = { CascadeType.MERGE },mappedBy="alumno",fetch=FetchType.EAGER )
	//@JsonIgnore
	private Set<Pedido> pedidos;
	
	
	public Alumno() {
		pedidos = new HashSet<Pedido>();
	}
	public Alumno(String n) {
		pedidos = new HashSet<Pedido>();
		nombre = n;	 
	}
	
		
	public Set<Pedido> getPedidos() {
		return pedidos;
		
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		 
	}
	
	
	
	@Override
	public String toString() {
		return "Id_Alumno: "+id+"   Nombre: "+nombre+"\n" 
				+imprimirPedidos();
	}
	
	
	public String imprimirPedidos() {
		
		String resultado="Pedidos del alumno "+nombre+"\n";
		if(pedidos.size()==0) {
			resultado = (nombre+" No tiene pedidos");
		}else {
			for(Pedido p:pedidos) {
				resultado = resultado + p.toString();
			}
		}
		return resultado;
	}
	
	 
	public void imprimirAlumnos(List<Alumno> lista) {
		for(Alumno a:lista) {
			System.out.println(a.toString());
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}