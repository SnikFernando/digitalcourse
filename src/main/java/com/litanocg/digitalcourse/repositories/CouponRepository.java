package com.litanocg.digitalcourse.repositories;

import com.litanocg.digitalcourse.entities.Coupon;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CouponRepository extends R2dbcRepository<Coupon, Long> {
    Mono<Coupon> findByCouponCode(String couponCode);

}
