package com.jb.couponsphase3.jobs;

import com.jb.couponsphase3.repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class CouponExpirationDailyJob {
    private final CouponRepo couponRepo;

    @Scheduled(cron = "0 15 15 * * ? ", zone = "Asia/Jerusalem")
    public void deleteExpiredCoupons() {
        couponRepo.deletePurchasedExpiredCoupons();
        couponRepo.deleteExpiredCoupons();
    }

}
