package com.ayi.EjercicioEvaluativo2.controller;

import com.ayi.EjercicioEvaluativo2.entity.Proveedor;
import com.ayi.EjercicioEvaluativo2.service.contracts.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {

    private String titulo = "Listado de Proveedores";

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/listadoprov")
    public String listadoprov(Model model) {
        var proveedores = proveedorService.listarProveedores();

        model.addAttribute("titulo", titulo);
        model.addAttribute("proveedores", proveedores);
        return "listadoprov.html";
    }

    @GetMapping("/eliminarProveedor/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        proveedorService.eliminar(id);
            return "redirect:../listadoprov";
    }

    @GetMapping("/nuevoProveedor")
    public String nuevoProveedor(Model model){
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor_form.html";
    }

    @PostMapping("/guardarProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor){
        proveedorService.crearProveedor(proveedor);
        return "redirect:/listadoprov";
    }

}
