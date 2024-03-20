package com.webapp.bocadillos.model;

import java.util.Objects;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "BocadillosPedidos")
@Table(name = "bocadillos_pedidos")
public class BocadillosPedidos {
	
	@EmbeddedId
    private BocadilloPedidoId id;
	
    @ManyToOne(/*cascade = CascadeType.MERGE,*/ fetch = FetchType.EAGER)
    @MapsId("pedidoId")
    private Pedido pedido;
	
    @ManyToOne(/*cascade = CascadeType.MERGE,*/ fetch = FetchType.EAGER)
    @MapsId("bocadilloId")
    private Bocadillo bocadillo;
 
    @Column(name = "cantidad")
    private Integer cantidad =1;
    
//    @Column(name = "fecha")
//    private String fecha ="31-12-2023";
    
    
    private String nombre;
 
    
    private BocadillosPedidos() {}
 
    public BocadillosPedidos(Bocadillo b, Pedido p, int c) {
        this.bocadillo = b;
        this.pedido = p;
        this.cantidad = c;
        this.nombre = b.getNombre();
        this.id = new BocadilloPedidoId(p.getId(), b.getId());
    }
	
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        BocadillosPedidos that = (BocadillosPedidos) o;
        return Objects.equals(bocadillo, that.bocadillo) &&
               Objects.equals(pedido, that.pedido);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(pedido, bocadillo);
    }

	public BocadilloPedidoId getId() {
		return id;
	}

	public void setId(BocadilloPedidoId id) {
		this.id = id;
	}

	public Bocadillo getBocadillo() {
		return bocadillo;
	}

	public void setBocadillo(Bocadillo bocadillo) {
		this.bocadillo = bocadillo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return getBocadillo().getNombre();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
