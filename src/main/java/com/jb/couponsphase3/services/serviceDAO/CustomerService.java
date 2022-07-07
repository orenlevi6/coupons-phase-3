package com.jb.couponsphase3.services.serviceDAO;

import com.jb.couponsphase3.beans.Category;
import com.jb.couponsphase3.beans.Coupon;
import com.jb.couponsphase3.beans.Customer;
import com.jb.couponsphase3.exceptions.CouponException;
import com.jb.couponsphase3.exceptions.NotExistException;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponID) throws NotExistException, CouponException;

    List<Coupon> getAllCustomerCoupons() throws NotExistException;

    List<Coupon> getAllCustomerCouponsByCategory(Category category) throws NotExistException;

    List<Coupon> getAllCustomerCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Customer getCustomerDetails();
}
