package com.miempresa.controller;

import com.miempresa.model.Producto;
import com.miempresa.model.Venta;
import com.miempresa.service.PedidoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("miempresa-app")
@CrossOrigin(value = "http://localhost:4200")
public class VentaControlador {

    private static final Logger logger = LoggerFactory.getLogger(VentaControlador.class);
    List<Producto> listaProductos = new ArrayList<>();
    Venta ventaProcesada = new Venta();

    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping("/agregarProductos")
    public Producto  agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        listaProductos = pedidoServicio.agregarProducto(producto , listaProductos);
        listaProductos = pedidoServicio.definirPrecio(listaProductos);
        return producto;
    }


    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){

        return listaProductos;

    }

    @PostMapping("/generarVenta")
    public void generarVenta(@RequestBody Venta venta){

        venta.setValorPedido(pedidoServicio.calcularValorPedido(listaProductos));
        ventaProcesada = pedidoServicio.generarVenta(venta, listaProductos);
    }

    @GetMapping("/venta")
    public Venta mostrarVenta(){
        return ventaProcesada;
    }

    @GetMapping("/finalizar")
    public void finalizar(){
        listaProductos = new ArrayList<>();
        ventaProcesada = new Venta();
    }

}
