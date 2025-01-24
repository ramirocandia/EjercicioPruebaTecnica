package mx.com.trupper.controller;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.internal.CriteriaImpl.OrderEntry;
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
import mx.com.trupper.entity.ProductoEntity;
import mx.com.trupper.entity.SucursalEntity;
import mx.com.trupper.repository.OrdenRepository;
import mx.com.trupper.repository.ProductoRepository;
import mx.com.trupper.repository.SucursalRepository;
import mx.com.trupper.service.OrdenService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

	private final OrdenService ordenService;

	@Autowired
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}

	@GetMapping
	public String prueba() {
		return "Hola mundo";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ResponseEntity<OrdenEntity> crear(@RequestBody OrdenDTO ordenDTO) {

		OrdenEntity ordenesEntity = ordenService.crear(ordenDTO);
		return new ResponseEntity<>(ordenesEntity, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}


	
	@RequestMapping(value = "/sucursales", method = RequestMethod.GET)
	public ResponseEntity<List<SucursalEntity>> sucursales(){
		List<SucursalEntity> lista = ordenService.getAllSucursal();
		return new ResponseEntity<>(lista, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}
	
	@RequestMapping(value = "/ordenes", method = RequestMethod.GET)
	public ResponseEntity<List<OrdenEntity>> ordenes(){
		List<OrdenEntity> lista = ordenService.getAllOrden();
		return new ResponseEntity<>(lista, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}
	
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoEntity>> productos(){
		List<ProductoEntity> lista = ordenService.getAllProducts();
		return new ResponseEntity<>(lista, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}
	
}
