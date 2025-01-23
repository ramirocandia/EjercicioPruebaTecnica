package mx.com.trupper.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class OrdenesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orden_id;
	private int sucursal_id;
	private String date;
	private double total;

	@ManyToOne
	@JoinColumn(name = "sucurcal_id")
	private SucursalesEntity sucursal;
	
	
	
	@OneToMany()
	private List<ProductoEntity> listaProductos;
	

	public OrdenesEntity() {

	}

	public OrdenesEntity(int orden_id, int sucursal_id, String date, double total) {
		this.orden_id = orden_id;
		this.sucursal_id = sucursal_id;
		this.date = date;
		this.total = total;
	}

	public int getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(int orden_id) {
		this.orden_id = orden_id;
	}

	public int getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public SucursalesEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalesEntity sucursal) {
		this.sucursal = sucursal;
	}

	public List<ProductoEntity> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoEntity> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

}
