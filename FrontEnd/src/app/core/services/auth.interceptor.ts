  
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable()
export class AppInterceptor implements HttpInterceptor {
    constructor() { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add auth header with jwt if user is logged in and request is to the api url
        const currentUser = localStorage.getItem('user');
        const isApiUrl = request.url.startsWith(environment.SERVER_URL);
        const isLogin = request.url.indexOf('oauth/token') > -1;
        if ( isApiUrl && ! isLogin) {
        alert(isLogin)

            // request = request.clone({
            //     setHeaders: {
            //         Authorization: `basic`,
            //         Username:environment.API_USERNAME,
            //         Password:environment.API_PASSWORD
            //     }
            // });
        }
        
        // else if(request.url.indexOf('oauth/token') > -1  && isApiUrl){
            
        // }

        return next.handle(request);
    }
}