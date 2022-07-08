package com.jb.couponsphase3.controllers;

import com.jb.couponsphase3.beans.ClientType;
import com.jb.couponsphase3.beans.Company;
import com.jb.couponsphase3.beans.Customer;
import com.jb.couponsphase3.exceptions.LoginException;
import com.jb.couponsphase3.exceptions.NotExistException;
import com.jb.couponsphase3.exceptions.TokenException;
import com.jb.couponsphase3.services.serviceImpl.AdminServiceImpl;
import com.jb.couponsphase3.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    private final JWT jwt;
    private final AdminServiceImpl adminService;

    @PostMapping("/addCompany")
    public ResponseEntity<?> addCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.addCompany(company));
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.updateCompany(company);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @DeleteMapping("/deleteCompany/{companyID}")
    public ResponseEntity<?> deleteCompany(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCompany(companyID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<?> getAllCompanies(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getAllCompanies());
    }

    @GetMapping("/getCompanyByID/{companyID}")
    public ResponseEntity<?> getCompanyByID(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCompanyByID(companyID));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.addCustomer(customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.updateCustomer(customer);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @DeleteMapping("/deleteCustomer/{customerID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> deleteCustomer(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCustomer(customerID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .build();
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token.replace("Bearer ", "")))
                .body(adminService.getAllCustomers());
    }

    @GetMapping("/getCustomerByID/{customerID}")
    public ResponseEntity<?> getCustomerByID(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCustomerByID(customerID));
    }

}
