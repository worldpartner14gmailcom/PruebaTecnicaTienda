package com.miempresa.service;

import com.miempresa.model.Producto;
import com.miempresa.model.Venta;

import java.util.List;

public interface PedidoServicioI {

    public List<Producto> agregarProducto(Producto producto, List<Producto> productos);

    public Venta generarVenta(Venta venta, List<Producto> productos);

    public Double calcularValorPedido(List<Producto> productos);

    public List<Producto> definirPrecio(List<Producto> productos);
}
