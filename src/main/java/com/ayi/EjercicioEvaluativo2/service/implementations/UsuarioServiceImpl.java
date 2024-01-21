package com.ayi.EjercicioEvaluativo2.service.implementations;

import com.ayi.EjercicioEvaluativo2.entity.Usuario;
import com.ayi.EjercicioEvaluativo2.repository.IUsuarioRepository;
import com.ayi.EjercicioEvaluativo2.service.contracts.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    @Transactional
    public Usuario update(Integer id, Usuario usuario){

        Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra el usuario con el id" + id)));
        Usuario user = usuarioOptional.get();
        user.setNombre(usuario.getNombre());
        user.setPasswordUsuario(usuario.getPasswordUsuario());
        return usuarioRepository.save(user);

    }

    @Override
    @Transactional
    public Usuario findById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
    }

    //public List<Usuario> findAll= usuarioRepository.findAll();

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }


}
