package com.technical.controller;

import com.technical.repository.AccountRepository;
import com.technical.service.AccountService;
import com.technical.token.RequestTokenDTO;
import com.technical.token.ResponseTokenDTO;
import com.technical.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtToken jwtToken;

    @PostMapping("/authenticate")
    public ResponseTokenDTO authenticate(@RequestBody RequestTokenDTO dto ) {
        try{
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(
                            dto.getUsername(), dto.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            System.out.println("Authentication : " + authentication.isAuthenticated());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "can not authenticate", ex);
        }


        String role = userDetailsService
                .loadUserByUsername(dto.getUsername())
                .getAuthorities()
                .iterator()
                .next()
                .getAuthority();


        String token = jwtToken.generateToken(
                dto.getSubject(),
                dto.getUsername(),
                role
        );

        ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO(dto.getUsername(), role, token);
        return responseTokenDTO;
    }



}
