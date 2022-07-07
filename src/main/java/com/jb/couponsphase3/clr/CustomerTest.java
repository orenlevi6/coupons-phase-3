package com.jb.couponsphase3.clr;

import com.jb.couponsphase3.beans.ClientDetails;
import com.jb.couponsphase3.beans.ClientType;
import com.jb.couponsphase3.services.LoginService;
import com.jb.couponsphase3.services.serviceImpl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class CustomerTest implements CommandLineRunner {
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        CustomerServiceImpl customerService = (CustomerServiceImpl) loginService.login(
                new ClientDetails("orenlevi6@gmail.com", "orenOren", ClientType.CUSTOMER));

//        CREATE TEST
//        System.out.println("Purchase coupon");
        customerService.purchaseCoupon(1);
//        TablePrinter.print(customerService.getAllCustomerCoupons());

//        READ TEST #1
//        System.out.println("Get coupons by category - FOOD");
//        TablePrinter.print(customerService.getAllCustomerCouponsByCategory(Category.FOOD));

//        READ TEST #2
//        System.out.println("Get coupons by max price - 50");
//        TablePrinter.print(customerService.getAllCustomerCouponsByMaxPrice(50));

//        READ TEST #3
//        System.out.println("Get customer #1 details");
//        TablePrinter.print(customerService.getCustomerDetails()); doesn't work - failed to lazily initialize
//        System.out.println(customerService.getCustomerDetails());
    }

}
