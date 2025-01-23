package mx.com.trupper.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.trupper.controller.repository.OrdenRepository;
import mx.com.trupper.dto.OrdenDTO;
import mx.com.trupper.entity.OrdenesEntity;

@Service
public class OrdenService {

	private final OrdenRepository ordenRepository;

	@Autowired
	public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}

	public OrdenesEntity crear(OrdenDTO ordenDTO) {
		OrdenesEntity oEntity = new OrdenesEntity();
		oEntity.setSucursal_id(ordenDTO.getSucursalId());
		oEntity.setDate(obtenerFechaActual());
		oEntity.setTotal(ordenDTO.getTotal());
		return ordenRepository.save(oEntity);
	}

	public OrdenesEntity getOrderById(int ordenId) {
		Optional<OrdenesEntity> ordenEntity = ordenRepository.findById(ordenId);
		return ordenEntity.get();
	}

	private String obtenerFechaActual() {
		return "2025-01-23 11:24:01";
	}
}
