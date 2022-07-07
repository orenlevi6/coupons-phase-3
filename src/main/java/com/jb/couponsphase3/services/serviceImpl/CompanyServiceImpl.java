package com.jb.couponsphase3.services.serviceImpl;

import com.jb.couponsphase3.beans.Category;
import com.jb.couponsphase3.beans.Company;
import com.jb.couponsphase3.beans.Coupon;
import com.jb.couponsphase3.exceptions.ExceptionType;
import com.jb.couponsphase3.exceptions.NotExistException;
import com.jb.couponsphase3.services.ClientService;
import com.jb.couponsphase3.services.serviceDAO.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {
    private int companyID;

    /**
     * Performs a login check for a company
     *
     * @param email    Login email
     * @param password Login password
     * @return boolean that determines if the login was successful, while updating the local variable companyID
     */
    @Override
    public boolean login(String email, String password) {
        Optional<Company> optionalCompany = companyRepo.findByEmailAndPassword(email, password);
        if (optionalCompany.isPresent()) {
            this.companyID = optionalCompany.get().getId();
            return true;
        }
        return false;
    }

    /**
     * Adds a coupon to the database by a company
     *
     * @param coupon Full coupon instance that will be added to the database by the company logged in
     * @return coupon ID in order to assign to coupon in redux
     */
    @Override
    public int addCoupon(Coupon coupon) throws NotExistException {
        coupon.setCompany(getCompanyDetails());
        couponRepo.save(coupon);

        Optional<Coupon> optionalCoupon = couponRepo.findById(coupon.getId());
        if (optionalCoupon.isEmpty()) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        return optionalCoupon.get().getId();
    }

    /**
     * Updates a coupon in the database by a company
     *
     * @param coupon Full coupon instance that will be updated in the database by the company logged in
     * @throws NotExistException If the coupon does not exist or if the coupon does not belong to this company,
     *                           Or if the company was not found
     */
    @Override
    public void updateCoupon(Coupon coupon) throws NotExistException {
        coupon.setCompany(getCompanyDetails());
        if (!couponRepo.existsByIdAndCompanyId(coupon.getId(), this.companyID)) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        couponRepo.save(coupon);
    }

    /**
     * Deletes a coupon from the database by a company
     *
     * @param couponID The ID of the company that will be deleted
     * @throws NotExistException If the coupon does not exist or if the coupon does not belong to this company
     */
    @Override
    public void deleteCoupon(int couponID) throws NotExistException {
        if (!couponRepo.existsByIdAndCompanyId(couponID, this.companyID)) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        couponRepo.deleteCouponPurchaseByCouponID(couponID);
        couponRepo.deleteById(couponID);
    }

    /**
     * Gets all coupons of this company from the database
     *
     * @return A list of all the coupons of this company that exist in the database
     * @throws NotExistException If no coupons of this company exists in the database
     */
    @Override
    public List<Coupon> getAllCompanyCoupons() throws NotExistException {
        List<Coupon> companyCoupons = couponRepo.findAllByCompanyId(this.companyID);
        if (companyCoupons.isEmpty()) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        return companyCoupons;
    }

    /**
     * Gets all coupons of this company and category from the database
     *
     * @param category The category of the coupons which will be retrieved from the database
     * @return A list of all the coupons of this company in the given category that exist in the database
     * @throws NotExistException If no coupons of this company and category exists in the database
     */
    @Override
    public List<Coupon> getAllCompanyCouponsByCategory(Category category) throws NotExistException {
        List<Coupon> companyCouponsByCategory = couponRepo.findAllByCompanyIdAndCategory(this.companyID, category);
        if (companyCouponsByCategory.isEmpty()) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        return companyCouponsByCategory;
    }

    /**
     * Gets all coupons of this company and price limit from the database
     *
     * @param maxPrice The max price of the coupons which will be retrieved from the database
     * @return A list of all the coupons of this company in the given price limit that exist in the database
     * @throws NotExistException If no coupons of this company and price limit exists in the database
     */
    @Override
    public List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException {
        List<Coupon> companyCouponsByMaxPrice = couponRepo.findAllByCompanyIdAndPriceLessThanEqual(this.companyID, maxPrice);
        if (companyCouponsByMaxPrice.isEmpty()) {
            throw new NotExistException(ExceptionType.COUPON);
        }
        return companyCouponsByMaxPrice;
    }

    /**
     * Gets the company's details from the database
     *
     * @return The details of this company, that will be retrieved from the database
     */
    @Override
    public Company getCompanyDetails() {
        return companyRepo.findById(this.companyID).get();
    }

}
