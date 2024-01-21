package com.ayi.EjercicioEvaluativo2.controller;

import com.ayi.EjercicioEvaluativo2.entity.Usuario;
import com.ayi.EjercicioEvaluativo2.repository.IUsuarioRepository;
import com.ayi.EjercicioEvaluativo2.service.contracts.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String inicio() {

        return "redirect:/login";
    }
    @GetMapping("/login")
    public String mostrarFormularioLogin(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña inválidos!");
        }
        return "login.html";
    }


    @PostMapping("/login")
    public String loguearUsuario(@RequestParam String nombre, @RequestParam String password, Model modelo) {
        Usuario user = usuarioRepository.findByNombre(nombre);
        if (user != null && user.getPasswordUsuario().equals(password)) {
            return "redirect:/listadoprov";
        } else {
            modelo.addAttribute("error", "El nombre o la contraseña ingresadas no corresponden a un usuario registrado.");
            return "login";
        }
    }
}


