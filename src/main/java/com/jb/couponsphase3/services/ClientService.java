package com.jb.couponsphase3.services;

import com.jb.couponsphase3.repositories.CompanyRepo;
import com.jb.couponsphase3.repositories.CouponRepo;
import com.jb.couponsphase3.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {

    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);
}
