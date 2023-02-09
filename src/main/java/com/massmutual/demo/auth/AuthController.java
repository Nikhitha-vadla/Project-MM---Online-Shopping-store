package com.massmutual.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.massmutual.demo.auth.security.TokenProvider;
import com.massmutual.demo.auth.security.UserLoggedInService;
import com.massmutual.demo.exceptions.AppException;
import com.massmutual.demo.model.LoginRequest;
import com.massmutual.demo.model.LoginResponse;
import com.massmutual.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/login")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private TokenProvider tokenProvider;

    private UserServiceImpl userService;

    private UserLoggedInService userLoggedInService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserServiceImpl userService, UserLoggedInService userLoggedInService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
        this.userLoggedInService = userLoggedInService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws AuthenticationException {

        try{
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String authToken = tokenProvider.generateToken(authentication);

            LoginResponse result = new LoginResponse(loginRequest.getUserName(),"Success",authToken);

            return ResponseEntity.ok(result);
        }catch (AppException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage(),e);
        }catch (AuthenticationException e){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,"Bad Credentials",e
            );
        }
    }
}
