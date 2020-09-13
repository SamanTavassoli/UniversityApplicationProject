import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAuthenticationService } from '../_services/user-authentication.service';

/**
 * This class intercepts every http request that the user is making,
 * and adds the appropriate authorization if there is one
 */
@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(private authService: UserAuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const user = this.authService.userValue;
        const isLoggedIn = user && user.token;
        let authReq = request;
        // can also check that we are calling the correct api here
        if (isLoggedIn) {
            authReq = request.clone({
                setHeaders: {
                    'Authorization' : `Bearer ${user.token}`
                }
            })
        }
        return next.handle(authReq);
    }
}

export const authInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ];