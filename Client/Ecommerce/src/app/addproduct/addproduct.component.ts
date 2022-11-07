//import { Component, OnInit } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  constructor(private http:HttpClient,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }

  /* file upload */
     /* Variabe to store file data */
     imageSrc?:string
     selectedFiles : any
     imageName?:string
    retrievedImage: any;
    base64Data: any;
    retrieveResonse: any;








  prdtform = new FormGroup({
    prnm: new FormControl('', [Validators.required, Validators.minLength(5)]),
    description: new FormControl('' ,[Validators.required]),
    qty: new FormControl('', [Validators.required]),
    priceperunit: new FormControl('', [Validators.required]),
    image: new FormControl('', [Validators.required]),
    fileS: new FormControl('')
  });



  get f(){ return this.prdtform.controls;}

    /* File onchange event */
    onFileChange(e:any)
    {
      const reader = new FileReader();

    if(e.target.files && e.target.files.length)
    {
      this.selectedFiles = e.target.files[0];
      reader.readAsDataURL(this.selectedFiles);

      this.prdtform.controls["fileS"].patchValue(this.selectedFiles);

      reader.onload = () => {
        this.imageSrc = reader.result as string;
      };

    }
  }

    /* Upload button functioanlity */
    onSubmitform() {
      const headers= new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');



      return this.http.post('http://localhost:8080/addprdt', this.prdtform.value,
       { observe: 'response' ,'headers':headers})
      .subscribe((response) => {
        if (response.status === 200)
        {
            this.uploadimage();
            this.router.navigate(['/productlist']);
    }
  });
}

  uploadimage()
  {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFiles, this.selectedFiles.name);
//Make a call to the Spring Boot Application to save the image
    this.http.post('http://localhost:8080/upload', uploadImageData, { observe: 'response' })
    .subscribe((response) => {
                if (response.status === 200) {
                              alert('Image uploaded successfully');

                } else {
                alert('Image not uploaded successfully');}
              });
}

//Gets called when the user clicks on retieve image button to get the image from back end

    getImage() {

    //Make a call to Sprinf Boot to get the Image Bytes.

    this.http.get('http://localhost:8080/getimage/' + this.imageName)

      .subscribe(

        res => {

          this.retrieveResonse = res;

          this.base64Data = this.retrieveResonse.image;

          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;

        }

      );

  }




}
