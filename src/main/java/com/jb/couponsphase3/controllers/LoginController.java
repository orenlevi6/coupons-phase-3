package com.jb.couponsphase3.controllers;

import com.jb.couponsphase3.beans.ClientDetails;
import com.jb.couponsphase3.exceptions.LoginException;
import com.jb.couponsphase3.services.LoginService;
import com.jb.couponsphase3.services.serviceImpl.AdminServiceImpl;
import com.jb.couponsphase3.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsphase3.services.serviceImpl.CustomerServiceImpl;
import com.jb.couponsphase3.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final JWT jwt;
    private final LoginService loginService;
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody ClientDetails clientDetails) throws LoginException {
        if (loginService.login(clientDetails) == null) {
            throw new LoginException(clientDetails.getClientType());
        }
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(clientDetails))
                .build();
    }

}
