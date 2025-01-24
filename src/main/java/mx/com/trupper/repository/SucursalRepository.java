package mx.com.trupper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.trupper.entity.SucursalEntity;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {

}
