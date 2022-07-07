package com.jb.couponsphase3.clr;

import com.jb.couponsphase3.beans.Category;
import com.jb.couponsphase3.beans.ClientDetails;
import com.jb.couponsphase3.beans.ClientType;
import com.jb.couponsphase3.beans.Coupon;
import com.jb.couponsphase3.repositories.CouponRepo;
import com.jb.couponsphase3.services.LoginService;
import com.jb.couponsphase3.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsphase3.utils.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(2)
public class CompanyTest implements CommandLineRunner {
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Company Test \n");

//        System.out.println("Company 1");
        companyTest1();

//        System.out.println("Company 2");
        companyTest2();

//        System.out.println("Company 3");
        companyTest3();
    }

    private void companyTest1() throws Exception {
        CompanyServiceImpl company1 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("no-reply@oren.inc", "orenInc", ClientType.COMPANY));

        company1.addCoupon((Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Category.FOOD)
                .title("Mcdonald's")
                .description("Mcdonald's Discount 19.90$ Off!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(15)
                .price(19.90)
                .image("https://pbs.twimg.com/profile_images/1513918204325728257/5-R-x-P__400x400.jpg")
                .build()));

        company1.addCoupon(Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Category.ELECTRICITY)
                .title("Oven")
                .description("Oven Discount 99.90$ Off!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(5)
                .price(99.90)
                .image("https://media3.bosch-home.com/Product_Shots/1600x900/MCSA02401843_HBJ558YS0T_BuiltInOven_Bosch_STP_EVO_def.png")
                .build());

        company1.addCoupon(Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Category.RESTAURANT)
                .title("Gourmet")
                .description("Restaurant Discount 29.90$ Off!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(5)
                .price(29.90)
                .image("https://media-cdn.tripadvisor.com/media/photo-s/17/75/3f/d1/restaurant-in-valkenswaard.jpg")
                .build());

//        CREATE TEST
//        System.out.println("Adding coupons");
//        TablePrinter.print(company1.getAllCompanyCoupons());

//        UPDATE TEST
//        System.out.println("Updating coupon #1");
//        company1.updateCoupon(Coupon.builder()
//                .id(1)
//                .company(company1.getCompanyDetails())
//                .category(Category.FOOD)
//                .title("Mcdonald's")
//                .description("BLAH")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
//                .amount(10)
//                .price(19.90)
//                .image("M")
//                .build());

//        READ TEST #1
//        TablePrinter.print(company1.getAllCompanyCoupons());

//        READ TEST #2
//        System.out.println("Print all company coupons by category - FOOD");
//        TablePrinter.print(company1.getAllCompanyCouponsByCategory(Category.FOOD));

//        READ TEST #3
//        System.out.println("Print all company coupons by max price - 40");
//        TablePrinter.print(company1.getAllCompanyCouponsByMaxPrice(40));

//      DELETE TEST
//        System.out.println("Deleting coupon #2");
//        company1.deleteCoupon(2);
//        TablePrinter.print(company1.getAllCompanyCoupons());

//        READ TEST #4
//        System.out.println("Get company #1 details");
//        TablePrinter.print(company1.getCompanyDetails()); doesn't work - failed to lazily initialize
//        System.out.println(company1.getCompanyDetails() + "\n");
    }

    private void companyTest2() throws Exception {
        CompanyServiceImpl company2 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("no-reply@lea.inc", "leasInc", ClientType.COMPANY));

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Category.FOOD)
                .title("Food")
                .description("39.90$ Discount For Food!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now()))
                .amount(6)
                .price(39.90)
                .image("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/assortment-of-colorful-ripe-tropical-fruits-top-royalty-free-image-995518546-1564092355.jpg")
                .build());

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Category.ELECTRICITY)
                .title("Microwave")
                .description("49.90$ Discount For Microwave")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(4)
                .price(49.90)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKeezHBRy0EJ4ED-6q5SBXnjt06rlCINsP5Q&usqp=CAU")
                .build());

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Category.VACATION)
                .title("Bora Bora")
                .description("249.90$ Discount For Bora Bora Plane Tickets!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(3)
                .price(249.90)
                .image("https://media-cdn.tripadvisor.com/media/photo-s/1c/b3/44/bb/borexterior.jpg")
                .build());

//        CREATE TEST
//        System.out.println("Adding coupons");
//        TablePrinter.print(company2.getAllCompanyCoupons());

//        UPDATE TEST
//        System.out.println("Updating coupon #4");
//        company2.updateCoupon(Coupon.builder()
//                .id(4)
//                .company(company2.getCompanyDetails())
//                .category(Category.FOOD)
//                .title("Food")
//                .description("39.90$ Discount For General Foods!")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now()))
//                .amount(26)
//                .price(39.90)
//                .image("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/assortment-of-colorful-ripe-tropical-fruits-top-royalty-free-image-995518546-1564092355.jpg")
//                .build());

//        READ TEST #1
//        TablePrinter.print(company2.getAllCompanyCoupons());

//        READ TEST #2
//        System.out.println("Print all company coupons by category - FOOD");
//        TablePrinter.print(company2.getAllCompanyCouponsByCategory(Category.FOOD));

//        READ TEST #3
//        System.out.println("Print all company coupons by max price - 40");
//        TablePrinter.print(company2.getAllCompanyCouponsByMaxPrice(40));

//        DELETE TEST
//        System.out.println("Deleting coupon #5");
//        company2.deleteCoupon(5);
//        TablePrinter.print(company2.getAllCompanyCoupons());

//        READ TEST #4
//        System.out.println("Get company #2 details");
//        TablePrinter.print(company2.getCompanyDetails()); doesn't work - failed to lazily initialize
//        System.out.println(company2.getCompanyDetails() + "\n");
    }

    private void companyTest3() throws Exception {
        CompanyServiceImpl company3 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("no-reply@tal.inc", "talbInc", ClientType.COMPANY));

        company3.addCoupon(Coupon.builder()
//                .company(company3.getCompanyDetails())
                .category(Category.FOOD)
                .title("Foodies!")
                .description("39.90$ Discount For Food!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now()))
                .amount(10)
                .price(39.90)
                .image("https://static1.squarespace.com/static/53b839afe4b07ea978436183/53bbeeb2e4b095b6a428a13e/5fd2570b51740e23cce97919/1619789725229/traditional-food-around-the-world-Travlinmad.jpg")
                .build());

        company3.addCoupon(Coupon.builder()
//                .company(company3.getCompanyDetails())
                .category(Category.ELECTRICITY)
                .title("Microwave")
                .description("29.90$ Discount For Microwave")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(7)
                .price(29.90)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTNR2-GhDTq7wSUHT678nPGDa703okVjwlHQ&usqp=CAU")
                .build());

        company3.addCoupon(Coupon.builder()
//                .company(company3.getCompanyDetails())
                .category(Category.VACATION)
                .title("Boca Raton")
                .description("490$ Discount For Vacation in Boca Raton!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(2)
                .price(490)
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Mizner_Park.jpg/1200px-Mizner_Park.jpg")
                .build());

//        CREATE TEST
//        System.out.println("Adding coupons");
//        TablePrinter.print(company3.getAllCompanyCoupons());

//        UPDATE TEST
//        System.out.println("Updating coupon #8");
//        company3.updateCoupon(Coupon.builder()
//                .id(8)
//                .company(company3.getCompanyDetails())
//                .category(Category.ELECTRICITY)
//                .title("Microwave")
//                .description("bla bla")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now()))
//                .amount(7)
//                .price(49.90)
//                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTNR2-GhDTq7wSUHT678nPGDa703okVjwlHQ&usqp=CAU")
//                .build());

//        READ TEST #1
//        TablePrinter.print(company3.getAllCompanyCoupons());

//        READ TEST #2
//        System.out.println("Print all company coupons by category - FOOD");
//        TablePrinter.print(company3.getAllCompanyCouponsByCategory(Category.FOOD));

//        READ TEST #3
//        System.out.println("Print all company coupons by max price - 40");
//        TablePrinter.print(company3.getAllCompanyCouponsByMaxPrice(40));

//        DELETE TEST
//        System.out.println("Deleting coupon #3");
//        company3.deleteCoupon(3);
//        TablePrinter.print(company3.getAllCompanyCoupons());

//        READ TEST #4
//        System.out.println("Get company #2 details");
//        TablePrinter.print(company2.getCompanyDetails()); doesn't work - failed to lazily initialize
//        System.out.println(company3.getCompanyDetails() + "\n");
    }

}
