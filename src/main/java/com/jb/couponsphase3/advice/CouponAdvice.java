package com.jb.couponsphase3.advice;

import com.jb.couponsphase3.exceptions.CouponException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CouponAdvice {
    @ExceptionHandler({CouponException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleCouponException(Exception err) {
        return new ErrorDetails("Coupon Error", err.getMessage());
    }

}
