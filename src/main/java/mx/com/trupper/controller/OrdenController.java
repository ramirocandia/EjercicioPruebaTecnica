package mx.com.trupper.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.trupper.dto.OrdenDTO;
import mx.com.trupper.dto.ProductoDTO;
import mx.com.trupper.entity.OrdenEntity;
import mx.com.trupper.entity.SucursalEntity;
import mx.com.trupper.repository.OrdenRepository;
import mx.com.trupper.repository.ProductoRepository;
import mx.com.trupper.repository.SucursalRepository;
import mx.com.trupper.service.OrdenService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

	private final OrdenRepository ordenService;
	private final SucursalRepository sucursalRepository;
	private final ProductoRepository productoRepository;

	@Autowired
	public OrdenController(OrdenService ordenService, SucursalRepository sucursalRepository,
			ProductoRepository productoRepository) {
		this.ordenService = ordenService;
		this.sucursalRepository = sucursalRepository;
		this.productoRepository = productoRepository;
	}

	@GetMapping
	public String prueba() {
		return "Hola mundo";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ResponseEntity<OrdenEntity> crear(@RequestBody OrdenDTO ordenDTO) {

		
		return new ResponseEntity<>(ordenesEntity, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}

	public BigDecimal calcularTotal(List<ProductoDTO> listaProductos) {
		return listaProductos.stream().map(producto -> BigDecimal.valueOf(producto.getPrecio())).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

}
