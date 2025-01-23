package mx.com.trupper.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrdenDTO {

	private String nombreSucursal;
	private BigDecimal total;
	private List<ProductoDTO> listaProductos;

	private OrdenDTO() {

	}

	public OrdenDTO(String nombreSucursal, BigDecimal total, List<ProductoDTO> listaProductos) {
		this.nombreSucursal = nombreSucursal;
		this.total = total;
		this.listaProductos = listaProductos;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoDTO> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
