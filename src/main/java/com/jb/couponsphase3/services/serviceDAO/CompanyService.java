package com.jb.couponsphase3.services.serviceDAO;

import com.jb.couponsphase3.beans.Category;
import com.jb.couponsphase3.beans.Company;
import com.jb.couponsphase3.beans.Coupon;
import com.jb.couponsphase3.exceptions.NotExistException;

import java.util.List;

public interface CompanyService {

    int addCoupon(Coupon coupon) throws NotExistException;

    void updateCoupon(Coupon coupon) throws NotExistException;

    void deleteCoupon(int couponID) throws NotExistException;

    List<Coupon> getAllCompanyCoupons() throws NotExistException;

    List<Coupon> getAllCompanyCouponsByCategory(Category category) throws NotExistException;

    List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Company getCompanyDetails();
}
