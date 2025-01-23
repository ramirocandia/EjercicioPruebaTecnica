package mx.com.trupper.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUCURSALES")
public class SucursalesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sucurcal_id;

	private String nombre;

	@OneToMany()
	private List<OrdenesEntity> listaOrdenes;

	public SucursalesEntity() {

	}

	public SucursalesEntity(int sucurcal_id, String nombre) {
		super();
		this.sucurcal_id = sucurcal_id;
		this.nombre = nombre;
	}

	public int getSucurcal_id() {
		return sucurcal_id;
	}

	public void setSucurcal_id(int sucurcal_id) {
		this.sucurcal_id = sucurcal_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
