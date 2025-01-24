package mx.com.trupper.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "PRODUCTOS")
@JsonIgnoreProperties("orden")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int producto_id;

	@ManyToOne(fetch = FetchType.LAZY)
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
