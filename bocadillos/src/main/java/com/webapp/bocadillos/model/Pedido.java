package com.webapp.bocadillos.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/*
 * 
 * Añadir atributo cantidad a la relación M2M bocadillos pedidos
 * https://stackoverflow.com/questions/55091537/updating-a-manytomany-relationship-to-include-a-new-field
 * https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
 */

@Entity
@Table(name="pedidos")
public class Pedido {

	  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name ="precio")
	private double precio;
	
	@ManyToOne //(cascade = { CascadeType.ALL },optional = true)
    @JoinColumn(name="id_alumno", nullable=true)
	@JsonIgnore
	private Alumno alumno;
	
    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Set<BocadillosPedidos> bocadillos;
	 
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pedido( ) {
		bocadillos = new HashSet<BocadillosPedidos>();
	}
	
	public Pedido(Alumno a) {
		alumno = a;
		bocadillos = new HashSet<BocadillosPedidos>();
		
	//	crudPedido = new Crud(); 
	}

    public void addBocadillo(Bocadillo b, int cantidad) {
    	BocadillosPedidos b_p = new BocadillosPedidos(b, this,cantidad);
    	if(bocadillos.contains(b_p)) {
    		bocadillos.remove(b_p);        	
    	}
    	if(cantidad!=0) {
        	bocadillos.add(b_p);
    	}
        b.getPedidos().add(b_p);
    }
    
    public void addBocadillo2(Bocadillo b, int cantidad) {
    	BocadillosPedidos b_p = new BocadillosPedidos(b, this,cantidad);
    	if(bocadillos.contains(b_p)) {
    		bocadillos.remove(b_p);        	
    	}
    	if(cantidad!=0) {
        	bocadillos.add(b_p);
    	}
       // b.getPedidos().add(b_p);
    }
 
    public void removeBocadillo(Bocadillo b) {
        for (Iterator<BocadillosPedidos> iterator = bocadillos.iterator();
             iterator.hasNext(); ) {
        	BocadillosPedidos b_p = iterator.next();
 
            if (b_p.getPedido().equals(this) &&
            		b_p.getBocadillo().equals(b)) {
                iterator.remove();
                b_p.getBocadillo().getPedidos().remove(b_p);
                b_p.setPedido(null);
                b_p.setBocadillo(null);
                b_p.setCantidad(0);
            }
        }
    }
	
	


	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<BocadillosPedidos> getBocadillos() {
		return bocadillos;
	}

	public void setBocadillos(Set<BocadillosPedidos> bocadillos) {
		this.bocadillos = bocadillos;
	}

	@Override
	public String toString() {
		return imprimirBocadillos();
	}
	
public String imprimirBocadillos() {
		
		String resultado="Boccadillos del pedido "+id+"\n";
		if(bocadillos.size()==0) {
			 
		}else {
			for(BocadillosPedidos b:bocadillos) {
				resultado = resultado + b.getBocadillo().toString(b.getCantidad());
				resultado = resultado + "\n";
			}
			resultado = resultado + "\n\n";
		}		
		return resultado;
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
	
public void calcularPrecio() {
	double resultado = 0.0;
	
	for(BocadillosPedidos b:bocadillos) {
		resultado += b.getBocadillo().getPrecio()*b.getCantidad();
	}
	precio = resultado; 
}
	
}
