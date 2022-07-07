package com.jb.couponsphase3.clr;

import com.jb.couponsphase3.beans.*;
import com.jb.couponsphase3.services.LoginService;
import com.jb.couponsphase3.services.serviceImpl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class AdminTest implements CommandLineRunner {
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Admin Test \n");
        AdminServiceImpl admin = (AdminServiceImpl) loginService.login(
                new ClientDetails("admin@admin.com", "admin", ClientType.ADMIN));

        companiesTest(admin);
        customersTest(admin);
    }

    private void companiesTest(AdminServiceImpl admin) throws Exception {
        admin.addCompany(Company.builder()
                .name("Oren INC")
                .email("no-reply@oren.inc")
                .password("orenInc")
                .build());

        admin.addCompany(Company.builder()
                .name("Lea INC")
                .email("no-reply@lea.inc")
                .password("leasInc")
                .build());

        admin.addCompany(Company.builder()
                .name("Tal INC")
                .email("no-reply@tal.inc")
                .password("talbInc")
                .build());

//        CREATE TEST
//        System.out.println("Adding companies");
//        TablePrinter.print(admin.getAllCompanies()); doesn't work - failed to lazily initialize
//        admin.getAllCompanies().forEach(System.out::println);
//        System.out.println();

//        DELETE TEST
//        System.out.println("Deleting company");
//        admin.deleteCompany(3);
//        TablePrinter.print(admin.getAllCompanies()); doesn't work - failed to lazily initialize
//        admin.getAllCompanies().forEach(System.out::println);
//        System.out.println();

//        UPDATE TEST
//        System.out.println("Updating company");
//        admin.updateCompany(Company.builder()
//                .id(2)
//                .name("Lea INC")
//                .email("noreply@lea.inc")
//                .password("leasInc")
//                .build());

//        READ TEST
//        TablePrinter.print(admin.getAllCompanies()); doesn't work - failed to lazily initialize
//        admin.getAllCompanies().forEach(System.out::println);
//        System.out.println();
    }

    private void customersTest(AdminServiceImpl admin) throws Exception {
        admin.addCustomer(Customer.builder()
                .firstName("Oren")
                .lastName("Levi")
                .email("orenlevi6@gmail.com")
                .password("orenOren")
                .build());

        admin.addCustomer(Customer.builder()
                .firstName("Lea")
                .lastName("Sad")
                .email("leasad@gmail.com")
                .password("leaLea")
                .build());

        admin.addCustomer(Customer.builder()
                .firstName("Tal")
                .lastName("Bechor")
                .email("talb@gmail.com")
                .password("talTal")
                .build());

//        CREATE TEST
//        System.out.println("Adding customers");
//        TablePrinter.print(admin.getAllCustomers()); doesn't work - failed to lazily initialize
//        admin.getAllCustomers().forEach(System.out::println);
//        System.out.println();

//        DELETE TEST
//        System.out.println("Deleting customer");
//        admin.deleteCustomer(3);
//        TablePrinter.print(admin.getAllCustomers()); doesn't work - failed to lazily initialize
//        admin.getAllCustomers().forEach(System.out::println);
//        System.out.println();

//        UPDATE TEST
//        System.out.println("Updating customer");
//        admin.updateCustomer(Customer.builder()
//                .id(2)
//                .firstName("Lea")
//                .lastName("Sad")
//                .email("leas@gmail.com")
//                .password("leaLea")
//                .build());

//        READ TEST
//        TablePrinter.print(admin.getAllCustomers()); doesn't work - failed to lazily initialize
//        admin.getAllCustomers().forEach(System.out::println);
//        System.out.println();
    }

}
