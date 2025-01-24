package mx.com.trupper.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.trupper.dto.OrdenDTO;
import mx.com.trupper.dto.ProductoDTO;
import mx.com.trupper.entity.OrdenEntity;
import mx.com.trupper.entity.ProductoEntity;
import mx.com.trupper.entity.SucursalEntity;
import mx.com.trupper.repository.OrdenRepository;
import mx.com.trupper.repository.ProductoRepository;
import mx.com.trupper.repository.SucursalRepository;

@Service
public class OrdenService {

	private final OrdenRepository ordenRepository;
	private final SucursalRepository sucursalRepository;
	private final ProductoRepository productoRepository;

	@Autowired
	public OrdenService(OrdenRepository ordenRepository, SucursalRepository sucursalRepository,
			ProductoRepository productoRepository) {
		this.ordenRepository = ordenRepository;
		this.sucursalRepository = sucursalRepository;
		this.productoRepository = productoRepository;
	}

	public List<SucursalEntity> getAllSucursal() {
		return sucursalRepository.findAll();
	}

	public List<ProductoEntity> getAllProducts() {
		return productoRepository.findAll();
	}

	public List<OrdenEntity> getAllOrden() {
		return ordenRepository.findAll();
	}

	public OrdenEntity crear(OrdenDTO ordenDTO) {
		try {
			SucursalEntity sucursal = new SucursalEntity();
			sucursal.setNombre(ordenDTO.getNombreSucursal());
			sucursal = sucursalRepository.save(sucursal);

			OrdenEntity orden = new OrdenEntity();
			orden.setSucursal(sucursal);
			orden.setFecha(new Date());

			List<ProductoEntity> productos = ordenDTO.getListaProductos().stream().map(dto -> {
				ProductoEntity producto = new ProductoEntity();
				producto.setCodigo(dto.getCodigo());
				producto.setDescripcion(dto.getDescripcion());
				producto.setPrecio(BigDecimal.valueOf(dto.getPrecio()));
				producto.setOrden(orden);
				return producto;
			}).collect(Collectors.toList());

			orden.setProductos(productos);
			orden.setTotal(calcularTotal(ordenDTO.getListaProductos()));

			return ordenRepository.save(orden);

		} catch (Exception e) {
			throw new RuntimeException("Error al procesar la orden", e);
		}
	}

	public OrdenEntity getOrderById(int ordenId) {
		Optional<OrdenEntity> ordenEntity = ordenRepository.findById(ordenId);
		return ordenEntity.get();
	}

	public BigDecimal calcularTotal(List<ProductoDTO> listaProductos) {
		return listaProductos.stream().map(producto -> BigDecimal.valueOf(producto.getPrecio())).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}
}
