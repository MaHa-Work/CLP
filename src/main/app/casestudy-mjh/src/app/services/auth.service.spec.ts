import { TestBed } from '@angular/core/testing';

import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { of } from 'rxjs';

describe('AuthService', () => {
  let service: AuthService;
  let httpClientSpy:jasmine.SpyObj<HttpClient>;
  const user:User = new User(1, 'test', 'test', 'test');
  const blankUser:User = new User(0,'','','');

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj<HttpClient>(['post']);
    TestBed.configureTestingModule({
      providers:[{provide:HttpClient, useValue:httpClientSpy}]
    });
    service = TestBed.inject(AuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a user from the db', () => {
    httpClientSpy.post.and.returnValue(of(user));
    let returnedUser:User = blankUser;

    service.login({email:'email', password:'password'}).subscribe(ret=>returnedUser=ret);

    expect(returnedUser.id).toBeGreaterThan(0);
    expect(returnedUser.name).toBeTruthy();
  });
});
