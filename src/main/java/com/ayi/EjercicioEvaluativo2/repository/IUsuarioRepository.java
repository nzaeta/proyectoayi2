package com.ayi.EjercicioEvaluativo2.repository;

import com.ayi.EjercicioEvaluativo2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Integer> {

      Usuario findByNombre (String nombre);

/*@Query("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre and u.password LIKE :password")
   Usuario user (@Param("nombre") String nombre, @Param("password") String password);*/

}
