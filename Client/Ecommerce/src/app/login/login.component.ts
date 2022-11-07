import { Component, OnInit } from '@angular/core';
import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
import { UserService} from '../service/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: '/login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  image = "../../assets/login.jpg"

  email?:string
  pwd?:string
  constructor(private userserv:UserService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }
  functionOnWhichRedirectShouldHappen(){
    this.router.navigate(['/admin']);
  }
  Submit()
  {
     console.log(this.email);
     console.log(this.pwd);

     if(this.email=='admin@yahoo.com')
     {
         if(this.pwd=='1234')
         {
          this.router.navigate(['/adminpage']);
         }
         else{
          alert("failed");
            }

     }
      // this.userserv.getbyemail(this.email)
      //   .subscribe({
      //     next: (ur) => {
      //       this.functionOnWhichRedirectShouldHappen()
      //       console.log(ur);
      //     },
      //     error: (e) => console.error(e)
      //   });
  }

  Cancel()
  {
    this.router.navigate(['']);
  }

}
