import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  authorInfo: any = {
    ime: 'Ljiljana',
    prezime: 'Đurić',
    fakultet: 'Fakultet Tehničkih nauka, Novi Sad',
    brojIndeksa: 'IT48/2020'
  };

  constructor() { }

  ngOnInit(): void {
  }
}