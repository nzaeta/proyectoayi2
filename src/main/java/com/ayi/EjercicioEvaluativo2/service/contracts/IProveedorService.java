package com.ayi.EjercicioEvaluativo2.service.contracts;

import com.ayi.EjercicioEvaluativo2.entity.Proveedor;
import java.util.List;

public interface IProveedorService {

    public List<Proveedor> listarProveedores();

    public Proveedor crearProveedor(Proveedor proveedor);
    public void eliminar(Integer id);

    public Proveedor encontrarProveedor(int id);
}
