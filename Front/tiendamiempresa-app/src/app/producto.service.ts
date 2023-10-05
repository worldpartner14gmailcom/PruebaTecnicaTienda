import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlBase = "http://localhost:8080/miempresa-app/productos";
  private urlAgregarProducto = "http://localhost:8080/miempresa-app/agregarProductos";

  constructor(private clienteHttp: HttpClient) { }

  // Metodo para obtener la lista de los productos 
  obtenerProductosLista(): Observable<Producto[]>{
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }

  // metodo para enviar la informacion al back 
  agregarProducto(producto: Producto): Observable<Object>{
    return this.clienteHttp.post(this.urlAgregarProducto, producto);
  }

}
