import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../models/Service';
import { HelperService } from '../services/helper.service';
import { User } from '../models/User';

@Component({
  selector: 'app-viewservice',
  standalone: true,
  imports: [],
  templateUrl: './viewservice.component.html',
  styleUrl: './viewservice.component.css'
})
export class ViewserviceComponent implements OnInit{
  private router = inject(Router)
  private service = inject(HelperService)
  private navig = this.router.getCurrentNavigation()
  seniorUsername = ""
  description = ""
  address = ""
  price = 0
  name = ""
  helperUsername = ""
  s : Service = new Service()
  user: User = new User()

  accepted = true
  isme=false
  

  ngOnInit(): void {
    if(this.navig?.extras?.state){
      this.s = this.navig.extras.state['service']
      this.user = this.navig.extras.state['user']
      this.seniorUsername = this.s.senior_username
      this.description = this.s.description
      this.address = this.s.address
      this.price = this.s.price
      this.name = this.s.name
      if(this.s.helper_username == null){
        this.accepted=false
        this.helperUsername = "The service is not yet accepted"
      } else{
        this.helperUsername = this.s.helper_username
        if(this.helperUsername == this.user.username){
          this.isme=true
        }
      }
      
       
    }
  }

  acceptService(){
    if(!this.accepted){
      this.service.pickService(this.user, this.s.id).subscribe(data=>{
        this.router.navigate([`/provide`], {
          state: {user: this.user}
        });
      })
    }
  }

  finishService(){
    this.service.removeService(this.s).subscribe(data=>{
      this.router.navigate([`/provide`], {
        state: {user: this.user}
      });
    })
  }

  back(){
    this.router.navigate([`/provide`], {
      state: {user: this.user}
    })

  }

}
