package mx.com.trupper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ORDENES")
@JsonIgnoreProperties("sucursal")
public class OrdenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orden_id;

	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private SucursalEntity sucursal;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "total", nullable = false)
	private BigDecimal total;

	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
	private List<ProductoEntity> productos;

	public OrdenEntity() {
	}

	public int getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(int orden_id) {
		this.orden_id = orden_id;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}

}
