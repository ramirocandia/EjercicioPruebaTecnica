package mx.com.trupper.controller;

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
import mx.com.trupper.entity.OrdenesEntity;
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
	public ResponseEntity<OrdenesEntity> crear(@RequestBody OrdenDTO ordenDTO) {
		OrdenesEntity ordenesEntity = ordenService.crear(ordenDTO);
		return new ResponseEntity<>(ordenesEntity, HttpStatus.valueOf(HttpStatus.CREATED.value()));
	}

}
