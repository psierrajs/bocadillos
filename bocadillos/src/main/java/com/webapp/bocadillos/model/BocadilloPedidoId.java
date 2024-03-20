package com.webapp.bocadillos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable 
public class BocadilloPedidoId implements Serializable {

		    

	private static final long serialVersionUID = 1L;

		@Column(name = "pedido_id")
	    private Integer pedidoId;
			
		@Column(name = "bocadillo_id")
	    private Integer bocadilloId;
	 
	    
	    
	    private BocadilloPedidoId() {}
	 
	    public BocadilloPedidoId(Integer IdP,Integer IdB ) {
	    	 this.pedidoId = IdP;
	    	 this.bocadilloId = IdB;
	       
	    }
	
	
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	 
	        if (o == null || getClass() != o.getClass())
	            return false;
	 
	        BocadilloPedidoId that = (BocadilloPedidoId) o;
	        return Objects.equals(bocadilloId, that.bocadilloId) &&
	               Objects.equals(pedidoId, that.pedidoId);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(bocadilloId, pedidoId);
	    }

		public Integer getBocadilloAd() {
			return bocadilloId;
		}

		public void setBocadilloAd(Integer idBocadillo) {
			bocadilloId = idBocadillo;
		}

		public Integer getPedidoAd() {
			return pedidoId;
		}

		public void setPedidoAd(Integer idPedido) {
			pedidoId = idPedido;
		}
	
	
	
	
	    
	
	
}
