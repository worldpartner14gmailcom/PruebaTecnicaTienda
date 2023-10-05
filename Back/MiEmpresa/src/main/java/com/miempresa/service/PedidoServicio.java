package com.miempresa.service;

import com.miempresa.model.Producto;
import com.miempresa.model.Venta;
import com.miempresa.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServicio implements PedidoServicioI{

    @Autowired
    VentaRepositorio ventaRepositorio;


    @Override
    public List<Producto> agregarProducto(Producto producto, List<Producto> productos) {

        List<Producto> productosAgregados;
        productosAgregados = ventaRepositorio.agregarProducto(producto, productos);
        return productosAgregados;
    }

    @Override
    public Venta generarVenta(Venta venta, List<Producto> productos) {

        venta.setProductos(productos);
        venta.setCantidadProductos(productos.size());
        return venta;

    }

    @Override
    public Double calcularValorPedido(List<Producto> productos) {

        double valorVenta = 0;

        for (Producto producto : productos  ) {
           valorVenta = valorVenta + producto.getPrecio();
        }

        return valorVenta;
    }

    @Override
    public List<Producto> definirPrecio(List<Producto> productos) {

        for (Producto producto: productos ) {
            switch (producto.getTipoRopa()){
                case "Camisas Formales" -> {
                    producto.setPrecio(40000.0);
                }
                case "Pantalones Formales" -> {
                    producto.setPrecio(80000.0);
                }
                case "Chaquetas" -> {
                    producto.setPrecio(190000.0);
                }
                default -> {producto.setPrecio(0.0); }
            }
        }

        return productos;

    }


}
