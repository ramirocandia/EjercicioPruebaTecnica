package mx.com.trupper.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUCURSALES")
public class SucursalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sucursal_id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@OneToMany(mappedBy = "sucursal")
	private List<OrdenEntity> ordenes;

	public SucursalEntity() {

	}

	public SucursalEntity(int sucursal_id, String nombre, List<OrdenEntity> ordenes) {
		this.sucursal_id = sucursal_id;
		this.nombre = nombre;
		this.ordenes = ordenes;
	}

	public int getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<OrdenEntity> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<OrdenEntity> ordenes) {
		this.ordenes = ordenes;
	}

}
