package mx.com.trupper.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "SUCURSALES")
@JsonIgnoreProperties("ordenes")
public class SucursalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sucursal_id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@JsonManagedReference
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
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
