package mx.com.trupper.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.trupper.entity.OrdenesEntity;

public interface OrdenRepository extends JpaRepository<OrdenesEntity, Integer> {

}
