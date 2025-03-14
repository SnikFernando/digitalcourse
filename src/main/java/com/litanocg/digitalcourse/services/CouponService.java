package com.litanocg.digitalcourse.services;

import com.litanocg.digitalcourse.entities.Coupon;
import com.litanocg.digitalcourse.entities.dtos.CouponDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.entities.mappers.CouponMapper;
import com.litanocg.digitalcourse.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    private final CouponMapper couponMapper = CouponMapper.INSTANCE;

    // Obtener todos los cupones
    public Flux<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    // Obtener un cupón por ID
    public Mono<CouponDTO> getCouponById(Long id) {
        return couponRepository.findById(id)
                .map(couponMapper::toDTO)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Cupón no encontrado")));
    }

    public Mono<CouponDTO> createCoupon(CouponDTO couponDTO) {
        return couponRepository.findByCouponCode(couponDTO.getCouponCode())
                .map(couponMapper::toDTO) // 🔹 Mapeamos la entidad a DTO
                .flatMap(existingCoupon -> Mono.<CouponDTO>error(new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "El código de cupón '" + couponDTO.getCouponCode() + "' ya existe."))) // 🔹 Especificamos el tipo
                .switchIfEmpty(Mono.defer(() -> {
                    Coupon coupon = couponMapper.toEntity(couponDTO);
                    return couponRepository.save(coupon).map(couponMapper::toDTO);
                }));
    }

    // Actualizar un cupón
    public Mono<CouponDTO> updateCoupon(Long id, CouponDTO couponDTO) {
        return couponRepository.findById(id)
                .flatMap(existingCoupon -> {
                    couponMapper.updateCouponFromDTO(couponDTO, existingCoupon);
                    existingCoupon.setUpdatedAt(LocalDateTime.now()); // Solo se actualiza `updatedAt`
                    return couponRepository.save(existingCoupon);
                })
                .map(couponMapper::toDTO)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Cupón no encontrado")));
    }

    // Eliminar un cupón
    public Mono<MessageResponse> deleteCoupon(Long id) {
        return couponRepository.findById(id)
                .flatMap(coupon ->
                        couponRepository.delete(coupon)
                                .thenReturn(new MessageResponse("El cupón fue eliminado correctamente"))
                )
                .switchIfEmpty(Mono.defer(() -> Mono.just(new MessageResponse("El cupón con ID " + id + " no existe"))));
    }
}
