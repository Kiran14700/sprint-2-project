import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { RouterModule, Routes } from '@angular/router'; // Import Routes
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { TDetailsComponent } from './t-details/t-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'book-ticket', component: BookTicketComponent },
  { path: 'booking-list', component: BookingListComponent },
  { path: 'update/:id', component: UpdateBookingComponent },
  { path: 'details/:id', component: TDetailsComponent },
];



@NgModule({
  declarations: [
    AppComponent,
    BookTicketComponent,
    BookingListComponent,
    FooterComponent,
    HomeComponent,
    HeaderComponent,
    UpdateBookingComponent,
    TDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule ,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes), // Add this line to configure the routes
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule],
})
export class AppModule {}
