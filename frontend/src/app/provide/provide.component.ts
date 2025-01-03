import { Component, inject, OnInit } from '@angular/core';
import { HelperService } from '../services/helper.service';
import { Service } from '../models/Service';
import { Router } from '@angular/router';
import { User } from '../models/User';

@Component({
  selector: 'app-provide',
  standalone: true,
  imports: [],
  templateUrl: './provide.component.html',
  styleUrl: './provide.component.css'
})
export class ProvideComponent implements OnInit{
  ngOnInit(): void {
    if(this.navig?.extras?.state){
      this.user = this.navig.extras.state['user']
    }

    this.service.getAllServices().subscribe(
      (services: Service[]) => {
        this.allServices = services;
      })
  }
  private service = inject(HelperService)
  private router = inject(Router)
  private navig = this.router.getCurrentNavigation()
  user: User = new User()
  allServices: Service[] = []

  chooseService(id: number){
    this.service.chooseService(id).subscribe(data=>{
      this.router.navigate([`/viewservice`], {
        state: {service: data, user: this.user}
      });
    })
  }

  goBack(){
    this.router.navigate([`/${this.user.type}`], {
      state: {user: this.user}
    })

  }
  
}
