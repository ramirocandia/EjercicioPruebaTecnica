package mx.com.trupper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.trupper.entity.OrdenEntity;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Integer> {

}
