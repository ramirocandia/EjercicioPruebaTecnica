package mx.com.trupper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name = "ORDENES")
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
