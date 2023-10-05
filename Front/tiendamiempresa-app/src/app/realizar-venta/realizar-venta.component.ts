import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Route, Router } from '@angular/router';


@Component({
  selector: 'app-realizar-venta',
  templateUrl: './realizar-venta.component.html',
  
  
})
export class RealizarVentaComponent {

  productos: Producto[];
  productoAgregar : Producto = new Producto();
  tipoRopa: String [] = ["Pantalones Formales", "Camisas Formales" , "Chaquetas"];
  listaTallaa: String [] = ["XS", "S" , "M" ,"L" ,"XL"];
  listaColores: String [] = ["Amarillo", "Azul" , "Rojo" ,"Lila" ,"Negro"];

  constructor(private productoService: ProductoService , private enrutador: Router){}

  ngOnInit(){
    // Cargar todos los productos 
    this.obtenerProductos();
  }

  private obtenerProductos(){
    // consumir los datos del observable
    this.productoService.obtenerProductosLista().subscribe(datos => {
      this.productos= datos;
    })
  }

  onAdd(){
    this.guardarProducto();
  }

  guardarProducto(){
    this.productoService.agregarProducto(this.productoAgregar).subscribe(
      {
        next: (datos)=>{
          this.ngOnInit();
        },
        error: (error:any) =>{
          console.log(error);
        }
      }
    );
  }

  irListaProductos(){
    this.enrutador.navigate(['/realizar-venta'])
  } 

}
