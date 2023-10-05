package com.miempresa.repository;

import com.miempresa.model.Producto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaRepositorio implements VentaRepositorioI{


    @Override
    public List<Producto> agregarProducto(Producto producto, List<Producto> productos) {

        productos.add(producto);

        return productos;
    }
}
