package mx.com.trupper.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
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

	@ManyToOne
	@JoinColumn(name = "orden_id", nullable = false)
	private OrdenEntity orden;

	@Column(name = "codigo", nullable = false, length = 20)
	private String codigo;

	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;

	@Column(name = "precio", nullable = false)
	private BigDecimal precio;

	public ProductoEntity() {

	}

	public ProductoEntity(int producto_id, OrdenEntity orden, String codigo, String descripcion, BigDecimal precio) {
		this.producto_id = producto_id;
		this.orden = orden;
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

	public OrdenEntity getOrden() {
		return orden;
	}

	public void setOrden(OrdenEntity orden) {
		this.orden = orden;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
