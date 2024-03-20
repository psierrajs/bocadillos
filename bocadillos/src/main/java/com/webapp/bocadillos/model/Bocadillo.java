package com.webapp.bocadillos.model;


import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;




/*
 * 
 * Añadir atributo cantidad a la relación M2M bocadillos pedidos
 * https://stackoverflow.com/questions/55091537/updating-a-manytomany-relationship-to-include-a-new-field
 * https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
 */

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name="bocadillos")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Bocadillo {
	
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="vegano")
	private boolean vegano;
		
	@OneToMany(
        mappedBy = "bocadillo",
        cascade = CascadeType.ALL,
        orphanRemoval = true
	)
	private Set<BocadillosPedidos> pedidos= new HashSet<BocadillosPedidos>();
	
	@ManyToMany(mappedBy = "bocadillos", fetch = FetchType.EAGER)
	private Set<Ingrediente> ingredientes;
	
	

	
	public Bocadillo() {
		
	}
	
	public Bocadillo(String n, boolean v, double p) {
		nombre = n;
		pedidos = new HashSet<BocadillosPedidos>();
		ingredientes = new HashSet<Ingrediente>();
		precio = p;
		vegano = v;
		 
		//Crud<Bocadillo> crudBocadillo  = new Crud<Bocadillo>();
	    //crudBocadillo = new Crud();
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<BocadillosPedidos> getPedidos() {
		return pedidos;
	}


	public void setPedidos(Set<BocadillosPedidos> pedidos) {
		this.pedidos = pedidos;
	}
	
	 
	public String toString(Integer cant) {
		String resultado=nombre+"--->>\nIngredientes:\n";
		for(Ingrediente in:ingredientes)
		{
			 resultado= resultado + in.toString();
		}
		resultado= resultado + "Cantidad: "+cant+"\n";
		resultado= resultado + "Precio: "+precio+" €\n";
		
		return resultado;			 
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	


}
