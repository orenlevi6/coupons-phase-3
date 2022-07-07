package com.jb.couponsphase3.services;

import com.jb.couponsphase3.beans.ClientDetails;
import com.jb.couponsphase3.exceptions.LoginException;
import com.jb.couponsphase3.services.serviceImpl.AdminServiceImpl;
import com.jb.couponsphase3.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsphase3.services.serviceImpl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    public ClientService login(ClientDetails clientDetails) throws LoginException {
        ClientService clientService = null;
        switch (clientDetails.getClientType()) {
            case ADMIN:
                clientService = adminService;
                break;
            case COMPANY:
                clientService = companyService;
                break;
            case CUSTOMER:
                clientService = customerService;
        }
        if (clientService.login(clientDetails.getEmail(), clientDetails.getPassword())) {
            return clientService;
        }
        throw new LoginException(clientDetails.getClientType());
    }

}
