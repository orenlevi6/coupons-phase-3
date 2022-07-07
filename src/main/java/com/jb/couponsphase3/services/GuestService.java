package com.jb.couponsphase3.services;

import com.jb.couponsphase3.beans.Coupon;
import com.jb.couponsphase3.repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final CouponRepo couponRepo;

    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

}
