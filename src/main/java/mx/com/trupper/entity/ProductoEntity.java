package mx.com.trupper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int producto_id;

	//private int orden_id;
	private String codigo;
	private String descripcion;
	private double precio;
	
	
	
	@ManyToOne
	@JoinColumn(name = "orden_id")
	private OrdenesEntity listaOrdenes;

	public ProductoEntity() {

	}

	public ProductoEntity(int producto_id, int orden_id, String codigo, String descripcion, double precio) {
		this.producto_id = producto_id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public OrdenesEntity getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(OrdenesEntity listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}

}
