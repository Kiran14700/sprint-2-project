import { BookingService } from '../booking.service';
import { Booking } from '../booking';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-book-ticket',
  templateUrl: './book-ticket.component.html',
  styleUrls: ['./book-ticket.component.css']
})
export class BookTicketComponent implements OnInit {

  booking: Booking = new Booking();
  submitted = false;
  
  constructor(public http:HttpClient, private router: Router) { 
  }


  
  var_firstName=""
  var_lastName=""
  var_emailId=""
  var_phone=""
  var_address=""
  var_source=""
  var_destination=""
  var_date=""
  // var_document=""

  

  onSubmit(){

    var booking = {

      //"id":this.var_firstName,
      "firstName":this.var_firstName,
      "lastName":this.var_lastName,
      "emailId":this.var_emailId,
      "phone":this.var_phone,
      "address":this.var_address,
      "source":this.var_source,
      "destination":this.var_destination,
      "date":this.var_date,
      // "document":this.var_document
    }

    // alert(JSON.stringify(aplicant));

    //we arev sending data to server springboot app
    // if(this.var_firstName==null || this.var_firstName==''){
    //   console.log('enter firstname');
    //   alert('Enter First Name');
    // }
    // if(this.var_lastName==null || this.var_lastName==''){
    //   console.log('enter lastname');
    //   alert('Enter First Name');
    // }
    // if(this.var_emailId==null || this.var_emailId==''){
    //   console.log('enter valid email id');
    //   alert('Enter First Name');
    // }
    // if(this.var_phone==null || this.var_phone==''){
    //   console.log('enter phone nubmer');
    //   alert('Enter First Name');
    // }
    // if(this.var_address==null || this.var_address==''){
    //   console.log('enter address');
    //   alert('Enter First Name');
    // }
    // if(this.var_source==null || this.var_source==''){
    //   console.log('enter source');
    //   alert('Enter First Name');
    // }
    // if(this.var_destination==null || this.var_destination==''){
    //   console.log('enter destination');
    //   alert('Enter First Name');
    // }
    // if(this.var_date==null || this.var_date==''){
    //   console.log('enter date');
    //   alert('Enter First Name');
    // }
    this.http.post<any>("http://localhost:8080/bookings", booking).subscribe(data=>{

    // alert("data sent successfully");
    this.gotoList();
    });
  }






  // constructor(private bookingService: BookingService,
  //   private router: Router) { }

  ngOnInit() {
  }

  newBooking(): void {
    this.submitted = false;
    this.booking = new Booking();
  }

  // save() {
  //   this.bookingService
  //   .createBooking(this.booking).subscribe(data => {
  //     console.log(data)
  //     this.booking = new Booking();
  //     this.gotoList();
  //   }, 
  //   error => console.log(error));
  // }

  // onSubmit() {
  //   this.submitted = true;
  //   this.save();    
  // }

  gotoList() {
    this.router.navigate(['/bookings']);
  }

}
