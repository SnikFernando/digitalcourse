package com.litanocg.digitalcourse.controllers;

import com.litanocg.digitalcourse.entities.Coupon;
import com.litanocg.digitalcourse.entities.dtos.CouponDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public Flux<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/{id}")
    public Mono<CouponDTO> getCouponById(@PathVariable Long id) {
        return couponService.getCouponById(id);
    }

    @PostMapping
    public Mono<CouponDTO> createCoupon(@Validated @RequestBody CouponDTO coupon) {
        return couponService.createCoupon(coupon);
    }

    @PutMapping("/{id}")
    public Mono<CouponDTO> updateCoupon(@PathVariable Long id, @RequestBody CouponDTO coupon) {
        return couponService.updateCoupon(id, coupon);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<MessageResponse>> deleteCoupon(@PathVariable Long id) {
        return couponService.deleteCoupon(id)
                .map(response -> {
                    if (response.getMessage().contains("no existe")) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                    }
                    return ResponseEntity.ok(response);
                });
    }

}
