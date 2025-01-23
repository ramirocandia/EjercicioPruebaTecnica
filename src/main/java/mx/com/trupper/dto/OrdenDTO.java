package mx.com.trupper.dto;

import java.util.List;

public class OrdenDTO {

	private int sucursalId;
	private List<Integer> listaIdsProductos;
	private double total;

	public OrdenDTO() {

	}

	public OrdenDTO(int sucursalId, List<Integer> listaIdsProductos) {
		this.sucursalId = sucursalId;
		this.listaIdsProductos = listaIdsProductos;
	}
	
	

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}

	public List<Integer> getListaIdsProductos() {
		return listaIdsProductos;
	}

	public void setListaIdsProductos(List<Integer> listaIdsProductos) {
		this.listaIdsProductos = listaIdsProductos;
	}

}
