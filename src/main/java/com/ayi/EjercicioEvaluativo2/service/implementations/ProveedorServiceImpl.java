package com.ayi.EjercicioEvaluativo2.service.implementations;
import java.util.List;

import com.ayi.EjercicioEvaluativo2.entity.Proveedor;
import com.ayi.EjercicioEvaluativo2.repository.IProveedorRepository;
import com.ayi.EjercicioEvaluativo2.service.contracts.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Proveedor proveedor = proveedorRepository.getReferenceById(id);
        proveedorRepository.delete(proveedor);
    }

    @Override
    @Transactional
    public Proveedor crearProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return proveedor;
    }

}
