import { Producto } from "./producto";

export class Venta {
          nombrePersona: string;
          tipoIdentificacion: string;
          numeroIdentificacion: number;
          productos: Producto[];
          cantidadProductos: number;
          fechaEntrega: string;
          direccionEntrega: string;
          valorPedido: number;
}
