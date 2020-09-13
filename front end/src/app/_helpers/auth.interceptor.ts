import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAuthenticationService } from '../_services/user-authentication.service';

const TOKEN_HEADER_KEY = 'Authorization';

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
        // can also check that we are calling the correct api here
        if (isLoggedIn) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${user.token}`
                }
            })
        }
        return next.handle(request);
    }
}