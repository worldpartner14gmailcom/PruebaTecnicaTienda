package com.miempresa.repository;

import com.miempresa.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepositorioI {

    public List<Producto> agregarProducto(Producto producto, List<Producto> productos);
}
