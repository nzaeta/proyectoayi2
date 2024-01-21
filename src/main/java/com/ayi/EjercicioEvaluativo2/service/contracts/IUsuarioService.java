package com.ayi.EjercicioEvaluativo2.service.contracts;

import com.ayi.EjercicioEvaluativo2.entity.Usuario;


public interface IUsuarioService {


    Usuario save(Usuario usuario);

    Usuario update(Integer id, Usuario usuario);

    Usuario findById(Usuario usuario);

    void delete(Usuario usuario);


}
