package com.ayi.EjercicioEvaluativo2.repository;

import com.ayi.EjercicioEvaluativo2.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProveedorRepository extends JpaRepository <Proveedor, Integer> {
}
