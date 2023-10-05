import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RealizarVentaComponent } from './realizar-venta/realizar-venta.component';

const routes: Routes = [
  {path:'realizar-venta', component: RealizarVentaComponent},
  {path: '' , redirectTo: 'productos', pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
