package com.jb.couponsphase3.controllers;

import com.jb.couponsphase3.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping("/coupons")
    public ResponseEntity<?> getAllCoupons() {
        return ResponseEntity.ok()
                .body(guestService.getAllCoupons());
    }

}
