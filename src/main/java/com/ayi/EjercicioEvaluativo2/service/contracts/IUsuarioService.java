package com.ayi.EjercicioEvaluativo2.service.contracts;

import com.ayi.EjercicioEvaluativo2.entity.Usuario;
import jakarta.transaction.Transactional;


public interface IUsuarioService {


    @Transactional
    Usuario save(Usuario usuario);

    @Transactional
    Usuario update(Integer id, Usuario usuario);

    @Transactional
    Usuario findById(Usuario usuario);

    @Transactional
    void delete(Usuario usuario);


}
