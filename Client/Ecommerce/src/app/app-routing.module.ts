import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './component/cart/cart.component';
import { ProductsComponent } from './component/products/products.component';
import {AdminpageComponent} from './adminpage/adminpage.component';
 import { ProductlistComponent } from './productlist/productlist.component';
import { UserlistComponent } from './userlist/userlist.component';
// import { CategorylistComponent } from './categorylist/categorylist.component';
import { LoginComponent } from './login/login.component';
import {AddproductComponent} from './addproduct/addproduct.component';
// import {ProductcollectionComponent} from './productcollection/productcollection.component'


const routes: Routes = [
  {path:'', redirectTo:'products',pathMatch:'full'},
  {path:'products', component: ProductsComponent},
  {path:'cart', component: CartComponent},
  {path:'adminpage', component: AdminpageComponent},
  {path:'admin', component: LoginComponent},
  {path:'productlist', component: ProductlistComponent},
  {path:'userlist', component: UserlistComponent},
  // {path:'categorylist', component: CategorylistComponent},
  {path:'addproduct', component: AddproductComponent},
  // {path:'getitemsall',component:ProductcollectionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
